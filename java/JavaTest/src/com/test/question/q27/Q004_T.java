package com.test.question.q27;

import java.io.File;

private static Q004 = "C:\\Users\\변소윤\\Documents\\카카오톡 받은 파일\\027_파일_디렉토리\\파일_디렉토리_문제\\음악 파일\\Music";

public class Q004_T {
	public static void main(String[] args) {
		//Ex70_File.java
		q004();
		
		
		
		
	}//main



private static void q004(){
	//음악 파일이 100개 있다. 파일명 앞에 일련번호를 붙이시오.
	//listFiles() + renameTo()
	
	int temp = 0;
	
	File dir = new File(Q004);
	File[] list = dir.listFiles();//***
	
	for (int i=0; i<list.length; i++) {
		//System.out.println(list[i].getName());
	
		String filename = list[i].getName();
		if(filename.toLowerCase().endsWith(".mp3")) {
			
			//음악 파일만.
			//System.out.println(filename);
			
			filename = String.format("[%03d]%s", (temp+1),filename);//***
			System.out.println(filename);
			temp++;
			
			//파일명 바꾸기 
			list[i].renameTo(new File(Q004 +"\\" +filename));
		}
	}
	
}




}

}