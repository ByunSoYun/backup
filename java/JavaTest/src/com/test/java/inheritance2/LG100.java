package com.test.java.inheritance2;

public class LG100 implements Monitor { //인터페이스 구현
	
	//모니터 특성 (상태)
	private int size;
	private String type;
	private int price;
	
	//모니터 행동
//	public void on() {
//		System.out.println("LG100 모니터를 켭니다");
//	}
//	public void off() {
//		System.out.println("LG100 모니터를 끕니다");
//	}
	
	@Override
	public void powerOn() {
		System.out.println("LG100 모니터를 켭니다")		
	}

	@Override
	public void powerOff() {
		System.out.println("LG100 모니터를 끕니다");
		
	}
}
