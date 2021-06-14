package com.test.question.q27;

import java.io.File;
import java.util.ArrayList;

public class Q009 {
	public static void main(String[] args) {
		
		File dir = new File("C:\\Users\\변소윤\\Documents\\파일_디렉토리_문제\\크기 정렬");
		ArrayList<File> flist = new ArrayList<File>();
		
		addFile(dir,flist);
		
		for(File file : flist) {
			System.out.println("\t[파일명]\t\t\t[크기]\t\t\t\t\t");
//			File max = ;
//			if(file.length()<)
			System.out.printf("%20s%15s\n",file.getName(),file.length());
		}
		
	}//main
	
	
	//폴더의 위치와 상관없이 모든 폴더 내의 파일들을 찾아 한번에 크기를 비교하고, 크기가 큰 순으롤 정렬하시오.
	
	
		private static void addFile(File dir,ArrayList<File> flist) {
			
			File[] list = dir.listFiles();
			for (File file : list) {
				if(file.isFile()) {
					flist.add(file);
				}
			}
			
			
			//자식 폴더로 들어가서 동일한 일을 반복 -> 재귀 
			for(File sub : list) {
				if(sub.isDirectory()) {
					addFile(sub,flist);
				}
			}
			
			
		}//deleteFile



	}//Q009

Q009.java
신

유형
자바
크기
2KB (2,042바이트)
사용한 용량
2KB (2,042바이트)
위치
신시내
소유자
신시내
수정한 날짜
오전 9:17, 신시내
열어본 날짜
내가 오후 8:16에 열어봄
생성한 날짜
오전 9:18
설명 추가
뷰어가 다운로드할 수 있음
package com.test.question.q27;

import java.io.File;
import java.util.ArrayList;

public class Q009 {
	public static void main(String[] args) {
		
		//폴더의 위치와 상관없이 모든 폴더 내의 파일들을 비교하고, 크기가 큰 순으로 정렬하시오.

		String path = "C:\\027_파일_디렉토리\\파일_디렉토리_문제\\크기 정렬";
		File dir = new File(path);
		
		
		ArrayList<File> flist = new ArrayList<File>();
		
		addFile(dir, flist);
		
		sort(flist);
		
		System.out.println("파일이름\t\t\t\t길이\t폴더");
		
		for(int i=0; i<flist.size(); i++){
			
			//C:\027_파일_디렉토리\파일_디렉토리_문제\크기 정렬\BBB\win.ini
			String filepath = flist.get(i).getPath();
			int index = filepath.lastIndexOf("\\");
			String dirname = filepath.substring(0, index);  //C:\027_파일_디렉토리\파일_디렉토리_문제\크기 정렬\BBB
			dirname = dirname.substring(dirname.lastIndexOf("\\")+1);  //BBB
			System.out.printf("%-24s\t%dKB\t%s\n"
					, flist.get(i).getName()
					, flist.get(i).length()/1024
					, dirname);
		}
		
	}//main
	

	private static void sort(ArrayList<File> flist) {
		
		for(int i =flist.size()-1; i>0; i--) {
			for(int j=0; j<i; j++) {
				if(flist.get(j).length()>flist.get(j+1).length()) {
					File temp = flist.get(j);
					flist.set(j, flist.get(j+1));
					flist.set(j+1, temp);
				}
			}
		}
	}//sort


	private static void addFile(File dir, ArrayList<File> flist) {
		
		File[] list = dir.listFiles();
		
		for(File file : list) {
			if(file.isFile()) {
				flist.add(file);
			}
		}
		
		for(File sub : list) {
			if(sub.isDirectory()) {
				//재귀 호출
				addFile(sub, flist);
			}
		}
				
	}//addFile
	
}//Q009

//버블정렬
//int[] list = new int[5];
//int temp;
//for(int i=list.length-1; i>0; i--) {
//	for(int j=0; j<i; j++) {
//		if(list[j]>list[j+1]) {
//			temp = list[j];
//			list[j]=list[j+1];
//			list[j+1] = temp;
//		}
//	}
//}