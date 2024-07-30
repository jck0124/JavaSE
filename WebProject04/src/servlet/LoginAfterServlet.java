package servlet;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.UserInfoDao;
import dto.UserDto;

@WebServlet("/LoginAfterServlet")
public class LoginAfterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.setCharacterEncoding("UTF-8");
		
		HttpSession session = request.getSession();
		String loginId = (String)session.getAttribute("loginId");
		
		UserInfoDao uiDao = new UserInfoDao();
		
		UserDto uDto = uiDao.getUserInfo(loginId);
		String loginName = uDto.getName();
		int loginPoint = uDto.getPoint();
		
		request.setAttribute("loginName", loginName);
		request.setAttribute("loginPoint", loginPoint);
		
		if( loginId.equals("admin") ) {
			UserInfoDao uDao = new UserInfoDao();
			ArrayList<UserDto> uList = uDao.getUserList();
			request.setAttribute("userList", uList);
			request.getRequestDispatcher("admin.jsp").forward(request, response);
		} else {
			request.getRequestDispatcher("main.jsp").forward(request, response);
		}
		
	}

}
