package com.test.question.q13;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Q002 {public static void main(String[] args) throws NumberFormatException, IOException {
	BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    System.out.print("행의 갯수: ");
    int linenum = Integer.parseInt(reader.readLine());
    
    	for(int i=0; i<linenum; i++) {
    		for(int j=i+1; j<linenum; j++) {
    			System.out.print(" ");
    		}
    			for(int j=0; j<=i; j++) {
    				System.out.print("*");
    			}
    			System.out.println();
    	}
    

	}//main
}//Q2
