package com.OrangeHRM;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class TS_3 {
	
	WebDriver driver;

	String url = "https://opensource-demo.orangehrmlive.com/web/index.php/auth/login";

@BeforeTest
	public void launch() throws Exception {

		System.setProperty("webdriver.chrome.driver","C:\\Users\\Sel_3.141_Jars_ExcelrOnline\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get(url);
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);

		driver.findElement(By.name("username")).sendKeys("Admin");
		driver.findElement(By.name("password")).sendKeys("admin123");
		driver.findElement(By.xpath("//button[@type='submit']")).click();

		driver.findElement(By.xpath("/html/body/div/div[1]/div[1]/aside/nav/div[2]/ul/li[2]/a/span")).click();
		driver.findElement(By.linkText("Add Employee")).click();
		
		Thread.sleep(1000);
		
}
	
@BeforeMethod
	public void EmployeeList() throws Exception {
	
		driver.findElement(By.xpath("/html/body/div/div[1]/div[1]/aside/nav/div[2]/ul/li[2]/a/span")).click();
		Thread.sleep(1000);

		driver.findElement(By.linkText("Add Employee")).click();
		Thread.sleep(1000);
}

@Test(priority = 1)
public void TC001() {

	driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

	WebElement PIMpage = driver.findElement(By.xpath("//h6[@class='oxd-text oxd-text--h6 oxd-topbar-header-breadcrumb-module']"));
	Assert.assertTrue(PIMpage.isDisplayed(), "Test Failed, driver is not navigated to PIM page");
}

@Test(priority = 2)
public void TC002() {

	driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

	WebElement AddEmppage = driver.findElement(By.xpath("//h6[@class='oxd-text oxd-text--h6 orangehrm-main-title']"));
	Assert.assertTrue(AddEmppage.isDisplayed(), "Test Failed, driver is not navigated to AddEmppage page");

}

@Test(priority = 3)
public void TC003() throws Exception {

driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

driver.findElement(By.xpath("//input[@name='firstName']")).sendKeys("Anaya");
driver.findElement(By.xpath("//input[@name='middleName']")).sendKeys("mahesh");
driver.findElement(By.xpath("//input[@name='lastName']")).sendKeys("Pathak");
driver.findElement(By.xpath("//span[@class='oxd-switch-input oxd-switch-input--active --label-right']")).click();
driver.findElement(By.xpath("/html/body/div/div[1]/div[2]/div[2]/div/div/form/div[1]/div[2]/div[3]/div/div[1]/div/div[2]/input")).sendKeys("Anaya");
driver.findElement(By.xpath("/html/body/div/div[1]/div[2]/div[2]/div/div/form/div[1]/div[2]/div[4]/div/div[1]/div/div[2]/input")).sendKeys("Anaya123!@#");
driver.findElement(By.xpath("/html/body/div/div[1]/div[2]/div[2]/div/div/form/div[1]/div[2]/div[4]/div/div[2]/div/div[2]/input")).sendKeys("Anaya123!@#");
driver.findElement(By.xpath("//button[text()=' Save ']")).click();
Thread.sleep(2000);
}

@Test(priority = 4)
public void TC04() throws Exception {
	
	 WebElement TitleAddEmployee = driver.findElement(By.xpath("//h6[@class='oxd-text oxd-text--h6 orangehrm-main-title']"));
	 WebElement EmployeeFullName = driver.findElement(By.xpath("//label[@class='oxd-label oxd-input-field-required']"));
     Thread.sleep(1000);
     WebElement FirstName = driver.findElement(By.xpath("//input[@name='firstName']"));
     WebElement MiddleName = driver.findElement(By.xpath("//input[@name='middleName']"));
     WebElement LastName = driver.findElement(By.xpath("//input[@name='lastName']"));
     Thread.sleep(1000);
     WebElement EmployeeId= driver.findElement(By.xpath("//label[@class='oxd-label']"));
     Thread.sleep(1000);
     WebElement CreateLoginDetails= driver.findElement(By.xpath("//p[@class='oxd-text oxd-text--p user-form-header-text']"));
     WebElement Switch = driver.findElement(By.xpath("//span[@class='oxd-switch-input oxd-switch-input--active --label-right']"));	
     Thread.sleep(1000);
     WebElement Username= driver.findElement(By.xpath("/html/body/div/div[1]/div[2]/div[2]/div/div/form/div[1]/div[2]/div[3]/div/div[1]/div/div[2]/input"));
     Thread.sleep(1000);
     WebElement Status= driver.findElement(By.xpath("//label[text()='Status']"));
     WebElement Password= driver.findElement(By.xpath("/html/body/div/div[1]/div[2]/div[2]/div/div/form/div[1]/div[2]/div[4]/div/div[1]/div/div[2]/input"));
     WebElement ConfirmPassword= driver.findElement(By.xpath("/html/body/div/div[1]/div[2]/div[2]/div/div/form/div[1]/div[2]/div[4]/div/div[2]/div/div[2]/input"));
     WebElement Cancelbutton = driver.findElement(By.xpath("//button[@class='oxd-button oxd-button--medium oxd-button--ghost']"));
     WebElement Savebutton = driver.findElement(By.xpath("//button[@class='oxd-button oxd-button--medium oxd-button--secondary orangehrm-left-space']"));
     Thread.sleep(1000);
     
     Assert.assertTrue(TitleAddEmployee.isDisplayed(), "Title Add Employee is not visible");
	 Assert.assertTrue(EmployeeFullName.isDisplayed(), "Employee Full Name input box is not visible");
     Assert.assertTrue(FirstName.isDisplayed(), "First Name input box is not visible");
     Assert.assertTrue(MiddleName.isDisplayed(), "Middle Name input box is not visible");
     Assert.assertTrue(LastName.isDisplayed(), "LastName Name input box is not visible");
     Assert.assertTrue(EmployeeId.isDisplayed(), "EmployeeId input box is not visible");
     Assert.assertTrue( CreateLoginDetails.isDisplayed(), " CreateLoginDetails link is not visible");
     Assert.assertTrue(Switch.isDisplayed(), "Switch is not visible");
     Assert.assertTrue( Username.isDisplayed(), " Username input box is not visible");
     Thread.sleep(1000);
     Assert.assertTrue(Status.isDisplayed(), "Status link is not visible");
     Assert.assertTrue( Password.isDisplayed(), " Password input box is not visible");
     Assert.assertTrue( ConfirmPassword.isDisplayed(), " ConfirmPassword input box is not visible");
     Assert.assertTrue( Cancelbutton.isDisplayed(), " Cancelbutton button is not visible");
     Assert.assertTrue( Savebutton.isDisplayed(), " Savebutton button is not visible");
     
     Assert.assertTrue(EmployeeFullName.isEnabled(), "Employee Name input box is disabled");
     Assert.assertTrue(EmployeeFullName.isEnabled(), "Employee Name input box is disabled");
     Assert.assertTrue(FirstName.isEnabled(), "First Name input box disabled");
     Assert.assertTrue(MiddleName.isEnabled(), "Middle Name input box is disabled");
     Assert.assertTrue(LastName.isEnabled(), "LastName Name input box is disabled");
     Assert.assertTrue(EmployeeId.isEnabled(), "EmployeeId input box is disabled");
     Assert.assertTrue( CreateLoginDetails.isEnabled(), " CreateLoginDetails link is disabled");
     Assert.assertTrue(Switch.isEnabled(), "Switch is disabled");
     Assert.assertTrue( Username.isEnabled(), " Username input box is disabled");
     Thread.sleep(1000);
     Assert.assertTrue(Status.isEnabled(), "Status link is disabled");
     Assert.assertTrue( Password.isEnabled(), " Password input box is disabled");
     Assert.assertTrue( ConfirmPassword.isEnabled(), " ConfirmPassword input box is disabled");
     Assert.assertTrue( Cancelbutton.isEnabled(), " Cancelbutton button is disabled");
     Assert.assertTrue( Savebutton.isEnabled(), " Savebutton button is disabled");
     
}
@AfterTest
public void Close() {
driver.quit();
}






}
