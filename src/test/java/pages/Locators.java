package pages;

import org.openqa.selenium.By;

public interface Locators {
    String url = "http://automationpractice.com";
    By loginLink = By.cssSelector("a.login");
    By username = By.cssSelector("input[id='email']");
    By password = By.cssSelector("input[id='passwd']");
    By loginSubmitButton = By.cssSelector("button[id='SubmitLogin']");
    By logoutLink = By.cssSelector("a[class='logout']");
    By prodList = By.cssSelector("ul.product_list >li");
    By searchInput = By.cssSelector("input[id='search_query_top']");
    By searcButton = By.cssSelector("button[name='submit_search']");
}
