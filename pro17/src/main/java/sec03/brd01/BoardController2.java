/*
 * package sec03.brd01;
 * 
 * import java.io.IOException; import java.util.ArrayList; import
 * java.util.List;
 * 
 * import javax.servlet.RequestDispatcher; import javax.servlet.Servlet; import
 * javax.servlet.ServletConfig; import javax.servlet.ServletException; import
 * javax.servlet.annotation.WebServlet; import javax.servlet.http.HttpServlet;
 * import javax.servlet.http.HttpServletRequest; import
 * javax.servlet.http.HttpServletResponse;
 * 
 *//**
	 * Servlet implementation class BoardController
	 */
/*
 * @WebServlet("/board/*") public class BoardController2 extends HttpServlet {
 * BoardService boardService; ArticleVO articleVO;
 * 
 *//**
	 * @see Servlet#init(ServletConfig)
	 */
/*
 * public void init(ServletConfig config) throws ServletException { // TODO
 * Auto-generated method stub boardService = new BoardService(); }
 * 
 *//**
	 * @see Servlet#destroy()
	 */
/*
 * public void destroy() { // TODO Auto-generated method stub }
 * 
 *//**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
/*
 * protected void doGet(HttpServletRequest request, HttpServletResponse
 * response) throws ServletException, IOException { // TODO Auto-generated
 * method stub doHandle(request, response); }
 * 
 *//**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 *//*
		 * protected void doPost(HttpServletRequest request, HttpServletResponse
		 * response) throws ServletException, IOException { // TODO Auto-generated
		 * method stub doHandle(request, response); }
		 * 
		 * private void doHandle(HttpServletRequest request, HttpServletResponse
		 * response) throws ServletException, IOException { // TODO Auto-generated
		 * method stub String nextPage = ""; request.setCharacterEncoding("utf-8");
		 * response.setContentType("text/html;charset=utf-8"); String action =
		 * request.getPathInfo(); System.out.println("action: " + action); try {
		 * List<ArticleVO> articlesList = new ArrayList<ArticleVO>(); if(action == null)
		 * { articlesList = boardService.listArticles();
		 * request.setAttribute("articlesList", articlesList); nextPage =
		 * "/board01/listArticles.jsp";
		 * 
		 * } else if (action.equals("/listArticles.do")) { articlesList =
		 * boardService.listArticles(); request.setAttribute("articlesList",
		 * articlesList); nextPage = "/board01/listArticles.jsp"; } RequestDispatcher
		 * dispatch = request.getRequestDispatcher(nextPage); dispatch.forward(request,
		 * response); } catch (Exception e) { e.printStackTrace(); } }
		 * 
		 * 
		 * }
		 */