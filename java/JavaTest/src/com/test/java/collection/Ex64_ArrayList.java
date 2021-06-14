package com.test.java.collection;

public class Ex64_ArrayList {

	public static void main(String[] args) {
		//E64_ArrayList.java
		
		MyList list = new MyList();
		
		System.out.println(list);
		
		list.add(100);
		
		System.out.println(list);

		list.add(200);
		
		System.out.println(list);
		
		list.add(300);
		
		System.out.println(list);
		
		list.add(400);
		
		System.out.println(list);
		
		list.add(500);
		
		System.out.println(list);
		
		list.add(600);
		
		System.out.println(list);
		
		list.add(700);
		
		System.out.println(list);
		list.add(800);
		
		System.out.println(list);
		
		list.add(900);
		
		System.out.println(list);
		
		
		System.out.println("list.get(0): "+list.get(0));
		System.out.println("list.get(3): "+list.get(3));
		System.out.println("list.get(5): "+list.get(5));
		
//		for(int i = 0; i<16; i++) {
//			System.out.println(list.get(i));
//		}
//		
//		
//		System.out.println(list.get(20));
//		
		
		
		System.out.println("size: "+ list.size());
	
	
	
		list.set(0, 1000);
	
		System.out.println(list);
		
		list.set(8, 9000);
		
		System.out.println(list);
	
	
	
	
	
	
	
	}
}





class MyList {
	private int [] list; //내부배열 
	private int index;//현재 데이터를 넣을 방의 위치
	
	public MyList() {
		
		this.list = new int[4]; //초기 배열 크기 
		this.index = 0;//처음 넣은 방 번호 
		
	}// 생성자 
	
	
	
	
	//추가하기(Append)
	public void add(int n)	{
		
		
		//1. 방의 갯수 확인 -> 2배로 늘리기
		
		if(this.index >= this.list.length) {
			int[] temp = new int[this.list.length * 2 ];
			
			//깊은복사 (짧은 배열 길이만큼 반복)			
			for(int i=0; i<this.list.length; i++) {
				temp[i] = this.list[i]; // 원래배열의 방 -> 2배 배의 방 -> 1:1 복사 
			}
			
			this.list = temp; // 배열 교체 
		}
			
			
		//2. 데이터 추가하기
		this.list[this.index] = n;
		this.index++;
	
	}
	@Override
	public String toString() {
		String temp ="[";
		
		
		for(int n : this.list) {
			temp += n + ",";
		}
		
		temp = temp.substring(0,temp.length()-1);
		temp += "]";
		return String.format("length: %d\nindex: %d\n%s\n",
							this.list.length//실제 내부 배열의 길이
							, this.index//현재 방번호
							,temp);
	}
	
	
	//가져오기(get)
	public int get(int index) {
		//for문;;
		
		//요청하는 방번호가 자신이 집어넣은 데이터 갯수 범위 내 
		if (index >=0 && index<this.index) {
			
			return this.list[index];
		}else {
			throw new IndexOutOfBoundsException();// 예외 던지기 
		}
		
	}
	
	
	
	//현재 요소 갯수 변환
	//- 배열의 길이(X)
	// - 배열의 길이와 상관없이 넣은 데이터의 갯수(O)
	
	public int size() {
		return this.index;
	}
	
	
	
	
	
	//수정하기 
	public void set(int index, int n) {
		
		this.list[index] = n;
		
		System.out.println(list);
		
		list.set(10,10000);
		
		System.out.println();
	
	}
}	




