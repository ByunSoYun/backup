package com.test.java.file;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.Scanner;

public class Ex72_File {
	
	private static Scanner scan ; // (한클래스 내의 모든 곳에서 쓸 공용 )
	private final static String DATA;
	
	static {
		scan = new Scanner(System.in);
		DATA = ".\\dat\\student.dat";
		
		//DATA = "C:\\class\\java\\JavaTest\\dat\\student.dat"// 절대경로 
	}
	
	public static void main(String[] args) {
		
//		
//		File file = new File(DATA);
//		System.out.println(file.exists()); 
//		위의 파일이 진짜 있는지 없는지? 확인 -> 있다 True 없다 False 나엄~
		
		//학생 정보 관리
		// - 파일 입출력 기반 
		// - 데이터를 지속적으로 관리 (파일 실행 꺼도)(****) -> 데이터 구조 설계( 저장할 파일을 생성 + 저장할 구조(패턴))
		//	-JavaTest >dat 폴더생성
		//		- student.dat 파일 생성 
		
		// - 데이터 정의
		// 		- 학생 정보?
		//			- 이름, 나이, 국어, 영어, 수학
		//			- 홍길동,14,100,90,80
		
		//데이터 조작 -> CRUD -> Create,Read,Update,Delete
		
		//기능 
		// - 학생 정보 저장하기 (C)
		// - 학생 정보 목록 (R)
		// - 학생 정보 삭제하기 (D)
		
		
		System.out.println("[학생 정보 관리]");
		
		boolean loop = true;
		while(loop) {
			
			//메뉴출력
			//선택 
			//분기 
			
			String seq = menu();
			
			if(seq.equals("1")) {
				add();
			}else if(seq.equals("2")) {
				list();
			}else if(seq.equals("3")) {
				delete();
			}else {
				loop = false;
			}
		}
		
		System.out.println("프로그램 종료");
		
		
	}//main
		
	private static void pause() {
		System.out.println("엔터를 누르시면 다음으로 진행합니다.");
		scan.nextLine();//Block
	}

	
	
	private static void delete() {

		System.out.println("[학생 삭제]");
		
		try {
			
			BufferedReader reader = new BufferedReader(new FileReader(DATA));
			
			String line = "";
			
			System.out.println("[이름]");
			
			while ((line =reader.readLine()) != null){
				
				
			String[] temp = line.split(",");
			
			System.out.printf("%s\n", temp[0]);

				
			}
			reader.close();
			
			System.out.println("삭제할 학생을 선택하세요.");
			System.out.print("선택(이름): ");
			
			String name = scan.nextLine();

			
			reader = new BufferedReader(new FileReader(DATA));
			
			String result = "";//누적변수
			line = "";
			
			while ((line =reader.readLine()) != null){
				
				
				String[] temp = line.split(",");
				
				if (!temp[0].equals(name)) {
					result += line +"\r\n";
				}
			
				
			}
			reader.close(); // 빼려는거 빼고 나옴 
			
			BufferedWriter writer = new BufferedWriter(new FileWriter(DATA,true));
			// 빼려는거 빼고 덮어쓰기 
			writer.write(result);
			writer.close();
			
			
		} catch (Exception e) {
			System.out.println(e);
		}
		
		pause();
	}

	private static void list() {
		
		System.out.println("[학생 목록]");
		String line = "";
		
		System.out.println("[이름]\t[나이]\t[국어]\t[영어]\t[수학]");
		try {
			BufferedReader reader = new BufferedReader(new FileReader(DATA));
			
			while ((line =reader.readLine()) != null){
				// 모든학생 탐색 
				//System.out.println(line);
				
				String[] temp = line.split(",");
				System.out.printf("%s\t%5s\t%5s\t%5s\t%5s\n"
									, temp[0]
									, temp[1]
									, temp[2]		
									, temp[3]
									, temp[4]);

				
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		pause();
	}

	private static void add() {
		
		Util util = new Util();
		
		System.out.println("[학생 추가]");
		
		System.out.print("이름: ");
		String name = scan.nextLine();
		
		String age = util.get("나이");
		String kor = util.get("국어");
		String eng = util.get("영어");
		String math = util.get("수학");
		
		try {
			
			
			BufferedWriter writer = new BufferedWriter(new FileWriter(DATA,true));
			
			//홍길동,12,100,90,80
			
			writer.write(String.format("%s,%s,%s,%s,%s\n",name,age,kor,eng,eng));
			
			writer.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		pause();
	}

	private static String menu() {
		System.out.println("===================");
		System.out.println("1. 학생 정보 등록하기");
		System.out.println("2. 학생 정보 목록보기");
		System.out.println("3. 학생 정보 삭제하기");
		System.out.println("4. 종료");
		System.out.println("===================");
		System.out.println("선택: ");
	
		String sel = scan.nextLine();
		
		return sel;
				
	}
}
