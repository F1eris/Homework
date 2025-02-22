package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class MTSPaymentPage {
    private final WebDriver webDriver;
    private final WebDriverWait wait;

    public MTSPaymentPage(WebDriver webDriver, WebDriverWait wait) {
        this.webDriver = webDriver;
        this.wait = wait;
    }

    private final By paymentInfoTextLocator = By.xpath("/html/body/app-root/div/div/div/app-payment-container/section/div/div/div[2]/span");

    public WebElement getPaymentInfoTextElement() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(paymentInfoTextLocator));
    }
}
