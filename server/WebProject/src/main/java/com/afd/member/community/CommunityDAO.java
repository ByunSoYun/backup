package com.afd.member.community;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;

import com.afd.DBUtil;


/**

 * 메소드들을 모아놓은 클래스 

 * @author 3조

 *   
 *
 */
public class CommunityDAO {
   private Connection conn;
   private Statement stat;
   private PreparedStatement pstat;
   private ResultSet rs;
   
   /**

    * 

    * @author 3조

    *  데이터베이스를 연결해주는 메소드
    *
    */
   
   public CommunityDAO() {
      
      try {
         
         
         conn = DBUtil.open();
         
         
         
      } catch (Exception e) {
         System.out.println("CommunityDAO.CommunityDAO()");
         e.printStackTrace();
      }
      
   }
   
//   
//   CREATE TABLE tblCommunity (
//          communitySeq number NOT NULL,
//          memberSeq number NOT NULL,
//          category varchar2(50) NOT NULL,
//          title varchar2(200) NOT NULL,
//          content varchar(4000) NOT NULL,
//          regdate date DEFAULT sysdate NOT NULL,
//          readCount number DEFAULT 0 NOT NULL
//         );

   
   /**

    * @return 성공1 실패0

    * @author 3조
    * 
    *  @param ComunnityDTO dto 

    * AddOk 서블릿에서 가져온 값을 게시글 테이블에 insert해주는 메소드
    *
    */

   public int add(CommunityDTO dto) {
      
      try {
         
         String sql = "insert into tblCommunity (communitySeq, memberSeq, category, title, content, regdate, readCount)"
               + "values (communitySeq.nextVal, ?, ?, ?, ?, default, default)";
         
         pstat = conn.prepareStatement(sql);
         
         
         pstat.setString(1, dto.getMemberseq());
         pstat.setString(2, dto.getCategory());
         pstat.setString(3, dto.getTitle());
         pstat.setString(4, dto.getContent());
         
      
         return pstat.executeUpdate(); //성공하면 1 실패하면 0
         
         

      } catch (Exception e) {
         System.out.println(e);
         e.printStackTrace();
      }
      
      
      return 0;
   }

   
   /**

    * @return list

    * @author 3조

    *  @param HashMap<String, String> map

    * List서블릿으로 게시글 테이블이 가지고 있는 값의 list를 가져오는 메소드 
    *
    */
   
   //List 서블릿이 게시판 목록을 달라고..
      public ArrayList<CommunityDTO> list(HashMap<String, String> map) {
         
         try {
            
                
            //2. 검색하기
            String where = "";
            String sql = "";
            //System.out.println("column"+ map.get("column"));
            //System.out.println("search"+ map.get("search"));
            
            if (map.get("isSearch").equals("y")) {
               //검색
               //where name like '%홍길동%'
               //where subject like '%날씨%'
            
               if(map.get("column").equals("all")) {
                  where = String.format("title like '%%%s%%' or content like '%%%s%%'"
                                       ,map.get("search"), map.get("search"));
               }else if(map.get("column").equals("title")){
                  where = String.format(" title like '%%%s%%' ",  map.get("search"));
               }else if(map.get("column").equals("nickname")){
                  where = String.format(" nickname like '%%%s%%' ",map.get("search"));
               }else if(map.get("column").equals("content")){
                  where = String.format("content like '%%%s%%' ",map.get("search"));}
               
                sql = String.format("select * from vwPost where  %s order by regdate desc" , where);
                  
            
            
            } else if (map.get("isSearch").equals("n")) {
               
               if (sql == null || sql.equals("")) {
                  
                  sql = String.format("select * from vwPost where rnum between %s and %s order by regdate desc", map.get("begin"), map.get("end"));
                  
               }
               
               if (map.get("orderRegdate") != null && map.get("orderRegdate").equals("regdate")) {
                  
                  sql = String.format("select v.* , rownum  from (select * from vwpost order by regdate desc)v where rownum between %s and %s", map.get("begin"), map.get("end"));
                  
               } else if (map.get("orderRecommendCount") != null && map.get("orderRecommendCount").equals("recommendCount")) {
                  
                  sql = String.format("select v.* , rownum  from (select * from vwpost order by recommendcount desc)v where rownum between %s and %s", map.get("begin"), map.get("end"));
                  
               } else if (map.get("orderComment") != null && map.get("orderComment").equals("ccnt")) {
                  
                  sql = String.format("select v.* , rownum  from (select * from vwpost order by commentCount desc)v where rownum between %s and %s", map.get("begin"), map.get("end"));
                  
               } else if (map.get("orderReadCount") != null && map.get("orderReadCount").equals("readCount")) {
                  
                  sql = String.format("select v.* , rownum  from (select * from vwpost order by readcount desc)v where rownum between %s and %s", map.get("begin"), map.get("end"));
                  
               }
               
            } 
            
            System.out.println("SQL문: " + sql);
               
            pstat = conn.prepareStatement(sql);

            rs = pstat.executeQuery();
            
            
         
            //이 메소드 입장
            //1. 목록보기
            //2. 검색하기
            
                              
            ArrayList<CommunityDTO> list = new ArrayList<CommunityDTO>(); //옮겨 담을 큰상자
            
            while (rs.next()) {
               
               //레코드 1줄 -> BoardDTO 1개
               CommunityDTO dto = new CommunityDTO();
               
                 dto.setRnum(rs.getString("rnum"));
                 dto.setSeq(rs.getString("seq")); //dto.setId(rs.getString("id"));
                 dto.setMemberseq(rs.getString("memberseq"));
                 dto.setCategory(rs.getString("category"));
                 dto.setTitle(rs.getString("title"));
                 dto.setContent(rs.getString("content"));
                 dto.setIsnew(rs.getString("isnew"));
                 dto.setRegdate(rs.getString("regdate")); //글쓰고 난뒤 며칠이 지났는지 시간
                 dto.setContent(rs.getString("content"));
                 dto.setNickname(rs.getString("nickname"));
                 dto.setReadcount(rs.getString("readcount"));
                 dto.setScrapcount(rs.getInt("scrapcount"));
                 dto.setRecommendcount(rs.getInt("recommendcount"));
                 dto.setDecommendcount(rs.getInt("decommendcount"));
                 dto.setCommentcount(rs.getInt("commentcount"));
               
                 
               
               list.add(dto);
               
               
            }
            
               
            return list;         
            
         } catch (Exception e) {
            System.out.println("CommunityDAO.list()");
            e.printStackTrace();
         }
         
         return null;
      }
      
      
      /**

       * @return list

       *  @param HashMap<String, String> map

       * @author 3조

       * Livestroy 서블릿으로 게시글 테이블이 가지고 있는 값의 list를 가져오는 메소드 
       *
       */
      
