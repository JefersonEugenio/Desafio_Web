package org.desafio_web.framework.tools;

import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.model.Media;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

public class Screenshot {

    public static Media screenshotBase64(WebDriver driver) throws IllegalAccessException {
        if (driver == null) {
            throw new IllegalAccessException("WebDriver não pode ser null");
        }
        String base64Screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BASE64);
        return MediaEntityBuilder.createScreenCaptureFromBase64String(base64Screenshot).build();
    }

}