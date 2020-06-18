import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.concurrent.TimeUnit;

public class ProjectSettings {

    private WebDriver driver;
    private ExtentReports extentReports;

    public void setProjectWebDriver(){
        System.setProperty("webdriver.chrome.driver"
                ,"/Users/igor_shved/Documents/Java/libraries/webDrivers/chromedriver");
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--disable-notifications");
        driver = new ChromeDriver(options);
        driver.manage().timeouts().pageLoadTimeout(15, TimeUnit.SECONDS);
        driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
        driver.manage().window().maximize();
    }

    public void setProjectReports(){
        ExtentHtmlReporter htmlReporter = new ExtentHtmlReporter("/Users/igor_shved/Desktop/reports/facebook_signIn_report.html");
        extentReports = new ExtentReports();
        extentReports.attachReporter(htmlReporter);
        extentReports.setSystemInfo("Environment", "Production");
        extentReports.setSystemInfo("Dveloper", "Mayer Shved");
    }

    public WebDriver getDriver(){
        return this.driver;
    }

    public ExtentReports getExtentReports(){
        return this.extentReports;
    }
}