package com.test.question.q12;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Q13 {
public static void main(String[] args) throws NumberFormatException, IOException {
	
	BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
	
	for(int i =1; ; i++) {
		System.out.println("====================");
		System.out.println("      자판기        ");
		System.out.println("====================");
		System.out.println("1. 콜라   \t700원    ");
		System.out.println("2. 사이다	 \t600원    ");
		System.out.println("3. 비타500\t500원    ");
		System.out.println("--------------------");
		System.out.printf("금액 투입(원) :");
	    int money = Integer.parseInt(reader.readLine()); 
	    System.out.println("--------------------");
	    System.out.printf("음료선택(번호) :");
	    int drink = Integer.parseInt(reader.readLine()); 
	    
	    
	    if (drink == 1) {
	    	System.out.printf("+콜라를 제공합니다.\n+잔돈 %d을 제공합니다.\n",money-700);
	    	System.out.println("계속하시려면 엔터를 입력하세요.");
	     	String enter = reader.readLine();
	     	
	    } else if (drink == 2) {
	    	System.out.printf("+사이다를 제공합니다.\n+잔돈 %d을 제공합니다.\n",money-600);
	    	System.out.println("계속하시려면 엔터를 입력하세요.");
	     	String enter = reader.readLine();
	     	
	    } else if (drink == 3) {
	    	System.out.printf("+비타500을 제공합니다.\n+잔돈 %d을 제공합니다.\n",money-500);
	    	System.out.println("계속하시려면 엔터를 입력하세요.");
	    	String enter = reader.readLine();
	    	
	    	 
	    	 
	    } else {
	    	System.out.println("음료번호 다시 선택해주세요");
	    }
	
	}//for
	}//main
}
