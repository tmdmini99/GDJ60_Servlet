package com.iu.home.product;

public class ProductService {

	public static void main(String[] args) {
		
		ProductDAO productDAO = new ProductDAO();
		
		ProductDTO productDTO = new ProductDTO();
		productDTO.setProductName("product1");
		productDTO.setProductDetail("detail1");
		
		
		ProductOptionDTO productOptionDTO = new ProductOptionDTO();
		
		
		
		
		
		
		try {
			
			Long num = productDAO.getProductNum();
			
			productDTO.setProductNum(num);
			
			int result = productDAO.setProduct(productDTO);
			
			productOptionDTO.setOptionNum(1L);
			productOptionDTO.setProductNum(num);
			productOptionDTO.setOptionInventory(3L);
			productOptionDTO.setOptionPrice(5L);
			
			if(result>0) {
				productDAO.setProdcutOption(productOptionDTO);
				
			}
			
			
			
		} catch (Exception e) {
			
			e.printStackTrace();
		}

	}

}
