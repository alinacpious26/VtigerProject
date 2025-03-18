package utilities;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Properties;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class DataUtilities {
	String propertyFilePath = "C:\\Users\\ALINA\\eclipse-workspace\\Testing\\Vtiger\\src\\test\\resources\\datas\\vtigerdata.properties";
	String excelFilePath = "C:\\Users\\ALINA\\eclipse-workspace\\Testing\\Vtiger\\src\\test\\resources\\datas\\Book1.xlsx";

	public void setDataIntoPropertyFile(String key, String value) {

		try {

			// specify the path by creating object for FIS
			FileInputStream fis = new FileInputStream(propertyFilePath);

			// create object for properties class
			Properties p = new Properties();

			// load file into property object
			p.load(fis);

			// set data
			p.setProperty(key, value);

			// create object FOS
			FileOutputStream fout = new FileOutputStream(propertyFilePath);

			// store data
			p.store(fout, "Data Stored Successfully");

			// print confirmation message
			System.out.println("Data Stored Successfully");

		} catch (Exception e) {
			System.out.println("Unable to set data into property file");
		}

	}

	public String getDataFromPropertyFile(String property) {
		String value = "";

		try {

			// specify the path by creating object for FIS
			FileInputStream fis = new FileInputStream(propertyFilePath);

			// create object for properties class
			Properties p = new Properties();

			// load file into property object
			p.load(fis);

			// get property
			value = p.getProperty(property);

		} catch (Exception e) {

			System.out.println("Unable to fetch data from property file");

		}
		// return the property
		return value;

	}

	public void removeDataFromPropertyFile(String property) {

		try {

			// specify the path by creating object for FIS
			FileInputStream fis = new FileInputStream(propertyFilePath);

			// create object for properties class
			Properties p = new Properties();

			// load file into property object
			p.load(fis);

			// remove data
			p.remove(property);

			// create object for File output stream
			FileOutputStream fout = new FileOutputStream(propertyFilePath);

			// store data
			p.store(fout, "Data Removed Successfully");

			// print confirmation message
			System.out.println("Data Removed Successfully");

		} catch (Exception e) {

			System.out.println("Unable to remove data from property file");

		}

	}

	public void setDataIntoExcel(String sheet, int row, int cell, String value) {

		try {

			// specify the path by creating object for FIS
			FileInputStream fis = new FileInputStream(excelFilePath);

			// create workbook and load file
			Workbook wb = WorkbookFactory.create(fis);

			// get sheet,create row ,create cell
			wb.getSheet(sheet).createRow(row).createCell(cell).setCellValue(value);

			// create object for file output stream
			FileOutputStream fout = new FileOutputStream(excelFilePath);

			// write into file
			wb.write(fout);

		} catch (Exception e) {

			System.out.println("Unable to set data into Excel");

		}

	}

	public String getDataFromExcel(String sheet, int row, int cell) {

		String value = "";

		try {

			// specify the path by creating object for FIS
			FileInputStream fis = new FileInputStream(excelFilePath);

			// create workbook factory and load file
			Workbook wb = WorkbookFactory.create(fis);

			// get sheet,get row,get cell,get cell value
			value = wb.getSheet(sheet).getRow(row).getCell(cell).getStringCellValue();

		} catch (Exception e) {

			System.out.println("Unable to fetch data from Excel");

		}
		// return the value
		return value;

	}

	public void setDataIntoDatabase(String query) {

		try {

			// fetch jdbcurl,jdbcun,jdbcpwd from property file
			String jdbcURL = getDataFromPropertyFile("jdbcurl");
			String jdbcun = getDataFromPropertyFile("jdbcun");
			String jdbcpwd = getDataFromPropertyFile("jdbcpwd");

			// load the driver
			Class.forName("com.mysql.cj.jdbc.Driver");

			// create connection by entering url,un,pwd
			Connection conn = DriverManager.getConnection(jdbcURL, jdbcun, jdbcpwd);

			// create statement object and execute query
			conn.createStatement().execute(query);

			// print success message
			System.out.println("Query Executed Successfully");

		} catch (Exception e) {

			System.out.println("Unable to execute the query");

		}

	}

	public ArrayList<Object[]> getDataFromDatabase(String query) {

		ArrayList<Object[]> al = new ArrayList<Object[]>();

		try {

			// fetch jdbcurl, jdbcun, jdbcpwd from property file

			String jdbcURL = getDataFromPropertyFile("jdbcurl");
			String jdbcun = getDataFromPropertyFile("jdbcun");
			String jdbcpwd = getDataFromPropertyFile("jdbcpwd");

			// load the driver
			Class.forName("com.mysql.cj.jdbc.Driver");

			// create connection by entering url,un,pwd
			Connection conn = DriverManager.getConnection(jdbcURL, jdbcun, jdbcpwd);

			// create statement object and execute query
			ResultSet result = conn.createStatement().executeQuery(query);

			// print result
			while (result.next()) {

				int columnCount = result.getMetaData().getColumnCount();
				String[] rowdata = new String[columnCount];

				for (int i = 1; i <= columnCount; i++) {

					rowdata[i - 1] = result.getString(i);
				}
				al.add(rowdata);

			}

		} catch (Exception e) {

			System.out.println("Unable to fetch data from Database");
		}

		// return the value
		return al;

	}

}
