package com.test.java.collection;

import java.util.Arrays;

public class MyStack {
	
	private String[] list;
	private int index;
	
	public MyStack() {
		this.list = new String[4];
		this.index = 0;
	}
	
	
	@Override
	public String toString() {
		return String.format("length: %d\nindex: %d\n%s"
							,list.length
							,this.index
							,Arrays.toString(this.list));
	}
	
	public void  push(String value) {
		doubling();
		this.list[this.index] = value;
		this.index++;
	}


	private void doubling(){
		if(this.index >= this.list.length ) {
			String[] temp = new String[this.list.length * 2];
			for(int i=0; i< this.list.length; i++) {
				temp[i] = this.list[i];
			}
			this.list = temp;
			
		}
	
	}


	
	public String pop() {
		
		String temp = this.list[this.index-1];
		
		//우측 쉬프트
		for (int i=this.index-1; i>=0; i--) {
			
			list[i+1] = list[i];
			
		}
	
		return temp;
	}



	public int size() {
		return this.index;
	}


	public String peek() {
		return this.list[this.index-1];
	}
	
	public void clear(){
		this.index = 0;
	}
	
	public void trimToSize() {
	String[] temp = new String[size()];
			
			for (int i=0; i<temp.length; i++) {
				temp[i] = this.list[i];
			}
			
			this.list = temp;//교체	
	
	}




}//class MyStack


