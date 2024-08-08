package pages;

import base.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

public class Practice extends BasePage {
    //The Elements
    @FindBy(xpath = "/html/body/div[1]/div/header/div[2]/div/div/a/img")
    private WebElement mainTitle;
    @FindBy(xpath = "/html/body/div[1]/div/header/div[2]/div/div/a/img")
    private WebElement testLoginLink;
    @FindBy(xpath = "/html/body/div[1]/div/header/div[2]/div/div/a/img")
    private WebElement TestExceptionLink;
    @FindBy(xpath = "/html/body/div[1]/div/section/div/div/article/div[2]/div/div[1]/p/a")
    private List<WebElement> links;





    public Practice(WebDriver driver) {
        //Constructor
        super(driver);
    }

    //The Methods
    public String isTitleTrue(){
        return mainTitle.getText();
    }
    public int isNumberOfLinksTrue(){
        return links.size();
    }
    public Login isTestLoginLinkWorking(){
        // النقر على الزر
        testLoginLink.click();

        return new Login(driver);
    }



}