      public ArrayList<CommunityDTO> livestroylist(HashMap<String, String> map) {
         
         try {
            
             
            //2. 검색하기
            String where = "";
            String sql = "";
            //System.out.println("column"+ map.get("column"));
            //System.out.println("search"+ map.get("search"));
            if (map.get("isSearch").equals("y")) {
               //검색
               //where name like '%홍길동%'
               //where subject like '%날씨%'
            
               if(map.get("column").equals("all")) {
                  where = String.format("title like '%%%s%%' or content like '%%%s%%'"
                                       ,map.get("search"), map.get("search"));
               }else if(map.get("column").equals("title")){
                  where = String.format(" title like '%%%s%%' ",  map.get("search"));
               }else if(map.get("column").equals("nickname")){
                  where = String.format(" nickname like '%%%s%%' ",map.get("search"));
               }else if(map.get("column").equals("content")){
                  where = String.format("content like '%%%s%%' ",map.get("search"));}
               
                sql = String.format("select * from vwlivestory where  %s order by regdate desc" , where);
                  
            
            
            } else if (map.get("isSearch").equals("n")) {
               
               if (sql == null || sql.equals("")) {

                  sql = String.format("select * from vwlivestory where rnum between %s and %s order by regdate desc", map.get("begin"), map.get("end"));
                  
               }
               
               if (map.get("orderRegdate") != null && map.get("orderRegdate").equals("regdate")) {
                  
                  sql = String.format("select v.* , rownum  from (select * from vwlivestory order by regdate desc)v where rownum between %s and %s", map.get("begin"), map.get("end"));
                  
               } else if (map.get("orderRecommendCount") != null && map.get("orderRecommendCount").equals("recommendCount")) {
                  
                  sql = String.format("select v.* , rownum  from (select * from vwlivestory order by recommendcount desc)v where rownum between %s and %s", map.get("begin"), map.get("end"));
                  
               } else if (map.get("orderComment") != null && map.get("orderComment").equals("ccnt")) {
                  
                  sql = String.format("select v.* , rownum  from (select * from vwlivestory order by commentCount desc)v where rownum between %s and %s", map.get("begin"), map.get("end"));
                  
               } else if (map.get("orderReadCount") != null && map.get("orderReadCount").equals("readCount")) {
                  
                  sql = String.format("select v.* , rownum  from (select * from vwlivestory order by readcount desc)v where rownum between %s and %s", map.get("begin"), map.get("end"));
                  
               }
               
            } 
            
            
            
            System.out.println("SQL문: " + sql);
            
            pstat = conn.prepareStatement(sql);

            rs = pstat.executeQuery();
            
            
            //이 메소드 입장
            //1. 목록보기
            //2. 검색하기
            
                              
            ArrayList<CommunityDTO> list = new ArrayList<CommunityDTO>(); //옮겨 담을 큰상자
            
            while (rs.next()) {
               
               //레코드 1줄 -> BoardDTO 1개
               CommunityDTO dto = new CommunityDTO();
               
                 dto.setRnum(rs.getString("rnum"));
                 dto.setSeq(rs.getString("seq")); //dto.setId(rs.getString("id"));
                 dto.setMemberseq(rs.getString("memberseq"));
                 dto.setCategory(rs.getString("category"));
                 dto.setTitle(rs.getString("title"));
                 dto.setContent(rs.getString("content"));
                 dto.setRegdate(rs.getString("regdate")); //글쓰고 난뒤 며칠이 지났는지 시간
                 dto.setContent(rs.getString("content"));
                 dto.setIsnew(rs.getString("isnew"));
                 dto.setNickname(rs.getString("nickname"));
                 dto.setReadcount(rs.getString("readcount"));
                 dto.setScrapcount(rs.getInt("scrapcount"));
                 dto.setRecommendcount(rs.getInt("recommendcount"));
                 dto.setDecommendcount(rs.getInt("decommendcount"));
                 dto.setCommentcount(rs.getInt("commentcount"));
               
                 
               
                 list.add(dto);
               
               
            }
            
               
            return list;         
            
         } catch (Exception e) {
            System.out.println("CommunityDAO.list()");
            e.printStackTrace();
         }
         return null;
      }

