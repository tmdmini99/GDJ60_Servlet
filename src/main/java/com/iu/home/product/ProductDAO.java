package com.iu.home.product;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.iu.home.util.DBConnection;

public class ProductDAO {
	
	//getMax
	public Long getProductNum() throws Exception{
		Connection con = DBConnection.getConnection1();
		
		String sql = "SELECT MAX(PRODUCT_NUM) FROM PRODUCTOPTION";
		
		PreparedStatement st = con.prepareStatement(sql);
		
		ResultSet rs = st.executeQuery();
		
		rs.next();
		 Long num = rs.getLong(1);
		 
		 DBConnection.disConnection(rs, st, con);
		 
		 return num;
		
	}
	
	
	
	//ProductOption 메서드
	
	public List<ProductOptionDTO> getProductOptionList()throws Exception{
		List<ProductOptionDTO> ar = new ArrayList<ProductOptionDTO>();
		
		Connection con = DBConnection.getConnection1();
		String sql="SELECT PRODUCT_SEQ.NEXTVAL FROM DUAL";
		PreparedStatement st = con.prepareStatement(sql);
		
		ResultSet rs = st.executeQuery();
		
		while(rs.next()) {
			ProductOptionDTO dto = new ProductOptionDTO();
			dto.setOptionNum(rs.getLong("OPTION_NUM"));
			dto.setProductNum(rs.getLong("PRODUCT_NUM"));
			dto.setOptionDetail(rs.getString("OPTION_DETAIL"));
			dto.setOptionPrice(rs.getLong("OPTION_PRICE"));
			dto.setOptionInventory(rs.getLong("OPTION_INVENTORY"));
			
			ar.add(dto);
			
		}
		return ar;
	}
	
	
	
	public int setProdcutOption(ProductOptionDTO dto) throws Exception{
		Connection con = DBConnection.getConnection1();
		
		String sql = "INSERT INTO PRODUCTOPTION VALUES(PRODUCT_OPTION_SEQ.NEXTVAL,?,?,?,?)";
		
		PreparedStatement st = con.prepareStatement(sql);
		
		st.setLong(1, dto.getProductNum());
		st.setString(2, dto.getOptionDetail());
		st.setLong(3, dto.getOptionPrice());
		st.setLong(4, dto.getOptionInventory());
		
		int result = st.executeUpdate();
		
		DBConnection.disConnection(st, con);
		return result;
	}
	
	
	
	
	
	// Product 메서드
	public List<ProductDTO> getProductList()throws Exception{
		ArrayList<ProductDTO> ar = new ArrayList<ProductDTO>();
		
		Connection con = DBConnection.getConnection1();
		
		String sql = "SELECT PRODUCT_NUM,PRODUCT_NAME,PRODUCT_JUMSU "
				+ "FROM PRODUCT ORDER BY PRODUCT_JUMSU DESC";
	
		PreparedStatement st = con.prepareStatement(sql);
		
		ResultSet rs = st.executeQuery();
		
		while(rs.next()) {
			ProductDTO productDTO = new ProductDTO();
			productDTO.setProductNum(rs.getLong("PRODUCT_NUM"));
			productDTO.setProductName(rs.getString("PRODUCT_NAME"));
			productDTO.setProductJumsu(rs.getDouble("PRODUCT_JUMSU"));
			
			ar.add(productDTO);
		}
		DBConnection.disConnection(rs, st, con);
		
		return ar;
	}
	
	
	public int setProduct(ProductDTO productDTO) throws Exception{
		Connection con = DBConnection.getConnection1();
		
		String sql = "INSERT INTO PRODUCT(PRODUCT_NUM, PRODUCT_NAME, PRODUCT_DETAIL, PRODUCT_JUMSU) VALUES(?,?,?,?)";
		
		PreparedStatement st = con.prepareStatement(sql);
		
		
		st.setLong(1, productDTO.getProductNum());
		st.setString(2, productDTO.getProductName());
		st.setString(3, productDTO.getProductDetail());
		st.setDouble(4, productDTO.getProductJumsu());
		
		int result = st.executeUpdate();
		return result;
	}
	
	public static void main(String[] args) {
		
		try {
			ProductDAO dao = new ProductDAO();
			ProductDTO dto = new ProductDTO();
			
			List<ProductOptionDTO> ar =dao.getProductOptionList();
			
			
			
//			dto.setProductname("상품");
//			dto.setProductdetail("설명");
//			dto.setProductjumsu(1.1);
//			int a= dao.setProduct(dto);
			
			System.out.println(ar.size()!=0);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
