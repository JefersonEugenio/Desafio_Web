package org.desafio_web.tasks;

import com.aventstack.extentreports.Status;
import org.desafio_web.appObjects.TransferAppObjects;
import org.desafio_web.framework.data.EncapsulationData;
import org.desafio_web.framework.supports.Transfer;
import org.desafio_web.framework.tools.Screenshot;
import org.desafio_web.framework.utils.ObjectsUtils;
import org.openqa.selenium.WebDriver;

import static org.desafio_web.framework.tools.Report.extentTest;

public class TransferTask {

    private final WebDriver driver;
    private final TransferAppObjects transferAppObjects;

    public TransferTask (WebDriver driver) {
        this.driver = driver;
        transferAppObjects = new TransferAppObjects(driver);
    }

    public void dataAccount(EncapsulationData user1, EncapsulationData user2) throws IllegalAccessException {
        String numberAccount = ObjectsUtils.getPropertiesData("dados", user2.getName());
        String number = numberAccount.split("-")[0];
        String digit = numberAccount.split("-")[1];
        transferAppObjects.getNumberAccountField().sendKeys(number);
        transferAppObjects.getNumberDigitField().sendKeys(digit);
        user1.setTransferValue(Transfer.value());
        transferAppObjects.getValueTransferFiled().sendKeys(user1.getTransferValue());
        Transfer.transfer(user1.getBalance(), user2.getBalance(), user1.getTransferValue());
        transferAppObjects.getDescriptionFiled().sendKeys("Doar");
        transferAppObjects.getTransferNowButton().click();
        if (transferAppObjects.getTransferSuccessText().getText().equals("Transferencia realizada com sucesso")) {
            if (Screenshot.screenshotBase64(driver) != null) {
                extentTest.log(Status.PASS, "Transferencia realizada com sucesso", Screenshot.screenshotBase64(driver));
            } else {
                extentTest.log(Status.FAIL, "Falha ao capturar a screenshot");
            }
        } else {
            extentTest.log(Status.FAIL, "Conta inválida ou inexistente", Screenshot.screenshotBase64(driver));
        }
        transferAppObjects.getTransferCloseButton().click();
        transferAppObjects.getTransExitButton().click();
    }

}