package mannn.com.pages;

import mannn.com.utils.WebUI;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class SignInPage {
    WebDriver driver = null;
    WebUI webUI;


    //Khai báo element
    By headerSignInPage = By.xpath("//h1[normalize-space()='Welcome to AT eCommerce']");
    By emailInput = By.xpath("//input[@id='email']");
    By passwordInput = By.xpath("//input[@id='password']");
    By rememberMeCheckBox = By.xpath("//span[@class='aiz-square-check']");
    By forgotPasswordBtn = By.xpath("//a[normalize-space()='Forgot password ?']");
    By signInBtn = By.xpath("//button[normalize-space()='Login']");
    By emailForgotPwInput = By.xpath("//input[@placeholder='Email']");
    By sendPwBtn = By.xpath("//button[normalize-space()='Send Password Reset Link']");

    public SignInPage(WebDriver _driver){
        driver = _driver;
        webUI = new WebUI(driver);
    }

    //Xử lý
    //SignIn
    public DashboardPage signIn(String email, String password){
        driver.get("https://ecommerce.anhtester.com/login");
//        Assert.assertEquals(driver.findElement(headerSignInPage).getText(), "Welcome to AT eCommerce");
        webUI.waitForPageLoad();
        Assert.assertEquals(webUI.getElement(headerSignInPage).getText(), "Welcome to AT eCommerce");
        Assert.assertEquals(webUI.getElement(emailInput).getAttribute("placehodler"), "Email", "Placehoder email chưa đúng");
//        Hoặc
//        Assert.assertTrue(webUI.getElement(emailInput).getAttribute("placehodler").equals("Email"), "Placehoder email chưa đúng");
        webUI.setText(emailInput, email);
        Assert.assertEquals(webUI.getElement(passwordInput).getAttribute("placehodler"), "Password", "Placehoder password chưa đúng");
        webUI.setText(passwordInput, password);
        webUI.clickElement(rememberMeCheckBox);
        Assert.assertTrue(webUI.verifyElementText(signInBtn, "Sign in"));
        webUI.clickElement(signInBtn);
        webUI.waitForPageLoad();

        return new DashboardPage(driver);
    }

    public void verifyDashboardUrl(){
        Assert.assertEquals(driver.getCurrentUrl(), "https://ecommerce.anhtester.com/admin", "Chuyển hướng chưa đúng link Url");
    }

    public void verifyForgotPwUrl(){
        Assert.assertEquals(driver.getCurrentUrl(), "https://ecommerce.anhtester.com/password/reset", "Chuyển hướng chưa đúng link Url");
    }

    public void forgotPassword(String email){
        webUI.clickElement(forgotPasswordBtn);
        webUI.setText(emailForgotPwInput, email);
        webUI.clickElement(sendPwBtn);
    }

}


