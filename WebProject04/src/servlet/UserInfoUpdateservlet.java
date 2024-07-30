package servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.UserInfoDao;


@WebServlet("/UserInfoUpdateservlet")
public class UserInfoUpdateservlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String id = request.getParameter("change_id");
		String pw = request.getParameter("change_pw");
		String name = request.getParameter("change_name");
		int point = Integer.parseInt(request.getParameter("change_point"));
		
		UserInfoDao uDao = new UserInfoDao();
		uDao.userInfoUpdate(id, pw, name, point);
		
		request.getRequestDispatcher("admin.jsp").forward(request, response);
	}

}
