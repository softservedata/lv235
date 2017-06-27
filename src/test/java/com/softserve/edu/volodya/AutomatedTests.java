package com.softserve.edu.volodya;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.softserve.edu.registrator.data.users.UserRepository;
import com.softserve.edu.registrator.pages.Application;

public class AutomatedTests {

	/**
	 * Delay for Thread.Sleep().
	 */
	private final int DELAY_FOR_DEMO = 300;

	RegistratorHomePage registratorHomePage;
	
	 @BeforeClass
	    public void beforeClass() {
	    	registratorHomePage = Application.get().load()
	    			.successRegistratorLogin(UserRepository.get().registrator());
	    }
	
	 @AfterClass
	    public void afterClass() {
	    	Application.get().getBrowser().quit();
	    }
	 
	@DataProvider
	public Object[][] subclass() {
		return new Object[][] {
				{ new Subclass("TestName", "TestDescription", "points") },
				}; 
	}

	/**
	 * This test CREATE a new subclass.
	 * Thread.sleep() Use only for DEMO!
	 * @throws Exception - use for Thread.Sleep().
	 */
	@Test (dataProvider = "subclass")
	public void testCreateSubclass(ISubclass subclass) throws Exception {
		AddSubclassPage addSubclassPage = registratorHomePage
				.clickSubclassObjects().clickAddSubclassButton();
		Thread.sleep(DELAY_FOR_DEMO);
		addSubclassPage.FillSubclassName(subclass);
		Thread.sleep(DELAY_FOR_DEMO);
		addSubclassPage.clickAddParametersButton();
		Thread.sleep(DELAY_FOR_DEMO);
		addSubclassPage.FillDescriptionParameter(subclass);
		Thread.sleep(DELAY_FOR_DEMO);
		addSubclassPage.FillUnitParameter(subclass);
		Thread.sleep(DELAY_FOR_DEMO);
		addSubclassPage.clickDiscreteParameter();
		addSubclassPage.clickAddButton();
		Thread.sleep(DELAY_FOR_DEMO);
		addSubclassPage.FillDescriptionParameter2("Test_Description2");
		Thread.sleep(DELAY_FOR_DEMO);
		addSubclassPage.FillUnitParameter2("count");
		Thread.sleep(DELAY_FOR_DEMO);
		addSubclassPage.clickLinearParameter();
		addSubclassPage.clickSaveButton();
		Thread.sleep(DELAY_FOR_DEMO);
		Assert.assertNotNull(addSubclassPage.FindSubclassName(subclass));
		Thread.sleep(DELAY_FOR_DEMO);
	}
	
	/**
	 * This test DELETE a new subclass.
	 * Thread.sleep() Use only for DEMO!
	 * @throws Exception - use for Thread.Sleep().
	 */
	@Test (dataProvider = "subclass")
	public void testDeleteSubclass(ISubclass subclass) throws Exception {
		SubclassPage subclassPage = registratorHomePage.clickSubclassObjects();
		Thread.sleep(DELAY_FOR_DEMO);
		Assert.assertNotNull(subclassPage.FindSubclassName(subclass));
		subclassPage.clickDeleteCurrentSubclass(subclass);
		Thread.sleep(DELAY_FOR_DEMO);
		subclassPage.clickOkButton();
		Assert.assertTrue(subclassPage.CheckSubclassName(subclass).size() == 0);
	}

	/**
	 * Test to add resource and search it
	 * Thread.sleep() Use only for DEMO!
	 * @throws Exception - use for Thread.Sleep().
	 */
	@Test (dataProvider = "subclass")
	public void testAddResource(ISubclass subclass) throws Exception {
		AddResourcePage addResourcePage = registratorHomePage.clickAddNewResource();
		Thread.sleep(DELAY_FOR_DEMO);
		addResourcePage.fillOwnerField("NazarUser");
		Thread.sleep(DELAY_FOR_DEMO);
		addResourcePage.fillObjectName("Тестовий");  // Only Ukrainian allowed
		Thread.sleep(DELAY_FOR_DEMO);
		addResourcePage.clickResourceByName("TestName");
		addResourcePage.clickProcurations();
		Thread.sleep(DELAY_FOR_DEMO);
		addResourcePage.clickPointsButton();
		Thread.sleep(DELAY_FOR_DEMO);
		addResourcePage.fillPoints();
		Thread.sleep(DELAY_FOR_DEMO);
		addResourcePage.clickPerimeterArea();
		Thread.sleep(DELAY_FOR_DEMO);
		addResourcePage.fillDiscreteValue("1000");
		Thread.sleep(DELAY_FOR_DEMO);
		addResourcePage.fillDiscreteComment("Hello, World!");
		Thread.sleep(DELAY_FOR_DEMO);
		addResourcePage.fillLinearValue("2000");
		Thread.sleep(DELAY_FOR_DEMO);
		addResourcePage.fillLinearComment("Second Great comment!");
		Thread.sleep(DELAY_FOR_DEMO);
		addResourcePage.clickMapButton();
		Thread.sleep(DELAY_FOR_DEMO);
		addResourcePage.clickAllUkraineCheckbox();
		Thread.sleep(DELAY_FOR_DEMO);
		addResourcePage.clickSaveButton();
		Thread.sleep(DELAY_FOR_DEMO);
		SearchResourcesPage searchResourcesPage = registratorHomePage.clickSearchResources();
		Thread.sleep(DELAY_FOR_DEMO);
		searchResourcesPage.clickSearchByParameterButton();
		Thread.sleep(DELAY_FOR_DEMO);
		searchResourcesPage.clickResourceTypeSelect();
		Thread.sleep(DELAY_FOR_DEMO);
		searchResourcesPage.clickResourceByName(subclass);
		Thread.sleep(DELAY_FOR_DEMO);
		searchResourcesPage.fillDiscreteParameter("1000");
		Thread.sleep(DELAY_FOR_DEMO);
		searchResourcesPage.fillLinearParameter("2000");
		Thread.sleep(DELAY_FOR_DEMO);
		Assert.assertNotNull(By.linkText("Тестовий"));
	}


}