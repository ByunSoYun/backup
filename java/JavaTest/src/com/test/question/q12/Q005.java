package com.test.question.q12;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Q005 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		
		System.out.print("시작 숫자: ");
		int startnum = Integer.parseInt(reader.readLine());
		System.out.print("종료 숫자: ");
		int endnum = Integer.parseInt(reader.readLine());
		
		int sum = 0;
		
		for(int i = startnum; i <= endnum; i++) {
			
			sum+=i;
			
			
		if (i==endnum) {
			System.out.printf("%d=",i);
			}else {
		
			System.out.printf("%d+",i);
			}
		}
		
		System.out.println(sum);
		
	}//main

}
//
//
///for (int i = start; i <= end; i++) {
//    
//    sum += i;
//    
//    System.out.print(i);
//    
//    if (i <= end - 1) { // ( i < end)로 넣어도 됨
//       System.out.print(" + ");
//    }
//    
//    if (i == end) {
//       System.out.print(" = ");
//       System.out.print(sum);
//    }
// }