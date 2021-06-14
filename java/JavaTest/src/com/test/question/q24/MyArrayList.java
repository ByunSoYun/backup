package com.test.question.q24;

import java.util.ArrayList;



public class MyArrayList {
	

	private String[] list;
	private int index; // ***중요한 역할 (요소가 들어갈 방의 번호)
	
	
	
	public MyArrayList(){
		this.list = new String[4];
		this.index = 0;
		
	} // 생성자 (초기화)

	
	
	public void add(String s) {
	      
	      //방이 남아있는지 체크 ? 
	      if(this.index >= this.list.length) {
	         // 1. 2배 길이의 배열 만든다.
	         // 2. 기존 배열의 각 방의 값을 새 배열에 복사한다.
	         // 3. 새 배열을 this.list에 넣는다.
	         
	         String[] temp = new String[this.list.length * 2];
	         for(int i=0; i< this.list.length; i++) {
	            temp[i] = this.list[i];
	         }
	         this.list = temp;
	      }

	      this.list[this.index] = s;
	      this.index++;
	   
	   } 
	
	public String get(int index) {
		
		
		return list[index]+ "";
	}



	public int size() {
		return this.index;
	}
	
	public void set(int index,String value) {
		 list[index] = value;
	
	}
	
	public void remove(int index) {
		
		 for(int i = index ; i<this.index; i++) {
			 list[i] = list [i+1];
		 } 
		 
		 this.index --;
		
	}
	
	public void add(int index,String value) {

		
		for(int i = this.index; i > index; i--) {
		
				list[i]= list[i-1];
	
		}
		
		list[index] = value;
	}
	
	
	public int indexOf(String value) {
	
		
		for(int i = 0; i<this.index+1 ; i++) {
			if(list[i]==value) {
				return i;
			}
		}
		
		return -2 ;
	}
	
	  public int lastIndexOf(String value) {
	      for(int i=this.index -1; i>=0; i--) { 
	         if(list[i] == value) {
	            return i;
	         } 
	      }
	      return -2;
	   }
		   
	
	public void clear() {
		if(index >= 0 && index<this.list.length)
		
		
		list = new String[4]; // 새로운 배열로 덮어쓰기

	}
		
}	
		
		

	
	

