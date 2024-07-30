package dao;

import java.sql.*;
import java.util.ArrayList;

import dto.UserDto;

public class UserInfoDao {

	
	Connection getConnection() throws Exception {
		String driver = "oracle.jdbc.driver.OracleDriver";
		String url = "jdbc:oracle:thin:@localhost:1521:xe";
		String dbId = "user0404";
		String dbPw = "pass1234";
		
		Class.forName(driver);
		DriverManager.getConnection(url, dbId, dbPw);
		
		Connection conn = DriverManager.getConnection(url, dbId, dbPw);
		return conn;
	}
	
	
	public UserDto getUserInfo(String id) {
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		UserDto uDto = new UserDto();
		
		try {
			conn = getConnection();
					
			String sql = 
					"SELECT  id, " + 
					"        password, " + 
					"        name, " + 
					"        point " + 
					"FROM    member " + 
					"WHERe   id = ? ";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, id);
			rs = pstmt.executeQuery();
			
			
			if( rs.next() ) {
				uDto.setId( rs.getString("id") );
				uDto.setPw( rs.getString("password") );
				uDto.setName( rs.getString("name") );
				uDto.setPoint( rs.getInt("point") );
			}
			
			
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if(rs != null) {
					rs.close();
				}
				if(pstmt != null) {
					pstmt.close();
				}
				if(conn != null) {
					conn.close();
				}
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
	
		
		
		
		
	
				
				
		return uDto;
	}
	
	
	public ArrayList<UserDto> getUserList() {
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		ArrayList<UserDto> uList = new ArrayList<UserDto>();
		
		try {
			conn = getConnection();
					
			String sql = 
					"SELECT  id, " + 
					"        password, " + 
					"        name, " + 
					"        point " + 
					"FROM    member ";
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			
			
			while( rs.next() ) {
				UserDto uDto = new UserDto();
				uDto.setId( rs.getString("id") );
				uDto.setPw( rs.getString("password") );
				uDto.setName( rs.getString("name") );
				uDto.setPoint( rs.getInt("point") );
				
				uList.add(uDto);
			}
			
			
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if(rs != null) {
					rs.close();
				}
				if(pstmt != null) {
					pstmt.close();
				}
				if(conn != null) {
					conn.close();
				}
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
		return uList;
	}
	
	
	
	public void deleteUser(String id) {
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			conn = getConnection();
			String sql = 
					"DELETE  " + 
					"FROM    member " + 
					"WHERE   id = ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, id);
			pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if(pstmt != null) {
					pstmt.close();
				}
				if(conn != null) {
					conn.close();
				}
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
	}
	
	
	public void userInfoUpdate(String id, String pw, String name, int point) {
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		try {
			conn = getConnection();
			String sql = 
					"UPDATE  member " + 
					"SET     id = ?, " + 
					"        password = ? , " + 
					"        name = ?, " + 
					"        point = 100000 " + 
					"WHERE   id = 'testId1' " + 
					"";
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, id);
			pstmt.setString(2, pw);
			pstmt.setString(3, name);
			pstmt.setInt(4, point);
			pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if(pstmt != null) {
					pstmt.close();
				}
				if(conn != null) {
					conn.close();
				}
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
	}
	
	
	
	
}
