package org.example;

import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.util.Properties;

public class MailHandler {
   public void sendmail(){

        //this give a HashTable (key and its values)
        Properties properties=System.getProperties();
        //System.out.print(properties);
        properties.put("mail.smtp.host",MailMetadata.hostserver);
        properties.put("mail.smtp.port",MailMetadata.port);
        properties.put (MailMetadata.sslproperty,"true");
        properties.put(MailMetadata.authpermisssion,"true");

        Authenticator mailauthentication= new CustomizedAuthentication();
        Session mailsession=Session.getInstance(properties,mailauthentication);

        MimeMessage message=new MimeMessage(mailsession);
        //send sender data
        try {
            message.setFrom(MailMetadata.username);
            message.setSubject("testing maven projet");
            message.setText(Sub.getsub());

            //set receiver data
            Address reciverEmail = new InternetAddress(MailMetadata.reveivermail);
            message.setRecipient(Message.RecipientType.TO, new InternetAddress(MailMetadata.reveivermail));

            Transport.send(message);
        }
        catch (Exception mailexception){
            System.out.print(mailexception.toString());

        }
    }
}

