package org.desafio_web.tasks;

import org.desafio_web.appObjects.IndexAppObjects;
import org.openqa.selenium.WebDriver;

public class IndexTask {

    private final IndexAppObjects indexAppObjects;
    private final WebDriver driver;

    public IndexTask (WebDriver driver) {
        this.driver = driver;
        indexAppObjects = new IndexAppObjects(driver);
    }

    public void createRegister() {
        indexAppObjects.getRegisterButton().click();
        indexAppObjects.getEmailField().sendKeys("Jeferson@hotmail.com");
        indexAppObjects.getNameField().sendKeys("Jeferson");
        indexAppObjects.getPasswordField().sendKeys("1234567890");
        indexAppObjects.getPasswordConfirmationField().sendKeys("1234567890");
        indexAppObjects.getCreateAccountBalanceToggle().click();
        indexAppObjects.getRegisterFinalButton();
        indexAppObjects.getCloseModalButton().click();
    }

    public void createRegisterOther() {
        indexAppObjects.getRegisterButton().click();
        indexAppObjects.getEmailField().clear();
        indexAppObjects.getEmailField().sendKeys("eugenio@hotmail.com");
        indexAppObjects.getNameField().clear();
        indexAppObjects.getNameField().sendKeys("Eugenio");
        indexAppObjects.getPasswordField().clear();
        indexAppObjects.getPasswordField().sendKeys("0987654321");
        indexAppObjects.getPasswordConfirmationField().clear();
        indexAppObjects.getPasswordConfirmationField().sendKeys("0987654321");
        indexAppObjects.getCreateAccountBalanceToggle().click();
        indexAppObjects.getRegisterFinalButton();
        indexAppObjects.getCloseModalButton().click();
    }

}