package com.internousdev.sampleweb1.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.PreparedStatement;
import java.util.ArrayList;
import java.util.List;
import java.sql.SQLException;

import com.internousdev.sampleweb1.dto.ProductInfoDTO;
import com.internousdev.sampleweb1.util.DBConnector;

public class ProductInfoDAO {

	public List<ProductInfoDTO> getProductInfoList(){
	DBConnector dbConnector = new DBConnector();
	Connection con = dbConnector.getConnection();
	List<ProductInfoDTO> productInfoDtoList = new ArrayList<ProductInfoDTO>();
	String sql = "select * from product_info";

	try{
		PreparedStatement ps = con.prepareStatement(sql);
		ResultSet rs = ps.executeQuery();
		while(rs.next()){
			ProductInfoDTO productInfoDto = new ProductInfoDTO();
			productInfoDto.setId(rs.getInt("id"));
			productInfoDto.setProductId(rs.getInt("product_id"));
			productInfoDto.setProductName(rs.getString("product_name"));
			productInfoDto.setProductNameKana(rs.getString("product_name_kana"));
			productInfoDto.setProductDescription(rs.getString("product_description"));
			productInfoDto.setCategoryId(rs.getInt("category_id"));
			productInfoDto.setPrice(rs.getInt("price"));
			productInfoDto.setImageFilePath(rs.getString("image_file_path"));
			productInfoDto.setImageFileName(rs.getString("image_file_name"));
			productInfoDto.setReleaseDate(rs.getDate("release_date"));
			productInfoDto.setReleaseCompany(rs.getString("release_company"));
			productInfoDto.setStatus(rs.getInt("status"));
			productInfoDto.setRegistDate(rs.getDate("regist_date"));
			productInfoDto.setUpdateDate(rs.getDate("update_date"));
			productInfoDtoList.add(productInfoDto);
		}
	}catch (SQLException e){
		e.printStackTrace();
	}try{
		con.close();
	}catch (SQLException e){
		e.printStackTrace();
	}
	return productInfoDtoList;
}

public ProductInfoDTO getProductInfo(int productId){
	DBConnector dbConnector = new DBConnector();
	Connection con = dbConnector.getConnection();
	ProductInfoDTO productInfoDTO = new ProductInfoDTO();
	String sql = "select * from product_info where product_id=?";
	try{
		PreparedStatement ps = con.prepareStatement(sql);
		ps.setInt(1, productId);
		ResultSet rs = ps.executeQuery();
		while(rs.next()){
			productInfoDTO.setId(rs.getInt("id"));
			productInfoDTO.setProductId(rs.getInt("product_id"));
			productInfoDTO.setProductName(rs.getString("product_name"));
			productInfoDTO.setProductNameKana(rs.getString("product_name_kana"));
			productInfoDTO.setProductDescription(rs.getString("product_description"));
			productInfoDTO.setCategoryId(rs.getInt("category_id"));
			productInfoDTO.setPrice(rs.getInt("price"));
			productInfoDTO.setImageFilePath(rs.getString("image_file_path"));
			productInfoDTO.setImageFileName(rs.getString("image_file_name"));
			productInfoDTO.setReleaseDate(rs.getDate("release_date"));
			productInfoDTO.setReleaseCompany(rs.getString("release_company"));
			productInfoDTO.setStatus(rs.getInt("status"));
			productInfoDTO.setRegistDate(rs.getDate("regist_date"));
			productInfoDTO.setUpdateDate(rs.getDate("update_date"));
		}
	}catch(SQLException e){
		e.printStackTrace();
	}
	try{
		con.close();
	}catch (SQLException e){
		e.printStackTrace();
	}
	return productInfoDTO;
}

public List<ProductInfoDTO> getProductInfoListByCategoryId(int categoryId, int productId,
		int limitOffset, int limitRowCount) {
	DBConnector dbConnector = new DBConnector();
	Connection con = dbConnector.getConnection();
	List<ProductInfoDTO> productInfoDtoList = new ArrayList<ProductInfoDTO>();
	String sql = "select * from product_info where categpry_id=? and product_id not in(?) order by rand() limit ?,?";

}
	{
}
}