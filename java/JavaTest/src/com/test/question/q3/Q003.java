package com.test.question.q3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Q003 {
	public static void main(String[] args) throws IOException {
		
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		System.out.print("너비(cm): ");
		String width = reader.readLine();
		int iwidth = Integer.parseInt(width);
		
		System.out.print("높이(cm): " );
		String height = reader.readLine();
		int iheight = Integer.parseInt(height);
		
		
		int area = iwidth * iheight;
	    int circumference = (2*iwidth) + (2*iheight);
				
		System.out.printf("사각형의 넓이는 %dcm²입니다. \n", area);
		System.out.printf("사각형의 둘레는 %dcm입니다. \n", circumference);
				
		
		
	}

}
