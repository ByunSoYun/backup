package com.test.question.q15;

public class Q003 {
	public static void main(String[] args) {
		int[] list = new int [4];
		list[0] = 10;
		list[1] = 20;
		list[2] = 30;
		list[3] = 40;
		String result = dump(list);
	
		System.out.printf("nums = [%s]\n",result);
	}//main

	private static String dump(int[] list) {
	
		String num ="" ;
		
		for(int i=0; i<4; i++) {
			  
			  num += list[i];
			
			  if(i==3) {
				  num += "";
			  }else {
				  num += ", ";
			  }
		}
	
		return  num ;
	}

}
