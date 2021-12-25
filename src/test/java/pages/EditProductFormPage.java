package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class EditProductFormPage {
    private WebDriver browser;

    public EditProductFormPage(WebDriver browser) {
        this.browser = browser;
    }

    public String getSucessMessage() {
        return browser.findElement(By.cssSelector(".toast.rounded")).getText();
    }
}