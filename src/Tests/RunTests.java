package Tests;

import org.junit.Assert;
import org.junit.Test;

import Task1.Task1;

public class RunTests {

		@Test
		public void test1()
		{
			int expected = 5;
			Task1 task1 = new Task1();
			int actual = task1.findDigits(50000);
	        Assert.assertEquals(expected, actual);
		}

		@Test
		public void test2()
		{
			int expected = 1;
			Task1 task1 = new Task1();
			int actual = task1.findDigits(0);
	        Assert.assertEquals(expected, actual);
		}

		@Test
		public void test3()
		{
			int expected = 1;
			Task1 task1 = new Task1();
			int actual = task1.findDigits(1);
	        Assert.assertEquals(expected, actual);
		}

		@Test
		public void test4()
		{
			int expected = 10;
			Task1 task1 = new Task1();
			int actual = task1.findDigits(1234567890);
	        Assert.assertEquals(expected, actual);
		}
}
