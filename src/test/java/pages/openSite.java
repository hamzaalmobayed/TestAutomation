package pages;

import base.BasePage;
import utils.ConfigUtils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class openSite extends BasePage {
    public openSite(WebDriver driver) {
        //Constructor
        super(driver);
    }

    //The Methods
    public openSite loadWebSite() {
        // Load the website using the configured base URL
        driver.get(ConfigUtils.getInstance().getBaseUrl());
        // Return a new instance of the Login page
        return new openSite(driver);
    }

    public Home openSite() throws Exception {
        // Set the email and wait for a while

        return new Home(driver);
    }








}
