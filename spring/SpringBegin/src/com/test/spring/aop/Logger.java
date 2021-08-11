package com.test.spring.aop;

import java.util.Calendar;

public class Logger {

	public void log(String message) {

		//시간 기록(DB)
		System.out.printf("[log] %tT. %s\n", Calendar.getInstance(), message);
	}

	public void log() {

		//시간 기록(DB)
		System.out.printf("[log] %tT\n", Calendar.getInstance());
	}

}
