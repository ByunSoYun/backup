package com.test.question.q27;

import java.io.File;

public class Q008 {
	
	public static int count = 0;
	public static int dcount = 0;
	
	public static void main(String[] args) {
		//delete 폴더를 삭제하세요 
		 // - 내용물ㅇ 있는 폴더는 삭젤ㄹ 못한다 
		// - 내용물? 파일 (빈폴더)
		 String path = "C:\\Users\\변소윤\\Documents\\카카오톡 받은 파일\\027_파일_디렉토리\\파일_디렉토리_문제\\폴더 삭제";
		 File dir = new File(path);
	

				
				countFile(dir);
				//dir.delete();
				System.out.printf("폴더를 삭제했습니다.\n삭제된 폴더는 %d개이고,파일은 %d개입니다.", dcount, count);

				
			
		 
		 
		 
	}//main

	private static void countFile(File dir) {
		
		File[] list = dir.listFiles();
		
		for (File sub : list) {
			if (sub.isFile()) {
				count++;
				
			}
		}
		
		for (File sub : list) {
			if (sub.isDirectory()) {
				
				countFile(sub); //재귀 호출
			}
		}
		
		dcount++;//이 메소드 호출이 곧 폴더 1개가 존재한다.
	}


}

