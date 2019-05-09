package br.gov.cursoSelenium.utils;

import java.text.DateFormat;
import java.text.MessageFormat;
import java.text.SimpleDateFormat;
import java.time.DayOfWeek;
import java.util.Calendar;
import java.util.Date;

public class DataUtils {

	public static Date obterDatasComDiferencaDias(int dias){
		Calendar calendar = Calendar.getInstance();
		calendar.add(Calendar.DAY_OF_MONTH, dias);
		return calendar.getTime();		
	}
	
	public static String obterDataFormatada(Date data){
		DateFormat form = new SimpleDateFormat("dd/MM/YYYY");
		return form.format(data);
		
	}
	
}
