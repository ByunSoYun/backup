package com.test.question.q15;

public class Q007 {
public static void main(String[] args) {
	
		int[]list= new int[10];
		
		
		add(list,5);
		add(list,6);
		add(list,1);
		add(list,3);
		add(list,2);
		
		insert(list, 2, 100);
	
		output(list);
	
	
	}//main
		
	private static void insert(int[] list, int index, int n) {
	
		for (int i =list.length-2; i>=index; i--) {
			list[i+1]=list[i];
		}
		list[index]=n;
		
	}

	private static void add(int[] list, int n) {

	int index = -1;
	
		for (int i =0; i<list.length; i++) {
			if(list[i]==0) {	
				index = i; // i번째 위치에서 0이면 밖으로 나온다 
				break;
			}
		}
		
		list[index] = n; // n의 값을 가장 앞의 빈칸에 넣는다 
	
	}
	
	private static void output(int[] list) {

		for(int i=0; i<list.length;i++) {
			System.out.printf("%d ",list[i]);
		
		}
	System.out.println();
	}//output 
	
}//Q007
