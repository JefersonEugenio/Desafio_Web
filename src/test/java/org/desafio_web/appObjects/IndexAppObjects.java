package org.desafio_web.appObjects;

import org.desafio_web.framework.supports.Wait;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class IndexAppObjects {

    private final WebDriver driver;
    private final Wait wait;

    public IndexAppObjects (WebDriver driver) {
        this.driver = driver;
        wait = new Wait(driver);
    }

    public WebElement getRegisterButton() {
        return driver.findElement(By.cssSelector(".ihdmxA"));
    }

    public WebElement getEmailField() {
        return driver.findElement(By.xpath("//div[@class='card__register']//input[@name='email']"));
    }

    public WebElement getNameField() {
        return driver.findElement(By.name("name"));
    }

    public WebElement getPasswordField() {
        return driver.findElement(By.xpath("//div[@class='card__register']//input[@name='password']"));
    }

    public WebElement getPasswordConfirmationField() {
        return driver.findElement(By.name("passwordConfirmation"));
    }

    public WebElement getCreateAccountBalanceToggle() {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeAsyncScript("window.setTimeout(arguments[arguments.length - 1], 1000);");
        return driver.findElement(By.id("toggleAddBalance"));
    }

    public WebElement getRegisterFinalButton() {
        WebElement element = driver.findElement(By.xpath("//div[@class='card__register']//button[@type='submit']"));
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].click();", element);
        return null;
    }

    public WebElement getCloseModalButton() {
        wait.waitVisibilityElement(By.id("btnCloseModal"));
        return driver.findElement(By.id("btnCloseModal"));
    }

}