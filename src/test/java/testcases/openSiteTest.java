package testcases;

import base.BaseTest;
import pages.Home;
import pages.openSite;
import org.testng.annotations.Test;
import utils.ConfigUtils;

//@Feature("Test Case")
public class openSiteTest extends BaseTest {
    static Home homePage;
    @Test(priority = 0)
// This test opens the website and performs a login
    public void openAndLogin() throws Exception {
        // Create a new instance of the Login page
        openSite returnHome = new openSite(getDriver());

        // Open the website and login
        homePage=returnHome.loadWebSite().openSite();
    }


}
