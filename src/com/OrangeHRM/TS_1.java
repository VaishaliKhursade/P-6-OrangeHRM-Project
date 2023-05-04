package com.OrangeHRM;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class TS_1 {
	// Verifying Login of OrangeHRM Application

	WebDriver driver;

	String url = "https://opensource-demo.orangehrmlive.com/web/index.php/auth/login";

	@BeforeMethod

	public void launch() throws Exception {

	System.setProperty("webdriver.chrome.driver", "C:\\Users\\Sel_3.141_Jars_ExcelrOnline\\chromedriver.exe");

	driver = new ChromeDriver();

	driver.get(url);

	driver.manage().window().maximize();

	Thread.sleep(1000);

	}

	@Test(priority = 1)

	public void TC1() {

	driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

	String actTitle = driver.getTitle();

	String expextedTitle = "OrangeHRM";

	Assert.assertEquals(actTitle, expextedTitle, "Test Failed Application not launched successfully");

	}

	@Test(priority = 2)

	public void TC2() {

	driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

	driver.findElement(By.xpath("//input[@name='username']")).sendKeys("Admin");

	driver.findElement(By.xpath("//input[@name='password']")).sendKeys("admin123");

	driver.findElement(By.xpath("//button[@type='submit']")).click();

	WebElement w = driver.findElement(By.xpath("//*[@class='oxd-text oxd-text--h6 oxd-topbar-header-breadcrumb-module']"));

	Assert.assertTrue(w.isDisplayed(), "Test Failed user is not able to login with valid credentials");

	}

	@Test(priority = 3)

	public void TC3() {

	driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

	driver.findElement(By.xpath("/html/body/div/div[1]/div/div[1]/div/div[2]/div[2]/form/div[4]/p")).click();

	driver.findElement(By.xpath("//input[@name='username']")).sendKeys("Admin");

	driver.findElement(By.xpath("//*[@type='submit']")).click();

	String msg = driver

	.findElement(By.xpath("//*[@class='oxd-text oxd-text--h6 orangehrm-forgot-password-title']"))

	.getText();

	String expmsg = "Reset Password link sent successfully";

	Assert.assertEquals(msg, expmsg, "Test failed passwod reset link is not sent to mail");

	}

	@Test(priority = 4)

	public void TC4() {

	driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

	driver.findElement(By.xpath("/html/body/div/div[1]/div/div[1]/div/div[2]/div[2]/form/div[4]/p")).click();

	driver.findElement(By.xpath("//input[@name='username']")).sendKeys("Admin1");

	driver.findElement(By.xpath("//*[@type='submit']")).click();

	String msg = driver

	.findElement(By.xpath("//*[@class='oxd-text oxd-text--h6 orangehrm-forgot-password-title']"))

	.getText();

	String expmsg = "Reset Password link sent successfully";

	Assert.assertNotEquals(msg, expmsg,

	"Test failed passwod reset link is sent to mail eaven though using invalid userID");

	}

	@AfterMethod

	public void close() {

	driver.quit();

	}
}
