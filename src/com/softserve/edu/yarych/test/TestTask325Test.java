package com.softserve.edu.yarych.test;

import java.util.LinkedList;
import java.util.List;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import com.softserve.edu.yarych.Task224;
import com.softserve.edu.yarych.Task325;

public class TestTask325Test {
    private Task325 target;
    private List<Integer> expected;
    @Before
    public void init() {
        target = new Task325();
        expected = new LinkedList<Integer>();
    }
    @After
    public void tearDown() {
        target = null;
    }
  
    @Test
    public void testCalculate1() {
        List<Integer> actual = target.calculate(0);
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void testCalculate2() {
        expected.add(1);
        expected.add(17);
        List<Integer> actual = target.calculate(17);
        Assert.assertEquals(expected, actual);
    }
    
    @Test
    public void testCalculate3() {
        expected.add(1);
        expected.add(3);
        expected.add(11);
        List<Integer> actual = target.calculate(99);
        Assert.assertEquals(expected, actual);
    }
}
