package com.softserve.edu.registrator.tests.serch;

import com.softserve.edu.registrator.data.users.IUser;
import com.softserve.edu.registrator.data.users.UserRepository;
import com.softserve.edu.registrator.pages.search.user.ActiveUserPageContent;
import com.softserve.edu.registrator.tests.community.AdminHomePageTestRunner;
import com.softserve.edu.registrator.tools.assertion.FlexAssert;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

/**
 * Test to editing passport information
 *
 * @author Ihor
 * @version 1.2
 */
public class SearchTest extends AdminHomePageTestRunner {
    @DataProvider
    public Object[][] searchData() {
        return new Object[][]{
                {UserRepository.get().testActiveUserSearch(),
                        UserRepository.get().testActiveUserSearchTableData()}
        };
    }

    /**
     * Delay for Thread.Sleep().
     */
    private final int DELAY_FOR_DEMO = 1000;

    /**
     * Test for checking search functional by FirstName and E-mail.
     *
     * @throws Exception - used by Thread.sleep() for DEMO
     */
   @Test(dataProvider = "searchData")
    public void searchByFistNameWithEmailTest(IUser searchFields, IUser data) throws Exception {
        logger.info("Started");
        ActiveUserPageContent page = getAdminHomePage().clickActive();
        page.inputFirstNameData(searchFields.getPerson().getFirstname());
        page.inputEmailData(searchFields.getPerson().getEmail());
        page.clickSearchButton();
        Thread.sleep(DELAY_FOR_DEMO);
        Assert.assertTrue(
                !page.getRefTable().getRowByValueInColumn(
                        page.getTestName(searchFields),
                        page.getRefTable().getColumnIndexByValueOfHeader(page.getColumnNameByName(data))).
                        isEmpty());
        Assert.assertTrue(
                !page.getRefTable().getRowByValueInColumn(
                        page.getEmailTestData(searchFields),
                        page.getRefTable().getColumnIndexByValueOfHeader(page.getColumnNameByEmail(data))).
                        isEmpty());
        setAdminHomePage(page);
        logger.info("Done");
    }

    /**
     * Test for checking search functional by FirstName and Login.
     *
     * @throws Exception - used by Thread.sleep() for DEMO
     */
    @Test(dataProvider = "searchData")
    public void searchByFistNameWithLoginTest(IUser searchField, IUser data) throws Exception {
        logger.info("Started");
        ActiveUserPageContent page = getAdminHomePage().clickActive();
        page.inputFirstNameData(searchField.getPerson().getFirstname());
        page.inputLoginData(searchField.getAccount().getLogin());
        page.clickSearchButton();
        Thread.sleep(DELAY_FOR_DEMO);
        FlexAssert.assertTrue(
                !page.getRefTable().getRowByValueInColumn(
                        page.getTestName(searchField),
                        page.getRefTable().getColumnIndexByValueOfHeader(page.getColumnNameByName(data))).
                        isEmpty());
        FlexAssert.assertTrue(
                !page.getRefTable().getRowByValueInColumn(
                        page.getTestLogin(searchField),
                        page.getRefTable().getColumnIndexByValueOfHeader(page.getColumnNameByLogin(data))).
                        isEmpty());
        setAdminHomePage(page);
        logger.info("Done");
    }

    /**
     * Test for checking search functional by Login and Community.
     *
     * @throws Exception - used by Thread.sleep() for DEMO
     */
  //  @Test(dataProvider = "searchData")
    public void searchLoginWithCommunity(IUser searchField, IUser data) throws Exception {
        logger.info("Started");
        ActiveUserPageContent page = getAdminHomePage().clickActive();
        page.inputLoginData(searchField.getAccount().getLogin());
        page.inputCommunityData(searchField.getAccount().getCommunity());
        page.clickSearchButton();
        Thread.sleep(DELAY_FOR_DEMO);
        Assert.assertTrue(
                !page.getRefTable().getRowByValueInColumn(
                        page.getTestLogin(searchField),
                        page.getRefTable().getColumnIndexByValueOfHeader(page.getColumnNameByLogin(data))).
                        isEmpty());
        Assert.assertTrue(
                !page.getRefTable().getRowByValueInColumn(
                        page.getTestCommunity(searchField),
                        page.getRefTable().getColumnIndexByValueOfHeader(page.getColumnNameByCommunity(data))).
                        isEmpty());
        setAdminHomePage(page);
        logger.info("Done");
    }

    /**
     * Test for checking search functional by E-mail and LastName.
     *
     * @throws Exception - used by Thread.sleep() for DEMO
     */
    @Test(dataProvider = "searchData")
    public void searchEmailWithLastName(IUser searchField, IUser data) throws Exception {
        logger.info("Started");
        ActiveUserPageContent page = getAdminHomePage().clickActive();
        page.inputEmailData(searchField.getPerson().getEmail());
        page.inputLastNameData(searchField.getPerson().getLastname());
        page.clickSearchButton();
        Thread.sleep(DELAY_FOR_DEMO);
        FlexAssert.assertTrue(
               ! page.getRefTable().getRowByValueInColumn(
                        page.getEmailTestData(searchField),
                        page.getRefTable().getColumnIndexByValueOfHeader(page.getColumnNameByEmail(data))).
                        isEmpty());
        Assert.assertTrue(
                !page.getRefTable().getRowByValueInColumn(
                        page.getTestLastName(searchField),
                        page.getRefTable().getColumnIndexByValueOfHeader(page.getColumnByLastName(data))).
                        isEmpty());
        setAdminHomePage(page);
        FlexAssert.assertAll();
        logger.info("Done");
    }

    /**
     * Test for checking search functional by Community and LastName.
     *
     * @throws Exception - used by Thread.sleep() for DEMO
     */
   // @Test(dataProvider = "searchData")
    public void searchCommunityWithLastName(IUser searchField, IUser data) throws Exception {
        logger.info("Started");
        ActiveUserPageContent page = getAdminHomePage().clickActive();
        page.inputCommunityData(searchField.getAccount().getCommunity());
        page.inputLastNameData(searchField.getPerson().getLastname());
        page.clickSearchButton();
        Thread.sleep(DELAY_FOR_DEMO);
        Assert.assertTrue(
                !page.getRefTable().getRowByValueInColumn(
                        page.getTestCommunity(searchField),
                        page.getRefTable().getColumnIndexByValueOfHeader(page.getColumnNameByCommunity(data))).
                        isEmpty());
        Assert.assertTrue(
                !page.getRefTable().getRowByValueInColumn(
                        page.getTestLastName(searchField),
                        page.getRefTable().getColumnIndexByValueOfHeader(page.getColumnByLastName(data))).
                        isEmpty());
        setAdminHomePage(page);
        logger.info("Done");
    }
}
