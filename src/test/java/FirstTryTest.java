import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static org.junit.Assert.assertTrue;

public class FirstTryTest {

    WebDriver driver = new ChromeDriver();

    @BeforeClass
    public static void setupClass(){
        WebDriverManager.chromedriver().setup();
    }

    @Test
    public void navigate() throws InterruptedException{
        By loginLocator = By.linkText("Login");
        By userNameLinkLocator = By.id("username");
        By passwordLinkLocator = By.id("password");
        By loginLinkLocator = By.id("Login");
        By submitVerificationLocator = By.id("save");
//        By correspondenciaLocator = By.xpath("//*[@id=\"00O1o000005aVRP_NAME\"]/div[2]/a");
//        By correspondenciaLocator = By.cssSelector("#\\30 0O1o000005aVRP_NAME > div.nameFieldContainer.descrContainer > a");
//        By frameLocator = By.xpath("//iframe");

        driver.get("https://www.salesforce.com");

        driver.findElement(loginLocator).click();
        Thread.sleep(3000);
        driver.findElement(userNameLinkLocator).sendKeys("mensajeria@enel.com");
        driver.findElement(passwordLinkLocator).sendKeys("09*Ago*2022*");
        driver.findElement(loginLinkLocator).submit();

        for(int i = 25; i >= 0; i--) {
            Thread.sleep(1000);
            if (i > 9) {
                System.out.println("Waiting for verification code... 00:" + i);
            } else {
                System.out.println("Waiting for verification code... 00:0" + i);
            }
        }
        driver.findElement(submitVerificationLocator).click();
        Thread.sleep(10000);
//        driver.switchTo().defaultContent();

//        WebDriverWait wait = new WebDriverWait(driver, 10);
//        WebElement element = wait.until(ExpectedConditions.presenceOfElementLocated(correspondenciaLocator));
//        assertTrue(element.isDisplayed());


//        driver.findElement(frameLocator).click();

//        driver.findElement(correspondenciaLocator).click();
    }

    @Test
    public void clickImpossibleLink(){
        driver.switchTo().frame(0);
        driver.findElement(By.xpath("//a/span[contains(text(), 'Correspondencia Digital (pendiente)')]/..")).click();
    }
}


