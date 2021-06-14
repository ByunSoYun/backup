package com.test.question.q11;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Calendar;

public class Q010 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		System.out.print("년: ");
		int year = Integer.parseInt(reader.readLine());
	
		System.out.print("월: ");
		int month = Integer.parseInt(reader.readLine());
	
		System.out.print("일: ");
		int day = Integer.parseInt(reader.readLine());
	

		
		Calendar enterdate = Calendar.getInstance();
	
		enterdate.set(year,month-1, day);
		
		if (enterdate.get(Calendar.DAY_OF_WEEK) ==  1 ||enterdate.get(Calendar.DAY_OF_WEEK) ==7 ) { 
			System.out.println("입력하신 날짜는 '휴일'입니다. \n 결과가 없습니다.");
		} else {
			System.out.println("입력하신 날짜는 '평일'입니다. \n 해당주의 토요일로 이동합니다.");
		  enterdate.set(Calendar.DAY_OF_WEEK,7);
		  System.out.printf("이동할 날짜는 '%tF'입니다.",enterdate); }
		 
	}

}

