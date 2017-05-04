package Tests;

import org.junit.Assert;
import org.junit.Test;

import Task1.Task1;
import Task2.Task2;

public class RunTests {

		@Test
		public void testTask11()
		{
			int expected = 5;
			Task1 task1 = new Task1();
			int actual = task1.findDigits(50000);
	        Assert.assertEquals(expected, actual);
		}

		@Test
		public void testTask12()
		{
			int expected = 1;
			Task1 task1 = new Task1();
			int actual = task1.findDigits(0);
	        Assert.assertEquals(expected, actual);
		}

		@Test
		public void testTask13()
		{
			int expected = 1;
			Task1 task1 = new Task1();
			int actual = task1.findDigits(1);
	        Assert.assertEquals(expected, actual);
		}

		@Test
		public void testTask14()
		{
			int expected = 10;
			Task1 task1 = new Task1();
			int actual = task1.findDigits(1234567890);
	        Assert.assertEquals(expected, actual);
		}



		@Test
		public void testTask21()
		{
			int[] expected = {120, 100, 16, 4, 0 };
			Task2 task2 = new Task2();
			int[] actual = task2.findMatch(120);
	        Assert.assertArrayEquals(expected, actual);
		}

		@Test
		public void testTask22()
		{
			int[] expected = {0, 0, 0, 0, 0 };
			Task2 task2 = new Task2();
			int[] actual = task2.findMatch(0);
	        Assert.assertArrayEquals(expected, actual);
		}

		@Test
		public void testTask23()
		{
			int[] expected = {100, 100, 0, 0, 0 };
			Task2 task2 = new Task2();
			int[] actual = task2.findMatch(100);
	        Assert.assertArrayEquals(expected, actual);
		}

		@Test
		public void testTask24()
		{
			int[] expected = {7, 4, 1, 1, 1 };
			Task2 task2 = new Task2();
			int[] actual = task2.findMatch(7);
	        Assert.assertArrayEquals(expected, actual);
		}


}
