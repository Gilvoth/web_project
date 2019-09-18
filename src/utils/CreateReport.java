package utils;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.hssf.usermodel.HSSFFont;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Row;

import model.Fdoc;

public class CreateReport {
	public static void createReport(ArrayList<Fdoc> fdoc, String filepath) throws ParseException {
	
	if (filepath.isEmpty()){
		filepath = "D:\\soft";
		}
	
	//create excelfile in memory
    HSSFWorkbook workbook = new HSSFWorkbook();
    // create name of list
    HSSFSheet sheet = workbook.createSheet("Отчёт");
    
    
    // заполняем список какими-то данными
    List<Fdoc> list = new ArrayList<>(fdoc);
	
    // счетчик для строк
    int rowNum = 0;

    // создаем подписи к столбцам (это будет первая строчка в листе Excel файла)
    Row row = sheet.createRow(rowNum);
    row.createCell(0).setCellValue("№");
    row.createCell(1).setCellValue("Тип");
    row.createCell(2).setCellValue("Контрагент");
    row.createCell(3).setCellValue("Предмет");
    
    row.createCell(4).setCellValue("Содержание");
    row.createCell(5).setCellValue("И.о. отв.");
    row.createCell(6).setCellValue("Фамилия отв.");
    row.createCell(7).setCellValue("Статус актуальности");
    row.createCell(8).setCellValue("Дата создания");
    row.createCell(9).setCellValue("Закончен ли документ");
    row.createCell(10).setCellValue("Рек. дата");
    row.createCell(11).setCellValue("ТРУ");
    row.createCell(12).setCellValue("ФЗ");
    row.createCell(13).setCellValue("Подразделение");
    //row.createCell(0).setCellValue(fdoc.getPrice());
    row.createCell(14).setCellValue("Оплачен ли");
    //row.createCell(0).setCellValue(fdoc.getIfo());
    row.createCell(15).setCellValue("Доп соглашение");
    //row.createCell(0).setCellValue(fdoc.getPrice_add_agr());  
    
    
    // заполняем лист данными
    for (Fdoc dataModel : list) {
        createSheetHeader(sheet, ++rowNum, dataModel);
    }

    // записываем созданный в памяти Excel документ в файл
    try (FileOutputStream out = new FileOutputStream(new File(filepath + "\\Excel File.xls"))) {
        workbook.write(out);
    } catch (IOException e) {
        e.printStackTrace();
    }
    System.out.println("Excel файл успешно создан!");
    
    //do one row bold
    // говорим, что хотим работать с первым листом
    //HSSFSheet sheet = workbook.getSheetAt(0);

    // создаем шрифт
    HSSFFont font = workbook.createFont();
    // указываем, что хотим его видеть жирным
    font.setBoldweight(HSSFFont.BOLDWEIGHT_BOLD);
    font.setFontHeightInPoints((short)14);
    font.setFontName("Courier New");
    // создаем стиль для ячейки
    HSSFCellStyle style = workbook.createCellStyle();
    // и применяем к этому стилю жирный шрифт
    style.setFont(font);
    style.setWrapText(true);
    // получаем первую строку листа excel файла
    row = sheet.getRow(0);
    // проходим по всем ячейкам этой строки
    for (int i = 0; i < row.getPhysicalNumberOfCells(); i++) {
        // применяем созданный выше стиль к каждой ячейке
        row.getCell(i).setCellStyle(style);
        sheet.autoSizeColumn(i);
        
    }
    sheet.autoSizeColumn(1);
    // получаем доступ к excel файлу и обновляем его
    try (FileOutputStream out = new FileOutputStream(new File(filepath + "\\Excel File.xls"))) {
        workbook.write(out);
    } catch (IOException e) {
        e.printStackTrace();
    	}
    System.out.println("Excel файл успешно обновлен!"); 

    
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
        row.createCell(0).setCellValue(fdoc.getId());
        row.createCell(1).setCellValue(fdoc.getId_type());
        row.createCell(2).setCellValue(fdoc.getId_contractor());
        row.createCell(3).setCellValue(fdoc.getName());
        
        row.createCell(4).setCellValue(fdoc.getContent());
        row.createCell(5).setCellValue(fdoc.getCreator_name());
        row.createCell(6).setCellValue(fdoc.getCreator_second());
        row.createCell(7).setCellValue(fdoc.getUrgency());
        row.createCell(8).setCellValue(fdoc.getDate_cre());
        row.createCell(9).setCellValue(fdoc.getStatus_finished());
        row.createCell(10).setCellValue(fdoc.getRec_date());
        row.createCell(11).setCellValue(fdoc.getTru());
        row.createCell(12).setCellValue(fdoc.getLaw());
        row.createCell(13).setCellValue(fdoc.getDivision());
        //row.createCell(0).setCellValue(fdoc.getPrice());
        row.createCell(14).setCellValue(fdoc.isPaid());
        //row.createCell(0).setCellValue(fdoc.getIfo());
        row.createCell(15).setCellValue(fdoc.getAdd_agr());
        //row.createCell(0).setCellValue(fdoc.getPrice_add_agr());        
    }
    
    
    
}
