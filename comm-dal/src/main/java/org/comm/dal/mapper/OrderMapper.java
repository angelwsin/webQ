package org.comm.dal.mapper;

import org.comm.dal.model.Order;
import org.springframework.stereotype.Repository;

@Repository("orderMapper")
public interface OrderMapper {
	
	
	 public int  insertOrder(Order order);
	 
	 public Order  findOrderByPtypeOrUserId(Order order);

}
