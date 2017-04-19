package org.comm.cache;

import org.junit.Test;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.Transaction;

/**
 * Unit test for simple App.
 */
public class AppTest {
	
	//@Test
	public void test(){
		Jedis jedis = new Jedis();
		jedis.set("name", "zhangsan");
		
	}
	
	//乐观锁
	//@Test
	public void  version(){
		Jedis jedis = new Jedis();
		jedis.watch("version");
		Transaction tx = jedis.multi();
		tx.incr("version");
		tx.exec();
	}
	@Test
	public void lock(){
		Jedis jedis = new Jedis();
		Long lock  =jedis.setnx("lock","lock");
		if(lock==1){
			System.out.println("得到锁");
	     try{
	    	 buss();
	     }finally{
	    	Long res =  jedis.del("lock");
	    	if(res==1){
	    		System.out.println("释放锁成功");
	    	}
	     }
		}else{
			System.out.println("没有得到锁");
		}
	}

	private void buss() {
		// TODO Auto-generated method stub
		
	}
}
