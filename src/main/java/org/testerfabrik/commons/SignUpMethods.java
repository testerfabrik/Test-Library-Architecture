package org.testerfabrik.commons;

import org.openqa.selenium.WebDriver;
import org.testerfabrik.pages.SignUpPage;

public class SignUpMethods extends SignUpPage {
    WebDriver driver;

    public SignUpMethods(WebDriver driver){
        super(driver);
        this.driver = driver;
    }

    // Método para navegar a la página de Amazon
    public void navigateToAmazon(){
        this.driver.get("https://www.amazon.com");
        sync(driver);
    }

    // Método para crear un usuario en Amazon
    public void signUp(String yourName, String email, String password){
        clickCreateAccount();
        setYourName(yourName);
        setEmail(email);
        setPassword(password);
        setConfirmPass(password);
        clickCreateAmazonAccount();
    }
}
