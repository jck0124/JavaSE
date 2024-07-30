package servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.json.simple.JSONObject;

import dao.RemainingPointsDao;


@WebServlet("/AdvertisementServlet")
public class AdvertisementServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
  
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		HttpSession session = request.getSession();
		String id = (String)session.getAttribute("loginId");
		RemainingPointsDao rDao = new RemainingPointsDao();
		
		int addPoint = (int)(Math.random()*1000) + 1;
		
		rDao.adClick(id, addPoint);
		
		JSONObject jObj = new JSONObject();
		jObj.put("key", addPoint);
		
		response.setContentType("application/json; charset=utf-8");
		response.getWriter().print( jObj.toString() );
		
	}



}
