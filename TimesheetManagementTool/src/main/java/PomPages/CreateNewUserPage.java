package PomPages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CreateNewUserPage extends BaseClass {

	public CreateNewUserPage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}

	
	
	@FindBy(xpath ="//input[@name='username']")
	private WebElement createUsernameTextField;
	
	@FindBy(name = "passwordText")
	private WebElement createPasswordTextField;
	
	@FindBy(name = "passwordTextRetype")
	private WebElement passwordReTypeTextField;
	
	@FindBy(name = "firstName")
	private WebElement firstNameTextField;
	
	@FindBy(name = "lastName")
	private WebElement lastNameTextField;
	
	@FindBy(xpath = "//input[contains(@value,'Create User')]")
	private WebElement createUserButton;

	public WebElement getCreateUsernameTextField() {
		return createUsernameTextField;
	}

	public WebElement getCreatePasswordTextField() {
		return createPasswordTextField;
	}

	public WebElement getPasswordReTypeTextField() {
		return passwordReTypeTextField;
	}

	public WebElement getFirstNameTextField() {
		return firstNameTextField;
	}

	public WebElement getLastNameTextField() {
		return lastNameTextField;
	}

	public WebElement getCreateUserButton() {
		return createUserButton;
	}
	
	public void createNewUser(String username,String password,String fn,String Ln)
	{
		createUsernameTextField.sendKeys(username);
		createPasswordTextField.sendKeys(password);
		passwordReTypeTextField.sendKeys(password);
		firstNameTextField.sendKeys(fn);
		lastNameTextField.sendKeys(Ln);
		createUserButton.click();
	}
	
	
	
}
