package TestScript;

import java.io.IOException;
import java.lang.reflect.Method;

import org.apache.poi.EncryptedDocumentException;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;

import PomPages.CreateNewUserPage;
import PomPages.HomePage;
import PomPages.LoginPage;
import PomPages.UserListPage;
import genericLib.BaseTest;
import genericLib.Flib;
import genericLib.WorkLIb;

public class CreateUserTest extends BaseTest {

	@Test(groups = "RT")
	public void createNewUser(Method method) throws EncryptedDocumentException, IOException {

		// login
		test = report.createTest(method.getName());
		Flib f = new Flib();
		String username = f.getDataFromExcelFile(EXCELPATH, USERSHEET, 1, 0);
		String password = f.getDataFromExcelFile(EXCELPATH, USERSHEET, 1, 1);
		LoginPage lp = new LoginPage(driver);
		lp.validLogin(username, password);

		// click on user link
		HomePage hp = new HomePage(driver);
		hp.clickOnUsersLink();
		test.log(Status.FAIL, "Successfully clicked on user link");

		// click on createNewUserButton
		UserListPage ulp = new UserListPage(driver);
		ulp.clickOnCreateNewUserButton();

		WorkLIb wlib = new WorkLIb();

		String usn = f.getDataFromExcelFile(EXCELPATH, NEWUSERSHEET, 1, 0) + wlib.getRandomNo();
		String pwd = f.getDataFromExcelFile(EXCELPATH, NEWUSERSHEET, 1, 1) + wlib.getRandomNo();
		String fn = f.getDataFromExcelFile(EXCELPATH, NEWUSERSHEET, 1, 2) + wlib.getRandomNo();
		String ln = f.getDataFromExcelFile(EXCELPATH, NEWUSERSHEET, 1, 3) + wlib.getRandomNo();

		// create new user
		CreateNewUserPage cnup = new CreateNewUserPage(driver);
		cnup.createNewUser(usn, pwd, fn, ln);

	}

}
