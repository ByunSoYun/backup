package com.test.java;

public class Task1 {
	public static void main(String[] args) {
	 
		String Name1 = "홍길동";
		String Name2 = "아무개";
		String Name3 = "하하하";
	   
		
		byte Kor1 = 80;
		byte Eng1 = 90;
		byte Math1 = 95;
		int Average1 = (Kor1+Eng1+Math1)/3; 
		
		
		byte Kor2 = 76;
		byte Eng2 = 86;
		byte Math2 = 79;
		int Average2 = (Kor2+Eng2+Math2)/3; 
		
		byte Kor3 = 89;
		byte Eng3 = 92;
		byte Math3 = 95;
		int Average3 = (Kor3+Eng3+Math3)/3; 
		
		System.out.println("[학생]   [국어]   [영어]   [수학]   [평균]	");
		System.out.println("-----------------------------------------");
		System.out.println( Name1 +"\t"	+ Kor1 + "\t" + Eng1 +"\t" +Math1+"\t"	+Average1);
		System.out.println( Name2 +"\t"	+ Kor2 + "\t" + Eng2 +"\t" +Math2+"\t"	+Average2);
		System.out.println( Name3 +"\t"	+ Kor3 + "\t" + Eng3 +"\t" +Math3+"\t"	+Average3);

		
	}

}


