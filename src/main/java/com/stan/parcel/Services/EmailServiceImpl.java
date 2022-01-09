package com.stan.parcel.Services;

import com.stan.parcel.Percistance.Entities.Message;
import com.stan.parcel.Percistance.Model.ResponseModel;
import com.stan.parcel.ServiceImplementation.MailService;
import org.springframework.http.HttpStatus;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import javax.mail.MessagingException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.io.UnsupportedEncodingException;


@Service
public class EmailServiceImpl implements MailService {

     private final JavaMailSender mailSender;

    public EmailServiceImpl(JavaMailSender mailSender) {
        this.mailSender = mailSender;
    }


    public ResponseModel sendEmail(Message message) {
        MimeMessage mimeMessage = mailSender.createMimeMessage();
        ResponseModel responseModel=new ResponseModel();

        try {
            MimeMessageHelper mimeMessageHelper = new MimeMessageHelper(mimeMessage, true);

            mimeMessageHelper.setSubject(message.getSubject());
            mimeMessageHelper.setFrom(new InternetAddress(message.getMessageType(), "Stan"));
            mimeMessageHelper.setTo(message.getRecipient());
            mimeMessageHelper.setText(message.getMessage());

            mailSender.send(mimeMessageHelper.getMimeMessage());
              responseModel.setStatus(HttpStatus.OK);
              responseModel.setMessage("Email dispatched");
        } catch (MessagingException | UnsupportedEncodingException e) {
            responseModel.setStatus(HttpStatus.BAD_GATEWAY);
            return responseModel;
        }

        return responseModel;
    }
}

