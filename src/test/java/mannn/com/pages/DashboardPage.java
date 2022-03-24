package mannn.com.pages;

import mannn.com.utils.WebUI;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import java.util.List;

public class DashboardPage {
    WebDriver driver = null;
    WebUI webUI;

    By listMenuLocator = By.xpath("//ul[@id='main-menu']//li");
    By menuProducts = By.xpath("//span[normalize-space()='Products']");
    By menuAddNewProduct = By.xpath("//span[normalize-space()='Add New Product']");

    public DashboardPage(WebDriver _driver){
        driver = _driver;
        webUI = new WebUI(driver);
    }

    public AddNewProductPage openAddNewProductPage(){
        webUI.clickElement(menuProducts);
        webUI.clickElement(menuAddNewProduct);
        return new AddNewProductPage(driver);
    }

    public void getListMenu(){
        webUI.getElement(listMenuLocator); //Các item
        List<WebElement> listMenu = webUI.getElements(listMenuLocator); //List WebElement
        System.out.println("Số Menu: " + listMenu.size());
        for(WebElement element : listMenu) {
//            System.out.println(element.getText());
            System.out.println(webUI.getElementText(element));
        }
    }

    public void checkMenuExist(){
        Assert.assertTrue(webUI.verifyElementExits(menuProducts), "Không tìm thấy menu");
    }

}
