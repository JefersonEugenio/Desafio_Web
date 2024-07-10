package org.desafio_web.tasks;

import com.aventstack.extentreports.Status;
import org.desafio_web.appObjects.ExtractAppObjects;
import org.desafio_web.framework.data.EncapsulationData;
import org.desafio_web.framework.tools.Screenshot;
import org.desafio_web.framework.utils.ObjectsUtils;
import org.openqa.selenium.WebDriver;

import static org.desafio_web.framework.tools.Report.extentTest;

public class ExtractTask {

    private final WebDriver driver;
    private final ExtractAppObjects extractAppObjects;

    public ExtractTask (WebDriver driver) {
        this.driver = driver;
        extractAppObjects = new ExtractAppObjects(driver);
    }

    public void validateExtract(EncapsulationData user) throws IllegalAccessException {
        String value = extractAppObjects.getBalanceText().getText().replaceAll("[^0-9.,]", "");
        user.setBalance(value);
        if (ObjectsUtils.getPropertiesData("dados", "Value_transfer") == null) {
            ObjectsUtils.setPropertiesData("dados", "Saldo_"+user.getName(), user.getBalance());
            extentTest.log(Status.INFO, "Verificar o valor do saldo "+ user.getName()+ " é " + user.getBalance());
        } else {
            ObjectsUtils.setPropertiesData("dados", "Saldo_"+user.getName(), user.getBalance());
            extentTest.log(Status.PASS, "Verificar o valor do saldo "+ user.getName()+ " é " + user.getBalance(), Screenshot.screenshotBase64(driver));
        }
        extractAppObjects.getExitButton().click();
    }

}