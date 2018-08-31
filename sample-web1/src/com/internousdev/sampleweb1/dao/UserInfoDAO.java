package com.internousdev.sampleweb1.dao;

import java.sql.SQLException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Connection;

import com.internousdev.sampleweb1.util.DBConnector;
import com.internousdev.sampleweb1.dto.UserInfoDTO;

public class UserInfoDAO {
	public int createUser(String familyName, String firstName, String familyNameKana,
			String firstNameKana, String sex, String email, String userId, String password){
		DBConnector dbConnector = new DBConnector();
		Connection con = dbConnector.getConnection();
		int count =0;
		String sql = "insert into user_info(user_id, password, family_name, first_name, "
				+ "family_name_kana, first_name_kana, sex, email, status, userId, regist_date, "
				+ "update_date) "
				+ "values (?,?,?,?,?,?,?,?,?,?, now(), 0)";
		try{
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, userId);
			ps.setString(2, password);
			ps.setString(3, familyName);
			ps.setString(4, firstName);
			ps.setString(5, familyNameKana);
			ps.setString(6, firstNameKana);
			ps.setString(7, sex);
			ps.setString(8, email);
			ps.setInt(9, 0);
			ps.setInt(10, 1);
			count = ps.executeUpdate();
		}catch(SQLException e){
			e.printStackTrace();
		}
		try{
			con.close();
		}catch (SQLExeption e){
			e.printStackTrace();
		}
		return count;
	}

		public boolean isExistsUserInfo(String userId, String password){
			DBConnector dbConnector = new DBConnector();
			Connection con = dbConnector.getConnection();
			boolean result = false;
			String sql = "select count(*) as count from user_info where user_id=? and password=?";
			try{
				PreparedStatement ps = con.prepareStatement(sql);
				ps.setString(1, userId);
				ps.setString(2, password);
				ResultSet rs = ps.executeQuery();
				while(rs.next()){
					if(rs.getInt("count") > 0){
						result = true;
					}
				}
			}catch(SQLException e){
				e.printStackTrace();
			}
			try{
				con.close();
			}catch(SQLException e){
				e.printStackTrace();
			}
			return result;
		}
		public UserInfoDTO getUserInfo(String userId, String password){
			DBConnector dbConnector = new DBConnector();
			Connection con = dbConnector.getConnection();
			UserInfoDTO userInfoDTO = new UserInfoDTO();
			String sql = "select * from user_info where user_id=? and password=?";
			try{
				PreparedStatement ps = con.prepareStatement(sql);
				ps.setString(1, userId);
				ps.setString(2, password);
				ResultSet rs = ps.executeQuery();
				while(rs.next()){
					userInfoDTO.setId(rs.getInt("id"));
					userInfoDTO.setUserId(rs.getString("user_id"));
					userInfoDTO.setPassword(rs.getString("password"));
					userInfoDTO.setFamilyName(rs.getString("family_name"));
					userInfoDTO.setFirstName(rs.getString("first_name"));
					userInfoDTO.setFamilyNameKana(rs.getString("family_name_kana"));
					userInfoDTO.setFirstNameKana(rs.getString("first_name_kana"));
					userInfoDTO.setSex(rs.getInt("sex"));
					userInfoDTO.setEmail(rs.getString("email"));
					userInfoDTO.setStatus(rs.getString("status"));
					userInfoDTO.setUserId(rs.getInt("userId"));
					userInfoDTO.setRegistDate(rs.getDate("regist_date"));
					userInfoDTO.setUpdateDate(rs.getDate("update_date"));
				}
			}catch (SQLException e){
				e.printStackTrace();
			}
			try{
				con.close();
			}catch(SQLException e){
				e.printStackTrace();
			}
			return userInfoDTO;
		}

		public UserInfoDTO getUserInfo(String userId){
			DBConnector dbConnector = new DBConnector();
			Connection con = dbConnector.getConnection();
			UserInfoDTO userInfoDTO = new UserInfoDTO();
			String sql = "select * from user_info where user_id=?";
			try{
				PreparedStatement ps = con.prepareStatement(sql);
				ps.setString(1, userId);
				ResultSet rs = ps.executeQuery();
				while(rs.next()){
					userInfoDTO.setId(rs.getInt("id"));
					userInfoDTO.setUserId(rs.getString("user_id"));
					userInfoDTO.setPassword(rs.getString("password"));
					userInfoDTO.setFamilyName(rs.getString("family_name"));
					userInfoDTO.setFirstName(rs.getString("first_name"));
					userInfoDTO.setFamilyNameKana(rs.getString("family_name_kana"));
					userInfoDTO.setFirstNameKana(rs.getString("first_name_kana"));
					userInfoDTO.setSex(rs.getInt("sex"));
					userInfoDTO.setEmail(rs.getString("email"));
					userInfoDTO.setStatus(rs.getString("status"));
					userInfoDTO.setLogined(rs.getInt("logined"));
					userInfoDTO.setRegistDate(rs.getDate("regist_date"));
					userInfoDTO.setUpdateDate(rs.getDate("update_date"));
				}
			}catch (SQLException e){
				e.printStackTrace();
			}
			try{
				con.close();
			}catch(SQLException e){
				e.printStackTrace();
			}
		return userInfoDTO;
		}

		public int resetPassword(String userId, String password){
			DBConnector dbConnector = new DBConnector();
			Connection con = dbConnector.getConnection();
			String sql = "update user_info set password=? where user_id=?";
			int result = 0;

		try{
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, password);
			ps.setString(2, userId);
			result = ps.executeUpdate();
		}catch(SQLException e){
			e.printStackTrace();
		}
		try{
			con.close();
		}catch (SQLException e){
			e.printStackTrace();
		}
		return result;
		}

		public int login(String userId, String password){
			DBConnector dbConnector = new DBConnector();
			Connection con = dbConnector.getConnection();
			int result = 0;
			String sql = "update user_info set logined=1 where user_id=? and password=?";
			try{
				PreparedStatement ps = con.prepareStatement(sql);
				ps.setString(1, userId);
				ps.setString(2, password);
				result = ps.executeUpdate();
			}catch(SQLExeption e){
				e.printStackTrace();
			}
			try{
				con.close();
			}catch(SQLException e){
				e.printStackTrace();
			}
			return result;
		}

		public int logout(String userId){
			DBConnector dbConnector = new DBConnector();
			Connection con = dbConnector.getConnection();
			int result =0;
			String sql = "update user_info set logined=0 where user_id=?";
			try{
				PreparedStatement ps = con.prepareStatement(sql);
				ps.setString(1, userId);
				result = ps.executeUpdate();
			}catch (SQLException e){
				e.printStackTrace();
			}
			try{
				con.close();
			}catch(SQLException e){
				e.printStackTrace();
			}
			return result;
		}

		public String concealPassword(String password){
			int beginIndex = 0;
			int endIndex = 1;
			if(password.length() > 1){
				endIndex = 2;
			}
			StringBuilder stringBuilder = new StringBuilder("*************");

			String concealPassword = "stringBuilder.replace(beginIndex, endIndex, password.substring "
					+ "(beginIndex, endIndex)).toString()";
			return concealPassword;
		}
}
