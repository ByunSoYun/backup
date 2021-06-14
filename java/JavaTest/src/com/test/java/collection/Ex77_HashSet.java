package com.test.java.collection;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Random;

public class Ex77_HashSet {
	 public static void main(String[] args) {
		//Ex77_HashSet.java
		 
		 /*면접때 물어보기 쉬운 질문!
		   List / Set 비교 
		   
		  List 인터페이스  
		  - Collection 인터페이스의 자식
		  - 순서가 있는 배열 (***)
		  - 순수배열, ArrayList,LinkedList -> 방번호 존재 -> 첨자(index)를 사용해서 요소를 관리한다.
		  - 요소가 중복값을 가질 수 있다.(****)
		   -> 요소가 똑같아도 방번호로 구분 가능하다.
		  Set 인터페이스
		  - Collection 인터페이스의 자식 
		  - 순서가 없는 배열 (***) 
		  - 방번호 존재x -> 첨자(index)를 사용하지 않음 -> 순서가 없다.
		  - 요소가 중복값을 가질 수 없다.(****)
		   - 요소가 똑같으면 구분이 불가능하다.
		  */
		// m1();
		 //m2();
		 m3();
		// m4();
		 
	}//main 
	 
	 private static void m4() {
		 
		 
		 //값형 
		 int a = 10;
		 int b = 10;
		 System.out.println(a==b);
		 
		 boolean f1 = true;
		 boolean f2 = true;
		 System.out.println(f1 == f2);
		 
		 //참조형 
		 
		 //1. 문자열은 불변이다.(Immutable)  -> 메모리 성질 , 문자열 재사용 
		 //2. 모든 참조형 변수의 비교는 주소값을 비교한다!!!!
		 
		 String s1 = "홍길동";
		 String s2 = "홍길동"; // 위에 것을 다시 쓰자 (데이터 낭비라고 생각하기 때문) 변수만 새로만들고 같은거 공유 
		 
		 s1 = "홍길동님";
		 
		 String s3 = "홍";
		 s3 = s3 +"길동";
		
		 // 가공되어진 리터럴과 원래의 리터럴은 공유가 안된다.
		 
		 //절대로 하지 말것 (==) 문자열 비교는 반드시 equals로 할것
		 System.out.println(s1 == s2);   // -> 같은 데티어를 공유하고있기 때문에 주소값이 같음
		 System.out.println(s1.equals(s2));//String.equals(Objext anObect)
	
	  
		 System.out.println(s1 == s3); // false => s1과 s2는 같은 홍길동을 공유하지만 s3은 다른 홍길동을 쓴다 /즉 주소값이 달라서 false로 나옴 
		 System.out.println(s1.equals(s3)); // ture = > s1으로 찾아가서 한글자를 뽑고 s3로 찾아가서 한글자를 뽑아서 계속 한글자씩 비교한다 -> 즉 s1과 s3을 데이터값으로 비교 / 즉,문자열 equals로 쓰기
		 System.out.println();
		 
		 //참조형 객체의 비교 
		 Keyboard k1 = new Keyboard("K810",200000);
		 Keyboard k2 = new Keyboard("K810",200000);
		 Keyboard k3 = k1;
		 Keyboard k4 = new Keyboard("K990",350000);
		 

		 
		 System.out.println(k1 == k2); //flase 
		 System.out.println(k1.equals(k2));  // object.equals는 여전히 주소값 비교 -> 위의 방법과 동일 
		 
		 // -> equals를 뜯어 고쳐 true 로 만들기 
		 
		 System.out.println(k1 == k3); // true 
		 System.out.println();
		
		 System.out.println(k1.toString());
		 System.out.println(k2.toString());
		 
		 System.out.println(k1.hashCode()); // 객체의 위치(메모리 주소값)
		 System.out.println(k2.hashCode());
		 System.out.println();
		 
		 System.out.println(k1==k2);//false(C)	
		 System.out.println(k1.equals(k2));//true
		 System.out.println(k1.equals(k4));//false라고나와야하는데 true 로 나옴 -> hashCode 잘못만듬
	 System.out.println();
	 System.out.println();
	 System.out.println();
		 
		 System.out.println(k1.hashCode()); // k1 k2 다른 객체지만 안의 값 동일 
		 System.out.println(k2.hashCode());
		 System.out.println(k4.hashCode()); // k4 는 안의 값도 다름 
		 System.out.println();
		 System.out.println();
		 
		 
		 System.out.println(k1.equals(k2)); // 같은 키보드
		 System.out.println(k1.equals(k4)); // 다른 키보드 
		 
		 
	 }

