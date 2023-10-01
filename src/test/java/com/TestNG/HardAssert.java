package com.TestNG;

import static org.testng.Assert.*;

import org.testng.annotations.Test;

public class HardAssert {

	@Test
	public void hardAssert1() {
		System.out.println("---step 1--");
		System.out.println("--step 2 --");

		assertEquals("A", "B", "expect b but found a");
		System.out.println("--step 3--");
		System.out.println("--step 4--");

	}
	@Test
	public void hardAssertTest2() {
		System.out.println("--step 5--");
		System.out.println("--step 6--");
		
		assertNotEquals("x", "y");
		
		System.out.println("--step 7--");
		System.out.println("--step 8--");
	}
	@Test
	public void hardAssert() {
		int m=5;
		assertNull(m);
		System.out.println("--step 9--");
	}
}
