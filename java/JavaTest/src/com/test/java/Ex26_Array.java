package com.test.java;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Calendar;

public class Ex26_Array {
	public static void main(String[] args) throws NumberFormatException, IOException {
		
		
		
		//m1();
		//m2();
		//m3();
		//m4();
		//m5();
		//m6();
		//m7();
		//m8();
		//m9();
		//m10();
		//m11();
		
		m12();
		
		//자료구조, 알고리즘 
		//자료구조 -> 배열 (연습 + 제어문)
	}

	private static void m12() {
		//프로젝트 적용 
		//- 데이터 만들기 
		//- 회원 정보 x 100명 
		
		//회원 정보 
		//a. 이름 : 문자열
		//b. 나이 : 숫자
		//c. 성별 : 숫자 (1. 남자 , 2. 여자)
		//d. 주소 : 문자열 
		
		//Math.random() + 배열 
		
		int count = 100;
		String[] name = new String[count];
		int[] age = new int[count];
		int[] gender = new int[count];
		String[] address = new String[count];

		//기초 데이터 -> 임의의 회원 정보를 생성하기 위한 기반 데이터 
		

		
		//이름(성)
		String[] n1 = {"김","이","박","최","정","한","유","조","임","왕"};
		//이름
		String[] n2 = {"대","은","창","미","준","우","나","혜","운","인","영","수","민","호","환","혁","현","희","준","원"};
	
		//주소 
		String[] a1 = {"서울시","인천시","부산시","광주시","대전시"};
		String[] a2 = {"동대문구", "서대문구", "중구", "남구", "북구"};
	     String[] a3 = {"역삼동", "대치동", "성내동", "논현동", "염재동"};
		
		
		
		
		System.out.println( n1[(int)(Math.random()*n1.length)] 
							+n2[(int)(Math.random()*n2.length)]
							+n2[(int)(Math.random()*n2.length)]	);
		
		
		
		for (int i=0; i <count ; i++) {
			
			
			name[i]= n1[(int)(Math.random() * n1.length)]
					 +n2[(int)(Math.random() * n1.length)]
					+n2[(int)(Math.random() * n1.length)];
	
			age[i] = (int)(Math.random()*41) + 19;//0~40 -> 19~59
			
			gender[i] = (int)(Math.random()*2) + 1 ;// 0~1 -> 1~2
		
			address[i] = a1[(int)(Math.random()* a1.length)]
						+" "
						+ a2[(int)(Math.random()* a2.length)]
						+" "
						+ a2[(int)(Math.random()* a2.length)]			
						+" "
						+ ((int)(Math.random()* 330)+1)
						+"번지";
		}
		
		for(int i=0; i<count; i++) {
			System.out.printf("[%s] %d세, %s, %s\n"
								,name[i]
								,age[i]
								,gender[i]==1? "남자": "여자"
								,address[i]);
				
		
		
		}
			
	}	
			
			
			
			
			
	private static void m11() {
		//배열 초기화 리스트, 배열 초기자 (Initializer)
		int[] num1 = new int[5];
		
		for(int i=0; i<num1.length; i++) {
			num1[i] = (i+1) * 100;
		}
		for(int n: num1) {
			System.out.println(n);
		}
		
		int[] num2 = new int[5]; // 152, 45, 36, 98, 354
		
		num2[0] = 152; 
		num2[1] = 45; 
		num2[2] = 36; 
		num2[3] = 98; 
		num2[4] = 354;  
	
		int[] num3 = new int[] {152, 45, 36, 98, 354}; // 배열 초기자 
		int[] num4 = {152, 45, 36, 98, 354}; //***
		
		String[] name = {"홍길동", "아무개", "하하하"};
		
		boolean[] flag = { true, false, false, true, false};
		
		char[]cs = { 'A', 'B','C' };
		
	
	
	}

	private static void m10() {
		// 값형 vs 참조형 
		int n;//null
		String s;//null
		
		//지역 변수(***)는 초기화하지 않으면 사용 불가능하다.
		//System.out.println(n);
		//System.out.println(s);

		//초기화해야할 값이 정해지지 않았지만 일단 초기화를 해야 하는 경우
		
		//참조형(주소값) 변수는 null로 초기화를 할 수 있다.
		s =null;
		s= "";
		
		//값형 변수는 절대로 null로 초기화를 할 수 없다.
		//n = null;
		n = 0;
		
		//------------------------------------
		
		//배열의 특징(참조형의 특징) 중 하나
		// - 배열은 방을 만들면 개발자의 의도와 상관없이 모든 방이 특정 값으로 초기화가 된다.  
		
		// 어떤값으로 초기화?(***)
		//1. 정수배열 > 0
		//2. 실수 배열 > 0.0
		//3. 문자형 배열 > '\0' (null문자, 문자코드값(0))
		//4. 논리 배열 > false
		//5. 참조형 배열 > null
		
		int[] num =new int[5];
		
		System.out.println(num[0]); //num[0] 자료형 ->int 
		System.out.println(num[1]); 
		System.out.println(num[2]); 
		System.out.println(num[3]); 
		System.out.println(num[4]);
		System.out.println();
		
		double[] num2 = new double[3];
		System.out.println(num2[0]);
		
		char[] list1 = new char[3];
		System.out.println(list1[0]);
		System.out.println((int)list1[0]);
		
		boolean[] list2 = new boolean[3];
		System.out.println(list2[0]);
		
		String[] list3 = new String[3];
		System.out.println(list3[0]);
		
		
	}

