package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.time.Duration;

public class WishListPage extends PageBase{

    public WishListPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(id = "product_enteredQuantity_4")
    WebElement productQuantity;

    @FindBy(id = "add-to-wishlist-button-4")
    WebElement wishListButt;

    @FindBy(linkText = "wishlist")
    public WebElement wishListPageLink;

    @FindBy(className = "page-title")
    public WebElement pageTitle;

    @FindBy(name = "itemquantity11232")
    public WebElement wishListQuantity;

    @FindBy(className = "product-unit-price")
    public WebElement productPrice;

    @FindBy(className = "product-subtotal")
    public WebElement totalPrice;

    public void addToWishList(WebDriver driver){

        productQuantity.clear();
        sendTxt(productQuantity,"3");
        clickElement(wishListButt);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
        clickElement(wishListPageLink);


    }






}
