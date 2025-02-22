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

    //поле для ввода номера телефона
    private final By phoneNumberFieldLocator = By.xpath("//*[@id=\"connection-phone\"]");

    //поле для ввода суммы
    private final By sumFieldLocator = By.xpath("//*[@id=\"connection-sum\"]");

    //поле для ввода email
    private final By emailFieldLocator = By.xpath("//*[@id=\"connection-email\"]");

    //кнопка продолжить в форме оплаты
    private final By continueButton = By.xpath("//*[@id=\"pay-connection\"]/button");

    //iframe оплаты
    private final By iframePaymentLocator = By.xpath("//iframe[contains(@class, 'bepaid-iframe')]");

    public MTSMainPage(WebDriver webDriver) {
        this.webDriver = webDriver;
        this.wait = new WebDriverWait(webDriver,Duration.ofSeconds(10));
    }

    public WebElement getOnlineReplenishmentElement() {
        return wait.until(ExpectedConditions.presenceOfElementLocated(onlineReplenishmentLocator));
    }

    public List<WebElement> getImageElements(){
        return new ArrayList<>(Arrays.asList(
                wait.until(ExpectedConditions.presenceOfElementLocated(partnersImageLocator.get(0))),
                wait.until(ExpectedConditions.presenceOfElementLocated(partnersImageLocator.get(1))),
                wait.until(ExpectedConditions.presenceOfElementLocated(partnersImageLocator.get(2))),
                wait.until(ExpectedConditions.presenceOfElementLocated(partnersImageLocator.get(3))),
                wait.until(ExpectedConditions.presenceOfElementLocated(partnersImageLocator.get(4)))
        ));
    }

    public void clickMoreAboutServiceLink(){
        wait.until(ExpectedConditions.elementToBeClickable(moreAboutServiceLinkLocator)).click();
        wait.until(ExpectedConditions.urlContains("/poryadok-oplaty-i-bezopasnost-internet-platezhey"));
    }

    public MTSMainPage typeAllData(){
        WebElement webElement = wait.until(ExpectedConditions.presenceOfElementLocated(phoneNumberFieldLocator));
        webElement.click();
        webElement.sendKeys("297777777");
        webElement = wait.until(ExpectedConditions.presenceOfElementLocated(sumFieldLocator));
        webElement.click();
        webElement.sendKeys("100");
        webElement = wait.until(ExpectedConditions.presenceOfElementLocated(emailFieldLocator));
        webElement.click();
        webElement.sendKeys("test@gmail.com");
        return this;
    }

    public MTSPaymentPage typeAllDataAndSubmit(){
        typeAllData();
        wait.until(ExpectedConditions.elementToBeClickable(continueButton)).submit();
        return new MTSPaymentPage(webDriver.switchTo().frame(wait.until(ExpectedConditions.visibilityOfElementLocated(iframePaymentLocator))),wait);
    }

}