	private static void m9() {
		
		String[] name = new String[5];
		
		name[0] = "홍길동";
		name[1] = "아무개";
		name[2] = "유재석";
		name[3] = "강호동";
		name[4] = "신동엽";
	
		//배열 탐색 -> for문을 사용해서 배열의 요소(Element)에 접근하기
		for(int i =0; i<name.length; i++) {
			System.out.println(name[i]);
			name[i] += "님"; // 수정 
		}
		System.out.println();
		
		//제어문 -> 또 다른 for 문 -> 향상된 for문 (Enhanced for Statement)
		// - 배열이나 컬렉셜을 대상으로만 사용이 가능하다.(iterator를 지원하는 자료형에 한해서..)
		// - 루프 변수가 없다. > 안정성 높음 +코드 간결함
		// - 배열의 모든 요소를 순차적으로 (****) 자동 탐색한다. -> 다른 방식으로 탐색 불가능 
		// - 속도가 일반 for문보다 빠르다
		// - 읽기 전용 반복문 : 요소의 값을 수정할 수 없다 -> 요소의 값을 수정하면 안된다!!
		
		
		
		//for (변수 : 집합) {
		//
		//}
		
		for(String temp : name) {
			System.out.println(temp);
			temp = "고객: " + name; //수정 -> 고객: 홍길동님 -> 나중에 사라지게되기 때문에 수정 x  
		}
		System.out.println();
	
		
		for(String temp : name) {
			System.out.println(temp);
		}
		System.out.println();
		
		int[] num = new int[10];
		
		//쓰기 -> 일반 for문 
		for (int i=0; i<num.length; i++) {
			num[i]= (int)(Math.random()*100) +1; // 1~100
		}
		//읽기 -> 일반 for문 of 향상된 for문
		for(int n: num)
			System.out.println(n);
	}
	
	

	private static void m8() {
		
		//베열 복사(참조형 복사)
		//1.얕은 복사 , Shallow Copy
		//2.깊은 복사, Deep Copy
		
		int[] num1 = new int[3];
		
		num1[0] =100;
		num1[1] =200;
		num1[2] =300;
		
		int[] num2; // new int[3]; -> 복사할 변수는 실제 배열을 만들 필요가 없다.
		
		//얕은 복사
		num2 = num1;
		
		int[] num3 = new int[3];
		
		num3[0] =100;
		num3[1] =200;
		num3[2] =300;
		
		int[] num4 = new int[4]; // 배열을 꼭 만들어야 한다!!
		
		//깊은 복사 
		for(int i=0; i<num3.length; i++) {
			//int = int
			//값형 복사(데이터 복사)
			num4[i] = num3[i];
		} 
		num3[0] = 500;
		
		output(num3);
		output(num4);
		
		//참조형 복사 
		//1. 변수끼리 복사 -> 얕은 복사 -> 원본을 건들이면 복사본도 수정된다.
		//2. 실제 공간끼리 복사 ->깊은 복사 -> 원본을 건드려도 복사본 영향을 받지 않는다.
	}

	private static void m7() {
		
		//값형 복사 vs 참조형 복사
		
		
		
		//값형 복사 -> 하나를 건들여도 각각 따로이기 때문에 주변에 영향x
		// -Side Effect 없다
		int a = 10;
		int b;
		
		b = a;
		System.out.println(a);
		System.out.println(b);
		
		a++;
		
		System.out.println(a);
		System.out.println(b);
		 System.out.println();
		 System.out.println();
		 
		
		//배열 복사 (참조형복사)
		// -Side Effect 있다!!
		//- 복사된 변수가 있었을 때 그 중 하나를 조작하면 나머지도 영향을 받는다.(주의!!!!!!!!!!)
		int[] num1 = new int[3];
		
		num1[0] = 100;
		num1[1] = 200;		
		num1[2] = 300;
		
		output(num1);
		 
		 int[] num2 = new int[3];
		 //*********** -> 그림 참조!!
		 //int[] = int[] 끼리 복사 -> 아무문제 x
		 //***// - 모든 참조형 변수끼리의 복사는 데이터 복사가 아닌 참조 주소 복사가 일어난다.
		 //heap에 있는 값들을 복사하는것이 아니라 
		 //num1에 있는 100번지를 200번지에 복사 -> num2는 100번지가댐  -> 나중에 200번지는 GC

		 
		 num2 = num1;
		
		 output(num2);
		 
		 num1[0] = 500;
		 
		 output (num1);
		 output (num2);// num1[0]의 수정이 num2[0]의 수정으로 반영 ? num1[0]의 숫자만 바꿧는데 num2의 숫자도 바뀜; -> 그림으로 이해  
	}

