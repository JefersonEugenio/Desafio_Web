package org.desafio_web.tasks;

import org.desafio_web.appObjects.ExtractAppObjects;
import org.desafio_web.framework.data.EncapsulationData;
import org.desafio_web.framework.utils.ObjectsUtils;
import org.openqa.selenium.WebDriver;

public class ExtractTask {

    private final WebDriver driver;
    private final ExtractAppObjects extractAppObjects;

    public ExtractTask (WebDriver driver) {
        this.driver = driver;
        extractAppObjects = new ExtractAppObjects(driver);
    }

    public void validateExtract(EncapsulationData user) {
        String value = extractAppObjects.getBalanceText().getText().replaceAll("[^0-9.,]", "");
        user.setBalance(value);
        System.out.println("saldo>>> " + user.getBalance());
        ObjectsUtils.setPropertiesData("dados", "Saldo_"+user.getName(), user.getBalance());
        extractAppObjects.getExitButton().click();
    }

}