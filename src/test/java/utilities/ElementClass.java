package utilities;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.ArrayList;
import java.util.List;

public class ElementClass {

    private WebDriver driver;
    private WebElement element;
    private WebDriverWait wait;
    private By by;


    public static void open(String url){
        new ElementClass().getUrl(url);

    }

    public static ElementClass $(By by){
        return new ElementClass(by);
    }


    public static List<WebElement> $$(By by){
        return new ElementClass(by).findElements();
    }

    private ElementClass(){
        driver = Driver.getDriver();
        driver.manage().window().maximize();
        wait = new WebDriverWait(driver, 5);
    }

    private ElementClass(By by){
        this();
        this.by = by;
        wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(by));
        element = driver.findElements(by).get(0);
    }

    public void getUrl(String url){
        driver.get(url);
    }

    public void click(){
        element.click();
    }

    public void pressEnter(){
        element.sendKeys(Keys.ENTER);
    }

    public void pressEscape(){
        element.sendKeys(Keys.ESCAPE);
    }

    public ElementClass setValue(String text){
        element.sendKeys(text);
        return this;
    }

    public ElementClass clear(){
        element.clear();
        return this;
    }

    public ElementClass scrollIntoView(){
        ((JavascriptExecutor) driver)
                .executeScript("arguments[0].scrollIntoView();", element);
        return this;
    }

    public ElementClass shouldBe(Conditions cons){
        switch (cons){
            case exist:
                wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(by));
                break;
            case visible:
            case appear:
                wait.until(ExpectedConditions.visibilityOf(element));
                break;
            case enable:
                wait.until(ExpectedConditions.elementToBeClickable(by));
                break;
        }
        return this;
    }

    public ElementClass waitUntil(Conditions cons, int seconds){
        WebDriverWait w = new WebDriverWait(driver,  seconds*1000);
        switch (cons){
            case exist:
                w.until(ExpectedConditions.presenceOfAllElementsLocatedBy(by));
                break;
            case visible:
            case appear:
                w.until(ExpectedConditions.visibilityOf(element));
                break;
            case enable:
                w.until(ExpectedConditions.elementToBeClickable(by));
                break;
        }
        return this;

    }

    public List<WebElement> findElements(){
        List<WebElement> elements = new ArrayList<WebElement>();
        return driver.findElements(by);
    }

    public WebElement getElement(){
        return element;
    }

}
