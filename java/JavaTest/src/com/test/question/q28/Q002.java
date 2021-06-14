package com.test.question.q28;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;

public class Q002 {
	public static void main(String[] args) {
		
		String path = "C:\\Users\\변소윤\\Desktop\\파일_입출력_문제\\숫자.dat";
		File file = new File(path);
		
		String path2 = "C:\\Users\\변소윤\\Desktop\\파일_입출력_문제\\숫자_변환.dat";
	    File file2 = new File(path2);
	    
	      String content ="";
	      try {
	    	  
	    	  BufferedReader reader = new BufferedReader(new FileReader(path));
		      BufferedWriter writer = new BufferedWriter(new FileWriter(path2));
		         
		         String line = "";
	      
			    while ((line = reader.readLine()) != null) {
			    
			    	//content = line;
			    	
			    	content = line.replace("0", "영");
			    	content = content.replace("1", "일");
			    	content = content.replace("2", "이");
			    	content = content.replace("3", "삼");
			    	content = content.replace("4", "사");
			    	content = content.replace("5", "오");
			    	content = content.replace("6", "육");
			    	content = content.replace("7", "칠");
			    	content = content.replace("8", "팔");
			    	content = content.replace("9", "구");
			    	
			    	System.out.println(content);
			    	
			    	writer.write(content+"\r\n");
				    
		                
			    }
			    
			    writer.close();
		        reader.close();
		        
		    System.out.println("변환 후 다른 이름으로 저장하였습니다.");
		         
		    file.delete(); //원래있던 파일 삭제

			      
	      }  catch (Exception e) {
		         e.printStackTrace();
		     }
	}//main
}//Q002
