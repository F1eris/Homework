package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MTSPaymentPage {
    private final WebDriver webDriver;
    private final WebDriverWait wait;

    public MTSPaymentPage(WebDriver webDriver, WebDriverWait wait) {
        this.webDriver = webDriver;
        this.wait = wait;
    }

    private final By paymentInfoTextLocator = By.xpath("/html/body/app-root/div/div/div/app-payment-container/section/div/div/div[2]/span");

    private final By sumTextLocator = By.xpath("/html/body/app-root/div/div/div/app-payment-container/section/div/div/div[1]/span[1]");

    private final By sumButtonLocator = By.xpath("/html/body/app-root/div/div/div/app-payment-container/section/div/app-card-page/div/div[1]/button");

    private final List<By> cardFieldLocators = new ArrayList<>(Arrays.asList(
            By.xpath("/html/body/app-root/div/div/div/app-payment-container/section/div/app-card-page/div/div[1]/app-card-input/form/div[1]/div[1]/app-input/div/div/div[1]/label"),
            By.xpath("/html/body/app-root/div/div/div/app-payment-container/section/div/app-card-page/div/div[1]/app-card-input/form/div[1]/div[2]/div[1]/app-input/div/div/div[1]/label"),
            By.xpath("/html/body/app-root/div/div/div/app-payment-container/section/div/app-card-page/div/div[1]/app-card-input/form/div[1]/div[2]/div[3]/app-input/div/div/div[1]/label"),
            By.xpath("/html/body/app-root/div/div/div/app-payment-container/section/div/app-card-page/div/div[1]/app-card-input/form/div[1]/div[3]/app-input/div/div/div[1]/label")
    ));

    private final List<By> cardIconLocators = new ArrayList<>(Arrays.asList(
            By.xpath("/html/body/app-root/div/div/div/app-payment-container/section/div/app-card-page/div/div[1]/app-card-input/form/div[1]/div[1]/app-input/div/div/div[2]/div/div/img[1]"),
            By.xpath("/html/body/app-root/div/div/div/app-payment-container/section/div/app-card-page/div/div[1]/app-card-input/form/div[1]/div[1]/app-input/div/div/div[2]/div/div/img[2]"),
            By.xpath("/html/body/app-root/div/div/div/app-payment-container/section/div/app-card-page/div/div[1]/app-card-input/form/div[1]/div[1]/app-input/div/div/div[2]/div/div/img[3]"),
            By.xpath("/html/body/app-root/div/div/div/app-payment-container/section/div/app-card-page/div/div[1]/app-card-input/form/div[1]/div[1]/app-input/div/div/div[2]/div/div/div/img[1]"),
            By.xpath("/html/body/app-root/div/div/div/app-payment-container/section/div/app-card-page/div/div[1]/app-card-input/form/div[1]/div[1]/app-input/div/div/div[2]/div/div/div/img[2]")
    ));

    public WebElement getPaymentInfoTextElement() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(paymentInfoTextLocator));
    }

    public WebElement getSumTextElement() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(sumTextLocator));
    }

    public WebElement getSumButtonElement() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(sumButtonLocator));
    }

    public List<WebElement> getFieldWebElements() {
        return new ArrayList<>(Arrays.asList(
                wait.until(ExpectedConditions.visibilityOfElementLocated(cardFieldLocators.get(0))),
                wait.until(ExpectedConditions.visibilityOfElementLocated(cardFieldLocators.get(1))),
                wait.until(ExpectedConditions.visibilityOfElementLocated(cardFieldLocators.get(2))),
                wait.until(ExpectedConditions.visibilityOfElementLocated(cardFieldLocators.get(3)))
        ));
    }

    public List<WebElement> getIconWebElements() {
        return new ArrayList<>(Arrays.asList(
                wait.until(ExpectedConditions.visibilityOfElementLocated(cardIconLocators.get(0))),
                wait.until(ExpectedConditions.visibilityOfElementLocated(cardIconLocators.get(1))),
                wait.until(ExpectedConditions.visibilityOfElementLocated(cardIconLocators.get(2))),
                wait.until(ExpectedConditions.visibilityOfElementLocated(cardIconLocators.get(3))),
                wait.until(ExpectedConditions.visibilityOfElementLocated(cardIconLocators.get(4)))
        ));
    }
}
