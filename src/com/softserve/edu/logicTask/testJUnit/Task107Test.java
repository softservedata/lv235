package com.softserve.edu.logicTask.testJUnit;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import com.softserve.edu.logicTask.task107.Task107;

public class Task107Test {

    
    @Test
    public void test() {

        Task107 task107 = new Task107();
  
        int actual0 = task107.logicTask107(0);
        int expected0 = -1;
        assertEquals(expected0, actual0);
          
        int actual = task107.logicTask107(1);
        int expected = -1;
        assertEquals(expected, actual);
        
        
        int actual2 = task107.logicTask107(2);
        int expected2 = 0;
        assertEquals(expected2, actual2);
        
        
        int actual3 = task107.logicTask107(3);
        int expected3 = 0;
        System.out.println(actual3);
        assertEquals(expected3, actual3);
        
        
        int actual4 = task107.logicTask107(4);
        System.out.println(actual4);
        int expected4 = 0;
        assertEquals(expected4, actual4);
        
        int actual5 = task107.logicTask107(5);
        int expected5 = 1;
        assertEquals(expected5, actual5);

        int actual6 = task107.logicTask107(1070);
        int expected6 = 5;
        assertEquals(expected6, actual6);
    }
}
