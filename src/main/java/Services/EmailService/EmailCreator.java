package Services.EmailService;

import javax.mail.internet.InternetAddress;
import java.io.File;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.Map;

public class EmailCreator {

    public void mandarEmail(InternetAddress[] destinatarios) throws Exception {

        // Message info
        String subject = "¡DDS CINEMA: NUEVOS ESTRENOS!";
        String html = this.pasarArchivoAString(new File("src/main/resources/codigo.html").getAbsolutePath());

        // Inline images
        Map<String, String> inlineImages = new HashMap<>();
        inlineImages.put("logo", new File("src/main/resources/images/logo.png").getAbsolutePath());
        inlineImages.put("twitter", new File("src/main/resources/images/twitter.png").getAbsolutePath());
        inlineImages.put("facebook", new File("src/main/resources/images/facebook.png").getAbsolutePath());
        inlineImages.put("black", new File("src/main/resources/images/black.jpg").getAbsolutePath());
        inlineImages.put("joker", new File("src/main/resources/images/joker.jpg").getAbsolutePath());
        inlineImages.put("rata", new File("src/main/resources/images/rata.jpg").getAbsolutePath());
        inlineImages.put("snatch", new File("src/main/resources/images/snatch.jpg").getAbsolutePath());

        try {
            EmailSender sender = new EmailSender();
            sender.send(subject, html, inlineImages, destinatarios);
            System.out.println("Email enviado con éxito.");
        } catch (Exception ex) {
            System.out.println("No se pudo enviar el email.");
            ex.printStackTrace();
        }
    }

    private static String pasarArchivoAString(String fileName)throws Exception {
        String data = "";
        data = new String(Files.readAllBytes(Paths.get(fileName)));
        return data;
    }
}
