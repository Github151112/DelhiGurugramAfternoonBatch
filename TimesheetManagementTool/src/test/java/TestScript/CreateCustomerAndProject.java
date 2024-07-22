package TestScript;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.testng.annotations.Test;

import PomPages.CreateNewCustomerPage;
import PomPages.HomePage;
import PomPages.LoginPage;
import PomPages.OpenTaskPage;
import genericLib.BaseTest;
import genericLib.Flib;
import genericLib.WorkLIb;

public class CreateCustomerAndProject extends BaseTest {
	
	
	@Test(groups = {"IT","RT"})
	public void createCustomerAndProject() throws EncryptedDocumentException, IOException
	{
		//login
		Flib f = new Flib();
		String username = f.getDataFromExcelFile(EXCELPATH, USERSHEET, 1, 0);
		String password = f.getDataFromExcelFile(EXCELPATH, USERSHEET, 1, 1);
		LoginPage lp = new LoginPage(driver);
		lp.validLogin(username, password);
		
		//click on tasks
		HomePage hp = new HomePage(driver);
		hp.clickOnTasksLink();
		
		//click on project and customer link
		OpenTaskPage otp = new OpenTaskPage(driver);
		otp.clickOnProjectAndCustomerLink();
		
		WorkLIb lib = new WorkLIb();
		
		String customerName = f.getDataFromExcelFile(EXCELPATH, CUSTPROJSHEET, 1, 0)+lib.getRandomNo();
		String ProjectName = f.getDataFromExcelFile(EXCELPATH, CUSTPROJSHEET, 1, 1)+lib.getRandomNo();
		
		//createNewProjectAndCustomer
		CreateNewCustomerPage cncp = new CreateNewCustomerPage(driver);
		cncp.createNewCustomerAndProject(driver, customerName, ProjectName);
		
	}

}
