package com.lovo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.lovo.entity.PageBean;
import com.lovo.entity.UserEntity;
import com.lovo.service.IUserService;

@Controller
public class UserController {

	@Autowired
	private IUserService userService;

	@RequestMapping("show.lovo")
	@ResponseBody
	public PageBean<UserEntity> show(Integer currentPage) {
		Integer totlePage = userService.getTotalPage();
		if (currentPage < 1) {
			currentPage = 1;
		} else if (currentPage > totlePage) {
			currentPage = totlePage;
		}
		List<UserEntity> list = userService.findByItem(currentPage);
		PageBean<UserEntity> page = new PageBean<UserEntity>();
		page.setList(list);
		page.setCurrentPage(currentPage);
		page.setTotalPage(totlePage);
		return page;
	}
}
