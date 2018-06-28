package com.app.dao.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.app.bean.Student;
import com.app.dao.UserDao;
import com.simple.dao.SimpleDao;

public class UserDaoImpl implements UserDao {

	@Override
	public void addUser(Student student) {
		
		SimpleDao dao = new SimpleDao();
		
		Map map = new HashMap();
		
		map.put("id", null);
		map.put("username", student.getUsername());
		map.put("password", student.getPassword());
		map.put("name", student.getName());
		map.put("sex", student.getSex());
		
		dao.save("db_student", "t_student", map);
		
	}

	@Override
	public int getByUserName(Student student) {
		
		String sql = "select count(1) from t_student where username = ?";
		
		SimpleDao dao = new SimpleDao();
		return dao.queryForInt(sql, student.getUsername());
	}

	@Override
	public Map<String, Object> getUsers(Student student, int page, int rows) {
		String sql = "select * from t_student where 1=1 ";
		List args = new ArrayList();
		
		
		if(student.getId() != 0){
			sql += " and id = ?"; 
			args.add(student.getId());
		}
		
		
		if(student.getUsername() != null && !"".equals(student.getUsername())){
			sql += " and username = ?"; 
			args.add(student.getUsername());
		}
		
		if(student.getName() != null && !"".equals(student.getName())){
			sql += " and name = ?"; 
			args.add(student.getName());
		}
		
		SimpleDao dao = new SimpleDao();
		Map<String, Object> pageBean = dao.queryForPage(sql, page, rows, args.toArray());
		
		return pageBean;
	}

}
