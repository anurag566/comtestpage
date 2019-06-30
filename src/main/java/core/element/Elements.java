package core.element;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class Elements {

    public WebElement getElement(WebDriver driver, String locator, String value) {
        return getEl(driver,locator,value);
    }

    public List<WebElement> getElements(WebDriver driver, String locator, String value) {
        return getEls(driver,locator,value);
    }

    private WebElement getEl(WebDriver driver,String locator, String value){
        String val = locator.toLowerCase();
        switch (val){
            case "id" :
                return driver.findElement(By.id(value));
            case "name" :
                return driver.findElement(By.name(value));
            case  "xpath" :
                return driver.findElement(By.xpath(value));
            default:
                return  null;
        }
    }

    private List<WebElement> getEls(WebDriver driver,String locator, String value){
        String val = locator.toLowerCase();
        switch (val){
            case "id" :
                return driver.findElements(By.id(value));
            case "name" :
                return driver.findElements(By.name(value));
            case  "xpath" :
                return driver.findElements(By.xpath(value));
            default:
                return  null;
        }
    }

}
