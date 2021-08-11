package com.test.spring.aop;

public class Memo {

	/*
	public void add(String memo) {

		//보조업무 - 인증
		Auth auth = new Auth();
		auth.check();

		//1. 주업무 - 메모쓰기
		System.out.printf("메모쓰기: %s\n", memo);

		//보조업무 - 로그
		Logger logger = new Logger();
		logger.log("메모쓰기");
	}

	public void edit(int seq, String memo) {

		//보조업무 - 인증
		Auth auth = new Auth();
		auth.check();

		//2. 주업무 - 메모수정
		System.out.printf("메모수정: %d번 메모를 수정했습니다.\n", seq);

		//보조업무 - 로그
		Logger logger = new Logger();
		logger.log("메모쓰기");
	}

	public void del(int seq) {

		//보조업무 - 인증
		Auth auth = new Auth();
		auth.check();

		//3. 주업무 - 메모삭제
		System.out.printf("메모삭제: %d번 메모를 삭제했습니다.\n", seq);

		//보조업무 - 로그
		Logger logger = new Logger();
		logger.log("메모쓰기");
	}

	public void read(int seq) {

		//4. 주업무 - 메모읽기
		System.out.printf("메모읽기: %s번 메모를 읽습니다.\n", seq);

		//보조업무 - 로그
		Logger logger = new Logger();
		logger.log("메모쓰기");
	}
	*/

	public void add(String memo) {

		//1. 주업무 - 메모쓰기
		System.out.printf("메모쓰기: %s\n", memo);

	}

	public void edit(int seq, String memo) {

		//2. 주업무 - 메모수정
		System.out.printf("메모수정: %d번 메모를 수정했습니다.\n", seq);

	}

	public void del(int seq) {

		//3. 주업무 - 메모삭제
		System.out.printf("메모삭제: %d번 메모를 삭제했습니다.\n", seq);

	}

	public void read(int seq) {

		//4. 주업무 - 메모읽기
		System.out.printf("메모읽기: %s번 메모를 읽습니다.\n", seq);

	}


}







