package com.emre.stocktracking.controller;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.text.SimpleDateFormat;
import java.util.List;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFFont;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.stereotype.Service;

import com.emre.stocktracking.model.Customer;
import com.emre.stocktracking.model.StockOut;
import com.emre.stocktracking.model.StockStatus;
import com.emre.stocktracking.model.StockIn;
import com.emre.stocktracking.model.Supplier;

@Service
public class ExcelFileServiceImpl implements ExcelFileService {

    @Override
    public ByteArrayInputStream export(List<StockStatus> stockStatuses,
                                       List<StockIn> stockIns, List<StockOut> stockOuts,
                                       List<Customer> customers, List<Supplier> suppliers) {
        try (Workbook workbook = new XSSFWorkbook()) {
            CellStyle headerCellStyle = createHeaderCellStyle(workbook);

            createStockStatusSheet(workbook, stockStatuses, headerCellStyle);
            createStockInSheet(workbook, stockIns, headerCellStyle);
            createStockOutSheet(workbook, stockOuts, headerCellStyle);
            createCustomerSheet(workbook, customers, headerCellStyle);
            createSupplierSheet(workbook, suppliers, headerCellStyle);

            ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
            workbook.write(outputStream);
            return new ByteArrayInputStream(outputStream.toByteArray());

        } catch (Exception e) {
            return null;
        }
    }

    private CellStyle createHeaderCellStyle(Workbook workbook) {
        CellStyle headerCellStyle = workbook.createCellStyle();
        XSSFFont font = (XSSFFont) workbook.createFont();
        font.setBold(true);
        font.setFontHeight(14);
        headerCellStyle.setFont(font);
        return headerCellStyle;
    }

    private void createStockStatusSheet(Workbook workbook, List<StockStatus> stocks, CellStyle headerCellStyle) {
        Sheet sheet = workbook.createSheet("Stock Status");
        String[] headers = {"Barcode Number", "Product Name", "The Amount of Stock", "Average Unit Cost"};
        createHeaderRow(sheet, headers, headerCellStyle);

        for (int i = 0; i < stocks.size(); i++) {
            Row dataRow = sheet.createRow(i + 1);
            StockStatus stock = stocks.get(i);
            dataRow.createCell(0).setCellValue(stock.getBarcodeId());
            dataRow.createCell(1).setCellValue(stock.getName());
            dataRow.createCell(2).setCellValue(stock.getQuantity());
            dataRow.createCell(3).setCellValue(stock.getAverageCost());
        }
        autoSizeColumns(sheet, headers.length);
    }

    private void createStockInSheet(Workbook workbook, List<StockIn> stockIns, CellStyle headerCellStyle) {
        Sheet sheet = workbook.createSheet("Stock Ins");
        String[] headers = {"Id", "Product Barcode", "Product Name", "Supplier Name", "Product Quantity", "Purchase Price", "Transaction Date"};
        createHeaderRow(sheet, headers, headerCellStyle);

        SimpleDateFormat simpleDate = new SimpleDateFormat("dd-MM-yyyy");
        for (int i = 0; i < stockIns.size(); i++) {
            Row dataRow = sheet.createRow(i + 1);
            StockIn stockIn = stockIns.get(i);
            dataRow.createCell(0).setCellValue(stockIn.getId());
            dataRow.createCell(1).setCellValue(stockIn.getProduct().getBarcodeId());
            dataRow.createCell(2).setCellValue(stockIn.getProduct().getName());
            dataRow.createCell(3).setCellValue(stockIn.getSupplier().getCompany());
            dataRow.createCell(4).setCellValue(stockIn.getQuantity());
            dataRow.createCell(5).setCellValue(stockIn.getPrice());
            dataRow.createCell(6).setCellValue(simpleDate.format(stockIn.getEntryDate()));
        }
        autoSizeColumns(sheet, headers.length);
    }

    private void createStockOutSheet(Workbook workbook, List<StockOut> stockOuts, CellStyle headerCellStyle) {
        Sheet sheet = workbook.createSheet("Stock Out");
        String[] headers = {"Id", "Product Barcode", "Product Name", "Customer Name", "Product Quantity", "Selling Price", "Transaction Date"};
        createHeaderRow(sheet, headers, headerCellStyle);

        SimpleDateFormat simpleDate = new SimpleDateFormat("MM-dd-yyyy");
        for (int i = 0; i < stockOuts.size(); i++) {
            Row dataRow = sheet.createRow(i + 1);
            StockOut stockOut = stockOuts.get(i);
            dataRow.createCell(0).setCellValue(stockOut.getId());
            dataRow.createCell(1).setCellValue(stockOut.getProduct().getBarcodeId());
            dataRow.createCell(2).setCellValue(stockOut.getProduct().getName());
            dataRow.createCell(3).setCellValue(stockOut.getCustomer().getCompany());
            dataRow.createCell(4).setCellValue(stockOut.getQuantity());
            dataRow.createCell(5).setCellValue(stockOut.getPrice());
            dataRow.createCell(6).setCellValue(simpleDate.format(stockOut.getReleaseDate()));
        }
        autoSizeColumns(sheet, headers.length);
    }

    private void createCustomerSheet(Workbook workbook, List<Customer> customers, CellStyle headerCellStyle) {
        Sheet sheet = workbook.createSheet("Customers");
        String[] headers = {"Id", "Company Name", "Phone", "Fax Number", "E-Mail", "Address"};
        createHeaderRow(sheet, headers, headerCellStyle);

        for (int i = 0; i < customers.size(); i++) {
            Row dataRow = sheet.createRow(i + 1);
            Customer customer = customers.get(i);
            dataRow.createCell(0).setCellValue(customer.getId());
            dataRow.createCell(1).setCellValue(customer.getCompany());
            dataRow.createCell(2).setCellValue(customer.getPhone());
            dataRow.createCell(3).setCellValue(customer.getFaxNumber());
            dataRow.createCell(4).setCellValue(customer.getEmail());
            dataRow.createCell(5).setCellValue(customer.getAddress());
        }
        autoSizeColumns(sheet, headers.length);
    }

    private void createSupplierSheet(Workbook workbook, List<Supplier> suppliers, CellStyle headerCellStyle) {
        Sheet sheet = workbook.createSheet("Suppliers");
        String[] headers = {"Id", "Company Name", "Phone", "Fax Number", "E-Mail", "Address"};
        createHeaderRow(sheet, headers, headerCellStyle);

        for (int i = 0; i < suppliers.size(); i++) {
            Row dataRow = sheet.createRow(i + 1);
            Supplier supplier = suppliers.get(i);
            dataRow.createCell(0).setCellValue(supplier.getId());
            dataRow.createCell(1).setCellValue(supplier.getCompany());
            dataRow.createCell(2).setCellValue(supplier.getPhone());
            dataRow.createCell(3).setCellValue(supplier.getFaxNumber());
            dataRow.createCell(4).setCellValue(supplier.getEmail());
            dataRow.createCell(5).setCellValue(supplier.getAddress());
        }
        autoSizeColumns(sheet, headers.length);
    }

    private void createHeaderRow(Sheet sheet, String[] headers, CellStyle headerCellStyle) {
        Row headerRow = sheet.createRow(0);
        for (int i = 0; i < headers.length; i++) {
            Cell cell = headerRow.createCell(i);
            cell.setCellValue(headers[i]);
            cell.setCellStyle(headerCellStyle);
        }
    }

    private void autoSizeColumns(Sheet sheet, int numberOfColumns) {
        for (int i = 0; i < numberOfColumns; i++) {
            sheet.autoSizeColumn(i);
        }
    }
}
