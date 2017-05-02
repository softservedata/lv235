package com.softserve.edu.yarych.test;

import java.util.LinkedList;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;

import com.softserve.edu.yarych.Task325;

public class TestTask325Test {

    @Test
    public void testCalculate1() {
        Task325 target = new Task325(15);
        List<Integer> expected = new LinkedList<Integer>();
        expected.add(1);
        expected.add(3);
        expected.add(5);
        List<Integer> actual = target.calculate();
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void testCalculate2() {
        Task325 target = new Task325(17);
        List<Integer> expected = new LinkedList<Integer>();
        expected.add(1);
        expected.add(17);
        List<Integer> actual = target.calculate();
        Assert.assertEquals(expected, actual);
    }
}
