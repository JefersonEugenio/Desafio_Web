package org.desafio_web.tasks;

import org.desafio_web.appObjects.LoginAppObjects;
import org.desafio_web.framework.data.EncapsulationData;
import org.openqa.selenium.WebDriver;

public class LoginTask {

    private final WebDriver driver;
    private final LoginAppObjects loginAppObjects;

    public LoginTask (WebDriver driver) {
        this.driver = driver;
        loginAppObjects = new LoginAppObjects(driver);
    }

    public void acessarContaLogin(EncapsulationData user) {
        loginAppObjects.getLoginEmailField().sendKeys(user.getEmail());
        loginAppObjects.getLoginPasswordField().sendKeys(user.getSenha());
        loginAppObjects.getLoginAccessButton().click();
    }

}