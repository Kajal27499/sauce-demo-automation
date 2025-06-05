package objectRepository;

import org.openqa.selenium.By;

public class Locators {
	//locators for login page
	public static By userName = By.id("user-name");
	public static By password = By.id("password");
	public static By loginButton = By.id("login-button");
	//locators for select product
	public static By prodName = By.xpath("//div[text()='Sauce Labs Backpack']");
	
//	for printing details
//	public static By productFetchedName = By.xpath("(//div[@class=\"inventory_details_desc_container\"]/child::div)[1]");
//	public static By description = By.xpath("(//div[@class=\"inventory_details_desc_container\"]/child::div)[2]");
//	public static By price = By.xpath("(//div[@class=\"inventory_details_desc_container\"]/child::div)[3]");
	
}
