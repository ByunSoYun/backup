package com.test.question.q16;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Q006 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		System.out.print("행,열 수 입력하시오 : ");
		int nums = Integer.parseInt(reader.readLine());
		
		int [][] num = new int [nums][nums];
		
		int n = 1;
		
		int total =0;
		
		
		for(int i =0 ; i<num.length; i++) {
			int jsum =0;
			for(int j = 0; j<num[0].length; j++) {
				if(j==num[0].length-1 && i==num.length-1) {
					num[i][j] = total;
				}// total 구하기 
				
				else if(j==num[0].length-1) {
					jsum =num[i][j];
					total += jsum;
				}// j가 마지막자리일때  값을 구하고 토탈값 구하기 
				else if(i==num.length) {
					int isum = 0;
					for(int k=0;k<num[0].length;k++) {
						isum += num[k][j];
						
					}
					isum = num[i][j];
					
				}
				else {
					num[i][j] = n;
					jsum +=n;
					n++;
				}
			}//forj
		}//fori
		
				
			
			output(num);
		}//main
	
	private static void output(int [][] num) {
		for(int i=0; i<num.length; i++) {
			for (int j=0; j<num[0].length; j++) {
				System.out.printf("%4d",num[i][j]);
			}
			System.out.println();
		
		}
	}


}

		
		
		
		
		
		
//		int isum = 0;
//		int jsum = 0;
//		int n = 1;
//		for(i=0; i<=num.length; i++) {
//			int isum = 0;
//			if(i==num.length-1) {
//				isum += i;
//				 isum = n ;
//				 for(j=0; j<num[0].length;j++) {
//					 if(j==num[0].length-1) {
//						 jsum += j;
//						 jsum = n;
//					 }
//					 
					 
					 
					 
					 
					 
					 
					 
//					 
//					 
//				 }
//			}else {
//				n++				
//			}
//				
//			}//if
