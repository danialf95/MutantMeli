package com.meli.mutant.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TimeZone;

public class Helper {

	
	
	
	 public static Date obtenerFechaLocal() throws ParseException {
	        Date fechaServer = new Date();
	        String formatoFecha = "yyyy-MM-dd HH:mm:ss";
	        TimeZone timeZone = TimeZone.getTimeZone("America/Bogota");
	        SimpleDateFormat formatoTimeZone = new SimpleDateFormat(formatoFecha);
	        formatoTimeZone.setTimeZone(timeZone);
	        SimpleDateFormat formatter = new SimpleDateFormat(formatoFecha);
	        return formatter.parse(formatoTimeZone.format(fechaServer));
	    }
	 
	 
	 public static String generatePersistenceInput(String [] input) throws ParseException {
	        
		 String persistence="[";
		 
		 for (int i = 0; i < input.length; i++) {
			persistence = persistence + input[i];
			if(i!=(input.length-1))
				persistence = persistence + ",";
		   }
		 persistence = persistence + "]";
		    return persistence;
	    }
}
