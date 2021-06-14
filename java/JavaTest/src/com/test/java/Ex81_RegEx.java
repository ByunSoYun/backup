package com.test.java;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Ex81_RegEx {

	public static void main(String[] args) {
		//m1();
		//m2();
		//m3();
		m4();
}
	private static void m4() {
		// TODO Auto-generated method stub
		
	}
	private static void m3() {
		//네이버 시작 페이지 -> 모든 URL을 수집 
		//-> 문자열\문자열
		Pattern p = Pattern.compile("(http|ftp|https):\\\\/\\\\/[\\\\w\\\\-_]+(\\\\.[\\\\w\\\\-_]+)+([\\\\w\\\\-\\\\.,@?^=%&amp;:/~\\\\+#]*[\\\\w\\\\-\\\\@?^=%&amp;/~\\\\+#])?");
		
		Matcher m = p.matcher(wholeText);
		
		while (m.find()) {
			
		}
	}
	private static void m2() {
		String txt = "안녕하세요. 홍길동입니다. 제 전화번호는 010-1234-5678입니다. 그리고 집 전화는 02-987-6543입니다. 연락주세요";
		
		//-txt- > 전화 번호 있는지 없는지?
		
		// 정규식 객체 생성 
		Pattern p = Pattern.compile("\\d{2,3}-\\d{3,4}-\\d{4}");
				
		//검색 
		Matcher m = p.matcher(txt);
		//System.out.println(m.find());
		
		if(m.find()) {
			System.out.println("게시물 작성 금지!!!");
			//어떤 전화번호를 작성했길래?
			System.out.println(m.group());
		}else {
			System.out.println("게시물 작성 완료");
		}
		
		
		//게시판 작성 -> 금지어 (바보, 멍청이)
		txt = "글을 쓰고 있습니다...바보";
		
		p = Pattern.compile("(바보|멍청이)");
		
		m = p.matcher(txt);
		
		if(m.find()) {
			System.out.println("금지어 사용!!!");
		}else { 
			System.out.println("통과~");
		}
		
		
		
		txt = "안녕하세요. 제 몸무게는 75kg입니다. 키는 175cm입니다.나이는 20살입니다.";
		// -> 숫자만 골라내시오 
		p = Pattern.compile("\\d{1,}");
		
		m.pattern().matcher(txt);
		
		while(m.find()) { // iter.hasNext()
			System.out.println(m.group());// iter.next();
			
		}
	}

	private static void m1() {
		
				//자바 + 정규식 
				// - 자바의 일부 메소드가 정규식을 지원
				String txt = "안녕하세요. 홍길동입니다. 제 전화번호는 010-1234-5678입니다. 그리고 집 전화는 02-987-6543입니다. 연락주세요";
				
				//게시판ㄴ 정책 - >연락처 작성금지 -> 마스킹 처리 
				//System.out.println(txt.replace("010-1234-5678", "xxx-xxxx-xxxx"));
				
				//CharSequence -> String 클래스의 부모 인터페이스 
				//System.out.println(txt.replaceAll("[0-9]{2,3}-[0-9]{3,4}-[0-9]{4}", "xxx-xxxx-xxxx"));
				
				//Pattern 클래스 
				//-정규식 지원
				
				String name = " 홍길동,, 아무개, 하하하, 호호호, 후후후";
		
		//분할 메소드 -> 구분자를 기준으로 문자를 자르는 기능
		//String[] result = name.split(",{1,4}");
		String[] result = name.split("[,\\.]");
		
//		for(String n : result) {
//			System.out.println(n);
//		}
		
		for(int i =0; i< result.length; i++) {
			System.out.printf("result[%d] = %s\n", i , result[i]);
		}
	}
		// TODO Auto-generated method stub
		
	}