package org.desafio_web.appObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginAppObjects {

    private final WebDriver driver;

    public LoginAppObjects(WebDriver driver) {
        this.driver = driver;
    }

    public WebElement getLoginEmailField() {
        return driver.findElement(By.xpath("//div[@class='card__login']//input[@name='email']"));
    }

    public WebElement getLoginPasswordField() {
        return driver.findElement(By.xpath("//div[@class='card__login']//input[@name='password']"));
    }

    public WebElement getLoginAccessButton() {
        return driver.findElement(By.cssSelector(".otUnI"));
    }

    public WebElement getLoginRegisterButton() {
        return driver.findElement(By.cssSelector(".ihdmxA"));
    }

}