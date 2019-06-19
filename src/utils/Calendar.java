package utils;

import java.io.IOException;
import java.util.Date;
//import java.util.Calendar;
import java.util.GregorianCalendar;


import java.text.SimpleDateFormat;

public class Calendar {

public Calendar() {
        super();
        // TODO Auto-generated constructor stub
    }	
	
    public static String Date()
    {
        // календарь на текущую дату
        GregorianCalendar c = new GregorianCalendar();
        //java.util.Date st_c = c.getTime();
        System.out.print(c.getTime());
        String str_c = c.getTime().toString();
        return  str_c;


}
}