      /**

       * @return list

       * @author 3조
       *  @param HashMap<String, String> map


       *  Itevent 서블릿으로 게시글 테이블이 가지고 있는 값의 list를 가져오는 메소드 
       *
       */
      public ArrayList<CommunityDTO> iteventlist(HashMap<String, String> map) {
         
         try {
            
             
            //2. 검색하기
            String where = "";
            String sql = "";
            //System.out.println("column"+ map.get("column"));
            //System.out.println("search"+ map.get("search"));
            
            if (map.get("isSearch").equals("y")) {
               //검색
               //where name like '%홍길동%'
               //where subject like '%날씨%'
            
               if(map.get("column").equals("all")) {
                  where = String.format("title like '%%%s%%' or content like '%%%s%%'"
                                       ,map.get("search"), map.get("search"));
               }else if(map.get("column").equals("title")){
                  where = String.format(" title like '%%%s%%' ",  map.get("search"));
               }else if(map.get("column").equals("nickname")){
                  where = String.format(" nickname like '%%%s%%' ",map.get("search"));
               }else if(map.get("column").equals("content")){
                  where = String.format("content like '%%%s%%' ",map.get("search"));}
               
                sql = String.format("select * from vwitevent where  %s and category= 'IT 행사' order by regdate desc" , where);
                  
               
            
            }else if (map.get("isSearch").equals("n")) {
               
               if (sql == null || sql.equals("")) {

                  sql = String.format("select * from vwitevent where rnum between %s and %s and category= 'IT 행사' order by regdate desc", map.get("begin"), map.get("end"));
                  
               }
               if (map.get("orderRegdate") != null && map.get("orderRegdate").equals("regdate")) {
                  
                  sql = String.format("select v.* , rownum  from (select * from vwitevent order by regdate desc)v where rownum between %s and %s", map.get("begin"), map.get("end"));
                  
               } else if (map.get("orderRecommendCount") != null && map.get("orderRecommendCount").equals("recommendCount")) {
                  
                  sql = String.format("select v.* , rownum  from (select * from vwitevent order by recommendcount desc)v where rownum between %s and %s", map.get("begin"), map.get("end"));
                  
               } else if (map.get("orderComment") != null && map.get("orderComment").equals("ccnt")) {
                  
                  sql = String.format("select v.* , rownum  from (select * from vwitevent order by commentCount desc)v where rownum between %s and %s", map.get("begin"), map.get("end"));
                  
               } else if (map.get("orderReadCount") != null && map.get("orderReadCount").equals("readCount")) {
                  
                  sql = String.format("select v.* , rownum  from (select * from vwitevent order by readcount desc)v where rownum between %s and %s", map.get("begin"), map.get("end"));
                  
               }
   
               
            } 
      
            
            System.out.println("SQL문: " + sql);
            
            pstat = conn.prepareStatement(sql);

            rs = pstat.executeQuery();
            
            
            
            System.out.println(sql);
            
            //이 메소드 입장
            //1. 목록보기
            //2. 검색하기
            
                              
            ArrayList<CommunityDTO> list = new ArrayList<CommunityDTO>(); //옮겨 담을 큰상자
            
            while (rs.next()) {
               
               //레코드 1줄 -> BoardDTO 1개
               CommunityDTO dto = new CommunityDTO();
               
                 dto.setRnum(rs.getString("rnum"));
                 dto.setSeq(rs.getString("seq")); //dto.setId(rs.getString("id"));
                 dto.setMemberseq(rs.getString("memberseq"));
                 dto.setCategory(rs.getString("category"));
                 dto.setTitle(rs.getString("title"));
                 dto.setContent(rs.getString("content"));
                 dto.setRegdate(rs.getString("regdate")); //글쓰고 난뒤 며칠이 지났는지 시간
                 dto.setContent(rs.getString("content"));
                 dto.setNickname(rs.getString("nickname"));
                 dto.setReadcount(rs.getString("readcount"));
                 dto.setIsnew(rs.getString("isnew"));
                 dto.setScrapcount(rs.getInt("scrapcount"));
                 dto.setRecommendcount(rs.getInt("recommendcount"));
                 dto.setDecommendcount(rs.getInt("decommendcount"));
                 dto.setCommentcount(rs.getInt("commentcount"));
               
                 
               
                 list.add(dto);
               
               
            }
            
               
            return list;         
            
         } catch (Exception e) {
            System.out.println("CommunityDAO.list()");
            e.printStackTrace();
         }
         return null;
      }
      
      
      /**

       * @return list

       * @author 3조
    *  @param HashMap<String, String> map

       * Review 서블릿으로 게시글 테이블이 가지고 있는 값의 list를 가져오는 메소드 
       *
       */
   public ArrayList<CommunityDTO> reviewlist(HashMap<String, String> map) {
         
         try {
            
             
            //2. 검색하기
            String where = "";
            String sql = "";
            //System.out.println("column"+ map.get("column"));
            //System.out.println("search"+ map.get("search"));
            
            if (map.get("isSearch").equals("y")) {
               //검색
               //where name like '%홍길동%'
               //where subject like '%날씨%'
            
               if(map.get("column").equals("all")) {
                  where = String.format("title like '%%%s%%' or content like '%%%s%%'"
                                       ,map.get("search"), map.get("search"));
               }else if(map.get("column").equals("title")){
                  where = String.format(" title like '%%%s%%' ",  map.get("search"));
               }else if(map.get("column").equals("nickname")){
                  where = String.format(" nickname like '%%%s%%' ",map.get("search"));
               }else if(map.get("column").equals("content")){
                  where = String.format("content like '%%%s%%' ",map.get("search"));}
               
                sql = String.format("select * from vwreview where  %s  order by regdate desc" , where);
            
            }else if (map.get("isSearch").equals("n")) {
               
               if (sql == null || sql.equals("")) {

                  sql = String.format("select * from vwreview where rnum between %s and %s  order by regdate desc", map.get("begin"), map.get("end"));
                  
               }
               if (map.get("orderRegdate") != null && map.get("orderRegdate").equals("regdate")) {
                  
                  sql = String.format("select v.* , rownum  from (select * from vwreview order by regdate desc)v where rownum between %s and %s", map.get("begin"), map.get("end"));
                  
               } else if (map.get("orderRecommendCount") != null && map.get("orderRecommendCount").equals("recommendCount")) {
                  
                  sql = String.format("select v.* , rownum  from (select * from vwreview order by recommendcount desc)v where rownum between %s and %s", map.get("begin"), map.get("end"));
                  
               } else if (map.get("orderComment") != null && map.get("orderComment").equals("ccnt")) {
                  
                  sql = String.format("select v.* , rownum  from (select * from vwreview order by commentCount desc)v where rownum between %s and %s", map.get("begin"), map.get("end"));
                  
               } else if (map.get("orderReadCount") != null && map.get("orderReadCount").equals("readCount")) {
                  
                  sql = String.format("select v.* , rownum  from (select * from vwreview order by readcount desc)v where rownum between %s and %s", map.get("begin"), map.get("end"));
                  
               }
               
               
         
               
            } 
      
            
            System.out.println("SQL문: " + sql);
            
            pstat = conn.prepareStatement(sql);

            rs = pstat.executeQuery();
            
            
            
            System.out.println(sql);
            
            //이 메소드 입장
            //1. 목록보기
            //2. 검색하기
            
                              
            ArrayList<CommunityDTO> list = new ArrayList<CommunityDTO>(); //옮겨 담을 큰상자
            
            while (rs.next()) {
               
               //레코드 1줄 -> BoardDTO 1개
               CommunityDTO dto = new CommunityDTO();
               
                 dto.setRnum(rs.getString("rnum"));
                 dto.setSeq(rs.getString("seq")); //dto.setId(rs.getString("id"));
                 dto.setMemberseq(rs.getString("memberseq"));
                 dto.setCategory(rs.getString("category"));
                 dto.setTitle(rs.getString("title"));
                 dto.setContent(rs.getString("content"));
                 dto.setRegdate(rs.getString("regdate")); //글쓰고 난뒤 며칠이 지났는지 시간
                 dto.setContent(rs.getString("content"));
                 dto.setNickname(rs.getString("nickname"));
                 dto.setReadcount(rs.getString("readcount"));
                 dto.setScrapcount(rs.getInt("scrapcount"));
                 dto.setIsnew(rs.getString("isnew"));
                 dto.setRecommendcount(rs.getInt("recommendcount"));
                 dto.setDecommendcount(rs.getInt("decommendcount"));
                 dto.setCommentcount(rs.getInt("commentcount"));
               
                 
               
                 list.add(dto);
               
               
            }
            
               
            return list;         
            
         } catch (Exception e) {
            System.out.println("CommunityDAO.list()");
            e.printStackTrace();
         }
         return null;
      }
   
   
   /**

    * @return list

    * @author 3조

    *  @param HashMap<String, String> map

    * Lincense 서블릿으로 게시글 테이블이 가지고 있는 값의 list를 가져오는 메소드 
    *
    */
   public ArrayList<CommunityDTO> licenselist(HashMap<String, String> map) {
      
      try {
         
          
         //2. 검색하기
         String where = "";
         String sql = "";
         //System.out.println("column"+ map.get("column"));
         //System.out.println("search"+ map.get("search"));
         
         if (map.get("isSearch").equals("y")) {
            //검색
            //where name like '%홍길동%'
            //where subject like '%날씨%'
         
            if(map.get("column").equals("all")) {
               where = String.format("title like '%%%s%%' or content like '%%%s%%'"
                                    ,map.get("search"), map.get("search"));
            }else if(map.get("column").equals("title")){
               where = String.format(" title like '%%%s%%' ",  map.get("search"));
            }else if(map.get("column").equals("nickname")){
               where = String.format(" nickname like '%%%s%%' ",map.get("search"));
            }else if(map.get("column").equals("content")){
               where = String.format("content like '%%%s%%' ",map.get("search"));}
            
             sql = String.format("select * from vwlicense where  %s  order by regdate desc" , where);
               
      
         
         }else if (map.get("isSearch").equals("n")) {
            
            if (sql == null || sql.equals("")) {

               sql = String.format("select * from vwlicense where rnum between %s and %s  order by regdate desc", map.get("begin"), map.get("end"));
               
            }
            if (map.get("orderRegdate") != null && map.get("orderRegdate").equals("regdate")) {
               
               sql = String.format("select v.* , rownum  from (select * from vwlicense order by regdate desc)v where rownum between %s and %s", map.get("begin"), map.get("end"));
               
            } else if (map.get("orderRecommendCount") != null && map.get("orderRecommendCount").equals("recommendCount")) {
               
               sql = String.format("select v.* , rownum  from (select * from vwlicense order by recommendcount desc)v where rownum between %s and %s", map.get("begin"), map.get("end"));
               
            } else if (map.get("orderComment") != null && map.get("orderComment").equals("ccnt")) {
               
               sql = String.format("select v.* , rownum  from (select * from vwlicense order by commentCount desc)v where rownum between %s and %s", map.get("begin"), map.get("end"));
               
            } else if (map.get("orderReadCount") != null && map.get("orderReadCount").equals("readCount")) {
               
               sql = String.format("select v.* , rownum  from (select * from vwlicense order by readcount desc)v where rownum between %s and %s", map.get("begin"), map.get("end"));
               
            }
            
            
            
         } 
   
         
         System.out.println("SQL문: " + sql);
         
         pstat = conn.prepareStatement(sql);

         rs = pstat.executeQuery();
         
         
         
         System.out.println(sql);
         
         //이 메소드 입장
         //1. 목록보기
         //2. 검색하기
         
                           
         ArrayList<CommunityDTO> list = new ArrayList<CommunityDTO>(); //옮겨 담을 큰상자
         
         while (rs.next()) {
            
            //레코드 1줄 -> BoardDTO 1개
            CommunityDTO dto = new CommunityDTO();
            
              dto.setRnum(rs.getString("rnum"));
              dto.setSeq(rs.getString("seq")); //dto.setId(rs.getString("id"));
              dto.setMemberseq(rs.getString("memberseq"));
              dto.setCategory(rs.getString("category"));
              dto.setTitle(rs.getString("title"));
              dto.setContent(rs.getString("content"));
              dto.setRegdate(rs.getString("regdate")); //글쓰고 난뒤 며칠이 지났는지 시간
              dto.setContent(rs.getString("content"));
              dto.setNickname(rs.getString("nickname"));
              dto.setReadcount(rs.getString("readcount"));
              dto.setIsnew(rs.getString("isnew"));
              dto.setScrapcount(rs.getInt("scrapcount"));
              dto.setRecommendcount(rs.getInt("recommendcount"));
              dto.setDecommendcount(rs.getInt("decommendcount"));
              dto.setCommentcount(rs.getInt("commentcount"));
            
              
            
              list.add(dto);
            
            
         }
         
            
         return list;         
         
      } catch (Exception e) {
         System.out.println("CommunityDAO.list()");
         e.printStackTrace();
      }
      return null;
   }

   
   
