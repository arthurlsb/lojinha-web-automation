package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.pagefactory.ByAll;

public class LoginPage {
    private WebDriver browser;

    public LoginPage(WebDriver browser) {
        this.browser = browser;
    }

    public LoginPage informUser(String user) {
        this.browser.findElement(ByAll.cssSelector("label[for=usuario]")).click();
        this.browser.findElement(ByAll.id("usuario")).sendKeys(user);

        return this;
    }

    public LoginPage informPassword(String password) {
        this.browser.findElement(ByAll.cssSelector("label[for=senha]")).click();
        this.browser.findElement(ByAll.id("senha")).sendKeys(password);

        return this;
    }

    public ProductListPage submitLoginForm() {
        this.browser.findElement(ByAll.name("action")).click();

        return new ProductListPage(this.browser);
    }
}
