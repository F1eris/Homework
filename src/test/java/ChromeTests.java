import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.*;
import org.openqa.selenium.By;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import pageObjects.*;

import java.time.Duration;
import java.util.List;

public class ChromeTests {
    private WebDriver webDriver;
    private MTSMainPage mtsMainPage;

    @BeforeAll
    static void setupAll() {
        WebDriverManager.chromedriver().setup();
    }

    @BeforeEach
    void setup(){
        webDriver = new ChromeDriver();
        webDriver.get("https://www.mts.by/");
        //добавляем куки, чтобы сайт постоянно не запрашивал подтверждение
        webDriver.manage().addCookie(new Cookie("BITRIX_SM_COOKIES_AGREEMENT", "yes", ".www.mts.by", "/", null));
        webDriver.navigate().refresh();

        //создаем pageObject
        mtsMainPage = new MTSMainPage(webDriver);
    }

    @AfterEach
    void teardown() {
        webDriver.quit();
    }

    @Test
    @DisplayName("1. Проверить название указанного блока")
    void test1() {
        final String expected = "Онлайн пополнение\n" + "без комиссии";

        Assertions.assertEquals(expected, mtsMainPage.getOnlineReplenishmentElement().getText(), "Элементы не совпадают!");
    }

    @Test
    @DisplayName("2. Проверить наличие логотипов платежных систем")
    void test2() {
        List<WebElement> imageElements = mtsMainPage.getImageElements();
        final WebElement image1 = imageElements.get(0);
        final WebElement image2 = imageElements.get(1);
        final WebElement image3 = imageElements.get(2);
        final WebElement image4 = imageElements.get(3);
        final WebElement image5 = imageElements.get(4);


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

        mtsMainPage.clickMoreAboutServiceLink();
        Assertions.assertEquals(expected, webDriver.getCurrentUrl(), "URL не совпадает с ожидаемым");
    }

    @Test
    @DisplayName("4. Заполнить поля и проверить работу кнопки...")
    void test4() {
        final String expected = "Оплата: Услуги связи Номер:375297777777";

        Assertions.assertEquals(expected, mtsMainPage.typeAllDataAndSubmit().getPaymentInfoTextElement().getText());
    }

    /**
     * Метод ожидания загрузки элемента по xPath с таймаутом 10 секунд
     *
     * @param xPathExpression xPath, по которому идет ожидание загрузки
     * @return загруженный WebElement
     * @deprecated - ожидание загрузки элементов не должно находится в тестовом классе
     */
    @Deprecated
    private WebElement oldDriverWait(String xPathExpression) {
        return new WebDriverWait(webDriver, Duration.ofSeconds(10))
                .until(ExpectedConditions.presenceOfElementLocated(By.xpath(xPathExpression)));
    }

}
