package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.pagefactory.ByAll;

public class NewProductFormPage {
    private WebDriver browser;

    public NewProductFormPage(WebDriver browser) {
        this.browser = browser;
    }

    public NewProductFormPage informProductName(String productName) {
        this.browser.findElement(ByAll.id("produtonome")).sendKeys(productName);

        return this;
    }

    public NewProductFormPage informProductValue(String productValue) {
        this.browser.findElement(ByAll.id("produtovalor")).sendKeys(productValue);

        return this;
    }

    public NewProductFormPage informProductColors(String productColors) {
        this.browser.findElement(ByAll.id("produtocores")).sendKeys(productColors);

        return this;
    }

    public EditProductFormPage submitProductForm() {
        this.browser.findElement(ByAll.name("action")).click();

        return new EditProductFormPage(this.browser);
    }

    public ProductListPage submitProductFormWithError() {
        this.browser.findElement(ByAll.name("action")).click();

        return new ProductListPage(this.browser);
    }

}
