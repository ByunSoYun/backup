package com.test.etc.crawling;

import java.util.Arrays;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class Ex03 {
	
	public static void main(String[] args) throws Exception {
		
		//네이버 현재 상영 영화
		String url = "https://movie.naver.com/movie/running/current.naver#";
		
		Document doc = Jsoup.connect(url).get();
		
		//소스 분석(개발자 재량에 따라..)
		
		//div.lst_wrap > ul.lst_detail_t1 > li
		
		Elements list = doc.select("div.lst_wrap > ul.lst_detail_t1 > li"); //문서 전체에서 검색
		
		
		
		MovieDAO dao = new MovieDAO();
		
		
		for (Element item : list) {
			
			//<li>태그?
			//System.out.println(item);
			//System.out.println("=====================================");
			
			
			String title = item.select(".tit > a").text(); //<li>내부에서만 검색
			//System.out.println(title);
			
			//String outline = item.select("dd:nth-child(2) .link_txt").text(); //<span> <a>
			//System.out.println(outline);
			
			String temp = item.select(".info_txt1 dd:nth-child(2)").text();
			
			//애니메이션,코미디,모험|107분|2021.07.21
			//94분|1955.04.06
			
			temp = temp.replace(" ", "").replace("개봉", "");
			
			String[] templist = temp.split("\\|");
			
			String outline = "";
			String time = "";
			String rdate = "";
			
			//System.out.println(Arrays.toString(templist));
			
			if (templist.length == 2) {
				time = templist[0].replace("분", "");
				rdate = templist[1];
			} else {
				outline = templist[0];
				time = templist[1].replace("분", "");
				rdate = templist[2];
			}
			
//			System.out.println(outline);
//			System.out.println(time);
//			System.out.println(rdate);
//			System.out.println("===========");
			


//		    poster varchar2(300) not null           --포스터
			
			String director = item.select("dd:nth-child(4) .link_txt").text();
			//System.out.println(director);
			
			String actor = item.select("dd:nth-child(6) .link_txt").text();
			//System.out.println(actor);
			
			String poster = item.select(".thumb > a > img").attr("src");
			//System.out.println(poster);
			
			
			//DB 작업
			MovieDTO dto = new MovieDTO();
			
			if (title == null || title.equals("")) title = "제목없음";
			if (outline == null || outline.equals("")) outline = "개요없음";
			if (time == null || time.equals("")) time = "0";
			if (rdate == null || rdate.equals("")) rdate = "상용일없음";
			if (director == null || director.equals("")) director = "감독없음";
			if (actor == null || actor.equals("")) actor = "배우없음";
			if (poster == null || poster.equals("")) poster = "포스터없음";
			
			System.out.println(title);
			System.out.println(outline);
			System.out.println(time);
			System.out.println(rdate);
			System.out.println(director);
			System.out.println(actor);
			System.out.println(poster);
			
			
			dto.setTitle(title);
			dto.setOutline(outline);
			dto.setTime(time);
			dto.setRdate(rdate);
			dto.setDirector(director);
			dto.setActor(actor);
			dto.setPoster(poster);
			
			dao.add(dto);
			
		}//forEach
		
		System.out.println("완료!!");
		
		
	}//main

}
















