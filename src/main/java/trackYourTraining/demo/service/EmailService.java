package trackYourTraining.demo.service;


import jakarta.mail.MessagingException;
import jakarta.mail.internet.MimeMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import org.thymeleaf.context.Context;
import trackYourTraining.demo.Dto.TrainingDto;
import org.thymeleaf.TemplateEngine;


import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.Objects;


@Service
public class EmailService {

    @Value("${spring.mail.username}")
    private String from;

    @Autowired
    private JavaMailSender javaMailSender;


    private final TemplateEngine templateEngine;

    public EmailService(JavaMailSender mailSender,TemplateEngine templateEngine ) {
        this.templateEngine=templateEngine;
        this.javaMailSender = mailSender;
    }

    public void sendMailWithThymleaf(String to, String subject, TrainingDto.TrainingAddrequest model) throws MessagingException, IOException {
        model.setDatum(changeDate(model));
        Context context = new Context();
        context.setVariable("training", model);
        String process = templateEngine.process("htmlEmail.html", context);

        MimeMessage mimeMessage = javaMailSender.createMimeMessage();
        MimeMessageHelper helper = new MimeMessageHelper(mimeMessage);
        helper.setSubject(subject);
        helper.setText(process, true);
        helper.setTo(to);
        helper.setFrom(from);
        javaMailSender.send(mimeMessage);
    }

    public String changeDate(TrainingDto.TrainingAddrequest request){
        String date = request.getDatum();
        String[] splitDate = date.split("-");

        return (splitDate[2]+"-"+splitDate[1]+"-"+splitDate[0]);
    }





}
