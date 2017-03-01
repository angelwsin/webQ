package org.comm.dal;

import org.comm.dal.mapper.OrderMapper;
import org.comm.dal.model.Order;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class OrderMapperTest  extends AppContextTest{
	
	 private OrderMapper  orderMapper;
	 
	 @Before
	 public void setOrderMapper(){
		   orderMapper = (OrderMapper) context.getBean("orderMapper");
	 }
	 
	 //@Test
	 public void  insetOrder(){
		 Order order = new Order();
		 order.setpType("biyuntao");
		 order.setUserId(1);
		 int x =  orderMapper.insertOrder(order);
		 Assert.assertEquals(1, x);
	 }
	 
	 @Test
	 public void findOrder(){
		 Order order = new Order();
		 order.setpType("biyuntao");
		 order.setUserId(1);
		 order =  orderMapper.findOrderByPtypeOrUserId(order);
		 Assert.assertEquals(1, order.getUserId());
	 }

}