	private static void output(int[] num) { //int [] num = num1;
		 for(int i=0; i<num.length; i++) {
			 System.out.printf("%d ", num[i]);
		 }
		 System.out.println();
		
	}

	private static void m6() {
		//배열을 만드는 목적
		// -> 한번에 변수를 여러개 만들기 위해서 
		// -> 같은 자료형 + 같은 성격 데이터 다량으로 저장하기 위한 공간 필요 
		
		int[] kor = new int[3]; // int방 x 3개
		kor[0] = 100; //국어점수
		kor[1] = 90; //국어점수
		kor[2] = 80; //영어점수 -> 컴파일o, 런타임o ,데이터x

		int[] score = new int[3];
		score[0] = 100; //국어점수
		score[1] = 90; //영어점수
		score[2] = 80; //수학점수
		
		
		
		
		System.out.println(kor[0]);//국어점수
		System.out.println(score[1]);//???
		
		//[index] 표기법 > Indexer(인덱서)
		//score[0]
		
		
		//메모리 구조 
		// - 값형과 참조형(모든자료형)은 메모리에 공간이 한번 할당되면 그 공간의 크기를 변경할 수 없다.
		// - 메모리에 잡힌 공간은 변경이 불가능하다.
		// - 모든 지역 변수는 값형, 참조형에 상관없이 무조건 Stack 영역에 생성된다.
		//1. 값형(8가지)
		// - 데이터가 변해도 공간의 크기가 변하지 않는다
		
		//2. 참조형 (String, Array, Calendar, Math, BufferedReader...)
		// - 데이터에 따라 공간의 크기가 일정하지 않다.
		// - 공간의 크기를 미리 예측 불가능하다.
		
		//값형, 원시형 -> stack 어딘가에 공간이 잡힘 -> 값이 바껴도 공간이 안바뀌기때문에 문제x
		
		
		int n = 10;
		//0000 0000 0000 0000 0000 0000 0000 1010 (4byte)
		n = 100000000; //로 바꿔도  -> 공간은 변함x 
		//0000 1001 1000 1001 0110 1000 0000 (4byte)
		boolean b = true;
		
		double d = 3.14;
		
		//참조형  -> 몇바이트 짜리 공간 ? 변수는 Stack에 저장 참조형의 데이터는 모두 heap에 저장댐 -> 주소 달림 
		String s1 = "홍길동"; //->한글자당 2바이트 -? 6바이트
		String s2 = "안녕하세요"; // ->10바이트
		
	
		s1 = "반갑습니다"; 
		// ->s1으로 갔는데 주소가있음 (데이터가 저장된곳이아님 )-> heap으로감 데이터, 주소저장 -> s1에 기존에 홍길동의 주소를 지우고 교체된 주소 저장 -> 홍길동 주소가 끊김(참조가 끊김) -> GC(garbage collector)가 홍길동 가져가서버림 (ex)"홍길동"->"홍길동."이면 홍길동에 .을 더한것이아니라 홍길동 대신 홍길동.으로 교체된것이다. 
		s2 = "하하";
		
		
		//s1?
		System.out.println(n);//-> 데이터가 stack에 바로 있음
		System.out.println(s1); //->데이터가 없고 주소가 있음 -> 데이터가 있는 주소를 알아 heap으로 이동 -> 읽어서 가져감 
		
		String s3 = "a";
		s3 = "ab";
		s3 = "abc";
		
		int[] num = new int[3]; //int x 3 = 12byte
		num = new int[5]; //int x 5 = 20byte
		
		int[] num2 = new int[3]; // 모든 주소 저장값 = 4byte -> 3개 공간 못넣음 -> 첫번째 주소만 넣음
		
		num2[0] = 100;
		//num2-> 대표주소 400 으로감 -> []값보고 몇번째 방인지 확인 
		num2[2] = 300;
		
		System.out.println(num2[2]);
		
		String[] name = new String[3];
		
		name[0] = "홍길동";
		name[1] = "아무개";
		name[2] = "하하하";
		// name의 방 3개 heap에 생김 (500번지라고생각)-> name에 500번지 -> 공간에다가 데이터를 못넣어서 또다시 주소를 넣어 불러와야함 
		
		System.out.println(name[2]); //name 찾아감 500번지로가서 몇번쨰방인지 확인 또 그 데이터값의 주소를 가서 데이터 값 얻어옴 (코드상에서는 보이지 않음) 
		
	}//m6

