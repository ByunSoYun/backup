package com.test.question.q28;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.Calendar;
import java.util.Scanner;

public class Q007 {
	 
	public final static String DATA;

	 
	 static {
		 DATA = "C:\\Users\\변소윤\\Desktop\\파일_입출력_문제\\출결.dat";
		 }
		   
	 
	public static void main(String[] args) {
		//2018-8-8,하석게,8:16,16:13
	String line ="";
	
		try {
			 BufferedReader reader = new BufferedReader (new FileReader(DATA));
			 String [] temp = line.split(",");
			 Calendar attendance = Calendar.getInstance();
			
			 
			 if(temp[2]){
				 
				 
			 }
		} catch (Exception e) {
			System.out.println(e);
		}
		
	}
}



