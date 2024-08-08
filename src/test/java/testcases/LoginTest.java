package testcases;
import base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.Logout;
import pages.Practice;

//@Feature("Test Case")
public class LoginTest extends BaseTest {
    static Logout logout;


    @Test(priority = 0)
    public void isTitleTrueTest() throws Exception {
        // Open the website and login

        try {
            Assert.assertEquals("Test login", PracticeTest.login.isTitleTrue());
        } catch (Exception e) {
            System.out.println("Exception: " + e.getMessage());
        }
    }
    @Test(priority = 1)
    public void isPasswordPresent() throws Exception {
        // Open the website and login

        try {
            Assert.assertEquals("Password", PracticeTest.login.isPasswordPresent());
        } catch (Exception e) {
            System.out.println("Exception: " + e.getMessage());
        }
    }
    @Test(priority = 2)
    public void isUsernamePresent() throws Exception {
        // Open the website and login

        try {
            Assert.assertEquals("Username", PracticeTest.login.isUsernamePresent());
        } catch (Exception e) {
            System.out.println("Exception: " + e.getMessage());
        }
    }


}
