package org.desafio_web.testCases;

import org.desafio_web.framework.data.EncapsulationData;
import org.desafio_web.framework.supports.BaseTest;
import org.desafio_web.framework.webDrivers.DriverManager;
import org.desafio_web.tasks.*;
import org.junit.jupiter.api.Test;

import static org.desafio_web.framework.data.UseresData.userTwo;
import static org.desafio_web.framework.data.UseresData.userOne;

public class BugBankTest extends BaseTest {

    private RegisterTask indexTask = new RegisterTask(DriverManager.getDriver());
    private LoginTask loginTask = new LoginTask(DriverManager.getDriver());
    private HomeTask homeTask = new HomeTask(DriverManager.getDriver());
    private TransferTask transferTask = new TransferTask(DriverManager.getDriver());
    private ExtractTask extractTask = new ExtractTask(DriverManager.getDriver());

    EncapsulationData user1 = userOne();
    EncapsulationData user2 = userTwo();

    @Test
    public void accomplishTransferAccountsTest() throws InterruptedException {
        createAccountUserOne();
        createAccountUserTwo();
        transerOtherAccount();
        validateValueUserOne();
        validateValueUserTwo();
    }

    public void createAccountUserOne() {
        indexTask.createRegister(user1);
        loginTask.accessAccount(user1);
        homeTask.accountExtract();
        extractTask.validateExtract(user1);

    }

    public void createAccountUserTwo() {
        indexTask.createRegister(user2);
        loginTask.accessAccount(user2);
        homeTask.accountExtract();
        extractTask.validateExtract(user2);
    }

    public void transerOtherAccount() {
        loginTask.accessAccount(user1);
        homeTask.transferOtherAccount();
        transferTask.dataAccount(user1, user2);
    }

    public void validateValueUserOne() {
        loginTask.accessAccount(user1);
        homeTask.accountExtract();
        extractTask.validateExtract(user1);
    }

    public void validateValueUserTwo() {
        loginTask.accessAccount(user2);
        homeTask.accountExtract();
        extractTask.validateExtract(user2);
    }

}