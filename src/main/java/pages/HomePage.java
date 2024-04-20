package pages;



import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;





public class HomePage extends PageBase {
    public HomePage(WebDriver driver) {
        super(driver);
    }

    @FindBy(linkText = "Register")
    WebElement registerLink;

    @FindBy(css = "a.ico-login")
    WebElement loginLink;

    @FindBy(id = "customerCurrency")
    WebElement currencyDropList;

    @FindBy(linkText = "Computers")
    WebElement computerMenu;

    @FindBy(linkText = "Notebooks")
    WebElement noteBookMenu;


    public void openRegisterPage(){

       clickElement(registerLink);

    }

    public void openLoginPage(){

        clickElement(loginLink);
    }

    public void changeCurrency(int index){

        Dropdown(currencyDropList,index);

    }

    public void hoverOverItem(WebDriver driver){

        MoveToElement(driver,computerMenu);
        MoveToElement(driver,noteBookMenu);
        clickElement(noteBookMenu);

    }











}
