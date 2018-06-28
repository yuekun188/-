package test;

import java.util.HashMap;
import java.util.Map;

import com.simple.dao.SimpleDao;

public class TestDelete {
	public static void main(String[] args) {
		
		SimpleDao dao = new SimpleDao();
		dao.update("delete from t_student where id = ?", 2018012102);
		System.out.println("删除成功！");
	}
}
