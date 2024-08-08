package testcases;
import base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.Login;

//@Feature("Test Case")
public class PracticeTest extends BaseTest {
    static Login login;

    @Test(priority = 0)
    public void isTitleTrueTest() throws Exception {
        // Open the website and login

        try {
            Assert.assertEquals("Practice", XPathTest.practice.isTitleTrue());
        } catch (Exception e) {
            System.out.println("Exception: " + e.getMessage());
        }
    }
    @Test(priority = 1)
    public void isNumberOfTabsTrueTest() throws Exception {
        // Open the website and login
        try {
            Assert.assertEquals(2, XPathTest.practice.isNumberOfLinksTrue());
        } catch (Exception e) {
            System.out.println("Exception: " + e.getMessage());
        }
    }
    @Test(priority = 2)
    public void isOlderBlogerButtonWorking() throws Exception {
        // Open the website and login

        try {
            login=XPathTest.practice.isTestLoginLinkWorking();
        } catch (Exception e) {
            System.out.println("Exception: " + e.getMessage());
        }
    }
}
