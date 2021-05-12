package com.nagarro.assignment5.utilities;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import com.nagarro.assignment5.dto.Employee;

public class ExcelExporter {

    private XSSFWorkbook workbook;
    private XSSFSheet sheet;
    private List<Employee> employees;

    public ExcelExporter(List<Employee> employees) {
	this.employees = employees;
	workbook = new XSSFWorkbook();
    }

    private void createCell(Row row, int columnCount, Object value, CellStyle style) {
	sheet.autoSizeColumn(columnCount);
	Cell cell = row.createCell(columnCount);
	cell.setCellValue(String.valueOf(value));
	cell.setCellStyle(style);
    }

    private void writeHeaderLine() {

	sheet = workbook.createSheet("Employees");
	Row row = sheet.createRow(0);
	CellStyle style = workbook.createCellStyle();

	createCell(row, 0, "code", style);
	createCell(row, 1, "name", style);
	createCell(row, 2, "location", style);
	createCell(row, 3, "email", style);
	createCell(row, 4, "dateOfBirth", style);

    }

    private void writeDataLines() {

	int currRow = 1;
	CellStyle style = workbook.createCellStyle();

	for (Employee employee : employees) {
	    Row row = sheet.createRow(currRow++);
	    int columnCount = 0;

	    createCell(row, columnCount++, employee.getCode(), style);
	    createCell(row, columnCount++, employee.getName(), style);
	    createCell(row, columnCount++, employee.getLocation(), style);
	    createCell(row, columnCount++, employee.getEmail(), style);
	    createCell(row, columnCount++, employee.getDateOfBirth(), style);

	}
    }

    public void export(HttpServletResponse response) throws IOException {

	writeHeaderLine();
	writeDataLines();
	ServletOutputStream outputStream = response.getOutputStream();
	workbook.write(outputStream);
	workbook.close();

	outputStream.close();

    }
}
