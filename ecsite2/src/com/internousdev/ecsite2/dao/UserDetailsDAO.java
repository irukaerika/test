package com.internousdev.ecsite2.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.internousdev.ecsite2.dto.UserDetailsDTO;
import com.internousdev.ecsite2.util.DBConnector;

public class UserDetailsDAO {
		private DBConnector dbConnector = new DBConnector();
		public Connection connection = dbConnector.getConnection();

		public UserDetailsDTO getItemDetailsInfo(String id) {
			DBConnector dbConnector = new DBConnector();
			Connection connection = dbConnector.getConnection();
			UserDetailsDTO userDetailsDTO = new UserDetailsDTO();

			String sql = "select * from login_user_transaction where id=?";
					try{
						PreparedStatement preparedStatement = connection.prepareStatement(sql);
						preparedStatement.setString(1, id);
						ResultSet resultSet = preparedStatement.executeQuery();
						while(resultSet.next()){
							userDetailsDTO.setId(resultSet.getString("id"));
							userDetailsDTO.setUserId(resultSet.getString("login_id"));
							userDetailsDTO.setPassword(resultSet.getString("login_pass"));
							userDetailsDTO.setUserName(resultSet.getString("user_name"));
						}
					} catch (SQLException e) {
						e.printStackTrace();
					}
					try {
						connection.close();
					} catch (SQLException e) {
						e.printStackTrace();
					}
					return userDetailsDTO;
				}


		public int userDetailsDelete(String loginId)throws SQLException{

			String sql = "delete from login_user_transaction where login_id=?";


			PreparedStatement preparedStatement;

			int result = 0;
		try{
			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1, loginId);
			result = preparedStatement.executeUpdate();
		} catch(SQLException e){
			e.printStackTrace();
		} finally{
			connection.close();
		}
		return result;
		}

		public int updateUserDetails(String userId, String password, String userName, String id)throws SQLException{

/*
			System.out.println(userId);
			System.out.println(password);*/
			String sql = "update login_user_transaction set login_id=?, login_pass=?, user_name=? where id=?";


			int result = 0;
		try{
			PreparedStatement preparedStatement;
			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1, userId);
			preparedStatement.setString(2, password);
			preparedStatement.setString(3, userName);
			preparedStatement.setString(4, id);

			result = preparedStatement.executeUpdate();
/*
			System.out.println(userId);
			System.out.println(password);
*/
		} catch(SQLException e){
			e.printStackTrace();
		} finally{
			connection.close();
		}
		return result;
		}

	}

