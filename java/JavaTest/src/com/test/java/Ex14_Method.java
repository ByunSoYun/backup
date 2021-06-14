package com.test.java;

public class Ex14_Method {

	public static void main(String[] args) {
		
		//public static void hello()
		// - hello 정의/ 호출에 사용댐 
		

		int a;
		//메소드 인자 리스트 
		//- 파라미터(Parameter)
		//- 인자 (Argument)
		//- 매개변수 
		// - 가인자/ 실인자
		
		// - 메소드 호출 시 전달하자고 하는 데이터 전송하는 역할 
		//- (소극성) 다형성 구현 
		hello();
		hello2();
		
		//hello25(); // 누구?? > 메소드명 만들기도 힘들다 ;; 의미있게 
		
	//public static void hi(String name)
		//hi();  //The method hi(String)  is not applicable for the arguments ()
		hi("홍길동"); //> hi 메소드로 이동해서 홍길동이라는 변수를 String name 으로 초기화시켜줌
		hi("아무개");
		hi("호호호");
		hi("하하하"); // 호출할떄넘어가는 인자 - 실인자 , Actual Argument
		
		//public static void bye(String name, int age)
		
		bye("홍길동",20);
		bye("뽀로로",5);
		
		// 매개변수 사용 시 주의점!!!!
		
		//1. 가인자와 실인자의 개수가 동일해야한다 
		//hi();
		//hi("홍길동");
		//hi("홍길동","아무개")
		
		//2. 가인자와 실인자의 자료형이 동일해야한다.
		
		//hi(100);
		
		//3. 형변환이 가능하면 자료형이 동일하지 않아도 된다. 
		
		byte b = 10;
		bye ("홍길동",b); //bye(String name, int age)	
	
		//2개 숫자 입력 -> 연산과정 출력 
		
		int n1 = 10;
		int n2 = 20;
		
		System.out.printf("%d + %d = %d\n",n1 , n2 , n1 + n2);
	
		n1 = 5;
		n2 = 9;
		
		System.out.printf("%d + %d = %d\n",n1 , n2 , n1 + n2);

		n1 = 22;
		n2 = 123;
		
		System.out.printf("%d + %d = %d\n",n1 , n2 , n1 + n2);
		
		add(n1,n2);
		
		n1 = 111;
		n2 = 222;
		
	
		add(n1,n2);
		
		n1 =1 ;
		n2 =2 ;
		
		add(n1,n2);
		
	
		
	}//main
	
	// '홍길동'에게 인사하는 메소드를 구현하시오.
	public static void hello() {
		System.out.println("홍길동님. 안녕하세요.");
	}
	
	//'아무개'에게도 인사를 하는 메소드를 구현하시오.
	
	public static void hello2() {
		System.out.println("아무개님. 안녕하세요.");
	}
	
	//우리반 30명에게 각각 인사를 하는 메소드를 구현하시오.
	//-> 메소드를 30개 추가 선언하기 
	public static void hi(String name)//< 변수 선언만 가능 초기화 불가  String name = 매개변수, 가인자, Formal Argument 
	{
		//String name = "홍길동";//Duplicate local variable name
		System.out.printf("%s님.안녕하세요.\n"); // 재사용성 굉장히 높아짐 
	}
	
	public static void bye(String name, int age) {
		// 인삿말을 나이에 따라 다르게..
		// 10세이상 -> 안녕하세요.
		// 10세미만 -> 안녕~
		
		String result = age >= 10? "안녕하세요." :" 안녕~";
		System.out.printf("%s님 %s\n",name , result);
	}
	
	public static void add(int n1,int n2) {
	
	 System.out.printf("%d + %d = %d\n",n1 , n2 , n1 + n2);
	 
		
	}
	
	public static void aaa(int num) {
		int a;
	}
	public static void bbb(int num) { 
		int a;
	}
	
	
}
