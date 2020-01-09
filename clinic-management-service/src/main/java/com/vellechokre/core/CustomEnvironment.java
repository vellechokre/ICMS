package com.vellechokre.core;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

/**
 * Project clinic-management-service
 *
 * @author nishant.bhardwaz
 * @version 1.0
 * @date Jan 7, 2020
 */
@Configuration
@ConfigurationProperties(prefix = "chokre")
public class CustomEnvironment {

    private PdfTemplate pdfTemplate;

    /**
     * @return the pdfTemplate
     */
    public PdfTemplate getPdfTemplate() {

        return pdfTemplate;
    }

    /**
     * @param pdfTemplate the pdfTemplate to set
     */
    public void setPdfTemplate(PdfTemplate pdfTemplate) {

        this.pdfTemplate = pdfTemplate;
    }

    /**
     * to get the file path of invoice template<br>
     * Project clinic-management-service
     *
     * @author nishant.bhardwaz
     * @version 1.0
     * @date Jan 7, 2020
     */
    public static class PdfTemplate {

        private String invoiceWithDetails;

        private String invoiceWithoutDetials;

        private String invoiceWithoutLetterHeadWithoutDetails;

        private String invoiceWithoutLetterHeadWithDetails;

        private String paymentProcedure;

        private String creditNote;

        private String creditNoteWithoutHeader;

        public String getInvoiceWithDetails() {

            return invoiceWithDetails;
        }

        public void setInvoiceWithDetails(final String invoiceWithDetails) {

            this.invoiceWithDetails = invoiceWithDetails;
        }

        public String getInvoiceWithoutDetials() {

            return invoiceWithoutDetials;
        }

        public void setInvoiceWithoutDetials(final String invoiceWithoutDetials) {

            this.invoiceWithoutDetials = invoiceWithoutDetials;
        }

        public String getInvoiceWithoutLetterHeadWithoutDetails() {

            return invoiceWithoutLetterHeadWithoutDetails;
        }

        public void setInvoiceWithoutLetterHeadWithoutDetails(final String invoiceWithoutLetterHeadWithoutDetails) {

            this.invoiceWithoutLetterHeadWithoutDetails = invoiceWithoutLetterHeadWithoutDetails;
        }

        public String getInvoiceWithoutLetterHeadWithDetails() {

            return invoiceWithoutLetterHeadWithDetails;
        }

        public void setInvoiceWithoutLetterHeadWithDetails(final String invoiceWithoutLetterHeadWithDetails) {

            this.invoiceWithoutLetterHeadWithDetails = invoiceWithoutLetterHeadWithDetails;
        }

        public String getPaymentProcedure() {

            return paymentProcedure;
        }

        public void setPaymentProcedure(final String paymentProcedure) {

            this.paymentProcedure = paymentProcedure;
        }

        public String getCreditNote() {

            return creditNote;
        }

        public void setCreditNote(final String creditNote) {

            this.creditNote = creditNote;
        }

        public String getCreditNoteWithoutHeader() {

            return creditNoteWithoutHeader;
        }

        public void setCreditNoteWithoutHeader(final String creditNoteWithoutHeader) {

            this.creditNoteWithoutHeader = creditNoteWithoutHeader;
        }
    }
}
