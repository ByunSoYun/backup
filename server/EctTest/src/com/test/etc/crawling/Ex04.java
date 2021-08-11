package com.test.etc.crawling;

import java.io.IOException;
import java.util.List;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class Ex04 {
	
	public static void main(String[] args) throws Exception {
		
		//Jsoup 사용 방식
		// - 인증이 불필요한 페이지에서만 사용 가능
		// - 인증이 필요한 페이지에서는 사용 불가능
		// - JavaScript 실행이 필요한 페이지에서는 사용 불가능(Ajax가 대부분을 차지한다.)
		
		//웹 응응 프로그램(웹 사이트) 자동화 프로그램
		// - 셀레니움
		// - 사람 대신에 프로그램이 사람처럼 웹 사이트에 방문해서, 여러가지 행동(테스트)를 하는 프로그램
		// - 크롤링 작업 가능하다.
		
		//준비물
		// - 크롬 브라우저(버전 91.0.4472.164(공식 빌드) (64비트))
		// - 엣지 브라우저
		
		
		
		//Ex04.java
		
		//m1();
		//m2();
		//m3();
		//m4();
		m5();
		
	}

	private static void m5() {
		
		//웹 테스트 > 목적에 맞는 시나리오 구성(********)
		
		String webDriverID = "webdriver.chrome.driver";
		String path = "chromedriver.exe"; 
		
		System.setProperty(webDriverID, path);
		
		ChromeOptions options = new ChromeOptions();
		options.setCapability("ignoreProtectedModeSettings", true);
		
		WebDriver driver = new ChromeDriver(options);
		
		String url = "http://localhost:8090/myapp/member/login.do";
		
		driver.get(url);
		
		
		//테스트 - 로그인
		WebElement btn = driver.findElement(By.cssSelector("body > section > div > button:nth-child(2)"));
		btn.click();
		
		
		//글쓰기 페이지
		url = "http://localhost:8090/myapp/board/add.do?reply=0";
		
		driver.get(url);
		
		WebElement subject = driver.findElement(By.id("subject"));
		subject.sendKeys("셀레니움을 통해서 작성중입니다.");
		
		WebElement content = driver.findElement(By.id("content"));
		content.sendKeys("내용입니다.");
				
		WebElement btnWrite = driver.findElement(By.cssSelector("body > section > form > div > button.btn.btn-primary"));
		btnWrite.click();
		
		
	}

	private static void m4() {
		
		String webDriverID = "webdriver.chrome.driver";
		String path = "chromedriver.exe";
		
		System.setProperty(webDriverID, path);
		
		ChromeOptions options = new ChromeOptions();
		options.setCapability("ignoreProtectedModeSettings", true);
		
		WebDriver driver = new ChromeDriver(options);
		
		String url = "https://www.banapresso.com/menu";
		
		driver.get(url);
		
		
		
		List<WebElement> list = driver.findElements(By.className("menu_box"));
		
		
		//<div class="menu_box">
		//	<span class="img">
		//		<img src="img_87ffe0eb7656.png">
		//	</span>
		//	<em class="menu_name">
		//		<strong>Americano</strong>
		//		<i>아메리카노</i>
		//		<span class="price">\2,000</span>
		//	</em>
		//</div>
		for (WebElement item : list) {
			String name = item.findElement(By.tagName("strong")).getText();
			String price = item.findElement(By.className("price")).getText();
			System.out.println(name + "," + price);
		}
		
		
	}

	private static void m3() {
		
		String webDriverID = "webdriver.chrome.driver";
		String path = "D:\\webdriver\\chromedriver.exe";
		
		//웹드라이브 설치
		System.setProperty(webDriverID, path);
		
		ChromeOptions options = new ChromeOptions();
		options.setCapability("ignoreProtectedModeSettings", true);
		
		WebDriver driver = new ChromeDriver(options);
		
		
		//여기서부터 업무 시작
		String url = "http://lms1.sist.co.kr/worknet/SLogin.asp";
		
		driver.get(url);
		
		
		//아이디 텍스트 박스(<input 태그)
		WebElement id = driver.findElement(By.id("strLoginID"));
		id.sendKeys("");
		
		WebElement pw = driver.findElement(By.id("strLoginPwd"));
		pw.sendKeys("");
		
		
		
		
		
		
		
		
		
		WebElement btn = driver.findElement(By.cssSelector("#content > div > form > table > tbody > tr > td > div > div.login-form > div.login-btn > input"));
		btn.click();
		
		//페이지 전환시 트래픽
		try {
			driver.wait(3000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		WebElement td = driver.findElement(By.cssSelector("#content > div > div > div > div.panel-body > form > table > thead > tr:nth-child(5) > td:nth-child(2)"));
		System.out.println(td.getText());
		
		
	}

	private static void m2() throws IOException {
		
		String url = "https://www.banapresso.com/menu";
		
		//브라우저 vs Jsoup
		// - 공통점
		//	  : 웹서버에 접근해서 소스를 받아온다.
		// - 차이점
		//	  : 브라우저는 받아온 소스의 HTML, CSS, JavaScript를 실행하는 능력이 있다. > 실행한다.
		//	  : Jsoup는 받아온 소스의 HTML를 분석하는 능력이 있다. > CSS와 JavaScript를 실행하는 능력은 없다.
		
		//Jsoup <> 브라우저
		Document doc = Jsoup.connect(url).get();
		
		//문서 전체 소스
		System.out.println(doc.html());
		
	}

	private static void m1() throws IOException {
		//아래 URL은 접속 불가능
		String url = "http://lms1.sist.co.kr/worknet/SMember/index.asp?strCode=I202010070024";
		//String selector = "#content > div > div > div > div.panel-body > form > table > thead > tr:nth-child(5) > td:nth-child(2)";
		String selector = "td";
		
		Document doc = Jsoup.connect(url).get();
		
		System.out.println(doc.title());
		
		Elements list = doc.select(selector);
		
		//2020-10-12 ~ 2021-03-24
		System.out.println(list.get(0).text());
	}

}











