package com.softserve.edu.logicTask.testJUnit;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Test;

import com.softserve.edu.logicTask.task243A.Couple;
import com.softserve.edu.logicTask.task243A.Task243A;

public class Task243ATest {

    @Test
    public void test() {
        Task243A task243A = new Task243A();
        ArrayList<Couple> actual = task243A.findCouple(2);
        ArrayList<Couple> expected = new ArrayList<>();
        expected.add(new Couple(1, 1));
        assertEquals(expected, actual);
    }
    @Test
    public void test2() {
        Task243A task243A = new Task243A();
        ArrayList<Couple> actual2 = task243A.findCouple(17);
        ArrayList<Couple> expected2 = new ArrayList<>();
        expected2.add(new Couple(4, 1));
        assertEquals(expected2, actual2);
    }
    @Test
    public void test3() {
        Task243A task243A = new Task243A();
        ArrayList<Couple> actual = task243A.findCouple(-1);
        assertFalse(!actual.isEmpty());
    }
    @Test
    public void test4() {
        Task243A task243A = new Task243A();
        ArrayList<Couple> actual = task243A.findCouple(1);
        assertFalse(!actual.isEmpty());
    }
}
