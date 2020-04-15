import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class CreateMail {
	public static void SentMail(String ToMailId, int card, int pin)
	{
		Properties p = new Properties();
		p.put("mail.smtp.auth", "true");
		p.put("mail.smtp.starttls.enable", "true");
		p.put("mail.smtp.host", "smtp.gmail.com");
		p.put("mail.smtp.port", "587");
		
		String MyEmailId = "ritendubhattacharyya@gmail.com";
		String password = "sonurits14111998";
		
		Session session = Session.getInstance(p, new javax.mail.Authenticator() {

			@Override
			protected javax.mail.PasswordAuthentication getPasswordAuthentication() {
				return new javax.mail.PasswordAuthentication(MyEmailId, password);
			}
			
		});
		Message m = new MimeMessage(session);
		try {
			m.setFrom(new InternetAddress(MyEmailId));
			m.addRecipient(Message.RecipientType.TO,new InternetAddress(ToMailId));
			m.setSubject("Your Card Nunber and Pin Number");
			m.setText("Card Number = " + card + "& Pin Number = " + pin);
			
			Transport.send(m);
			 } catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}
