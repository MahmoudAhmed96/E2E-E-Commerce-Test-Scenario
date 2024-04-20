package tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.*;

public class SearchProductTest extends TestBase {


    HomePage homePage;
    UserRegisterPage register;
    LoginPage loginPage;
    SearchPage searchPage;

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

    @Test(dependsOnMethods = "userCanLogin",enabled = true)
    public void userCanSearchProduct(){

        //By SearchButton

        searchPage=new SearchPage(driver);
        searchPage.searchProduct(pro.getProperty("productName"));
        Assert.assertTrue(searchPage.itemName.getText().equalsIgnoreCase(pro.getProperty("productName")));
        Assert.assertEquals(searchPage.itemName.getText(),pro.getProperty("productName"));
        
    }

    @Test(dependsOnMethods = "userCanLogin",enabled = false)
    public void userCanSearchProduct2(){

        //By AutoSuggest

         searchPage=new SearchPage(driver);
         searchPage.autoSuggestSearch(pro.getProperty("productName"), driver);
         Assert.assertTrue(searchPage.itemName.getText().equalsIgnoreCase(pro.getProperty("productName")));
         Assert.assertEquals(searchPage.itemName.getText(),pro.getProperty("productName"));


    }

}
