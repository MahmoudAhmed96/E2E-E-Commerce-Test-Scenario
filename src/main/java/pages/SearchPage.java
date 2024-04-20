package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class SearchPage extends PageBase{


    public SearchPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(id = "small-searchterms")
    WebElement searchBox;

    @FindBy(css = "button.button-1.search-box-button")
    WebElement searchButton;

    @FindBy(id = "ui-id-1")
   public WebElement popupItem;

    @FindBy(css = "strong.current-item")
    public WebElement itemName;

    @FindBy(linkText = "Apple MacBook Pro 13-inch")
    WebElement directLinkItem;


    public void searchProduct(String productName){

        sendTxt(searchBox,productName);
        clickElement(searchButton);
        clickElement(directLinkItem);

    }

    public void autoSuggestSearch(String productName, WebDriver driver){

        sendTxt(searchBox,productName);
        iamImplicitWait(driver);
        clickElement(popupItem);







    }
}
