package com.test.question.q11;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Q008 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		System.out.println("[들어온 시간]");
		System.out.print("시: ");
		int inhour = Integer.parseInt(reader.readLine());
		System.out.print("분: ");
		int inminute = Integer.parseInt(reader.readLine());
	
		System.out.println("[나간시간]");
		System.out.print("시: ");
		int outhour = Integer.parseInt(reader.readLine());
		System.out.print("분: ");
		int outminute = Integer.parseInt(reader.readLine());
	
		if(outminute-inminute>=0) {
			int parkhour = outhour - inhour;
			int parkminute = outminute - inminute;
			int charge = (((parkhour*60) + parkminute - 30)/10) *2000;
			System.out.printf("주차 요금은 %d원 입니다",charge);
			
			
		} else { 
			int parkhour = outhour - inhour - 1;
			int parkminute = outminute - inminute +60;	
			int charge = (((parkhour*60) + parkminute - 30)/10) *2000;
			System.out.printf("주차 요금은 %d원 입니다",charge);
		}
		
	}
}
