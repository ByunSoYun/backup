package com.test.question.q15;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Q005 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		System.out.print("최대 범위 : ");
		int max = Integer.parseInt(reader.readLine());
		
		System.out.print("최소 범위 : ");
		int min = Integer.parseInt(reader.readLine());
		
		int num [] = new int [20];
		for(int i = 1; i<num.length; i++) {
			num[i] = (int)(Math.random()*20) + 1;
		}
		System.out.println("원본: "+dump(num));
		System.out.print("결과: [");
		for(int i = 0; i<num.length; i++) {
			if(num[i]>=min &&num[i]<=max)
				System.out.print(num[i]+",");
		}
		System.out.print("]");
	}//main 

	private static String dump(int[] list) {
		String result = "[";
		for(int i=0; i<list.length; i++) {
			result+= list[i]+",";
		}
		result += "]";
		return result;
	}
	

}
