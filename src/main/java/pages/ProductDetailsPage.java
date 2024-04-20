package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ProductDetailsPage extends PageBase{


    public ProductDetailsPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(id = "price-value-4")
    public WebElement successMessage;

    @FindBy (css = "div.page-title")
    public WebElement noteBookSuccessMessage;

}
