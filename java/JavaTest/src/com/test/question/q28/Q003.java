package com.test.question.q28;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;

public class Q003 {
	public static void main(String[] args) {
		
		String path = "C:\\Users\\변소윤\\Desktop\\파일_입출력_문제\\성적.dat";
		File file = new File(path);
	
		String line = "";
		  try {
			  String fail = "";
			  String pass = "";
			  BufferedReader reader = new BufferedReader(new FileReader(path));
			  
			  while ((line =reader.readLine()) != null){
				  String[] temp = line.split(",");
				 			
				
				if((Integer.parseInt(temp[1]+temp[2]+temp[3]))/3>60 
						&& Integer.parseInt(temp[1])>40 
						&& Integer.parseInt(temp[2])>40 
						&& Integer.parseInt(temp[3])>40){
						 pass += temp[0]+"\n";
						}else {
						fail += temp[0]+"\n";

						}
				
		  
			  }//while
			 
			  
			  System.out.println("[합격자]");
			  System.out.println(pass);
			  
			  System.out.println("[불합격자]");
			  System.out.println(fail);
			  
			  
		       reader.close();
		        
		
		} catch (Exception e) {
			System.out.println(e);
		}
	}//main

}
