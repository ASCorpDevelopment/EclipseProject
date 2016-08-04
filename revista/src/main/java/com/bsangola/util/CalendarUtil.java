package com.bsangola.util;

import java.util.Calendar;
import java.util.Date;

public class CalendarUtil {
	
	public static final Date dataDeHoje(){
		Calendar dataHoje = Calendar.getInstance();
		dataHoje.set(Calendar.SECOND, 0);
		dataHoje.set(Calendar.MILLISECOND, 0);
		return dataHoje.getTime();
	}
}
