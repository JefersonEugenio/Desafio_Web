package org.desafio_web.tasks;

import org.desafio_web.appObjects.RegisterAppObjects;
import org.desafio_web.appObjects.LoginAppObjects;
import org.desafio_web.framework.data.EncapsulationData;
import org.desafio_web.framework.utils.CreateFolder;
import org.desafio_web.framework.utils.ObjectsUtils;
import org.desafio_web.framework.webDrivers.DriverManager;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.WebDriver;

public class RegisterTask {

    private final WebDriver driver;
    private final RegisterAppObjects registerAppObjects;
    private final LoginAppObjects loginAppObjects;

    public RegisterTask(WebDriver driver) {
        this.driver = driver;
        loginAppObjects = new LoginAppObjects(driver);
        registerAppObjects = new RegisterAppObjects(driver);
    }

    public void createRegister(EncapsulationData user) {
        loginAppObjects.getLoginRegisterButton().click();
        registerAppObjects.getRegisterEmailField().sendKeys(user.getEmail());
        registerAppObjects.getRegisterNameField().sendKeys(user.getName());
        registerAppObjects.getRegisterPasswordField().sendKeys(user.getPassword());
        registerAppObjects.getResgiterPasswordConfirmationField().sendKeys(user.getPassword());
        registerAppObjects.getRegisterCreateAccountBalanceToggle().click();
        registerAppObjects.getRegisterFinalButton();
        user.setAccount(registerAppObjects.getNumberAccountText().getText().replaceAll("[^0-9-]", ""));
        ObjectsUtils.setPropertiesData("dados", user.getName(), user.getAccount());
        registerAppObjects.getCloseModalButton().click();
        DriverManager.getDriver().navigate().refresh();
    }

}