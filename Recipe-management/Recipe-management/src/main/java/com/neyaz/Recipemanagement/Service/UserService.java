package com.neyaz.Recipemanagement.Service;

import com.neyaz.Recipemanagement.Model.AuthenticationToken;
import com.neyaz.Recipemanagement.Model.Comment;
import com.neyaz.Recipemanagement.Model.Recipe;
import com.neyaz.Recipemanagement.Model.User;
import com.neyaz.Recipemanagement.Model.dto.SignInInput;
import com.neyaz.Recipemanagement.Model.dto.SignUpOutput;
import com.neyaz.Recipemanagement.Repository.UserRepo;
import com.neyaz.Recipemanagement.Service.emailUtility.EmailHandler;
import com.neyaz.Recipemanagement.Service.hashingUtility.PasswordEncrypter;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Data
@Service
public class UserService {


    @Autowired
    UserRepo userRepo;

    @Autowired
    AuthenticationService authenticationService;
    @Autowired
    CommentService commentService;
    @Autowired
    RecipeService recipeService;

    public SignUpOutput signUpUser(User user) {

        boolean signUpStatus = true;
        String signUpStatusMessage = null;

        String newEmail = user.getUserEmail();

        if (newEmail == null) {
            signUpStatusMessage = "Invalid email";
            signUpStatus = false;
            return new SignUpOutput(signUpStatus, signUpStatusMessage);
        }

        //check if this user email already exists ??
        User existingUser = userRepo.findFirstByUserEmail(newEmail);

        if (existingUser != null) {
            signUpStatusMessage = "Email already registered!!!";
            signUpStatus = false;
            return new SignUpOutput(signUpStatus, signUpStatusMessage);
        }

        //hash the password: encrypt the password
        try {
            String encryptedPassword = PasswordEncrypter.encryptPassword(user.getUserPassword());

            //saveAppointment the user with the new encrypted password

            user.setUserPassword(encryptedPassword);
            userRepo.save(user);

            return new SignUpOutput(signUpStatus, "User registered successfully!!!");
        } catch (Exception e) {
            signUpStatusMessage = "Internal error occurred during sign up";
            signUpStatus = false;
            return new SignUpOutput(signUpStatus, signUpStatusMessage);
        }
    }


    public String signInUser(SignInInput signInInput) {


        String signInStatusMessage = null;

        String signInEmail = signInInput.getEmail();

        if (signInEmail == null) {
            signInStatusMessage = "Invalid email";
            return signInStatusMessage;


        }

        //check if this user email already exists ??
        User existingUser = userRepo.findFirstByUserEmail(signInEmail);

        if (existingUser == null) {
            signInStatusMessage = "Email not registered!!!";
            return signInStatusMessage;

        }

        //match passwords :

        //hash the password: encrypt the password
        try {
            String encryptedPassword = PasswordEncrypter.encryptPassword(signInInput.getPassword());
            if (existingUser.getUserPassword().equals(encryptedPassword)) {
                //session should be created since password matched and user id is valid
                AuthenticationToken authToken = new AuthenticationToken(existingUser);
                authenticationService.saveAuthToken(authToken);

                EmailHandler.sendEmail("neyazwakil8271@gmail.com", "email testing", authToken.getTokenValue());
                return "Token sent to your email";
            } else {
                signInStatusMessage = "Invalid credentials!!!";
                return signInStatusMessage;
            }
        } catch (Exception e) {
            signInStatusMessage = "Internal error occurred during sign in";
            return signInStatusMessage;
        }

    }

    public String sigOutUser(String email) {

        User user = userRepo.findFirstByUserEmail(email);
        AuthenticationToken token = authenticationService.findFirstByUser(user);
        authenticationService.removeToken(token);
        return "User Signed out successfully";
    }

    public String createRecipe(Recipe recipe, String email) {

        User postOwner = userRepo.findFirstByUserEmail(email);
        recipe.setPostOwner(postOwner);
        return recipeService.createRecipe(recipe);
    }

    public String removeRecipe(Long recipeId, String email) {

        User user = userRepo.findFirstByUserEmail(email);
        return recipeService.removeRecipe(recipeId, user);
    }

    public String addComment(Comment comment, String commenterEmail) {

        boolean postValid = recipeService.validateRecipe(comment.getRecipeComment());
        if (postValid) {
            User commenter = userRepo.findFirstByUserEmail(commenterEmail);
            comment.setCommenter(commenter);
            return commentService.addComment(comment);
        } else {
            return "Cannot comment on Invalid Post!!";
        }
    }

    boolean authorizeCommentRemover(String email, Comment comment) {
        String commentOwnerEmail = comment.getCommenter().getUserEmail();
        String postOwnerEmail = comment.getRecipeComment().getPostOwner().getUserEmail();

        return postOwnerEmail.equals(email) || commentOwnerEmail.equals(email);
    }

    public String removeComment(Long commentId, String email) {
        Comment comment = commentService.findComment(commentId);
        if (comment != null) {
            if (authorizeCommentRemover(email, comment)) {
                commentService.removeComment(comment);
                return "comment deleted successfully";
            } else {
                return "Unauthorized delete detected...Not allowed!!!!";
            }

        } else {
            return "Invalid Comment";
        }

    }

    ///\
    public String updateRecipe(Long recipeId, Recipe updatedRecipe, String email) {

        User user = userRepo.findFirstByUserEmail(email);
        Recipe recipe = recipeService.getRecipeById(recipeId);

        if (recipe != null && recipe.getPostOwner().equals(user)) {

            recipe.setRecipeId(updatedRecipe.getRecipeId());
            recipe.setRecipeName(updatedRecipe.getRecipeName());
            recipe.setIngredients(updatedRecipe.getIngredients());
            recipe.setInstruction(updatedRecipe.getInstruction());

            recipeService.createRecipe(recipe);

            return "Post updated successfully!";
        } else {

            throw new RuntimeException("You are not authorized to update this post!");
        }

    }
    public List<User> getAllUsers() {
        return userRepo.findAll();
    }

    public User getUserById(Long userId) {
        return userRepo.findById(userId).orElse(null);
    }
}
