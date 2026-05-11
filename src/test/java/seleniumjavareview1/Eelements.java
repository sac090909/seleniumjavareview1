package seleniumjavareview1;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Eelements {

	public static void main(String[] args) throws InterruptedException {
		
		//WebDriverManager.chromedriver();
		ChromeOptions options = new ChromeOptions();
		options.addArguments("disable-features=PasswordManagerEnabled");
		options.addArguments("disable-features=PasswordLeakDetection");
		options.addArguments("disable-features=AutofillServerCommunication");
		options.addArguments("disable-features=AutofillEnableAccountWalletStorage");
		
		WebDriver driver = new ChromeDriver(options);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.manage().window().maximize();
		
		//driver.get("https://testautomationpractice.blogspot.com/");
		//driver.findElement(By.id("name")).sendKeys("Abu Test");
		
		driver.get("https://www.saucedemo.com/");
		driver.findElement(By.xpath("//input[contains(@id,'user-name')]")).sendKeys("standard_user");
		driver.findElement(By.cssSelector("#password")).sendKeys("secret_sauce");
		driver.findElement(By.xpath("//div[@class='error-message-container']/following-sibling::input")).click();
		
		String pageTitle = driver.findElement(By.xpath("//div[text()='Swag Labs']")).getText();
		System.out.println(driver.getTitle());
		System.out.println(pageTitle);
		
		//Thread.sleep(1000);
		driver.close();

	}

}
