package com.test.java.collection;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Comparator;
import java.util.HashMap;

public class Ex74_Anonymous {
	public static void main(String[] args) {
		//Ex74_Anonymous.java
		
		/*
		 익명 객체, Anonymous Object
		 - 익명 클래스, Anonymous Class 
		 - 이름이 없는 클래스(객체)
		 - 붕어빵틀에 이름이 없다.
		 - 이름이 없는 이유? -> 해당 클래스를 호출할 일이 없다.(반복해서 사용할 일이 없는 붕어빵 틀)
		 
		 a.데이터 집합 
		  1.클래스 : 같은 형식을 가지는 집합 x N개 + 클래스 선언 비용 (같은 형식의 객체를 여러개 찍어낼때) 
		  2.HashMap : 데이터 집합 x 1회 + 클래스 선언 비용 (X)
		
		 b. 행동 집합 
		  1.실명 클래스 : 객체화 횟수 x N개 + 클래스 선언 비용 O
		  2.익명 클래스 : 객체화 횟수 x 1개 + 클래스 선언 비용 X 
		 */
		 
		//m1();
		//m2();
		//m3();
		//m4();
		//m5();
		//m6();
		// --------- 사용자가 직접 구현
		
		
		// ----------제공하는 기능을 사용 (완전 자동 + 반자동)
		
		//m7();
		//m8();
		//m9();
		//m10();
		m11();
		
		
		// 자바의 sort 메소드 
		// -> 퀵 정렬 구현 
		
	}//main

	
	
	
	
	
	private static void m11() {
		ArrayList<User> list = new ArrayList<User>();

		Calendar c1 = Calendar.getInstance();
		c1.set(1995,2,5);
		list.add(new User("홍길동",c1));
		
		Calendar c2 = Calendar.getInstance();
		c2.set(1996	,4,3);
		list.add(new User("아무개",c2));
		
		Calendar c3 = Calendar.getInstance();
		c3.set(1998,9,3);
		list.add(new User("하하하",c3));
		
		list.sort(new Comparator<User>() {

			@Override
			public int compare(User o1, User o2) {
				return o1.birthday.compareTo(o2.birthday); 
				//return ((int)o1.birthday.getTimeInMillis() - (int)o2.birthday.getTimeInMillis());
			}
			
		});
		System.out.println(list);
		
	}






	private static void m10() {
		ArrayList<Product> list = new ArrayList<Product>();
		
		list.add(new Product("마우스",1000));
		list.add(new Product("키보드",1500));
		list.add(new Product("모니터",3000));
		list.add(new Product("USB",1200));
		list.add(new Product("랩탑",1100));
		
		list.sort(new Comparator<Product>() {

			@Override
			public int compare(Product o1, Product o2) {
				return o1.price - o2.price; // 가격정렬 
				
			}
			
		});
		
		System.out.println(list);
	}






	private static void m9() {
		ArrayList<String> name = new ArrayList<String>();
		
		name.add("홍길동");
		name.add("아무개");
		name.add("하하하하");
		name.add("호호호");
		name.add("후후");
		
		name.sort(new Comparator<String>() {

			@Override
			public int compare(String o1, String o2) {
				//앞의 것이 크면 오름차순 
				//뒤의 것이 크면 내림차순 
				
				//return o1.compareTo(o2); // 오름차순 앞의 것이 크면 양수 ,뒤의것이 크면 음수 ,같으면 0 
				//return o2.compareTo(o1);// 내림차순
				
				
				//return o1.length() - o2.length(); // 글자수로 1차정렬 한것 
				
				if(o1.length()>o2.length()) {
					return 1;
				}else if(o1.length()<o2.length()) {
					return -1;
				}else {
					return o1.compareTo(o2);// 양수 , 음수, 0 (똑같은 글자수를 같는 객체끼리 비교 2차정렬)
				}        
			
			}
		});
		
		System.out.println(name);
	}






	private static void m8() {
		ArrayList<Integer> num = new ArrayList<Integer>();
		
		num.add(10);
		num.add(50);
		num.add(30);
		num.add(40);
		num.add(20);
		
		num.sort(new Comparator<Integer>() {

			@Override
			public int compare(Integer o1, Integer o2) {
				
				return o1 - o2;
			}
			
		});
		
		System.out.println(num);
	}





	private static void m7() {
		Integer[] num = { 5, 3, 1, 4, 2};
		
		Arrays.sort(num); // 정렬 ( 오름차순 )
		
		System.out.println(Arrays.toString(num));
	
		// 순수 배열 -> 내림 차순 정렬 기능 없음 
		
//		Arrays.sort(num, 1, 4); // 부분정렬
//		
//		System.out.println(Arrays.toString(num));
		
		//Comparator<? super T> c 
		Arrays.sort(num,new Mysort());
		System.out.println(Arrays.toString(num));
		
		
		
//		Arrays.sort(num,new Comparator<Integer>() {
//
//			@Override
//			public int compare(Integer o1, Integer o2) {
//				return o1-o2;
//			}
//		
//
//	});          -> 위의 것을 익명 객체로 만든것 

}




