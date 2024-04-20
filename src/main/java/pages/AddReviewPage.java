package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pages.PageBase;

public class AddReviewPage extends PageBase {
    public AddReviewPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(linkText = "Add your review")
    WebElement addReviewLink;

    @FindBy(id = "AddProductReview_Title")
    WebElement reviewTitle;

    @FindBy(id = "AddProductReview_ReviewText")
    WebElement reviewTextBox;

    @FindBy(id = "addproductrating_5")
    WebElement reviewRate;

    @FindBy(name = "add-review")
    WebElement addReviewButt;

    @FindBy(css = "div.result")
    public WebElement successMessage;



    public void goToReviewPage(String title,String reviewText){

        clickElement(addReviewLink);
        sendTxt(reviewTitle,title);
        sendTxt(reviewTextBox,reviewText);
        clickElement(reviewRate);
        clickElement(addReviewButt);

    }
}
