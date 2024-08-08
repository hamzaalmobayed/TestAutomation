package pages;

import base.BasePage;
import net.sourceforge.tess4j.ITesseract;
import net.sourceforge.tess4j.Tesseract;
import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import javax.imageio.IIOImage;
import javax.imageio.ImageIO;
import javax.imageio.ImageTypeSpecifier;
import javax.imageio.ImageWriter;
import javax.imageio.metadata.IIOMetadata;
import javax.imageio.metadata.IIOMetadataNode;
import javax.imageio.stream.ImageOutputStream;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.Iterator;

public class Login extends BasePage {
    //The Elements
    @FindBy(xpath = "/html/body/div[1]/div/section/section/h2")
    private WebElement mainTitle;
    @FindBy(xpath = "/html/body/div[1]/div/section/section/div[1]/div[1]/label")
    private WebElement usernameLable;
    @FindBy(xpath = "/html/body/div[1]/div/section/section/div[1]/div[2]/label")
    private WebElement passwordLable;
    @FindBy(xpath = "//*[@id=\"username\"]")
    private WebElement usernameTextBox;
    @FindBy(xpath = "//*[@id=\"password\"]")
    private WebElement passwordTextBox;
    @FindBy(xpath = "//*[@id=\"error\"]")
    private WebElement errorMessage;
    @FindBy(xpath = "//*[@id=\"submit\"]")
    private WebElement submit;







    public Login(WebDriver driver) {
        //Constructor
        super(driver);
    }

    //The Methods
    public String isTitleTrue(){
        return mainTitle.getText();
    }
    public String isUsernamePresent(){
        return usernameLable.getText();
    }
    public String isPasswordPresent(){
        return passwordLable.getText();
    }
    public String isWrongUsername(){
        setTextElementText(usernameTextBox,"dfv");
        setTextElementText(passwordTextBox,"Password123");
        submit.click();
        return errorMessage.getText();
    }
    public String isWrongPassword(){
        setTextElementText(usernameTextBox,"student");
        setTextElementText(passwordTextBox,"Passwkjhg123");
        submit.click();
        return errorMessage.getText();
    }
    public String isWrongPasswordWrongUsername(){
        setTextElementText(usernameTextBox,"hgfgf");
        setTextElementText(passwordTextBox,"Passwkjhg123");
        submit.click();
        return errorMessage.getText();
    }
    public Logout isLoginWorking(){
        setTextElementText(usernameTextBox,"student");
        setTextElementText(passwordTextBox,"Password123");
        submit.click();
        return new Logout(driver);
    }




}
