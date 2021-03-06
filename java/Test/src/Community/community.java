package Community;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.Random;

public class community {
   
   public static void main(String[] args) {
      
      Random rnd = new Random();
      
      String[] title = {
            
            "2021 정보처리기사 1회 시험 정보",
            "2021 정보처리기사 2회 시험 정보",
            "2021 정보처리기사 3회 시험 정보",
            "2021 정보보안기사 1,2회 ",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            ""
            
            
            
      };
      
      String[] regdate = {
              
              "2021-07-01",
              "2021-07-02",
              "2021-07-03",
              "2021-07-04",
              "2021-07-05",
              "2021-07-06",
              "2021-07-07",
              "2021-07-08",
              "2021-07-09",
              "2021-07-10",
              "2021-07-11",
              "2021-07-12",
              "2021-07-13",
              "2021-07-14",
              "2021-07-15",
              "2021-07-16",
              "2021-07-17",
              "2021-07-18",
              "2021-07-19",
              "2021-07-20",
              "2021-07-21",
              "2021-07-22",
              "2021-07-23",
              "2021-07-24"
              
        };
      
      String[] content = {
    	  
    		 "2021 정보처리기사 1회 시험 정보 \r\n"
    		 + "\r\n"
    		 + "필기원서접수(인터넷)(휴일제외) 2021.01.25.(월) ~ 2021.01.28.(목)	\r\n"
    		 + "\r\n"
    		 + "필기시험 2021.03.07.(일)\r\n"
    		 + "\r\n"
    		 + "필기합격(예정자)발표 2021.03.19.(금)\r\n"
    		 + "\r\n"
    		 + "응시자격 서류 제출 2021.03.08.(월) ~ 2021.03.30.(화)	\r\n"
    		 + "\r\n"
    		 + "실기원서접수(휴일제외)  2021.03.31.(수) ~ 2021.04.05.(월)	\r\n"
    		 + "\r\n"
    		 + "실기시험 2021.04.24.(토) ~ 2021.05.07.(금)		\r\n"
    		 + "\r\n"
    		 + "최종합격자 발표일 2021.05.21.(금) ~ 2021.07.21.(수)	\r\n"
    		 + "\r\n"
    		 + "\r\n"
    		 + "정보처리기사 기본 정보 \r\n"
    		 + "\r\n"
    		 + "1. 개요\r\n"
    		 + "\r\n"
    		 + " - 컴퓨터를 효과적으로 활용하기 위해서 하드웨어뿐만 아니라 정교한 소프트웨어가 필요하다. 이에 따라 우수한 프로그램을 개발하여 업무의 효율성을 높이고, 궁극적으로 국가발전에 이바지하기 위해서 컴퓨터에 관한 전문적인 지식과 기술을 갖춘 사람을 양성할 목적으로 제정됨.\r\n"
    		 + "\r\n"
    		 + "실시기관 홈페이지\r\n"
    		 + "\r\n"
    		 + "2. 실시기관 홈페이지\r\n"
    		 + " - http://www.q-net.or.kr\r\n"
    		 + "\r\n"
    		 + "3. 진로 및 전망\r\n"
    		 + "\r\n"
    		 + " - 기업체 전산실, 소프트웨어 개발업체, SI(system integrated)업체(정보통신, 시스템 구축회사 등), 정부기관, 언론기관, 교육 및 연구기관, 금융기관, 보험업, 병원 등 컴퓨터 시스템을 개발 및 운용하거나, 데이터 통신을 이용하여 정보처리를 시행하는 업체에서 활동하고 있다. 품질검사 전문기관 기술인력과 감리원 자격을 취득하여 감리 전문회사의 감리원으로 진출할 수 있다.\r\n"
    		 + "\r\n"
    		 + " - 정보화사회로 이행함에 따라 지식과 정보의 양이 증대되어 작업량과 업무량이 급속하게 증가했다. 또한 각종 업무의 전산화 요구가 더욱 증대되어 사회 전문분야로 컴퓨터 사용이 보편화되면서 컴퓨터산업은 급속도로 확대되었다. 컴퓨터산업의 확대는 곧 이 분야의 전문인력에 대한 수요 증가로 이어졌다.",
            "2021 정보처리기사 2회 시험 정보 \r\n"
            + "\r\n"
            + "필기원서접수(인터넷)(휴일제외) 2021.04.12.(월) ~ 2021.04.15.(목)\r\n"
            + "\r\n"
            + "필기시험 2021.05.15.(토)\r\n"
            + "\r\n"
            + "필기합격(예정자)발표  2021.06.02.(수)\r\n"
            + "\r\n"
            + "응시자격 서류 제출 2021.05.17.(월) ~ 2021.06.11.(금)\r\n"
            + "\r\n"
            + "실기원서접수(휴일제외)  2021.06.14.(월) ~ 2021.06.17.(목)\r\n"
            + "\r\n"
            + "실기시험 2021.07.10.(토) ~ 2021.07.24.(토)	\r\n"
            + "\r\n"
            + "최종합격자 발표일 2021.08.06.(금) ~ 2021.10.06.(수)\r\n"
            + "\r\n"
            + "\r\n"
            + "정보처리기사 기본 정보 \r\n"
            + "\r\n"
            + "1. 개요\r\n"
            + "\r\n"
            + " - 컴퓨터를 효과적으로 활용하기 위해서 하드웨어뿐만 아니라 정교한 소프트웨어가 필요하다. 이에 따라 우수한 프로그램을 개발하여 업무의 효율성을 높이고, 궁극적으로 국가발전에 이바지하기 위해서 컴퓨터에 관한 전문적인 지식과 기술을 갖춘 사람을 양성할 목적으로 제정됨.\r\n"
            + "\r\n"
            + "실시기관 홈페이지\r\n"
            + "\r\n"
            + "2. 실시기관 홈페이지\r\n"
            + " - http://www.q-net.or.kr\r\n"
            + "\r\n"
            + "3. 진로 및 전망\r\n"
            + "\r\n"
            + " - 기업체 전산실, 소프트웨어 개발업체, SI(system integrated)업체(정보통신, 시스템 구축회사 등), 정부기관, 언론기관, 교육 및 연구기관, 금융기관, 보험업, 병원 등 컴퓨터 시스템을 개발 및 운용하거나, 데이터 통신을 이용하여 정보처리를 시행하는 업체에서 활동하고 있다. 품질검사 전문기관 기술인력과 감리원 자격을 취득하여 감리 전문회사의 감리원으로 진출할 수 있다.\r\n"
            + "\r\n"
            + " - 정보화사회로 이행함에 따라 지식과 정보의 양이 증대되어 작업량과 업무량이 급속하게 증가했다. 또한 각종 업무의 전산화 요구가 더욱 증대되어 사회 전문분야로 컴퓨터 사용이 보편화되면서 컴퓨터산업은 급속도로 확대되었다. 컴퓨터산업의 확대는 곧 이 분야의 전문인력에 대한 수요 증가로 이어졌다.",

            "2021 정보처리기사 3회 시험 정보 \r\n"
            + "\r\n"
            + "필기원서접수(인터넷)(휴일제외) 2021.07.12.(월) ~ 2021.07.15.(목)		\r\n"
            + "\r\n"
            + "필기시험 2021.08.14.(토)	\r\n"
            + "\r\n"
            + "필기합격(예정자)발표 2021.09.01.(수)	\r\n"
            + "\r\n"
            + "응시자격 서류 제출 2021.08.16.(월) ~ 2021.09.10.(금)	\r\n"
            + "\r\n"
            + "실기원서접수(휴일제외)  2021.09.13.(월) ~ 2021.09.16.(목)		\r\n"
            + "\r\n"
            + "실기시험 2021.10.16.(토) ~ 2021.10.29.(금)			\r\n"
            + "\r\n"
            + "최종합격자 발표일 2021.11.12.(금) ~ 2022.01.12.(수)	\r\n"
            + "\r\n"
            + "\r\n"
            + "정보처리기사 기본 정보 \r\n"
            + "\r\n"
            + "1. 개요\r\n"
            + "\r\n"
            + " - 컴퓨터를 효과적으로 활용하기 위해서 하드웨어뿐만 아니라 정교한 소프트웨어가 필요하다. 이에 따라 우수한 프로그램을 개발하여 업무의 효율성을 높이고, 궁극적으로 국가발전에 이바지하기 위해서 컴퓨터에 관한 전문적인 지식과 기술을 갖춘 사람을 양성할 목적으로 제정됨.\r\n"
            + "\r\n"
            + "실시기관 홈페이지\r\n"
            + "\r\n"
            + "2. 실시기관 홈페이지\r\n"
            + " - http://www.q-net.or.kr\r\n"
            + "\r\n"
            + "3. 진로 및 전망\r\n"
            + "\r\n"
            + " - 기업체 전산실, 소프트웨어 개발업체, SI(system integrated)업체(정보통신, 시스템 구축회사 등), 정부기관, 언론기관, 교육 및 연구기관, 금융기관, 보험업, 병원 등 컴퓨터 시스템을 개발 및 운용하거나, 데이터 통신을 이용하여 정보처리를 시행하는 업체에서 활동하고 있다. 품질검사 전문기관 기술인력과 감리원 자격을 취득하여 감리 전문회사의 감리원으로 진출할 수 있다.\r\n"
            + "\r\n"
            + " - 정보화사회로 이행함에 따라 지식과 정보의 양이 증대되어 작업량과 업무량이 급속하게 증가했다. 또한 각종 업무의 전산화 요구가 더욱 증대되어 사회 전문분야로 컴퓨터 사용이 보편화되면서 컴퓨터산업은 급속도로 확대되었다. 컴퓨터산업의 확대는 곧 이 분야의 전문인력에 대한 수요 증가로 이어졌다.",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
      
            
      };
      
//      Connection conn = null;
//      PreparedStatement pstat = null;
//      
//      try {
//         
//         String sql = "insert into tblTechQna (techQnaSeq, memberSeq, title, content, regdate, readCount) values (techQnaSeq.nextVal, ?, ?, ?, default, default)";
//         
//         conn = DBUtil.open();
//         
//         pstat = conn.prepareStatement(sql);
//         
//         for (int i=0; i<100; i++) {
//            
//            pstat.setInt(1, memberSeq);
//            pstat.setString(2, title[rnd.nextInt(title.length)]);
//            pstat.setString(3, content[rnd.nextInt(content.length)]);
//            
//            pstat.executeUpdate();
//            
//         }
//         
//         pstat.close();
//         conn.close();
//         
//      } catch (Exception e) {
//         e.printStackTrace();
//      }
      
      int n = 0;
      
      for (int i=0; i<100; i++) {
         
         int memberSeq = (int)rnd.nextInt(100) + 1;
         
         int commentSeq =(int)rnd.nextInt(100) + 1;
         
         System.out.printf("INSERT INTO TBLCOMMUNITY (communitySeq ,memberSeq , commentSeq  , category , title, content,regdate ,readCount,image) values (communitySeq.nextVal, %d, %d ,'자격증 정보','%s', '%s', '%s', 0);\r\n", memberSeq, commentSeq, title[n], content[n], regdate[n]);
         
         n++;
         
         if (n > 20) {
            
            n = 0;
            
            
            
         }
         
      }
      
   }

}