package com.test.java.collection;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class Ex67_Stack {
	public static void main(String[] args) {
		// Ex67_Stack.java		

	
		
		/*
		 Queue,큐
		 - 선입선출
		 -FIFO, First Input First Output
		 -줄서기 
		 
		 Stack 
		 -후입선출
		 -LIFO, Last Input First Output
		 - 메모리 영역, 히스토리 
		 
		 
		 
		 
		 */
	

	//
	
	//m1();
	
	m2();
	}//main
	
private static void m2() {
	
	//큐 , Queue
	// 	==============================
	// ->       노랑    파랑    빨강     ->  
	//  ==============================
	//		     2        1      0
	//Queue<String> queue = new Queue<String>();
	Queue<String> queue = new LinkedList<String>();
		
	
	//요소 추가 
	//Enqueue
	queue.add("빨강");
	queue.add("파랑");
	queue.add("노랑");
	
	System.out.println(queue.size());
	
	//요소 읽기(+삭제)
	// - Dequeue
	
	System.out.println(queue.poll());
	System.out.println(queue.size());

	System.out.println(queue.poll());
	System.out.println(queue.size());
	
	System.out.println(queue.poll());
	System.out.println(queue.size());
	
	queue.add("빨강");
	queue.add("파랑");
	queue.add("노랑");

	
	System.out.println(queue.peek());
	System.out.println(queue.size());
	
	while (queue.size() > 0) {
		System.out.println(queue.poll());
	}

}


// 0 1 2 
private static void m1() {
	
	//스택,Stack
		// 	==============================
		// <->       노랑    파랑    빨강   =  
		//  ==============================
		//			2		1		0

	Stack <String> stack = new Stack<String>();
	
	//요소 추가 
	stack.push("빨강");
	stack.push("파랑");
	stack.push("노랑");
	
	
	//요소 개수 
	System.out.println(stack.size());

	//요소 읽기 (+삭제)
//	System.out.println(stack.pop());
//	System.out.println(stack.size());
//	
//	System.out.println(stack.pop());
//	System.out.println(stack.size());
//	
//	System.out.println(stack.pop());
//	System.out.println(stack.size());
//	
//	System.out.println(stack.pop());
//	System.out.println(stack.size());
//	java.util.EmptyStackException -> 스택은 비어있다.

	
	//루프
//	while(stack.size()>0) {
//		System.out.println(stack.pop());
//		System.out.println(stack.size());
//	}
	
//	while(!stack.isEmpty()) {
//		System.out.println(stack.pop());
//		System.out.println(stack.size());
//	}

	
	System.out.println(stack.peek());
	System.out.println(stack.size());

	System.out.println(stack.peek());
	System.out.println(stack.size());
	
	System.out.println(stack.peek());
	System.out.println(stack.size());

	
	
	
	
	
	
}
	
	
	
	


}

