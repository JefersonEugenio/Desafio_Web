package org.desafio_web.testCases;

import org.desafio_web.framework.supports.BaseTest;
import org.desafio_web.framework.webDrivers.DriverManager;
import org.desafio_web.tasks.IndexTask;
import org.junit.jupiter.api.Test;

public class BugBankTest extends BaseTest {

    private IndexTask indexTask;

    @Test
    public void accomplishTransferAccountsTest() throws InterruptedException {
        indexTask = new IndexTask(DriverManager.getDriver());
        indexTask.createRegister();
        Thread.sleep(5000);

    }

}
