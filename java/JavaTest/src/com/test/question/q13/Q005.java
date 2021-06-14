package com.test.question.q13;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Q005 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		System.out.print("행의 갯수: ");
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		int linenum = Integer.parseInt(reader.readLine());
		
		
			for(int i = 0; i<linenum;i++) {
				for(int j=i+1;j<linenum;j++) {
					System.out.print(" ");
				}
				for(int j=97; j<=97+i; j++) {
					System.out.printf("%c",j);
				}
				for(int j=97+i; j>=97; j--) {
					System.out.printf("%c",j);
				}
				System.out.println();	
			}
			
		}
	}


