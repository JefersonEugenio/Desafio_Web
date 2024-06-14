package org.desafio_web.framework.supports;

import org.desafio_web.framework.webDrivers.DriverFactory;
import org.desafio_web.framework.webDrivers.DriverManager;
import org.desafio_web.framework.webDrivers.Drivers;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;

public class BaseTest extends DriverFactory {

    @BeforeAll
    public static void setUp() {
        DriverManager.setDriver(getBrower(Drivers.CHROME));
    }

    @AfterAll
    public static void tearDown() {
        DriverManager.quit();
    }

}
