package com.test.question.q22;

public class Pencil {
	
	private String hardness;
	
	public void setHardness(String hardness) throws Exception {

		if(hardness=="4B" || hardness == "3B"||hardness == "2B"||hardness == "B"||hardness == "HB"||hardness == "H"||hardness == "2H"||hardness == "3H"||hardness == "4H") {
			this.hardness = hardness;
		}else {
			 throw new Exception("올바른 용량이 아닙니다.");
		}
	         
	}

	public String info() {
		
		return String.format("%s 진하기 연필", this.hardness);
	}
}
