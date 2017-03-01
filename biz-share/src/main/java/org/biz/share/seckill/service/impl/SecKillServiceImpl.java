package org.biz.share.seckill.service.impl;

import javax.annotation.Resource;

import org.biz.share.seckill.service.SecKillService;
import org.comm.dal.mapper.OrderMapper;
import org.comm.dal.mapper.ProductMapper;
import org.comm.dal.mapper.UserMapper;
import org.comm.dal.model.Order;
import org.comm.dal.model.Product;
import org.comm.dal.model.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service("secKillService")
public class SecKillServiceImpl implements SecKillService{

	private static Logger log = LoggerFactory.getLogger(SecKillServiceImpl.class); 
	@Resource(name="productMapper")
	private   ProductMapper productMapper;
	@Resource(name="orderMapper")
	private   OrderMapper    orderMapper;
	@Resource(name="userMapper")
	private   UserMapper     userMapper;
	
	@Transactional
	public String secKill(User user,String pType) {
		log.info("seckill "+user.getName());
		Product p = productMapper.findProductByPtype(pType);
		
		if(p.getSum()<=0){
			int update = productMapper.updateProduct(p.getVersion());
			if(update>0){
				user = userMapper.findByName(user.getName());
				Order  order = new Order();
				order.setpType(pType);
				order.setUserId(user.getId());
				Order orderp = orderMapper.findOrderByPtypeOrUserId(order);
				if(orderp==null){
					orderMapper.insertOrder(order);
				}				
				return user.getName()+"seckill sucess" ;
			}else{
				return "seckill already end";
			}
		}
		return user.getName()+" already";
	}

}
