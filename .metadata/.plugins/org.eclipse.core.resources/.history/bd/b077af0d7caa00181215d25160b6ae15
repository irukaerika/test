package com.internousdev.ecsite2.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.internousdev.ecsite2.dto.ItemDetailsDTO;
import com.internousdev.ecsite2.util.DBConnector;

public class ItemDetailsDAO {
		private DBConnector dbConnector = new DBConnector();
		public Connection connection = dbConnector.getConnection();

		public ItemDetailsDTO getItemDetailsInfo(String id) {
			DBConnector dbConnector = new DBConnector();
			Connection connection = dbConnector.getConnection();
			ItemDetailsDTO itemDetailsDTO = new ItemDetailsDTO();

			String sql = "select * from item_info_transaction where id=?";
					try{
						PreparedStatement preparedStatement = connection.prepareStatement(sql);
						preparedStatement.setString(1, id);
						ResultSet resultSet = preparedStatement.executeQuery();
						while(resultSet.next()){
							itemDetailsDTO.setItemId(resultSet.getString("id"));
							itemDetailsDTO.setItemName(resultSet.getString("item_name"));
							itemDetailsDTO.setItemPrice(resultSet.getString("item_price"));
							itemDetailsDTO.setItemStock(resultSet.getString("item_stock"));
						}
					} catch (SQLException e) {
						e.printStackTrace();
					}
					try {
						connection.close();
					} catch (SQLException e) {
						e.printStackTrace();
					}
					return itemDetailsDTO;
				}
		public int itemDetailsDelete(String id)throws SQLException{

			String sql = "delete from item_info_transaction where id=?";


			PreparedStatement preparedStatement;

			int result = 0;
		try{
			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1, id);
			result = preparedStatement.executeUpdate();
		} catch(SQLException e){
			e.printStackTrace();
		} finally{
			connection.close();
		}
		return result;
		}

		public int updateItemDetails(String itemName, String itemPrice, String itemStock, String id)throws SQLException{

			String sql = "update item_info_transaction set item_name=?, item_price=?, item_stock=? where id=?";

			int result = 0;

		try{
			PreparedStatement preparedStatement;
			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1, itemName);
			preparedStatement.setString(2, itemPrice);
			preparedStatement.setString(3, itemStock);
			preparedStatement.setString(4, id);
			result = preparedStatement.executeUpdate();

		} catch(SQLException e){
			e.printStackTrace();
		} finally{
			connection.close();
		}
		return result;
		}
}


