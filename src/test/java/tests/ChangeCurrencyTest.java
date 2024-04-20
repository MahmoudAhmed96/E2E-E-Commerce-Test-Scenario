package tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.*;

public class ChangeCurrencyTest extends TestBase{

    HomePage homePage;
    LoginPage loginPage;
    UserRegisterPage register;
    SearchPage searchPage;
    ProductDetailsPage details;


    @Test(priority = 1,alwaysRun = true)
    public void userCanRegister(){

        homePage=new HomePage(driver);
        homePage.openRegisterPage();

        register=new UserRegisterPage(driver);
        register.userRegister(pro.getProperty("fName"),pro.getProperty("sName"),pro.getProperty("email"),pro.getProperty("password"));
        Assert.assertEquals(register.successMessage.getText(),pro.getProperty("successMessage"));

    }

    @Test(dependsOnMethods = "userCanRegister")
    public void userCanLogin(){

        homePage=new HomePage(driver);
        homePage.openLoginPage();

        loginPage=new LoginPage(driver);
        loginPage.userLogin(pro.getProperty("email"),pro.getProperty("password"));
        Assert.assertEquals(loginPage.logoutButton.getText(),pro.getProperty("successMessage2"));


    }

    @Test(priority = 3)
    public void userChangeCurrency(){

        homePage=new HomePage(driver);
        homePage.changeCurrency(1);
    }

    @Test(priority = 4)
    public void userCanSearchProduct(){

        //By Clicking SearchButton
        searchPage=new SearchPage(driver);
        details=new ProductDetailsPage(driver);
        searchPage.searchProduct(pro.getProperty("productName"));
        Assert.assertTrue(searchPage.itemName.getText().equalsIgnoreCase(pro.getProperty("productName")));
        Assert.assertEquals(searchPage.itemName.getText(),"Apple MacBook Pro 13-inch");
        Assert.assertTrue(details.successMessage.getText().contains("€"));

    }
}
