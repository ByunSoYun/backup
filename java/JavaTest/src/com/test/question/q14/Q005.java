package com.test.question.q14;

public class Q005 {
	public static void main(String[] args) {
		String content = "안녕~길동아~잘가~길동아~";
		String word = "길동";
			

		int count = 0;
		int index = 0;
		
		
		while (index != -1) {
			
			index = content.indexOf(word, index); //원하는 문자를 검색한곳의 위치의값 
			
			if (index > -1) {
				count++;  	// -1 이상이니까 발견하는 횟숫 1씩 더해짐 
				index += word.length(); // 무한루프에서 index의 값에 '길동'의 단어길이 더해서 루프 돌리기 
			}
			
		}
		
		System.out.printf("'%s'을(를) 총 %d회 발견했습니다.\n", word, count);
		
		
		
	}
}