   /**

    * @return list

    * @author 3조
    *     
    *  @param HashMap<String, String> map


    *  List 서블릿으로 총 게시물 수를 가져오는 메소드 
    *
    */
      //List 서블릿이 총 게시물 수 알려달라고 요청
      public int getTotalCount(HashMap<String, String> map) {
         try {

            String where = "";
            
            //System.out.println("column"+ map.get("column"));
            //System.out.println("search"+ map.get("search"));
            
            if (map.get("isSearch").equals("y")) {
               //검색
               //where name like '%홍길동%'
               //where subject like '%날씨%'
               
               if(map.get("column").equals("all")) {
                  where = String.format(" where title like '%%%s%%' or content like '%%%s%%'"
                                       ,map.get("search"), map.get("search"));
               } else {
                  where = String.format(" where %s like '%%%s%%' ", map.get("column"), map.get("search"));
               }
               
            }
            String sql = String.format("select count(*) as cnt from vwPost %s", where);
            
            pstat = conn.prepareStatement(sql);
            
            rs = pstat.executeQuery();
            
            if (rs.next()) {
               return rs.getInt("cnt");
            }
         
            

         } catch (Exception e) {
            System.out.println("BoardDAO.getCount()");
            e.printStackTrace();
         }
         return 0;
      }
      
      
      /**

       * @return list

       * @author 3조
       *     
       *  @param HashMap<String, String> map


       *  Livestory 서블릿으로 총 게시물 수를 가져오는 메소드 
       *
       */
      public int getLivestoryTotalCount(HashMap<String, String> map) {
         try {

            String where = "";
            
            //System.out.println("column"+ map.get("column"));
            //System.out.println("search"+ map.get("search"));
            
            if (map.get("isSearch").equals("y")) {
               //검색
               //where name like '%홍길동%'
               //where subject like '%날씨%'
               
               if(map.get("column").equals("all")) {
                  where = String.format(" where title like '%%%s%%' or content like '%%%s%%'"
                                       ,map.get("search"), map.get("search"));
               } else {
                  where = String.format(" where %s like '%%%s%%' ", map.get("column"), map.get("search"));
               }
               
            }
            String sql = String.format("select count(*) as cnt from vwlivestory %s", where);
            
            pstat = conn.prepareStatement(sql);
            
            rs = pstat.executeQuery();
            
            if (rs.next()) {
               return rs.getInt("cnt");
            }
         
            

         } catch (Exception e) {
            System.out.println("BoardDAO.getCount()");
            e.printStackTrace();
         }
         return 0;
      }
      

      
      /**

       * @return list

       * @author 3조
         *  @param HashMap<String, String> map


       *  Itevent 서블릿으로 총 게시물 수를 가져오는 메소드 
       *
       */


