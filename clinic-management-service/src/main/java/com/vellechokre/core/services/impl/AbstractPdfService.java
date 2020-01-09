package com.vellechokre.core.services.impl;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;

import javax.servlet.http.HttpServletResponse;

import org.apache.commons.io.IOUtils;

import com.vellechokre.core.services.PdfService;
import com.vellechokre.exceptions.MessageException;
import com.vellechokre.exceptions.PdfGenerationException;
import com.vellechokre.util.ApplicationConstant;
import com.vellechokre.util.DateUtil;

import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperPrint;

/**
 * Project clinic-management-service
 *
 * @author nishant.bhardwaz
 * @version 1.0
 * @date Jan 7, 2020
 */
public abstract class AbstractPdfService implements PdfService {

    /**
     * Generate pdf using jasper
     *
     * @param jasperPrint
     * @param response
     * @param displayName
     * @return
     * @throws MessageException
     * @throws PdfGenerationException
     */
    public HttpServletResponse generatePdfResponse(final JasperPrint jasperPrint,
                                                   final HttpServletResponse response,
                                                   final String displayName) throws PdfGenerationException {

        try {
            /* Write content to PDF file */
            final byte[] bytes = JasperExportManager.exportReportToPdf(jasperPrint);
            final ByteArrayOutputStream pdf = new ByteArrayOutputStream(bytes.length);
            pdf.write(bytes, 0, bytes.length);
            // Copy the stream to the response's output stream.
            response.addHeader(
                    ApplicationConstant.CONTENT_DISPOSITION,
                    ApplicationConstant.ATTACHEMENT_FILENAME + displayName
                                                             + ApplicationConstant.HYPHEN
                                                             + DateUtil.getCurrentString(
                                                                     ApplicationConstant.DATE_FORMAT)
                                                             + ".pdf");
            IOUtils.copy((new ByteArrayInputStream(pdf.toByteArray())), response.getOutputStream());
            response.flushBuffer();
            return response;
        } catch (IOException | JRException e) {
            throw new PdfGenerationException(e.getMessage(), e.getCause());
        }
    }

    /**
     * @param jasperPrint
     * @return
     * @throws MessageException
     * @throws PdfGenerationException
     */
    public ByteArrayOutputStream generatePdfResponse(final JasperPrint jasperPrint) throws PdfGenerationException {

        try {
            /* Write content to PDF file */
            final byte[] bytes = JasperExportManager.exportReportToPdf(jasperPrint);
            final ByteArrayOutputStream pdf = new ByteArrayOutputStream(bytes.length);
            pdf.write(bytes, 0, bytes.length);
            return pdf;
        } catch (final JRException e) {
            throw new PdfGenerationException(e.getMessage(), e.getCause());
        }
    }
}
