package org.testerfabrik.commons;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.Random;
import java.util.concurrent.TimeUnit;

public class CommonMethods {

    // Método para agregar un numero aleatorio a un texto
    public static String randomInfo(String info){
        return info + (new Random().nextInt());
    }

    // Método para esperar a que la p+agina se carge por completo
    public static void sync(WebDriver driver){
        driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
    }

    // Método par esperar a que un objeto web exista
    public static void elementExist(WebDriver driver, WebElement element){
        WebDriverWait wait = new WebDriverWait(driver, 15);
        wait.until(ExpectedConditions.visibilityOf(element));
    }

    // Método para hacer scroll a un objeto
    public void scrollToElement(WebDriver driver, WebElement element){
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
    }

    // Método para hacer scroll en coordenadas dadas
    public void scroll(WebDriver driver, String coordinates){
        ((JavascriptExecutor) driver).executeScript("window.scrollBy(" + coordinates + ")", "");
    }
}
