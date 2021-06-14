package com.test.question.q17;

public class MainClass {
	public static void main(String[] args) throws Exception {
		
		Book b1 = new Book();
	     
	      b1.setTitle("어린!왕자");
	    //  System.out.println(b1.getTitle());
	      
	      
	      b1.setPrice(15000);
	     // System.out.println(b1.getPrice());
	      
	      b1.setAuthor("생텍쥐페리");
	     // System.out.println(b1.getAuthor());
	      
	      
	      b1.setPublisher("도우출판");
	     
	      
	      b1.setPage(2000);
	     // System.out.println(b1.getPage());
	      
	      //System.out.println(b1.getpubYear());
	      
	     b1.setISBN("9879879687");
	     // System.out.println(b1.getISBN());
	      
	      System.out.println(b1.info());
	}//main
}
