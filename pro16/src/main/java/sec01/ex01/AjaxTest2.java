package sec01.ex01;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.Servlet;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class AjaxTest2
 */
@WebServlet("/ajaxTest2")
public class AjaxTest2 extends HttpServlet {

	/**
	 * @see Servlet#init(ServletConfig)
	 */
	public void init(ServletConfig config) throws ServletException {
		// TODO Auto-generated method stub
	}

	/**
	 * @see Servlet#destroy()
	 */
	public void destroy() {
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doHandle(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doHandle(request, response);
	}
	
	private void doHandle(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html; charset=utf-8");
		String result="";
		PrintWriter writer = response.getWriter();
		result="<main><book>" +
				"<title><![CDATA[초보자를 위한 자바 프로그래밍]]></title>" +
				"<writer><![CDATA[인포북스 저 | 이병승]]></writer>" +
				"<image><![CDATA[http://localhost:8080/pro16/image/duke.jpg]]></image>" +
				"</book>" +
				"<book>" +
				"<title><![CDATA[초보자를 위한 자바 프로그래밍]]></title>" +
				"<writer><![CDATA[인포북스 저 | 이병승]]></writer>" +
				"<image><![CDATA[http://localhost:8080/pro16/image/duke.jpg]]></image>" +
				"</book></main>";
		writer.print(result);		
	}

}
