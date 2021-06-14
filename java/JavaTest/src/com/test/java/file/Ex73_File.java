package com.test.java.file;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Scanner;

public class Ex73_File {
	   
	   private static Scanner scanner;
	   private final static String DATA;
	   
	   private static ArrayList<Memo> list; // memo.dat의 대리자
	   
	   static {
	      
	      scanner = new Scanner(System.in);
	      DATA = "dat\\memo.dat";
	      list = new ArrayList<Memo>();
	      
	   }
	   
	   public static void main(String[] args) {
	      
	      /*
	           
	      어제: 파일 입출력만 사용
	      1. 정보 쓰기
	         - BufferedWriter
	      2. 정보 읽기
	         - BufferedReader
	      3. 정보 삭제하기     
	         - BufferedReader -> BufferedReader -> BufferedWriter
	         
	      
	      오늘: 파일 입출력(백업장치) + 컬렉션(주대상) 사용
	      - 프로그램 시작: 파일 모든 내용 읽기 -> 메모리 저장(컬렉션)
	      - 프로그램 사용: 메모리 조작(컬렉션)
	      - 프로그램 종료: 메모리 저장(컬렉션) -> 파일 모든 내용 쓰기
	      
	      [콘솔 메모장]
	      
	      기능
	      1. 메모 쓰기
	      2. 메모 읽기
	      3. 메모 삭제
	      
	      데이터
	      1. 메모
	         e. 번호(숫자) - 유일한 값(식별자)
	         a. 작성자(문자열)
	         b. 메모 내용(문자열..)
	            - 한줄 메모
	            - 여러줄 메모(v)
	         c. 날짜(2021-04-30 12:00:00)
	         d. 중요도(A, B, C)
	         
	      2. 파일
	         - memo.dat
	      3. 형식
	         이름, 날짜, 중요도
	         메모내용
	         =====
	         
	           
	           
	           
	           
	      */
	      
	      load(); // 텍스트파일 -> 배열
	      
	      System.out.println(list);
	      
	      
	      System.out.println("[메모장]");
	      
	      boolean loop = true;
	      
	      while (loop) {
	         
	         //메뉴 출력
	         //선택
	         //분기
	         
	         String sel = menu();
	         
	         if (sel.equals("1")) {
	            
	            add();
	            
	         } else if (sel.equals("2")) {
	            
	            list();
	            
	         } else if (sel.equals("3")) {
	            
	            delete();
	            
	         } else {
	            
	            loop = false;
	            
	         }
	         
	         
	      } // while
	      
	      System.out.println("메모장을 종료합니다.");
	      
	      save(); //ArrayList<Memo> -> memo.dat
	      
	      
	   }//main
	   
	   private static void save() {
	      
	      try {
	         
	         BufferedWriter writer = new BufferedWriter(new FileWriter(DATA));
	         
	         for (Memo memo : list) {
	            
	            //2,아무개,2021-03-26 17:15:05,B
	            //퇴근때 마트 장보기
	            //돼지고기,상추,쌈장
	            
	            writer.write(String.format("%s, %s, %s, %s\n%s==========\n", memo.getSeq(), memo.getName(), memo.getRegdate(), memo.getPriority(), memo.getContent()));
	            
	            
	         }
	         
	         writer.close();
	         
	      } catch (Exception e) {
	         System.out.println(e);
	      }
	      
	   }

	   private static void load() {
	      
	      //BufferedReader
	      // - memo.dat -> ArrayList<Memo> list
	      
	      try {
	         
	         BufferedReader reader = new BufferedReader(new FileReader(DATA));
	         
	         String line = "";
	         
	         while ((line = reader.readLine()) != null) {
	            
	            //Memo 객체 1개 생성
	            Memo memo = new Memo();
	            
	            //2,아무개,2021-03-26 17:15:05,B
	            //퇴근때 마트 장보기
	            //돼지고기,상추,쌈장
	            //==========
	            
	            String[] temp = line.split(",");
	            
	            memo.setSeq(temp[0]);
	            memo.setName(temp[1]);
	            memo.setRegdate(temp[2]);
	            memo.setPriority(temp[3]);
	            
	            //메모 내용 읽기
	            String tempContent = "";
	            while (!(line = reader.readLine()).equals("==========")) {
	               
	               tempContent += line + "\r\n";
	               
	            }
	            
	            memo.setContent(tempContent);
	            
	            //메모 1건 -> Memo 객체 1개에 옮겨 담기
	            
	            list.add(memo);
	            
	         }//while
	         
	         reader.close();
	         
	      } catch (Exception e) {
	         
	         System.out.println(e);
	      }
	      
	   }

