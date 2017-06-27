package com.softserve.edu.ihor;

import com.softserve.edu.registrator.data.users.UserRepository;
import com.softserve.edu.registrator.pages.AdminHomePage;
import com.softserve.edu.registrator.pages.Application;
import com.softserve.edu.registrator.tests.TestRunner;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.Collections;

/**
 * Created by User on 6/27/2017.
 */
public class TestIhor extends TestRunner {
    @Test
    public void testhr(){
    AdminHomePage adminHomePage = Application.get().load().successAdminLogin(UserRepository.get().admin());
    adminHomePage.clickActive();
    
    }

}