	private static void m5() throws NumberFormatException, IOException {
		// 배열의 성질
		//- 배열의 길이가 불변(Immutable)이다. > 한번 만들어진 배열의 방 갯수는 수정이 불가능하다.
		//> 방을 더 만들거나, 있는 방을 삭제할 수 없다.> 배열에 들어갈 데이터의 갯수를 미리 충분히 예측해서 최대값의 근접한 길이로 잡는다(조금더 크게)
		
		int[] num = new int [5];
		
		
		//추후에 변경 불가!!!
		
		//- 자바의 배열은 동적할당이 가능하다. > 자바 배열의 길이는 런타임에서 결정할 수 있따.
		//int[] list = new int[5]; //정적할당
		
		 BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		 System.out.print("숫자:");
		 int n = Integer.parseInt(reader.readLine());

	
		int[] list = new int[n]; // 동적할당 
		
		System.out.println(list.length);
	}

	private static void m4() {
		// 배열 + 여러 자료형 
		
		// 정수 배열 (byte, short, int,)
		byte[] list1 = new byte[3];
		list1[0] = 10;
		System.out.println(list1[0]);
		
		//실수형 배열(float,double)
		double[] list2 = new double[3];
		list2[0]= 3.14;
		System.out.println(list2[0]);
		//변수를 여러개 만드는것을 편하게해줌 
		
		//문자형 배열(char)
		char[] list3 = new char[3];
		list3[0] = 'A';
		System.out.println(list3[0]);
		
		//논리형 배열(boolean)
		boolean[] list4 = new boolean[3];
		list4[0] = true;
		System.out.println(list4[0]);
		
		//참조형 타입 배열 (*************************)
		//- 문자열은 참조형에 속하지만 사용법은 값형과 동일하다.
		String[] list5 = new String[3];
		list5[0] = "홍길동";
		System.out.println(list5[0]);
		
		
		//모든 자료형으로 배열을 생성할 수 있다
		Calendar[] list6 = new Calendar[3];
		list6[0] = Calendar.getInstance();
		System.out.printf("%tF\n", list6[0]);
	
	
	
	}
	private static void m3() {
		// 요구사항 ] int 숫자 -> 1~10까지 저장 
		
		int[] num = new int[10];
		//int num[] = new int [10];
		
		//배열안의 방 10개 -> 숫자 대입
		//배열 탐색
		for (int i=0; i<num.length; i++) {
			num[i] = i + 1;
		}
		//출력 
		System.out.println(num[0]);
		System.out.println(num[1]);
		System.out.println(num[2]);
		
		System.out.println(num[9]);
		System.out.println(num[10]);
		//java.lang.ArrayIndexOutOfBoundsException: Index 10 out of bounds for length 10
		
		for(int i=0; i<num.length; i++) {
			System.out.printf("num[%d] = %d\n",i,num[i]);
		}
	}

	private static void m2() {
		// 배열 사용 
		//m1() -> 개선 -> m2()
		
		//요구사항 ] 학생 3명 > 국어점수 > 총점,평균
		// 수정사항] 학생 수 증가 > 500명 >10000
		
		
		//1. 배열만들기(선언하기)
		// - 자료형[] 배열명 = new 자료형[길이];
		
		int[] kor = new int[10000]; //인티저 배열의 변수인 kor
									// 이득 발생
		
		kor[0]=100; //연속으로 만들어진 인티저방의 첫번쨰방 
		kor[1]=90;
		kor[2]=80;
		//..
		kor[499] =100;
		
		
		//int total = kor[0] + kor[1] + kor[2];
		int total = 0;
		
		for(int i =0; i<kor.length; i++) {
			total += kor[i];
		}
		
		double avg = (double)total / kor.length;
		
		System.out.printf("총점 : %d점, 평균: %.1f점 \n", total,avg);

		
	}

	private static void m1() {
		// 요구사항] 학생 3명 > 국어 점수 > 총점 , 평균 
		// 수정사항] 학생 수 증가 > 500명 
		int kor1;
		int kor2;
		int kor3;
		//+497
		
		
		kor1 =100;
		kor2 = 90;
		kor3 = 80;
		//+497
		
		int total = kor1 + kor2 + kor3;//+497
		double avg = total / 3.0;//3->500
		
		System.out.printf("총점 : %d점, 평균: %.1f점 \n", total,avg);

		
	}

}

