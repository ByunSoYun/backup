package com.test.question.q27;

import java.io.File;

public class Q006 {
	public static void main(String[] args) {
		String path = "C:\\Users\\변소윤\\Documents\\카카오톡 받은 파일\\027_파일_디렉토리\\파일_디렉토리_문제\\파일 제거"; 
		File dir = new File(path);
		int num = 0;
		File[] list = dir.listFiles();
		
		for (File file : list) {
				if(file.length() == 0) {
					file.delete();
					num++;
				}
			
			
		}
		System.out.printf("총 %d개의 파일을 삭제했습니다.",num);
		
		
		
	}

}
