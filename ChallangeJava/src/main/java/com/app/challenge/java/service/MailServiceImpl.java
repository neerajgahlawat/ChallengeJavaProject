package com.app.challenge.java.service;

import java.util.HashMap;
import java.util.Map;

import javax.mail.Message;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.mail.MailException;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.mail.javamail.MimeMessagePreparator;
import org.springframework.stereotype.Service;
import org.springframework.ui.freemarker.FreeMarkerTemplateUtils;

import com.app.challenge.java.DTO.UserDTO;
import com.app.challenge.java.model.ResetPassTemplate;

import freemarker.template.Configuration;

@Service("mailService")
public class MailServiceImpl implements MailService {

	@Autowired
	JavaMailSender mailSender;
	
	 @Autowired
	 Configuration freemarkerConfiguration;

	public void sendEmail(Object object, String url) {

		UserDTO userDTO = (UserDTO) object;

		MimeMessagePreparator preparator = getMessagePreparator(userDTO, url);

		try {
			mailSender.send(preparator);
			System.out.println("Message Send...Hurrey");
		} catch (MailException ex) {
			System.err.println(ex.getMessage());
		}
	}

	private MimeMessagePreparator getMessagePreparator(final UserDTO userDTO , final String url) {
		
		MimeMessagePreparator preparator = new MimeMessagePreparator() {

			public void prepare(MimeMessage mimeMessage) throws Exception {
				MimeMessageHelper helper = new MimeMessageHelper(mimeMessage, true);
				
				helper.setSubject("Reset Password for future tech");
                helper.setFrom("challengejava@gmail.com");
                helper.setTo(userDTO.getEmail());
      
                ResetPassTemplate resetPassTemplate = new ResetPassTemplate();
				resetPassTemplate.setUrl(url);
				resetPassTemplate.setName(userDTO.getFirstName());
				Map<String, Object> model = new HashMap<String, Object>();
                model.put("reset", resetPassTemplate);
                 
                String text = geFreeMarkerTemplateContent(model);//Use Freemarker or Velocity
                System.out.println("Template content : "+text);
 
                // use the true flag to indicate you need a multipart message
                helper.setText(text, true);
 
                //Additionally, let's add a resource as an attachment as well.
                helper.addAttachment("cutie.png", new ClassPathResource("social-icons.png"));
				
				
				
				
				/*mimeMessage.setFrom("challengejava@gmail.com");
				mimeMessage.setRecipient(Message.RecipientType.TO, new InternetAddress(userDTO.getEmail()));
				mimeMessage.setText("Dear " + userDTO.getFirstName() + ", thank you. " + url);
				
				mimeMessage.setSubject("Reset Password future tech");
				
				ResetPassTemplate resetPassTemplate = new ResetPassTemplate();
				resetPassTemplate.setUrl(url);
				resetPassTemplate.setName(userDTO.getFirstName());
				Map<String, Object> model = new HashMap<String, Object>();
                model.put("reset", resetPassTemplate);
                 
                String text = geFreeMarkerTemplateContent(model);//Use Freemarker or Velocity
                System.out.println("Template content : "+text);
 
                // use the true flag to indicate you need a multipart message
                mimeMessage.setText(text, true);*/
			}
		};
		return preparator;
	}
	
	public String geFreeMarkerTemplateContent(Map<String, Object> model){
        StringBuffer content = new StringBuffer();
        try{
        freemarkerConfiguration.setClassForTemplateLoading(this.getClass(), "/fmtemplates/");
         content.append(FreeMarkerTemplateUtils.processTemplateIntoString( 
                 freemarkerConfiguration.getTemplate("resetPass.txt"),model));
         return content.toString();
        }catch(Exception e){
            System.out.println("Exception occured while processing fmtemplate:"+e.getMessage());
        }
          return "";
    }

}
