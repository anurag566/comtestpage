package objectRepo.objectProvider;

import core.element.ProcessElement;
import core.utility.Logs;
import objectRepo.objectInfo.LocationPageInfo;
import org.openqa.selenium.WebElement;

public class LocationPageObject {
    private ProcessElement element;
    private LocationPageInfo locInfo;
    private Logs logs;

    public LocationPageObject(){
        this.element = new ProcessElement();
        this.locInfo = new LocationPageInfo();
        this.logs = new Logs();
    }

    public WebElement getOpenXlab(){
        return element.getElements(locInfo.btnOpenXlab).get(0);
    }

    public WebElement getIfMap() {
        return element.getElement(locInfo.ifMap);
    }
}
