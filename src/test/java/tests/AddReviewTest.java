package tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.*;

public class AddReviewTest extends TestBase{

    //Instances
    HomePage homePage;
    UserRegisterPage register;
    LoginPage loginPage;
    SearchPage searchPage;
    AddReviewPage addReviewPage;


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
    public void userCanSearchProduct(){

        //By SearchButton

        searchPage=new SearchPage(driver);
        searchPage.searchProduct(pro.getProperty("productName"));
        Assert.assertTrue(searchPage.itemName.getText().equalsIgnoreCase(pro.getProperty("productName")));
        Assert.assertEquals(searchPage.itemName.getText(),pro.getProperty("productName"));

    }

    @Test(dependsOnMethods = "userCanSearchProduct")
    public void userCanAddReview(){

         addReviewPage=new AddReviewPage(driver);

         addReviewPage.goToReviewPage(pro.getProperty("title"),pro.getProperty("reviewText"));
         Assert.assertEquals(addReviewPage.successMessage.getText(),pro.getProperty("successMessage4"));
    }
}