      public int getIteventTotalCount(HashMap<String, String> map) {
         try {

            String where = "";
            
            //System.out.println("column"+ map.get("column"));
            //System.out.println("search"+ map.get("search"));
            
            if (map.get("isSearch").equals("y")) {
               //검색
               //where name like '%홍길동%'
               //where subject like '%날씨%'
               
               if(map.get("column").equals("all")) {
                  where = String.format(" where title like '%%%s%%' or content like '%%%s%%'"
                                       ,map.get("search"), map.get("search"));
               } else {
                  where = String.format(" where %s like '%%%s%%' ", map.get("column"), map.get("search"));
               }
               
            }
            String sql = String.format("select count(*) as cnt from vwitevent %s", where);
            
            pstat = conn.prepareStatement(sql);
            
            rs = pstat.executeQuery();
            
            if (rs.next()) {
               return rs.getInt("cnt");
            }
         
            

         } catch (Exception e) {
            System.out.println("BoardDAO.getCount()");
            e.printStackTrace();
         }
         return 0;
      }
      
      /**

       * @return list

       * @author 3조
    *  @param HashMap<String, String> map

       *  Review 서블릿으로 총 게시물 수를 가져오는 메소드 
       *
       */


      public int getReviewTotalCount(HashMap<String, String> map) {
         try {

            String where = "";
            
            //System.out.println("column"+ map.get("column"));
            //System.out.println("search"+ map.get("search"));
            
            if (map.get("isSearch").equals("y")) {
               //검색
               //where name like '%홍길동%'
               //where subject like '%날씨%'
               
               if(map.get("column").equals("all")) {
                  where = String.format(" where title like '%%%s%%' or content like '%%%s%%'"
                                       ,map.get("search"), map.get("search"));
               } else {
                  where = String.format(" where %s like '%%%s%%' ", map.get("column"), map.get("search"));
               }
               
            }
            String sql = String.format("select count(*) as cnt from vwreview %s", where);
            
            pstat = conn.prepareStatement(sql);
            
            rs = pstat.executeQuery();
            
            if (rs.next()) {
               return rs.getInt("cnt");
            }
         
            

         } catch (Exception e) {
            System.out.println("BoardDAO.getCount()");
            e.printStackTrace();
         }
         return 0;
      }

      /**

       * @return list

       * @author 3조
           *  @param HashMap<String, String> map


       *  License 서블릿으로 총 게시물 수를 가져오는 메소드 
       *
       */

      public int getLicenseTotalCount(HashMap<String, String> map) {
         try {

            String where = "";
            
            //System.out.println("column"+ map.get("column"));
            //System.out.println("search"+ map.get("search"));
            
            if (map.get("isSearch").equals("y")) {
               //검색
               //where name like '%홍길동%'
               //where subject like '%날씨%'
               
               if(map.get("column").equals("all")) {
                  where = String.format(" where title like '%%%s%%' or content like '%%%s%%'"
                                       ,map.get("search"), map.get("search"));
               } else {
                  where = String.format(" where %s like '%%%s%%' ", map.get("column"), map.get("search"));
               }
               
            }
            String sql = String.format("select count(*) as cnt from vwlicense %s", where);
            
            pstat = conn.prepareStatement(sql);
            
            rs = pstat.executeQuery();
            
            if (rs.next()) {
               return rs.getInt("cnt");
            }
         
            

         } catch (Exception e) {
            System.out.println("BoardDAO.getCount()");
            e.printStackTrace();
         }
         return 0;
      }

      // 조회수 +1 하는 메소드
      
      /**

       * @return  int 실패0, 성공1

       * @author 3조

       *  List서블릿으로 부터 가져온 값에 +1 을 해 테이블을 업데이트해주는 메소드 
       *
       */

   
      public void updateReadcount(String seq) {
         
         try {

            String sql ="update tblCommunity set readcount = readcount + 1 where Communityseq= ?";
            
            pstat = conn.prepareStatement(sql);
            pstat.setString(1,seq);
            
            pstat.executeUpdate();
            

         } catch (Exception e) {
            System.out.println("updateReadCount()");
            e.printStackTrace();
         }
         
      }

      //get메소드로 정보들을 다 얻어와 seq으로 ..,,DTO에서 ..
      
      /**

       * @return  dto

       * @author 3조
        *  @param String seq 게시글번호


       *  List서블릿으로 테이블의 값을 dto에 넣어 dto을 반환하는 메소드
       *
       */
      
