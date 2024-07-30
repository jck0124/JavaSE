package dao;

import dto.UserDto;

public class DaoMain {
	public static void main(String[] args) {
		
//		JoinDao jDao = new JoinDao();
//		jDao.userJoin("testId1", "testPw1", "tester1");
		
		
//		LoginDao lDao = new LoginDao();
//		boolean loginResult = lDao.userLogin("testId1", "testPw1");
//		System.out.println(loginResult);
		
		UserInfoDao uiDao = new UserInfoDao();
		UserDto uDto = uiDao.getUserInfo("testId1");
		System.out.println( uDto.getName() );
		
		
		
	}
}
