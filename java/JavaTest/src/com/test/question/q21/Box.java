package com.test.question.q21;



public class Box {
	//요구사항] 다량의 객체를 잘 제어할 수 있는지?
	private Macaron[] list = new Macaron[10];
	int pass = 0;
	public void cook() {
		for(int i = 0; i<this.list.length ; i++) {
			Macaron m = new Macaron();
			list[i] = m;
			
			m.setSize((int)(Math.random()*11)+5);
			   //Color
	         String color[] = new String[]{"red", "blue", "yellow", "white", "pink", "puple", "green", "black"}; //8가지
	         
	         list[i].setColor(color[(int)(Math.random() * color.length)]);
	         
	         //thickness
	         list[i].setThickness((int)(Math.random() * 20) + 1);
	         
			
		}
	System.out.printf("마카롱을 %d개 만들었습니다.\n",this.list.length);
	}
	
	public void check() {
		Macaron m = new Macaron();
		int pass = 0;
		int fail = 0;
		for (int i =0; i< this.list.length; i++) {
			if(list[i].getSize()>=8 || list[i].getSize()<=14){
				 pass ++;
			}else {
				
				fail++;
			}
		
		}
		for (int j =0; j< this.list.length; j++) {
			if(list[j].getColor() == "black") {
				fail++;
			}else if(list[j].getColor()=="red" || list[j].getColor()=="yellow" ||list[j].getColor()=="white"||list[j].getColor()=="purple"||list[j].getColor()=="pink"||list[j].getColor()=="green") {
				
				 pass ++;
			}
		}
		
		for (int k =0; k< this.list.length; k++) {
			if(list[k].getThickness()>= 3|| list[k].getThickness()<=18) {
				 pass ++;	
			}else {
				
				fail++;
			}
		}
		  System.out.printf("QC 합격 개수  : %d개 \nQC 불합격 개수 : %d개\n\n", pass, fail);
	      
		
	}
	
	public void list() {
		for(int i=0; i<this.list.length; i++) {
			System.out.printf("%d번 마카롱 : %dcm(%s,%dmm):%s\n", i+1,list[i].getSize(),list[i].getColor(),list[i].getThickness(),success(i));;
			
		}
	}
	
//성공 실패 여부 
	private String success(int i) {
	    if(//유효하지 않을때 
	            (list[i].getSize() < 8 || list[i].getSize() > 14)
	            || (list[i].getThickness() < 3 || list[i].getThickness() > 18 )
	            ||list[i].getColor().equals("black")
	         ) {

	        return "불합격";
	      } else  { 
	         return "합격";
	      }
	}
}//box
	
