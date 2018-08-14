package com.internousdev.ecsite2.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.internousdev.ecsite2.dto.UserListDTO;
import com.internousdev.ecsite2.util.DBConnector;

public class UserListDAO {
		private DBConnector dbConnector = new DBConnector();
		private Connection connection = dbConnector.getConnection();

		public ArrayList<UserListDTO> getUserListInfo() throws SQLException {
			ArrayList<UserListDTO> userListDTO = new ArrayList<UserListDTO>();
			String sql = "SELECT id,login_id,login_pass,user_name FROM login_user_transaction";
					try{
						PreparedStatement preparedStatement = connection.prepareStatement(sql);

						ResultSet resultSet = preparedStatement.executeQuery();

						while(resultSet.next()){
							UserListDTO dto = new UserListDTO();
							dto.setId(resultSet.getString("id"));
							dto.setUserId(resultSet.getString("login_id"));
							dto.setPassword(resultSet.getString("login_pass"));
							dto.setUserName(resultSet.getString("user_name"));
							userListDTO.add(dto);
						}
								} catch(Exception e){
									e.printStackTrace();
								}finally{
									connection.close();
								}
								return userListDTO;
							}

		public int userHistoryDelete()throws SQLException{

		String sql = "DELETE FROM login_user_transaction";
	PreparedStatement preparedStatement;
	int result = 0;
	try{
			preparedStatement = connection.prepareStatement(sql);

			result = preparedStatement.executeUpdate();
	} catch(SQLException e){
		e.printStackTrace();
	} finally{
		connection.close();
	}
	return result;
	}

}