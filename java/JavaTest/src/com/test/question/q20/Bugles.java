package com.test.question.q20;

import java.util.Calendar;

public class Bugles {
	private int price;
	private int size;
	private Calendar creationTime;
	private int expiration;
	Calendar now = Calendar.getInstance();
	 
	 
	 public void setSize(int size) throws Exception {
	      this.size = size;
	      if(size==300 ) {
	    	 price = 850;
	    	  
	      }else if(size== 500) {
	    	  price = 1200;	
	      }else if(size == 850) {
	    	  price = 1950;	
	      }else{
	    	  throw new Exception("올바른 용량이 아닙니다.");
	      }
	 }
	 
	 public int getPrice() {
		      return this.price;
	 }  
	 
	 public Calendar setCreationTime(Calendar creationTime) {
		 return this.creationTime = creationTime;
		 
	 }
	 
	 public int getExpiration() throws Exception {
		 
		 long gap = creationTime.getTimeInMillis() -now.getTimeInMillis();
	     gap =gap/1000/60/60/24/365;
		 
	     if(size == 300) {
	    	 gap=+7;
	    	 expiration = (int) gap;
	     }else if(size == 500) {
	    	 gap=+10;
	    	 expiration = (int) gap;
	     }else if(size == 850) {
	    	 gap=+15;
	    	 expiration = (int) gap;
	     }else {
	    	 throw new Exception("올바른 용량이 아닙니다.");
	     }
	
		 return expiration;
}

	    public void eat() {
			
			if (this.expiration <= 0) {
				System.out.println("유통 기한이지나 먹을 수 없습니다.");
			} else {
				System.out.println("과자를 맛있게 먹습니다.");
			}
			
		}//eat
}//Class
