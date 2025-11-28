package com.vn.nghlong3004.interface_segregation.error;

/**
 * Project: solid-example
 *
 * @author nghlong3004
 * @since 11/28/2025
 */
public interface ReportService {
  void generatePdfReport();
  void generateExcelReport();
  void sendReportByEmail();
}

