package test;

import java.util.HashMap;
import java.util.Map;

import com.simple.dao.SimpleDao;

public class TestQueryForPage {
	public static void main(String[] args) {
		String sql = "select * from t_student where 1=1 and sex = ?";

		SimpleDao dao = new SimpleDao();
		Map<String, Object> list = dao.queryForPage(sql, 1, 10, "男");
		System.out.println(list);
	}
}
