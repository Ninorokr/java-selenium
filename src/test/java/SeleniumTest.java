import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;

public class SeleniumTest {

    @BeforeClass
    public static void setupClass(){
//        WebDriverManager.chromedriver().setup();
        System.setProperty("webdriver.edge.driver", "resources/msedgedriver.exe");
    }

    @Test
    public void edgeTest() throws InterruptedException{
        WebDriver driver = new EdgeDriver();
        driver.get("https://the-internet.herokuapp.com/");
//        Thread.sleep(3000);
        driver.quit();
    }

    @Test
    public void cypressTest() throws InterruptedException{
        WebDriver driver = new EdgeDriver();
        driver.get("https://example.cypress.io/");
//        Thread.sleep(3000);
        driver.quit();
    }

    @Test
    public void shoppingCartTest() throws InterruptedException{
        WebDriver driver = new EdgeDriver();
        driver.get("https://react-shopping-cart-67954.firebaseapp.com/");
//        Thread.sleep(3000);
        driver.quit();
    }
}
