package com.softserve.edu.yarych.test;

import java.util.LinkedList;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;

import com.softserve.edu.yarych.Task224;

public class TestTask224 {
    
    @Test
    public void testCalculate1() {
        Task224 target = new Task224(9);
        List<Integer> expected = new LinkedList<Integer>();
        expected.add(1);
        expected.add(3);
        expected.add(9);
        List<Integer> actual = target.calculate();
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void testCalculate2() {
        Task224 target = new Task224(77);
        List<Integer> expected = new LinkedList<Integer>();
        expected.add(1);
        expected.add(7);
        expected.add(11);
        expected.add(77);
        List<Integer> actual = target.calculate();
        Assert.assertEquals(expected, actual);
    }
    
    @Test
    public void testCalculate3() {
        Task224 target = new Task224(-1);
        List<Integer> expected = new LinkedList<Integer>();
        List<Integer> actual = target.calculate();
        Assert.assertNotEquals(expected, actual);
    }
}
