package com.internousdev.ecsite2.dao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.internousdev.ecsite2.util.DBConnector;

public class AddItemCompleteDAO {
		private DBConnector dbConnector = new DBConnector();
		private Connection connection = dbConnector.getConnection();

		private String sql="INSERT INTO item_info__transaction(item_name, item_price, item_stock) VALUES(?,?,?)";
		public void addItemInfo(String itemName, String itemPrice, String itemStock) throws SQLException{
			try{
					PreparedStatement preparedStatement = connection.prepareStatement(sql);
					preparedStatement.setString(1, itemName);
					preparedStatement.setString(2, itemPrice);
					preparedStatement.setString(3, itemStock);
					preparedStatement.execute();
			} catch(Exception e){
				e.printStackTrace();
			} finally{
				 connection.close();
			}
     }
}