package com.test.question.q10;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Calendar;

public class Q006 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		
		System.out.print("음식을 받기 원하는 시각: \n시: ");
		int WantHour = Integer.parseInt(reader.readLine());
		
		System.out.print("분: ");
		int WantMinute = Integer.parseInt(reader.readLine());
		
		Calendar WantTime = Calendar.getInstance();
		WantTime.set(Calendar.HOUR_OF_DAY,WantHour); 
		WantTime.set(Calendar.MINUTE,WantMinute);
		
		Calendar ZzajangTime = Calendar.getInstance();
		ZzajangTime.set(Calendar.HOUR_OF_DAY,WantHour);
		ZzajangTime.set(Calendar.MINUTE,WantMinute-10);

	 
		Calendar ChickenTime = Calendar.getInstance();
		ChickenTime.set(Calendar.HOUR_OF_DAY,WantHour);
		ChickenTime.set(Calendar.MINUTE,WantMinute-18);
	 
		Calendar PizzaTime = Calendar.getInstance();
		PizzaTime.set(Calendar.HOUR_OF_DAY,WantHour);
		PizzaTime.set(Calendar.MINUTE,WantMinute-25);
		
		System.out.printf("짜장면 %d시 %d분 \n", ZzajangTime.get(Calendar.HOUR_OF_DAY),ZzajangTime.get(Calendar.MINUTE));
		System.out.printf("치킨 %d시 %d분 \n", ChickenTime.get(Calendar.HOUR_OF_DAY),ChickenTime.get(Calendar.MINUTE));
		System.out.printf("피자 %d시 %d분 \n", PizzaTime.get(Calendar.HOUR_OF_DAY),PizzaTime.get(Calendar.MINUTE));
	}
}
