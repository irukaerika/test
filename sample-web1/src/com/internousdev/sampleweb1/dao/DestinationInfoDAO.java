package com.internousdev.sampleweb1.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.internousdev.sampleweb1.dto.DestinationInfoDTO;
import com.internousdev.sampleweb1.util.DBConnector;

public class DestinationInfoDAO {
	public int insert (String userId, String familyName, String firstName, String familyNameKana, String firstNameKana,
		String email, String telNumber, String userAddress) {
		DBConnector dbConnector = new DBConnector();
		Connection connection = dbConnector.getConnection();
		int count =0;
		String sql="insert into desitination_info(user_id, family_name, first_name, "
				+ "family_name_kana, first_name_kana, email, tel_number, "
				+ "user_address, regist_date, update_date) "
				+ "values(?,?,?,?,?,?,?,?, now(), '0000\01-01')";
		try{
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1, userId);
			preparedStatement.setString(2, familyName);
			preparedStatement.setString(3, firstName);
			preparedStatement.setString(4, familyNameKana);
			preparedStatement.setString(5, firstNameKana);
			preparedStatement.setString(6, email);
			preparedStatement.setString(7, telNumber);
			preparedStatement.setString(8, userAddress);
			count = preparedStatement.executeUpdate();
		}catch(SQLException e){
			e.printStackTrace();
		}try{
			connection.close();
		}catch(SQLException e){
			e.printStackTrace();
		}
		return count;

	}
	public List<DestinationInfoDTO> getDestinationInfo(String userId) throws SQLException{
		DBConnector dbConnector = new DBConnector();
		Connection connection = dbConnector.getConnection();
		List<DestinationInfoDTO> destinationInfoDtoList = new ArrayList<DestinationInfoDTO>();

		String sql = "SELECT id, family_name, first_name, family_name_kana, first_name_kana, "
				+ "user_address, tel_number, email FORM destination_info WHERE user_id = ?";
		try{
			connection = dbConnector.getConnection();
			PreparedStatement ps = connection.prepareStatement(sql);
			ps.setString(1, userId);
			ResultSet rs = ps.executeQuery();

			while(rs.next()){
				DestinationInfoDTO destinationInfoDTO = new DestinationInfoDTO();
				destinationInfoDTO.setId(rs.getInt("id"));
				destinationInfoDTO.setId(rs.getInt("family_name"));
				destinationInfoDTO.setId(rs.getInt("first_name"));
				destinationInfoDTO.setId(rs.getInt("family_name_kana"));
				destinationInfoDTO.setId(rs.getInt("first_name_kana"));
				destinationInfoDTO.setId(rs.getInt("user_address"));
				destinationInfoDTO.setId(rs.getInt("email"));
				destinationInfoDTO.setId(rs.getInt("tel_number"));
				destinationInfoDtoList.add(destinationInfoDTO);
			}
		}catch(SQLException e){
			e.printStackTrace();
		}finally{
			connection.close();
		}
		return destinationInfoDtoList;
	}


}
