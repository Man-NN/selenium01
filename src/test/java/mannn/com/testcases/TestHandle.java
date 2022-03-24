package mannn.com.testcases;

import mannn.com.common.SetupBrower;
import mannn.com.utils.WebUI;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

public class TestHandle{

    WebDriver driver;
    WebUI webUI;

    @Test
    public void testDropdown(){
        driver = new SetupBrower().createBrowser("edge");
        webUI = new WebUI(driver);

        driver.get("https://demo.anhtester.com/basic-select-dropdown-demo.html");
        webUI.waitForPageLoad();
        webUI.sleep(1);

        By dropdown = By.xpath("//select[@id='select-demo']");
        webUI.selectOptionByText(dropdown, "Friday");

        webUI.sleep(2);
        driver.quit();
    }

    @Test
    public void testDropdown2(){
        driver = new SetupBrower().createBrowser("firefox");
        webUI = new WebUI(driver);

        driver.get("https://demo.anhtester.com/basic-select-dropdown-demo.html");
        webUI.waitForPageLoad();
        webUI.sleep(1);

        By dropdown = By.xpath("//select[@id='select-demo']");
        webUI.selectOptionByText(dropdown, "Moday");

        webUI.sleep(2);
        driver.quit();
    }
}
