import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.*;
import org.junit.runners.MethodSorters;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static org.junit.Assert.assertTrue;

@FixMethodOrder
public class FirstTryTest {

    WebDriver driver = new ChromeDriver();

    @Before
    public void setUp(){
        WebDriverManager.chromedriver().setup();
    }

    @Test
    public void navigate() throws InterruptedException{
        By loginLocator = By.linkText("Login");
        By userNameLinkLocator = By.id("username");
        By passwordLinkLocator = By.id("password");
        By loginLinkLocator = By.id("Login");
        By submitVerificationLocator = By.id("save");

        By correspondenciaLocator = By.xpath("//a/span[contains(text(), 'Correspondencia Digital (pendiente)')]/..");
//        By orderByFechaCreacionLocator = By.cssSelector("css=th:nth-child(16) > a > strong");
        By orderByFechaCreacionLocator = By.xpath("//th/a/strong[text()='Fecha de creación']/..");
        By btnExportarDetallesLocator = By.name("csvsetup");
        By btnExportarLocator = By.name("export");
        By btnListoLocator = By.name("cancel");

        By iFrameCorrespondenciaLocator = By.xpath("//div[@id='scc-st-0']/div/iframe"); //Podría usarse sólo para la primera vez que se ingresa al sitio

        driver.get("https://www.salesforce.com");

        System.out.print("Cargando landing page...");
        driver.findElement(loginLocator).click();
        System.out.println(" OK");
        System.out.print("Cargando formulario de login");
        esperar(3);
        driver.findElement(userNameLinkLocator).sendKeys("mensajeria@enel.com");
        driver.findElement(passwordLinkLocator).sendKeys("09*Ago*2022*");
        driver.findElement(loginLinkLocator).submit();
        System.out.println(" OK");
        System.out.print("Esperando al código de verificación");
        esperar(15);

//        for(int i = 15; i >= 0; i--) {
//            Thread.sleep(1000);
//            if (i > 9) {
//                System.out.println("Waiting for verification code... 00:" + i);
//            } else {
//                System.out.println("Waiting for verification code... 00:0" + i);
//            }
//        }

        driver.findElement(submitVerificationLocator).click();
        System.out.println(" OK");
        System.out.print("Cargando página principal");
        esperar(10);

        driver.switchTo().frame(0);
        driver.findElement(correspondenciaLocator).click();
        System.out.println(" OK");
        System.out.print("Cargando informe de \"Correspondencia Digital (pendiente)\"");
        esperar(45);

        driver.switchTo().defaultContent();
        System.out.println(driver.findElements(By.tagName("iframe")).size());
        driver.switchTo().frame(1);
        System.out.println(" OK");
        System.out.print("Ordenando por fecha de creación");
        driver.findElement(orderByFechaCreacionLocator);
        esperar(30);
        driver.findElement(btnExportarDetallesLocator).click();
        System.out.println(" OK");
        System.out.print("Cambiando a pantalla de \"Exportar detalles\"");
        esperar(5);
        driver.findElement(btnExportarLocator).click();
        System.out.println(" OK");
        System.out.print("Exportando .xlsx");
        esperar(30);
        driver.findElement(btnListoLocator).click();
        System.out.println(" OK");
        System.out.print("Regresando a informe de \"Correspondencia Digital (pendiente)\"");
//        esperar(30);


    }

    public void esperar(int seconds) throws InterruptedException{
        System.out.println();
        for(int i = seconds; i >= 0; i--) {
            Thread.sleep(1000);
            if (i > 9) {
                System.out.println("Esperando por... :" + i + " segundos");
            } else {
                System.out.println("Esperando por... :0" + i + " segundos");
            }
        }
    }
}


