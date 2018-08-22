package com.internousdev.ecsite2.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.internousdev.ecsite2.dto.AddItemListDTO;
import com.internousdev.ecsite2.util.DBConnector;

public class AddItemListDAO {
		private DBConnector dbConnector = new DBConnector();
		private Connection connection = dbConnector.getConnection();

		public ArrayList<AddItemListDTO> getAllItemListInfo() throws SQLException {
			ArrayList<AddItemListDTO> addItemListDTO = new ArrayList<AddItemListDTO>();
			String sql = "SELECT id,item_name,item_price,item_stock FROM item_info_transaction";
					try{
						PreparedStatement preparedStatement = connection.prepareStatement(sql);

						ResultSet resultSet = preparedStatement.executeQuery();

						while(resultSet.next()){
							AddItemListDTO dto = new AddItemListDTO();
							dto.setId(resultSet.getString("id"));
							dto.setItemName(resultSet.getString("item_name"));
							dto.setItemPrice(resultSet.getString("item_price"));
							dto.setItemStock(resultSet.getString("item_stock"));
							addItemListDTO.add(dto);
							}
					} catch(Exception e){
						e.printStackTrace();
					}finally{
						connection.close();
					}
			return addItemListDTO;
		}

		public int itemHistoryDelete()throws SQLException{

		String sql = "DELETE FROM item_info_transaction";
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


