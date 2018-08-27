package com.internousdev.ecsite2.dao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import com.internousdev.ecsite2.util.DBConnector;
import com.internousdev.ecsite2.util.DateUtil;

public class BuyItemCompleteDAO {
		private DBConnector dbConnector = new DBConnector();
		private Connection connection = dbConnector.getConnection();
		private DateUtil dateUtil = new DateUtil();
		private String sql = "INSERT INTO user_buy_item_transaction "
				             +"(buy_item_id, total_price,total_count, buy_login_id, pay,insert_date) values(?,?,?,?,?,?)";
							public void buyItemInfo(String buy_item_id, String buy_login_id,
									String total_price, String total_count, String pay) throws SQLException{
								try{
									PreparedStatement preparedStatement = connection.prepareStatement(sql);
									preparedStatement.setString(1, buy_item_id);
									preparedStatement.setString(2, total_price);
									preparedStatement.setString(3, total_count);
									preparedStatement.setString(4, buy_login_id);
									preparedStatement.setString(5, pay);
									preparedStatement.setString(6, dateUtil.getDate());
									preparedStatement.execute();
								} catch(Exception e){
									e.printStackTrace();
								}finally{
									connection.close();
								}
							}
}
