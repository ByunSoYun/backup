package com.test.question.q4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Q007 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		System.out.print("역의 개수 : ");
		int numstation = Integer.parseInt(reader.readLine());
		
		System.out.print("환승역 개수 : ");
		int numtransfer = Integer.parseInt(reader.readLine());
		
		System.out.print("평상(0) 출근(1) 퇴근(2) 시간 선택하시오");
		int commutetime= Integer.parseInt(reader.readLine());

	
		
		System.out.printf("총 소요시간은 %d분 입니다.", getTime(numstation, numtransfer,commutetime));

		
	}//main
	
	public static int getTime(int numstation, int numtransfer, int commutetime) {
		int stationtime = 2;
		int transfertime = 3;
		
		transfertime = (commutetime == 0) ? transfertime : transfertime;
		transfertime = (commutetime == 1) ? transfertime+1 : transfertime;
		transfertime = (commutetime == 2) ? transfertime +2 : transfertime;
		
		return  numstation*stationtime + numtransfer*transfertime ;
		
	
	}

	
}
