package com.test.java.inheritance2;



//모니터 제품 -실제제품 
public class HP200 implements Monitor {

	private String name;
	private int power;
	private String color;
	
	//모니터 행동 
//	public void begin() {
//		System.out.println("HP200 Power on");
//	}
//	
//	public void end() {
//		System.out.println("HP200 Power off");
//	}
	@Override
	public void powerOn() {
		System.out.println("HP200 Power on");
		
	}
	
	@Override
	public void powerOff() {
		System.out.println("HP200 Power off");
		
	}
}
