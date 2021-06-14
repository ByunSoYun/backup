package com.test.question.q23;

public class Student {
	
	private String name;
	private int age;
	private int grade;
	private int classNumber;
	private int number;
	
	
	//기본생성자
	public Student() {
		
		this.name = "미정";
		this.age = 0;
		this.grade = 0;
		this.classNumber = 0;
		this.number = 0;
		
		
	}
	//생성자 오버로딩
	public Student(String name, int age, int grade,int classNumber,int number) {
		
		this.name = name;
		this.age = age;
		this.grade = grade;
		this.classNumber = classNumber;
		this.number = number;
		
		
	}
	//생성자 오버로딩
	public Student(String name, int age) {
		

		this.name = name;
		this.age = age;
		this.grade = 0;
		this.classNumber = 0;
		this.number = 0;
		
	}
	//생성자 오버로딩
	public Student(int grade,int classNumber,int number) {
		
		this.name = "미정";
		this.age = 0;
		this.grade = grade;
		this.classNumber = classNumber;
		this.number = number;
		
	}
	// info 생성
	public String info() {
		   
	      return this.name+ "(나이: " +( this.age != 0 ? this.age +"세" : "미정" ) +", 학년:"+(this.grade!= 0 ? this.grade:"미정" )
	            + ", 반: " + (this.classNumber!= 0 ? this.classNumber:"미정" ) +",번호: " +(this.number!=0 ? this.grade:"미정")+")";
	   
	   }
}
