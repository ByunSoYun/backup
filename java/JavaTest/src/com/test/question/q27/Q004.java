package com.test.question.q27;

import java.io.File;



public class Q004 {
	public static void main(String[] args) {
		
		String path = "C:\\Users\\변소윤\\Documents\\카카오톡 받은 파일\\027_파일_디렉토리\\파일_디렉토리_문제\\음악 파일\\Music";
		File dir = new File(path);
		
		File[] list = dir.listFiles(); // 폴더안의 파일들을 리스트배열로 뽑음
		
		int num = 1;
		for (File file : list) {
			  String newPath = String.format("[%03d] %s",num,file.getName()); //파일 이름 앞에 숫자 넣어주기 
			  File newName = new File(newPath); 
			  System.out.println(newName.getName());
			  num++;// 숫자를 증가 시켜 포문 돌때마다 1씩증가해 파일이름앞에 숫자가 순차적으로 1씩 증가 
			  
		  }
		
	}	
		
		
		
}


