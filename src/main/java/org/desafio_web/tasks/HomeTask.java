package org.desafio_web.tasks;

import org.desafio_web.appObjects.HomeAppObjects;
import org.openqa.selenium.WebDriver;

public class HomeTask {

    private final WebDriver driver;
    private final HomeAppObjects homeAppObjects;

    public HomeTask (WebDriver driver) {
        this.driver = driver;
        homeAppObjects = new HomeAppObjects(driver);
    }

    public void transferirParaOutraConta() {
        homeAppObjects.getTransferButton().click();
    }

    public void acessarExtratoConta() {
        homeAppObjects.getExtractButton().click();
    }

}