package seleniumjavareview1;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
	
	WebDriver driver;
	
	public LoginPage(WebDriver driver) {
	    PageFactory.initElements(driver, this);
	}
	
	
	@FindBy(xpath="//input[contains(@id,'user-name')]") WebElement nameTextBox;
	@FindBy(css="#password") WebElement passwordTextBox;
	@FindBy(xpath="//div[@class='error-message-container']/following-sibling::input") WebElement loginBtn;
	@FindBy(tagName="h3") WebElement errorMsg;
	
	//driver.findElement(By.xpath("//input[contains(@id,'user-name')]")).sendKeys("standard_user");
	//driver.findElement(By.cssSelector("#password")).sendKeys("secret_sauce");
	//driver.findElement(By.xpath("//div[@class='error-message-container']/following-sibling::input")).click();
	
	
	public void enterUserNameAndPassword(String name, String password) {
		nameTextBox.sendKeys(name);
		passwordTextBox.sendKeys(password);
		
		
	}
	
	public void submitLogin() {
		loginBtn.click();
	}
	
	public String loginErrorMessage() {
		return errorMsg.getText();
	}

}
