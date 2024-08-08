package pages;

import base.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class Logout extends BasePage {
    //The Elements
    @FindBy(xpath = "/html/body/div[1]/div/section/div/div/article/div[1]/h1")
    private WebElement mainTitle;
    @FindBy(xpath = "/html/body/div[1]/div/section/div/div/article/div[2]/p[1]/strong")
    private WebElement successMessage;
    @FindBy(xpath = "/html/body/div[1]/div/section/div/div/article/div[2]/div/div/div/a")
    private WebElement logoutButton;




    public Logout(WebDriver driver) {
        //Constructor
        super(driver);
    }

    //The Methods
    public String isTitleTrue(){
        return mainTitle.getText();
    }
    public String isSuccessMessagePresent(){
        return successMessage.getText();
    }
    public String isLogoutButtonWorking(){
        // النقر على الزر
        logoutButton.click();

        // انتظار الانتقال إلى الصفحة الجديدة (استبدل "new_page_url" بعنوان URL الفعلي للصفحة الجديدة)
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.urlContains("https://practicetestautomation.com/practice-test-login/"));

        // التحقق من أن العنوان URL الحالي هو العنوان المتوقع
        return driver.getCurrentUrl();
    }




}
