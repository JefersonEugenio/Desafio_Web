package org.desafio_web.tasks;

import org.desafio_web.appObjects.IndexAppObjects;
import org.desafio_web.appObjects.LoginAppObjects;
import org.desafio_web.framework.data.EncapsulationData;
import org.desafio_web.framework.utils.ObjectsUtils;
import org.desafio_web.framework.webDrivers.DriverManager;
import org.openqa.selenium.WebDriver;

public class IndexTask {

    private final WebDriver driver;
    private final IndexAppObjects indexAppObjects;
    private final LoginAppObjects loginAppObjects;

    public IndexTask (WebDriver driver) {
        this.driver = driver;
        loginAppObjects = new LoginAppObjects(driver);
        indexAppObjects = new IndexAppObjects(driver);
    }

    public void createRegister(EncapsulationData user) {
        loginAppObjects.getLoginRegisterButton().click();
        indexAppObjects.getRegisterEmailField().sendKeys(user.getEmail());
        indexAppObjects.getRegisterNameField().sendKeys(user.getName());
        indexAppObjects.getRegisterPasswordField().sendKeys(user.getPassword());
        indexAppObjects.getResgiterPasswordConfirmationField().sendKeys(user.getConfirmPassword());
        indexAppObjects.getRegisterCreateAccountBalanceToggle().click();
        indexAppObjects.getRegisterFinalButton();
        String numberAccount = indexAppObjects.getNumberAccountText().getText();
        user.setAccount(numberAccount);
        System.out.println(user.getName() + ", sua conta é: " + user.getAccount());
        ObjectsUtils.setPropertiesData("dados", user.getName(), user.getAccount());
        indexAppObjects.getCloseModalButton().click();
        DriverManager.getDriver().navigate().refresh();
    }

}