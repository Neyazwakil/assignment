package org.example;

import javax.mail.Authenticator;
import javax.mail.PasswordAuthentication;

public class CustomizedAuthentication extends Authenticator {
    protected PasswordAuthentication getPasswordAuthentication(){
        return new PasswordAuthentication(MailMetadata.username,MailMetadata.password);

    }


}
