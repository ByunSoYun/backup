package com.test.question.q27;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;

public class Q003 {
	public static void main(String[] args) throws IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		System.out.print("파일 이동을 실행합니다.\n 같은 이름을 가지는 파일이 이미 존재합니다. 덮어쓸까요? (y/n)");
		char select = (char) reader.read();
	
		String path = "C:\\class\\java\\file\\AAA\\m4.txt ";
		File file = new File(path);
		
		String path1 = "C:\\class\\java\\file\\BBB\\m4.txt ";
		File file1 = new File(path1);
	
		if(file.exists()) { // 파일이 존재한다면 true
			
			if(file1.exists()) {  //파일1이 존재한다면 true
				
				if(select == 'y') { //덮어쓰기 
					file1.delete();
					file.renameTo(file1);
					System.out.println("파일을 덮어썼습니다.");
					
				}else if(select == 'n') {  // 넘어가기 
					System.out.println("작업을 취소합니다.");
				}else {
					System.out.println("y 또는 n을 입력해주세요.");
				}
				
				
			}else {
				
				boolean result = file.renameTo(file1);
				System.out.println(result);
			}
			
	
		}
	
	
	}//main
	
	
}
