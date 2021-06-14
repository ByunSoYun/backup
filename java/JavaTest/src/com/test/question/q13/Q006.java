package com.test.question.q13;

public class Q006 { 
	public static void main(String[] args) {
		
		for(int i = 1; i <= 9; i++) {
	         for(int j = 2; j <= 5; j++) {   
	            System.out.printf("%d x %d = %2d  ", j, i, j*i);
	         }
	         System.out.println();
	      }
	      System.out.println();
	      
	      for(int i = 1; i <= 9; i++) {
	         for(int j = 6; j <= 9; j++) {
	            System.out.printf("%d x %d = %2d  ", j, i, j*i);      
	         }
	         System.out.println();
	      }
	
		}
	}//main




//밑의 방법으로 하면 2단-5단 , 6단-9단 나눌 필요가 없어져서 더 편리하다 

//for (int a=2; a<=6; a+=4) {
//for (int i=1; i<=9; i++) {
//    for (int j=a; j<=a+3; j++) {
//       System.out.printf("%d x %d = %d\t", j, i, j*i);
//    }
//    System.out.println();
// }
// System.out.println();
//}



// for문을 풀어서 하는 방법 

//for (int dan=2; dan<=2; dan++) {
//    for (int i=1; i<=9; i++) {
//       System.out.printf("%d x %d = %d ", dan, i, dan * i);
//       System.out.printf("%d x %d = %d ", dan+1, i, (dan+1)*i);
//       System.out.printf("%d x %d = %d ", dan+2, i, (dan+2)*i);
//       System.out.printf("%d x %d = %d \n", dan+3, i, (dan+3)*i);
//    }
// }
// System.out.println();
// 
// for (int dan=6; dan<=6; dan++) {
//    for (int i=1; i<=9; i++) {
//       System.out.printf("%d x %d = %d ", dan, i, dan * i);
//       System.out.printf("%d x %d = %d ", dan+1, i, (dan+1)*i);
//       System.out.printf("%d x %d = %d ", dan+2, i, (dan+2)*i);
//       System.out.printf("%d x %d = %d \n", dan+3, i, (dan+3)*i);
//    }
// }
// 
//}
