package org.desafio_web.appObjects;

import org.desafio_web.framework.supports.Wait;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class RegisterAppObjects {

    private final WebDriver driver;
    private final Wait wait;

    public RegisterAppObjects(WebDriver driver) {
        this.driver = driver;
        wait = new Wait(driver);
    }

    public WebElement getRegisterEmailField() {
        return driver.findElement(By.xpath("//div[@class='card__register']//input[@name='email']"));
    }

    public WebElement getRegisterNameField() {
        return driver.findElement(By.name("name"));
    }

    public WebElement getRegisterPasswordField() {
        return driver.findElement(By.xpath("//div[@class='card__register']//input[@name='password']"));
    }

    public WebElement getResgiterPasswordConfirmationField() {
        return driver.findElement(By.name("passwordConfirmation"));
    }

    public WebElement getRegisterCreateAccountBalanceToggle() {
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

    public WebElement getAccessButton() {
        return driver.findElement(By.xpath("//div[@class='login__buttons']//button[@type='submit']"));
    }

    public WebElement getNumberAccountText() {
        wait.waitVisibilityElement(By.id("modalText"));
        return driver.findElement(By.id("modalText"));
    }

}