package pages;

import base.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class Home extends BasePage {
    //The Elements
    @FindBy(xpath = "/html/body/div[1]/div/header/div[2]/div/div/a/img")
    private WebElement logo;
    @FindBy(xpath = "/html/body/div[1]/div/header/div[3]/div[1]/div/div[2]/div/nav/ul/li/a")
    private List<WebElement> tabs;
    @FindBy(xpath = "/html/body/div[1]/div/section/div/div/article/div[1]/h1")
    private WebElement mainTitle;
    @FindBy(xpath = "/html/body/div[1]/div/section/div/div/article/div[2]/p/strong")
    private List<WebElement> subTitle;
    @FindBy(xpath = "/html/body/div[1]/div/section/div/div/article/div[2]/div[1]/figure/img")
    private WebElement img;
    @FindBy(xpath = "/html/body/div[1]/div/header/div[3]/div[1]/div/div[2]/div/nav/ul/li[2]/a")
    private WebElement practiceTab;
    @FindBy(xpath = "//*[@id=\"form_email_7\"]")
    private WebElement emailTextField;
    @FindBy(xpath = "//*[@id=\"form_first_name_7\"]")
    private WebElement nameTextField;
    @FindBy(xpath = "/html/body/div[1]/div/section/div/div/article/div[2]/div[3]/form/div[3]/input\n")
    private WebElement loginButton;
    @FindBy(xpath = "/html/body/div[1]/div/section/div/div/article/div[2]/div[3]/form/div[3]/input\n")
    private WebElement header;
    @FindBy(xpath = "/html/body/div[1]/div/footer/div")
    private WebElement footer;








    public Home(WebDriver driver) {
        //Constructor
        super(driver);
    }

    //The Methods
    public boolean isLogoPresent(){
        return logo.isDisplayed();

    }
    public boolean isImgPresent(){
        return img.isDisplayed();

    }
    public boolean isHeaderPresent(){
        return header.isDisplayed();

    }public boolean isFooterPresent(){
        return footer.isDisplayed();

    }

    public int isNumberOfTabsTrue(){
        return tabs.size();
    }
    public int isNumberOfSubTitlesTrue(){
        return subTitle.size();
    }

    public String isTitleTrue(){
        return mainTitle.getText();
    }

    public XPath login(String email, String password) throws Exception {
        // Set the email and wait for a while
        setTextElementText(emailTextField, email);
        Thread.sleep(1000);

        // Set the password and wait for a while
        setTextElementText(nameTextField, password);
        Thread.sleep(1000);

        // Click the login button and wait for OTP field to be clickable
        loginButton.click();
        return new XPath(driver);
    }









}
