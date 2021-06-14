package com.test.java.obj;

public class Ex31_Class {
	public static void main(String[] args) {
		
		//Ex31_Class.java
		
		//객체(Object)
		// -철학 용어 
		// -데이터 + 행동 
		//	 |       |
		// - 변수 + 메소드
		
		
		//클래스의 용도
		//1. 데이터의 집합 : 멤버 변수들의 집합 10%
		//2. 행동 집합: 멤버 메소드들의 집합2-3%
		//3. 데이터 + 행동 집합 : 멤버 변수 + 멤버 메소드의 //80-90%
	
		divide(10,2);// 생략
		//Ex31_Class.divide(10,2);//정석
		//MyMath.add(10,20);
		add(10,20); // 생략되면 같은 클래스 걸 호출
		Ex31_Class.add(10, 200);
		MyMath.add(10,20);
	
	
	
	
	}//math
	
	public static void add(int a, int b) {
		System.out.println(a+b);
	}
	
	public static void divide(int a, int b) {
		System.out.println(a/b);
	}
	
	
}// 같은동네 

//행동의 집합 
class MyMath{  //main mathod입장에서 다른 동네 
	
	public static void add(int a, int b) {
		System.out.println(a+b);
	}
	public static void substract(int a, int b) {
		System.out.println(a-b);
	}
	public static void multiply(int a, int b) {
		System.out.println(a*b);
	}
	
}