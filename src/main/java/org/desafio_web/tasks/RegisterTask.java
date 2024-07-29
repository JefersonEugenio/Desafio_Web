package org.desafio_web.tasks;

import org.desafio_web.appObjects.RegisterAppObjects;
import org.desafio_web.appObjects.LoginAppObjects;
import org.desafio_web.framework.data.EncapsulationData;
import org.desafio_web.framework.utils.CreateCsv;
import org.desafio_web.framework.webDrivers.DriverManager;
import org.openqa.selenium.WebDriver;

import java.io.IOException;

public class RegisterTask {

    private final WebDriver driver;
    private final RegisterAppObjects registerAppObjects;
    private final LoginAppObjects loginAppObjects;

    public RegisterTask(WebDriver driver) {
        this.driver = driver;
        loginAppObjects = new LoginAppObjects(driver);
        registerAppObjects = new RegisterAppObjects(driver);
    }

    public void criarRegistroUsuario(EncapsulationData user) throws IOException {
        loginAppObjects.getLoginRegisterButton().click();
        registerAppObjects.getRegisterEmailField().sendKeys(user.getEmail());
        registerAppObjects.getRegisterNameField().sendKeys(user.getNome());
        registerAppObjects.getRegisterPasswordField().sendKeys(user.getSenha());
        registerAppObjects.getResgiterPasswordConfirmationField().sendKeys(user.getSenha());
        registerAppObjects.getRegisterCreateAccountBalanceToggle().click();
        registerAppObjects.getRegisterFinalButton();
        user.setConta(registerAppObjects.getNumberAccountText().getText().replaceAll("[^0-9-]", ""));
        CreateCsv.inserirDados(user.getConta(), user.getEmail(), user.getNome(), user.getSenha());
        registerAppObjects.getCloseModalButton().click();
        DriverManager.getDriver().navigate().refresh();
    }

}