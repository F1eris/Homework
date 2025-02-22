package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class MTSMainPage {
    private final WebDriver webDriver;
    private final WebDriverWait wait;

    //Онлайн пополнение без комиссии
    private final By onlineReplenishmentLocator = By.xpath("//*[@id=\"pay-section\"]/div/div/div[2]/section/div/h2");

    //Изображения партнеров оплаты
    private final ArrayList<By> partnersImageLocator = new ArrayList<>(Arrays.asList(
            By.xpath("//*[@id=\"pay-section\"]/div/div/div[2]/section/div/div[2]/ul/li[1]/img"),
            By.xpath("//*[@id=\"pay-section\"]/div/div/div[2]/section/div/div[2]/ul/li[2]/img"),
            By.xpath("//*[@id=\"pay-section\"]/div/div/div[2]/section/div/div[2]/ul/li[3]/img"),
            By.xpath("//*[@id=\"pay-section\"]/div/div/div[2]/section/div/div[2]/ul/li[4]/img"),
            By.xpath("//*[@id=\"pay-section\"]/div/div/div[2]/section/div/div[2]/ul/li[5]/img")
    ));

    //ссылка Подробнее о сервисе
    private final By moreAboutServiceLinkLocator = By.xpath("//*[@id=\"pay-section\"]/div/div/div[2]/section/div/a");

    //ПОЛЯ ДЛЯ УСЛУГ СВЯЗИ
    ArrayList<By> commServiceFieldLocators = new ArrayList<>(Arrays.asList(
            By.xpath("//*[@id=\"connection-phone\"]"),
            By.xpath("//*[@id=\"connection-sum\"]"),
            By.xpath("//*[@id=\"connection-email\"]"),
            By.xpath("//*[@id=\"pay-connection\"]/button")
    ));

    //ПОЛЯ ДЛЯ ДОМАШНЕГО ИНТЕРНЕТА
    ArrayList<By> homeInternetFieldLocators = new ArrayList<>(Arrays.asList(
            By.xpath("//*[@id=\"internet-phone\"]"),
            By.xpath("//*[@id=\"internet-sum\"]"),
            By.xpath("//*[@id=\"internet-email\"]"),
            By.xpath("//*[@id=\"pay-internet\"]/button")
    ));

    //ПОЛЯ ДЛЯ РАССРОЧКИ
    ArrayList<By> installmentFieldLocators = new ArrayList<>(Arrays.asList(
            By.xpath("//*[@id=\"score-instalment\"]"),
            By.xpath("//*[@id=\"instalment-sum\"]"),
            By.xpath("//*[@id=\"instalment-email\"]"),
            By.xpath("//*[@id=\"pay-instalment\"]/button")
    ));

    //ПОЛЯ ДЛЯ ЗАДОЛЖЕННОСТИ
    ArrayList<By> debtFieldLocators = new ArrayList<>(Arrays.asList(
            By.xpath("//*[@id=\"score-arrears\"]"),
            By.xpath("//*[@id=\"arrears-sum\"]"),
            By.xpath("//*[@id=\"arrears-email\"]"),
            By.xpath("//*[@id=\"pay-arrears\"]/button")
    ));

    //iframe оплаты
    private final By iframePaymentLocator = By.xpath("//iframe[contains(@class, 'bepaid-iframe')]");

    //Селектор в форме онлнайн пополнения
    private final By paymentTypeSelector = By.xpath("//*[@id=\"pay-section\"]/div/div/div[2]/section/div/div[1]/div[1]/div[2]/button");


    public MTSMainPage(WebDriver webDriver) {
        this.webDriver = webDriver;
        this.wait = new WebDriverWait(webDriver, Duration.ofSeconds(10));
    }

    public WebElement getOnlineReplenishmentElement() {
        return wait.until(ExpectedConditions.presenceOfElementLocated(onlineReplenishmentLocator));
    }

    public List<WebElement> getImageElements() {
        return new ArrayList<>(Arrays.asList(
                wait.until(ExpectedConditions.presenceOfElementLocated(partnersImageLocator.get(0))),
                wait.until(ExpectedConditions.presenceOfElementLocated(partnersImageLocator.get(1))),
                wait.until(ExpectedConditions.presenceOfElementLocated(partnersImageLocator.get(2))),
                wait.until(ExpectedConditions.presenceOfElementLocated(partnersImageLocator.get(3))),
                wait.until(ExpectedConditions.presenceOfElementLocated(partnersImageLocator.get(4)))
        ));
    }

    public void clickMoreAboutServiceLink() {
        wait.until(ExpectedConditions.elementToBeClickable(moreAboutServiceLinkLocator)).click();
        wait.until(ExpectedConditions.urlContains("/poryadok-oplaty-i-bezopasnost-internet-platezhey"));
    }

    public MTSMainPage typeAllData() {
        WebElement webElement = wait.until(ExpectedConditions.presenceOfElementLocated(commServiceFieldLocators.get(0)));
        webElement.click();
        webElement.sendKeys("297777777");
        webElement = wait.until(ExpectedConditions.presenceOfElementLocated(commServiceFieldLocators.get(1)));
        webElement.click();
        webElement.sendKeys("100");
        webElement = wait.until(ExpectedConditions.presenceOfElementLocated(commServiceFieldLocators.get(2)));
        webElement.click();
        webElement.sendKeys("test@gmail.com");
        return this;
    }

    public MTSPaymentPage typeAllDataAndSubmit() {
        typeAllData();
        wait.until(ExpectedConditions.elementToBeClickable(commServiceFieldLocators.get(3))).submit();
        return new MTSPaymentPage(webDriver.switchTo().frame(wait.until(ExpectedConditions.visibilityOfElementLocated(iframePaymentLocator))), wait);
    }

    /**
     * Выбирает указанный PaymentType и нажимает на него
     */
    public void selectPaymentType(PaymentType paymentType) {
        wait.until(ExpectedConditions.elementToBeClickable(paymentTypeSelector)).click();
        wait.until(ExpectedConditions.elementToBeClickable(paymentType.getLocator())).click();
    }

    /**
     * Для определенного типа оплаты (PaymentType) создает список WebElement через их локаторы
     *
     * @param paymentType тип оплаты
     * @return List of WebElement
     * @see PaymentType
     */
    public List<WebElement> getElementsByPaymentType(PaymentType paymentType) {
        List<By> list = new ArrayList<>();
        switch (paymentType) {
            case COMM_SERVICES:
                list = commServiceFieldLocators;
                break;
            case HOME_INTERNET:
                list = homeInternetFieldLocators;
                break;
            case INSTALLMENT:
                list = installmentFieldLocators;
                break;
            case DEBT:
                list = debtFieldLocators;
                break;
        }
        selectPaymentType(paymentType);
        List<WebElement> webElements = new ArrayList<>();
        for (By locator : list) {
            webElements.add(wait.until(ExpectedConditions.visibilityOfElementLocated(locator)));
        }
        return webElements;
    }


    /**
     * Типы оплат в форме пополнения
     */
    public enum PaymentType {
        COMM_SERVICES("Услуги связи", By.xpath("//*[@id=\"pay-section\"]/div/div/div[2]/section/div/div[1]/div[1]/div[2]/ul/li[1]/p")),
        HOME_INTERNET("Домашний интернет", By.xpath("//*[@id=\"pay-section\"]/div/div/div[2]/section/div/div[1]/div[1]/div[2]/ul/li[2]/p")),
        INSTALLMENT("Рассрочка", By.xpath("//*[@id=\"pay-section\"]/div/div/div[2]/section/div/div[1]/div[1]/div[2]/ul/li[3]/p")),
        DEBT("Задолженность", By.xpath("//*[@id=\"pay-section\"]/div/div/div[2]/section/div/div[1]/div[1]/div[2]/ul/li[4]/p"));

        private final String description;
        private final By locator;

        PaymentType(String description, By locator) {
            this.description = description;
            this.locator = locator;
        }

        public String getDescription() {
            return description;
        }

        public By getLocator() {
            return locator;
        }

    }


}
