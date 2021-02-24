package com.stackroute.DateTimeEx;

import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;

public class BankDepositExercise {
	
	public static void main(String[] args) {
		String investmentDate = "2020-02-09";
        LocalDate iDate = LocalDate.parse(investmentDate);
        LocalDate mDate = LocalDate.parse("2020-12-27");
		Period duration = Period.between(iDate, mDate);
	
		String ans1 = getMaturityDate(investmentDate, duration);
		System.out.println(ans1);

		String investment = "09/10/2019";
		String maturityDate = "21/06/2020";

		String ans2 = getInvestmentPeriod(investment, maturityDate);
		System.out.println(ans2);
		
	}
	
	public static String getMaturityDate(String investmentDate, Period duration) {

		LocalDate startDate = LocalDate.parse(investmentDate);
		
		int noDays = duration.getDays();
		int noMonths = duration.getMonths();
		int noYears = duration.getYears();
		
		LocalDate d1 = startDate.plusYears(noYears);
		LocalDate d2 = d1.plusMonths(noMonths);
		LocalDate endDate = d2.plusDays(noDays);
		
		String formattedDate = endDate.format(DateTimeFormatter.ofPattern("dd-MM-yyyy"));
		
		return formattedDate;
	}
	
	
	public static String getInvestmentPeriod(String investmentDate, String maturityDate) {
		
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		LocalDate startDate = LocalDate.parse(investmentDate, dtf);
		LocalDate endDate = LocalDate.parse(maturityDate, dtf);
	
		Period p = Period.between(startDate, endDate);
		int x = p.getYears();
		int y = p.getMonths();
		String result = x + " years, " + y + " months";
		
		return result;
	}
}