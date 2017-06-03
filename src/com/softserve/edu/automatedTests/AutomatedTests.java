package com.softserve.edu.automatedTests;

import java.util.concurrent.TimeUnit;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class AutomatedTests {

	/**
	 * Delay for Thread.Sleep().
	 */
	private final int DELAY_FOR_DEMO = 1000;

	/**
	 * This method initialize driver with settings.
	 * @return driver.
	 * @throws Exception - use for Thread.Sleep().
	 */
	private WebDriver init() throws Exception {
		System.setProperty("webdriver.chrome.driver", "./lib/chromedriver.exe");
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--start-maximized");
		options.addArguments("--no-proxy-server");
		WebDriver driver = new ChromeDriver(options);
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		driver.get("http://java.training.local:8080/registrator");
		Thread.sleep(DELAY_FOR_DEMO);
		return driver;
	}

	/**
	 * Thread.sleep() Use only for DEMO!
	 * This method login user to account.
	 * @param user - user name.
	 * @param password - user password.
	 * @param driver - driver.
	 * @throws Exception - use for Thread.Sleep().
	 */
	private void login(String user, String password, WebDriver driver) throws Exception {
		LoginPage loginPage = new LoginPage(driver);
		loginPage.getLoginField().clear();
		loginPage.getLoginField().click();
		loginPage.getLoginField().sendKeys(user);
		Thread.sleep(DELAY_FOR_DEMO);
		loginPage.getLoginPassword().clear();
		loginPage.getLoginPassword().click();
		loginPage.getLoginPassword().sendKeys(password);
		Thread.sleep(DELAY_FOR_DEMO);
		loginPage.getLoginButton().click();
		Thread.sleep(DELAY_FOR_DEMO);
	}

	/**
	 * This method logout current user.
	 * @param driver - driver.
	 * @throws Exception - use for Thread.Sleep().
	 */
	private void logout(WebDriver driver) throws Exception {
		driver.findElement(By.cssSelector(".btn.btn-primary.btn-sm.dropdown-toggle")).click();
		Thread.sleep(DELAY_FOR_DEMO);
		driver.findElement(By.xpath("//a[contains(@href,'/logout')]")).click();
		Thread.sleep(DELAY_FOR_DEMO);
		driver.findElement(By.cssSelector("img")).getAttribute("src").contains("/ukraine_logo2.gif");
		Thread.sleep(DELAY_FOR_DEMO);
		driver.quit();
	}

	/**
	 * This test CREATE a new subclass.
	 * Thread.sleep() Use only for DEMO!
	 * @throws Exception - use for Thread.Sleep().
	 */
	//@Test
	public void testCreateSubclass() throws Exception {
		WebDriver driver = init();
		login("regist", "111111", driver);
		driver.findElement(By.xpath("//*[@id='navigationbar']/ul/li[3]/a")).click(); // Subclass of objects
		Thread.sleep(DELAY_FOR_DEMO);
		driver.findElement(By.xpath("//*[@id='body']/p/a")).click(); // Add new subclass
		Thread.sleep(DELAY_FOR_DEMO);
		driver.findElement(By.name("typeName")).click();
		driver.findElement(By.name("typeName")).sendKeys("TestName");
		Thread.sleep(DELAY_FOR_DEMO);
		driver.findElement(By.id("clickmeshow")).click();
		Thread.sleep(DELAY_FOR_DEMO);
		driver.findElement(By.name("parameters[0].description")).click();
		driver.findElement(By.name("parameters[0].description")).sendKeys("Test_Description");
		Thread.sleep(DELAY_FOR_DEMO);
		driver.findElement(By.name("parameters[0].unitName")).click();
		driver.findElement(By.name("parameters[0].unitName")).sendKeys("points");
		Thread.sleep(DELAY_FOR_DEMO);
		driver.findElement(By.name("parameters[0].parametersType")).click();
		driver.findElement(By.cssSelector("*[value='discreteParameters']")).click();
		driver.findElement(By.id("btnAdd")).click();
		Thread.sleep(DELAY_FOR_DEMO);
		driver.findElement(By.name("parameters[1].description")).click();
		driver.findElement(By.name("parameters[1].description")).sendKeys("Test_Description2");
		Thread.sleep(DELAY_FOR_DEMO);
		driver.findElement(By.name("parameters[1].unitName")).click();
		driver.findElement(By.name("parameters[1].unitName")).sendKeys("count");
		Thread.sleep(DELAY_FOR_DEMO);
		driver.findElement(By.name("parameters[1].parametersType")).click();
		driver.findElement(By.cssSelector("#input2 #myparam2"))
		.findElement(By.cssSelector("*[value='linearParameters']")).click();
		driver.findElement(By.id("valid")).click();
		Thread.sleep(DELAY_FOR_DEMO);
		Assert.assertNotNull(driver.findElement(By.xpath(".//*[@id='datatable']//td[contains(.,'TestName')]")).getText());
		Thread.sleep(DELAY_FOR_DEMO);
		logout(driver);
	}

	/**
	 * Test to add resource and search it
	 * Thread.sleep() Use only for DEMO!
	 * @throws Exception - use for Thread.Sleep().
	 */
	//@Test
	public void testzAddResource() throws Exception {
		WebDriver driver = init();
		login("regist", "111111", driver);
		Thread.sleep(DELAY_FOR_DEMO);
		driver.findElement(By.cssSelector("#navigationbar > ul > li:nth-child(5) > a")).click();
		Thread.sleep(DELAY_FOR_DEMO);
		driver.findElement(By.id("owner_search")).click();
		driver.findElement(By.id("owner_search")).sendKeys("NazarUser");
		Thread.sleep(DELAY_FOR_DEMO);
		driver.findElement(By.id("w-input-search")).click();
		driver.findElement(By.id("w-input-search")).sendKeys("Тестовий"); // Only Ukrainian allowed
		Thread.sleep(DELAY_FOR_DEMO);
		driver.findElement(By.id("resourcesTypeSelect")).click();
		driver.findElement(By.cssSelector("*[value='TestName']")).click();
		driver.findElement(By.id("delivery")).click();
		Thread.sleep(DELAY_FOR_DEMO);
		driver.findElement(By.xpath("//*[@id='coordinates']/li/a[@data-target='#points']")).click();
		Thread.sleep(DELAY_FOR_DEMO);
		driver.findElement(By.id("myparam1")).click();
		driver.findElement(By.id("myparam1")).clear();
		driver.findElement(By.id("myparam1")).sendKeys("1");
		Thread.sleep(DELAY_FOR_DEMO);
		driver.findElement(By.id("myparam2")).click();
		driver.findElement(By.id("myparam2")).clear();
		driver.findElement(By.id("myparam2")).sendKeys("1");
		Thread.sleep(DELAY_FOR_DEMO);
		driver.findElement(By.id("myparam3")).click();
		driver.findElement(By.id("myparam3")).clear();
		driver.findElement(By.id("myparam3")).sendKeys("1.1");
		Thread.sleep(DELAY_FOR_DEMO);
		driver.findElement(By.id("myparam4")).click();
		driver.findElement(By.id("myparam4")).clear();
		driver.findElement(By.id("myparam4")).sendKeys("1");
		Thread.sleep(DELAY_FOR_DEMO);
		driver.findElement(By.id("myparam5")).click();
		driver.findElement(By.id("myparam5")).clear();
		driver.findElement(By.id("myparam5")).sendKeys("1");
		Thread.sleep(DELAY_FOR_DEMO);
		driver.findElement(By.id("myparam6")).click();
		driver.findElement(By.id("myparam6")).clear();
		driver.findElement(By.id("myparam6")).sendKeys("1.1");
		Thread.sleep(DELAY_FOR_DEMO);
		driver.findElement(By.id("btnAddAreaPoint")).click();
		Thread.sleep(DELAY_FOR_DEMO);
		driver.findElement(By.cssSelector("#areaInput2 #myparam1")).click();
		driver.findElement(By.cssSelector("#areaInput2 #myparam1")).clear();
		driver.findElement(By.cssSelector("#areaInput2 #myparam1")).sendKeys("2");
		Thread.sleep(DELAY_FOR_DEMO);
		driver.findElement(By.cssSelector("#areaInput2 #myparam2")).click();
		driver.findElement(By.cssSelector("#areaInput2 #myparam2")).clear();
		driver.findElement(By.cssSelector("#areaInput2 #myparam2")).sendKeys("2");
		Thread.sleep(DELAY_FOR_DEMO);
		driver.findElement(By.cssSelector("#areaInput2 #myparam3")).click();
		driver.findElement(By.cssSelector("#areaInput2 #myparam3")).clear();
		driver.findElement(By.cssSelector("#areaInput2 #myparam3")).sendKeys("2.1");
		Thread.sleep(DELAY_FOR_DEMO);
		driver.findElement(By.cssSelector("#areaInput2 #myparam4")).click();
		driver.findElement(By.cssSelector("#areaInput2 #myparam4")).clear();
		driver.findElement(By.cssSelector("#areaInput2 #myparam4")).sendKeys("2");
		Thread.sleep(DELAY_FOR_DEMO);
		driver.findElement(By.cssSelector("#areaInput2 #myparam5")).click();
		driver.findElement(By.cssSelector("#areaInput2 #myparam5")).clear();
		driver.findElement(By.cssSelector("#areaInput2 #myparam5")).sendKeys("2");
		Thread.sleep(DELAY_FOR_DEMO);
		driver.findElement(By.cssSelector("#areaInput2 #myparam6")).click();
		driver.findElement(By.cssSelector("#areaInput2 #myparam6")).clear();
		driver.findElement(By.cssSelector("#areaInput2 #myparam6")).sendKeys("2.1");
		Thread.sleep(DELAY_FOR_DEMO);
		driver.findElement(By.id("btnAddAreaPoint")).click();
		Thread.sleep(DELAY_FOR_DEMO);
		driver.findElement(By.cssSelector("#areaInput3 #myparam1")).click();
		driver.findElement(By.cssSelector("#areaInput3 #myparam1")).clear();
		driver.findElement(By.cssSelector("#areaInput3 #myparam1")).sendKeys("3");
		Thread.sleep(DELAY_FOR_DEMO);
		driver.findElement(By.cssSelector("#areaInput3 #myparam2")).click();
		driver.findElement(By.cssSelector("#areaInput3 #myparam2")).clear();
		driver.findElement(By.cssSelector("#areaInput3 #myparam2")).sendKeys("3");
		Thread.sleep(DELAY_FOR_DEMO);
		driver.findElement(By.cssSelector("#areaInput3 #myparam3")).click();
		driver.findElement(By.cssSelector("#areaInput3 #myparam3")).clear();
		driver.findElement(By.cssSelector("#areaInput3 #myparam3")).sendKeys("3.1");
		Thread.sleep(DELAY_FOR_DEMO);
		driver.findElement(By.cssSelector("#areaInput3 #myparam4")).click();
		driver.findElement(By.cssSelector("#areaInput3 #myparam4")).clear();
		driver.findElement(By.cssSelector("#areaInput3 #myparam4")).sendKeys("3");
		Thread.sleep(DELAY_FOR_DEMO);
		driver.findElement(By.cssSelector("#areaInput3 #myparam5")).click();
		driver.findElement(By.cssSelector("#areaInput3 #myparam5")).clear();
		driver.findElement(By.cssSelector("#areaInput3 #myparam5")).sendKeys("3");
		Thread.sleep(DELAY_FOR_DEMO);
		driver.findElement(By.cssSelector("#areaInput3 #myparam6")).click();
		driver.findElement(By.cssSelector("#areaInput3 #myparam6")).clear();
		driver.findElement(By.cssSelector("#areaInput3 #myparam6")).sendKeys("3.1");
		Thread.sleep(DELAY_FOR_DEMO);
		driver.findElement(By.xpath("//*[@id='calculatedParamsTab']")).click();
		Thread.sleep(DELAY_FOR_DEMO);
		driver.findElement(By.id("discreteValue")).click();
		driver.findElement(By.id("discreteValue")).sendKeys("1000");
		Thread.sleep(DELAY_FOR_DEMO);
		driver.findElement(By.id("discreteComment")).click();
		driver.findElement(By.id("discreteComment")).sendKeys("Hello, World!");
		Thread.sleep(DELAY_FOR_DEMO);
		driver.findElement(By.id("linearBegin")).click();
		driver.findElement(By.id("linearBegin")).sendKeys("2000");
		Thread.sleep(DELAY_FOR_DEMO);
		driver.findElement(By.id("linearEnd")).click();
		driver.findElement(By.id("linearEnd")).sendKeys("Hello, I am writting this test for free!");
		Thread.sleep(DELAY_FOR_DEMO);
		driver.findElement(By.xpath("//*[@id='coordinates']/li/a[@data-target='#map']")).click();
		Thread.sleep(DELAY_FOR_DEMO);
		driver.findElement(By.id("allUkraine")).click();
		Thread.sleep(DELAY_FOR_DEMO);
		driver.findElement(By.id("submitForm")).click();
		Thread.sleep(DELAY_FOR_DEMO);
		driver.findElement(By.cssSelector("#navigationbar > ul > li:nth-child(2) > a")).click();
		Thread.sleep(DELAY_FOR_DEMO);
		driver.findElement(By.id("searchByParameterButton")).click();
		Thread.sleep(DELAY_FOR_DEMO);
		driver.findElement(By.id("resourcesTypeSelect")).click();
		driver.findElement(By.xpath("//*[@id='resourcesTypeSelect']/option[contains(.,'TestName')]")).click();
		driver.findElement(By.cssSelector("#discreteParameters > div > span.col-md-6 > input")).click();
		Thread.sleep(DELAY_FOR_DEMO);
		driver.findElement(By.cssSelector("#discreteParameters > div > span.col-md-6 > input")).sendKeys("1000");
		driver.findElement(By.cssSelector("#linearParameters > div > span > input")).click();
		driver.findElement(By.cssSelector("#linearParameters > div > span > input")).sendKeys("2000");
		Thread.sleep(DELAY_FOR_DEMO);
		Assert.assertNotNull(By.linkText("Тестовий"));
		logout(driver);
	}


	/**
	 * This test DELETE a new subclass.
	 * Thread.sleep() Use only for DEMO!
	 * @throws Exception - use for Thread.Sleep().
	 */
	//@Test
	public void testDeleteSubclass() throws Exception {
		WebDriver driver = init();
		login("regist", "111111", driver);
		driver.findElement(By.xpath("//*[@id='navigationbar']/ul/li[3]/a")).click(); // Subclass of objects
		Thread.sleep(DELAY_FOR_DEMO);
		Assert.assertNotNull(driver.findElement(By.xpath(".//*[@id='datatable']//td[contains(.,'TestName')]")).getText());
		driver.findElement(By.xpath(".//*[@id='datatable']//td[contains(.,'TestName')]/../td[6]/div/a")).click();
		Thread.sleep(DELAY_FOR_DEMO);
		driver.findElement(By.cssSelector(".bootbox.modal.fade.bootbox-confirm.in")).findElement(By.cssSelector(".btn.btn-primary")).click();
		Thread.sleep(DELAY_FOR_DEMO);
		Assert.assertTrue(driver.findElements(By.xpath("*[@id='datatable']//td[contains(text(),'TestName')]")).size() == 0);
		logout(driver);
	}





	// DeadCode

	// login
		/*	driver.findElement(By.id("login")).click();
			driver.findElement(By.id("login")).clear();
			driver.findElement(By.id("login")).sendKeys("regist");
			Thread.sleep(DELAY_FOR_DEMO);
			driver.findElement(By.id("password")).click();
			driver.findElement(By.id("password")).clear();
			driver.findElement(By.id("password")).sendKeys("111111");
			Thread.sleep(DELAY_FOR_DEMO);
			driver.findElement(By.cssSelector(".btn.btn-primary")).click();
			Thread.sleep(DELAY_FOR_DEMO);
*/

}
