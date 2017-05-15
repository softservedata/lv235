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
        expected = target.calculate(16);
        List<Integer> actual = target.calculate(15);
        Assert.assertEquals(expected, actual);
    }
    
    @Test
    public void testCalculate2() {
        expected.add(1);
        expected.add(5);
        expected.add(6);
        expected.add(25);
        expected.add(76);
        expected.add(376);
        expected.add(625);
        expected.add(9376);
        expected.add(83647);
        expected.add(483647);
        expected.add(7483647);
        expected.add(47483647);
        expected.add(147483647);
        List<Integer> actual = target.calculate(1000000000);
        Assert.assertEquals(expected, actual);
    }
    
    @Test 
    public void testCalculate3() {
        List<Integer> actual = target.calculate(0);
        Assert.assertEquals(expected, actual);

    }

}
