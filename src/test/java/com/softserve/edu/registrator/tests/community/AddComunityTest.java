package com.softserve.edu.registrator.tests.community;

import org.testng.annotations.Test;

import com.softserve.edu.registrator.data.communities.Community;
import com.softserve.edu.registrator.data.communities.ICommunity;
import com.softserve.edu.registrator.data.users.UserRepository;
import com.softserve.edu.registrator.pages.AdminHomePage;
import com.softserve.edu.registrator.pages.Application;
import com.softserve.edu.registrator.pages.communities.AddCommunityPage;
import com.softserve.edu.registrator.pages.communities.CommunityPage;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
  
	public class AddComunityTest {

	    /**
	     * object Home Page for Administrator.
	     */
		AdminHomePage adminHomePage;

		@BeforeClass
	    public void beforeClass() {
	    	adminHomePage = Application.get().load().successAdminLogin(UserRepository.get().admin());
	    }
	
	    @AfterClass
	    public void afterClass() {
	    	Application.get().getBrowser().quit();
	    }

		@DataProvider 
		public Object[][] communityValid() {
			return new Object[][] {
				 {new Community("Mykolaiv", "")},
				 {new Community("Kyiv", "120:00:94:860:35001")}
			};
		}
		
	    /**
	     * Test to create new community with valid data.
	     */
		//@Test(dataProvider = "communityValid")
	    public void createComunityWithValidData(ICommunity community) {
	        CommunityPage communityPage = adminHomePage
	        	.clickCommunities()
	        	.addNewCommunity()
	        	.seccesfulAddedCommunity(community);
	        Assert.assertTrue(communityPage.getCountOfCommunities(community) == 1);
	        communityPage.deleteCommunity(community).ok();
	        adminHomePage = communityPage;
		}

		
		@DataProvider 
		public Object[][] communityEmpty() {
			return new Object[][] {
				 {new Community("", "1465"), "Заповніть це поле."}
			};
		}
		
	    /**
	     * Test to create new community with empty data.
	     */
		//@Test(dataProvider = "communityEmpty")
	    public void createComunityWithEmptyName(ICommunity community, String messageText) {
	        AddCommunityPage addCommunityPage = adminHomePage
	        	.clickCommunities()
	        	.addNewCommunity();
	        addCommunityPage.setCommunityData(community);
	        addCommunityPage.clickSaveButton();
	        Assert.assertEquals(addCommunityPage.getValidationMessageText(
	        		addCommunityPage.getActiveElement()), messageText);
	        adminHomePage = addCommunityPage;
		}

		
		@DataProvider 
		public Object[][] invalidName() {
			return new Object[][] {
				 { new Community("./$%", "") }
			};
		}
		
	    /**
	     * Test to create new community with valid name and
	     * invalid number community.
	     */
	    //@Test(dataProvider = "invalidName")
	    public void createComunityWithInvalidName(ICommunity community) {
	    	AddCommunityPage addCommunityPage = adminHomePage
		        	.clickCommunities()
		        	.addNewCommunity();
	    	addCommunityPage.setCommunityData(community);
	        addCommunityPage.clickSaveButton();
	        if(addCommunityPage.getErrorLables().isEmpty()) {
	        	Assert.fail();
	        }
	    }

	    
		@DataProvider 
		public Object[][] invalidRegisterNumber() {
			return new Object[][] {
				 { new Community("Odessa", "124"), "Невірний формат" }
			};
		}
		
	    /**
	     * Test to create new community with invalid number community.
	     */
	    @Test(dataProvider = "invalidRegisterNumber")
	    public void createComunityWithInvalidNumber(ICommunity community, String errorText) {
	    	AddCommunityPage addCommunityPage = adminHomePage
		        	.clickCommunities()
		        	.addNewCommunity();
	    	addCommunityPage.setCommunityData(community);
	        addCommunityPage.clickSaveButton();
	        if(addCommunityPage.getErrorLables().isEmpty()) {
	        	Assert.assertEquals(addCommunityPage.getRegistrationNumberErrorLabelText(), errorText);
	        }
	    }

//	    /**
//	     * Test to create new community with used name and empty number community.
//	     */
//	    @Test
//	    public void createComunityWithUsedNameEmptyNumber() {
//	        String name = "Lviv";
//	        String number = "";
//	        File screenShot = addComunity(name, number);
//	        if (!isPresentErrorLabel("Підклас з вказаним іменем вже існує")) {
//	            String nameFolder = "TestUsedNameEmptyNumber";
//	            FileHelper.saveBugAttachments(
//	                    folderName + "/" + nameFolder, screenShot, driver);
//	            Assert.fail();
//	        }
//	        SleepThread.sleep(1); // mus be deleted
//	    }
//
//	    /**
//	     * Test to create new community with valid name and
//	     * invalid number community.
//	     */
//	    @Test
//	    public void createComunityWithUsedNameInvalidNumber() {
//	        String name = "Lviv";
//	        String number = "123";
//	        File screenShot = addComunity(name, number);
//	        if (!isPresentErrorLabel("Підклас з вказаним іменем вже існує")
//	                || !isPresentErrorLabel("Невірний формат")) {
//	            String nameFolder = "TestUsedNameInvalidNumber";
//	            FileHelper.saveBugAttachments(
//	                    folderName + "/" + nameFolder, screenShot, driver);
//	            Assert.fail();
//	        }
//	        SleepThread.sleep(1); // mus be deleted
//	    }
//
//	    /**
//	     * Test to create new community with used name and used number community.
//	     */
//	    @Test
//	    public void createComunityWithUsedNameUsedNumber() {
//	        String name = "Lviv";
//	        String number = "000:25:09:376:40009";
//	        File screenShot = addComunity(name, number);
//	        if (driver.findElements(By.cssSelector("#body span")).size() != 2) {
//	            String nameFolder = "TestUsedNumberUsedNumber";
//	            FileHelper.saveBugAttachments(
//	                    folderName + "/" + nameFolder, screenShot, driver);
//	            Assert.fail();
//	        }
//	        SleepThread.sleep(1); // mus be deleted
//	    }
//
//	    /**
//	     * Test to create new community with empty name.
//	     */
//	    @Test
//	    public void createComunityWithEmptyName() {
//	        String name = "";
//	        String number = "123";
//	        File screenShot = addComunity(name, number);
//	        if (!driver.switchTo().activeElement().getAttribute("validationMessage")
//	                .equals("Заповніть це поле.")) {
//	            FileHelper.saveBugAttachments(
//	                    folderName + "/TestEmptyName", screenShot, driver);
//	            DeletingComunity.getDeletingComunity(driver)
//	                    .deleteComunityIfExistOk(name);
//	            Assert.fail();
//	        }
//	        SleepThread.sleep(1); // mus be deleted
//	    }
//
//	    /**
//	     * Test to create new community with invalid name and
//	     * empty number community.
//	     */
//	    @Test
//	    public void createComunityWithInvalidNameEmptyNumber() {
//	        String name = "/.";
//	        String number = "";
//	        File screenShot = addComunity(name, number);
//	        if (driver.findElements(By.cssSelector("#body span")).size() != 1) {
//	            String nameFolder = "TestInvalidNameEmptyNumber";
//	            FileHelper.saveBugAttachments(
//	                    folderName + "/" + nameFolder, screenShot, driver);
//	            DeletingComunity.getDeletingComunity(driver)
//	                    .deleteComunityIfExistOk(name);
//	            Assert.fail();
//	        }
//	        SleepThread.sleep(1); // mus be deleted
//	    }
//
//	    /**
//	     * Test to create new community with invalid name and
//	     * invalid number community.
//	     */
//	    @Test
//	    public void createComunityWithInvalidNameInvalidNumber() {
//	        String name = "/.";
//	        String number = "123";
//	        File screenShot = addComunity(name, number);
//	        if (driver.findElements(By.cssSelector("#body span")).size() != 2) {
//	            String nameFolder = "TestInvalidNameInvalidNumber";
//	            FileHelper.saveBugAttachments(
//	                    folderName + "/" + nameFolder, screenShot, driver);
//	            DeletingComunity.getDeletingComunity(driver)
//	                    .deleteComunityIfExistOk(name);
//	            Assert.fail();
//	        }
//	        SleepThread.sleep(1); // mus be deleted
//	    }
//
//	    /**
//	     * Test to create new community with invalid name and used number community.
//	     */
//	    @Test
//	    public void createComunityWithInvalidNameUsedNumber() {
//	        String name = "#4/^";
//	        String number = "123:54:67:123:98734";
//	        File screenShot = addComunity(name, number);
//	        if (driver.findElements(By.cssSelector("#body span")).size() != 1) {
//	            String nameFolder = "TestInvalidNameUsedNamber";
//	            FileHelper.saveBugAttachments(
//	                    folderName + "/" + nameFolder, screenShot, driver);
//	            DeletingComunity.getDeletingComunity(driver)
//	                    .deleteComunityIfExistOk(name);
//	            Assert.fail();
//	        }
//	        SleepThread.sleep(1); // mus be deleted
//	    }
//
//	    /**
//	     * Test verify if field is empty by defult.
//	     */
//	    @Test
//	    public void isEmptyFiledByDefault() {
//	        driver.findElement(
//	                By.xpath("//a[contains(@href,'/show-all-communities')]"))
//	                .click();
//	        File screenShot = ((TakesScreenshot) driver)
//	                .getScreenshotAs(OutputType.FILE);
//	        driver.findElement(By.cssSelector("a[href= 'addCommunity']")).click();
//	        SleepThread.sleep(1); // mus be deleted
//	        if (!driver.findElement(By.name("name")).getText().equals("")
//	                && !driver.findElement(
//	                        By.name("registrationNumber")).getText().equals("")) {
//	            String nameFolder = "TestEmptyFiledByDefault";
//	            FileHelper.saveBugAttachments(
//	                    folderName + "/" + nameFolder, screenShot, driver);
//	            Assert.fail();
//	        }
//	        SleepThread.sleep(1); // mus be deleted
//	    }
//
//	    /**
//	     * Test verify if field is empty after clik butoon cancel.
//	     */
//	    @Test
//	    public void isEmptyFiledAfterCancel() {
//	        driver.findElement(
//	                By.xpath("//a[contains(@href,'/show-all-communities')]"))
//	                .click();
//	        driver.findElement(By.cssSelector("a[href= 'addCommunity']")).click();
//	        File screenShot = ((TakesScreenshot) driver)
//	                .getScreenshotAs(OutputType.FILE);
//	        driver.findElement(By.name("name")).sendKeys("Harkiv");
//	        driver.findElement(By.name("registrationNumber"))
//	                .sendKeys("111:22:55:666:99999");
//	        driver.findElement(By.cssSelector("button[type='reset']")).click();
//	        SleepThread.sleep(2); // mus be deleted
//	        if (!driver.findElement(By.name("name")).getText().equals("")
//	                && !driver.findElement(
//	                        By.name("registrationNumber")).getText().equals("")) {
//	            String nameFolder = "TestEmptyFiledAfterClear";
//	            FileHelper.saveBugAttachments(
//	                    folderName + "/" + nameFolder, screenShot, driver);
//	            Assert.fail();
//	        }
//	        SleepThread.sleep(1); // mus be deleted
//	    }

//	    /**
//	     * Method adding comunity.
//	     * @param name Community name.
//	     * @param number Community number.
//	     * @return screenShot.
//	     */
//	    public File addComunity(final String name, final String number) {
//	        WebDriverWait wait = new WebDriverWait(driver, TIME_FOR_WAIT);
//	        wait.until(ExpectedConditions.elementToBeClickable(driver
//	                .findElement(By.xpath(
//	                     "//a[contains(@href,'/show-all-communities')]"))));
//	        SleepThread.sleep(1); // mus be deleted
//	        driver.findElement(
//	                By.xpath("//a[contains(@href,'/show-all-communities')]"))
//	                .click();
//	        driver.findElement(By.cssSelector("a[href= 'addCommunity']")).click();
//	        SleepThread.sleep(1); // mus be deleted
//	        driver.findElement(By.name("name")).click();
//	        driver.findElement(By.name("name")).clear();
//	        driver.findElement(By.name("name")).sendKeys(name);
//	        driver.findElement(By.name("registrationNumber")).click();
//	        driver.findElement(By.name("registrationNumber")).clear();
//	        driver.findElement(By.name("registrationNumber")).sendKeys(number);
//	        SleepThread.sleep(1); // mus be deleted
//	        File viewBeforeTestExecute = ((TakesScreenshot) driver)
//	                .getScreenshotAs(OutputType.FILE);
//	        driver.findElement(By.cssSelector("input[type = 'submit']")).click();
//	        SleepThread.sleep(1); // mus be deleted
//	        return viewBeforeTestExecute;
//	    }
//

//
//	    /**
//	     * Verify if community presented in list.
//	     * @param name Community name.
//	     * @return result.
//	     */
//	    public boolean isPresentComunity(final String name) {
//	        return driver.findElements(
//	                By.xpath("//td/a[text() = '" + name + "']")).size() > 0;
    }

