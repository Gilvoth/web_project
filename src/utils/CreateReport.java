package utils;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Row;

import model.Fdoc;

public class CreateReport {
	public static void createReport(ArrayList<Fdoc> fdoc) throws ParseException {
    // create excelfile in memory
    HSSFWorkbook workbook = new HSSFWorkbook();
    // create name of list
    HSSFSheet sheet = workbook.createSheet("Отчёт");
    
    // заполняем список какими-то данными
    List<Fdoc> list = new ArrayList<>(fdoc);
	
    // счетчик для строк
    int rowNum = 0;

    // создаем подписи к столбцам (это будет первая строчка в листе Excel файла)
    Row row = sheet.createRow(rowNum);
    row.createCell(0).setCellValue("Название");
    row.createCell(1).setCellValue("Содержание");
    row.createCell(2).setCellValue("Имя");
    row.createCell(3).setCellValue("Фамилия");

    // заполняем лист данными
    for (Fdoc dataModel : list) {
        createSheetHeader(sheet, ++rowNum, dataModel);
    }

    // записываем созданный в памяти Excel документ в файл
    try (FileOutputStream out = new FileOutputStream(new File("D:\\soft\\workspace\\Apache POI Excel File.xls"))) {
        workbook.write(out);
    } catch (IOException e) {
        e.printStackTrace();
    }
    System.out.println("Excel файл успешно создан!");
    try {
		workbook.close();
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
    
	}
	
	
    // заполнение строки (rowNum) определенного листа (sheet)
    // данными  из dataModel созданного в памяти Excel файла
    private static void createSheetHeader(HSSFSheet sheet, int rowNum, Fdoc fdoc) {
        Row row = sheet.createRow(rowNum);
 
        row.createCell(0).setCellValue(fdoc.getName());
        row.createCell(1).setCellValue(fdoc.getContent());
        row.createCell(2).setCellValue(fdoc.getCreator_name());
        row.createCell(3).setCellValue(fdoc.getCreator_second());
    }
    
    
    
}
