package com.test.question.q27;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;

public class Q001 {
	public static void main(String[] args) throws IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		System.out.print("파일경로: ");
		String InputPath = reader.readLine();
		
		File file = new File(InputPath);
		
		int index = InputPath.lastIndexOf(".");
		String fileExtension = InputPath.substring(index+1);
		
		System.out.printf("파일명 : %s\n종류 : %s파일\n파일 크기 : %,dB", file.getName(),fileExtension,file.length());

	}//main
		
}


