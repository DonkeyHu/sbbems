package com.donkey.system.dao;

import java.util.List;

import com.donkey.common.utils.Query;
import com.donkey.system.model.UserDO;

public interface IUserDao {
	
	int update(UserDO userDO);
	
	List<UserDO> list(Query query);
	
	int count(Query query);
}