	   private static void delete() {
	      
	      System.out.println("[메모 삭제]");
	      
	      System.out.println("[번호]\t[이름]\t[내용(일부분)]");
	      
	      for (Memo memo : list) {
	         
	         String content = memo.getContent();
	         
	         if (content.length() > 10) {
	            
	            content = content.substring(0, 10) + "..";
	            
	         }
	         
	         System.out.printf("%s\t%s\t%s\n", memo.getSeq(), memo.getName(), content);
	         
	      }
	      
	      System.out.print("삭제할 번호: ");
	      String seq = scanner.nextLine();
	      
	      //향샹된 for문 -> 추가, 삭제 작업을 하면 안된다. -> 에러 발생
	      //         -> 읽기 전용!!!!
	      
	      for (int i=0; i<list.size(); i++) {
	         
	         if (list.get(i).getSeq().equals(seq)) {
	            
	            //메모 삭제
	            list.remove(i);
	            
	         }
	         
	      }
	      
	      pause();
	      
	   }

	   private static void list() {
	      
	      System.out.println("[메모 읽기]");
	      
	      System.out.println("[번호]\t[이름]\t[내용(일부분)]");
	      
	      for (Memo memo : list) {
	         
	         String content = memo.getContent();
	         if (content.length() > 10) {
	            
	            content = content.substring(0, 10) + "..";
	            
	         }
	         
	         System.out.printf("%s\t%s\t%s\n", memo.getSeq(), memo.getName(), content);
	         
	         
	      }
	      System.out.println("0\t목록 끝내기");
	      
	      System.out.print("자세히 메모 선택(번호): ");
	      
	      String seq = scanner.nextLine();
	      
	      if (seq != "") {
	    	  if(!seq.equals("0")) {
	         
	         System.out.println("[메모 상세보기]");
	         
	         Memo memo = getMemo(seq);
	         
	         System.out.println("번호: " + memo.getSeq());
	         System.out.println("이름: " + memo.getName());
	         System.out.println("날짜: " + memo.getRegdate());
	         System.out.println("중요도: " + memo.getPriority());
	         System.out.println("내용: " + memo.getContent());
	    	  }
	      }
	      
	      
	      
	      pause();
	      
	   }

	   private static Memo getMemo(String seq) {
	      
	      for (Memo memo : list) {
	         if (memo.getSeq().equals(seq)) {
	            return memo;
	         }
	      }
	      
	      return null;
	      
	   }

	   private static void add() {
	      
	      System.out.println("[메모 쓰기]");
	      
	      System.out.print("이름: ");
	      String name = scanner.nextLine();
	      
	      System.out.print("중요도(A, B, C): ");
	      String priority = scanner.nextLine();
	      
	      System.out.print("내용(exit:입력종료): ");
	      String content = "";
	      
	      while (true) {
	         
	         String temp = scanner.nextLine();
	         
	         if (temp.equals("exit")) {
	            break;
	         }
	         
	         content += temp + "\r\n";
	         
	      }
	      
	      //입력 받은 내용 -> memo.dat //지금X
	      //입력 받은 내용 -> ArrayList<Memo>에 추가 //지금o
	      
	      Memo memo = new Memo();
	      
	      memo.setName(name);
	      memo.setPriority(priority);
	      memo.setContent(content);
	      
	      Calendar now = Calendar.getInstance();
	      memo.setRegdate(String.format("%tF %tT", now, now));
	      
	      memo.setSeq(getSeq()); // 마지막 메모 번호 + 1
	      
	      list.add(memo);
	      
	      //System.out.println(list);
	      
	      pause();
	      
	   }

	   private static String getSeq() {
	      
	      int max = 0;
	      
	      for (Memo m : list) {
	         if (Integer.parseInt(m.getSeq()) > max) {
	            max = Integer.parseInt(m.getSeq());
	         }
	      }
	      
	      return (max + 1) + "";
	   }

	   private static String menu() {
	      
	      System.out.println("====================");
	      System.out.println("1. 메모 쓰기");
	      System.out.println("2. 메모 읽기");
	      System.out.println("3. 메모 삭제하기");
	      System.out.println("4. 종료");
	      System.out.println("====================");
	      System.out.print("선택: ");
	      
	      String sel = scanner.nextLine();
	      
	      return sel;
	      
	   }
	   
	   private static void pause() {
	      
	      System.out.println("엔터를 누르면 다음으로 진행합니다.");
	      
	      scanner.nextLine(); // Block
	      
	   }

	}