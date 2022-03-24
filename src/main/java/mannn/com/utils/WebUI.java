package mannn.com.utils;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class WebUI {
    WebDriver driver;
    WebDriverWait wait;
    Select select;
    Actions actions;

    int PAGE_LOAD_TIMEOUT = 20;
    int ELEMENT_LOAD_TIMEOUT = 10; //10s tối đa có thể đợi

    public WebUI(WebDriver _driver){
        driver = _driver;
        wait = new WebDriverWait(driver, ELEMENT_LOAD_TIMEOUT);
        actions = new Actions(driver);
    }

    //Hàm xử lý chung
    public WebElement getElement(By locator){
        wait.until(ExpectedConditions.visibilityOfElementLocated(locator)); //Đợi locator ổn định
        return driver.findElement(locator); //Trả về đối tượng WebElement của chính locator truyền vào
    }

    public List<WebElement> getElements(By locator){
        wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
        return driver.findElements(locator);
    }

    public boolean verifyElementExits(By locator){
        List<WebElement> listElements = getElements(locator); //List element tìm được
        if (listElements.size() > 0){
            return true; //Tìm thấy/ Tồn tại element
        } else {
            return false;
        }
    }

    public void moveToElement(By locator){
        actions.moveToElement(getElement(locator)).perform();
    }
    
    //Handle Select Dropdown
    public void selectOptionByText(By locator, String Text){
        select = new Select(getElement(locator));
        select.selectByVisibleText(Text);
    }

    public void selectOptionByValue(By locator, String Value){
        select = new Select(getElement(locator));
        select.selectByValue(Value);
    }

    public void selectOptionByIndex(By locator, int Index){
        select = new Select(getElement(locator));
        select.selectByIndex(Index);
    }

    public String getElementText(By locator){
        return getElement(locator).getText();
    }

    public String getElementText(WebElement webElement){
        return webElement.getText();
    }

    public boolean verifyElementText(By locator, String text){
        return getElement(locator).getText().equals(text);
    }

    //Click element with Explicit wait
    public void clickElement(By element){
//        wait.until(ExpectedConditions.visibilityOfElementLocated(element)); //Đợi cho đến khi element xuất hiện
//        driver.findElement(element).click();
        getElement(element).click();
    }

    //Enter data on element with Explicit wait
    public void setText(By element, String value){
//        wait.until(ExpectedConditions.visibilityOfElementLocated(element));
//        driver.findElement(element).sendKeys(value);
        getElement(element).sendKeys(value);
    }

    //Wait page load
    public void waitForPageLoad(){
        ExpectedCondition<Boolean> jQueryLoad = new ExpectedCondition<Boolean>() {
            @Override
            public Boolean apply(WebDriver driver) {
                try {
                    return ((Long) ((JavascriptExecutor) driver).executeScript("return jQuery.active") == 0);
                }catch (Exception e){
                    return true;
                }
            }
        };

        //Wait for Javascript to loaded
        ExpectedCondition<Boolean> jsLoad = new ExpectedCondition<Boolean>() {
            @Override
            public Boolean apply(WebDriver driver) {
                return ((JavascriptExecutor) driver).executeScript("return document.readyState")
                        .toString().equals("complete");
            }
        };

        try {
            wait = new WebDriverWait(driver, PAGE_LOAD_TIMEOUT);
            wait.until(jQueryLoad);
            wait.until(jsLoad);
        } catch (Throwable error){
            error.getMessage();
        }
    }

    public void sleep(int second){
        try {
            Thread.sleep(second * 1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}
