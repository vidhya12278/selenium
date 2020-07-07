package org.test3;

import org.testng.annotations.Test;

public class One {

	@Test
	private void tc2() {
		long id = Thread.currentThread().getId();
		System.out.println(id +"test33");
		}
	@Test
	private void tc1() {
		long id = Thread.currentThread().getId();
		System.out.println(id +"test31");
		}
	@Test
	private void tc3() {
		long id = Thread.currentThread().getId();
		System.out.println(id +"test32");
		
		

	}
}
