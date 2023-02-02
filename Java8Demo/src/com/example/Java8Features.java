package com.example;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.Period;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.Arrays;
import java.util.Optional;
import java.util.StringJoiner;

/*
 * pkg - java.time
 * Date & Time - 
 *  LocalDate
 *  LocalTime
 *  LocalDateTime
 *  Period
 *  ZoneId - Internationalization - software adopting to various region's
 *  ZoneDateTime
 *  
 * java.util.StringJoinerClass
 * java.util.OptionalClass
 * Nashorn - engine helps to run JS code in command line
 *  
 */

public class Java8Features {
	
	
	int x = 100;
	static int y = 1000;

	public static void main(String[] args) {
		// Parallel Array Sorting.
		int[] intArr = { 10, 7, 14, 19, 9, 5, 45 };
		double[] dblArr = { 10.00, 23.56, 34.11 };
		String[] strArr = { "aa", "cc", "dd" };

		System.out.println(intArr); // [I@75a1cd57
		System.out.println(strArr); // [Ljava.lang.String;@515f550a
		System.out.println(dblArr); // [D@626b2d4a

		for (int i = 0; i < intArr.length; i++) {
			System.out.println(intArr[i]);
		}
		System.out.println("Before Sorting: " + Arrays.toString(intArr));

		// Arrays.parallelSort
//		Arrays.parallelSort(intArr);
//		
//		System.out.println("After Sorting: "+Arrays.toString(intArr)); [5, 7, 9, 10, 14, 19, 45]

		// [10, 7, 14, 19, 9, 5, 45]
		// Arrays.parallelSort(intArr, 0, 4); // [7, 10, 14, 19, 9, 5, 45]
		Arrays.parallelSort(intArr, 1, 5);
		System.out.println("After Sorting: " + Arrays.toString(intArr)); // [10, 7, 9, 14, 19, 5, 45]

		String str1 = new String("Hello");
		String str2 = new String("World");

		String str3 = String.join(" ", str1, str2);
		System.out.println(str3); // Hello World

		// split
		String ph = "91-044-34567890";
		String[] strArr1 = ph.split("-");
		System.out.println(Arrays.toString(strArr1)); // [91, 044, 34567890]

		System.out.println(strArr1[0]); // 91
		System.out.println(strArr1[0] + strArr1[1]); // 91044

		System.out.println(Integer.parseInt(strArr1[0]) + Integer.parseInt(strArr1[1])); // 135

		// trim() -

		// StringJoinerClass - Joins multiple strings
		// java.util -pkg

		// new StringJoiner("Delimiter");
		StringJoiner sj = new StringJoiner(" ");
		sj.add("Hello").add("World!");
		System.out.println(sj); // Hello World!

		// new StringJoiner("delimiter", "prefix", "suffix")
		StringJoiner sj1 = new StringJoiner(" ", "[", "]");// [Hello World!]
		sj1.add("How").add("Are").add("You");

		System.out.println(sj1);// [How Are You]

		// merge()
		System.out.println(sj.merge(sj1)); // Hello World! How Are You

		// ==========================================================
		// java.time - pkg
		// LocalDate, LocalTime, LocalDateTime, Period, ZoneId, ZoneDateTime
		// Get system current date
		LocalDate ld = LocalDate.now();
		System.out.println(ld); // 2023-01-31

		System.out.println(ld.getYear()); // 2023
		System.out.println(ld.getMonth()); // JANUARY
		System.out.println(ld.getDayOfMonth()); // 31

		System.out.printf("%d/%s/%d", ld.getDayOfMonth(), ld.getMonth(), ld.getYear()); // dd/MM/yyyy
		System.out.println();

		System.out.println("Date after 6 month: ");
		System.out.println(ld.plusMonths(6)); // 2023-07-31
		System.out.println("Date after 5 days: ");
		System.out.println(ld.plusDays(5)); // 2023-02-05
		// minus

		// representing our own date
		System.out.println();
		System.out.println("DOB ");
		LocalDate dob = LocalDate.of(2000, 10, 15);
		System.out.printf("%d-%d-%d", dob.getDayOfMonth(), dob.getMonthValue(), dob.getYear()); // 2023-02-05

		// LocalTime
		LocalTime lt = LocalTime.now();
		System.out.println(lt); // 12:33:13.664515800

		System.out.printf("%d:%d:%d", lt.getHour(), lt.getMinute(), lt.getSecond()); // 12:35:2
		System.out.println();

		// LocalDateTime
		LocalDateTime ldt = LocalDateTime.now();
		System.out.println(ldt); // 2023-01-31T12:37:22.941259800

		System.out.println(ldt.getDayOfMonth()); // 31
		System.out.println(ldt.getMonthValue()); // 1
		System.out.println(ldt.getHour()); // 12

		// Period
		System.out.println();
		System.out.println("Period between() ");
		System.out.println(Period.between(dob, LocalDate.now()).getYears() + " Years old");

		// ZoneId, ZoneDateTime
		// get system zone
		System.out.println(ZoneId.systemDefault()); // Asia/Calcutta

		ZoneId zid = ZoneId.of("Asia/Tokyo");
		ZonedDateTime lt1 = ZonedDateTime.now(zid);
		System.out.println("ZonedDateTime : " + lt1);

	
		String[] strArr2 = new String[5];
		strArr2[0] = "aa";
		strArr2[4] = "dd";
		String[] strArr3 = new String[strArr2.length];

		try {
			// Optional class - java 1.8
			// java.util - pkg
			//y= 200;
			
			
			for (int i = 0; i < strArr2.length; i++) {
				strArr3[i] = strArr2[i].toUpperCase(); // NullPointerException
			}
			
			System.out.println(Arrays.toString(strArr3));
			
		    // some  more lines of code 
		} catch (Exception e) {
			e.printStackTrace();
		}
		// ["AA", , null, null, null, "DD"];
		// ["AA", , NULL, NULL, NULL, "DD"];
		
		// java.util.Optional- Container class
		// of(), ofNullable(), empty()
		
		for (int i = 0; i < strArr2.length; i++) {
			//Optional<String> opt = Optional.of(strArr2[i]);
			Optional<String> opt = Optional.ofNullable(strArr2[i]);
			if(opt.isPresent()) {
				strArr3[i] = strArr2[i].toUpperCase(); 
			} 
		}
		System.out.println();
		System.out.println(Arrays.toString(strArr3));
		
		// nashorn- JS engine, runs JS code using JVM - Introduced in Java 1.8
		// Mozilla Rhino engine
		// jdk/bin/jjs.exe - command line tool
		// jrunscript
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		

		/*
		 * 
		 * 
		 * // ================== // Optional class
		 * 
		 * // returns empty optional Optional<Object> opt= Optional.ofNullable(null);
		 * System.out.println(opt); // Optional.empty
		 * 
		 * 
		 * //Optional<Object> opt1= Optional.of(null); //System.out.println(opt1); //
		 * NullPointerException
		 * 
		 * // return non empty optional Optional<Object> opt2=
		 * Optional.ofNullable("Hello"); System.out.println(opt2); // Optional[Hello]
		 * 
		 * // return non empty optional Optional<Object> opt3= Optional.of("Hello");
		 * System.out.println(opt3); //Optional[Hello]
		 * 
		 * // returns empty optional Optional<Object> opt4= Optional.empty();
		 * System.out.println(opt4); // Optional.empty
		 * 
		 * String[] str = new String[3]; str[0] = "aa"; str[1] = "bb";
		 * 
		 * for(int i=0;i<3; i++) {
		 * 
		 * System.out.println(str[i].toUpperCase());
		 * 
		 * // Optional<String> opt5= Optional.ofNullable(str[i]); //
		 * if(opt5.isPresent()) { // System.out.println(str[i].toUpperCase()); // } }
		 * 
		 * // Nashorn // jjk - command line tool
		 * 
		 * 
		 */
	}

}
