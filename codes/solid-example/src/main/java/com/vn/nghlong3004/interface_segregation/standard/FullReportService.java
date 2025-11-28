package com.vn.nghlong3004.interface_segregation.standard;

/**
 * Project: solid-example
 *
 * @author nghlong3004
 * @since 11/28/2025
 */
public class FullReportService implements PdfReportGenerator, ExcelReportGenerator, EmailReportSender {
  @Override
  public void generatePdfReport() { /* ... */ }

  @Override
  public void generateExcelReport() { /* ... */ }

  @Override
  public void sendReportByEmail() { /* ... */ }
}