	private static void m3() {
		//단일값(원자값) 집합
		 //- String[]
		 //- int[]
		 //- HashSet<String>
		 //- HashSet<Integer>
		 
		 //복합값 집합 -> 객체배열 
		 //-Student[]
		 //-HashSet<Student>
		 
		 HashSet<Integer> lotto = new HashSet<Integer>();
		 
		 lotto.add(10);
		 lotto.add(5);
		 lotto.add(10);// 허용x
		 
	
		 //Set -> 중복값 허용 안함
		 HashSet<Keyboard> set = new HashSet<Keyboard>();
		 
		 set.add(new Keyboard("K810",200000));
		 set.add(new Keyboard("K210",50000));
		 set.add(new Keyboard("K810",200000));
	
		 
		 //A와 C는 같은 키보드? 아니냐?
		 //- 모든 참조형(객체)는 아무리 상태(멤버 변수의 값)가 동일해도.. 다른 객체로 취급한다.
		 // - 쌍둥이 개념
		 System.out.println(set);
		 //3개나옴
		 
		 
		 //m4 이후로는 2개나옴 중복되면 삭제댐 왜냐면 m4에서 객체 두개를 동일하게 만들려고 조작했기 때문에 
	 }
	 
	 
	private static void m2() {
		 //로또 만들기 -> 중복값 허용 X
		 Random rnd = new Random();
		 //List
		 ArrayList<Integer> lotto = new ArrayList<Integer>();
		 
		 for(int i = 0 ; i<6 ; i++) {
			 
			 boolean flag = false;
			 
			 int n = rnd.nextInt(45) +1;
			
			 
			 //같은 숫자 검사 
			 for(int j=0; j<i;j++) {
				 if(n==lotto.get(j)) {
					 flag = true;
					 break;
				 }
			 }
			 
			 if(flag) {
				 i--;
			 }else {
				 lotto.add(n);
			 }
		
		 }
		 
		 Collections.sort(lotto);
		 
		 System.out.println(lotto);
		 
		 //Set 
		 HashSet<Integer> lotto2 = new HashSet<Integer> ();
		 
		 while(lotto2.size() < 6) {
			 int n = rnd.nextInt(45)+1;
			 lotto2.add(n);
		 }
		 System.out.println(lotto2);
		 
	}

	private static void m1() {
		 
		 ArrayList<String> list = new ArrayList<String>();
		 HashSet<String> set = new HashSet<String>();
		 
		 //요소 추가 
		 list.add("사과");
		 list.add("딸기");
		 list.add("바나나");
		 list.add("딸기"); // 중복값 허용, 방번호가 달라서 구분 가능하기 때문에
		 
		 set.add("사과");
		 set.add("딸기");
		 set.add("바나나");
		 set.add("딸기");// 중복값 허용 안함. 방번호가 없어서 데이터로 구분이 안되면 아예 구분 불가능하기 때문에...
		 
		 //갯수 
		 System.out.println(list.size());
		 System.out.println(set.size());
		 
		 //덤프 (출력용으로 사용금지 -> 개발자만 보는 용도)
		 System.out.println(list);
		 System.out.println(set);
		 
		 //요소 접근 / 탐색 
		 System.out.println(list.get(0));
		 //System.out.println(set.get(0));셋은 get(),indextOf(),lastIndexOf(),remove()...메소드가 없다 -> 방번호가 없기 떄문 
		 System.out.println();
		 //Set -> Iterator 지원 
		 //Iterator은 방번호 상관없이 모든 방 가져올수 있기때문 
		
		 for(String item : list) {
			 System.out.println(item);
		 }
		 
		 System.out.println();
		 
		 
		 Iterator<String> iter = set.iterator();
		 
		 while(iter.hasNext()) {
			 System.out.println(iter.next());
		 }
	 
	 
	 }
}//Ex77_HashSet


class Keyboard {
	private String model;
	private int price;
	public Keyboard(String model, int price) {
		this.model = model;
		this.price = price;
	}
	public String getModel() {
		return model;
	}
	public void setModel(String model) {
		this.model = model;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	@Override
	public String toString() {
		return "Keyboard [model=" + model + ", price=" + price + "]";
	}
	
	//hashCode 오버라이딩 + equals 오버라이딩 
	
	@Override
	public int hashCode() {
		//return 100; // 고정 상수 반환 금지
		//본인의 상태에 따라 달라지는 값을 반환하도록 재정의
		//k1 : "K810" , 200000 - > "K810200000"  
		//k2: "K810" , 200000 - > "K810200000"  -> 객체는 다르지만 멤버의 상태가 동일하면 동일한 주소값을 가진다.
		//k4 : "K990" , 350000 - > "K990350000" -> 객체도 다르고 멤버의 상태가 달라서 다른 주소값을 가진다.
		
		 return (this.model +this.price).hashCode();
		 
	}
	
	@Override
	public boolean equals(Object obj) {
		return this.hashCode() == obj.hashCode();
	}
}