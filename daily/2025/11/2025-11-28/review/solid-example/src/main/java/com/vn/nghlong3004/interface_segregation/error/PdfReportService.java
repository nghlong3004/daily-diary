package com.vn.nghlong3004.interface_segregation.error;

/**
 * Project: solid-example
 *
 * @author nghlong3004
 * @since 11/28/2025
 */
public class PdfReportService implements ReportService {
  @Override
  public void generatePdfReport() {
    System.out.println("Generate PDF...");
  }

  @Override
  public void generateExcelReport() {
    throw new UnsupportedOperationException("Not supported");
  }

  @Override
  public void sendReportByEmail() {
    throw new UnsupportedOperationException("Not supported");
  }
}

