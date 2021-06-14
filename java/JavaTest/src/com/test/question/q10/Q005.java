package com.test.question.q10;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Calendar;

public class Q005 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		System.out.print("아빠 생일(년) : ");
		int DadBirthYear = Integer.parseInt(reader.readLine());
		
		System.out.print("아빠 생일(월) : ");
		int DadBirthMonth = Integer.parseInt(reader.readLine());
			
		System.out.print("아빠 생일(일) : ");
		int DadBirthDay = Integer.parseInt(reader.readLine());
			
		
		System.out.print("딸 생일(년) : ");
		int DaughterBirthYear = Integer.parseInt(reader.readLine());
			
		System.out.print("딸 생일(월) : ");
		int DaughterBirthMonth = Integer.parseInt(reader.readLine());
		
		System.out.print("딸 생일(일) : ");
		int DaughterBirthDay = Integer.parseInt(reader.readLine());
		
		
		
		Calendar DadBirth = Calendar.getInstance();
		DadBirth.set(DadBirthYear,DadBirthMonth,DadBirthDay); //아빠 태어난 정보 최종 
		
		
		
		
		long DadBirthTick = DadBirth.getTimeInMillis(); //아빠 tick
		

		Calendar DaughterBirth = Calendar.getInstance();
		DaughterBirth.set(DaughterBirthYear,DaughterBirthMonth,DaughterBirthDay);//딸 태어난 정보 최종 
		
		long DaughterBirthTick = DaughterBirth.getTimeInMillis(); //딸 tick
		
		
		
		
		System.out.printf("아빠는 딸보다 총 %d일을 더 살았습니다.", ((DaughterBirthTick-DadBirthTick)/1000/60/60/24));
	}//main

}
