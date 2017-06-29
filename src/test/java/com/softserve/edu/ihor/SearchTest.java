package com.softserve.edu.ihor;

import com.softserve.edu.registrator.tests.community.AdminHomePageTestRunner;
import org.testng.Assert;
import org.testng.annotations.Test;

/**
 * Test to editing passport information
 *@version 1.2
 *@author Ihor
 *
 */
public class SearchTest extends AdminHomePageTestRunner {
    /**
     * Delay for Thread.Sleep().
     */
    private final int DELAY_FOR_DEMO = 1000;

    /**
     * Test for checking search functional by FirstName and E-mail.
     * @throws Exception - used by Thread.sleep() for DEMO
     */
    @Test
    public void searchByFistNameWithEmailTest() throws Exception {
        ActiveCoownersPage page = getAdminHomePage().clickActive();
        page.inputInFirstNameField("ihor");
        page.inputInEmailField("IvaTest@gmail.com");
        page.clickSearchButton();
        Thread.sleep(DELAY_FOR_DEMO);
        Assert.assertTrue(
                !page.getRefTable().getRowByValueInColumn(
                        "ihor",
                        page.getRefTable().getColumnIndexByValueOfHeader("Ім'я")).
                        isEmpty());
        Assert.assertTrue(
                !page.getRefTable().getRowByValueInColumn(
                        "IvaTest@gmail.com",
                        page.getRefTable().getColumnIndexByValueOfHeader("Електронна пошта")).
                        isEmpty());
        setCommunityPage(page);
    }

    /**
     * Test for checking search functional by FirstName and Login.
     * @throws Exception - used by Thread.sleep() for DEMO
     */
    @Test
    public void searchByFistNameWithLoginTest() throws Exception {
       ActiveCoownersPage page = getAdminHomePage().clickActive();
        page.inputInFirstNameField("ihor");
        page.inputInLoginField("adminIhor");
        page.clickSearchButton();
        Thread.sleep(DELAY_FOR_DEMO);
        Assert.assertTrue(
                !page.getRefTable().getRowByValueInColumn(
                        "ihor",
                        page.getRefTable().getColumnIndexByValueOfHeader("Ім'я")).
                        isEmpty());
        Assert.assertTrue(
                !page.getRefTable().getRowByValueInColumn(
                        "adminIhor",
                        page.getRefTable().getColumnIndexByValueOfHeader("Логін")).
                        isEmpty());
        setCommunityPage(page);
    }

    /**
     * Test for checking search functional by Login and Community.
     * @throws Exception - used by Thread.sleep() for DEMO
     */
    @Test
    public void searchLoginWithCommunity() throws Exception {
        ActiveCoownersPage page = getAdminHomePage().clickActive();
        page.inputInLoginField("adminIhor");
        page.inputInCommunityField("Львівська");
        page.clickSearchButton();
        Thread.sleep(DELAY_FOR_DEMO);
        Assert.assertTrue(
                !page.getRefTable().getRowByValueInColumn(
                        "adminIhor",
                        page.getRefTable().getColumnIndexByValueOfHeader("Логін")).
                        isEmpty());
        Assert.assertTrue(
                !page.getRefTable().getRowByValueInColumn(
                        "Львівська",
                        page.getRefTable().getColumnIndexByValueOfHeader("Територіальна громада")).
                        isEmpty());
        setCommunityPage(page);
    }

    /**
     * Test for checking search functional by E-mail and LastName.
     * @throws Exception - used by Thread.sleep() for DEMO
     */
    @Test
    public void searchEmailWithLastName() throws Exception {
        ActiveCoownersPage page = getAdminHomePage().clickActive();
        page.inputInEmailField("IvaTest@gmail.com");
        page.inputInLastNameField("IvaTestSurname");
        page.clickSearchButton();
        Thread.sleep(DELAY_FOR_DEMO);
        Assert.assertTrue(
                !page.getRefTable().getRowByValueInColumn(
                        "IvaTest@gmail.com",
                        page.getRefTable().getColumnIndexByValueOfHeader("Електронна пошта")).
                        isEmpty());
        Assert.assertTrue(
                !page.getRefTable().getRowByValueInColumn(
                        "IvaTestSurname",
                        page.getRefTable().getColumnIndexByValueOfHeader("Прізвище")).
                        isEmpty());
        setCommunityPage(page);
    }

    /**
     * Test for checking search functional by Community and LastName.
     * @throws Exception - used by Thread.sleep() for DEMO
     */
    @Test
    public void searchCommunityWithLastname() throws Exception {
        ActiveCoownersPage page = getAdminHomePage().clickActive();
        page.inputInCommunityField("Львівська");
        page.inputInLastNameField("IvaTestSurname");
        page.clickSearchButton();
        Thread.sleep(DELAY_FOR_DEMO);
        Assert.assertTrue(
                !page.getRefTable().getRowByValueInColumn(
                        "Львівська",
                        page.getRefTable().getColumnIndexByValueOfHeader("Територіальна громада")).
                        isEmpty());
        Assert.assertTrue(
                !page.getRefTable().getRowByValueInColumn(
                        "IvaTestSurname",
                        page.getRefTable().getColumnIndexByValueOfHeader("Прізвище")).
                        isEmpty());
        setCommunityPage(page);
    }

}
