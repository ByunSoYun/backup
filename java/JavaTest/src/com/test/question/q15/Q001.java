package com.test.question.q15;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Q001 {
	public static void main(String[] args) throws IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		int[] nums = new int[5];
		
		
		
		
		for(int i=0; i<nums.length; i++) {
			System.out.print("숫자: ");
			int input = Integer.parseInt(reader.readLine());
			nums[i]= input ;
			
			
		}
		
		for(int j = nums.length-1; j>=0; j--) {
		
			System.out.printf("nums[%d] = %d\n",j, nums[j]);
		}
	}

}

