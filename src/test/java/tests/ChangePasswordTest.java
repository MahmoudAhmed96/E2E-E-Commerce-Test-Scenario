package tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.*;

public class ChangePasswordTest extends TestBase {

    HomePage homePage;
    LoginPage loginPage;
    MyAccountPage myAccountPage;
    UserRegisterPage register;


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

    @Test(priority = 2)
    public void userCanChangePassword(){

        myAccountPage=new MyAccountPage(driver);

        myAccountPage.openMyAccountPage();
        myAccountPage.openChangePass(pro.getProperty("password"),pro.getProperty("newPassword"));
        Assert.assertEquals(myAccountPage.successMessage.getText(),pro.getProperty("successMessage6"));
    }

    @Test(priority = 3)
    public void userCanLogout()  {

        PageBase pageBase=new PageBase(driver);
        UserRegisterPage userRegisterPage=new UserRegisterPage(driver);

        //driver.manage().window().fullscreen();
        pageBase.MoveToElement(driver,register.logoutButton);
        userRegisterPage.userLogout();
    }

    @Test(priority = 4)
    public void userCanReLogin(){

        homePage=new HomePage(driver);
        homePage.openLoginPage();

        loginPage=new LoginPage(driver);
        loginPage.userLogin(pro.getProperty("email"),pro.getProperty("newPassword"));
        Assert.assertEquals(loginPage.logoutButton.getText(),pro.getProperty("successMessage2"));
    }

}
