package com.test.question.q20;

import java.util.Calendar;

public class Bugle_MainClass {
	public static void main(String[] args) throws Exception {
		Bugles snack = new Bugles();
		snack.setSize(500);
		Calendar c = Calendar.getInstance();
		c.set(2021, 4-1, 10);      
	    snack.setCreationTime(c);
	    System.out.println("가격: "+snack.getPrice() +"원");
		System.out.println("유통기한:"+snack.getExpiration()+"일 남았습니다.");
		snack.eat();
		
		Bugles snack2 = new Bugles();
		snack2.setSize(300);
		Calendar c2 = Calendar.getInstance();
		c2.set(2021, 4-1, 10);      
		snack2.setCreationTime(c2);
		System.out.println("가격: "+snack2.getPrice() +"원");
		System.out.println("유통기한:"+snack2.getExpiration()+"일 남았습니다.");
		snack2.eat();
	}
}
