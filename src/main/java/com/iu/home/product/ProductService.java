package com.iu.home.product;

import java.util.List;

public class ProductService {
	
	
	//결합도가 높다(강하다) 서비스가 죽을때 같이소멸되는 경우
	
	
	
	private ProductDAO productDAO;
	
	

	//결합도가 낮다(약하다)
	public void setProductDAO( ProductDAO productDAO) {
		this.productDAO =productDAO;
		
	}
	
	
	
	public int setAddProduct(ProductDTO productDTO, List<ProductOptionDTO> ar) throws Exception{
		//product, option  두가지를 전처리함
		Long productNum = productDAO.getProductNum();
		productDTO.setProductNum(productNum);
		
		int result = productDAO.setAddProduct(null);
		
		for(ProductOptionDTO productOptionDTO : ar) {
			productOptionDTO.setProductNum(productNum);
			result = productDAO.setAddProdcutOption(productOptionDTO);
			
		}
		return result;
		
		
		
	}
	
	
	
	
	
	
	
	
	
	public static void main(String[] args) {
		
		ProductDAO productDAO = new ProductDAO();
		
		ProductDTO productDTO = new ProductDTO();
		productDTO.setProductName("product1");
		productDTO.setProductDetail("detail1");
		
		
		ProductOptionDTO productOptionDTO = new ProductOptionDTO();
		
		
		
		
		
		
		try {
			
			Long num = productDAO.getProductNum();
			
			productDTO.setProductNum(num);
			
			int result = productDAO.setAddProduct(productDTO);
			
			productOptionDTO.setOptionNum(1L);
			productOptionDTO.setProductNum(num);
			productOptionDTO.setOptionAmount(3L);
			productOptionDTO.setOptionPrice(5L);
			
			if(result>0) {
				productDAO.setAddProdcutOption(productOptionDTO);
				
			}
			
			
			
		} catch (Exception e) {
			
			e.printStackTrace();
		}

	}

}
