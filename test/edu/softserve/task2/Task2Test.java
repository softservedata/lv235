package edu.softserve.task2;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static org.junit.Assert.assertEquals;

/**
 * Created by User on 5/3/2017.
 */
public class Task2Test {
    static final Task2 test = new Task2();

    @Test
    public void myResult() {
        List<Integer> list = new ArrayList<>();
        list.add(6);
        list.add(15);
        list.add(24);
        list.add(33);
        list.add(42);
        list.add(51);
        assertEquals(list, test.myResult(60, 36));
    }

    @Test
    public void myResult1() throws Exception {
        //List<Integer> list = new ArrayList<>();
        assertEquals(Collections.emptyList(), test.myResult(45, 26));

    }


}