package br.com.ghidini.banco.utils;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public class Utils {
	
	public static Long differenceInDays(LocalDate initDate, LocalDate endDate) {
		
		return initDate.until(endDate, ChronoUnit.DAYS);

	}

}
