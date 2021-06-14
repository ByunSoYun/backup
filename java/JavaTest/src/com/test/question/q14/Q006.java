package com.test.question.q14;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Q006 {
	public static void main(String[] args) throws IOException {
	 BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
	System.out.print("주민등록번호:");
	String jumin = reader.readLine();

	int sum = 0;
	int num = 0;
		if (jumin.length()==14  || jumin.length()==13) {
				if(jumin.length()==13) {
					for(int i =0; i<8 ; i++) {
							num = jumin.charAt(i)*(i+1);
					 		sum += num;
					 		num = (jumin.charAt(8)*2) +(jumin.charAt(9)*3)+(jumin.charAt(10)*4)+(jumin.charAt(11)*5);
					 		sum = num + sum;
					 		int num2 = sum /11; 
							int num3 = 11-num2;
							if(num3 == 10){
								  if(jumin.charAt(12) == 0){
									  System.out.println("올바른 주민번호입니다.");
								  }else {System.out.println("올바르지않은 주민번호입니다.");
									  
								  }
								
								if (jumin.charAt(12)==num3) {
									System.out.println("올바른 주민번호입니다.");
									break;
								}
							  if(jumin.charAt(12) == 1){
								  System.out.println("올바른 주민번호입니다.");
							  }else {System.out.println("올바르지않은 주민번호입니다.");
								  
							  }
							
						
							}else {
								System.out.println("올바르지않은 주민번호입니다.");
								break;
							}
						}
				} else if(jumin.length()==14){
					for(int i =0; i<8 ; i++) {
						if(i==6) {
							continue;
						}else {
							 	num = jumin.charAt(i)*(i+1);
					 			sum += num;
						}
								num = (jumin.charAt(9)*2) +(jumin.charAt(10)*3)+(jumin.charAt(11)*4)+(jumin.charAt(12)*5);
						 		sum = num + sum;
						 		int num2 = sum /11; 
								int num3 = 11-num2;
								if(num3==11) {
									  if(jumin.charAt(13) == 1){
										  System.out.println("올바른 주민번호입니다.");
									  }else {System.out.println("올바르지않은 주민번호입니다.");
										  
									  }
									}
								if(num3 == 10){
									  if(jumin.charAt(13) == 0){
										  System.out.println("올바른 주민번호입니다.");
									  }else {System.out.println("올바르지않은 주민번호입니다.");
										  
									  }
									}
								if (jumin.charAt(13)==num3) {
								
									System.out.println("올바른 주민번호입니다.");
									break;
									
								}else {
									System.out.println("올바르지않은 주민번호입니다.");
									break;
								}
					}//for2
				
				} else {
					System.out.println("올바르지않은 주민번호입니다.");
				}
				
		}//while

	}//main
}