package org.desafio_web.tasks;

import com.aventstack.extentreports.Status;
import org.desafio_web.appObjects.ExtractAppObjects;
import org.desafio_web.framework.data.EncapsulationData;
import org.desafio_web.framework.tools.Screenshot;
import org.desafio_web.framework.utils.CreateCsv;
import org.openqa.selenium.WebDriver;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Path;

import static org.desafio_web.framework.tools.Report.extentTest;

public class ExtractTask {

    private final WebDriver driver;
    private final ExtractAppObjects extractAppObjects;

    public ExtractTask (WebDriver driver) {
        this.driver = driver;
        extractAppObjects = new ExtractAppObjects(driver);
    }

    public void validarExtratoConta(EncapsulationData user) throws IllegalAccessException {
        File pasta = new File(CreateCsv.CAMINHO_CSV + "transfer.csv");

        String valor = extractAppObjects.getBalanceText().getText().replaceAll("[^0-9.,]", "");

        user.setSaldo(valor);

        informarSaldo(user, pasta.toPath());

        extractAppObjects.getExitButton().click();
    }

    private void informarSaldo(EncapsulationData user, Path path) {
        try {
            if (Files.exists(path)) {
                extentTest.log(Status.PASS, "Verificar o valor do saldo "+ user.getNome()+ " é " + user.getSaldo(), Screenshot.screenshotBase64(driver));
            } else {
                extentTest.log(Status.INFO, "Verificar o valor do saldo "+ user.getNome()+ " é " + user.getSaldo());
            }
        } catch (IllegalAccessException e) {
            extentTest.log(Status.FAIL, "Erro ao verificar a existência do arquivo: " + e.getMessage());
        }
    }

}