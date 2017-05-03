package com.softserve.edu.logicTask.testJUnit;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Collection;

import org.junit.Test;

import com.softserve.edu.logicTask.task331AB.Task331A;
import com.softserve.edu.logicTask.task331AB.Triplet;

public class Task331ATest {

    Triplet triplet;

    @Test
    public void test() {

        Task331A task331A = new Task331A();
        
        ArrayList<Triplet> expected = new ArrayList<Triplet>();
        expected.add(new Triplet(1, 1, 1));
        ArrayList<Triplet> actual = task331A.findTiplet(3);
        assertEquals(expected, actual);

        ArrayList<Triplet> expected2 = new ArrayList<Triplet>();
        expected2.add(new Triplet(2, 2, 2));
        ArrayList<Triplet> actual2 = task331A.findTiplet(12);
        assertEquals(expected2, actual2);

        ArrayList<Triplet> actual3 = task331A.findTiplet(7);
        assertTrue(actual3.isEmpty());

        ArrayList<Triplet> actual4 = task331A.findTiplet(1);
        assertTrue(actual4.isEmpty());
    }

}
