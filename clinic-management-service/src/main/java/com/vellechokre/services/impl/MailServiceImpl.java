package com.vellechokre.services.impl;

import java.util.HashMap;
import java.util.Map;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

import org.apache.velocity.app.VelocityEngine;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;
import org.springframework.ui.velocity.VelocityEngineUtils;

import com.vellechokre.bo.Mail;
import com.vellechokre.entity.PatientDetail;
import com.vellechokre.services.MailService;

/**
 * Project clinic-management-service
 *
 * @author nishant.bhardwaz
 * @version 1.0
 * @date Sep 2, 2019
 */
@Service("mailService")
public class MailServiceImpl implements MailService {

    @Autowired
    JavaMailSender mailSender;

    @Autowired
    VelocityEngine velocityEngine;

    @Override
    public void sendWelcomeEmail(final Mail mail) {

        final MimeMessage mimeMessage = mailSender.createMimeMessage();
        try {
            final MimeMessageHelper mimeMessageHelper = new MimeMessageHelper(mimeMessage, true);
            mimeMessageHelper.setSubject("Dev Dental Welcomes you !!");
            mimeMessageHelper.setFrom(mail.getMailFrom());
            mimeMessageHelper.setTo(mail.getMailTo());
            mail.setMailContent(geContentFromTemplateForWelcome(mail.getModel()));
            mimeMessageHelper.setText(mail.getMailContent(), true);
            mailSender.send(mimeMessageHelper.getMimeMessage());
        } catch (final MessagingException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void sendAddressEmail(final Mail mail) {

        final MimeMessage mimeMessage = mailSender.createMimeMessage();
        try {
            final MimeMessageHelper mimeMessageHelper = new MimeMessageHelper(mimeMessage, true);
            mimeMessageHelper.setSubject("DevDental Clinic Address!!");
            mimeMessageHelper.setFrom(mail.getMailFrom());
            mimeMessageHelper.setTo(mail.getMailTo());
            mail.setMailContent(geContentFromTemplateForAddress(mail.getModel()));
            mimeMessageHelper.setText(mail.getMailContent(), true);
            mailSender.send(mimeMessageHelper.getMimeMessage());
        } catch (final MessagingException e) {
            e.printStackTrace();
        }
    }

    public String geContentFromTemplateForAddress(final Map<String, Object> model) {

        final StringBuffer content = new StringBuffer();
        try {
            content.append(VelocityEngineUtils.mergeTemplateIntoString(velocityEngine,
                    "/templates/email-address-template.vm", model));
        } catch (final Exception e) {
            e.printStackTrace();
        }
        return content.toString();
    }

    public String geContentFromTemplateForWelcome(final Map<String, Object> model) {

        final StringBuffer content = new StringBuffer();
        try {
            content.append(VelocityEngineUtils.mergeTemplateIntoString(velocityEngine,
                    "/templates/email-welcome-template.vm", model));
        } catch (final Exception e) {
            e.printStackTrace();
        }
        return content.toString();
    }

    @Override
    public Mail composeMail(final PatientDetail patientDetail) {

        final Mail mail = new Mail();
        mail.setMailFrom("devdentalclinic@yahoo.com");
        mail.setMailTo(patientDetail.getEmailId());
        final Map<String, Object> model = new HashMap<String, Object>();
        model.put("firstName", patientDetail.getFirstname());
        model.put("lastName", patientDetail.getLastname());
        model.put("location", "Adhmedabad");
        model.put("signature", "Sig test");
        mail.setModel(model);
        return mail;
    }
}
