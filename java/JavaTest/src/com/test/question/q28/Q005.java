package com.test.question.q28;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.Scanner;

public class Q005 {
	 public final static String DATA;
	 public static Scanner scan;
	 public final static String DATA1;
	 
	 static {
		    DATA = "C:\\Users\\변소윤\\Desktop\\파일_입출력_문제\\검색_회원.dat";
		    DATA1 = "C:\\Users\\변소윤\\Desktop\\파일_입출력_문제\\검색_주문.dat";
		    scan = new Scanner(System.in);
		 }
	 
	 public static void main(String[] args) {
		 
		 
		 System.out.print("이름: ");
		 String name = scan.nextLine();
		   
		 
		 try {
			 
			 BufferedReader reader = new BufferedReader (new FileReader(DATA));
			 BufferedReader reader1 = new BufferedReader (new FileReader(DATA1));
			 String line = "";
			 String line1 = "";
			 int num = 0;
		     while((line = reader.readLine()) != null) {
		    	 String [] temp = line.split(",");
		    	 if(temp[1].equals(name)) {
		    		 num = Integer.parseInt(temp[0]);
		    		 String address = temp[2];
		    		 while((line1 = reader1.readLine()) != null) {
		    			 String [] temp1 = line1.split(",");
		    			if(num == Integer.parseInt(temp1[3])) {
		    				String tool = temp1[1];
		    				String toolNum = temp1[2];
		    				System.out.println("==== 구매내역 ====");
		    				System.out.println("[번호]\t[이름]\t[상품명]\t[개수]\t[배송지]");
		    				System.out.printf("%3d\t%3s\t%3s\t%3s\t%3s", num,name,tool,toolNum,address);
		    				
		    			}
		    		 }
		    	 
		    	 }
		    }// while 
		     
		     reader.close();
		     reader1.close();
			 
		} catch (Exception e) {
			System.out.println(e);
		}
	 
	 
	 }//main
}//Q005
