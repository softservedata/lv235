package com.softserve.edu;

import org.junit.Assert;
import org.junit.Test;

public class AppTest {
	
	@Test
	public void testApp() {
		//double i = 1. / 0;
		//int i = 1 / 0;
		//System.out.println("i=" + i);
		//Assert.assertEquals(1, 1.0, 0.001);
		Calc calc = new Calc();
		Assert.assertEquals(3, calc.add(2, 1), 0.001);
		Assert.assertEquals(2.5, calc.div(20, 8), 0.001);
	}
}
