package testcases;
import base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.Logout;

//@Feature("Test Case")
public class LogoutTest extends BaseTest {
    static Logout logout;


    @Test(priority = 0)
    public void isTitleTrueTest() throws Exception {
        // Open the website and login

        try {
            Assert.assertEquals("Logged In Successfully", LoginTest.logout.isTitleTrue());
        } catch (Exception e) {
            System.out.println("Exception: " + e.getMessage());
        }
    }
    @Test(priority = 1)
    public void isSuccessMessagePresent() throws Exception {
        // Open the website and login

        try {
            Assert.assertEquals("Congratulations student. You successfully logged in!", LoginTest.logout.isSuccessMessagePresent());
        } catch (Exception e) {
            System.out.println("Exception: " + e.getMessage());
        }
    }
    @Test(priority = 2)
    public void isLogoutWorking() throws Exception {
        // Open the website and login

        try {
            Assert.assertEquals("https://practicetestautomation.com/practice-test-login/", LoginTest.logout.isLogoutButtonWorking());
        } catch (Exception e) {
            System.out.println("Exception: " + e.getMessage());
        }
    }



}
