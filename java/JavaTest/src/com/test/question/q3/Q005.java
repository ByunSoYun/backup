package com.test.question.q3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Q005 {
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader reader = new BufferedReader (new InputStreamReader(System.in));
		
		System.out.print("한달 수입 금액(원): ");
		String income = reader.readLine();
		int iincome = Integer.parseInt(income);
		
		
		double Tax = iincome * 0.033;
		double AfterTax = iincome - Tax;
	
		System.out.printf("세후 금액(원): %,.0f원 \n", AfterTax);
		System.out.printf("세금(원):%,.0f원 \n", Tax,AfterTax);
		
	

	
				
		
	}

}
