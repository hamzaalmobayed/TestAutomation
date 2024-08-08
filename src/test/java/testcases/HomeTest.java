package testcases;
import base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.XPath;
import utils.ConfigUtils;

//@Feature("Test Case")
public class HomeTest extends BaseTest {

    // Create a new instance of the Login page

    static XPath login;

    @Test(priority = 0)
    public void isLogoPresentTest() throws Exception {
        // Open the website and login
        try {
            Assert.assertTrue(openSiteTest.homePage.isLogoPresent());
        } catch (Exception e) {
            System.out.println("Exception: " + e.getMessage());
        }
    }

    @Test(priority = 1)
    public void isImgPresentTest() throws Exception {
        // Open the website and login
        try {
            Assert.assertTrue(openSiteTest.homePage.isImgPresent());
        } catch (Exception e) {
            System.out.println("Exception: " + e.getMessage());
        }
    }
    @Test(priority = 2)
    public void isHeaderPresentTest() throws Exception {
        // Open the website and login
        try {
            Assert.assertTrue(openSiteTest.homePage.isHeaderPresent());
        } catch (Exception e) {
            System.out.println("Exception: " + e.getMessage());
        }
    }
    @Test(priority = 3)
    public void isFooterPresentTest() throws Exception {
        // Open the website and login
        try {
            Assert.assertTrue(openSiteTest.homePage.isFooterPresent());
        } catch (Exception e) {
            System.out.println("Exception: " + e.getMessage());
        }
    }

    @Test(priority = 4)
    public void isNumberOfTabsTrueTest() throws Exception {
        // Open the website and login
        try {
            Assert.assertEquals(5,openSiteTest.homePage.isNumberOfTabsTrue());
        } catch (Exception e) {
            System.out.println("Exception: " + e.getMessage());
        }
    }
    @Test(priority = 5)
    public void isNumberOfSubTitlesTrueTest() throws Exception {
        // Open the website and login
        try {
            Assert.assertEquals(7,openSiteTest.homePage.isNumberOfSubTitlesTrue());
        } catch (Exception e) {
            System.out.println("Exception: " + e.getMessage());
        }
    }
    @Test(priority = 6)
    public void isTitleTrueTest() throws Exception {
        // Open the website and login

        try {
            Assert.assertEquals("Hello",openSiteTest.homePage.isTitleTrue());
        } catch (Exception e) {
            System.out.println("Exception: " + e.getMessage());
        }
    }
    @Test(priority = 7)
    public void isLoginWorkingTest() throws Exception {
        // Open the website and login
        try{
            login =openSiteTest.homePage.login(ConfigUtils.getInstance().getMerchantEmail(), ConfigUtils.getInstance().getMerchantPassword());
        } catch (Exception e) {
            System.out.println("Exception: " + e.getMessage());
        }
    }







}
