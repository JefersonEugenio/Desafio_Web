package org.desafio_web.tasks;

import org.desafio_web.appObjects.TransferAppObjects;
import org.desafio_web.framework.data.EncapsulationData;
import org.desafio_web.framework.supports.Fakers;
import org.desafio_web.framework.utils.ObjectsUtils;
import org.openqa.selenium.WebDriver;

public class TransferTask {

    private final WebDriver driver;
    private final TransferAppObjects transferAppObjects;

    public TransferTask (WebDriver driver) {
        this.driver = driver;
        transferAppObjects = new TransferAppObjects(driver);
    }

    public void dataAccount(EncapsulationData user) {
        String numberAccount = ObjectsUtils.getPropertiesData("dados", user.getName());
        String number = numberAccount.split("-")[0];
        String digit = numberAccount.split("-")[1];
        transferAppObjects.getNumberAccountField().sendKeys(number);
        transferAppObjects.getNumberDigitField().sendKeys(digit);
        transferAppObjects.getValueTransferFiled().sendKeys(value());
        transferAppObjects.getDescriptionFiled().sendKeys("Doar");
        transferAppObjects.getTransferNowButton().click();
        transferAppObjects.getTransferCloseButton().click();
        transferAppObjects.getTransExitButton().click();
    }

    public String value() {
        Fakers fakers = new Fakers();
        double value = fakers.getValue();
        String valueStr = Double.toString(value);
        return valueStr;
    }
}
