package com.softserve.edu.registrator.data;

public class Appl {
    public static void main(String[] args) {
        // 1 Create by full Constructor
        //User user = new User("aa", "bb", "cc", "dd", "ee");
        // 2 Create by default Constructor and setters
//        User user = new User();
//        user.setLogin("aa");
//        user.setPassword("bb");
//        user.setFirstname("cc");
//        user.setLastname("dd");
//        user.setEmail("ee");
        // 3 Create by default Constructor and fluent interface
//        User user = new User()
//                .setLogin("aa")
//                .setPassword("bb")
//                //.setFirstname("cc")
//                .setLastname("dd")
//                .setEmail("ee");
        // 4 Create by static factory and fluent interface
//        User user = User.get()
//                .setLogin("aa")
//                .setPassword("bb")
//                //.setFirstname("cc")
//                .setLastname("dd")
//                .setEmail("ee");
        // 5 Create by Builder
        User user = User.get()
                .setLogin("aa")
                .setPassword("bb")
                .setFirstname("ccc")
                .setLastname("dd")
                .build();
        //
        System.out.println("user.firstname = " + user.getFirstname());
    }
}
