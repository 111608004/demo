package com.stackroute.DateTimeEx;

//import java.awt.List;
import java.time.LocalDate;
import java.time.Period;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
public class DateTimeExercise {

	static List<Tablet> tablets = new ArrayList<> ();

	
	
	public static void main(String[] args) {
				
		tablets.add(new Tablet("Actos", "sun", LocalDate.of(2019, 10, 13), LocalDate.of(2021, 12, 23)));
		tablets.add(new Tablet("Abenol", "Lupin", LocalDate.of(2020, 8, 17), LocalDate.of(2023, 2, 3)));
		tablets.add(new Tablet("Hytrin", "Sandoz", LocalDate.of(2020, 6, 8), LocalDate.of(2022, 9, 19)));
		tablets.add(new Tablet("Norflex", "Mylan", LocalDate.of(2021, 1, 29), LocalDate.of(2024, 4, 15)));
		
		List<String> list1 = getExpiringTables(26);
		System.out.println(list1);
		System.out.println("----------------\n\n");
		
		List<Tablet> list2 = getExpiringTabletsSorted();
		System.out.println(list2);
		System.out.println("----------------\n\n");
		
		LinkedHashMap<String, String> map1 = getTabletExpiryPeriod();
		System.out.println(map1);
		System.out.println("----------------\n\n");
		
		LinkedHashMap<String, String> map2 = getSameYearExpiry();
		System.out.println(map2);
	}
	
	public static List getExpiringTables(int months) {
		List<String> names =  new ArrayList<String>();
		LocalDate today = LocalDate.now();
		LocalDate d = today.plusMonths(months);
		
		for(int i = 0; i < tablets.size(); i++) {
			if(tablets.get(i).expDate.isBefore(d)) {
				names.add(tablets.get(i).tabletName);
			}
		}
		return names;
	}

	public static List getExpiringTabletsSorted() {
		List<Tablet> list = new ArrayList<> ();
		list = tablets;
	    Collections.sort(list, (x, y) -> x.expDate.compareTo(y.expDate));
		return list;
	}

	
	public static LinkedHashMap getTabletExpiryPeriod() {
		LinkedHashMap<String, String> result = new LinkedHashMap<>();
		String ans = "";
		for(int i = 0; i < tablets.size(); i++) {
			Period p = Period.between(tablets.get(i).getMfgDate(), tablets.get(i).getExpdate());
			//1 year/s 2 month/s 5 day/s
			ans = p.getYears() + " year/s " + p.getMonths() + " month/s " + p.getDays() + " day/s";
			result.put(tablets.get(i).getTabletName(), ans);
		}
		return result;
	}
	
	public static LinkedHashMap getSameYearExpiry() {
		LinkedHashMap<String, String> result = new LinkedHashMap<>();
		LocalDate today = LocalDate.now();
		for(int i = 0; i < tablets.size(); i++) {
			if((today.getYear() == tablets.get(i).getMfgDate().getYear()) && (tablets.get(i).getExpdate().isBefore(today))) {
				result.put(tablets.get(i).getManufacturer(), tablets.get(i).getTabletName());
			}
		}
		return result;
	}
}