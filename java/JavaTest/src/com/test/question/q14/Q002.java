package com.test.question.q14;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Q002 {
	public static void main(String[] args) throws IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		System.out.print("이메일: ");
		String txt = reader.readLine();
		
		//아이디찾기 
		
		int index  = txt.indexOf('@');
		
		if(index > -1) {
			String ID = txt.substring(0,index); 
			System.out.printf("아이디: %s \n", ID);
			String mail = txt.substring(index+1);
			System.out.printf("도메일: %s ", mail);
		}
		
	}

}
