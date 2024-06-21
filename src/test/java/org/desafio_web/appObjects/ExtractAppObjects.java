package org.desafio_web.appObjects;

import org.desafio_web.framework.supports.Wait;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ExtractAppObjects {

    private final WebDriver driver;
    private final Wait wait;

    public ExtractAppObjects(WebDriver driver) {
        this.driver = driver;
        wait = new Wait(driver);
    }

    public WebElement getBalanceText() {
        wait.waitVisibilityElement(By.id("textBalanceAvailable"));
        return driver.findElement(By.id("textBalanceAvailable"));
    }

    public WebElement getExitButton() {
        return driver.findElement(By.id("btnExit"));
    }

}
