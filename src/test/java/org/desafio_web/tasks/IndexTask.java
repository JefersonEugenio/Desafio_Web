package org.desafio_web.tasks;

import org.desafio_web.appObjects.IndexAppObjects;
import org.openqa.selenium.WebDriver;

public class IndexTask {

    private final IndexAppObjects indexAppObjects;

    public IndexTask (WebDriver driver) {
        indexAppObjects = new IndexAppObjects(driver);
    }

    public void createRegister() {
        indexAppObjects.getRegisterButton().click();
        indexAppObjects.getEmailField().sendKeys("Jeferson@hotmail.com");
        indexAppObjects.getNameField().sendKeys("Jeferson");
        indexAppObjects.getPasswordField().sendKeys("1234567890");
        indexAppObjects.getPasswordConfirmationField().sendKeys("1234567890");
        indexAppObjects.getCreateAccountBalanceToggle().click();
    }

}
