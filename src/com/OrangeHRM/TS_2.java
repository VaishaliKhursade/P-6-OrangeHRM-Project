package com.OrangeHRM;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class TS_2 {
	public WebDriver driver;

	String url = "https://opensource-demo.orangehrmlive.com/web/index.php/auth/login";
	
@BeforeClass
	public void launch() throws Exception {
		
		System.setProperty("webdriver.chrome.driver","C:\\Users\\Sel_3.141_Jars_ExcelrOnline\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get(url);
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);

		driver.findElement(By.name("username")).sendKeys("Admin");
		driver.findElement(By.name("password")).sendKeys("admin123");
		driver.findElement(By.xpath("//button[@type='submit']")).click();
		driver.findElement(By.linkText("PIM")).click();
		driver.findElement(By.linkText("Employee List")).click();
		
		Thread.sleep(1000);
		
}
	
@BeforeMethod
	public void EmployeeList() throws Exception {
	driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.findElement(By.linkText("PIM")).click();
		Thread.sleep(1000);

		driver.findElement(By.linkText("Employee List")).click();
		Thread.sleep(1000);
}
	
@Test(priority = 1)
	public void TC001() {
	driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

		WebElement PIMpage = driver.findElement(By.xpath("//h6[@class='oxd-text oxd-text--h6 oxd-topbar-header-breadcrumb-module']"));
		Assert.assertTrue(PIMpage.isDisplayed(), "Test Failed, driver is not navigated to PIM page");
}


@Test(priority = 2)
	public void TC002() {
	driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
                                            
		WebElement List = driver.findElement(By.xpath("/html/body/div/div[1]/div[2]/div[2]/div/div[2]/div[3]"));
		Assert.assertTrue(List.isDisplayed(), "Test Failed, List of employees is not displayed");

}


@Test(priority = 3)
	public void TC003() {
	

		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

		WebElement Employeename = driver.findElement(By.xpath("(//input[@placeholder='Type for hints...'])[1]"));
		Employeename.sendKeys("Kiyara");
		driver.findElement(By.xpath("//button[text()=' Search ']")).click();
		WebElement list1 = driver.findElement(By.xpath("//div[@class='orangehrm-container']"));
		
		Assert.assertTrue(list1.isDisplayed(), "Test Failed, Unable to search with Employee Name");
}

@Test(priority = 4)
public void TC004() {

	driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

	WebElement EmployeeId = driver.findElement(By.xpath("/html/body/div/div[1]/div[2]/div[2]/div/div[1]/div[2]/form/div[1]/div/div[2]/div/div[2]/input"));
	EmployeeId.sendKeys("239");
	driver.findElement(By.xpath("//button[text()=' Search ']")).click();
	WebElement list1 = driver.findElement(By.xpath("//div[@class='orangehrm-container']"));
	
	Assert.assertTrue(list1.isDisplayed(), "Test Failed, Unable to search with EmployeeId");
}

@Test(priority = 5)
	public void TC005() {

		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

		driver.findElement(By.xpath(
		"/html/body/div/div[1]/div[2]/div[2]/div/div[1]/div[2]/form/div[1]/div/div[6]/div/div[2]/div/div/div[1]"))
		.click();
		driver.findElement(By.xpath(
				"/html/body/div/div[1]/div[2]/div[2]/div/div[1]/div[2]/form/div[1]/div/div[6]/div/div[2]/div/div/div[2]/i")).click();

		driver.findElement(By.xpath("/html/body/div/div[1]/div[2]/div[2]/div/div[1]/div[2]/form/div[1]/div/div[6]/div/div[2]/div/div/div[1]"))
		.click();

		WebElement list1 = driver.findElement(By.xpath("//div[@class='orangehrm-container']"));

		Assert.assertTrue(list1.isDisplayed(), "Test Failed, Unable to search with Job Title");

}



@Test(priority = 6)
	public void TC006() {

		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

		driver.findElement(By.xpath(
		"/html/body/div/div[1]/div[2]/div[2]/div/div[1]/div[2]/form/div[1]/div/div[7]/div/div[2]/div/div/div[1]"))
		.click();
		driver.findElement(By.xpath(
				"/html/body/div/div[1]/div[2]/div[2]/div/div[1]/div[2]/form/div[1]/div/div[7]/div/div[2]/div/div/div[2]/i")).click();

		driver.findElement(By.xpath("/html/body/div/div[1]/div[2]/div[2]/div/div[1]/div[2]/form/div[1]/div/div[7]/div/div[2]/div/div/div[1]"))
		.click();

		WebElement list1 = driver.findElement(By.xpath("//div[@class='orangehrm-container']"));

		Assert.assertTrue(list1.isDisplayed(), "Test Failed, Unable to search with Sub Unit");

}


@Test(priority = 7) //(should select  id check box)
	public void TC007() throws Exception {

		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

		driver.findElement(By.xpath(
				"/html/body/div/div[1]/div[2]/div[2]/div/div[2]/div[3]/div/div[2]/div[1]/div/div[1]/div/div/label/span/i"))
		.click();

		Thread.sleep(3000);
		String s = driver.findElement(By.xpath("/html/body/div/div[1]/div[2]/div[2]/div/div[2]/div[2]/div/div/span")).getText();
		String exps = "(1) Record Selected";
		Assert.assertEquals(s, exps,"Test fail user is not able to sellect multiple options");

}

@Test(priority = 8)  //( delete Selected button displayed)
	public void TC008() {

	driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
	
	driver.findElement(By.xpath("/html/body/div/div[1]/div[2]/div[2]/div/div[2]/div[3]/div/div[2]/div[1]/div/div[1]/div/div/label/span/i")).click();
	driver.findElement(By.xpath("//button[text()=' Delete Selected ']")).click();
	
	driver.findElement(By.xpath("//button[text()=' Yes, Delete ']")).click();
	String c = driver.findElement(By.xpath("/html/body/div/div[1]/div[2]/div[2]/div/div[2]/div[2]/div/div/span")).getText();
	String expc = "(1) Record Found" ;
	Assert.assertEquals(c, expc,"Test failed Sellected employees not get deleted");

	
	
}


@Test(priority = 9)     //(Able to delete employee)
	public void TC009() {

		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

		driver.findElement(By.xpath(
				"/html/body/div/div[1]/div[2]/div[2]/div/div[2]/div[3]/div/div[2]/div[4]/div/div[9]/div/button[1]/i"))
		.click();
		driver.findElement(By.xpath("/html/body/div/div[3]/div/div/div/div[3]/button[2]")).click();
}

@Test(priority = 10)
	public void TC010() {
	driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		List<String> EmployeeList = new ArrayList<String>();
		List<WebElement> EmployeeElements = driver.findElements(By.xpath("/html/body/div/div[1]/div[2]/div[2]/div/div[2]/div[3]/div/div[2]/div[1]/div/div[3]/div"));

		for (WebElement EmployeeElements1 : EmployeeElements) {
			EmployeeList.add(EmployeeElements1.getText());
		}

		List<String> sortedEmployeeList = new ArrayList<String>(EmployeeList);

		Collections.sort(sortedEmployeeList);

		Assert.assertEquals(EmployeeList, sortedEmployeeList, "The user list is not sorted alphabetically.");
}


@Test(priority = 11)   //(click on add button)
	public void TC011() {
	driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

	driver.findElement(By.xpath("//button[text()=' Add ']")).click();
	WebElement TitleAddEmployee = driver.findElement(By.xpath("//h6[@class='oxd-text oxd-text--h6 orangehrm-main-title']"));

    Assert.assertTrue(TitleAddEmployee.isDisplayed(), "Test Failed, user is not able to see Title Add Employee form");

}

@Test(priority = 12)
	public void TC012() throws Exception {
	
	driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	driver.findElement(By.linkText("Employee List")).click();
	WebElement EmployeeInformation = driver.findElement(By.xpath("//h5[text()='Employee Information']"));
	WebElement EmployeeName = driver.findElement(By.xpath("//label[text()='Employee Name']"));
	WebElement EmployeeId = driver.findElement(By.xpath("//label[text()='Employee Id']"));
	WebElement EmployeeStatus = driver.findElement(By.xpath("//label[text()='Employment Status']"));

	WebElement Include = driver.findElement(By.xpath("//label[text()='Include']"));
	WebElement SupervisorName = driver.findElement(By.xpath("//label[text()='Supervisor Name']"));

	WebElement JobTitle = driver.findElement(By.xpath("//label[text()='Job Title']"));
	WebElement SubUnit = driver.findElement(By.xpath("//label[text()='Sub Unit']"));
	
	WebElement Searchbutton = driver.findElement(By.xpath("//button[text()=' Search ']"));
	WebElement Resetbutton = driver.findElement(By.xpath("//button[text()=' Reset ']"));
	WebElement Addbutton = driver.findElement(By.xpath("//button[text()=' Add ']"));
	
	WebElement Deletebutton = driver.findElement(By.xpath("(//i[@class='oxd-icon bi-trash'])[1]"));
	WebElement Editbutton = driver.findElement(By.xpath("(//i[@class='oxd-icon bi-pencil-fill'])[1]"));
	
	
	
     Assert.assertTrue(EmployeeInformation.isDisplayed(), "EmployeeInformation link is not visible");
     Assert.assertTrue(EmployeeName.isDisplayed(), "First Name input box is not visible");
     Assert.assertTrue(EmployeeId.isDisplayed(), "EmployeeId input box is not visible");
     Assert.assertTrue(EmployeeStatus.isDisplayed(), "EmployeeStatus dropdown is not visible");
     Assert.assertTrue(Include.isDisplayed(), "Include input box is not visible");
     Assert.assertTrue( SupervisorName.isDisplayed(), " SupervisorName input box is not visible");
     Assert.assertTrue(JobTitle.isDisplayed(), "Job Title is not visible");
     Assert.assertTrue( SubUnit.isDisplayed(), " SubUnit input box is not visible");
     Assert.assertTrue(Searchbutton.isDisplayed(), "Searchbutton button is not visible");
     Assert.assertTrue( Resetbutton.isDisplayed(), " Resetbutton button is not visible");
     Assert.assertTrue( Addbutton.isDisplayed(), " Addbutton button is not visible");
     Assert.assertTrue( Deletebutton.isDisplayed(), " Deletebutton button is not visible");
     Assert.assertTrue( Editbutton.isDisplayed(), " Editbutton button is not visible");
     
     
     Assert.assertTrue(EmployeeInformation.isEnabled(), "EmployeeInformation link is disabled");
     Assert.assertTrue(EmployeeName.isEnabled(), "First Name input box is disabled");
     Assert.assertTrue(EmployeeId.isEnabled(), "EmployeeId input box is disabled");
     Assert.assertTrue(EmployeeStatus.isEnabled(), "EmployeeStatus dropdown is disabled");
     Assert.assertTrue(Include.isEnabled(), "Include input box is disabled");
     Assert.assertTrue( SupervisorName.isEnabled(), " SupervisorName input box is disabled");
     Assert.assertTrue(JobTitle.isEnabled(), "Job Title is disabled");
     Assert.assertTrue( SubUnit.isEnabled(), " SubUnit input box is disabled");
     Assert.assertTrue(Searchbutton.isEnabled(), "Searchbutton button is disabled");
     Assert.assertTrue( Resetbutton.isEnabled(), " Resetbutton button is disabled");
     Assert.assertTrue( Addbutton.isEnabled(), " Addbutton button is disabled");
     Assert.assertTrue( Deletebutton.isEnabled(), " Deletebutton button is disabled");
     Assert.assertTrue( Editbutton.isEnabled(), " Editbutton button is disabled");
     
}
@Test(priority = 13)
	public void TC013() {
	driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

	driver.findElement(By.xpath("//button[text()=' Add ']")).click();
	driver.findElement(By.xpath("/html/body/div/div[1]/div[2]/div[2]/div/div/form/div[3]/button[2]")).click();
	WebElement errormsg = driver
	.findElement(By.xpath("(//span[@class='oxd-text oxd-text--span oxd-input-field-error-message oxd-input-group__message'])[1]"));

	Assert.assertTrue(errormsg.isDisplayed(),"Test failed, user is able to add Employee without filling required field");

}

@AfterTest
	public void Close() {
	driver.quit();
}


}
