package com.test.question.q23;

public class Time {
	
	private int hour ;
	private int minute;
	private int second;

 
	public Time() {
//		this.hour = 0;
//		this.minute = 0;
//		this.second = 0;
		
		this (0,0,0);
		}
	
	public Time(int hour, int minute ,int second) {
	
		for(;;) { 
			
//			 if(hour<0 || minute<0 || second<0) {
//			
//	         System.out.println("올바른 시간이 아닙니다.");
//	         break;
//	            }

	         if(hour>24) {
	            hour -= 24;
	         }else if(second >= 60){
	           minute += second / 60;
	            second = second % 60;
	         }else if(minute >= 60) {
	            hour += minute/60;
	            minute = minute % 60;
	         }else {
	            this.hour = hour;
	            this.minute = minute;
	            this.second = second;               
	            break;
	         }
	      }
		
	}


	
	public Time(int minute,int second) {
		this(0,minute,second);
	}
	
	public Time(int second) {
		this(0,0,second);
	}
	
	public String info() {
		return String.format("%d:%d:%d", this.hour,this.minute,this.second);
		
	}
}
