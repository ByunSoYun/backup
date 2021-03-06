package com.test.java.collection;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
import java.util.Iterator;
import java.util.TreeSet;

public class Ex78_TreeSet {
	
	public static void main(String[] args) {
		//Ex78_TreeSet.java
		
		/*Set
		 
		 
		 OOOXXX 
		 - OOO : 자료구조 (물리적인 공간의 형태)
		 - XXX : 인터페이스(사용법)
		 
		 List 
		 - ArrayList: Array(배열형태의 공간) + List(리스트 사용법 제공,index)
		 - LinkedList: Linked(링크형태의공간) + List(리스트 사용법 제공,index)
		 
		 Set
		 - HashSet : Hash(알고리즘 사용 , 구조) + Set(사용법, 중복값X)
		 - TreeSet : Tree()	+Set(사용법, 중복값X)
		 
		 
		 Map
		 - HashMap : Hash(알고리즘) + Map(key,value)
		 - TreeMap : Tree(트리구조) + Map(key,value)
		
		TreeSet
		- Tree 구조를 가지는 Set
		- 중복값 X , 순서(index) X , 정렬기능X(누가앞에오고 뒤에오는지X 1,2,3...)
		- 이진 트리 구조(자식이 최소 2개) 기반의 자동 정렬이 되어있는 Set 
		- 정렬필요 + 중복값 X + 검색 자주
		*/
		
		
		
		TreeSet<Integer>set = new TreeSet<Integer>();
		
		set.add(10);
		set.add(40);
		set.add(20);
		set.add(50);
		set.add(30);
		
		System.out.println(set.size());
		
		Iterator<Integer> iter = set.iterator();
		 
		while (iter.hasNext()) {
			System.out.println(iter.next());
		}
		
		System.out.println();
		
		//메소드 
		System.out.println(set.first());// 최솟값
		System.out.println(set.last());// 최댓값
		System.out.println(set.headSet(30)); // 처음 ~30전까지
		System.out.println(set.tailSet(30)); // 30부터 ~끝까지 
		System.out.println(set.subSet(30,50)); // 30부터~ 50전까지
	
	
	//**********************************************
	// 배열안에 객체가 들어있다 . <-> 배열안에 원자값이 들어있다.(int,String...)
		
		ArrayList<Score>list = new ArrayList<Score>();
		list.add(new Score("홍길동", 100, 90, 80));
		list.add(new Score("아무개", 99, 88, 77));
		list.add(new Score("하하하", 81, 69, 87));
		
		System.out.println(list);
		
	//정렬
		//Collections.sort(list);
		list.sort(new Comparator<Score>(){
			
			public int compare(Score o1, Score o2) {
				//return o1.getKor() - o2.getKor();
				//return o2.getEng() - o1.getEng();
				return (o1.getKor() + o1.getEng() + o1.getMath()) - (o2.getKor() + o2.getKor() +o2.getMath());
			}
		});
		
		
		HashSet<Score> hset = new HashSet<Score>();
		hset.add(new Score("홍길동", 100, 90, 80));
		hset.add(new Score("아무개", 99, 88, 77));
		hset.add(new Score("하하하", 81, 69, 87));
		
		
		System.out.println(hset);

		hset.add(new Score("하하하", 81, 69, 87));// 동명이인, 동일인 
		
		System.out.println(hset);
		
		//객체를 비교 우위 대상으로 사용할 수 있게하는 방법 
		//1. Comparator 구현 (실명 구현, 익명 객체)
		//2. Comparable 구현 
		
		
		
//		TreeSet<Score> tset = new TreeSet<Score>();
//		tset.add(new Score("홍길동", 100, 90, 80));
//		tset.add(new Score("아무개", 99, 88, 77));
//		tset.add(new Score("하하하", 81, 69, 87));
//		
//		애초부터 비교를 해서 넣어야하는데 시작조차 불가능함 
//	정렬을 안핻 정렬이 끝나있음 -> 정렬이 국어점수순으로 설정돼있음 가장밑에 오버라이딩 
		
	
	
	
	
	
	
	
	
	
	
	
	}//main

}

class Score implements Comparable<Score>{
	private String name;
	private int kor;
	private int eng;
	private int math;
	
	//생성자 오버로딩 
	
	public Score(String name, int kor, int eng, int math) {
		super();
		this.name = name;
		this.kor = kor;
		this.eng = eng;
		this.math = math;
	}

	//Getter,Setter

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getKor() {
		return kor;
	}

	public void setKor(int kor) {
		this.kor = kor;
	}

	public int getEng() {
		return eng;
	}

	public void setEng(int eng) {
		this.eng = eng;
	}

	public int getMath() {
		return math;
	}

	public void setMath(int math) {
		this.math = math;
	}

	
	//toString() 오버라이딩 
	@Override
	public String toString() {
		return "Score [name=" + name + ", kor=" + kor + ", eng=" + eng + ", math=" + math + "]";
	}
	
	// 모든 멤버의 상태가 똑같으면 -> 동일한 객체로 취급하도록 ...
	//1.hashCode() 오버라이딩
	//2. equals()	 오버라이딩
	
	@Override
	public int hashCode() {
		return (this.name + this.kor + this.eng + this.math).hashCode();
	}
	@Override
	public boolean equals(Object obj) {
		return this.hashCode() == obj.hashCode();
	}

	
	@Override
	public int compareTo(Score o) {
 // 들어갈 
//		return this.getKor() - o.getKor();
//		return (this.getKor() +this.getEng()+this.getMath())
//				-(o.getKor() + o.getEng() +o.getMath());
//		
		return this.getName().compareTo(o.getName());
	}

}