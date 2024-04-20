package tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.LoginPage;
import pages.ProductDetailsPage;
import pages.UserRegisterPage;

public class hoverMenuTest extends TestBase {
    HomePage homePage;
    LoginPage loginPage;
    UserRegisterPage register;
    ProductDetailsPage productDetailsPage;


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

    @Test(dependsOnMethods = "userCanLogin")
    public void userCanHoverOverItem(){

        homePage = new HomePage(driver);
        productDetailsPage=new ProductDetailsPage(driver);

        homePage.hoverOverItem(driver);
        Assert.assertEquals(productDetailsPage.noteBookSuccessMessage.getText(),pro.getProperty("successMessage8"));

    }

}
