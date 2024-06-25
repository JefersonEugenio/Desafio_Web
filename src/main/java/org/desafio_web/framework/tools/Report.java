package org.desafio_web.framework.tools;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import org.desafio_web.framework.utils.CreateFolder;
import org.openqa.selenium.WebDriver;

import java.io.File;

public class Report {

    private static ThreadLocal<ExtentTest> test = new ThreadLocal<>();
    private static final String CAMINHO_REPORT = System.getProperty("user.dir") + File.separator + "src" + File.separator + "main" + File.separator + "resources" + File.separator + "report";
    public static WebDriver driver;
    public static ExtentHtmlReporter htmlReporter;
    public static ExtentReports extentReports;
    public static ExtentTest extentTest;

    public static void configurarExtentReport(){
        CreateFolder.createDirectory(CAMINHO_REPORT);

        htmlReporter = new ExtentHtmlReporter(CAMINHO_REPORT + File.separator + "ReportTest.html");

        htmlReporter.config().setDocumentTitle("Automação de web");
        htmlReporter.config().setReportName("Automação de teste");
        htmlReporter.config().setEncoding("UTF-8");
        htmlReporter.config().setTheme(Theme.DARK);
        htmlReporter.config().setTimeStampFormat("EEEE, MMMM dd, yyyy, hh:mm a '('zzz')'");
        htmlReporter.config().setJS("$('.brand-logo').html('<img src=\\\"https://i.imgur.com/qDYwkD2.png\\\" class=\\\"db-logo\\\"/>');");
        htmlReporter.config().setCSS(".nav-wrapper { background-color: #1E317A !important; } .brand-logo { background-color: #1E317A !important; padding: 0 10px 0 0 !important; margin: 0 !important; position: absolute !important } .report-name { margin-left: 80px !important } .blue.darken-3 { background-color: #1E317A !important; color: #FFF !important;  }");

        extentReports = new ExtentReports();

        extentReports.attachReporter(htmlReporter);
    }

    public static void createTest(String testName){
        extentTest = extentReports.createTest(testName);
        test.set(extentTest);
    }

    public static void closeReport(){
        extentReports.flush();
        if (driver!=null){
            driver.quit();
            driver = null;
        }
    }

}