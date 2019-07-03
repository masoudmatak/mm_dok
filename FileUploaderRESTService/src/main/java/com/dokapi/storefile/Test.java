/*
Owner and programmer: Masoud Mohammadi 2019
Copywrite is limited and it is only the owner of the program code
can allow the use of it in a system if legal overcoming occurs. 
All rights are reserved for the owner of the code.
This is part of a system design and implementation of this 
Document Management System is based on a particular application area. 
This implementation is based on observation of the use in certain industries. 
In the case of copyright infringement, the owner is entitled to legal 
action and will require legal action through court.
*/
package com.dokapi.storefile;

import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

public class Test {

	public static void main(String[] args) {
	/*
		System.out.println("NNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNN "+System.getProperty("os.name"));
		String osname=System.getProperty("os.name");
		if(osname.toUpperCase().startsWith("W")) {
			System.out.println(" it i swindows");
		}
		
		int mili=1000*60*60*24*365*1000;
		Timestamp timestamp1 = new Timestamp(System.currentTimeMillis()+mili);
		Timestamp timestamp2 = new Timestamp(System.currentTimeMillis());
		
			*/
		
		//Calendar calendar = new GregorianCalendar(2019,3,1,13,24,56);

		//int year       = calendar.get(Calendar.YEAR+3);
		
		//calendar.set(calendar.get(Calendar.YEAR)+1, 2, 1);
	
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy MMM dd HH:mm:ss");	
		Date date=new Date();
		Calendar calendar2 = Calendar.getInstance();
		calendar2.setTime(date);
		System.out.println(sdf.format(calendar2.getTime()));
		int antalYEAR=10;
		calendar2.set(calendar2.get(Calendar.YEAR)+antalYEAR,calendar2.get(Calendar.MONTH),calendar2.get(Calendar.DATE));
		//System.out.println(calendar2.get(Calendar.YEAR)+","+(calendar2.get(Calendar.MONTH)+1) +","+calendar2.get(Calendar.DATE)+","+calendar2.get(Calendar.HOUR));
		System.out.println(sdf.format(calendar2.getTime()));
		
		
		
		
		String DATE_FORMAT = "yyyy/MM/dd HH:mm:ss";
		    DateFormat dateFormat = new SimpleDateFormat(DATE_FORMAT);
		// Get current date
        Date currentDate = new Date();
        System.out.println("date : " + dateFormat.format(currentDate));

        // convert date to localdatetime
        LocalDateTime localDateTime = currentDate.toInstant().atZone(ZoneId.systemDefault()).toLocalDateTime();
        System.out.println("localDateTime : " + dateFormat.format(localDateTime));

        // plus one
        localDateTime = localDateTime.plusYears(1).plusMonths(1).plusDays(1);
        localDateTime = localDateTime.plusHours(1).plusMinutes(2).minusMinutes(1).plusSeconds(1);

        // convert LocalDateTime to date
        Date currentDatePlusOneDay = Date.from(localDateTime.atZone(ZoneId.systemDefault()).toInstant());

        System.out.println("\nOutput : " + dateFormat.format(currentDatePlusOneDay));
		
	}

}
