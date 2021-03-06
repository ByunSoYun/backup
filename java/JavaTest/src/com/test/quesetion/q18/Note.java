package com.test.quesetion.q18;

public class Note {
	private String size ;
	private String color ;
	private int page;
	private String owner;
	 
	private int price  = 500;
	private  String Thickness = " ";
	
	public void setSize(String size) throws Exception {
	      this.size = size;  
	      char size1 = size.charAt(0);
	      char size2 = size.charAt(1);
	      if( size1 =='A') {
	    	  if(size2=='3') {
	    		  price +=400;
	    	  }else if(size2 =='4') {
	    		  price += 200;
	    	  }else if(size2=='5') {
	    		  price+=0;
	    	  }else {
	    		  throw new Exception("올바른 용지크기가 아닙니다.");
	    	  }
	      }
	      if( size1 =='B') {
	    	  if(size2=='3') {
	    		  price += 500;
	    	  }else if(size2=='4') {
	    		  price += 200;
	    	  }else if(size2=='5') {
	    		  price += 100;
	    	  }else {
	    		  throw new Exception("올바른 용지크기가 아닙니다.");
	    	  }
	    	  
	      
	      
	      
	      }
	
	      
	} //setSize 
	
	
	public void setColor(String color) throws Exception {
		this.color = color;
		if (color == "검정색") {
			price+= 200;
		}else if(color == "노란색") {
			price+= 200;
		}else if(color == "흰색") {
			price +=0;
		}else if(color == "파란색") {
			price+= 200;
		} else {
			throw new Exception("올바른 용지색상이 아닙니다.");	
		}
			
			
			
			
		
	}// setColor 
	
	
	
	
	
	
	
	
	
	public void setPage(int page) throws Exception {
		this.page = page;
		
			if(page>=10 && page<=50) {
				Thickness= "얇은";
			}else if(page>=51 && page<=100) {
				Thickness= "보통";
			}else if(page>=101 && page<=200) {
				Thickness= "두꺼운";
			}else {
				throw new Exception("올바른 용지페이지가 아닙니다.");
			}
			
			price += (page *10);
			
			
	}//setPage
	
	
	public void setOwner(String owner) throws Exception {
		this.owner = owner;
		
		for(int k = 0; k<owner.length(); k++) {
		char name = owner.charAt(k);
			if(name >= '가' && name <= '힣' && owner.length()>1 && owner.length()<6 ){
				
			}else {
				throw new Exception("올바른 이름이 아닙니다.");
			}
	    }	
    }	//setOwner
	
	
	
	
	
	public void info() {
		if (this.owner == null) {
			System.out.println("■ ■ ■ ■ ■ 노트정보 ■ ■ ■ ■ ■ \n주인없는노트\n■ ■ ■ ■ ■ ■ ■ ■ ■ ■ ■ ■ ■ ■ ■ ");
		}else {
			System.out.printf("■ ■ ■ ■ ■ 노트정보 ■ ■ ■ ■ ■ \n 소유자 :%s \n 특성 : %s %s %s노트 \n 가격: %,d원 \n■ ■ ■ ■ ■ ■ ■ ■ ■ ■ ■ ■ ■ ■ ■ ", this.owner,this.color,Thickness,this.size,price);
		}
	

	}
	
	
	
	
	
	
	
	
}//Class