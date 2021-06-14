package com.test.quesetion.q18;

public class Note_MainClass {
	public static void main(String[] args) throws Exception {
		Note note = new Note();
		
		note.setSize("B4");
		note.setColor("노란색");
		note.setPage(25);
		note.setOwner("홍길동");
		note.info();
		System.out.println();
		System.out.println();
		
		Note note2 = new Note();
		note2.setSize("A4");
		note2.setColor("검정색");
		note2.setPage(170);
		note2.setOwner("최효일");
		note2.info();
		
		
		
	}

	
}
