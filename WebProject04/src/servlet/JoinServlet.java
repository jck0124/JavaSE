package servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.JoinDao;


@WebServlet("/JoinServlet")
public class JoinServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.setCharacterEncoding("UTF-8");
		
		String joinId = request.getParameter("join_id");
		String joinPw = request.getParameter("join_pw");
		String joinName = request.getParameter("join_name");
		
		JoinDao jDao = new JoinDao();
		jDao.userJoin(joinId, joinPw, joinName);
		
		request.getRequestDispatcher("login.jsp").forward(request, response);		
	}

}
