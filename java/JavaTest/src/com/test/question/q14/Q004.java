package com.test.question.q14;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Q004 {
		public static void main(String[] args) throws IOException {
			BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
			
			int gifsum =0;
			int jpgsum =0;
			int pngsum =0;
			int hwpsum =0;
			int docsum =0;
			
			
			for(int i=1; i<11 ; i++) {  // 10번 입력하니까 루프 10번 돌리게 만듬
			System.out.print("파일명:");
			String file = reader.readLine();
			
				if(file.endsWith(".gif")) {
					gifsum ++;
				}else if (file.endsWith(".jpg")) {
					jpgsum ++;
				}else if (file.endsWith(".png")) {
					pngsum ++;
				}else if (file.endsWith(".hwp")) {
					hwpsum ++;
				}else if (file.endsWith(".doc")) {
					docsum ++;
				}else {
			
				}
				
		
			}//for1
			
			
			// lastIndex로 찾는법 
//			for(int j= 0 ; j<fileName.length(); j++) {
//	            
//	            dot = fileName.lastIndexOf(".");/// '.'이 있는 인덱스 값을 dot에 저장
//	            
//	            ext =fileName.substring(dot+1, fileName.length());  // .을 제외한 확장자명만 저장
//	            
//	            if(ext.equals("gif") == true) { // 확장자명 비교
//	               gif++;
//	               break;
//	            }else if(ext.equals("jpg") == true){
//	               jpg++;
//	               break;
//	            }else if(ext.equals("png") == true) {
//	               png++;
//	               break;
//	            }else if(ext.equals("hwp") == true){
//	               hwp++;
//	               break;
//	            }else if(ext.equals("doc") == true) {
//	               doc++;
//	               break;
//	            }else {
//	               System.out.println("알 수 없는 확장자가 있습니다.");
//	               break;
//	            }
//	            
//	         }
//			
			System.out.printf("gif: %d개 ",gifsum);
			System.out.printf("jpg: %d개 ",jpgsum);
			System.out.printf("png: %d개 ",pngsum);
			System.out.printf("hwp: %d개 ",hwpsum);
			System.out.printf("doc: %d개 ",docsum);
			
			
			
		}//main
}
