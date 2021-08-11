package Community;

import java.util.Random;

public class communityRecommend {
	public static void main(String[] args) {
		
		for (int i = 0; i < 400; i++) {
	        
	        System.out.printf("INSERT INTO tblComScrap (comScrapSeq, communitySeq ,memberSeq) "
	               + "values (comScrapSeq.nextVal, %d, %d);\r\n",
	                ok() ,ssn());
	        
	     }

		
	}
//	INSERT INTO tblComScrap (comScrapSeq, communitySeq, memberSeq) values (comScrapSeq.nextVal, 1, 13);

	  public static int ssn() {

	     Random rand = new Random();

	     int one = (int)(Math.random() * 100) + 1;
	     //String two = (int)(Math.random() * 99) + "";
	    
	    
//	     INSERT INTO tblComScrap (comScrapSeq, communitySeq, memberSeq) values (comScrapSeq.nextVal, 68, 2);
	     return one;
	  }
	  public static int ok() {

		     Random rand = new Random();

		     int two = (int)(Math.random() * 260) + 1;
		     //String two = (int)(Math.random() * 99) + "";
		    
		    

		     return two;
		  }
		
}
