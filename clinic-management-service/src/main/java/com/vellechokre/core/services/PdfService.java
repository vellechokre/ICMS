package com.vellechokre.core.services;

import java.io.ByteArrayOutputStream;
import java.text.ParseException;

import com.vellechokre.exceptions.MessageException;
import com.vellechokre.exceptions.PdfGenerationException;
import com.vellechokre.exceptions.ValidationException;

/**
 * Project clinic-management-service
 *
 * @author nishant.bhardwaz
 * @version 1.0
 * @date Jan 7, 2020
 */
public interface PdfService {

    /**
     * @param actionEvent
     * @param id
     * @param type
     * @param response
     * @return
     * @throws ValidationException
     * @throws ParseException
     * @throws MessageException
     * @throws PdfGenerationException
     */
    ByteArrayOutputStream generatePdfReport(String actionEvent, Object object,
                                            Object type) throws ValidationException, ParseException,
                                                         PdfGenerationException;
}
