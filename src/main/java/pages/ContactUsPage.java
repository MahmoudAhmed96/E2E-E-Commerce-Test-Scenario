package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ContactUsPage extends PageBase{
    public ContactUsPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(linkText = "Contact us")
    WebElement contactUsButt;

    @FindBy(name = "send-email")
    WebElement submitButt;

    @FindBy(id = "Enquiry")
    WebElement EnquiryBox;

    @FindBy(className = "result")
    public WebElement successMessage;

    public void openContactUs(WebDriver driver,String message)  {

        ScrollDown(driver);

        clickElement(contactUsButt);
        sendTxt(EnquiryBox,message);
        clickElement(submitButt);

    }

}
