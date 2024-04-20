package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class MyAccountPage extends PageBase {


    public MyAccountPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(css = "a.ico-account")
    WebElement myAccountButton;

    @FindBy(linkText = "Change password")
    WebElement changePassLink;

    @FindBy(id = "OldPassword")
    WebElement oldPasswordBox;

    @FindBy(id = "NewPassword")
    WebElement newPasswordBox;

    @FindBy(id = "ConfirmNewPassword")
    WebElement confirmPasswordBox;

    @FindBy(css = "button.button-1.change-password-button")
    WebElement changePassButton;

    @FindBy(css = "div.bar-notification.success")
    public WebElement successMessage;

    @FindBy(css = "span.close")
    WebElement closeMessageButton;




    public void openMyAccountPage(){

        clickElement(myAccountButton);

    }

    public void openChangePass(String oldPassword,String newPassword){

        clickElement(changePassLink);
        sendTxt(oldPasswordBox,oldPassword);
        sendTxt(newPasswordBox,newPassword);
        sendTxt(confirmPasswordBox,newPassword);
        clickElement(changePassButton);
        clickElement(closeMessageButton);
    }





}
