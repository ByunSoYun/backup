package com.test.question.q10;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Calendar;

public class Q004 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		System.out.print("남자 이름:");
		String ManName = reader.readLine();
		
		System.out.print("여자 이름:");
		String WomanName = reader.readLine();
		
		System.out.print("만난날(년):");
		int MeetYear = Integer.parseInt(reader.readLine());
	
		System.out.print("만난날(월):");
		int MeetMonth = Integer.parseInt(reader.readLine());
	
		System.out.print("만난날(일):");
		int MeetDay = Integer.parseInt(reader.readLine());
	
		Calendar Meet = Calendar.getInstance();
		
		Meet.set(MeetYear, MeetMonth,MeetDay);

        Meet.add(Calendar.DATE, 100-1);//Meet 100일댐 
		
		System.out.printf("'%s'과(와) '%s'의 기념일 \n",ManName,WomanName);
		System.out.printf("100일 : %tF\n", Meet  );
		
		 Meet.add(Calendar.DATE, 100);//Meet 200일댐 
		 System.out.printf("200일 : %tF\n", Meet  );
		
		 Meet.add(Calendar.DATE, 100);//Meet 300일댐 
		 System.out.printf("300일 : %tF\n", Meet  );
		
		 Meet.add(Calendar.DATE, 200);//Meet 500일댐 
		 System.out.printf("500일 : %tF\n", Meet  );
		 
		 Meet.add(Calendar.DATE, 500);//Meet 1000일댐 
		 System.out.printf("1000일 : %tF\n", Meet  );
		
	}

	
	

		
	}


