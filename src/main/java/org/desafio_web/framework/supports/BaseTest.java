package org.desafio_web.framework.supports;

import com.aventstack.extentreports.Status;
import org.desafio_web.framework.tools.Report;
import org.desafio_web.framework.utils.CreateFolder;
import org.desafio_web.framework.utils.ExcluirDiretorio;
import org.desafio_web.framework.utils.ObjectsUtils;
import org.desafio_web.framework.webDrivers.DriverFactory;
import org.desafio_web.framework.webDrivers.DriverManager;
import org.desafio_web.framework.webDrivers.Drivers;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;

import java.io.File;
import java.io.IOException;

import static org.desafio_web.framework.tools.Report.extentTest;

public class BaseTest extends DriverFactory {

    public static String CAMINHO_PASTA_CSV = System.getProperty("user.dir") + File.separator
            + "src" + File.separator + "main" + File.separator + "resources"
            + File.separator + "CSV" + File.separator;

    @BeforeAll
    public static void setUp() throws IOException {
        ExcluirDiretorio.excluirTodosArquivoDiretorio(CAMINHO_PASTA_CSV);
        CreateFolder.createDirectory(CAMINHO_PASTA_CSV);
        Report.configurarExtentReport();
        Report.createTest("BugBank");
        DriverManager.setDriver(getBrower(Drivers.CHROME));
        DriverManager.getDriver().get(ObjectsUtils.getPropertiesData("path", "bugbank"));
        extentTest.log(Status.INFO, "Acessou site do Bugbank");
    }

    @AfterAll
    public static void tearDown() {
        Report.closeReport();
        DriverManager.quit();
    }

}