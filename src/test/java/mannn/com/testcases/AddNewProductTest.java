package mannn.com.testcases;

import mannn.com.common.SetupBrower;
import mannn.com.pages.AddNewProductPage;
import mannn.com.pages.DashboardPage;
import mannn.com.pages.SignInPage;
import org.testng.annotations.Test;

public class AddNewProductTest extends SetupBrower {
    SignInPage signInPage;
    DashboardPage dashboardPage;
    AddNewProductPage addNewProductPage;

    @Test
    public void addNewProduct() {
        signInPage = new SignInPage(driver);
        dashboardPage =signInPage.signIn("man@email.com", "123456");
        addNewProductPage = dashboardPage.openAddNewProductPage();
        addNewProductPage.addNewProduct("Sổ ghi chép");
        addNewProductPage.checkNewProduct("Sổ ghi chép");
    }
}
