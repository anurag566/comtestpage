package core.actions;

import core.driver.DriverProvider;
import core.utility.Logs;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class WindowsActions {
    private Logs logs = null;
    private DriverProvider driver = null;

    public WindowsActions(){
        this.logs = new Logs();
        this.driver = new DriverProvider();
    }

    public void openWebPage(String url){
        this.driver.getDriver().get(url);
    }

    public void switchToIframe(int index){
        driver.getDriver().switchTo().frame(index);
    }
}
