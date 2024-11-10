import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.chrome.ChromeDriver;

public class LoginTest {
	
	private static final String URL_LOGIN = "http://localhost:8080/login";
	private ChromeDriver browser;
	
	/*
	@BeforeAll
	public static void beforeAll() {
		System.setProperty("webdriver.chrome.driver","drivers\\chromedriver");
	}*/

	@BeforeEach
	public void beforeEach() {
		this.browser = new ChromeDriver();
		this.browser.navigate().to(URL_LOGIN);
	}
    
	@AfterEach
	public void afterEach() {
		this.browser.quit();
	}
	
	
	@Test
	public void efetuarLoginComDadosValidos() {
        browser.findElement(By.id("username")).sendKeys("fulano");
        browser.findElement(By.id("password")).sendKeys("pass");
        browser.findElement(By.id("login-form")).submit();
        // Verificando se logou com sucesso. Não pode estar na URL abaixo, e verificar se o nome é Fulano
        Assertions.assertFalse(browser.getCurrentUrl().equals(URL_LOGIN));
        Assertions.assertEquals("fulano", browser.findElement(By.id("login-success")).getText());
	}
	
	@Test
	public void efetuarLoginComDadosInvalidos() {
        browser.findElement(By.id("username")).sendKeys("asfasda");
        browser.findElement(By.id("password")).sendKeys("asda");
        browser.findElement(By.id("login-form")).submit();
        Assertions.assertTrue(browser.getCurrentUrl().equals("http://localhost:8080/login?error"));
        Assertions.assertTrue(browser.getPageSource().contains("Usuário e senha inválidos."));
        Assertions.assertThrows(NoSuchElementException.class, ()-> browser.findElement(By.id("login-success")).getText());
	}
	
	@Test
	public void naoDeveAcessarPaginaRestritaSemEstarLogado() {
		browser.navigate().to("http://localhost:8080/leiloes/2");
		Assertions.assertTrue(browser.getCurrentUrl().equals("http://localhost:8080/login"));
		Assertions.assertFalse(browser.getPageSource().contains("Usuário e senha inválidos."));
	}

}