      public CommunityDTO get(String seq) {
         try {
            
            String sql = "select * from vwPost where seq= ?";
            
            pstat = conn.prepareStatement(sql);
            pstat.setString(1, seq);
            
            rs = pstat.executeQuery();
            
            if (rs.next()) {
               
               CommunityDTO dto = new CommunityDTO();
               
               dto.setSeq(rs.getString("seq"));
               dto.setMemberseq(rs.getString("memberseq"));
               dto.setCategory(rs.getString("category"));
               dto.setTitle(rs.getString("title"));
               dto.setContent(rs.getString("content"));
               dto.setRegdate(rs.getString("regdate"));
               dto.setReadcount(rs.getString("readcount"));
               dto.setNickname(rs.getString("nickname"));
               dto.setIsnew(rs.getString("isnew"));
               dto.setCommentcount(rs.getInt("commentcount"));
               dto.setScrapcount(rs.getInt("scrapcount"));
               dto.setRecommendcount(rs.getInt("recommendcount"));
               dto.setDecommendcount(rs.getInt("decommendcount"));
               return dto;
            }
            
            
         }catch(Exception e) {
            System.out.println("CommunityDAO.get()");
         }
         return null;
      }
      
      /**

       * @return  clist

       * @author 3조
        *  @param String seq 게시글번호

       *  ListComment 서블릿으로  테이블의 값을 clist에 넣어 clist를 반환하는 메소드
       *
       */


      public ArrayList<CommentDTO> listComment(String seq) {
         
               try {
               
               String sql = "select * from vwcomcomment  where communityseq = ? order by rnum asc"; //부모글번호를 조건으로
               
               pstat = conn.prepareStatement(sql);
               pstat.setString(1, seq);
               
               rs = pstat.executeQuery();
               
               ArrayList<CommentDTO> clist = new ArrayList<CommentDTO>();
               
               while(rs.next()) {
                  
                  CommentDTO dto = new CommentDTO();
                  dto.setCommentseq(rs.getString("commentseq"));
                  dto.setMemberseq(rs.getString("memberseq"));
                  dto.setCommunityseq(rs.getString("communityseq"));
                  dto.setContent(rs.getString("content"));
                  dto.setRegdate(rs.getString("regdate"));
                  dto.setNickname(rs.getString("nickname"));
                  
                  clist.add(dto);
                  
               }

               return clist;
               
            } catch (Exception e) {
               System.out.println("CommunityDAO.listComment()");
               e.printStackTrace();
            }
 
 
         return null;
      }

      
//      
//      CREATE TABLE tblCommunityComment (
//             commentSeq number NOT NULL,
//             memberSeq number NOT NULL,
//             communitySeq number NOT NULL,
//             content varchar2(2000) NOT NULL,
//             regdate date DEFAULT sysdate NOT NULL
//            );
      
      
      /**

       * @return  int 0,1

       * @author 3조
        *  @param String seq 게시글번호

       *  DeleteOk 서블릿에서 가져온 seq값으로 해당되는 테이블의 값을 delete 해주는 메소드  
       *
       */
      
      public void delAllComment(String seq) {
         
         try {
            
            String sql = "delete from tblCommunityComment where communitySeq = ?";
            
            pstat = conn.prepareStatement(sql);

            pstat.setString(1, seq);
            
            pstat.executeUpdate();         

            
         } catch (Exception e) {
            System.out.println("CommunityDAO.delAllComment()");
            e.printStackTrace();
         }
         
      }

      /**

       * @return  int 0,1

       * @author 3조
        *  @param String seq 게시글번호

       *  DeleteOk 서블릿에서 가져온 seq값으로 해당되는 테이블의 값을 delete 해주는 메소드  
       *
       */
      
      public int del(String seq) {
         try {
            
            String sql = "delete from tblCommunity where communitySeq = ?";
            pstat = conn.prepareStatement(sql);
            pstat.setString(1, seq);
            
            return pstat.executeUpdate();
            
         } catch (Exception e) {
            System.out.println("CommunityDAO.del()");
            e.printStackTrace();
         }
         return 0;
      }

      /**

       * @return  int 0,1

       * @author 3조
        *  @param CommunityDTO dto 커뮤니티DTO 리스트

       *  DeleteOk 서블릿에서 가져온 dto값으로 해당되는 테이블의 값을 delete 해주는 메소드  
       *
       */
      
      public int edit(CommunityDTO dto) {
         try {
            
            String sql = "update tblCommunity set title = ?, content=?, category=? where Communityseq =?";
            pstat = conn.prepareStatement(sql);

            pstat.setString(1, dto.getTitle());
            pstat.setString(2, dto.getContent());
            pstat.setString(3, dto.getCategory());
            pstat.setString(4, dto.getSeq());
            
            return pstat.executeUpdate(); //0(실패) or 1(성공)
            
            
         } catch (Exception e) {
            System.out.println("CommunityDAO.edit()");
            e.printStackTrace();
         }return 0;
      }
      
      
      
      
      /**

       * @return  slist

       * @author 3조
        *  @param String seq 게시글번호


       *  Scrap 서블릿에서 가져온 seq값으로 slist을 얻어 반환하는 메소드  
       *
       */
       
   
      // 커뮤니티 글번호와 스크랩번호의 커뮤니고유번호와 같을때 
      public ArrayList<ScrapDTO> listScrap(String seq) {
         try {
               
               String sql = "select * from tblComScrap where communityseq = ?"; //부모글번호를 조건으로
               
               pstat = conn.prepareStatement(sql);
               pstat.setString(1, seq);
               
               rs = pstat.executeQuery();
               
               ArrayList<ScrapDTO> slist = new ArrayList<ScrapDTO>();
               
               while(rs.next()) {
                  
                  ScrapDTO dto = new ScrapDTO();
                  dto.setComscrapseq(rs.getString("comscrapseq"));
                  dto.setMemberseq(rs.getString("memberseq"));
                  dto.setCommunityseq(rs.getString("communityseq"));


                  slist.add(dto);
               }

               return slist;
               
            } catch (Exception e) {
               System.out.println("CommunityDAO.listScrap()");
               e.printStackTrace();
            }

         
         return null;
         
      }
      
      /**

       * @return  int 0,1

       * @author 3조

       * @param ScrapDTO 리스트 
       * 
       *  Scrap 서블릿에서 가져온 dto값을 테이블에 insert해주는 메소드   
       *
       */
       
