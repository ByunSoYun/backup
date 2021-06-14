package com.test.question.q13;

public class Q007 {
	public static void main(String[] args) {
		
		for(int i=10; i<101; i+=10) {
			
			int sum = 0;
			for (int j =1; j<=i; j++) {
				sum+=j;
			}
			System.out.printf("1~%d : %d\n", i,sum);

		}
			
	}

}



//
//int sum = 0;
//
//for (int i=10; i<=100; i+=10) {
//   for (int j=1; j<=i; j++) {
//      sum+=j;
//   }
//   System.out.printf("1 ~ %d: %d\n", i, sum);
//   sum = 0;
//}