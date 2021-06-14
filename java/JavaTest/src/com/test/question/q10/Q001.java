package com.test.question.q10;

import java.util.Calendar;

public class Q001 {
	public static void main(String[] args) {
	
		nowTime();
	
	}//main
	

	public static void nowTime(){
		
	Calendar now = Calendar.getInstance();
	
	
	System.out.printf("현재 시간 : %d시 %d분 %d초",now.get(Calendar.HOUR), now.get(Calendar.MINUTE), now.get(Calendar.SECOND));
	
}
	
}