	private static void m6() {
		User[] list = new User[5];
		
		Calendar c1 = Calendar.getInstance();
		c1.set(1995,2,5);
		list[0] = new User("홍길동", c1);
		
		Calendar c2 = Calendar.getInstance();
		c2.set(1996	,4,3);
		list[1] = new User("아무개", c2);
		
		Calendar c3 = Calendar.getInstance();
		c3.set(1998,9,3);
		list[2] = new User("하하하", c3);
		
		Calendar c4 = Calendar.getInstance();
		c4.set(1992,5,5);
		list[3] = new User("호호호", c4);
		
		Calendar c5 = Calendar.getInstance();
		c5.set(1991,7,11);
		list[4] = new User("후후후", c5);
		
		
		for(int i = 0; i<list.length-1 ; i++) {
			for(int j = 0; j<list.length-1-i; j++) {
				
				//객체 간의 우위 비교 
				// -> 생일 비교 
				if (list[j].birthday.getTimeInMillis()
						>list[j+1].birthday.getTimeInMillis()) {
					
					User temp = list[j];
					list[j] = list[j+1];
					list[j+1] = temp;
				}
			}
		}
		System.out.println(Arrays.toString(list));
	}






	private static void m5() {
		
		// 가장 현실적인 사례
		
		Product[] list = new Product[5];
		list[0] = new Product("모니터",350000);
		list[1] = new Product("키보드",120000);
		list[2] = new Product("마우스",50000);
		list[3] = new Product("랩탑",150000);
		list[4] = new Product("외장메모리",15000);
		
		//제품을 정렬하시오.
		// -> 기준??
		for (int i =0; i<list.length-1;i++) {
			
			for(int j =0; j<list.length-1-i; j++) {
				
				//우위 비교?
				// - 객체간의 비교(X) -> 객체가 가지는 단일값의 비교(O)
				if(list[j].price > list[j+1].price) {
				//if(lis[j].name.compareTo(list[j+1].name){	 //이름순으로 정렬
					//비교는 객체의 속성을 가지고 했지만 
					//실제 교환은 개체간 이뤄져야한다.(*****)
//					int temp = list[j].price;
//					list[j].price = list[j+1].price;
//					list[j+1].price = temp;
					
					//제품간의 교환
					Product temp = list[j];
					list[j]= list[j+1];
					list[j+1] = temp;
					
				}
			}
		}// i for
		System.out.println(Arrays.toString(list));
	}






	private static void m4() {
		// 문자 정렬 (버블)
		String[] name = { "홍길동", "아무개", "호호호", "가가가", "홍길순"};
		
		for(int i=0; i< name.length-1 ; i++) {
			
			for(int j=0; j<name.length-1-i; j++) {
				
				//두방의 이름을 비교 -> 우위 비교 
				//"홍길동" > "아무개"
				
				if(name[j].compareTo(name[j+1])>0) {
					//크면 양수 작으면 음수 같으면 0 ( 즉 위의 식은 앞의 이름이 더 크다는것)
					String temp = name[j];
					name[j] = name[j+1];
					name[j+1] = temp;
				
				}
				
			}
		}//i for
		System.out.println(Arrays.toString(name));
	}//m4






	private static void m3() {
		
		// 버블 정렬 
		int[] num = {5, 3, 4, 1, 2};
		
		for(int i=0; i< num.length-1 ; i++) {
			
			System.out.printf("%d 사이클 \n", i+1); // 사이클 수 출력 가능 

			
			for(int j=0; j<num.length-1-i; j++) {
				//j : 엑셀의 빨간숫자 
				System.out.printf("\t%d 작은 사이클 \n", i+1); // 사이클 수 출력 가능 

				
				if (num[j] > num[j+1]) {
					// 두방의 값을 서로 바꾸기(Swap)
					int temp = num[j]; //temp라는 임시 방에 j 저장 
					num[j] = num[j+1]; // j+1의 값을 j 에 저장
					num[j+1] = temp ; // temp (j)의값을 j+1의 방에 저장 
					
				}
				
				System.out.println("\t" + Arrays.toString(num));
			}
		}// i for 
		
		System.out.println(Arrays.toString(num));
	}//m3 

