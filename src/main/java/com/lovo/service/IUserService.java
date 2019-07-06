package com.lovo.service;

import java.util.List;

import com.lovo.entity.UserEntity;

public interface IUserService {

	public List<UserEntity> findByItem(int currentpage);

	public int getTotalPage();
}
