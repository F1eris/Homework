import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.*;
import org.openqa.selenium.By;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.text.ParseException;
import java.time.Duration;

public class ChromeTests {
    WebDriver webDriver;

    @BeforeAll
    static void setupAll() {
        WebDriverManager.chromedriver().setup();
    }

    @BeforeEach
    void setup() throws ParseException {
        webDriver = new ChromeDriver();
        webDriver.get("https://www.mts.by/");
        //добавляем куки, чтобы сайт постоянно не запрашивал подтверждение
        webDriver.manage().addCookie(new Cookie("BITRIX_SM_COOKIES_AGREEMENT", "yes", ".www.mts.by", "/", null));
        webDriver.navigate().refresh();
    }

    @AfterEach
    void teardown() {
        webDriver.quit();
    }

    @Test
    @DisplayName("1. Проверить название указанного блока")
    void test1() {
        final String expected = "Онлайн пополнение\n" + "без комиссии";

        WebElement webElement = driverWait("//*[@id=\"pay-section\"]/div/div/div[2]/section/div/h2");
        Assertions.assertEquals(expected, webElement.getText(), "Элементы не совпадают!");
    }

    @Test
    @DisplayName("2. Проверить наличие логотипов платежных систем")
    void test2() {
        driverWait("//*[@id=\"pay-section\"]/div/div/div[2]/section/div/div[2]");
        final WebElement image1 = webDriver.findElement(By.xpath("//*[@id=\"pay-section\"]/div/div/div[2]/section/div/div[2]/ul/li[1]/img"));
        final WebElement image2 = webDriver.findElement(By.xpath("//*[@id=\"pay-section\"]/div/div/div[2]/section/div/div[2]/ul/li[2]/img"));
        final WebElement image3 = webDriver.findElement(By.xpath("//*[@id=\"pay-section\"]/div/div/div[2]/section/div/div[2]/ul/li[3]/img"));
        final WebElement image4 = webDriver.findElement(By.xpath("//*[@id=\"pay-section\"]/div/div/div[2]/section/div/div[2]/ul/li[4]/img"));
        final WebElement image5 = webDriver.findElement(By.xpath("//*[@id=\"pay-section\"]/div/div/div[2]/section/div/div[2]/ul/li[5]/img"));

        Assertions.assertAll("Проверка изображений",
                () -> Assertions.assertEquals("Visa", image1.getDomAttribute("alt"), "Изображение \"Visa\" не совпадает"),
                () -> Assertions.assertEquals("Verified By Visa", image2.getDomAttribute("alt"), "Изображение \"Verified By Visa\" не совпадает"),
                () -> Assertions.assertEquals("MasterCard", image3.getDomAttribute("alt"), "Изображение \"MasterCard\" не совпадает"),
                () -> Assertions.assertEquals("MasterCard Secure Code", image4.getDomAttribute("alt"), "Изображение \"MasterCard Secure Code\" не совпадает"),
                () -> Assertions.assertEquals("Белкарт", image5.getDomAttribute("alt"), "Изображение \"Белкарт\" не совпадает"),

                () -> Assertions.assertTrue(image1.isDisplayed(), "Изображение \"Visa\" не отображается"),
                () -> Assertions.assertTrue(image2.isDisplayed(), "Изображение \"Verified By Visa\" не отображается"),
                () -> Assertions.assertTrue(image3.isDisplayed(), "Изображение \"MasterCard\" не отображается"),
                () -> Assertions.assertTrue(image4.isDisplayed(), "Изображение \"MasterCard Secure Code\" не отображается"),
                () -> Assertions.assertTrue(image5.isDisplayed(), "Изображение \"Белкарт\" не отображается")
        );
    }

    @Test
    @DisplayName("3. Проверить работу ссылки \"Подробнее о сервисе\"")
    void test3() {
        final String expected = "https://www.mts.by/help/poryadok-oplaty-i-bezopasnost-internet-platezhey/";

        WebElement webElement = driverWait("//*[@id=\"pay-section\"]/div/div/div[2]/section/div/a");
        webElement.click();
        new WebDriverWait(webDriver, Duration.ofSeconds(10)).until(ExpectedConditions.urlContains("/poryadok-oplaty-i-bezopasnost-internet-platezhey"));
        Assertions.assertEquals(expected, webDriver.getCurrentUrl(), "URL не совпадает с ожидаемым");
    }

    @Test
    @DisplayName("4. Заполнить поля и проверить работу кнопки...")
    void test4() {
        final String expected = "Оплата: Услуги связи Номер:375297777777";

        WebElement webElement = driverWait("//*[@id=\"connection-phone\"]");
        webElement.click();
        webElement.sendKeys("297777777");
        webElement = webDriver.findElement(By.xpath("//*[@id=\"connection-sum\"]"));
        webElement.click();
        webElement.sendKeys("100");
        webElement = webDriver.findElement(By.xpath("//*[@id=\"connection-email\"]"));
        webElement.sendKeys("test@gmail.com");
        webElement = webDriver.findElement(By.xpath("//*[@id=\"pay-connection\"]/button"));
        Assertions.assertTrue(webElement.isEnabled());
        webElement.click();

        //переход на iframe оплаты
        WebElement iframe = new WebDriverWait(webDriver, Duration.ofSeconds(10))
                .until(ExpectedConditions.presenceOfElementLocated(By.xpath("//iframe[contains(@class, 'bepaid-iframe')]")));
        webDriver.switchTo().frame(iframe);

        webElement = driverWait("/html/body/app-root/div/div/div/app-payment-container/section/div/div/div[2]");
        new WebDriverWait(webDriver, Duration.ofSeconds(10)).until(ExpectedConditions.textToBePresentInElement(webElement, expected));
        Assertions.assertEquals(expected, webElement.getText());
    }

    /**
     * Метод ожидания загрузки элемента по xPath с таймаутом 10 секунд
     *
     * @param xPathExpression xPath, по которому идет ожидание загрузки
     * @return загруженный WebElement
     */
    private WebElement driverWait(String xPathExpression) {
        return new WebDriverWait(webDriver, Duration.ofSeconds(10))
                .until(ExpectedConditions.presenceOfElementLocated(By.xpath(xPathExpression)));
    }
}
