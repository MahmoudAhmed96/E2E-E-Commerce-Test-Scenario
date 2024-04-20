package pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class PageBase {
    protected JavascriptExecutor js;
    protected Actions builder;
    protected WebDriverWait wait;

    public Select select;


    //Create Constructor to Initialize the driver
    public PageBase(WebDriver driver) {

        PageFactory.initElements(driver,this);
    }

    protected void clickElement(WebElement button){

        button.click();

    }

    protected void sendTxt(WebElement txtElement,String value){


        txtElement.sendKeys(value);
    }

    public void iamWait(WebDriver driver,WebElement element){
         wait=new WebDriverWait(driver, Duration.ofSeconds(10));
         wait.until(ExpectedConditions.elementToBeClickable(element));

    }

    public void iamImplicitWait(WebDriver driver){

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }

    public void MoveToElement(WebDriver driver,WebElement element ) {

        builder=new Actions(driver);
        builder.moveToElement(element).perform();

    }


    public void ScrollDown(WebDriver driver) {

        js =(JavascriptExecutor) driver;
        js.executeScript("scrollBy(0,2500)");



    }

    public void Dropdown(WebElement element,int index){

        select=new Select(element);
        select.selectByIndex(index);

    }




}
