package com.test.question.q10;

import java.util.Calendar;

public class Q002 {
	
	
	public static void main(String[] args) {
		
	 Date();
	}

	private static void Date() {
		
		//오늘 태어난 아이의 백일과 첫돌이 언제인지 출력 
		Calendar birthday = Calendar.getInstance();
		//오늘 (시각) +100일 (시간 ) -> add()
		birthday.add(Calendar.DATE, 100 -1); 
		
		
		System.out.printf("백일 : %tF \n" ,birthday );
		
		//** 월, 년 -> 산술연산은 반드시 add()를 가지고 사용 
		
		birthday = Calendar.getInstance();
		
		birthday.add(Calendar.YEAR, 1); 
		
		System.out.printf("첫돌 : %tF  \n",birthday);
		
	}

}
