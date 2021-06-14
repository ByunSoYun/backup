package com.test.question.q11;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Q005 {
	public static void main(String[] args) throws IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		System.out.print("첫번째 숫자:");
		int num1 = Integer.parseInt(reader.readLine());
		
		System.out.print("두번째 숫자:");
		int num2 = Integer.parseInt(reader.readLine());
		
		System.out.print("연산자:");
		String operator = reader.readLine();
	
		 if (operator.equals("+")) { 
			 System.out.printf("%d + %d = %d", num1,num2, num1+num2);
			 
		 } else if (operator.equals("-")) { 
			 System.out.printf("%d - %d = %d", num1,num2, num1-num2);
			 
		 } else if (operator.equals("*")) { 
			 System.out.printf("%,d * %,d = %,d", num1,num2, num1*num2);
			 
		 } else if (operator.equals("/")) { 
			 System.out.printf("%d / %d = %.1f", num1,num2, (double)num1/num2);
			 
		 } else if (operator.equals("%")) { 
			 System.out.printf("%d %% %d = %d", num1,num2, num1%num2);
			 
		 } else {
			 System.out.println();
		 }
	
	
	
	
	
	
	
	}

}


//  + : 43 /- : 45  /*= 42  / /: 47  /  % : 37