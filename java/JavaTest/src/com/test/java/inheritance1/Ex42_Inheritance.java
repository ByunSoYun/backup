package com.test.java.inheritance1;

import java.util.Random;

public class Ex42_Inheritance {
	public static void main(String[] args) {
		
		m1();
		m2();
		
	}
	
	private static void m2() {
 
		//상황] 개발자. 담당업무 > 난수 발생 잦음 > 난수 발생 코드 구현 잦음
		//1. -21억~21억
		//2. 1~10
		//3. 색상난수 : red, yellow, blue , orange, green
		//4. true,false
		
		s1();
		s2();
		s3();
		s4();
	}
	private static void s4() {
		
		//Random을 베이스로 해서 추가 기능을 넣은 클래스 -> 확장(Extends)
		
		MyRandom2 my = new MyRandom2();
		//1. 
		System.out.println(my.nextInt());
		//2.
		System.out.println(my.nextTinyInt());
		//3. 
		System.out.println(my.nextColor());
		//4.
		System.out.println(my.nextBoolean());
		
		System.out.println(my.nextLong());
		
		System.out.println(my.nextDouble());
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
		private static void s3() {
		
			MyRandom my = new MyRandom();
			
			//1.-21억~21억 
			System.out.println(my.nextInt());
			System.out.println(my.nextInt());
			System.out.println(my.nextInt());
			System.out.println(my.nextInt());
			System.out.println(my.nextInt());
			
			//2. 1~10 
			System.out.println(my.nextTinyInt());
			System.out.println(my.nextTinyInt());
			System.out.println(my.nextTinyInt());
			System.out.println(my.nextTinyInt());
			System.out.println(my.nextTinyInt());

			//3. 색상 난수 : red, yellow , blue, orange, green
			System.out.println(my.nextColor());
			System.out.println(my.nextColor());
			System.out.println(my.nextColor());
			System.out.println(my.nextColor());
			System.out.println(my.nextColor());
			
			
			
	}

		private static void s2() {
		
		Random rnd = new Random();
		MyRandom my = new MyRandom(); // 둘중에 하나 뭘써야할지 헷갈림 -> 두개 합침 !! -> s3
		
		//1.-21~ 21억 
		System.out.println(rnd.nextInt());//순수 Random기능 
		System.out.println(rnd.nextInt());
		System.out.println(rnd.nextInt());
		System.out.println(rnd.nextInt());
		System.out.println(rnd.nextInt());
		
		//2. 1~10 
		System.out.println(my.nextTinyInt());
		System.out.println(my.nextTinyInt());
		System.out.println(my.nextTinyInt());
		System.out.println(my.nextTinyInt());
		System.out.println(my.nextTinyInt());

		//3. 색상 난수 : red, yellow , blue, orange, green
		System.out.println(my.nextColor());
		System.out.println(my.nextColor());
		System.out.println(my.nextColor());
		System.out.println(my.nextColor());
		System.out.println(my.nextColor());
		
		}

		private static void s1() {
			//1.-21d억 ~ 21억 
			Random rnd = new Random();
			System.out.println(rnd.nextInt());//순수 Random 기능 
			System.out.println(rnd.nextInt());
			System.out.println(rnd.nextInt());
			System.out.println(rnd.nextInt());
			
			//2. 1~10
			
			System.out.println(rnd.nextInt(10)+1); //순수 Random 기능 + 사용자
			System.out.println(rnd.nextInt(10)+1); //순수 Random 기능 + 사용자
			System.out.println(rnd.nextInt(10)+1); //순수 Random 기능 + 사용자
			System.out.println(rnd.nextInt(10)+1); //순수 Random 기능 + 사용자
			System.out.println(rnd.nextInt(10)+1); //순수 Random 기능 + 사용자
			
			//3. 색상 난수 : red , yellow , blue , orange, green
			String [] color = {"red","yellow","blue","orange","green"};
			System.out.println(color[rnd.nextInt(color.length)]); //순수 random 방식
			System.out.println(color[rnd.nextInt(color.length)]);
			System.out.println(color[rnd.nextInt(color.length)]);
			System.out.println(color[rnd.nextInt(color.length)]);
			System.out.println(color[rnd.nextInt(color.length)]);
			System.out.println(color[rnd.nextInt(color.length)]);
		}
		
		
	

	private static void m1() {
		//상속X
		
		//난수 생성기 
		//1. Math.random() 메소드 
		//2. Random 클래스 
		//  - nextInt(int)
		//  - nextInt()
		//   -nextDouble()
		
		//preudorandom numbers -> 의사난수 숫자들
		Random rnd = new Random();
		
		
		for(int i =0; i<10; i++) {
			
			System.out.println(Math.random());//0(inclusive)~1(exclusive)사이
			System.out.println(rnd.nextInt());//int 범위의 난수 반환. -21~21억
			System.out.println(rnd.nextInt(10));//0(inclusive)~10(exclusive) -> 0~9까지
			System.out.println(rnd.nextBoolean());
			System.out.println(rnd.nextDouble());
			System.out.println(rnd.nextLong());
			System.out.println();
		
		}
		
	}
	
}
