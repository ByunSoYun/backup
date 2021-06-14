package com.test.question.q3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Q007 {

	public static void main(String[] args) throws IOException{
		
		BufferedReader reader = new BufferedReader (new InputStreamReader(System.in));
		
		System.out.print("섭씨(℃): ");
		
		String Cdegree = reader.readLine();
		double iCdegree = Integer.parseInt(Cdegree); 
		double Fdegree = (iCdegree* 1.8) + 32;
		
		System.out.printf("섭씨 %.1f℃는 화씨 %.1f℉입니다.",iCdegree,Fdegree);
		
	}
}
