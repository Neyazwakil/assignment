package com.neyaz.Recipemanagement.Controller;

import com.neyaz.Recipemanagement.Model.AuthenticationToken;
import com.neyaz.Recipemanagement.Model.Comment;
import com.neyaz.Recipemanagement.Model.Recipe;
import com.neyaz.Recipemanagement.Model.User;
import com.neyaz.Recipemanagement.Model.dto.SignInInput;
import com.neyaz.Recipemanagement.Model.dto.SignUpOutput;
import com.neyaz.Recipemanagement.Service.AuthenticationService;
import com.neyaz.Recipemanagement.Service.CommentService;
import com.neyaz.Recipemanagement.Service.RecipeService;
import com.neyaz.Recipemanagement.Service.UserService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Validated
@RestController
public class UserController {
    @Autowired
    UserService userService;

    @Autowired
    AuthenticationService authenticationService;
    @Autowired
    RecipeService recipeService;
    @Autowired
    CommentService commentService;


    //sign up, sign in , sign out a particular instagram user
    @PostMapping("user/signup")
    public SignUpOutput signUpUser(@RequestBody User user)
    {

        return userService.signUpUser(user);
    }

    @PostMapping("user/signIn")
    public String sigInUser(@RequestBody @Valid SignInInput signInInput)
    {
        return userService.signInUser(signInInput);
    }

    @DeleteMapping("user/signOut")
    public String sigOutUser(String email, String token)
    {
        if(authenticationService.authenticate(email,token)) {
            return userService.sigOutUser(email);
        }
        else {
            return "Sign out not allowed for non authenticated user.";
        }

    }
    @GetMapping("user")
    public List<User> getAllUsers() {
        return userService.getAllUsers();
    }
    @GetMapping("user/{userId}")
    public ResponseEntity<User> getUserById(@PathVariable Long userId) {
        User user = userService.getUserById(userId);
        if (user != null) {
            return ResponseEntity.ok(user);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    //content on instagram

    @PostMapping("recipe")
    public String createInstaPost(@RequestBody Recipe recipe, @RequestParam String email, @RequestParam String token)
    {
        if(authenticationService.authenticate(email,token)) {
            return userService.createRecipe(recipe,email);
        }
        else {
            return "Not an Authenticated user activity!!!";
        }
    }
    @GetMapping("recipe")
    public ResponseEntity<List<Recipe>> getAllRecipes() {
        List<Recipe> recipes = recipeService.getAllRecipes();
        return ResponseEntity.ok(recipes);
    }

    @GetMapping("recipeById/{id}")
    public ResponseEntity<Recipe> getRecipeById(@PathVariable Long id) {
        Recipe recipe = recipeService.getRecipeById(id);
        if (recipe == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(recipe);
    }
    ///

    @PutMapping("recipe/{recipeId}")
    public String updateRecipe(@PathVariable Long recipeId, @RequestBody Recipe updatedRecipe, @RequestParam String email, @RequestParam String token) {
        if (authenticationService.authenticate(email, token)) {
            return userService.updateRecipe(recipeId, updatedRecipe, email);
        } else {
            throw new RuntimeException("Not an Authenticated user activity!!!");
        }
    }




    // ... other methods ...

    @PostMapping("comment")
    public String addComment(@RequestBody Comment comment, @RequestParam String commenterEmail, @RequestParam String commenterToken)
    {
        if(authenticationService.authenticate(commenterEmail,commenterToken)) {
            return userService.addComment(comment,commenterEmail);
        }
        else {
            return "Not an Authenticated user activity!!!";
        }

    }


    @DeleteMapping("comment")
    public String removeComment(@RequestParam Long commentId, @RequestParam String email, @RequestParam String token)
    {
        if(authenticationService.authenticate(email,token)) {
            return userService.removeComment(commentId,email);
        }
        else {
            return "Not an Authenticated user activity!!!";
        }
    }






}
