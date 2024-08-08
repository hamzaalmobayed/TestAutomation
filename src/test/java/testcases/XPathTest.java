package testcases;
import base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.Practice;

//@Feature("Test Case")
public class XPathTest extends BaseTest {
    static Practice practice;

    @Test(priority = 0)
    public void isCaptchaWorkingWithCorrect() throws Exception {
        // Open the website and login
        try {
            Assert.assertEquals("Check your inbox or spam folder to confirm your subscription and get your FREE XPath cheat sheet.",HomeTest.login.checkCaptchaIsCorrect());
        } catch (Exception e) {
            System.out.println("Exception: " + e.getMessage());
        }
    }
    @Test(priority = 1)
    public void isCaptchaWorkingWithWrong() throws Exception {
        // Open the website and login
        try {
            Assert.assertEquals("The characters entered do not match with the previous CAPTCHA.",HomeTest.login.checkCaptchaIsWrong());
            HomeTest.login.checkCaptchaIsCorrect();
        } catch (Exception e) {
            System.out.println("Exception: " + e.getMessage());
        }
    }

    @Test(priority = 2)
    public void isTitleTrueTest() throws Exception {
        // Open the website and login

        try {
            Assert.assertEquals("Confirm you’re not a robot", HomeTest.login.isTitleTrue());
        } catch (Exception e) {
            System.out.println("Exception: " + e.getMessage());
        }
    }
    @Test(priority = 3)
    public void isOlderBlogerButtonWorking() throws Exception {
        // Open the website and login

        try {
            Assert.assertEquals("https://practicetestautomation.com/", HomeTest.login.isOlderBlogerButtonWorking());
        } catch (Exception e) {
            System.out.println("Exception: " + e.getMessage());
        }
    }
    @Test(priority = 4)
    public void isBackButtonWorking() throws Exception {
        // Open the website and login

        try {
            HomeTest.login.isBackWorking();
        } catch (Exception e) {
            System.out.println("Exception: " + e.getMessage());
        }
    }
    @Test(priority = 5)
    public void isNewerBlogerButtonWorking() throws Exception {
        // Open the website and login

        try {
            Assert.assertEquals("https://practicetestautomation.com/", HomeTest.login.isNewerBlogerButtonWorking());
        } catch (Exception e) {
            System.out.println("Exception: " + e.getMessage());
        }
    }
    @Test(priority = 6)
    public void isPracticeTabWorking() throws Exception {
        // Open the website and login

        try {
            practice=HomeTest.login.isPracticeTabWorking();
        } catch (Exception e) {
            System.out.println("Exception: " + e.getMessage());
        }
    }

}
