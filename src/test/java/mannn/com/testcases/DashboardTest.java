package mannn.com.testcases;

import mannn.com.common.SetupBrower;
import mannn.com.pages.DashboardPage;
import mannn.com.pages.SignInPage;
import org.testng.annotations.Test;

public class DashboardTest extends SetupBrower {
    SignInPage signInPage;
    DashboardPage dashboardPage;

    @Test (priority = 1)
    public void openMenuDashboard(){
        signInPage = new SignInPage(driver);
        dashboardPage = signInPage.signIn("man@email.com", "123456");
        dashboardPage.checkMenuExist();
        dashboardPage.openAddNewProductPage();
    }

    @Test (priority = 2)
    public void getListMenuTest(){
        dashboardPage.getListMenu();
    }
}
