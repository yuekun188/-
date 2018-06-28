package test;

import java.util.HashMap;
import java.util.Map;

import com.simple.dao.SimpleDao;

public class TestModify {
	public static void main(String[] args) {
		Map map = new HashMap();
		map.put("id", "2018012103"); //学号
		map.put("username", "gj"); //账号
		map.put("password", "123456"); //密码
		map.put("name", "郭靖"); //姓名
		map.put("sex", "男"); //性别

		SimpleDao dao = new SimpleDao();
		dao.update("db_student", "t_student", map, "id");
		System.out.println("修改成功！");
	}
}
