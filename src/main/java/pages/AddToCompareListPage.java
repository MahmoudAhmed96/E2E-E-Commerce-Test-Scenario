package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.time.Duration;

public class AddToCompareListPage extends PageBase {
    public AddToCompareListPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(css = "button.button-2.add-to-compare-list-button")
    WebElement addToCompareButt;

    @FindBy(linkText = "product comparison")
    WebElement comparisonLink;

    @FindBy(linkText = "Apple MacBook Pro 13-inch")
    public WebElement productName;

    @FindBy(className = "clear-list")
    WebElement clearListButt;

    @FindBy(className = "no-data")
    public WebElement clearMessage;

    public void openCompareList(WebDriver driver){

        clickElement(addToCompareButt);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
        clickElement(comparisonLink);

    }

    public void clearCompareList(){

        clickElement(clearListButt);
    }


}
