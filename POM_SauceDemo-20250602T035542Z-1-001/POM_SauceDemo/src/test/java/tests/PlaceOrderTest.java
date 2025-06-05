package tests;

import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

import pages.AddToCartPage;
import pages.LoginPage;
import pages.SelectProductPage;
import utils.Base;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.AfterClass;


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

	@BeforeMethod
	public void beforeMethod() {
		launchBrowser();
	}

	@AfterMethod
	public void afterMethod() {
		sleep(10000);
		driver.quit();
	}

	@BeforeClass
	public void beforeClass() {

	}

	@AfterClass
	public void afterClass() {

	}

	@Test
	public void testPlaceOrder() {
		test = extReports.createTest("Place Order");
		LoginPage loginPage = new LoginPage(driver, test);
		loginPage.validateLogin("standard_user","secret_sauce");
		
		// 2. click on the product and validate
				SelectProductPage selectProduct = new SelectProductPage(driver, test);
				selectProduct.validateProduct();

				
				// 3. Click add to cart button and validate
				AddToCartPage cartPage = new AddToCartPage(driver, test);
				cartPage.addToCart();
				cartPage.verifyCartUpdated();
	}

	@DataProvider
	public Object[][] dp() {
		return new Object[][] { new Object[] { 1, "a" }, new Object[] { 2, "b" }, };
	}
	


}
