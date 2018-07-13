package br.com.treinaweb.selenium.tests;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class CadastroUsuarioTest extends TreinaWebSeleniumTestBase{
	@BeforeMethod
	public void setupPage() {
		setUrl("file:///C:/site-teste/teste-selenium.html");
	}
	@Test(priority = 2)
	public void verificarEmailsDiferentesTest() {
		getDriver().findElement(By.id("txb-email")).sendKeys("treinaweb@test.com");
		getDriver().findElement(By.id("txb-confirmar-email")).sendKeys("diferentetreinaweb@test.com");
		getDriver().findElement(By.id("btn-salvar")).click();
		Assert.assertTrue(getDriver().findElement(By.id("div-erro-cadastro-usuario")).isDisplayed());
		Assert.assertTrue(getDriver().findElement(By.id("div-val-email")).isDisplayed());
		Assert.assertEquals(getDriver().findElement(By.id("div-val-email")).getText(),"Os e-mails devem ser iguais");
	}
	@Test(priority = 1)
	public void verificarNomeTest() {
		getDriver().findElement(By.id("txb-nome")).sendKeys("");
		getDriver().findElement(By.id("btn-salvar")).click();
		Assert.assertTrue(getDriver().findElement(By.id("div-erro-cadastro-usuario")).isDisplayed());
		Assert.assertTrue(getDriver().findElement(By.id("div-val-nome")).isDisplayed());
		Assert.assertTrue(getDriver().findElement(By.id("txb-nome")).getAttribute("class").contains("is-invalid"));
	}
	
	@Test(priority = 3)
	public void verificarUsuarioPreenchidoTest() {
		getDriver().findElement(By.id("txb-nome")).sendKeys("teste");
		getDriver().findElement(By.id("txb-email")).sendKeys("teste@test.com");
		getDriver().findElement(By.id("txb-confirmar-email")).sendKeys("teste@test.com");
		getDriver().findElement(By.id("txb-senha")).sendKeys("senha123");
		getDriver().findElement(By.id("txb-confirmar-senha")).sendKeys("senha123");
		getDriver().findElement(By.cssSelector("label.custom-control:nth-child(3)")).click();
		new Select(getDriver().findElement(By.id("sel-estado"))).selectByValue("SP");
		getDriver().findElement(By.id("btn-salvar")).click();
		Assert.assertTrue(getDriver().findElement(By.id("div-sucesso-cadastro-usuario")).isDisplayed());
		Assert.assertEquals(getDriver().findElement(By.xpath("//table[@id='tbl-usuarios']/tbody/tr[1]/td[1]")).getText(), "teste");
	}
}