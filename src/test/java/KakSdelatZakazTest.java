import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import static java.time.Duration.ofSeconds;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class KakSdelatZakazTest {

    public WebDriver driver;

    @BeforeEach
    public void setUpDriver() {
        WebDriverManager.chromedriver().setup(); // установка драйвера с помощью WebDriverManager
//        System.setProperty("chromedriver", "src/main/resources/chromedriver"); // установка драйвера вручную (файл драйвера находится в
//        проекте
        ChromeOptions options = new ChromeOptions(); // устанавливаем дополнительные настройки для браузера
        options.addArguments("--remote-allow-origins=*"); // без этого не работал хром. За что отвечает я хз, но без этого не работает
//        options.addArguments("start-maximized"); // установка максимального размера окна через настройки драйвера
//        options.setImplicitWaitTimeout(ofSeconds(10)); // установка неявного ожидания через настройки драйвера
        driver = new ChromeDriver(options); // собственно драйвер
    }

    @AfterEach
    public void quitDriver() {
        driver.quit();
    }

    @Test
    @DisplayName("Проверка названия ссылки") // ты используешь 18 java, а у нее есть проблемы с кодировкой. Поэтому при запуске видны
    // одни вопросы
    public void chekNameTest() throws InterruptedException {
        driver.manage().window().maximize(); // установка максимального размера окна
        driver.manage().timeouts().implicitlyWait(ofSeconds(10)); // установка неявного ожидания в 10 секунд
        driver.get("https://wildberries.ru/");
        WebElement link = driver.findElement(Footer.KAK_SDELAT_ZAKAZ);
        assertTrue(link.isDisplayed()); // проверяем, что наш элемент отображается
        assertEquals("Как сделать заказ", link.getText(), "текст не соответствует эталону");
        Thread.sleep(5000); // это лучше не использовать. Здесь для того, чтобы окно сразу не закрывалось
    }
}
