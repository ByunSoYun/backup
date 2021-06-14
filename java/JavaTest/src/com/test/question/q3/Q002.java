package com.test.question.q3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Q002 {

	public static void main(String[] args) throws IOException {
		
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		
		System.out.print("첫번째 숫자:  ");
		String num1 = reader.readLine();
		int inum1 = Integer.parseInt(num1);
		
		System.out.print("두번째 숫자:");
		String num2 = reader.readLine();
		int inum2 = Integer.parseInt(num2);
		
		
		int plus = inum1 + inum2;
		int minus = inum1 - inum2;
		int multi = inum1 * inum2;
		float division = inum1 / inum2;  
		int rest = inum1 % inum2;
	
				
				
		System.out.printf("%,d + %,d = ", inum1,inum2);
		System.out.printf("%,d \n",plus);
		
		System.out.printf("%,d - %,d = ", inum1,inum2);
		System.out.printf("%,d \n",minus);

		System.out.printf("%,d * %,d = ", inum1,inum2);
		System.out.printf("%,d \n",multi);

		System.out.printf("%,d / %,d= ", inum1,inum2);
		System.out.printf("%.1f \n", division);

		System.out.printf("%,d %% %,d = ", inum1,inum2);
		System.out.printf("%,d \n",rest);
	}
}
