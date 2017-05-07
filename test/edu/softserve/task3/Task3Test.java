package edu.softserve.task3;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

import static org.junit.Assert.assertEquals;

/**
 * @author Ihor
 */
public class Task3Test {
    @Test
    public void task562() {
        List<Integer> list = new ArrayList<>();
        Task3 test = new Task3();
        list.addAll(Arrays.asList(153,370,371,407,1634,8208,9474));
        assertEquals(list, test.task562());
    }
}
