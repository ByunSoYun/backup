package com.test.question.q17;

public class Book {
	
		private String title;
		private int price;
		private String author;
		private String publisher ;
		private String pubYear = "2021";
		private String ISBN;
		private int page;
		
		
		 public void setTitle(String title) throws Exception {
			 
				for (int i=0;i<title.length();i++) {
					
					char c = title.charAt(i);
					  if(
			                  (c >= (int)'a' && c <= (int)'z')
			               || (c >= (int)'A' && c <= (int)'Z')
			               || (c >= (int)'가' && c <= (int)'힣')
			               || (c >= (int)'0' && c <= (int)'9')
			               || (c == ' ') && title.length() >0 && title.length() <50
			               
			               ) {
			            this.title = title;
			         } //else throw new Exception("올바른 이름이 아닙니다.");
					
				}//for     
	
		}// setTitle
		 
		 public String getTitle() {
			      return this.title;
		 }//getTitle
		 
		 
			   
		 public void setPrice(int price) {
			 if(price>1000000||price < 0) {
				 System.out.println("가격을 다시 입력하시오");
				 
			 }// 유효성검사
		  this.price = price;
		 }//setPrice
		  
		  public int getPrice() {
		      return this.price;
		      
		 }//getPrice

		 public void setAuthor(String author) {
			
		 this.author = author; 
		}// setAuthor
		 
		 public String getAuthor() {
			      return this.author;
		 }//setAuthor
		 
		 public void setPublisher(String publisher) {
				
			 this.publisher = publisher; 
			}// setPublisher
		 
		 public String getpubYear() {
			 return pubYear;
		 }
		      
			public void setISBN(String ISBN) {
				
				this.ISBN = ISBN; 
			}

		 
		 public String getISBN() {
			 return this.ISBN;
		 }

		 
		 
		 public void setPage(int page) {
			 if(price<0) {
				 System.out.println("페이지수를 다시 입력하시오");
			 }// 유효성검사
			 
		  this.page = page;
		 }//setPrice
		  
		  public int getPage() {
		      return this.page;
		 }     
		
		  public String info() {
			  
			  String Bookinfo = "책 제목: "+ this.title+"\n"
						 + "가격: "+ this.price+"원\n"
						 + "저자: " + this.author+"님\n"
						 + "페이지수: "+ this.page+"page\n"
						 +"출판사: "+ this.publisher+"\n"
						 + "발행년도: "+ pubYear+"년\n"
						 + "ISBN: "+ this.ISBN+"\n";
						 	  
			 return Bookinfo;
		  }

		
	
		

	}//book




