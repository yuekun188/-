package com.app.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.app.bean.Student;
import com.app.dao.UserDao;
import com.app.dao.impl.UserDaoImpl;
import com.app.service.UserService;
import com.simple.dao.SimpleDao;

public class UserServiceImpl implements UserService{
	
	private UserDao userDao = new UserDaoImpl();

	@Override
	public void addUser(Student student) {
		
		userDao.addUser(student);
		
	}

	@Override
	public int getByUserName(Student student) {
		
		return userDao.getByUserName(student);
	}

	@Override
	public Map<String, Object> getUsers(Student student, int page, int rows) {
		
		return userDao.getUsers(student, page,rows);
		
		
	}

}
