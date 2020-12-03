package utilities;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class ElementClass {

    private WebDriver driver;
    private WebElement element;
    private WebDriverWait wait;
    private By by;
    By optionList = By.cssSelector("mat-option[role='option']");

    public static void open(String url){
        new ElementClass().getUrl(url);
    }
    public void getUrl(String url){
        driver.get(url);
    }


    public static ElementClass $(By by){
        return new ElementClass(by);
    }

    public static ElementClass $(WebElement e){
        return new ElementClass(e);
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

        //wait.until(ExpectedConditions.presenceOfElementLocated(by));
        //element = driver.findElement(by);

    }

    private ElementClass(WebElement e){
        this();
        this.element = e;
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
                .executeScript("arguments[0].scrollIntoView(true);", element);
        return this;
    }

    public ElementClass shouldBe(Condition cons){
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

    public ElementClass waitUntil(Condition cons, long seconds){
        WebDriverWait w = new WebDriverWait(driver,  seconds);
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

    public WebElement getElement(){
        return element;
    }


    public ElementClass selectOption(String text){
        element.click();
        List<WebElement> list = driver.findElements(optionList);
        for (WebElement e : list) {
            if (e.getText().trim().equalsIgnoreCase(text)){
                e.click();
                break;
            }
        }
        return this;
    }

    public ElementClass selectOption(int option){
        element.click();
        List<WebElement> list = driver.findElements(optionList);
        if (option<0) option = 0;
        if (option>=list.size()) option = list.size()-1;
        list.get(option).click();
        return this;
    }

    public ElementClass selectOption(){
        element.click();
        List<WebElement> list = driver.findElements(optionList);
        int option = new Random().nextInt(list.size());
        list.get(option).click();
        return this;
    }

}
