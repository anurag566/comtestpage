package core.actions;

import core.driver.DriverProvider;
import core.utility.Logs;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class ClickActions {
    private DriverProvider driverProvider;
    private Logs logs;

    public ClickActions(){
        driverProvider = new DriverProvider();
        logs = new Logs();
    }

    public void click(WebElement element) {
        try{
            element.click();
        }catch (Exception e){
            logs.log("Error while click on element" + e);
        }
    }

    public void javaScriptClick(WebElement element){
        try {
            JavascriptExecutor executor = (JavascriptExecutor) driverProvider.getDriver();
            executor.executeScript("arguments[0].click();", element);
        }catch (Exception e){
            logs.log("Error while click by javascript.");
        }
    }

    public void actionClick(WebElement element){
        try {
            Actions actions = new Actions(driverProvider.getDriver());
            actions.moveToElement(element).click().build().perform();
        }catch (Exception e){
            logs.log("Error while click by actions.");
        }

    }
}
