package org.desafio_web.appObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class IndexAppObjects {

    private final WebDriver driver;

    public IndexAppObjects (WebDriver driver) {
        this.driver = driver;
    }

    public WebElement getButtonRegister() {
        return driver.findElement(By.cssSelector(".ihdmxA"));
    }

}
