package com.internousdev.sampleweb1.dao;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.internousdev.sampleweb1.util.DBConnector;
import com.internousdev.sampleweb1.dto.PurchaseHistoryInfoDTO;

public class PurchaseHistoryInfoDAO {

	public List<PurchaseHistoryInfoDTO> getPurchaseHistoryList(String userId){
		DBConnector dbConnector = new DBConnector();
		Connection con = dbConnector.getConnection();
		List<PurchaseHistoryInfoDTO> purchaseHistoryInfoDtoList = new ArrayList<PurchaseHistoryInfoDTO>();
		String sql = "select"
				+ "phi.id as id," /*purchase_history_info のid*/
				+ "phi.user_id as user_id," /*user_id*/
				+ "phi.product_count as product_count," /*個数*/
				+ "pi.product_id as product_id," /*purchase_info の商品ID*/
				+ "pi.product_name as product_name," /*商品名*/
				+ "pi.product_name_kana as product_name_kana," /*商品名かな*/
				+ "pi.pi.product_description as product_description," /*商品詳細*/
				+ "pi.category_id as category_id," /*カテゴリID*/
				+ "pi.price as price," /* 価格*/
				+ "pi.image_file_name as image_file_name," /*画像ファイルパス*/
				+ "pi.image_file_path as image_file_path," /*画像ファイル名*/
				+ "pi.release_date as release_date," /*発売年月日*/
				+ "pi.release_company as release_company," /*発売会社名*/
				+ "phi.price as price,"/*purchase_history_info の価格*/
				+ "phi.regist_date as regist_date,"/*登録日*/
				+ "phi.update_date as update_date,"/*更新日*/
				+ "di.family_name as family_name,"/*destination_info の性*/
				+ "di. first_name as first_name,"/*名*/
				+ "di.family_name_kana as family_name_kana,"/*性かな*/
				+ "di.first_name_kana,"/*名かな*/
				+ "di.email as email,"/*メールアドレス*/
				+ "di.tel_number as tel_number,"/*電話番号*/
				+ "di.user_address as user_address,"/*住所*/
				+ "From purchase_history_info as phi"
				+ "LEFT JOIN product_info as pi"
				+ "ON phi.product_id = pi.product_id"
				+ "LEFT JOIN destination_info as di"
				+ "ON phi.destination_id = di.destination_id"
				+ "WHERE phi.user_id = ?"
				+ "ORDER BY regist_date DESC";
	try{
		PreparedStatement ps = con.prepareStatement(sql);
		ps.setString(1, userId);
		ResultSet rs = ps.executeQuery();
		while(rs.next()){
			PurchaseHistoryInfoDTO purchaseHistoryInfoDto = new PurchaseHistoryInfoDTO();
			purchaseHistoryInfoDto.setId(rs.getInt("id"));
			purchaseHistoryInfoDto.setUserId(rs.getString("user_id"));
			purchaseHistoryInfoDto.setProductId(rs.getInt("product_id"));
			purchaseHistoryInfoDto.setProductCount(rs.getInt("product_count"));
			purchaseHistoryInfoDto.setPrice(rs.getInt("price"));
			purchaseHistoryInfoDto.setRegistDate(rs.getDate("regist_date"));
			purchaseHistoryInfoDto.setUpdateDate(rs.getDate("update_date"));
			purchaseHistoryInfoDto.setProductName(rs.getString("product_name"));
			purchaseHistoryInfoDto.setProductNameKana(rs.getString("product_name_kana"));
			purchaseHistoryInfoDto.setProductDescription(rs.getString("product_description"));
			purchaseHistoryInfoDto.setCategoryId(rs.getInt("category_id"));
			purchaseHistoryInfoDto.setImageFileName(rs.getString("image_file_name"));
			purchaseHistoryInfoDto.setImageFilePath(rs.getString("image_file_path"));
			purchaseHistoryInfoDto.setReleaseCompany(rs.getString("release_company"));
			purchaseHistoryInfoDto.setReleaseDate(rs.getDate("release_date"));
			purchaseHistoryInfoDto.setFamilyName(rs.getString("family_name"));
			purchaseHistoryInfoDto.setFirstName(rs.getString("first_name"));
			purchaseHistoryInfoDto.setFamilyNameKana(rs.getString("family_name_kana"));
			purchaseHistoryInfoDto.setFirstNameKana(rs.getString("first_name_kana"));
			purchaseHistoryInfoDto.setEmail(rs.getString("email"));
			purchaseHistoryInfoDto.setTelNumber(rs.getString("tel_number"));
			purchaseHistoryInfoDto.setUserAddress(rs.getString("user_address"));
			purchaseHistoryInfoDtoList.add(purchaseHistoryInfoDto);
		}
	}catch(SQLException e){
		e.printStackTrace();
	}
	try{
		con.close();
	}catch(SQLException e){
		e.printStackTrace();
	}
	return purchaseHistoryInfoDtoList;
	}

public int regist(String userId, int productId, int productCount, int destinationId, int price){
	DBConnector dbConnector = new DBConnector();
	Connection con = dbConnector.getConnection();
	String sql = "insert into purchase_history_info(user_id, product_id, product_count, price, "
			+ "destination_id, regist_date, update_date) values (?,?,?,?,?, now(), "
			+ "'0000-01-01')";
	int count = 0;
	try{
		PreparedStatement ps = con.prepareStatement(sql);
		ps.setString(1, userId);
		ps.setInt(2, productId);
		ps.setInt(3, productCount);
		ps.setInt(4, price);
		ps.setInt(5, destinationId);
		count = ps.executeUpdate();
	}catch(SQLException e){
		e.printStackTrace();
	}
	try{
		con.close();
	}catch (SQLException e){
		e.printStackTrace();
	}
	return count;
	}
public int deleteAll(String userId){
	DBConnector dbConnector = new DBConnector();
	Connection con = dbConnector.getConnection();
	String sql = "delete from purchase_history_info where user_id=?";
	int count = 0;
	try{
		PreparedStatement ps = con.prepareStatement(sql);
		ps.setString(1, userId);
		count = ps.executeUpdate();
	}catch(SQLException e){
		e.printStackTrace();
	}
	try{
		con.close();
	}catch(SQLException e){
		e.printStackTrace();
	}
	return count;
	}
}
