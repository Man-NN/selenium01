package mannn.com.common;

import io.github.bonigarcia.wdm.WebDriverManager;
import mannn.com.utils.WebUI;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.*;

public class SetupBrower {
    public WebDriver driver;
    public WebUI webUI;

    @Parameters({"BrowerName"})

    @BeforeClass
    public void createDriver(@Optional("edge") String browserName, @Optional("https://anhtester.com") String url) {
        driver = createBrowser("chrome");
        webUI = new WebUI(driver);
    }

    public WebDriver createBrowser(String browsesrName){
        switch (browsesrName.trim().toLowerCase()){ //cắt khoảng trắng và chuyển tất cả về dạng chữ thường
            case "chrome": //Làm cái gì đó - Khởi tạo Chrome browser
                WebDriverManager.chromedriver().setup();
                driver = new ChromeDriver();
                System.out.println("Started Chrome Browser" + driver);
                driver.manage().window().maximize();
                break;
            case "edge":
                WebDriverManager.edgedriver().setup();
                driver = new EdgeDriver();
                System.out.println("Started Edge Browser" + driver);
                driver.manage().window().maximize();
                break;
            case "firefox":
                WebDriverManager.firefoxdriver().setup();
                driver = new FirefoxDriver();
                System.out.println("Started Firefox Browser" + driver);
                driver.manage().window().maximize();
                break;
            default:
                WebDriverManager.chromedriver().setup();
                driver = new ChromeDriver();
                System.out.println("Started Chrome Browser with default" + driver);
                driver.manage().window().maximize();
                break;
        }
        return driver; //Cách 2
    }

//    public WebDriver getDriver(){ //Cách 1
//        return driver;
//    }

    @AfterClass
    public void closeDriver(){
        driver.quit();
        System.out.println("Closes Driver");
    }
}
