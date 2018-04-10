package org.testerfabrik.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testerfabrik.commons.CommonMethods;

import static java.lang.Math.min;
import java.util.List;

public class HomePage extends CommonMethods{
    WebDriver driver;

    @FindBy(id = "nav-link-accountList")
    WebElement lnkSignIn;

    @FindBy(xpath = "//div[@id='nav-tools']/a[@id='nav-link-accountList']/span[@class='nav-line-1']")
    WebElement lblUserName;

    @FindBy(id = "twotabsearchtextbox")
    WebElement txtSearch;

    @FindBy(xpath = ".//*[@id='nav-search']/form/div[2]/div/input")
    WebElement btnSearch;

    @FindBy(xpath = ".//*[text()='Plastic']")
    WebElement chkPlastic;

    @FindBy(id = "low-price")
    WebElement txtLowPrice;

    @FindBy(id = "high-price")
    WebElement txtHighPrice;

    @FindBy(xpath = "//span/input[@value='Go']")
    WebElement btnGo;

    // Forma de obtener una lista de objetos web
    @FindAll({
            @FindBy(xpath = ".//*[contains(@id,'result_')]")
    })
    List<WebElement> lstResultItems;


    public HomePage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }

    // Clic en botón SignIn
    protected void clickSignIn(){
        elementExist(driver, lnkSignIn);
        lnkSignIn.click();
    }

    // Obtener el texto de bienvenida del usuario en la página principal
    protected String getUserSignedUp(){
        return lblUserName.getText();
    }

    // Escribir el item de búsqueda
    protected void setSearch(String search){
        elementExist(driver, txtSearch);
        txtSearch.sendKeys(search);
    }

    // Clic en el icono de la lupa para buscar el item
    protected void clickSearch(){
        btnSearch.click();
    }

    // Clic en el checkbox del material Plastic
    protected void checkPlaticMaterial(){
        scrollToElement(driver, chkPlastic);
        chkPlastic.click();
    }

    // Escribir el rango de precio más bajo
    protected void setLowPrice(String lowPrice) {
        scroll(driver, "0,130");
        elementExist(driver, txtLowPrice);
        txtLowPrice.sendKeys(lowPrice);
    }

    // Escribir el rango de precio más alto
    protected void setHighPrice(String highPrice) {
        txtHighPrice.sendKeys(highPrice);
    }

    // Clic en el botón Go
    protected void clickGo(){
        btnGo.click();
    }

    // Método que regresa los primeros 5 resultados
    public List<WebElement> getFirstFiveItems(){
        return lstResultItems.subList(0, min(lstResultItems.size(), 5));
    }
}
