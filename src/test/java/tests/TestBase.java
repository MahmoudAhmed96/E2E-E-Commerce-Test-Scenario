package tests;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import utility.Helper;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class TestBase extends AbstractTestNGCucumberTests {

   public static WebDriver driver;
   protected static Properties pro=new Properties();


   @BeforeClass
   public void LoadData() throws IOException {

       File file=new File("src/test/java/data/Data.properties");
       FileInputStream fis=new FileInputStream(file);
       pro.load(fis);
       fis.close();
   }


    @BeforeTest
    public void startDriver(){

         driver=new ChromeDriver();
         driver.get("https://demo.nopcommerce.com/");
         driver.manage().window().maximize();


    }

    //	@AfterSuite
    //	public void stopDriver() {
    //
    //
    //		driver.quit();
    //
    //	}

    //Take screenshot when testcase fail
    @AfterMethod
    public void ScreenshotOnFailure(ITestResult result) throws IOException {

        if (result.getStatus()==ITestResult.FAILURE) {

            System.out.println("Failed");
            System.out.println("Taking ScreenShot....");
            Helper.captureScreenshot(driver, result.getName());

        }


    }
}
