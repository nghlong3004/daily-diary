package com.vn.nghlong3004.interface_segregation.standard;

/**
 * Project: solid-example
 *
 * @author nghlong3004
 * @since 11/28/2025
 */
public class ExcelReportService implements ExcelReportGenerator {
  @Override
  public void generateExcelReport() {
    System.out.println("Generate Excel...");
  }
}

