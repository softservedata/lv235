package com.softserve.edu.logicTask.testJUnit;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Test;

import com.softserve.edu.logicTask.task331AB.Task331B;
import com.softserve.edu.logicTask.task331AB.Triplet;

public class Task331BTest {

    Triplet triplet;

    @Test
    public void test() {
        Task331B task331B = new Task331B();
        ArrayList<Triplet> expected = new ArrayList<Triplet>();
        expected.add(new Triplet(1, 1, 1));
        ArrayList<Triplet> actual = task331B.findAllTiplet(3);
        assertEquals(expected, actual);
    }
    @Test
    public void test2() {
        Task331B task331B = new Task331B();
        ArrayList<Triplet> expected = new ArrayList<Triplet>();
        expected.add(new Triplet(9, 9, 5));
        expected.add(new Triplet(13, 3, 3));

        ArrayList<Triplet> actual = task331B.findAllTiplet(187);
        assertEquals(expected, actual);
    }
    @Test
    public void test4() {
        Task331B task331B = new Task331B();
        ArrayList<Triplet> expected2 = new ArrayList<Triplet>();
        expected2.add(new Triplet(4, 4, 4));
        ArrayList<Triplet> actual2 = task331B.findAllTiplet(48);
        assertEquals(expected2, actual2);
    }
    @Test
    public void test5() {
        Task331B task331B = new Task331B();
        ArrayList<Triplet> actual = task331B.findAllTiplet(7);
        assertFalse(!actual.isEmpty());
    }
    @Test
    public void test6() {
        Task331B task331B = new Task331B();
        ArrayList<Triplet> actual = task331B.findAllTiplet(1);
        assertFalse(!actual.isEmpty());
    }
}
