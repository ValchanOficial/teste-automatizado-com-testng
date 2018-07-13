package br.com.treinaweb.selenium.tests;

//import org.openqa.selenium.support.ui.ExpectedConditions;
//import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class UploadTest extends TreinaWebSeleniumTestBase{
	@BeforeMethod
	public void setupPage() {
		setUrl("http://demo.guru99.com/selenium/upload/");
	}
	@Test
	public void testUpload() {
		getDriver().findElement(By.id("uploadfile_0")).sendKeys("C:\\site-teste\\teste-selenium.html");
		getDriver().findElement(By.id("terms")).click();
		getDriver().findElement(By.name("send")).click();
		try {
			Thread.sleep(1000);
		}catch(Exception e) {
			System.out.println(e);
		}
		//WebDriverWait wait = new WebDriverWait(getDriver(), 60);
		//wait.until(ExpectedConditions.presenceOfElementLocated(By.id("res")));
		Assert.assertTrue(getDriver().findElement(By.id("res")).isDisplayed());
		Assert.assertTrue(getDriver().getPageSource().contains("successfully"));
		//Assert.assertEquals(getDriver().findElement(By.id("res")).getText(), "successfully");
	}
}