      //Scrap에서 스크랩 add
        public int addScrap(ScrapDTO dto) {
           
           try {
           
                 String sql = "insert into tblComScrap (comScrapSeq, communitySeq, memberSeq)"
                + "values (comScrapSeq.nextVal, ?, ?)";
                 
                 pstat = conn.prepareStatement(sql);
                 
                 
                 pstat.setString(1, dto.getCommunityseq()); 
                 pstat.setString(2, dto.getMemberseq());
                 
                
                 return pstat.executeUpdate(); //성공하면 1 실패하면 0
                
           
              } catch (Exception e) { 
              System.out.println("CommunityDAO.listScrap()");
              e.printStackTrace(); 
              
           } return 0; 
          }
 
        /**

         * @return  int 0,1

         * @author 3조
         * @param ScrapDTO 리스트 

         *  Scrap 서블릿에서 가져온 dto값으로 테이블에서 delete 해주는 메소드   
         *
         */
        
      //Scrap에서 스크랩 삭제
         public int delScrap(ScrapDTO dto) {
            
            try {

               String sql = "delete from tblComScrap where memberSeq = ? and communitySeq = ?";
               
               pstat = conn.prepareStatement(sql);
               
               pstat.setString(1, dto.getMemberseq());
               pstat.setString(2, dto.getCommunityseq());
               
               return pstat.executeUpdate();

               

            } catch (Exception e) {
               System.out.println(e);
               e.printStackTrace();
            }
            
            return 0;
         }
         
         /**

          * @return  rlist 추천 비추천 리스트

          * @author 3조
          * @param String seq  게시글 수 



          *  Recommend 서블릿에서 가져온 dto값으로 테이블에서 delete 해주는 메소드   
          *
          */
      
         public ArrayList<RecommendDTO> listRecommend(String seq) {
            try {

               String sql = "select * from tblComRecommend where CommunitySeq = ?";
               
               pstat = conn.prepareStatement(sql);
               pstat.setString(1, seq);
               
               rs = pstat.executeQuery();
               
               ArrayList<RecommendDTO> rlist = new ArrayList<RecommendDTO>();
               
               
               while(rs.next()) {
                  
                  RecommendDTO dto = new RecommendDTO();
                  
                  
                  dto.setComrecseq(rs.getString("comrecseq"));
                  dto.setRecommend(rs.getString("recommend"));
                  dto.setMemberseq(rs.getString("memberseq"));
                  dto.setCommunityseq(rs.getString("communityseq"));
                  
                  
                  rlist.add(dto);
                  
               }
               
               return rlist;
               

            } catch (Exception e) {
               System.out.println(e);
               e.printStackTrace();
            }
            
            return null;
         }
         
         /**

          * @return  int 0,1

          * @author 3조
          * @param RecommendDTO dto 

          *  Scrap 서블릿에서 가져온 dto값으로 tblComrecommend에 insert 해주는 메소드 
          *
          */
          
         
         //추천/비추천을 애초에 누르지 않았을 때 추천을 눌러 테이블에 y insert.. 
         public int recNew(RecommendDTO dto) {

            try {

                String sql = "insert into tblComrecommend (ComRecSeq, memberSeq, communitySeq, recommend)"
                      + "values (ComRecSeq.nextVal, ?, ?, 'y')";
                
               pstat = conn.prepareStatement(sql);
               
               pstat.setString(1, dto.getMemberseq());
               pstat.setString(2, dto.getCommunityseq());
               
               return pstat.executeUpdate();

               

            } catch (Exception e) {
               System.out.println(e);
               e.printStackTrace();
            }
            
            
            return 0;
         }
         
         /**

          * @return  int 0,1

          * @author 3조
          * @param RecommendDTO dto 

          *  Recommend 서블릿에서 가져온 dto값으로 tblComrecommend에 insert 해주는 메소드 
          *
          */
         public int decCNew(RecommendDTO dto) {

            try {

                String sql = "insert into tblComrecommend (ComRecSeq, memberSeq, communitySeq, recommend)"
                      + "values (ComRecSeq.nextVal, ?, ?, 'n')";
               pstat = conn.prepareStatement(sql);
               
               pstat.setString(1, dto.getMemberseq());
               pstat.setString(2, dto.getCommunityseq());
               
               return pstat.executeUpdate();

               

            } catch (Exception e) {
               System.out.println(e);
               e.printStackTrace();
            }
            
            
            return 0;
         }
         
         
         /**

          * @return  int 0,1

          * @author 3조

          *  Scrap 서블릿에서 가져온 dto값으로 tblComrecommend에 update 해주는 메소드 
          *
          */      
         public int recChange(RecommendDTO dto) {
            
            try {

               String sql ="update tblComrecommend set recommend = 'y' where CommunitySeq= ? and memberSeq = ?";
               
               pstat = conn.prepareStatement(sql);
               
               pstat.setString(1, dto.getCommunityseq());
               pstat.setString(2, dto.getMemberseq());
               
               int result =  pstat.executeUpdate();
               return result;
               
               

            } catch (Exception e) {
               System.out.println(e);
               e.printStackTrace();
            }
            
            return 0;
         }
         /**

          * @return  int 0,1

          * @author 3조
          * @param RecommendDTO dto 

          *  Recommend 서블릿에서 가져온 dto값으로 tblComrecommend에 update 해주는 메소드 
          *
          */
         public int decChange(RecommendDTO dto) {
            
            try {

               String sql ="update tblComrecommend set recommend = 'n' where CommunitySeq= ? and memberSeq = ?";
               
               pstat = conn.prepareStatement(sql);
               
               pstat.setString(1, dto.getCommunityseq());
               pstat.setString(2, dto.getMemberseq());
               
               int result =  pstat.executeUpdate();
               return result;
               
               

            } catch (Exception e) {
               System.out.println(e);
               e.printStackTrace();
            }            return 0;
         }
         
         
         /**

          * @return  int 0,1

          * @author 3조
          * @param RecommendDTO dto 

          *  Recommend 서블릿에서 가져온 dto값으로 tblComrecommend에 delete 해주는 메소드 
          *
          */
         
         public int reczoro(RecommendDTO dto) {
            try {

               String sql ="delete from tblComrecommend where CommunitySeq= ? and memberSeq = ?";
               
               pstat = conn.prepareStatement(sql);
               
               pstat.setString(1, dto.getCommunityseq());
               pstat.setString(2, dto.getMemberseq());
               
               int result =  pstat.executeUpdate();
               return result;
               
               

            } catch (Exception e) {
               System.out.println(e);
               e.printStackTrace();
            }      
            
            return 0;
         }
         
