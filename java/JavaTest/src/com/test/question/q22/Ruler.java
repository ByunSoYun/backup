package com.test.question.q22;

public class Ruler {
	private int length;
	private String shape;

	public void setLength(int length) throws Exception {
		if(length == 30 || length == 50 || length == 100) {
		this.length = length;

		}else {
			 throw new Exception("올바른 길이가 아닙니다.");
		}
	}
	public void setShape(String shape) throws Exception {
		if(shape == "줄자"|| shape == "운형자"||shape == "삼각자") {
			this.shape = shape;
		}
		else {
			 throw new Exception("올바른 모양이 아닙니다.");
		}
	}

	public String info() {
		
		return String.format("%dcm %s", this.length,this.shape);
	}
	
}