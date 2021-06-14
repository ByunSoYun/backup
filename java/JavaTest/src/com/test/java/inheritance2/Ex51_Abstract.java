package com.test.java.inheritance2;

public class Ex51_Abstract {

	//Ex51_Abstract.java
	
	//인터페이스vs 추상클래스 
	// - 둘다 추상 메소드를 통해서 메소드를 강제 구현
	// - 구현 멤버도 물려주고 싶으면 추상 클래스를 사용해야한다. 인터페이스는 불가능(x)
	// - 용도가 다르다.
	// - 인터페이스 > 추상클래스 
	
}
//컴퓨터가 갖춰야할 사용법들의 집합
interface Computer {
	public abstract void on();
	public abstract void off();
}

abstract class AComputer{
	public abstract void on();
	public abstract void off();
	
	private String serialNumber;
	private int weight;
	private int price;
	
	
	
	public void check() {
		System.out.println("바이러스 검사");
	}

	
}


//class ASUS100 implements Computer {
class ASUS100 extends AComputer{
	
//	private String serialNumber;
//	private int weight;
//	private int price;
//	
//	
//	
//	public void check() {
//		System.out.println("바이러스 검사");
//	}

	@Override
	public void on() {
		//추상 메소드의 의도??
		// - 겉으로 보이는 사용법을 강제 
		// - 구현부는 자유롭게 맘대로~> 되도록 on 이름에 걸맞는 행동을 구현하는걸 권장 
//		
//		System.out.println("무슨짓..ASUS100 맘..");
//		System.out.println("전원을 종료합니다.");
	
	
		System.out.println("전원 On");
	}

	@Override
	public void off() {
		System.out.println("전원 Off");
	}
	
}

//class Samsung200 implements Computer {
class Samsung200 extends AComputer{
	
//	private String serialNumber;
//	private int weight;
//	private int price;
//	
//	public void check() {
//		System.out.println("바이러스 검사");
//	}

	@Override
	public void on() {
		System.out.println("Power On");
	}

	@Override
	public void off() {
		System.out.println("Power Off");
	}
	
}