         /**

          * @return  int 0,1

          * @author 3조
          * @param String seq 게시글번호

          *  Delete 서블릿에서 가져온 dto값으로 tblscrap에서 값을 delete 해주는 메소드 
          *
          */
         

         public void delAllScrap(String seq) {

            try {
               
               String sql = "delete from tblComScrap where communitySeq = ?";
               
               pstat = conn.prepareStatement(sql);

               pstat.setString(1, seq);
               
               pstat.executeUpdate();         

               
               
            } catch (Exception e) {
               System.out.println("CommunityDAO.delAllScrap()");
               e.printStackTrace();
            }
            
         }
         
         /**

          * @return  int 0,1

          * @author 3조

          *  Delete 서블릿에서 가져온 dto값으로 tblRecommend에서 값을 delete 해주는 메소드 
          *
          */

         public void delAllRecommend(String seq) {
               try {
         
               String sql = "delete from tblComRecommend where communitySeq = ?";
               
               pstat = conn.prepareStatement(sql);

               pstat.setString(1, seq);
               
               pstat.executeUpdate();         

            } catch (Exception e) {
               System.out.println("CommunityDAO.delAllRecommend()");
               e.printStackTrace();
            }
                        
         }
         
//         
//         CREATE TABLE tblCommunityComment (
//                commentSeq number NOT NULL,
//                memberSeq number NOT NULL,
//                communitySeq number NOT NULL,
//                content varchar2(2000) NOT NULL,
//                regdate date DEFAULT sysdate NOT NULL
//               );
         
         /**

          * @return  int 0,1

          * @author 3조
          * @param CommentDTO dto 댓글 리스트

          *  Comment 서블릿에서 가져온 dto값으로 tblCommunitycomment에 insert 해주는 메소드 
          *
          */

         public int addComment(CommentDTO dto) {
            try {
               
               String sql = "insert into tblCommunityComment (commentSeq, memberSeq, communitySeq ,content, regdate) "
                           + "values (commentSeq.nextVal, ?, ?, ?, default)";
               pstat = conn.prepareStatement(sql);

               pstat.setString(1, dto.getMemberseq());
               pstat.setString(2, dto.getCommunityseq());
               pstat.setString(3, dto.getContent());
               
               
               return pstat.executeUpdate(); //0(실패) or 1(성공)
               
            } catch (Exception e) {
               System.out.println("CommunityDAO.addComment()");
               e.printStackTrace();
            }
                        return 0;
         }

         
         /**

          * @return  int 0,1

          * @author 3조
          * @param String seq 댓글번호

          *  Comment 서블릿에서 가져온 dto값으로 tblCommunityComment의 값을 delete 해주는 메소드 
          *
          */

         public int delComment(String seq) {

            try {
               
               String sql = "delete from tblCommunityComment where commentSeq = ?";
               pstat = conn.prepareStatement(sql);

               pstat.setString(1, seq);
               
               return pstat.executeUpdate(); //0(실패) or 1(성공)
               
            } catch (Exception e) {
               System.out.println("CommunityDAO.addComment()");
               e.printStackTrace();
            }
            
            
            return 0;
         }

//         
//         
//         private String commentseq;
//         private String memberseq;
//         private String communityseq;
//         private String content;
//         private String regdate;
//         private String nickname;
         
         
         /**

          * @return  dto
          * @param String seq 댓글번호

          * @author 3조

          *  Comment 서블릿에서 가져온 seq값으로 테이블의 값을 dto에 넣어 dto를 반환해주는 메소드 
          *
          */
         
         public CommentDTO commentget(String seq) {
            try {
               
               String sql = "select * from vwcomcomment where commentseq= ?";
               
               pstat = conn.prepareStatement(sql);
               pstat.setString(1, seq);
               
               rs = pstat.executeQuery();
               
               if (rs.next()) {
                  
                  CommentDTO dto = new CommentDTO();
                  
                  dto.setCommentseq(rs.getString("commentseq"));
                  dto.setMemberseq(rs.getString("memberseq"));
                  dto.setCommunityseq(rs.getString("communityseq"));
                  dto.setContent(rs.getString("content"));
                  dto.setRegdate(rs.getString("regdate"));
                  dto.setNickname(rs.getString("nickname"));
                  
            
                  return dto;
               }
               
               
            }catch(Exception e) {
               System.out.println("CommunityDAO.commentget()");
            }
            return null;
         }

         
         /**

          * @return  list

          * @author 3조

          *  Chart 서블릿으로 테이블의 값을 list에 넣어 반환해주는 메소드 
          *
          */
         
         public ArrayList<ChartDTO> category() {

            try {

               String sql = "select name, num from vwCategory";
               
               stat = conn.createStatement();
               rs = stat.executeQuery(sql);
               
               ArrayList<ChartDTO> list = new ArrayList<ChartDTO>();
               
               while (rs.next()) {
                  ChartDTO dto = new ChartDTO();
                  dto.setName(rs.getString("name"));
                  dto.setNum(rs.getString("num"));
                  list.add(dto);
               }
               
               return list;
               

            } catch (Exception e) {
               System.out.println("ChartDAO.list1()");
               e.printStackTrace();
            }
            
            return null;
         }

         
         /**

          * @return  list1

          * @author 3조

          *  Chart 서블릿으로 테이블의 값을 list1에 넣어 반환해주는 메소드 
          *
          */
         
         public ArrayList<ChartDTO> categorycomment() {
            try {

               String sql = "select name, num from vwCategoryComment";
               
               stat = conn.createStatement();
               rs = stat.executeQuery(sql);
               
               ArrayList<ChartDTO> list1 = new ArrayList<ChartDTO>();
               
               while (rs.next()) {
                  ChartDTO dto = new ChartDTO();
                  dto.setName(rs.getString("name"));
                  dto.setNum(rs.getString("num"));
                  list1.add(dto);
               }
               
               return list1;
               

            } catch (Exception e) {
               System.out.println("ChartDAO.list1()");
               e.printStackTrace();
            }
            return null;
         }

   
      

         

      

         
}


