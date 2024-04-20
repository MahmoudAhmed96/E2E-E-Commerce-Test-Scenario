package steps;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;
import pages.HomePage;
import pages.LoginPage;
import pages.UserRegisterPage;
import tests.TestBase;

public class Login extends TestBase {
    HomePage homePage;
    LoginPage loginPage;

    UserRegisterPage register;

    String fName="Mahmoud";
    String sName="Ahmed";
    String Email="Jeka9@gmail.com";
    String Password="123456";

    @Given("The user in the homePage")
    public void the_in_the_home_page() {
        homePage=new HomePage(driver);
        homePage.openRegisterPage();

    }
    @When("user clicks on register link and register")
    public void user_clicks_on_register_link_and_register() {
        register=new UserRegisterPage(driver);
        register.userRegister(fName,sName,Email,Password);
        Assert.assertEquals(register.successMessage.getText(),"Your registration completed");
    }
    @When("user clicks on Login")
    public void user_clicks_on_login() {
        homePage=new HomePage(driver);
        homePage.openLoginPage();

    }
    @When("user enters Valid username And Password")
    public void user_enters_valid_username_and_password() {
        loginPage=new LoginPage(driver);
        loginPage.userLogin(Email,Password);
    }
    @Then("user can login successfully")
    public void user_can_login_successfully() {
        Assert.assertEquals(loginPage.logoutButton.getText(),"Log out");
    }
}
