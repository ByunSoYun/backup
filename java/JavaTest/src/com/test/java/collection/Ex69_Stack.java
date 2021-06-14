package com.test.java.collection;



public class Ex69_Stack {
	public static void main(String[] args) {
		
		
		MyStack stack = new MyStack();
		
		//추가 
		stack.push("빨강");
		stack.push("노랑");
		stack.push("파랑");
		stack.push("주황");
		stack.push("검정");
		
		//읽기 
		System.out.println(stack.pop());
		System.out.println(stack.pop());
		System.out.println(stack.pop());
		
		//개수 
		System.out.println(stack.size());
		
		//확인
		System.out.println(stack.peek());
		
		//크기조절 
		stack.trimToSize();
		
		//초기화
		stack.clear();
		System.out.println(stack.size());
	}//main 
	
}// Ex69
