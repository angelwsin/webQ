package org.comm.dal;

import org.comm.dal.mapper.ProductMapper;
import org.comm.dal.model.Product;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class ProductMapperTest extends AppContextTest {
	
	
	        private  ProductMapper productMapper ;
	        
	        @Before
	        public void setProductMapper(){
	        	productMapper = (ProductMapper) context.getBean("productMapper");
	        }
	        
	        //@Test
	        public void insertProduct(){
	        	Product p = new Product();
	        	p.setpType("biyuntao");
	        	p.setSum(10);
	        	p.setVersion(1);
	          int x = 	productMapper.insertProduct(p);
	          Assert.assertEquals(1, x);
	        }
	        @Test
	        public void updateProduct(){
	        	Product p =productMapper.findProductByPtype("biyuntao");
	        	 Assert.assertEquals(p.getpType(), "biyuntao");
	        	int count =  productMapper.updateProduct(p.getVersion());
	        	Assert.assertEquals(1, count);
	        }

}
