package br.com.treinaweb.selenium.tests;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

public class HelloSeleniumTest extends TreinaWebSeleniumTestBase{
	@Test
	public void testeHelloSelenium() {
		setUrl("file:///C:/site-teste/teste-selenium.html");
		getDriver().findElement(By.id("txb-nome")).sendKeys("TreinaWeb Cursos");
		String textInput = getDriver().findElement(By.id("txb-nome")).getAttribute("value");
		Assert.assertEquals(textInput, "TreinaWeb Cursos");
	}
}