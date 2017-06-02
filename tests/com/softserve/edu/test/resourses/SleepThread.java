package com.softserve.edu.test.resourses;

public class SleepThread {
    
    private SleepThread() {}
    
    public static void sleep(int countOfSecond) {
        try {
            Thread.sleep(countOfSecond*1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
