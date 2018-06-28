package com.app.controller;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.app.bean.ResultData;
import com.app.bean.Student;
import com.app.service.UserService;
import com.app.service.impl.UserServiceImpl;

@Controller
public class UserController {
	
	//用户业务类的引用
	private UserService userService = new UserServiceImpl();
	
	
	@RequestMapping("/getUsers")
	@ResponseBody
	public Map<String,Object> getUsers(HttpServletRequest request , HttpServletResponse response,Student student){
		System.out.println("开始搜索用户...");
		
		int page = Integer.parseInt(request.getParameter("page")); //第几页
		int rows = Integer.parseInt(request.getParameter("rows")); //每页多少行
		
		System.out.println(student);
		
		Map<String,Object> pageBean = userService.getUsers(student,page,rows);
		
		return pageBean;
	}
	
	@RequestMapping("/addUser")
	@ResponseBody
	public ResultData addUser(HttpServletRequest request , HttpServletResponse response,Student student){
		ResultData data = new ResultData();
		
		try{
			
			//先判断用户名是否重复
			
			int count = userService.getByUserName(student);
			
			if(count > 0){
				data.setErrCode(-1);
				data.setErrMsg("用户名已经存在啦，换一个吧。。。");
				return data;
			}
			
			userService.addUser(student);
		}catch(Exception e){
			data.setErrCode(-1);
			data.setErrMsg(e.getMessage());
		}
		
		return data;
		
		
	}    
}