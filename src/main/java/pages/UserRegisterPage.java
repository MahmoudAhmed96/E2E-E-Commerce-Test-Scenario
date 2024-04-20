package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;



public class UserRegisterPage extends PageBase {

    //Override The Constructor
    public UserRegisterPage(WebDriver driver) {

        super(driver);
    }

    //Finding Element For Registration Page
    @FindBy(id = "gender-male")
    WebElement genderRdButton;

    @FindBy(id = "FirstName")
    WebElement fNameBox;

    @FindBy(id = "LastName")
    WebElement sNameBox;

    @FindBy(id = "Email")
    WebElement emailBox;

    @FindBy(id = "Password")
    WebElement passBox;

    @FindBy(id = "ConfirmPassword")
    WebElement conPassBox;

    @FindBy(id = "register-button")
    WebElement registerButton;

    //Element for assertion
    @FindBy(css = "div.result")
    public WebElement successMessage;

    @FindBy(css = "a.ico-logout")
   public WebElement logoutButton;

    //Element for assertion
    @FindBy(css ="a.ico-login")
    public WebElement SuccessMessage2;






    //Actions Executed in The page by the used
    //Adding (Data) as Parameters  as flexible Values (Not Hardcoded)
    public void userRegister(String fName,String sName,String email,String pass){

        clickElement(genderRdButton);
        sendTxt(fNameBox,fName);
        sendTxt(sNameBox,sName);
        sendTxt(emailBox,email);
        sendTxt(passBox,pass);
        sendTxt(conPassBox,pass);
        clickElement(registerButton);

    }

    public void userLogout(){

        clickElement(logoutButton);
    }







}
