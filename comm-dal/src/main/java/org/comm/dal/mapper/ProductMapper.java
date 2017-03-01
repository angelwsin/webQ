package org.comm.dal.mapper;

import org.comm.dal.model.Product;
import org.springframework.stereotype.Repository;

@Repository("productMapper")
public interface ProductMapper {
	
	public int  insertProduct(Product product);
	
	public int updateProduct(int version);
	
	public Product  findProductByPtype(String pType);
	

}
