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
import dao.UserInfoDao;
import dto.UserDto;


@WebServlet("/RemainingPoints")
public class RemainingPoints extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		HttpSession session = request.getSession();
		RemainingPointsDao pDao = new RemainingPointsDao();
		UserInfoDao uDao = new UserInfoDao();
		
		int price = Integer.parseInt( request.getParameter("price") );
		String subject = request.getParameter("subject");
		String id = (String)session.getAttribute("loginId");
		
		
		// T면 구입가능, F면 불가능
		boolean result = pDao.remainingPoints(id, price);
		
		if(result) {
			UserDto uDto = uDao.getUserInfo(id);
			
			int userPoint = uDto.getPoint();
			int remainPoint = (userPoint - price);
			request.setAttribute("loginPoint", remainPoint);
			
			// 유저 포인트 갱신
			pDao.updateUserPoint(id, remainPoint);
			
			// 판매기록 테이블에 insertinto
			pDao.updateSalesRecords(id, subject);
		}
		
		JSONObject jObj = new JSONObject();
		jObj.put("key", result);
		
		response.setContentType("application/json; charset=utf-8");
		response.getWriter().print( jObj.toString() );
	}



}
