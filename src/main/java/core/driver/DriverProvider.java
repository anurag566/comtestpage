package core.driver;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.HashMap;

public class DriverProvider {
    private static HashMap<String,WebDriver> driverMap = new HashMap<>();

    public WebDriver getDriver() {
        return getChromeDriver();
    }

    private WebDriver getChromeDriver(){
        if(driverMap.containsKey("chrome")){
            return driverMap.get("chrome");
        }

        System.setProperty("webdriver.chrome.driver", "chromedriver");
        WebDriver driver = new ChromeDriver();
        driverMap.put("chrome",driver);
        return driver;
    }
}
