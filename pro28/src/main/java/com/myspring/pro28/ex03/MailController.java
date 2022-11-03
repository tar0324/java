package com.myspring.pro28.ex03;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@EnableAsync
public class MailController {
	@Autowired
	private MailService mailService;
	
	@RequestMapping(value = "/sendMail.do", method = RequestMethod.GET)
	public void sendSimpleMail(HttpServletRequest request, HttpServletResponse response) throws Exception {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset-utf-8");
		PrintWriter out = response.getWriter();
		
		StringBuffer sb = new StringBuffer();
		sb.append("<html><body>");
	    sb.append("<meta http-equiv='Content-Type' content='text/html; charset=utf=8'>");
	    sb.append("<h1>"+"제품소개"+"<h1><br>");
	    sb.append("신간 도서를 소개합니다.<br><br>");
	    sb.append("<a href='http://www.kyobobook.co.kr/product/detailViewKor.laf?ejkGb=KOR&mallGb=KOR&barcode=9791188331796&orderClick=LET&Kc='>");
	    sb.append("<img src='http://image.kyobobook.co.kr/images/book/xlarge/796/x9791188331796.jpg' /> </a><br>");
	    sb.append("</a>");
	    sb.append("<a href='http://www.kyobobook.co.kr/product/detailViewKor.laf?ejkGb=KOR&mallGb=KOR&barcode=9791188331796&orderClick=LET&Kc='>상품보기</a>");
	    sb.append("</body></html>");
	    String str = sb.toString();

	    mailService.sendMail("smk980324@naver.com","신상품을 소개합니다.",str);
		//mailService.sendMail("smk980324@naver.com","해킹이다 ㅋ","너의 메일을 훔쳐가겟다 우하핫 -송루팡😎");
		//mailService.sendPreConfiguredMail("너의 메일을 훔쳐가겟다 -송루팡😎");
		out.print("메일을 보냈습니다!!");
	}
}

