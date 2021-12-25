package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.pagefactory.ByAll;

public class ProductListPage {
    private WebDriver browser;

    public ProductListPage(WebDriver browser) {
        this.browser = browser;
    }

    public NewProductFormPage openProductForm() {
        this.browser.findElement(ByAll.cssSelector("a[href*=novo]")).click();

        return new NewProductFormPage(this.browser);
    }

    public String getErrorMessage() {
        return browser.findElement(By.cssSelector(".toast.rounded")).getText();
    }
}
