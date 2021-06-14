package com.test.question.q22;

public class BallPointPen {
 private double thickness;
 private String color;
	
 
 public void setThickness(double thickness) throws Exception {
	 if(thickness == 0.3||thickness ==0.5|| thickness == 0.7 || thickness == 1.0 ||thickness == 1.5) {
		 this.thickness = thickness;
	 }else {
		 throw new Exception("올바른 두께가 아닙니다.");
	 }
	 		
	}
 
	public void setColor(String color) throws Exception {
		if(color == "red"||color == "green"||color == "blue"||color == "black") {
			this.color = color;
		}else {
			throw new Exception("올바른 색깔이 아닙니다.");
		}
	}
	 
	public String info() {
		
		return String.format("%s색상 %fmm 볼펜", this.color,this.thickness);
	}
 
}
