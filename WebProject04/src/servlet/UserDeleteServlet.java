package servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.simple.JSONObject;

import dao.UserInfoDao;


@WebServlet("/UserDeleteServlet")
public class UserDeleteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String id = request.getParameter("id");
		UserInfoDao uDao = new UserInfoDao();
		uDao.deleteUser(id);
		
		JSONObject jObj = new JSONObject();
		jObj.put("key", true);
		
		response.setContentType("application/json; charset=utf-8");
		response.getWriter().print( jObj.toString() );
	}


}
