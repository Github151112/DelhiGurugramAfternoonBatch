package TestScript;

import java.io.IOException;
import java.lang.reflect.Method;

import org.apache.poi.EncryptedDocumentException;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;

import PomPages.LoginPage;
import genericLib.BaseTest;
import genericLib.Flib;


public class ValidLoginTest extends BaseTest {

	@Test(groups = "ST")
	public void login(Method method) throws EncryptedDocumentException, IOException {
		
		test = report.createTest(method.getName());
		Flib f = new Flib();
		String username = f.getDataFromExcelFile(EXCELPATH, USERSHEET, 1, 0);
		String password = f.getDataFromExcelFile(EXCELPATH, USERSHEET, 1, 1);
		LoginPage lp = new LoginPage(driver);
		test.log(Status.FAIL, "Login Successfully");

		lp.validLogin(username, password);
		test.log(Status.FAIL, "Login Successfully");

	}

}
