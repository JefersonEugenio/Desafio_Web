package org.desafio_web.tasks;

import org.desafio_web.appObjects.HomeAppObjects;
import org.desafio_web.framework.data.EncapsulationData;
import org.desafio_web.framework.utils.ObjectsUtils;
import org.openqa.selenium.WebDriver;

public class HomeTask {

    private final WebDriver driver;
    private final HomeAppObjects homeAppObjects;

    public HomeTask (WebDriver driver) {
        this.driver = driver;
        homeAppObjects = new HomeAppObjects(driver);
    }

    public void transferOtherAccount() {
        homeAppObjects.getTransferButton().click();
    }

    public void validateBalance(EncapsulationData user) {
        String value = homeAppObjects.getBalanceText().getText().replaceAll("[^0-9.,]", "");
        ObjectsUtils.setPropertiesData("dados", "Saldo_"+user.getName(), value);
    }

    public void accountExit() {
        homeAppObjects.getExitButton().click();
    }

    public void accountExtract() {
        homeAppObjects.getExtractButton().click();
    }
}
