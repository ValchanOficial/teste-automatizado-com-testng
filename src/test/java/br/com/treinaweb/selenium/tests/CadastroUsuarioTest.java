package br.com.treinaweb.selenium.tests;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class CadastroUsuarioTest extends TreinaWebSeleniumTestBase{
	@BeforeMethod
	public void setupPage() {
		setUrl("file:///C:/site-teste/teste-selenium.html");
	}
	@Test
	public void verificarEmailsDiferentesTest() {
		getDriver().findElement(By.id("txb-email")).sendKeys("treinaweb@test.com");
		getDriver().findElement(By.id("txb-confirmar-email")).sendKeys("diferentetreinaweb@test.com");
		getDriver().findElement(By.id("btn-salvar")).click();
		Assert.assertTrue(getDriver().findElement(By.id("div-erro-cadastro-usuario")).isDisplayed());
		Assert.assertTrue(getDriver().findElement(By.id("div-val-email")).isDisplayed());
		Assert.assertEquals(getDriver().findElement(By.id("div-val-email")).getText(),"Os e-mails devem ser iguais");
	}
	@Test
	public void verificarNomeTest() {
		getDriver().findElement(By.id("txb-nome")).sendKeys("");
		getDriver().findElement(By.id("btn-salvar")).click();
		Assert.assertTrue(getDriver().findElement(By.id("div-erro-cadastro-usuario")).isDisplayed());
		Assert.assertTrue(getDriver().findElement(By.id("div-val-nome")).isDisplayed());
	}
}