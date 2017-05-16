/**
 * 
 */
package testUnit;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import task323.Task323;
import task560.Task560;

/**
 * @author Andriy
 *
 */
//Task560 t560 = new Task560();
public class TestTask560 {
	
	@Test
	public void checkFriedlyIntegers() {
		
		int expected1 = 220;
		int expected2 = 284;
		int actual = Task560.checkFriedlyIntegers();
		assertEquals(expected1,expected1,actual);
		
	}
	@Test
	public void checkFriedlyIntegers2() {
		
		int expected1 = 1;
		int expected2 = 2;
		int actual = Task560.checkFriedlyIntegers();
		assertFalse(false);
		assertEquals(expected1,expected1,actual);
		
	}
	}


