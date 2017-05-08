package com.softserve.edu.yarych.test;

import java.util.LinkedList;
import java.util.List;

import org.junit.Test;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;

import com.softserve.edu.yarych.Task325;
import com.softserve.edu.yarych.Task561;

public class TestTask561 {
    private Task561 target;
    private List<Integer> expected;
    @Before
    public void init() {
        target = new Task561();
        expected = new LinkedList<Integer>();
    }
    @After
    public void tearDown() {
        target = null;
    }

    @Test
    public void testCalculate1() {
        expected.add(1);
        expected.add(5);
        expected.add(6);
        List<Integer> actual = target.calculate(15);
        Assert.assertEquals(expected, actual);
    }
    
    @Test
    public void testCalculate2() {
        expected.add(1);
        expected.add(5);
        expected.add(6);
        expected.add(25);
        List<Integer> actual = target.calculate(27);
        Assert.assertEquals(expected, actual);
    }

}
