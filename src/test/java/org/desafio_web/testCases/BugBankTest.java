package org.desafio_web.testCases;

import org.desafio_web.framework.data.EncapsulationData;
import org.desafio_web.framework.supports.BaseTest;
import org.desafio_web.framework.webDrivers.DriverManager;
import org.desafio_web.tasks.*;
import org.junit.jupiter.api.Test;

import static org.desafio_web.framework.data.UseresData.userEugenio;
import static org.desafio_web.framework.data.UseresData.userJeferson;

public class BugBankTest extends BaseTest {

    private RegisterTask indexTask = new RegisterTask(DriverManager.getDriver());
    private LoginTask loginTask = new LoginTask(DriverManager.getDriver());
    private HomeTask homeTask = new HomeTask(DriverManager.getDriver());
    private TransferTask transferTask = new TransferTask(DriverManager.getDriver());
    private ExtractTask extractTask = new ExtractTask(DriverManager.getDriver());

    EncapsulationData jeferson = userJeferson();
    EncapsulationData eugenio = userEugenio();

    @Test
    public void accomplishTransferAccountsTest() {
        indexTask.createRegister(jeferson);
        loginTask.accessAccount(jeferson);
        homeTask.accountExtract();
        extractTask.validateExtract(jeferson);
        indexTask.createRegister(eugenio);
        loginTask.accessAccount(eugenio);
        homeTask.accountExtract();
        extractTask.validateExtract(eugenio);
        loginTask.accessAccount(jeferson);
        homeTask.transferOtherAccount();
        transferTask.dataAccount(eugenio);
        loginTask.accessAccount(eugenio);
        homeTask.accountExtract();
        extractTask.validateExtract(eugenio);
        loginTask.accessAccount(jeferson);
        homeTask.accountExtract();
        extractTask.validateExtract(jeferson);
    }

}