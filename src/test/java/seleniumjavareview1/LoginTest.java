package seleniumjavareview1;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class LoginTest extends BaseClass {

	@Test(priority = 1, groups = "sanity")
	public void verifyLogin() {

		LoginPage loginPage = new LoginPage(driver);
		loginPage.enterUserNameAndPassword("standard_user", "secret_sauce");
		loginPage.submitLogin();
	}

	@Test(priority = 2, groups = "sanity")
	public void verifyInvalidLogin() {

		LoginPage loginPage = new LoginPage(driver);
		loginPage.enterUserNameAndPassword("standard_user", "secret_sauc");
		loginPage.submitLogin();
		String actualMsg = loginPage.loginErrorMessage();
		Assert.assertEquals(actualMsg, "Epic sadface: Username and password do not match any user in this service");
	}
	

	@Test(priority = 3, dataProvider="loginData", groups = {"regression"})
	public void verifyLoginMultipleData(String userName, String password) {

		LoginPage loginPage = new LoginPage(driver);
		loginPage.enterUserNameAndPassword(userName, password);
		loginPage.submitLogin();
	}

	@DataProvider(name = "loginData")
	public Object[][] getData() {
		return new Object[][] { { "standard_user", "secret_sauce" }, { "user2", "pass2" } };

	}

}