	private static void m2() {
		ArrayList<Integer> list = new ArrayList<Integer>();
		
		list.add(100);
		list.add(500);
		list.add(300);
		list.add(400);
		list.add(200);
		
		
		//대부분의 컬렉션은 toString() 오버라이드 되어있다.
		// -> 본인의 상태(데이터)를 문자열로 반환
		// -> 개발자 확인 용이 
		
		System.out.println(list);
		System.out.println(list.toString());
		
		
		int[] num = { 10, 30, 20, 50, 40 };
		System.out.println(num);
		System.out.println(num.toString());//(String java.lang.Object.toString() ) Object -> 오버라이딩 안돼있는것
		System.out.println(Arrays.toString(num));//***
		
		//정렬
		// - 값의 우위 비교를 통해 순서를 바꾸는 행동 
		// - 오름차순 정렬, 내림차순 정렬
		//1. 사용자 정렬
		// - 버블 정렬 (가장 쉬움)
		// - 삽입 정렬 
		// - 선택 정렬
		// - 퀵 정렬
		// - 병합 정렬 
		// - 힙 정렬
		// - 쉡 정렬 
		
		//2. 해당 클래스 정렬 기능 
	}//m2

	private static void m1() {
		HashMap<String,Integer>map = new HashMap<String,Integer>();
		map.put("kor", 100); //멤버 변수 역할(클래스)
		map.put("eng", 90);
		map.put("math", 80);
		
		HashMap<String,Integer>map2 = new HashMap<String,Integer>();
		map.put("kor", 100); //멤버 변수 역할(클래스)
		map.put("eng", 90);
		map.put("math", 80);

		
		
		
		
		
		CCC c = new CCC();
		c.test();
		
		//인터페이스를 상속한 클래스의 객체는 되도록 인터페이스 변수를 만들어서 담아라
		
		AAA c2 =new CCC(); //업캐스팅
		c2.test();
		
		
		//Cannot instantiate the type AAA
		// -> 추상메소드 때문에 객체 만들 수 없음 
		//AAA c3 = new AAA();
		
		AAA c3 = new AAA(){

			@Override
			public void test() {
				System.out.println("인터페이스 구현 메소드222");

			}
		};
		//(class CCC)c2 인터페이스를 상속받는 클래스를 선언 -> 위로올라가 인스턴스를 만들어 변수에 대입 
		//-> 위의 과정을 압축시킨것 (클래스 선언과 함꼐 객체를 만든것 c2,c3둘다  인터페이스를 구현한 객체이다
		
		// 일반 클래스로 만든 애들은 다른 객체가 재사용가능 But 이렇게 익명객체는 거기서 선언했던 객체만 사용 가능하다! 
		
		
		AAA c4 = new AAA() {

			@Override
			public void test() {
				// TODO Auto-generated method stub
				// 이름 없는 클래스 설계 
			}
			
		};
		
		AAA c5 = new CCC(); // test();
		AAA c6 = new CCC(); // test(); 같은 클래스로 객체만 생성하면 가능 ..
		
		
		AAA c7 = new AAA() {

			@Override
			public void test() {
				System.out.println("하하하");				
			}
		}; /// "하하하"를 구현하고 싶지만 이 익명객체는 c7만 사용할 수 있다 -> 즉 이름이없어서 부를수 없다 .
	}

}//m1
 

//class ?? {// ??이 없음
	
//}

interface AAA{
	//오로지 추상 메소드만 가능 -> 어차피 추상메소드만 가능하기 때문에 abstract 생략 가능!
	//어떤 메소드가 이 메소드를 구현했을 떄 이게 밖에서 보이지 않으면 의미x( 즉 private 생략가능 )
	void test();
	//public abstract void test();
}

// 프로젝트 > 클래스 갯수 > 관리 힘들다...(갯수, 이름 짓기 .. )
class CCC implements AAA{

	@Override
	public void test() {
		// 1000라인 (class가 똑같이 구현가능 )
		System.out.println("인터페이스 구현 메소드111");
	}
	
} // 인터페이스를 상속받는 클래스를 선언 -> 위로올라가 인스턴스를 만들어 변수에 대입 -> 위의 과정을 압축시킨것 (클래스 선언과 함꼐 객체를 만든것 c2,c3둘다  인터페이스를 구현한 객체이다
	// 

class DDD implements AAA {

	@Override
	public void test() {
	
		
	} //CCC와 DDD는 형제일뿐 직접적인 관계x 
	
}

abstract class BBB {
	public abstract void test();
	private int a;
	public void aaa() {
		
	}
}


class Product {
	public String name ; 
	public int price;
	
	public Product (String name, int price) {
		this.name = name;
		this.price = price;
		

	}
	
	@Override 
	public String toString() {
		return String.format("%s,%,d",this.name,this.price);
		
	}
	
}


class User {
	public String name;
	public Calendar birthday;
	
	public User(String name,Calendar birthday) {
		this.name= name;
		this.birthday = birthday;
		
	}
	
	@Override 
	public String toString() {
		return String.format("(%s,%tF)",this.name,this.birthday);
		
	}
}



class Mysort implements Comparator<Integer>{

	@Override
	public int compare(Integer o1, Integer o2) {
		//인자값 두개를 우위 비교 
		// -> 양수 or 0 or 음수 -> 반환 
		return o2-o1;
		
		//객체를 만들어 놓으면 정렬을 우리가 원하는대로 정의 가능 
	}
	
}