package tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.ContactUsPage;
import pages.HomePage;
import pages.LoginPage;
import pages.UserRegisterPage;

public class ContactUsTest extends TestBase{

    //Taking Objects From Pages Class To call their Methods
    HomePage homePage;
    UserRegisterPage register;
    LoginPage loginPage;


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
    public void userCanOpenContactUs()  {

        ContactUsPage contactUsPage =new ContactUsPage(driver);
        contactUsPage.openContactUs(driver, pro.getProperty("message"));
        Assert.assertTrue(contactUsPage.successMessage.getText().contains(pro.getProperty("successMessage7")));

    }


}
