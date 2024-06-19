package org.desafio_web.appObjects;

import org.desafio_web.framework.supports.Wait;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class TransferAppObjects {

    private final WebDriver driver;
    private final Wait wait;

    public TransferAppObjects (WebDriver driver) {
        this.driver = driver;
        wait = new Wait(driver);
    }

    public WebElement getNumberAccountField() {
        wait.waitVisibilityElement(By.cssSelector(".account__data input[name='accountNumber']"));
        return driver.findElement(By.cssSelector(".account__data input[name='accountNumber']"));
    }

    public WebElement getNumberDigitField() {
        return driver.findElement(By.cssSelector(".account__data input[name='digit']"));
    }

    public WebElement getValueTransferFiled() {
        return driver.findElement(By.cssSelector(".gQAEIG input[name='transferValue']"));
    }

    public WebElement getDescriptionFiled() {
        return driver.findElement(By.cssSelector(".gQAEIG input[name='description']"));
    }

    public WebElement getTransferNowButton() {
        return driver.findElement(By.cssSelector(".hehMDu button"));
    }

    public WebElement getTransferSuccessText() {
        return driver.findElement(By.id("modalText"));
    }

    public WebElement getTransferCloseButton() {
        wait.waitVisibilityElement(By.id("btnCloseModal"));
        return driver.findElement(By.id("btnCloseModal"));
    }

    public WebElement getTransExitButton() {
        return driver.findElement(By.id("btnExit"));
    }
}
