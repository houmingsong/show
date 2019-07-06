package com.lovo.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.lovo.dao.IUserDao;
import com.lovo.entity.UserEntity;
import com.lovo.service.IUserService;
@Service(value="userService")
public class UserServiceImpl implements IUserService{
	
	@Autowired
	private IUserDao userDao;
	@Override
	public List<UserEntity> findByItem(int currentpage) {	
		currentpage = (currentpage - 1) * 4;
		return userDao.findByItem(currentpage);
	}

	@Override
	public int getTotalPage() {
		Integer totalCount = userDao.getTotalPage();
		Integer totalPage = (totalCount + 4 - 1)/4;
		return totalPage;
	}

}
