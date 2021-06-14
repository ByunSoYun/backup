package com.test.question.q10;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Calendar;
public class Q006_1 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		
	// Calendar 없이 int로 변수를 지정하여 코드를 완성하는 방법도 있다.
	//-> 이 방법으로 하면 분 계산이 자동으로 되지않기때문에 일일이 계산해야하여 불편함.
		System.out.println("음식을 받기 원하는 시각");
		System.out.print("시: ");
		int hour = Integer.parseInt(reader.readLine());
	
		System.out.print("분: ");
		int minute = Integer.parseInt(reader.readLine());
	
		int Zzajangminute = minute -10;
     	int Zzajanghour = Zzajangminute <0 ? hour-1 : hour ;
     	Zzajangminute = (Zzajangminute < 0 )? Zzajangminute + 60 : Zzajangminute ;
     

     	int chickenminute = minute - 18;
		int chickenhour = (chickenminute <0)? hour-1: hour;
		chickenminute = (chickenminute <0) ? (60+chickenminute): chickenminute;
		
		int pizzaminute = minute - 25;
		int pizzahour = (pizzaminute <0)? hour-1: hour;
		pizzaminute = (pizzaminute <0) ? (60+pizzaminute): pizzaminute;
		
		System.out.printf("짜장면 : %d시 %d분\n", zazanghour, zazangminute);		
		System.out.printf("치킨 : %d시 %d분\n", chickenhour, chickenminute);
		System.out.printf("피자 : %d시 %d분\n", pizzahour, pizzaminute );		
		System.out.println("");
	}
}