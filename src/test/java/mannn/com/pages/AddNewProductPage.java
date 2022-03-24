package mannn.com.pages;

import mannn.com.utils.WebUI;
import org.openqa.selenium.*;
import org.testng.Assert;
import org.openqa.selenium.JavascriptExecutor;

public class AddNewProductPage {
    WebDriver driver = null;
    WebUI webUI;
    JavascriptExecutor js = null;

    By headerAddNewProductPage = By.xpath("//h5[normalize-space()='Add New Product']");
    By productNameInput = By.xpath("//input[@placeholder='Product Name']");
    By categoryDropdown = By.xpath("//div[contains(text(),'Computer & Accessories')]");
    By categoryInput = By.xpath("//div[@class='dropdown-menu show']//input[@aria-label='Search']");
    By unitInput = By.xpath("//input[@placeholder='Unit (e.g. KG, Pc etc)']");
    By tagsInput = By.xpath("//span[@role='textbox']");
    By productImages = By.xpath("//h5[normalize-space()='Product Images']");
    By galleryImageBrowse = By.xpath("//div[@data-multiple='true']");
    By chooseImage = By.xpath("//div[@title='Zoro wallpaper.jpg']//img[@class='img-fit']");
    By addFilesBtn = By.xpath("//button[normalize-space()='Add Files']");
    By unitPriceInput = By.xpath("//input[@placeholder='Unit price']");
    By discountInput = By.xpath("//input[@placeholder='Discount']");
    By quantityInput = By.xpath("//input[@placeholder='Quantity']");
    By metaTitleInput = By.xpath("//input[@placeholder='Meta Title']");
    By saveAndPublishBtn = By.xpath("//button[normalize-space()='Save & Publish']");

    By headerAllProductsPage = By.xpath("//h1[normalize-space()='All products']");
    By searchInput = By.xpath("//input[@id='search']");
    By resultSearch = By.xpath("//table//tbody//tr[1]/td[2]//div//span");

    public AddNewProductPage(WebDriver _driver){
        driver = _driver;
        webUI = new WebUI(driver);
        js = (JavascriptExecutor) driver;
    }

    public void addNewProduct(String nameProduct){
//        Assert.assertEquals(driver.findElement(headerAddNewProductPage).getText(), "Add New Product");
        Assert.assertEquals(webUI.getElement(headerAddNewProductPage).getText(), "Add New Product");
        webUI.setText(productNameInput, nameProduct);
        webUI.clickElement(categoryDropdown);
        webUI.setText(categoryInput, "Notebook");
        driver.findElement(categoryInput).sendKeys(Keys.ENTER);
        webUI.setText(unitInput, "200 pages");
        webUI.setText(tagsInput, "#notebook");
//        js.executeScript("arguments[0].scrollIntoView(true);", driver.findElement(By.xpath("//h5[normalize-space()='Product Images']")));
        js.executeScript("arguments[0].scrollIntoView(true);", webUI.getElement(productImages));
        webUI.clickElement(galleryImageBrowse);
        webUI.clickElement(chooseImage);
        webUI.clickElement(addFilesBtn);
//        js.executeScript("arguments[0].scrollIntoView(true);", driver.findElement(unitPriceInput));
        js.executeScript("arguments[0].scrollIntoView(true);", webUI.getElement(unitPriceInput));
        webUI.setText(unitPriceInput, "Quyển");
        webUI.setText(discountInput, "10%");
        webUI.setText(quantityInput, "10");
//        js.executeScript("arguments[0].scrollIntoView(true);", driver.findElement(metaTitleInput));
        js.executeScript("arguments[0].scrollIntoView(true);", webUI.getElement(metaTitleInput));
        webUI.setText(metaTitleInput, "272727");
        webUI.clickElement(saveAndPublishBtn);
        webUI.waitForPageLoad();
    }

    public void checkNewProduct(String nameProduct){
//        Assert.assertEquals(driver.findElement(headerAllProductsPage).getText(), "All products");
        Assert.assertEquals(webUI.getElement(headerAllProductsPage).getText(), "All products");
        webUI.setText(searchInput, nameProduct);
//        driver.findElement(searchInput).sendKeys(Keys.ENTER);
        webUI.getElement(searchInput).sendKeys(Keys.ENTER);
        webUI.sleep(2);
        webUI.waitForPageLoad();
//        Assert.assertEquals(driver.findElement(resultSearch).getText(), nameProduct);
        Assert.assertEquals(webUI.getElement(resultSearch).getText(), nameProduct);
    }

}
