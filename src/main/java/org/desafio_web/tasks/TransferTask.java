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

    public void transferirDadosContaUsuarioParaOutraConta(EncapsulationData user1, EncapsulationData user2) throws IllegalAccessException, IOException {
        String[] dadosContaUsuario2 = CreateCsv.leituraDados(user2).split("-");
        String numeroConta = dadosContaUsuario2[0];
        String digitoConta = dadosContaUsuario2[1];

        preencherFormularioTransferencia(user1, numeroConta, digitoConta);
        realizarTransferencia(user1, user2);
        validarSucessoTransferencia();
        fecharDialogosTransferencia();
    }

    private void preencherFormularioTransferencia(EncapsulationData user1, String numeroConta, String digitoConta) throws IOException {
        transferAppObjects.getNumberAccountField().sendKeys(numeroConta);
        transferAppObjects.getNumberDigitField().sendKeys(digitoConta);
        String valorTransferencia = Transfer.value();
        user1.setTransferirValor(valorTransferencia);
        CreateCsv.inserirValorTransfer(valorTransferencia);
        transferAppObjects.getValueTransferFiled().sendKeys(valorTransferencia);
        transferAppObjects.getDescriptionFiled().sendKeys("Doar");
    }

    private void realizarTransferencia(EncapsulationData user1, EncapsulationData user2) {
        Transfer.transfer(user1.getSaldo(), user2.getSaldo(), user1.getTransferirValor());
        transferAppObjects.getTransferNowButton().click();
    }

    private void validarSucessoTransferencia() throws IllegalAccessException {
        String mensagemSucesso = "Transferencia realizada com sucesso";
        if (transferAppObjects.getTransferSuccessText().getText().equals(mensagemSucesso)) {
            registrarResultadoTransferencia(Status.PASS, mensagemSucesso);
        } else {
            registrarResultadoTransferencia(Status.FAIL, "Conta inválida ou inexistente");
        }
    }

    private void registrarResultadoTransferencia(Status status, String mensagem) throws IllegalAccessException {
        String screenshot = String.valueOf(Screenshot.screenshotBase64(driver));
        if (status == Status.PASS && screenshot == null) {
            extentTest.log(Status.FAIL, "Falha ao capturar a screenshot");
        } else {
            extentTest.log(status, mensagem, Screenshot.screenshotBase64(driver));
        }
    }

    private void fecharDialogosTransferencia() {
        transferAppObjects.getTransferCloseButton().click();
        transferAppObjects.getTransExitButton().click();
    }

}