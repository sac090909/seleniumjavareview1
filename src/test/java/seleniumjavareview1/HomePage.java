package seleniumjavareview1;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {

	
	public HomePage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//div[text()='Swag Labs']")
	WebElement pageTitle;

	// String pageTitle = driver.findElement(By.xpath("//div[text()='Swag
	// Labs']")).getText();

	public String getPageTitle() {
		return pageTitle.getText();
	}

}
