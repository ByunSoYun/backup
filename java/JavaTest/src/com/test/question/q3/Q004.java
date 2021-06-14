package com.test.question.q3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Q004 {
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader reader = new BufferedReader (new InputStreamReader(System.in));
		System.out.printf("사용자가 페달을 밟은 횟수: ", reader);
		String Pedal = reader.readLine();
		int iPedal = Integer.parseInt(Pedal);
		
		double distance = 3.14 * 0.6604 * iPedal;
	
		System.out.printf("사용자가 총 %,d회 밟아 자전거가 총 %,.1fm를 달렸습니다.", iPedal,distance);

	}

}
