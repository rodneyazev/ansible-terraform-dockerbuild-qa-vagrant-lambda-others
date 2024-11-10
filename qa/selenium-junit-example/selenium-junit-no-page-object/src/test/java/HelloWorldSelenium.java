import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class HelloWorldSelenium {

	@Test
	public void hello() {
		WebDriver driver = new ChromeDriver();
        driver.navigate().to("http://localhost:8080/leiloes");
        driver.quit();
    }

}
