package com.test.question.q5;

public class d {
	public static void main(String[] args) {
		
		int count = 100;
		String[] name = new String[count];
	
		//이름(성)
		String[] n1 = {"김","이","박","최","정","한","유","조","임","왕","변","신","백","오","구","고","염","추"};
		//이름
		String[] n2 = {"대","은","창","미","준","우","나","혜","운","인","영","수","민","호","환","혁","현","희","준","원","소","윤","시","내","효","일","지","우","민","빛","화","학","래","인"};
			
		
		
		for (int i=0; i <count ; i++) {
				
				
				name[i]= n1[(int)(Math.random() * n1.length)]
						 +n2[(int)(Math.random() * n2.length)]
						+n2[(int)(Math.random() * n2.length)];
				System.out.println(name[i]);
				
		
		}
		
		
	}
}

