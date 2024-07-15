package org.desafio_web.testCases;

import org.desafio_web.framework.data.EncapsulationData;
import org.desafio_web.framework.supports.BaseTest;
import org.desafio_web.framework.webDrivers.DriverManager;
import org.desafio_web.tasks.*;
import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.desafio_web.framework.data.UseresData.userTwo;
import static org.desafio_web.framework.data.UseresData.userOne;

public class BugBankTest extends BaseTest {

    private final RegisterTask indexTask = new RegisterTask(DriverManager.getDriver());
    private final LoginTask loginTask = new LoginTask(DriverManager.getDriver());
    private final HomeTask homeTask = new HomeTask(DriverManager.getDriver());
    private final TransferTask transferTask = new TransferTask(DriverManager.getDriver());
    private final ExtractTask extractTask = new ExtractTask(DriverManager.getDriver());

    EncapsulationData user1 = userOne();
    EncapsulationData user2 = userTwo();

    @Test
    public void accomplishTransferAccountsTest() throws IllegalAccessException, IOException {
        createAccountUserOne();
        createAccountUserTwo();
        transerOtherAccount();
        validateValueUserOne();
        validateValueUserTwo();
    }

    public void createAccountUserOne() throws IllegalAccessException, IOException {
        indexTask.createRegisterUser(user1);
        loginTask.accessAccountLogin(user1);
        homeTask.accessAccountExtract();
        extractTask.validateAccountExtract(user1);

    }

    public void createAccountUserTwo() throws IllegalAccessException, IOException {
        indexTask.createRegisterUser(user2);
        loginTask.accessAccountLogin(user2);
        homeTask.accessAccountExtract();
        extractTask.validateAccountExtract(user2);
    }

    public void transerOtherAccount() throws IllegalAccessException, IOException {
        loginTask.accessAccountLogin(user1);
        homeTask.transferOtherAccountUser();
        transferTask.dataAccountUserTransfereOtherAccountUser(user1, user2);
    }

    public void validateValueUserOne() throws IllegalAccessException {
        loginTask.accessAccountLogin(user1);
        homeTask.accessAccountExtract();
        extractTask.validateAccountExtract(user1);
    }

    public void validateValueUserTwo() throws IllegalAccessException {
        loginTask.accessAccountLogin(user2);
        homeTask.accessAccountExtract();
        extractTask.validateAccountExtract(user2);
    }

}