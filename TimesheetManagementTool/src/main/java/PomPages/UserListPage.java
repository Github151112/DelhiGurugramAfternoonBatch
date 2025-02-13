package PomPages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class UserListPage extends BaseClass {

	public UserListPage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}

	
	@FindBy(xpath = "//input[@value='Create New User']")
	private WebElement createNewUserButton;


	public WebElement getCreateNewUserButton() {
		return createNewUserButton;
	}
	
	public void clickOnCreateNewUserButton()
	{
		createNewUserButton.click();
	}
	
	
}
