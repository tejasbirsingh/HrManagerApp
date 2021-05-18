package com.nagarro.assignment5.utilities;

import java.io.IOException;
import java.io.InputStream;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.web.multipart.MultipartFile;

import com.nagarro.assignment5.dto.Employee;
import com.nagarro.assignment5.exceptions.CustomException;

public class ExcelHelper {

    private static final String TYPE = "application/vnd.openxmlformats-officedocument.spreadsheetml.sheet";
    private static final String SHEET = "sheet1"; // for first sheet in an csv file

    private ExcelHelper() {
	// default contructor
    }

    // returns true if file is valid format else returns false
    public static boolean hasExcelFormat(MultipartFile file) {

	return TYPE.equals(file.getContentType());
    }

    public static List<Employee> excelToEmployees(InputStream is) throws CustomException {
	try (Workbook workbook = new XSSFWorkbook(is);) {

	    Sheet sheet = workbook.getSheet(SHEET);
	    Iterator<Row> rows = sheet.iterator();

	    List<Employee> employees = new ArrayList<>();

	    int rowNumber = 0;
	    while (rows.hasNext()) {
		Row currentRow = rows.next();

		// skip first row as it consists of column names
		if (rowNumber == 0) {
		    rowNumber++;
		    continue;
		}

		Iterator<Cell> cellsInRow = currentRow.iterator();
		Employee employee = new Employee();
		int cellIndex = 0;

		while (cellsInRow.hasNext()) {

		    Cell currentCell = cellsInRow.next(); // iterate over columns
		    switch (cellIndex) {
		    case 0:
			setEmployeeCode(employee, currentCell);
			break;

		    case 1:
			employee.setName(currentCell.getStringCellValue());
			break;

		    case 2:
			employee.setLocation(currentCell.getStringCellValue());
			break;

		    case 3:
			employee.setEmail(currentCell.getStringCellValue());
			break;

		    case 4:
			employee.setDateOfBirth(LocalDate.parse(currentCell.getStringCellValue()));
			break;

		    default:
			break;
		    }
		    cellIndex++;
		}
		employees.add(employee);
	    }
	    return employees;

	} catch (IOException e) {
	    throw new CustomException("Failed to parse CSV file: " + e.getMessage());
	}
    }

    static void setEmployeeCode(Employee employee, Cell currentCell) {
	try {
	    employee.setCode((long) currentCell.getNumericCellValue());
	} catch (Exception e) {
	    employee.setCode(Long.parseLong(currentCell.getStringCellValue()));
	}
    }
}