package core.element;

import core.driver.DriverProvider;
import core.utility.Logs;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class Visibility {
    private Logs logs = null;
    private DriverProvider driver = null;

    public Visibility(){
        this.logs = new Logs();
        this.driver = new DriverProvider();
    }

    public boolean isVisible(WebElement element, String condition){
        return getVisibility(element,condition);
    }

    public boolean isElementsVisible(List<WebElement> elements, String condition) {
        return getElementsVisibility(elements,condition);
    }

    private boolean getVisibility(WebElement element, String condition){
        switch (condition.toLowerCase()){
            case "enable":
                return enable(element);
            case "displayed":
                return displayed(element);
            case "enable_visible":
                return enableVisible(element);
                default:
                logs.log("Wrong Visibility Condition : "+condition);
                return false;
        }
    }

    private boolean getElementsVisibility(List<WebElement> element, String condition){
        switch (condition.toLowerCase()){
            case "visibilityall":
                return visibilityOfAll(element);
            case "existall":
                return existAll(element);
            default:
                logs.log("Wrong Visibility Condition : "+condition);
                return false;
        }
    }

    private boolean enable(WebElement element) {
        return element.isEnabled();
    }

    private boolean displayed(WebElement element) {
        return element.isDisplayed();
    }

    private boolean enableVisible(WebElement element) {
        return (element.isEnabled() && element.isDisplayed());
    }

    private boolean visibilityOfAll(List<WebElement> elements){
        List<WebElement> elementList = getWait().until(ExpectedConditions.visibilityOfAllElements(elements));
        if(elementList.size() == elements.size()){
            return true;
        }
        return false;
    }

    private WebDriverWait getWait(){
        return new WebDriverWait(driver.getDriver(),1);
    }

    private boolean existAll(List<WebElement> elements){
        if(elements.size()>=1){
            return true;
        }
        return false;
    }
}
