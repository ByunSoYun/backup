package com.test.java;

public class Task3 {
	public static void main(String[] args) {
		String Date1 = "2020-01-01";
		String Date2 = "2020-01-02";
		String Date3 = "2020-01-03";
		
		String Detail1= "카페라테";
		String Detail2 = "돼지불백";
		String Detail3 = "마트 장본것들";
		String Detail4 = "교통 카드 충전";
		String Detail5 = "편의점";
		
		int money1 = 4800;
		int money2 = 8500;
		int money3 = 125840;
		int money4 = 45000;
		int money5 = 16200;
		
		
		System.out.println("[날짜}		[내역]		[금액]");
		System.out.println("---------------------------------------");
		System.out.print(Date1 +"\t"+ Detail1+"\t"+"\t"); 
		System.out.printf("%,d원", money1);
		System.out.println();
		System.out.print(Date1 +"\t"+ Detail2+"\t"+"\t"); 
		System.out.printf("%,d원", money2);
		System.out.println();
		System.out.print(Date2 +"\t"+ Detail3+"\t"); 
		System.out.printf("%,d원", money3);
		System.out.println();
		System.out.print(Date3 +"\t"+ Detail4+"\t"); 
		System.out.printf("%,d원", money4);
		System.out.println();
		System.out.print(Date3 +"\t"+ Detail5+"\t"+"\t"); 
		System.out.printf("%,d원", money5);

		
		
	}

}
