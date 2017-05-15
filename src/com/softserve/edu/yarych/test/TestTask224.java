package com.softserve.edu.yarych.test;

import java.util.LinkedList;
import java.util.List;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import com.softserve.edu.yarych.NonNaturalNumberException;
import com.softserve.edu.yarych.Task224;

public class TestTask224 {
    private Task224 target;
    private List<Integer> expected;
    @Before
    public void init() {
        target = new Task224();
        expected = new LinkedList<Integer>();
    }
    @After
    public void tearDown() {
        target = null;
    }
    
    @Test
    public void testCalculate1() {
        expected.add(1);
        expected.add(3);
        expected.add(9);
        List<Integer> actual = target.calculate(9);
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void testCalculate2() {
        expected = new LinkedList<Integer>();
        expected.add(1);
        expected.add(7);
        expected.add(11);
        expected.add(77);
        List<Integer> actual = target.calculate(77);
        Assert.assertEquals(expected, actual);
    }
    
    @Test
    public void testCalculate3() {
        List<Integer> actual = target.calculate(0);
        Assert.assertEquals(expected, actual);
    }
}
