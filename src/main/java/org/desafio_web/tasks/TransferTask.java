package org.desafio_web.tasks;

import com.aventstack.extentreports.Status;
import org.desafio_web.appObjects.TransferAppObjects;
import org.desafio_web.framework.data.EncapsulationData;
import org.desafio_web.framework.supports.Transfer;
import org.desafio_web.framework.tools.Screenshot;
import org.desafio_web.framework.utils.CreateCsv;
import org.openqa.selenium.WebDriver;

import java.io.IOException;

import static org.desafio_web.framework.tools.Report.extentTest;

public class TransferTask {

    private final WebDriver driver;
    private final TransferAppObjects transferAppObjects;

    public TransferTask (WebDriver driver) {
        this.driver = driver;
        transferAppObjects = new TransferAppObjects(driver);
    }

    public void dataAccountUserTransfereOtherAccountUser(EncapsulationData user1, EncapsulationData user2) throws IllegalAccessException, IOException {
        transferAppObjects.getNumberAccountField().sendKeys(CreateCsv.leituraDados(user2).split("-")[0]);
        transferAppObjects.getNumberDigitField().sendKeys(CreateCsv.leituraDados(user2).split("-")[1]);
        user1.setTransferValue(Transfer.value());
        CreateCsv.inserirValorTransfer(user1.getTransferValue());
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