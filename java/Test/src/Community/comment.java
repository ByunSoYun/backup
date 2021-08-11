package Community;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class comment {

   public static void main(String[] args) {
	   int a = 0;
	   int b = 0;
	   Random random = new Random();
	   
      for (int i = 0; i < 500; i++) {
    	  a = random.nextInt(99)+1;
    	  b = random.nextInt(260)+1;
    	  
    	 
         System.out.printf(
               "INSERT INTO TBLCOMMUNITYCOMMENT (commentSeq ,memberSeq , communitySeq  , content , regdate) values (commentSeq.nextVal, %d , %d, '%s', '2021-07-01');\r\n",
                a, b, content());
    	
    	  
    	 
      }

   }
   


   // 댓글 생성하는 메소드

   public static String content(){

	      String[] cm = { "안녕하세요!!", "그렇습니다ㅋㅋ", "맞아요~!","아니요ㅠ","그래요~", "최고네요!!", "네? 어떤말씀이세요?", "ㅎㅎ 말씀 감사합니다", "조급해하지마세여 ㅋㅋ", "힘내세요~~", "모두 화이팅~!","동의합니다~","공부합시다 ㅠㅠ","취업 화이팅해여","ㅋㅋㅋㅋ","그러게요ㅎㅎ","맞습니다요~","하위","느낌이 좋네요~","홧팅홧팅~","취업은 어렵죠 ㅠ","아니아니요~"};
	      
	      Random rnd = new Random();

	      return cm[rnd.nextInt(cm.length)] ;
	      
	      
	   }

   



//	public static Integer memberSeq(){
//		
//		Random rnd = new Raddom
//		
//	}
	
	
}


   
   



//CREATE TABLE tblCommunityComment (
//		 commentSeq number NOT NULL,
//		 memberSeq number NOT NULL,
//		 communitySeq number NOT NULL,
//		 content varchar2(2000) NOT NULL,
//		 regdate date NOT NULL
//		);