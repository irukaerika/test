package com.internousdev.sampleweb1.dao;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Iterator;

import com.internousdev.sampleweb1.dto.MCategoryDTO;
import com.internousdev.sampleweb1.util.DBConnector;
public class MCategoryDAO {
	public List<MCategoryDTO> getMCategoryList(){
		DBConnector dbConnector = new DBConnector();
		Connection connection = dbConnector.getConnection();
		List<MCategoryDTO>mCategoryDtoList = new ArrayList<MCategoryDTO>();
		String sql = "select * from m_category";
		try{
			PreparedStatement ps = connection.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while(rs.next()){
				MCategoryDTO mCategoryDTO = new MCategoryDTO();
				mCategoryDTO.setId(rs.getInt("id"));
				mCategoryDTO.setCategoryId(rs.getInt("category_id"));
				mCategoryDTO.setCategoryName(rs.getString("category_name"));
				mCategoryDTO.setCategoryDescription(rs.getString("category_description"));
				mCategoryDTO.setInsertDate(rs.getDate("insert_date"));
				mCategoryDTO.setUpdateDate(rs.getDate("update_date"));
				mCategoryDtoList.add(mCategoryDTO);
			}
			Iterator<MCategoryDTO> iterator = mCategoryDtoList.iterator();
			if(!(iterator.hasNext())){
				mCategoryDtoList = null;
			}
		} catch (SQLException e){
			e.printStackTrace();
		}
		try{
			connection.close();
		}catch(SQLException e){
			e.printStackTrace();
		}
		return mCategoryDtoList;
	}
}