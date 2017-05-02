package com.softserve.edu.yarych.test;

import java.util.LinkedList;
import java.util.List;

import org.junit.Test;
import org.junit.Assert;

import com.softserve.edu.yarych.Task561;

public class TestTask561 {

    @Test
    public void testCalculate1() {
        Task561 target = new Task561(15);
        List<Integer> expected = new LinkedList<Integer>();
        expected.add(1);
        expected.add(5);
        expected.add(6);
        List<Integer> actual = target.calculate();
        Assert.assertEquals(expected, actual);
    }
    
    @Test
    public void testCalculate2() {
        Task561 target = new Task561(27);
        List<Integer> expected = new LinkedList<Integer>();
        expected.add(1);
        expected.add(5);
        expected.add(6);
        expected.add(25);
        List<Integer> actual = target.calculate();
        Assert.assertNotEquals(expected, actual);
    }

}
