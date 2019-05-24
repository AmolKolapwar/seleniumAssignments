package com.test.utilities;

import java.util.ArrayList;
import java.util.List;

import org.testng.TestNG;

public class Rerunne {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		TestNG runner = new TestNG();
		List<String> list = new ArrayList<String>();
		list.add("Provide Failed Testing.xml file path ");
		runner.run();
		
	}

}
