package base;


import factory.DriverFactory;
import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.annotations.*;

import java.util.ArrayList;
import java.util.List;

public class BaseTest {
    protected ThreadLocal<WebDriver>  driver = new ThreadLocal<>();


     public WebDriver getDriver(){
        return this.driver.get();
     }

    public void setDriver(WebDriver driver) {
    this.driver.set(driver);
     }

    @BeforeTest
    public void setup(){
        WebDriver driver = new DriverFactory().initializeDriver("chrome");
        setDriver(driver);
     }

//    @AfterTest
//    public void teardown(){
//        getDriver().quit();
//    }

}
