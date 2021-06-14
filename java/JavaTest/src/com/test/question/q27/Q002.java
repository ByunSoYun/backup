package com.test.question.q27;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;

public class Q002 {
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		System.out.print("폴더선택 :");
		String InputPath = reader.readLine();
		System.out.print("파일 확장자 :");
		String WantFileExtension = reader.readLine(); // 내가 원하는 파일 확장자
		
		File dir = new File(InputPath);
		
		if (dir.exists()) {
			
			File[] list = dir.listFiles();
			for (File file : list) {	
				int index = file.getName().lastIndexOf("."); // 파일의 마지막 .이 있는 인덱스 
				String RealFileExtension = file.getName().substring(index+1); // 실제 파일의 파일 확장자
				 if(RealFileExtension.equals(WantFileExtension)) {
			          System.out.println(file.getName());
					}
				
			}
		}else {
			System.out.println("해당경로 파일이 없습니다.");
		}
		
	}//main

}
