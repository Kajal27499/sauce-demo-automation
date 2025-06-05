package tests;

import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

import pages.LoginPage;
import pages.SelectProductPage;
import utils.Base;

public class PlaceOrderTest extends Base {
	ExtentSparkReporter spark;
	ExtentReports extReports;
	ExtentTest test;

	@BeforeClass
	public void setUpReports() {
		spark = new ExtentSparkReporter("reports\\ExtentReport.html");
		extReports = new ExtentReports();
		extReports.attachReporter(spark);
	}

	@AfterClass
	public void writeReports() {
		extReports.flush();
	}

	@Test
	public void testPlaceOrder() {
		// create step 1 in extent report
		test = extReports.createTest("Place order");
		// 1. perform login operation and validate
		LoginPage loginPage = new LoginPage(driver,test);
		loginPage.validateLogin("standard_user", "secret_sauce");
		// 2. click on the product and validate
		SelectProductPage selectProduct = new SelectProductPage(driver, test);
		selectProduct.validateProductDisplay();
		// 3. click add to cart button and validate
	}

	@BeforeMethod
	public void beforeMethod() {
		// to launch browser
		launchBrowser();
	}

	@AfterMethod
	public void afterMethod() {
		sleep(5000);
		driver.quit();
	}

	@DataProvider
	public Object[][] dp() {
		return new Object[][] { new Object[] { 1, "a" }, new Object[] { 2, "b" }, };
	}

}
