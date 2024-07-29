package org.desafio_web.testCases;

import org.desafio_web.framework.data.EncapsulationData;
import org.desafio_web.framework.supports.BaseTest;
import org.desafio_web.framework.webDrivers.DriverManager;
import org.desafio_web.tasks.*;
import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.desafio_web.framework.data.UseresData.usuarioDois;
import static org.desafio_web.framework.data.UseresData.usuarioUm;

public class BugBankTest extends BaseTest {

    private final RegisterTask indexTask = new RegisterTask(DriverManager.getDriver());
    private final LoginTask loginTask = new LoginTask(DriverManager.getDriver());
    private final HomeTask homeTask = new HomeTask(DriverManager.getDriver());
    private final TransferTask transferTask = new TransferTask(DriverManager.getDriver());
    private final ExtractTask extractTask = new ExtractTask(DriverManager.getDriver());

    EncapsulationData usuario1 = usuarioUm();
    EncapsulationData usuario2 = usuarioDois();

    @Test
    public void realizarTransferenciaContasTeste() throws IllegalAccessException, IOException {
        criarContaUsuarioUm();
        criarContaUsuarioDois();
        transferirParaOutraConta();
        validarSaldoUsuarioUm();
        validarSaldoUsuarioDois();
    }

    public void criarContaUsuarioUm() throws IllegalAccessException, IOException {
        indexTask.criarRegistroUsuario(usuario1);
        loginTask.acessarContaLogin(usuario1);
        homeTask.acessarExtratoConta();
        extractTask.validarExtratoConta(usuario1);
    }

    public void criarContaUsuarioDois() throws IllegalAccessException, IOException {
        indexTask.criarRegistroUsuario(usuario2);
        loginTask.acessarContaLogin(usuario2);
        homeTask.acessarExtratoConta();
        extractTask.validarExtratoConta(usuario2);
    }

    public void transferirParaOutraConta() throws IllegalAccessException, IOException {
        loginTask.acessarContaLogin(usuario1);
        homeTask.transferirParaOutraConta();
        transferTask.transferirDadosContaUsuarioParaOutraConta(usuario1, usuario2);
    }

    public void validarSaldoUsuarioUm() throws IllegalAccessException {
        loginTask.acessarContaLogin(usuario1);
        homeTask.acessarExtratoConta();
        extractTask.validarExtratoConta(usuario1);
    }

    public void validarSaldoUsuarioDois() throws IllegalAccessException {
        loginTask.acessarContaLogin(usuario2);
        homeTask.acessarExtratoConta();
        extractTask.validarExtratoConta(usuario2);
    }

}