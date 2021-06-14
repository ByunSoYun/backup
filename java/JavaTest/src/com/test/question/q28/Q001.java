package com.test.question.q28;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;

public class Q001 {
	public static void main(String[] args) {
		
		String path = "C:\\Users\\변소윤\\Desktop\\파일_입출력_문제\\이름수정.dat";
		File dir = new File(path);

		      String path2 = "C:\\Users\\변소윤\\Desktop\\파일_입출력_문제\\이름수정_변환.dat";
		      File dir2 = new File(path2);
		      
		      String content ="";
		      
		      try {
		         
		         BufferedReader reader = new BufferedReader(new FileReader(path));
		         BufferedWriter writer = new BufferedWriter(new FileWriter(path2));
		         
		         String line = "";
		         
		         while ((line = reader.readLine()) != null) {

		            if(line.contains("유재석")) {
		               content = line.replace("유재석", "메뚜기");
		            }else {
		               content = line;
		            }
		            System.out.println(content);
		            writer.write(String.format("%s\n",content));
		         }
		         
		         writer.close();
		         reader.close();
		         
		         System.out.println(dir.renameTo(dir2));
		         
		         dir.delete(); //원래있던 파일 삭제

		      } catch (Exception e) {
		         e.printStackTrace();
		      }
		      
		      
		   }//main
		   
		   
		}//Q001
		
		
		      
		  