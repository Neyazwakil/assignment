package org.example;

import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.util.Properties;

public class MailHandler {
   public static void sendmail(String signinEmail,String Subject,String Body){

        //this give a HashTable (key and its values)
        Properties properties=System.getProperties();
        System.out.print(properties);
        properties.put("mail.smtp.host",MailMetadata.hostserver);
        properties.put("mail.smtp.port",MailMetadata.port);
        properties.put (MailMetadata.sslproperty,"true");
        properties.put(MailMetadata.authpermisssion,"true");

        Authenticator mailauthentication= new CustomizedAuthentication();
        Session mailsession=null;

        mailsession=Session.getInstance(properties,mailauthentication);

        MimeMessage message=new MimeMessage(mailsession);
        //send sender data
        try {
            message.setFrom(MailMetadata.username);
            message.setSubject("testing maven project");
            message.setText(Sub.getsub());

            //set receiver data
            Address receiverEmail = new InternetAddress(MailMetadata.reveivermail);
            message.setRecipient(Message.RecipientType.TO, new InternetAddress(signinEmail));
            message.setSubject(Subject);
            message.setText(Body);

            Transport.send(message);
            System.out.println("Mail successfully sent");
        }
        catch (Exception mailexception){
            System.out.print(mailexception.toString());

        }
    }
}

