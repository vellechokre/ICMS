// package com.vellechokre.core.services.impl;
//
// import java.io.ByteArrayOutputStream;
// import java.text.ParseException;
// import java.util.ArrayList;
// import java.util.Date;
// import java.util.HashMap;
// import java.util.List;
// import java.util.Map;
// import java.util.Map.Entry;
//
// import org.jfree.ui.about.SystemPropertiesTableModel.SystemProperty;
// import org.slf4j.Logger;
// import org.slf4j.LoggerFactory;
// import org.springframework.beans.factory.annotation.Autowired;
// import org.springframework.stereotype.Service;
// import org.springframework.util.Assert;
// import org.springframework.util.CollectionUtils;
// import org.springframework.util.ObjectUtils;
// import org.springframework.util.StringUtils;
//
// import com.vellechokre.config.ApplicationContext;
// import com.vellechokre.core.CustomEnvironment;
// import com.vellechokre.core.CustomLogger;
// import com.vellechokre.core.constants.LoggerType;
// import com.vellechokre.core.constants.PrescriptionType;
// import com.vellechokre.exceptions.PdfGenerationException;
// import com.vellechokre.exceptions.ValidationException;
// import com.vellechokre.util.ApplicationConstant;
//
// import net.sf.jasperreports.engine.JREmptyDataSource;
// import net.sf.jasperreports.engine.JRException;
// import net.sf.jasperreports.engine.JasperFillManager;
// import net.sf.jasperreports.engine.JasperPrint;
// import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
//
/// **
// * Project sib-service
// *
// * @author homeshc
// * @version 1.0
// * @date 07-Sep-2018
// */
// @Service("invoicePdfServiceImpl")
// public class InvoicePdfServiceImpl extends AbstractPdfService {
//
// private static final Logger logger = LoggerFactory.getLogger(InvoicePdfServiceImpl.class);
//
// @Autowired
// private CustomEnvironment customEnv;
//
// @Autowired
// private CommonService commonService;
//
// @Autowired
// private SystemPropertyRepo systemRepo;
//
// @Override
// public ByteArrayOutputStream generatePdfReport(final String actionEvent, final Object object,
// final Object type) throws ValidationException,
// ParseException,
// PdfGenerationException {
//
// Assert.hasLength(actionEvent, "Action Event can't be null!");
// switch (actionEvent) {
// case ApplicationConstant.WITH_DETAIL:
// return generatePdfReport(object, type);
// // case ApplicationConstant.WITHOUT_DETAIL:
// // return generatePdfReportWithoutDetail(object, type);
// // case ApplicationConstant.WITH_DETAIL_WITHOUT_LETTER_HEAD:
// // return generatePdfReportWithoutHeader(object, type);
// // case ApplicationConstant.WITHOUT_DETAIL_WITHOUT__LETTER_HEAD:
// // return generatePdfReportWithOutDetailWithoutHeader(object, type);
// // case ApplicationConstant.CREDIT_NOTE_PDF_LETTER_HEAD:
// // return generatePdfReportForCNWithLetterHead(object, type);
// // case ApplicationConstant.CREDIT_NOTE_PDF_WITHOUT_LETTER_HEAD:
// // return generatePdfReportForCNWithOutLetterHead(object, type);
// default:
// // CustomLogger.doLog("Action Event not defined", TenantContext.getId(),
// // LoggerType.INFO, logger);
// return null;
// }
// }
//
// /**
// * Generate Invoice Pdf With Letter Head and With Detail <br>
// * https://www.youtube.com/watch?v=AfC6MlWrXqY&t=131s
// *
// * @param response
// * @param invoiceId
// * @return
// * @throws ValidationException
// * @throws ParseException
// * @throws PdfGenerationException
// */
// private ByteArrayOutputStream generatePdfReport(final Object object,
// final Object type) throws ValidationException,
// ParseException,
// PdfGenerationException {
//
// validateObject(object, type);
// final Invoice invoice = (Invoice) object;
// final PrescriptionType invoiceType = (PrescriptionType) type;
// CustomLogger.doLog("Generating pdf for invoice {} and type {}!", ApplicationContext.getId(),
// LoggerType.INFO, logger, new Object[] {invoice.getId(), type});
// try {
// final Map<String, Object> parameters = new HashMap<>();
// buildJasperParameterForWithDetail(invoice, parameters, invoiceType);
// /* Using compiled version(.jasper) of Jasper report to generate PDF */
// /*
// * "C:/Users/homeshc/JaspersoftWorkspace/MyReports/invoiceWithDetailWithoutHeader.jasper"
// */
// final JasperPrint jasperPrint =
// JasperFillManager.fillReport(customEnv.getPdfTemplate().getInvoiceWithDetails(),
// parameters, new JREmptyDataSource());
// // get pdf
// return generatePdfResponse(jasperPrint);
// } catch (final JRException e) {
// throw new PdfGenerationException(e.getMessage(), e.getCause());
// }
// }
//
// /**
// * Generate Invoice Pdf without Letter Head with Detail
// *
// * @param invoiceId
// * @param type
// * @param response
// * @return
// * @throws ValidationException
// * @throws ParseException
// * @throws PdfGenerationException
// */
// private ByteArrayOutputStream generatePdfReportWithoutHeader(final Object object,
// final Object type) throws ValidationException,
// ParseException,
// PdfGenerationException {
//
// validateObject(object, type);
// final Invoice invoice = (Invoice) object;
// final PrescriptionType invoiceType = (PrescriptionType) type;
// CustomLogger.doLog("Generating pdf for invoice {} and type {}.", TenantContext.getId(),
// LoggerType.INFO, logger, new Object[] {invoice.getId(), type});
// try {
// final Map<String, Object> parameters = new HashMap<>();
// buildJasperParameterForWithDetail(invoice, parameters, invoiceType);
// /* Using compiled version(.jasper) of Jasper report to generate PDF */
// final JasperPrint jasperPrint = JasperFillManager.fillReport(
// customEnv.getPdfTemplate().getInvoiceWithoutLetterHeadWithDetails(), parameters,
// new JREmptyDataSource());
// // get pdf
// return generatePdfResponse(jasperPrint);
// } catch (final JRException e) {
// throw new PdfGenerationException(e.getMessage(), e.getCause());
// }
// }
//
// /**
// * Generate Invoice Pdf Without Detail Without Letter Head
// *
// * @param invoiceId
// * @param type
// * @param response
// * @return
// * @throws ValidationException
// * @throws ParseException
// * @throws PdfGenerationException
// */
// private ByteArrayOutputStream generatePdfReportWithOutDetailWithoutHeader(final Object object,
// final Object type) throws ValidationException,
// ParseException,
// PdfGenerationException {
//
// validateObject(object, type);
// final Invoice invoice = (Invoice) object;
// final PrescriptionType invoiceType = (PrescriptionType) type;
// CustomLogger.doLog("Generating pdf for invoice {} and type {} !", TenantContext.getId(),
// LoggerType.INFO, logger, new Object[] {invoice.getId(), type});
// try {
// final Map<String, Object> parameters = new HashMap<>();
// buildJasperParameterForWithOutDetail(invoice, parameters, invoiceType);
// /* Using compiled version(.jasper) of Jasper report to generate PDF */
// final JasperPrint jasperPrint = JasperFillManager.fillReport(
// customEnv.getPdfTemplate().getInvoiceWithoutLetterHeadWithoutDetails(),
// parameters, new JREmptyDataSource());
// // get pdf
// return generatePdfResponse(jasperPrint);
// } catch (final JRException e) {
// throw new PdfGenerationException(e.getMessage(), e.getCause());
// }
// }
//
// /**
// * Generate Invoice Pdf without Detail With Letter Head
// *
// * @param invoiceId
// * @param type
// * @param response
// * @return
// * @throws ValidationException
// * @throws ParseException
// * @throws PdfGenerationException
// */
// private ByteArrayOutputStream generatePdfReportWithoutDetail(final Object object,
// final Object type) throws ValidationException,
// ParseException,
// PdfGenerationException {
//
// validateObject(object, type);
// final Invoice invoice = (Invoice) object;
// final PrescriptionType invoiceType = (PrescriptionType) type;
// CustomLogger.doLog("Generating pdf for invoice {} and type {}!", TenantContext.getId(),
// LoggerType.INFO, logger, new Object[] {invoice.getId(), type});
// try {
// final Map<String, Object> parameters = new HashMap<>();
// buildJasperParameterForWithOutDetail(invoice, parameters, invoiceType);
// /* Using compiled version(.jasper) of Jasper report to generate PDF */
// final JasperPrint jasperPrint = JasperFillManager.fillReport(
// customEnv.getPdfTemplate().getInvoiceWithoutDetials(), parameters,
// new JREmptyDataSource());
// // get pdf
// return generatePdfResponse(jasperPrint);
// } catch (final JRException e) {
// throw new PdfGenerationException(e.getMessage(), e.getCause());
// }
// }
//
// /**
// * Check weather object is type of invoice or not and also check that type must be InvoiceType
// *
// * @param object
// * @param type
// * @throws ValidationException
// */
// private void validateObject(final Object object, final Object type) throws ValidationException {
//
// if (!(object instanceof Invoice)) {
// throw new ValidationException("Object must be instance of Invoice");
// }
// if (!(type instanceof PrescriptionType)) {
// throw new ValidationException("Object must be instance of InvoiceType");
// }
// }
//
// /**
// * Build Jasper Parameters for Invoice with detail
// *
// * @param invoice
// * @param parameters
// * @throws ValidationException
// * @throws ParseException
// */
// private void buildJasperParameterForWithDetail(final Invoice invoice,
// final Map<String, Object> parameters,
// final PrescriptionType type) throws ValidationException,
// ParseException {
//
// // CustomLogger.doLog("Build jasper parameters for invoice with details for invoice {} ",
// // ApplicationContext.getId(), LoggerType.INFO, logger, new Object[] {invoice.getId()});
// final Tenant tenant = commonService.findTenant();
// final List<InvoicePdfItems> items = new ArrayList<>();
// if (invoice.getTotalAmount() == 0) {
// buildDescForZeroAmount(items);
// } else {
// // build rent items
// int count = buildRentItems(invoice, items);
// // build print items
// count = buildPrintItems(invoice, items, count);
// // build mounting items
// buildMountingItems(invoice, items, count);
// }
// /* Convert List to JRBeanCollectionDataSource */
// final JRBeanCollectionDataSource itemsJRBean = new JRBeanCollectionDataSource(items);
// parameters.put(ApplicationConstant.RENT_ITEMS, itemsJRBean);
// // build address and customer name
// buildAddress(invoice, parameters);
// // build vendor pan detail, gst detail, state, place of supply , state code
// buildCustomerGSTDetails(invoice.getInvoiceGstDetail(), invoice.getCampaign(),
// invoice.getInvoiceId(), invoice.getPlaceOfSupply(), parameters);
// /*
// * build invoice details i.e invoice date, invoice number, bill gen date, bill end date, display
// * name
// */
// buildInvoiceDetails(invoice, parameters);
// // build gst details which gst is applicable and its amount
// buildGSTDetail(invoice, invoice.getInvoiceGstDetail(), parameters,
// invoice.getBillGeneratedDate(), tenant);
// // build amount details
// buildAmountDetail(invoice, parameters);
// // build PO details
// buildPODetail(invoice, parameters);
// // invoice type
// parameters.put(ApplicationConstant.INVOICE_TYPE, type.getValue());
// // build signature details
// buildSignatureDetail(parameters, tenant, ApplicationConstant.SET_SIGNATURE);
// // invoice notes
// parameters.put("notes", invoice.getNote());
// // set header and footer
// setHeaderAndFooter(parameters, tenant);
// }
//
// /**
// * Build desc if total amount of invoice is zero
// *
// * @param invoice
// * @param items
// */
// private void buildDescForZeroAmount(final List<InvoicePdfItems> items) {
//
// final InvoicePdfItems item = new InvoicePdfItems();
// item.setSrNo(1);
// final StringBuilder desc = new StringBuilder();
// desc.append(ApplicationConstant.FREE_OF_COST);
// item.setDescription(desc.toString());
// item.setStartDate("");
// item.setEndDate("");
// item.setDays("");
// item.setRate("");
// item.setCost("" + 0);
// items.add(item);
// }
//
// /**
// * @param parameters
// * @param tenant
// */
// private void buildSignatureDetail(final Map<String, Object> parameters, final Tenant tenant,
// final String key) {
//
// final SystemProperty property = systemRepo.findByKeyAndModule(key, SibModule.BILLING);
// if ((boolean) property.getValue()) {
// parameters.put("signatureUrl", tenant.getSignature().getUrl());
// }
// // parameters.put("setSignature", (boolean) property.getValue());
// }
//
// /**
// * Build Jasper Parameters for Invoice Without Detail
// *
// * @param invoice
// * @param parameters
// * @throws ValidationException
// * @throws ParseException
// */
// private void buildJasperParameterForWithOutDetail(final Invoice invoice,
// final Map<String, Object> parameters,
// final PrescriptionType type) throws ValidationException,
// ParseException {
//
// CustomLogger.doLog("Building Jasper Parameters for invoice without detail for invoice {} ",
// TenantContext.getId(), LoggerType.INFO, logger, new Object[] {invoice.getId()});
// final Tenant tenant = commonService.findTenant();
// // build address and customer name
// buildAddress(invoice, parameters);
// // build vendor pan detail, gst detail, state, place of supply , state code
// buildCustomerGSTDetails(invoice.getInvoiceGstDetail(), invoice.getCampaign(),
// invoice.getInvoiceId(), invoice.getPlaceOfSupply(), parameters);
// /*
// * build invoice details i.e invoice date, invoice number, bill gen date, bill end date, display
// * name
// */
// buildInvoiceDetails(invoice, parameters);
// // build gst details which gst is applicable and its amount
// buildGSTDetail(invoice, invoice.getInvoiceGstDetail(), parameters,
// invoice.getBillGeneratedDate(), tenant);
// // build amount details
// buildAmountDetail(invoice, parameters);
// // build PO details
// buildPODetail(invoice, parameters);
// // invoice type
// parameters.put(ApplicationConstant.INVOICE_TYPE, type.getValue());
// // build signature details
// buildSignatureDetail(parameters, tenant, ApplicationConstant.SET_SIGNATURE);
// // invoice notes
// parameters.put("notes", invoice.getNote());
// // set header and footer
// setHeaderAndFooter(parameters, tenant);
// }
//
// /**
// * Build PO details and set that in parameters
// *
// * @param invoice
// * @param parameters
// */
// private void buildPODetail(final Invoice invoice, final Map<String, Object> parameters) {
//
// CustomLogger.doLog("Building PO details for invoice {} ", TenantContext.getId(),
// LoggerType.INFO, logger, new Object[] {invoice.getId()});
// // po details
// if (!CollectionUtils.isEmpty(invoice.getPurchaseOrders())) {
// if (ObjectUtils.isEmpty(invoice.getPurchaseOrders().get(0).getPoNumber())) {
// parameters.put(ApplicationConstant.PO_NUMBER, ApplicationConstant.HYPHEN);
// } else {
// parameters.put(ApplicationConstant.PO_NUMBER,
// invoice.getPurchaseOrders().get(0).getPoNumber());
// }
// if (ObjectUtils.isEmpty(invoice.getPurchaseOrders().get(0).getPoDate())) {
// parameters.put(ApplicationConstant.PO_DATE, ApplicationConstant.HYPHEN);
// } else {
// parameters.put(ApplicationConstant.PO_DATE,
// SibDateUtil.stringFormatedDate(
// invoice.getPurchaseOrders().get(0).getPoDate(),
// ApplicationConstant.XLSX_DATE_FORMAT));
// }
// } else {
// CustomLogger.doLog("No PO for invoice {} ", TenantContext.getId(), LoggerType.INFO,
// logger, new Object[] {invoice.getId()});
// parameters.put(ApplicationConstant.PO_NUMBER, ApplicationConstant.HYPHEN);
// parameters.put(ApplicationConstant.PO_DATE, ApplicationConstant.HYPHEN);
// }
// }
//
// /**
// * Build Amount details and set that in paramerters
// *
// * @param invoice
// * @param parameters
// * @param tenant
// * @throws ParseException
// */
// private void buildAmountDetail(final Invoice invoice, final Map<String, Object> parameters) {
//
// CustomLogger.doLog("Building Amount Details for invoice {} ", TenantContext.getId(),
// LoggerType.INFO, logger, new Object[] {invoice.getId()});
// final Double totalAmount = invoice.getTotalAmount();
// final Double totalTax = invoice.getTaxAmount();
// final Double subTotal = totalAmount - totalTax;
// parameters.put(ApplicationConstant.SUB_TOTAL, SibUtil.thousandSeperator((subTotal)));
// parameters.put(ApplicationConstant.TOTAL_AMOUNT, SibUtil
// .thousandSeperator((int) Math.round(Double.valueOf(totalAmount.toString()))));
// final StringBuilder amountInWords = new StringBuilder();
// amountInWords.append(ApplicationConstant.RS).append(" (")
// .append(SibUtil.convertNumberToWords(
// (int) Math.round(Double.valueOf(totalAmount.toString()))))
// .append(" ").append(ApplicationConstant.ONLY).append(")");
// parameters.put(ApplicationConstant.TOTAL_AMOUNT_WORDS, amountInWords.toString());
// CustomLogger.doLog("Amount Details build successfully for invoice {} ",
// TenantContext.getId(), LoggerType.INFO, logger, new Object[] {invoice.getId()});
// }
//
// /**
// * Build GST details
// *
// * @param invoice
// * @param parameters
// * @throws ValidationException
// * @throws ParseException
// */
// private void buildGSTDetail(final Invoice invoice, final InvoiceGstDetail invoiceGstDetail,
// final Map<String, Object> parameters, final Date billGeneratedDate,
// final Tenant tenant) throws ParseException {
//
// CustomLogger.doLog("Building TAX details for invoice {} ", TenantContext.getId(),
// LoggerType.INFO, logger, new Object[] {invoice});
// // GST amount if inter state then IGST and if intera state then CGST and SGST
// final Double taxPer = systemRepo.findGst(billGeneratedDate);
// final List<InvoicePdfTax> applicableGst = new ArrayList<>();
// if (!ObjectUtils.isEmpty(invoiceGstDetail.getBranchAddress().getBranchName())
// && !tenant.getAddress().getState().getName()
// .equals(invoiceGstDetail.getBranchAddress().getState().getName())) {
// CustomLogger.doLog("Building tax details for tax type IGST for invoice {} ",
// TenantContext.getId(), LoggerType.INFO, logger, new Object[] {invoice});
// final InvoicePdfTax tax = new InvoicePdfTax();
// final Double taxAmount = invoice.getTaxAmount();
// tax.setApplicableGstType(ApplicationConstant.IGST);
// tax.setTaxAmount(SibUtil.thousandSeperator((taxAmount)));
// tax.setTaxPercentage(taxPer.toString());
// applicableGst.add(tax);
// } else {
// CustomLogger.doLog("Building tax details for tax type CGST and SGST for invoice {} ",
// TenantContext.getId(), LoggerType.INFO, logger, new Object[] {invoice});
// // CGST
// final InvoicePdfTax cgst = new InvoicePdfTax();
// final Double amount = commonService.calculateGst(invoice.getRentAmount(),
// invoice.getPrintAmount(), invoice.getMountAmount(), taxPer / 2);
// cgst.setApplicableGstType(ApplicationConstant.CGST);
// cgst.setTaxAmount(SibUtil.thousandSeperator(amount));
// cgst.setTaxPercentage("" + (taxPer / 2));
// applicableGst.add(cgst);
// // for SGST
// final InvoicePdfTax sgst = new InvoicePdfTax();
// sgst.setApplicableGstType(ApplicationConstant.SGST);
// sgst.setTaxAmount(SibUtil.thousandSeperator(amount));
// sgst.setTaxPercentage("" + taxPer / 2);
// applicableGst.add(sgst);
// }
// final JRBeanCollectionDataSource gstTaxAmount =
// new JRBeanCollectionDataSource(applicableGst);
// parameters.put(ApplicationConstant.APPLICABLE_GST, gstTaxAmount);
// CustomLogger.doLog("Tax details build successfully for invoice {} ", TenantContext.getId(),
// LoggerType.INFO, logger, new Object[] {invoice});
// }
//
// /**
// * Build Invoice Details
// *
// * @param invoice
// * @param parameters
// */
// private void buildInvoiceDetails(final Invoice invoice, final Map<String, Object> parameters) {
//
// CustomLogger.doLog("Building Invocie details for invoice {} ", TenantContext.getId(),
// LoggerType.INFO, logger, new Object[] {invoice.getId()});
// final SystemProperty property = systemRepo
// .findByKeyAndModule(SibPropertyConstant.INVOICE_DUE_DAYS, SibModule.BILLING);
// final int days = SibUtil.objectToInteger(property.getValue());
// parameters.put(ApplicationConstant.INVOICE_NO, invoice.getInvoiceId());
// parameters.put(ApplicationConstant.BILL_GEN_DATE, SibDateUtil.stringFormatedDate(
// invoice.getBillGeneratedDate(), ApplicationConstant.XLSX_DATE_FORMAT));
// if (CollectionUtils.isEmpty(invoice.getRentItems())) {
// parameters.put(ApplicationConstant.BILL_END_DATE, " -");
// parameters.put(ApplicationConstant.BILL_START_DATE, " -");
// } else {
// parameters.put(ApplicationConstant.BILL_END_DATE, SibDateUtil.stringFormatedDate(
// invoice.getBillEndDate(), ApplicationConstant.XLSX_DATE_FORMAT));
// parameters.put(ApplicationConstant.BILL_START_DATE, SibDateUtil.stringFormatedDate(
// invoice.getBillStartDate(), ApplicationConstant.XLSX_DATE_FORMAT));
// }
// parameters.put("dueDate",
// SibDateUtil.stringFormatedDate(
// SibDateUtil.modifyDays(invoice.getBillGeneratedDate(), days, true),
// ApplicationConstant.XLSX_DATE_FORMAT));
// parameters.put(ApplicationConstant.DISPLAY_NAME, invoice.getCampaign().getDisplayName());
// parameters.put("srName", invoice.getCampaign().getEmployee().getFullName());
// CustomLogger.doLog("Invoice details build successfully for invoice {} ",
// TenantContext.getId(), LoggerType.INFO, logger, new Object[] {invoice.getId()});
// }
//
// /**
// * Build Vendor details
// *
// * @param invoice
// * @param parameters
// */
// private void buildCustomerGSTDetails(final InvoiceGstDetail invoiceGst,
// final CampaignWrapper campaign, final String invoiceId,
// final String placeOfSupply,
// final Map<String, Object> parameters) {
//
// CustomLogger.doLog("Building Customer Gst details for invoice {} ", TenantContext.getId(),
// LoggerType.INFO, logger, new Object[] {invoiceId});
// parameters.put(ApplicationConstant.PLACE_OF_SUPPLY, placeOfSupply);
// if (!ObjectUtils.isEmpty(invoiceGst.getGstNo())) {
// parameters.put(ApplicationConstant.STATE,
// !StringUtils.isEmpty(invoiceGst.getBranchAddress().getState()
// .getName()) ? invoiceGst.getBranchAddress().getState().getName()
// : ApplicationConstant.NA);
// parameters.put(ApplicationConstant.STATE_CODE,
// !StringUtils.isEmpty(invoiceGst.getBranchAddress().getState()
// .getKey()) ? invoiceGst.getBranchAddress().getState().getKey()
// : ApplicationConstant.NA);
// parameters.put(ApplicationConstant.PAN_NO,
// StringUtils.isEmpty(invoiceGst.getPanNo()) ? ApplicationConstant.NA
// : invoiceGst.getPanNo());
// parameters.put(ApplicationConstant.GST_NO,
// StringUtils.isEmpty(invoiceGst.getGstNo()) ? ApplicationConstant.NA
// : invoiceGst.getGstNo());
// CustomLogger.doLog("Customer Gst details build successfully for invoice {} ",
// TenantContext.getId(), LoggerType.INFO, logger, new Object[] {invoiceId});
// } else {
// if (!ObjectUtils.isEmpty(campaign.getCustomer().getState())) {
// parameters.put(ApplicationConstant.STATE,
// !StringUtils.isEmpty(campaign.getCustomer().getState().getName()) ? campaign
// .getCustomer().getState().getName() : ApplicationConstant.NA);
// parameters.put(ApplicationConstant.STATE_CODE,
// !StringUtils.isEmpty(campaign.getCustomer().getState().getKey()) ? campaign
// .getCustomer().getState().getKey() : ApplicationConstant.NA);
// }
// parameters.put(ApplicationConstant.PAN_NO,
// StringUtils.isEmpty(campaign.getCustomer().getPan()) ? ApplicationConstant.NA
// : campaign.getCustomer()
// .getPan());
// parameters.put(ApplicationConstant.GST_NO, ApplicationConstant.NA);
// CustomLogger.doLog("Customer Gst details build successfully for invoice {} ",
// TenantContext.getId(), LoggerType.INFO, logger, new Object[] {invoiceId});
// }
// }
//
// /**
// * Build Address of customer
// *
// * @param invoice
// * @param parameters
// */
// private void buildAddress(final Invoice invoice, final Map<String, Object> parameters) {
//
// CustomLogger.doLog("Build Customer address for invoice {} ", TenantContext.getId(),
// LoggerType.INFO, logger, new Object[] {invoice.getId()});
// final StringBuilder address = new StringBuilder();
// final InvoiceGstDetail customerDetail = invoice.getInvoiceGstDetail();
// parameters.put(ApplicationConstant.CUSTOMER_NAME,
// invoice.getCampaign().getCustomer().getBillingName());
// buildAddressLines(customerDetail, invoice.getCampaign(), address, parameters);
// CustomLogger.doLog("Customer address build successfully for invoice {} ",
// TenantContext.getId(), LoggerType.INFO, logger, new Object[] {invoice.getId()});
// }
//
// /**
// * Build Address lines
// *
// * @param customerDetail
// * @param campaignWrapper
// * @param address
// * @param parameters
// */
// private void buildAddressLines(final InvoiceGstDetail customerDetail,
// final CampaignWrapper campaignWrapper,
// final StringBuilder address,
// final Map<String, Object> parameters) {
//
// if (!ObjectUtils.isEmpty(customerDetail)
// && !ObjectUtils.isEmpty(customerDetail.getBranchAddress())
// && !StringUtils.isEmpty(customerDetail.getBranchAddress().getAddress1())) {
// buildAddressLineFromGstDetails(customerDetail, address);
// } else {
// buldAddressLineFromCustomerAddress(campaignWrapper, address);
// }
// parameters.put(ApplicationConstant.ADDRESS, address.toString());
// }
//
// /**
// * Build Customer Address Details
// *
// * @param campaignWrapper
// * @param address
// */
// private void buldAddressLineFromCustomerAddress(final CampaignWrapper campaignWrapper,
// final StringBuilder address) {
//
// if (!StringUtils.isEmpty(campaignWrapper.getCustomer().getAddress1())) {
// address.append(campaignWrapper.getCustomer().getAddress1());
// }
// if (!StringUtils.isEmpty(campaignWrapper.getCustomer().getAddress2())) {
// address.append(", ").append(campaignWrapper.getCustomer().getAddress2());
// }
// if (!ObjectUtils.isEmpty(campaignWrapper.getCustomer().getCity())
// && !StringUtils.isEmpty(campaignWrapper.getCustomer().getCity().getName())) {
// address.append(", ").append(campaignWrapper.getCustomer().getCity().getName());
// }
// if (!StringUtils.isEmpty(campaignWrapper.getCustomer().getPostalCode())) {
// address.append(" - ").append(campaignWrapper.getCustomer().getPostalCode());
// }
// }
//
// /**
// * Build Gst Address Details
// *
// * @param customerDetail
// * @param address
// */
// private void buildAddressLineFromGstDetails(final InvoiceGstDetail customerDetail,
// final StringBuilder address) {
//
// if (!StringUtils.isEmpty(customerDetail.getBranchAddress().getAddress1())) {
// address.append(customerDetail.getBranchAddress().getAddress1());
// }
// if (!StringUtils.isEmpty(customerDetail.getBranchAddress().getAddress2())) {
// address.append(", ").append(customerDetail.getBranchAddress().getAddress2());
// }
// if (!ObjectUtils.isEmpty(customerDetail.getBranchAddress().getCity())
// && !StringUtils.isEmpty(customerDetail.getBranchAddress().getCity().getName())) {
// address.append(", ").append(customerDetail.getBranchAddress().getCity().getName());
// }
// if (!StringUtils.isEmpty(customerDetail.getBranchAddress().getPostalCode())) {
// address.append(" - ").append(customerDetail.getBranchAddress().getPostalCode());
// }
// }
//
// /**
// * Build Mounting items for invoice pdf
// *
// * @param invoice
// * @param items
// * @param count
// * @return
// */
// private int buildMountingItems(final Invoice invoice, final List<InvoicePdfItems> items,
// int count) {
//
// CustomLogger.doLog("Building Mount items for invoice {} ", TenantContext.getId(),
// LoggerType.INFO, logger, new Object[] {invoice.getId()});
// // grouping for mount charge
// if (invoice.isGrouped()) {
// final Map<Double, Double> mountPriceToSqft =
// commonService.groupMountItemsByMountPrice(invoice.getMountingItems());
// for (final Entry<Double, Double> entry : mountPriceToSqft.entrySet()) {
// final InvoicePdfItems item = new InvoicePdfItems();
// item.setSrNo(count);
// item.setDescription(commonService.buildDescriptionForGroupMountPrintItem(
// entry.getValue(), entry.getKey(), ApplicationConstant.MOUNTING));
// item.setStartDate("-");
// item.setEndDate("-");
// item.setDays("-");
// item.setRate("-");
// final Double cost = entry.getKey() * entry.getValue();
// // item.setCost(SibUtil.thousandSeperator((int) Math.round(cost)));
// item.setCost(SibUtil.thousandSeperator(cost));
// items.add(item);
// count++;
// }
// } else {
// for (final AdditionalItem mountItem : invoice.getMountingItems()) {
// if (commonService.getMountCharge(mountItem) != 0) {
// final InvoicePdfItems item = new InvoicePdfItems();
// item.setSrNo(count);
// item.setDescription(
// buildMountPrintItemDesc(mountItem, ApplicationConstant.MOUNTING));
// item.setStartDate("-");
// item.setEndDate("-");
// item.setDays("-");
// item.setRate("-");
// // item.setCost(SibUtil.thousandSeperator((int)
// // Math.round(mountItem.getAmount())));
// item.setCost(SibUtil.thousandSeperator(mountItem.getAmount()));
// items.add(item);
// count++;
// }
// }
// }
// CustomLogger.doLog("Mount items build successfully for invoice {} ", TenantContext.getId(),
// LoggerType.INFO, logger, new Object[] {invoice.getId()});
// return count;
// }
//
// /**
// * Build Description for Mount and Print items
// *
// * @param mountItem
// * @param mounting
// * @return
// */
// private String buildMountPrintItemDesc(final AdditionalItem item, final String operationType) {
//
// double price = 0;
// String notes = null;
// if (operationType.equals(ApplicationConstant.MOUNTING)) {
// price = commonService.getMountCharge(item);
// notes = item.getNote();
// } else if (operationType.equals(ApplicationConstant.PRINTING)) {
// price = commonService.getPrintCharge(item);
// notes = item.getNote();
// }
// final StringBuilder desc = new StringBuilder();
// desc.append(item.getCustomId()).append(" - ").append(item.getCity()).append(", ")
// .append(item.getLocation()).append(" - ").append(item.getSize()).append("\n")
// .append(operationType).append(" - ")
// .append(item.getCreative().equals(ApplicationConstant.DEFAULT) ? ""
// : item.getCreative()
// + " - ")
// .append(item.getSquareFeet()).append(" Sq.Ft.").append("@ ")
// .append(Precision.round(price, ApplicationConstant.PRECISION_SCALE))
// .append("Rs/SQFT");
// appendNotes(desc, notes);
// return desc.toString();
// }
//
// /**
// * Build Print Items for invoice pdf
// *
// * @param invoice
// * @param items
// * @param count
// * @return
// */
// private int buildPrintItems(final Invoice invoice, final List<InvoicePdfItems> items,
// int count) {
//
// CustomLogger.doLog("Building Print items for invoice {} ", TenantContext.getId(),
// LoggerType.INFO, logger, new Object[] {invoice.getId()});
// // do group of printing items based on their print charge per sqft
// if (invoice.isGrouped()) {
// final Map<Double, Double> printPriceToSqft =
// commonService.groupPrintItemsByPrintPrice(invoice.getPrintingItems());
// // build printing items
// for (final Entry<Double, Double> entry : printPriceToSqft.entrySet()) {
// final InvoicePdfItems item = new InvoicePdfItems();
// item.setSrNo(count);
// item.setDescription(commonService.buildDescriptionForGroupMountPrintItem(
// entry.getValue(), entry.getKey(), ApplicationConstant.PRINTING));
// item.setStartDate("-");
// item.setEndDate("-");
// item.setDays("-");
// item.setRate("-");
// final Double cost = entry.getKey() * entry.getValue();
// item.setCost(SibUtil.thousandSeperator(cost));
// items.add(item);
// count++;
// }
// } else {
// for (final AdditionalItem printItem : invoice.getPrintingItems()) {
// if (commonService.getPrintCharge(printItem) != 0) {
// final InvoicePdfItems item = new InvoicePdfItems();
// item.setSrNo(count);
// item.setDescription(
// buildMountPrintItemDesc(printItem, ApplicationConstant.PRINTING));
// item.setStartDate("-");
// item.setEndDate("-");
// item.setDays("-");
// item.setRate("-");
// item.setCost(SibUtil.thousandSeperator(printItem.getAmount()));
// items.add(item);
// count++;
// }
// }
// }
// CustomLogger.doLog("Print items build successfully for invoice {} ", TenantContext.getId(),
// LoggerType.INFO, logger, new Object[] {invoice.getId()});
// return count;
// }
//
// /**
// * Build rent items for invoice pdf
// *
// * @param invoice
// * @param items
// * @return Count
// */
// private int buildRentItems(final Invoice invoice, final List<InvoicePdfItems> items) {
//
// CustomLogger.doLog("Building Rent items for invoice {} ", TenantContext.getId(),
// LoggerType.INFO, logger, new Object[] {invoice.getId()});
// int count = 1;
// for (final RentItem rentItem : invoice.getRentItems()) {
// final InvoicePdfItems item = new InvoicePdfItems();
// item.setSrNo(count);
// final StringBuilder desc = new StringBuilder();
// desc.append(rentItem.getCustomId()).append(" - ").append(rentItem.getCity())
// .append(", ").append(rentItem.getLocation()).append(" - ")
// .append(rentItem.getSize());
// appendNotes(desc, rentItem.getNote());
// item.setDescription(desc.toString());
// item.setStartDate(SibDateUtil.stringFormatedDate(rentItem.getItemStartDate(),
// ApplicationConstant.XLSX_DATE_FORMAT));
// item.setEndDate(SibDateUtil.stringFormatedDate(rentItem.getItemEndDate(),
// ApplicationConstant.XLSX_DATE_FORMAT));
// item.setDays("" + rentItem.getDays());
// item.setRate(SibUtil.thousandSeperator(rentItem.getRate()));
// item.setCost(SibUtil.thousandSeperator(rentItem.getCost()));
// count++;
// items.add(item);
// }
// CustomLogger.doLog("Rent items build successfully for invoice {} ", TenantContext.getId(),
// LoggerType.INFO, logger, new Object[] {invoice.getId()});
// return count;
// }
//
// /**
// * attach notes with description
// *
// * @param description
// * @param notes
// */
// private void appendNotes(final StringBuilder description, final String notes) {
//
// if (!StringUtils.isEmpty(notes)) {
// description.append(" (").append(notes).append(")");
// }
// }
//
// /**
// * Generate credit note pdf with letter head
// *
// * @param object
// * @param type
// * @return
// * @throws ValidationException
// * @throws ParseException
// * @throws PdfGenerationException
// */
// private ByteArrayOutputStream generatePdfReportForCNWithLetterHead(final Object object,
// final Object type) throws ValidationException,
// ParseException,
// PdfGenerationException {
//
// final CreditNote invoice = (CreditNote) object;
// final PrescriptionType invoiceType = (PrescriptionType) type;
// CustomLogger.doLog("Generating pdf for invoice {} and type {}", TenantContext.getId(),
// LoggerType.INFO, logger, new Object[] {invoice.getId()});
// try {
// final Map<String, Object> parameters = new HashMap<>();
// buildJasperParameterForCN(invoice, parameters, invoiceType);
// /* Using compiled version(.jasper) of Jasper report to generate PDF */
// final JasperPrint jasperPrint =
// JasperFillManager.fillReport(customEnv.getPdfTemplate().getCreditNote(),
// parameters, new JREmptyDataSource());
// // get pdf
// return generatePdfResponse(jasperPrint);
// } catch (final JRException e) {
// throw new PdfGenerationException(e.getMessage(), e.getCause());
// }
// }
//
// /**
// * Generate credit note pdf without letter head
// *
// * @param object
// * @param type
// * @return
// * @throws ValidationException
// * @throws ParseException
// * @throws PdfGenerationException
// */
// private ByteArrayOutputStream generatePdfReportForCNWithOutLetterHead(final Object object,
// final Object type) throws ValidationException,
// ParseException,
// PdfGenerationException {
//
// final CreditNote invoice = (CreditNote) object;
// final PrescriptionType invoiceType = (PrescriptionType) type;
// CustomLogger.doLog("Generating pdf for invoice {} and type {}", TenantContext.getId(),
// LoggerType.INFO, logger, new Object[] {invoice.getId()});
// try {
// final Map<String, Object> parameters = new HashMap<>();
// buildJasperParameterForCN(invoice, parameters, invoiceType);
// /* Using compiled version(.jasper) of Jasper report to generate PDF */
// final JasperPrint jasperPrint = JasperFillManager.fillReport(
// customEnv.getPdfTemplate().getCreditNoteWithoutHeader(), parameters,
// new JREmptyDataSource());
// // get pdf
// return generatePdfResponse(jasperPrint);
// } catch (final JRException e) {
// throw new PdfGenerationException(e.getMessage(), e.getCause());
// }
// }
//
// /**
// * Build Jasper Parameters for Credit Note
// *
// * @param invoice
// * @param parameters
// * @param invoiceType
// * @throws ValidationException
// * @throws ParseException
// */
// public void buildJasperParameterForCN(final CreditNote invoice,
// final Map<String, Object> parameters,
// final PrescriptionType invoiceType) throws ValidationException,
// ParseException {
//
// CustomLogger.doLog("Building Jasper Parameters for invoice without detail for invoice {} ",
// TenantContext.getId(), LoggerType.INFO, logger, new Object[] {invoice.getId()});
// final Tenant tenant = commonService.findTenant();
// // build address and customer name
// buildAddressForCN(invoice, parameters);
// // build vendor pan detail, gst detail, state, place of supply , state code
// buildCustomerGSTDetails(invoice.getInvoiceGstDetail(), invoice.getCampaign(),
// invoice.getInvoiceId(), invoice.getPlaceOfSupply(), parameters);
// /*
// * build invoice details i.e invoice date, invoice number, bill gen date, bill end date, display
// * name
// */
// // buildInvoiceDetails(invoice, parameters);
// // build gst details which gst is applicable and its amount
// buildGSTDetailForCN(invoice, tenant, parameters);
// // Credit note id
// parameters.put(ApplicationConstant.CREDIT_NOTE_NO, invoice.getInvoiceId());
// // Credit note id
// parameters.put(ApplicationConstant.INVOICE_NO, invoice.getInvoiceReferenceId());
// // bill generated date
// parameters.put(ApplicationConstant.BILL_GEN_DATE, SibDateUtil.stringFormatedDate(
// invoice.getBillGeneratedDate(), ApplicationConstant.XLSX_DATE_FORMAT));
// // cn created date
// parameters.put("cnDate", SibDateUtil.stringFormatedDate(invoice.getCreatedDate(),
// ApplicationConstant.XLSX_DATE_FORMAT));
// // invoice type
// parameters.put(ApplicationConstant.INVOICE_TYPE, invoiceType.getValue());
// // display name
// parameters.put(ApplicationConstant.DISPLAY_NAME, invoice.getCampaign().getDisplayName());
// // sr name
// parameters.put("srName", invoice.getCampaign().getEmployee().getFullName());
// // remark
// parameters.put("remark", invoice.getRemark());
// // build signature details
// buildSignatureDetail(parameters, tenant, ApplicationConstant.CN_SET_SIGNATURE);
// // set header
// setHeaderAndFooter(parameters, tenant);
// }
//
// /**
// * Build Amount details and set that in paramerters
// *
// * @param invoice
// * @param parameters
// * @param tenant
// * @throws ParseException
// */
// private void buildAmountDetailForCN(final Double subTotal, final Double taxAmount,
// final String invoiceId,
// final Map<String, Object> parameters) {
//
// CustomLogger.doLog("Building Amount Details for invoice {} ", TenantContext.getId(),
// LoggerType.INFO, logger, new Object[] {invoiceId});
// final Double totalAmount = subTotal + taxAmount;
// parameters.put(ApplicationConstant.SUB_TOTAL, SibUtil.thousandSeperator(subTotal));
// parameters.put(ApplicationConstant.TOTAL_AMOUNT, SibUtil
// .thousandSeperator((int) Math.round(Double.valueOf(totalAmount.toString()))));
// final StringBuilder amountInWords = new StringBuilder();
// amountInWords.append(ApplicationConstant.RS).append(" (")
// .append(SibUtil.convertNumberToWords(
// (int) Math.round(Double.valueOf(totalAmount.toString()))))
// .append(" ").append(ApplicationConstant.ONLY).append(")");
// parameters.put(ApplicationConstant.TOTAL_AMOUNT_WORDS, amountInWords.toString());
// CustomLogger.doLog("Amount Details build successfully for invoice {} ",
// TenantContext.getId(), LoggerType.INFO, logger, new Object[] {invoiceId});
// }
//
// /**
// * Build Address of customer
// *
// * @param invoice
// * @param parameters
// */
// private void buildAddressForCN(final CreditNote invoice, final Map<String, Object> parameters) {
//
// CustomLogger.doLog("Build Customer address for invoice {} ", TenantContext.getId(),
// LoggerType.INFO, logger, new Object[] {invoice.getId()});
// final StringBuilder address = new StringBuilder();
// final InvoiceGstDetail customerDetail = invoice.getInvoiceGstDetail();
// parameters.put(ApplicationConstant.CUSTOMER_NAME,
// invoice.getCampaign().getCustomer().getBillingName());
// buildAddressLines(customerDetail, invoice.getCampaign(), address, parameters);
// CustomLogger.doLog("Customer address build successfully for invoice {} ",
// TenantContext.getId(), LoggerType.INFO, logger, new Object[] {invoice.getId()});
// }
//
// /**
// * @param invoice
// * @param tenant
// * @param parameters
// * @throws ParseException
// */
// private void buildGSTDetailForCN(final CreditNote invoice, final Tenant tenant,
// final Map<String, Object> parameters) throws ParseException {
//
// CustomLogger.doLog("Building TAX details for invoice {} ", TenantContext.getId(),
// LoggerType.INFO, logger, new Object[] {invoice.getId()});
// // GST amount if inter state then IGST and if intera state then CGST and SGST
// final Double taxPer = systemRepo.findGst(invoice.getBillGeneratedDate());
// final List<InvoicePdfTax> applicableGst = new ArrayList<>();
// Double taxAmount;
// if (!ObjectUtils.isEmpty(invoice.getInvoiceGstDetail().getBranchAddress().getBranchName())
// && !tenant.getAddress().getState().getName().equals(
// invoice.getInvoiceGstDetail().getBranchAddress().getState().getName())) {
// CustomLogger.doLog("Building tax details for tax type IGST for invoice {} ",
// TenantContext.getId(), LoggerType.INFO, logger, new Object[] {invoice.getId()});
// final InvoicePdfTax tax = new InvoicePdfTax();
// // final Double taxAmount = invoice.getTaxAmount();
// taxAmount = invoice.getTaxAmount();
// tax.setApplicableGstType(ApplicationConstant.IGST);
// // tax.setTaxAmount(
// // SibUtil.thousandSeperator((int) Math.round(Double.valueOf(taxAmount.toString()))));
// tax.setTaxAmount(SibUtil.thousandSeperator(taxAmount));
// tax.setTaxPercentage(taxPer.toString());
// applicableGst.add(tax);
// } else {
// CustomLogger.doLog("Building tax details for tax type CGST and SGST for invoice {} ",
// TenantContext.getId(), LoggerType.INFO, logger, new Object[] {invoice.getId()});
// // CGST
// final InvoicePdfTax cgst = new InvoicePdfTax();
// // final Double amount = invoice.getTaxAmount() / 2;
// // final Double amount = this.commonService.calculateGst(invoice.getRentAmount(),
// // invoice.getPrintAmount(), invoice.getMountAmount(), taxPer / 2);
// final Double amount = commonService.calculateGst(
// invoice.getTotalAmount() - invoice.getTaxAmount(), 0, 0, taxPer / 2);
// cgst.setApplicableGstType(ApplicationConstant.CGST);
// // cgst.setTaxAmount(
// // SibUtil.thousandSeperator((int) Math.round(Double.valueOf(amount.toString()))));
// cgst.setTaxAmount(SibUtil.thousandSeperator(amount));
// cgst.setTaxPercentage("" + (taxPer / 2));
// applicableGst.add(cgst);
// // for SGST
// final InvoicePdfTax sgst = new InvoicePdfTax();
// sgst.setApplicableGstType(ApplicationConstant.SGST);
// // sgst.setTaxAmount(
// // SibUtil.thousandSeperator((int) Math.round(Double.valueOf(amount.toString()))));
// sgst.setTaxAmount(SibUtil.thousandSeperator(amount));
// sgst.setTaxPercentage("" + taxPer / 2);
// applicableGst.add(sgst);
// taxAmount = amount * 2;
// }
// final JRBeanCollectionDataSource gstTaxAmount =
// new JRBeanCollectionDataSource(applicableGst);
// parameters.put(ApplicationConstant.APPLICABLE_GST, gstTaxAmount);
// // build amount details
// buildAmountDetailForCN(invoice.getTotalAmount() - invoice.getTaxAmount(), taxAmount,
// invoice.getId(), parameters);
// CustomLogger.doLog("Tax details build successfully for invoice {} ", TenantContext.getId(),
// LoggerType.INFO, logger, new Object[] {invoice.getId()});
// }
//
// /**
// * Set Header and footer Url
// *
// * @param parameters
// * @param tenant
// * @throws ValidationException
// */
// private void setHeaderAndFooter(final Map<String, Object> parameters,
// final Tenant tenant) throws ValidationException {
//
// if (StringUtils.isEmpty(tenant.getInvoicePdfHeader().getUrl())
// || StringUtils.isEmpty(tenant.getInvoicePdfFooter().getUrl())) {
// throw new ValidationException("Please set invoice header and footer first");
// }
// parameters.put("headerUrl", tenant.getInvoicePdfHeader().getUrl());
// parameters.put("footerUrl", tenant.getInvoicePdfFooter().getUrl());
// }
// }
