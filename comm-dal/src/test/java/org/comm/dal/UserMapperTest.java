package org.comm.dal;

import org.comm.dal.mapper.UserMapper;
import org.comm.dal.model.User;
import org.junit.Assert;
import org.junit.Test;

public class UserMapperTest  extends AppContextTest{
	
	    
	    // @Test
	      public void  insertUserTest(){
	    	 UserMapper userMapper =   (UserMapper) context.getBean("userMapper");
	    	  User user = new User();
	    	  user.setName("zf");
	    	  userMapper.insertUser(user);
	    	  
	      }
	      @Test
	      public void find(){
	    	  UserMapper userMapper =   (UserMapper) context.getBean("userMapper");
	    	  User u = userMapper.findByName("zf");
	    	  Assert.assertEquals(u.getName(), "zf");
	      }

}
