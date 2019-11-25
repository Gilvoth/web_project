package utils;

//import java.io.IOException;
import java.util.Date;
//import java.util.Calendar;
import java.util.GregorianCalendar;
import java.text.DateFormatSymbols;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.ZoneId;

public class Calendar {

public Calendar() {
        super();
        // TODO Auto-generated constructor stub
    }	
	
    public static String Date()
    {
    	//текущая дата рус формата
    	Date currentDate = new Date();
        SimpleDateFormat dateFormat = null;
        
        dateFormat = new SimpleDateFormat();
        
        String str_c = dateFormat.format( currentDate );
        return  str_c;
    }
    
    public static java.sql.Date DateS()
    {

    	LocalDate todayLocalDate = LocalDate.now( ZoneId.of( "America/Montreal" ) );  // Use proper "continent/region" time zone names; never use 3-4 letter codes like "EST" or "IST".
    	java.sql.Date sqlDate = java.sql.Date.valueOf( todayLocalDate );
        return  sqlDate;
    }    
    
    
    public static String Date_data()
    {
        // календарь на текущую дату
        GregorianCalendar c = new GregorianCalendar();
        System.out.print(c.getTime());
        String str_c = c.getTime().toString();
        return  str_c;
}

    
}