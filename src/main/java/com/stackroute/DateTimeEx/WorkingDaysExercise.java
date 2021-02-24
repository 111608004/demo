package com.stackroute.DateTimeEx;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.time.temporal.TemporalAdjusters;


public class WorkingDaysExercise {

	public static void main(String[] args) {
		
		List<String> list = getNextMonthsWorkingDays();
		System.out.println(list);
	}

	
	public static List getNextMonthsWorkingDays() {
		
		List<String> list = new ArrayList<> ();
		LocalDate date = LocalDate.now();
		LocalDate start = getStartOfNextMonth();
		//System.out.println(start);
		//DayOfWeek s = start.getDayOfWeek();
		//int m = start.getMonthValue();
		//LocalDate nextm = start.plusMonths(1);
		//System.out.println(start.lengthOfMonth());
		Calendar cal = Calendar.getInstance();

		for(int i = 1; i <= start.lengthOfMonth(); i++) {
			DayOfWeek s = start.getDayOfWeek();
			int v = s.getValue();
			if((v != 6) && (v != 7)) {
				String str = start.format(DateTimeFormatter.ofPattern("dd-MM-yyyy"));
				list.add(str);
				//System.out.println(str);
			}
			start = start.plusDays(1);
		}
		return list;
	}
	
	 public static LocalDate getStartOfNextMonth() {
	        return LocalDate.now().with(TemporalAdjusters.firstDayOfNextMonth());
	    }

}
