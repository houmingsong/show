package com.lovo.dao;

import java.util.List;

import com.lovo.entity.UserEntity;

public interface IUserDao {
	
	public List<UserEntity> findByItem(int currentpage);
	
	public int getTotalPage();
}
