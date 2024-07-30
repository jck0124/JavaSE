package servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.json.simple.JSONObject;

import dao.LoginDao;


@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.setCharacterEncoding("UTF-8");
		
		String id = request.getParameter("loginId");
		String pw = request.getParameter("loginPw");
		
		LoginDao lDao = new LoginDao();
		JSONObject jObj = new JSONObject();
		
		boolean loginCheck = lDao.userLogin(id, pw);
		// System.out.println(loginCheck);
		
		jObj.put("key", loginCheck);
		
		HttpSession session = request.getSession();
		session.setAttribute("loginId", id);
		
		response.setContentType("application/json; charset=utf-8");
		response.getWriter().print( jObj.toString() );
	}
	
	

	
	

}
