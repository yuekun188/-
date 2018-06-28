package com.app.service;

import java.util.Map;

import com.app.bean.Student;

public interface UserService {

	void addUser(Student student);

	int getByUserName(Student student);

	Map<String, Object> getUsers(Student student, int page, int rows);

}
