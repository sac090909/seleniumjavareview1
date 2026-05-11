package seleniumjavareview1;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

public class BaseClass {

	WebDriver driver;
    @Parameters({"browser"})
	@BeforeMethod (groups={"sanity", "regression"})
	public void setUp(String br) {
		
		if(br.equalsIgnoreCase("chrome")) {
		ChromeOptions options = new ChromeOptions();
		options.addArguments("disable-features=PasswordManagerEnabled");
		options.addArguments("disable-features=PasswordLeakDetection");
		options.addArguments("disable-features=AutofillServerCommunication");
		options.addArguments("disable-features=AutofillEnableAccountWalletStorage");

		driver = new ChromeDriver(options);
		
		}else if(br.equalsIgnoreCase("firefox")) {
		
			FirefoxOptions options = new FirefoxOptions();
			options.addArguments("disable-features=PasswordManagerEnabled");
			options.addArguments("disable-features=PasswordLeakDetection");
			options.addArguments("disable-features=AutofillServerCommunication");
			options.addArguments("disable-features=AutofillEnableAccountWalletStorage");
			driver = new FirefoxDriver(options);
		}else {
			return;
		}
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.manage().window().maximize();
		driver.get("https://www.saucedemo.com/");
	}

	@AfterMethod (groups={"sanity", "regression"})
	public void tearDown() {
		if (driver != null) {
			driver.quit();
		}
	}

}
