package org.desafio_web.appObjects;

import org.desafio_web.framework.supports.Wait;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class HomeAppObjects {

    private final WebDriver driver;
    private final Wait wait;

    public HomeAppObjects (WebDriver driver) {
        this.driver = driver;
        wait = new Wait(driver);
    }

    public WebElement getBalanceText() {
        wait.waitVisibilityElement(By.id("textBalance"));
        return driver.findElement(By.id("textBalance"));
    }

    public WebElement getTransferButton() {
        wait.waitVisibilityElement(By.id("btn-TRANSFERÊNCIA"));
        return driver.findElement(By.id("btn-TRANSFERÊNCIA"));
    }

    public WebElement getExtractButton() {
        wait.waitVisibilityElement(By.id("btn-EXTRATO"));
        return driver.findElement(By.id("btn-EXTRATO"));
    }

    public WebElement getExitButton() {
        return driver.findElement(By.id("btnExit"));
    }
}
