package org.test;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class Asssert
{
	@Test
	private void tc2() {
		SoftAssert q = new SoftAssert();
		q.assertTrue(false);
		System.out.println("test2");
		// q.assertAll();
		System.out.println("testcase");
		System.out.println("testcase exceuted");
		q.assertAll();
	}
	

}
