package edu.softserve.task1;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

/**
 * Created by User on 4/30/2017.
 */
public class Task1Test {

    @Test
    public void myResult() {
        Task1 test=new Task1();
        List<Integer> list = new ArrayList<>();
        list.add(2);
        list.add(5);
        list.add(10);
        assertEquals(list, test.myResult(100));
    }

}