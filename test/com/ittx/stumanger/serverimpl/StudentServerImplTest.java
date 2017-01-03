package com.ittx.stumanger.serverimpl;

import java.util.HashMap;

import org.junit.Test;

public class StudentServerImplTest {
	private StudentServerImpl studentServer = new StudentServerImpl();
	@Test
	public void testAddStudent() {
		HashMap<String,String> parameters = new HashMap<>();
		parameters.put("name", "张三");
		parameters.put("number","1001");
		parameters.put("age", "23");
		parameters.put("sex", "1");
		parameters.put("headerImg","");
		String rootDir = "d://imgs/";
		studentServer.addStudent(parameters, rootDir);
	}

	@Test
	public void testSelectAllStudent() {
		
	}

}
