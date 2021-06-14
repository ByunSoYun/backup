package com.test.question.q22;

public class Eraser {
	
	private String size;
	
	public void setSize(String size) throws Exception {
		if(size == "Large"||size == "Medium"||size == "Small") {
			this.size = size;
		}else {
			 throw new Exception("올바른 크기가 아닙니다.");
		}
	         
	}
	
	public String info() {
			
			return String.format("%s 사이즈 지우개", this.size);
		}
}
