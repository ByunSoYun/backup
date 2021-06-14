package com.test.question.q4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Q002 {
	public static void main(String[] args) throws IOException {
		

BufferedReader reader = new BufferedReader (new InputStreamReader(System.in));

System.out.print("이름 : ");

String name = reader.readLine();

System.out.println(getName(name));
	
	}//main

	public static String getName(String name) { 
		System.out.printf("고객 : %s",name);
		return "님";
		
	}

}
