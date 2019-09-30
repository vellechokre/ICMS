package com.vellechokre.services;

import com.vellechokre.bo.Mail;
import com.vellechokre.entity.PatientDetail;

/**
 * Project clinic-management-service
 * 
 * @author nishant.bhardwaz
 * @version 1.0
 * @date Sep 2, 2019
 */
public interface MailService {

    /**
     * @param mail
     */
    public void sendWelcomeEmail(Mail mail);

    /**
     * @param mail
     */
    public void sendAddressEmail(Mail mail);

    public Mail composeMail(final PatientDetail patientDetail);
}
