package com.test.java.collection;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;

public class Ex76_Collection {
	public static void main(String[] args) {
		//Ex76_Collection.java
		
		//컬렉션 탐색 도구 
		// - 집합의 요소를 접근하는 도구 
		//1. for문(***)
		//2. 향상된 for문 (***)  -> 내부에 Iterator 사용 
		//3. Enumeration
		//4. Iterator(***)
		//			-전진 커서, Foward Corsor
		//			- 한번 읽은 값은 다시 읽지 못한다.
		//5. ListIterator 
		
		
		//m1();
		m2();
	}

	private static void m2() {

		//HashMap -> 탐색 
		HashMap<String,String> map = new HashMap<String,String>();
		
		map.put("과장", "홍길동");
		map.put("사원", "아무개");
		map.put("대리", "하하하");
		map.put("부장", "호호호");
		
		Set<String> set = map.keySet();
		
		Iterator<String> iter = set.iterator();
		
		while (iter.hasNext()) {
			//키 출력 + 값 출력
//			System.out.println(iter.next());// 키
//			System.out.println(map.get(iter.next())); // 값 //값을 가져오기전에 또 다시 밑으로 이동 즉 위의 iter.next와 밑의 iter.next 는 다른것 
//			
			String key = iter.next();
			
			
			System.out.print(key+" ");
			System.out.println(map.get(key));
	
		
		}
		
	}

	private static void m1() {
		ArrayList<String> list = new ArrayList<String>();
		
		list.add("사과");
		list.add("바나나");
		list.add("포도");
		list.add("딸기");
		list.add("귤");
		list.add("복숭아");
		list.add("참외");
		
		//M1. 일반 for문 -> index 사용o
		for (int i = 0; i<list.size(); i++) {
			System.out.println(list.get(i));
		}
		System.out.println();
	
		//M2. 향상된 for 문 -> index 사용x
		for(String item : list) {
			System.out.println(item);
			
		}
		
		System.out.println();
		
		//M3. Iterator -> index 사용 x
		// - ArrayList는 Iterator를 지원한다.
		// - iter : 탐색기(판독기)
		// 		a.hasXXX() : 다음에 읽을 요소가 존재하는지?
		//		b.nextXXX() : 다음 요소를 읽어와라(소비)
		Iterator<String> iter = list.iterator();
	
		
		while(iter.hasNext()) {
			System.out.println(iter.next());
		}
		System.out.println();
//		System.out.println(iter.hasNext()); // 지금 읽어올 다음 요소가 잇니?
//		System.out.println(iter.next());  // 다음 요소 읽어오기 
//		
//		System.out.println(iter.hasNext());
//		System.out.println(iter.next());
//	
//		System.out.println(iter.hasNext());
//		System.out.println(iter.next());
//	
//		System.out.println(iter.hasNext());
//		System.out.println(iter.next());
//	
//		System.out.println(iter.hasNext());
//		System.out.println(iter.next());
//	
//		System.out.println(iter.hasNext());
//		System.out.println(iter.next());
//	
//		System.out.println(iter.hasNext());
//		System.out.println(iter.next());
//	
//		System.out.println(iter.hasNext()); //false
//		System.out.println(iter.next());//오류 java.util.NoSuchElementException // 다음읽어올 요소 x
//		
//		
	
	}
}
