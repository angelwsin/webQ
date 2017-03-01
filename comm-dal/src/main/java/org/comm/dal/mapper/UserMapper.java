package org.comm.dal.mapper;

import org.comm.dal.model.User;
import org.springframework.stereotype.Repository;

@Repository("userMapper")
public interface UserMapper {
	
	public   int insertUser(User user);
	
	public User findByName(String name);

}
