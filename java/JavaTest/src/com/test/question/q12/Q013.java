package com.test.question.q12;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Q013 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		for(int i=1; i<=10; i++) {
		System.out.println("====================");
		System.out.println("      자판기        ");
		System.out.println("====================");
		System.out.println("1. 콜라   \t700원    ");
		System.out.println("2. 사이다	 \t600원    ");
		System.out.println("3. 비타500\t700원    ");
		System.out.println("--------------------");
		
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
	   
	    
	    System.out.printf("금액 투입(원) :");
	    int money = Integer.parseInt(reader.readLine()); 
	    System.out.println("--------------------");
	    System.out.printf("음료선택(번호) :");
	    int drink = Integer.parseInt(reader.readLine()); 
	    
	    
	    if(drink==1) {
	    	System.out.print("+콜라를 제공합니다");

	    } e
	
	
	
	
	
	
	
	
		}//for
	}//main

}
