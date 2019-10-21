package utils;

import java.io.IOException;

public class ScanImage {

	public static void scanImage(){
	    //new ProcessBuilder("D:\\soft\\1000net.exe").start();
	    //Runtime.getRuntime().exec("calc.exe");
	    //Process proc;
		try {
			System.out.print("Начинаем сканирование!");
			Process proc = Runtime.getRuntime().exec("D:\\soft\\scan.exe");
		    //proc.wait();
		//} catch (IOException | InterruptedException e) {
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}


//    CreateReport.createReport(fdocs, filepath);	

	}
}
