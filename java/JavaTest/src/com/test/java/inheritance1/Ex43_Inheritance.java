package com.test.java.inheritance1;

public class Ex43_Inheritance {
	public static void main(String[] args) {
		
		//Ex43_Inheritance.java
		
		//여행 패키지 상품   ->부모 클래스
		//A. 기본 패키지 
		// - 기차, 펜션
		
		//B.기본 패키지 + 액티비티 -> 딸 클래스
		// - A + 패러글라이드
		
		//C.기본패키지 + 힐링 ->아들 클래스 
		// -A + 농장체험
		
		
		//부모 클래스를 2개 이상 가지는 상속 
		// -> 다중 상속 
		// -> 자바느 클래스 다중 상속을 지원하지 않는다.(C++ 지원함) > 어렵다.
	}

}



class Parent{
	public int a = 10;
	public void aaa() {
	}
	
}



class daugter{
	public int b = 20;
	public void bbb(){
		
	}
	
}