package seleniumjavareview1;

import org.testng.annotations.Test;

public class HomeTest extends BaseClass{
	
	@Test(priority=3, groups={"sanity", "regression"})
	public void verifyHomePage() {

		LoginPage loginPage = new LoginPage(driver);
		loginPage.enterUserNameAndPassword("standard_user", "secret_sauce");
		loginPage.submitLogin();
		HomePage homePage = new HomePage(driver);
		String pageTitle = homePage.getPageTitle();
	}

}
