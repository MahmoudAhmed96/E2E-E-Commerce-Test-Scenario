package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends PageBase{
    public LoginPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(id = "Email")
    WebElement emailBox;

    @FindBy(id= "Password")
    WebElement passBox;

    @FindBy(css = "button.button-1.login-button")
    WebElement loginButton;

    @FindBy(css = "a.ico-logout")
    public WebElement logoutButton;



    public void userLogin(String email,String password){

        sendTxt(emailBox,email);
        sendTxt(passBox,password);
        clickElement(loginButton);


    }
}
