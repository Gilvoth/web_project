package utils;

import java.text.ParseException;

import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;

public class CreateReport {
	public static void createReport() throws ParseException {
    // create excelfile in memory
    HSSFWorkbook workbook = new HSSFWorkbook();
    // create name of list
    HSSFSheet sheet = workbook.createSheet("Отчёт");
    
	}
    
}
