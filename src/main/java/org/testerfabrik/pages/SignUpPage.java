package org.testerfabrik.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testerfabrik.commons.CommonMethods;

public class SignUpPage extends CommonMethods {

    WebDriver driver;

    @FindBy(id = "createAccountSubmit")
    WebElement lnkCreateAccount;

    @FindBy(id = "ap_customer_name")
    WebElement txtYourName;

    @FindBy(id = "ap_email")
    WebElement txtEmail;

    @FindBy(id = "ap_password")
    WebElement txtPassword;

    @FindBy(id = "ap_password_check")
    WebElement txtReEnterPass;

    @FindBy(id = "continue")
    WebElement btnCreateAccount;

    public SignUpPage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }

    // Click en Create Account
    protected void clickCreateAccount() {
        elementExist(driver, lnkCreateAccount);
        lnkCreateAccount.click();
    }

    // Escribir en cuadro de texto de Your Name
    protected void setYourName(String yourName){
        elementExist(driver, txtYourName);
        txtYourName.sendKeys(yourName);
    }

    // Escribir en cuadro de texto de email
    protected void setEmail(String email){
        txtEmail.sendKeys(email);
    }

    // Escribir en cuadro de texto de password
    protected void setPassword(String pass){
        txtPassword.sendKeys(pass);
    }

    // Escribir en cuadro de texto de re-enter password
    protected void setConfirmPass(String reEnterPass){
        txtReEnterPass.sendKeys(reEnterPass);
    }

    // Clic en el botón de Create Amazon Account
    protected void clickCreateAmazonAccount(){
        btnCreateAccount.click();
    }
}
