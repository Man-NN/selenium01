package mannn.com.testcases;

import mannn.com.common.SetupBrower;
import mannn.com.pages.SignInPage;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class SignInTest extends SetupBrower {
    SignInPage signInPage;

    @BeforeClass
    public void setUpClass(){
        signInPage = new SignInPage(driver);
    }

    @Test
    public void signInTest() {
        signInPage.signIn("man@email.com", "123456");
        signInPage.verifyDashboardUrl();
    }

}
