package com.test.java;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Ex22_for {
	public static void main(String[] args) throws NumberFormatException, IOException {
		
		//Ex22_for.java
		
		
		//프로그래밍을 잘하잘려면 어떻게 해야합니까?
		//->자료구조,알고리즘 공부해라 >얼만큼. .> 수십년..

		
		
		/*
		 반복문 
		 -실행,블럭 내의 코드를 원하는 횟수만큼 반복 실행하는 제어 
		 
		 for문 

		if () {
		
		}
		
		switch() {
		
		}
		
		for (초기식; 조건식; 증가식){
			실행문;
		}
		
		 */
	
		//m1();
		//m2();
		//m3();
		//m4();
		//m5();
		//m6();
		//m7();
		//m8();
		//m9();
		m10();
	}//main

	
	
	private static void m10() throws IOException {
		//무한 루프 사용 
		//요구사항] 사용자 입력 > 숫자(마음대로) > 누적 구하기 
	
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		
		int sum = 0;
		
		//CLI : Command Line Interface
		//GUI : Graphic User Interface
		
		int i = 0;
		//몇개를 받을지? > 사용자 결정 > 무한루프
		for(i = 1; ; i++) {
			System.out.printf("[%d회]숫자입력(종료 0을 입력): ",i);

			int num = Integer.parseInt(reader.readLine());
			
			if (num==0) {
				break;
			}
			
			sum += num;
		}//for
		//총 5개의 숫자를 입력하셨고, 그 합은 75입니다.
		System.out.printf("총 %d개의 숫자를 입력하셨고, 그 합은 %d입니다.\n",i,sum);
	
	}



	private static void m9() {
		
		//System.out.println(Integer.MAX_VALUE);
		// 2147483647 
		
		// 무한 루프 > 반복 횟수가 무한대 
//		for(int i =1; i >0; i++ ) { // 왜 언젠가 멈출까 ? -> int , overflow 
//			
//			System.out.println(i);
//		}
		
		//무한 루프 
		//1. 의도적으로 -> 어떤 행동이 횟수가 미정일 때 ..
		//2. 실수로 -> 조심 
	
		
		//-> 의도적으로 만들때 
//		for (;;) {
//			System.out.println("명시적인 무한루프");
//		}
	}

	private static void m8() {
		
		//분기문 
		//- break, continue 
		
		//1. break
		//- 자신이 속한 제어문을 탈출한다.
		//-if 문은 인식 못함
		
		//2. continue 
		// - 자신이 속한 제어문의 처음으로 돌아가세요 
		// - if문은 인식 못함 
		
		for (int i =1; i<=10; i++) {
			
			if(i ==5 ) {
				//반복문을 횟수와 상관없이 원할때 탈출하는 역할 
				//break; //중단
				
				//continue 이후의 코드를 실행하지 않고 반복문의 처음으로 돌아가는 역할 
				
				continue; // 일시 중단
			}
				System.out.println(i);
		}
		System.out.println();
		
		//학교 선생님 + 진로상담 (30명)
		for (int i =1; i<=30; i++) {
		
//			if (i ==16) {
//			break;
//			}
			
			if (i ==14 || i == 23 || i == 28) {
				
				continue;
			}
			
			
			
			System.out.printf("선생님이 %d번 학생을 상담합니다. \n",i);
		
		}
		
		
		
	}

	private static void m7() {

		//난수
		//- 임의의 수
		//- 난수 생성기
		
		//1.Math 클래스 
		// - 수학과 관련 기능 제공 (난수 기능 포함)
		
		//2.Random 클래스 
		// - 난수 전용 
		
		//0.0~0.99999999999 사이의 값
		
		//Returns a double value with a positive sign, greaterthan or equal to 
		// 0.0 and less than 1.0.Returned values are chosen pseudorandomly with (approximately)uniform distribution from that range. 
		 // 0(inclusive) ~ 1(exclusive)
		
		//System.out.println(Math.random());
		
		for (int i=1; i<=10; i++) {
			//System.out.println(Math.random());
			
			//0~9 사이의 난수
			//0.0 -> 0
			//0.9 -> 0
			//1.0 -> 1
			//1.9 -> 1 
			//2.0 -> 2
			//2.9 -> 2
			//..
			//9.0 -> 9
			//9.9 -> 9
			
			//System.out.println((int)(Math.random()*10));
		
			//1-10 사이의 난수 
			//System.out.println((int)(Math.random()*10) + 1 );
			
			//5~8 사이의 난수 
			//1.앞의 숫자 0으로 만들기 (-5)
			//0~3 
			//System.out.println((int (Math.random()*4)) +5 );
			
			
			//로또
			//1~45
			//0~44
			
			System.out.println((int) (Math.random()*45) + 1 );
		}
		
		
	}

	private static void m6() throws NumberFormatException, IOException {
		//요구사항] 사용자에게 5개의 숫자를 입력받아 그 숫자들의 합을 구하시오.
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		
		int sum = 0;
		
	
		for(int i= 1; i<=5; i++) {
			
		
			System.out.print("숫자 입력: ");
			
			int num = Integer.parseInt(reader.readLine());
			
			sum += num;
		}
		System.out.println(sum);
	}

	private static void m5() {
		
		// 실행(디버그 없이) Ctrl + F11 
		// 실행(디버그 모드): F11 (breakpoint가 동작함)-> 블포 실행전에 멈춤
		//-F5 (라인을 하나씩 실행한다)
		//- Variables 창 (현재 상태의 변수와 값을 실시간으로 보여준다)
		//- F8(나머지 코드를 한번에 실행한다)
		
		int sum=0;
		//int sum; -> null 상태 ( 연산이나 행동의 대상이 될수 없다.) -> 0과 다른의미 
		
		for (int i=1; i<=10; i++ ) {
			sum += i;
		}
		
		System.out.println(sum);
	}

	private static void m4() {

		//Loop -> 자주하는 행동 -> 누적값 구하기 
		//요구사항] 숫자 1에서 부터 100000까지의 합을 구하시오.
		
		int sum = 1 + 2 + 3 + 4 + 5 + 6 + 7 + 8 + 9 + 10 ;
		System.out.println(sum);
		
		//무언가의 누적값을 구하는 방법 
		//1. 누적 변수를 선언한다. 보통 누적 변수는 (영향을끼치지 않는)0으로 초기화된다.
		int sum2 = 0;
		
		//2. 누적 대상을 얻기 위한 제어문을 만든다.
		for (int i =1; i<=10; i++) {
			
		//3. 누적 변수에 누적 대상을 더한다.
		//The local variable sum2 may not have been initialized
		//초기화 되지 않은 변수는 연산 불가 
		//0 + 1
		//(0+1)+2
		//((0+1)+2) + 3
		//((0+1)+2) + 3 + 4
			
			sum2 = sum2 +i;
	}
		System.out.println(sum2);
		
		
		//요구사항] 3에서 7까지 더하시오 
		sum = 0; //누적 변수 생성 + 초기화 (0)
		
		for(int i = 3; i<= 7; i++) {
			sum += i;
		}
		System.out.println(sum);
	
	}//m4

	private static void m3() throws NumberFormatException, IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		System.out.print("원하는 단: ");
		
		//구구단 출력 
		//-5단 
		int dan = Integer.parseInt(reader.readLine());
		
		//5 x 1 = 5
		//5 x 2 = 10 
		//5 x 3 = 15 
		//...
		//5 x 9 = 45 
		
		for (int i=1; i<=9; i++) {
			
			System.out.printf("%d x %d = %2d\n",dan,i,dan*i);
		}
	}//m3

	private static void m2() {
		
		//for문 목적
		//1. 반복 횟수 제어 -> 루프 변수 값을 사용해서..-> 너무쉬움
		//2. 루프 변수 값 제어 -> 쉬움 ~ 어려움(*****)
		
		//요구사항] 숫자를 1에서부터 10까지 출력해주세요
		
//		System.out.println(1);
//		System.out.println(2);
//		System.out.println(3);
//		System.out.println(4);
//		System.out.println(1);
//		//-> for문 생각나야함
//		
		//제어문 내의 지역변수에 대해서..
		//지역변수
		// - 메소드내에서 선언한 변수 > 생명주기(영역) > 메소드를 영역으로..
		// - 제어문내에서 선언한 변수 > 생명주기(영역) > 제어문를 영역으로..
		
		int num = 10;
		String result ="0";
		if (num >0) {
			 result = "통과";
		}
		
		System.out.println(result); //result cannot be resolved to a variable
		
		int n = 1;
		
		for (int i =1; i<=10; i++) {
			
			//지역변수 (for문을 지역으로 하는..)
			//= *** for문이 반복할 떄마다 생성됐었다가 소멸된다 (************)
			//int n = 1;
			
		
			
			System.out.println(n);
			
			n++;
			
			
		}
		
		//최종 & 우리의 결론 (선택 )
		//- 루프 변수의 역할이란? 단순히 횟전수를 제어하는것 뿐만 아니라.. 요구에 필요한 값을 제어(제공)하는데 사용된다(중요!!어려움)
		for (int i=1 ,i<=10; i++) {
		 System.out.println(i);
		}
		System.out.println();
	
		//요구사항 ] 숫자 1~10 까지 출력 단, 홀수만 출력
		for (int i =1; i<=10; i++) {
			
			if(i%2 ==0) {
			 System.out.println(i);
			}
			System.out.println();
		}	
		
		
	// 루프 변수의 변화를 잘 파악했다 !!!!!!!11
		for (int i =1; i<=10; i+=2) {
		
			 System.out.println(i);
			}
			System.out.println();
	
	
			for (int i =2; i<=10; i+=2) {
				
				 System.out.println(i);
				}
				System.out.println();
	
				
			//요구사항 ] 27에서부터 158까지 7의 배수만 출력하시오 
				
				for (int i =28; i<=158; i+=7) {
					
					// System.out.println(i);
					System.out.printf("%d x %2d = %3d\n",i,i,i);
					}
					System.out.println(); 
					
					
			//요구사항 ] 숫자 10에서부터 1까지 출력하시오 
			for (int i=10 , i >1 ; i--) {
				System.out.println(i);
				
			}
			System.out.println();
	
			
			
			for (int i=1; i<=10; i++) {
				System.out.println(11-i);
			}

			System.out.println();
	
	
	
	
	
	
	
	
	}	//m2
	
	
	
	

	

	private static void m1() {
		
		// i ->루프 변수 , Loop Variable -> 회전을 제어하는데 역할
		//초기식 -> int i=1;
		//조건식 -> i<=5
		//증감식 -> i++ (증감연산자를 쓰라고해서 증감식이아니다)
		//초기식 -> 조건식 만족 -> 실행 -> 증감식 -> 초기변수 변화 -> 조건식 만족(반복)/불만족 밖으로 나감)
		
		
		for (int i=1; i<5; i++) {
			
			System.out.println("안녕하세요.");// 실행 x 5
		}
		System.out.println();
		
		
		
		
		
		for (int i=7; i<=11; i++) {
			
			System.out.println("반갑습니다.");// 실행 x 5
		}
		System.out.println();
		
		
		
		for (int i=1; i<=9; i+=2 ) {
			
			System.out.println("안녕~");// 실행 x 5
		}
		System.out.println();

	
	for (int i=10; i>=6; i-- ) {
		
		System.out.println("방가!!");// 실행 x 5
	}
	
	
	
	}//m1
	
	
	
	
	
	
	
}
