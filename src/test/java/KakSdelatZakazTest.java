import org.junit.jupiter.api.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class KakSdelatZakazTest {

    public WebDriver driver = new ChromeDriver();

//    @BeforeEach
//    public WebDriver getDriver() {
//        return new ChromeDriver();
//    }

    @AfterEach
    public void quitDriver() {
        driver.quit();
    }

    @Test
    @DisplayName("Проверка названия ссылки")
    public void chekNameTest() {
        driver.manage().window().maximize();
        driver.get("https://www.wildberries.ru/");
        WebElement link = driver.findElement(Footer.KAK_SDELAT_ZAKAZ);
        Assertions.assertEquals("Как сделать заказ", link.getText(), "текст не соответствует эталону");
    }
}
