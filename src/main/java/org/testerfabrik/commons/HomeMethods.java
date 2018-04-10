package org.testerfabrik.commons;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testerfabrik.pages.HomePage;

public class HomeMethods extends HomePage {

    WebDriver driver;

    public HomeMethods(WebDriver driver){
        super(driver);
        this.driver = driver;
    }

    // Método para navegar a la página de SignIn
    public void navigeteToSignUp(){
        clickSignIn();
    }

    // Método para verificar qeu el nombre de usuario exita
    public boolean verifyUserNameIncludes(String userName){
        sync(driver);
        return getUserSignedUp().contains(userName);
    }

    // Método para buscar el item Ipad Air
    public void searchIpadAir(String item, String lowPrice, String highPrice) {
        setSearch(item);
        clickSearch();
        checkPlaticMaterial();
        sync(driver);
        setLowPrice(lowPrice);
        setHighPrice(highPrice);
        clickGo();
    }

    // Método para encontrar los primeros 5 resultados
    public boolean findFirstFiveElements(){
        for(WebElement item : getFirstFiveItems()){
            System.out.println(item.getText());
        }
        return true;
    }
}
