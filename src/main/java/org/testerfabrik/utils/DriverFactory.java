package org.testerfabrik.utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.testng.Assert;

import java.util.concurrent.TimeUnit;

public class DriverFactory {

    private DriverFactory(){

    }

    private static DriverFactory instance = new DriverFactory();

    public static DriverFactory getInstance(){
        return instance;
    }

    //Enlazar objeto de driver local para webdriver
    ThreadLocal<WebDriver> driver = new ThreadLocal<WebDriver>(){
        @Override
        protected WebDriver initialValue(){
            return null; //Puede ser reemplazado con otros drivers de navegadores
        }
    };

    // llama a este método para obtener el objeto del driver e iniciar el navegador
    public WebDriver getDriver(){
        return driver.get();
    }

    // llama a este método para seleccionar el driver, puede ser para Chrome, Firefox, Edge, etc.
    public WebDriver setDriver(BrowserType browser){
        // Obtener la plataforma, puede ser Win, MAC, Linux, etc.
        String getOS = System.getProperty("os.name").toLowerCase();
        String osName = "";
        if(getOS.contains("mac")){
            osName = "mac";
        }else if(getOS.contains("win")){
            osName = "windows";
        }else if(getOS.contains("nix") || getOS.contains("nux") || getOS.contains("aix")){
            osName = "linux";
        }

        String driverPath = System.getProperty("user.dir") + "/drivers/";

        // Selecciona el driver dependiendo del enumerable y basado en la plataforma
        switch (browser.toString()){
            case "CHROME":
                if(osName.equals("windows")){
                    System.setProperty("webdriver.chrome.driver", driverPath + "chromedriver.exe");
                }else{
                    System.setProperty("webdriver.chrome.driver", driverPath + "chromedriver");
                }
                driver.set(new ChromeDriver());
                break;
            case  "IE":
                if(osName.equals("windows")){
                    System.setProperty("webdriver.ie.driver", driverPath + "IEDriverServer.exe");
                }
                driver.set(new InternetExplorerDriver());
                break;
            case "FIREFOX":
                if(osName.equals("windows")){
                    System.setProperty("webdriver.gecko.driver", driverPath + "geckodriver.exe");
                }else{
                    System.setProperty("webdriver.gecko.driver", driverPath + "geckodriver");
                }
                driver.set(new FirefoxDriver());
                break;
            case "SAFARI":
                if(osName.equals("mac")){driver.set(new SafariDriver());}
                break;
            case "EDGE":
                if(osName.equals("windows")){
                    System.setProperty("webdriver.edge.driver", driverPath + "MicrosoftWebDriver.exe");
                }
        }
        int i = 10;
        // Ocasionalmente no puede maximizar la ventana
        for (int j = 1; j <= i; i++){
            try {
                driver.get().manage().window().maximize();
                break;
            }catch (WebDriverException we){
                driver.set(new ChromeDriver());
                driver.get().manage().window().maximize();
            }
            if (i == j){
                Assert.fail("Failed to maximize window " + j + " times");
            }
        }
        driver.get().manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
        return driver.get();
    }

    // Quita el driver y cierra el navegador
    public void removeDriver(){
        driver.get().quit();
        driver.remove();
    }
}
