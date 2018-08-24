package com.internousdev.ecsite2.dao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import com.internousdev.ecsite2.util.DBConnector;
import com.internousdev.ecsite2.util.DateUtil;

public class UserCreateCompleteDAO {
		private DBConnector dbConnector = new DBConnector();
		private Connection connection = dbConnector.getConnection();
		private DateUtil dateUtil = new DateUtil();

		private String sql="INSERT INTO login_user_transaction(login_id, login_pass, user_name, flg_num, insert_date) VALUES(?,?,?,?,?)";
		public void createUser(String loginId, String loginPassword, String userName, boolean adminFlg) throws SQLException{
			try{
					PreparedStatement preparedStatement = connection.prepareStatement(sql);
					preparedStatement.setString(1, loginId);
					preparedStatement.setString(2, loginPassword);
					preparedStatement.setString(3, userName);
					preparedStatement.setBoolean(4, adminFlg);
					preparedStatement.setString(5, dateUtil.getDate());

					preparedStatement.execute();
			} catch(Exception e){
				e.printStackTrace();
			} finally{
				 connection.close();
			}
     }
}


