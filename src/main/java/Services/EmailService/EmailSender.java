package Services.EmailService;

import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Date;
import java.util.Map;
import java.util.Properties;
import java.util.Set;

/*
Esta clase es la encargada de toda la lógica interna que implica mandar un mail.
No debería tener contacto con ninguna otra salvo la que la invoca
 */

public class EmailSender {

    public static void send(String subject, String htmlBody, Map<String, String> mapInlineImages, InternetAddress[] toAddresses) throws MessagingException, IOException {

        Properties prop = new Properties();
        InputStream input = new FileInputStream("src/main/java/Services/EmailService/Mail.prop");
        prop.load(input);

        String username = prop.getProperty("username");
        String password = prop.getProperty("password");

        // Set de propiedades SMTP. Venían parametrizadas pero no es necesario
        Properties properties = new Properties();
        properties.put("mail.smtp.host", "smtp.gmail.com");
        properties.put("mail.smtp.port", "587");
        properties.put("mail.smtp.auth", "true");
        properties.put("mail.smtp.starttls.enable", "true");
        properties.put("mail.user", "DDS CINEMA");
        properties.put("mail.password", password);

        // Autenticamos nuestro mail
        Authenticator auth = new Authenticator() {
            public PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(username, password);
            }
        };
        Session session = Session.getInstance(properties, auth);

        // Creamos un nuevo mensaje de Email
        Message msg = new MimeMessage(session);

        // La idea es que a todos se les mande el mismo mensaje en principio
        msg.setFrom(new InternetAddress(username));
        msg.setRecipients(Message.RecipientType.BCC, toAddresses);
        msg.setSubject(subject);
        msg.setSentDate(new Date());

        // Creamos el elemento multi-part. Nos permite tener codigo HTML e imagenes
        Multipart multipart = new MimeMultipart();

        // Agregamos el HTML del mensaje
        MimeBodyPart messageBodyPart = new MimeBodyPart();
        messageBodyPart.setContent(htmlBody, "text/html");
        multipart.addBodyPart(messageBodyPart);

        // Agregamos las imagenes
        if (mapInlineImages != null && mapInlineImages.size() > 0) {
            Set<String> setImageID = mapInlineImages.keySet();

            for (String contentId : setImageID) {
                MimeBodyPart imagePart = new MimeBodyPart();
                imagePart.setHeader("Content-ID", "<" + contentId + ">");
                imagePart.setDisposition(MimeBodyPart.INLINE);

                String imageFilePath = mapInlineImages.get(contentId);
                try {
                    imagePart.attachFile(imageFilePath);
                } catch (IOException ex) {
                    ex.printStackTrace();
                }
                multipart.addBodyPart(imagePart);
            }
        }

        /*
        Ponemos el MultiPart que tiene HTML e imagenes en el msg que es el que
        tiene datos de conexion, etc.
        */
        msg.setContent(multipart);
        Transport.send(msg);
    }
}