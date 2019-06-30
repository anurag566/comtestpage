package core.element;

import core.driver.DriverProvider;
import core.utility.Logs;
import core.utility.StopWatch;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ProcessElement {
    Logs logs = null;
    Elements elments = null;
    Visibility visibility = null;
    DriverProvider driver = null;
    StopWatch watch = null;

    public ProcessElement() {
        this.logs = new Logs();
        this.elments = new Elements();
        this.visibility = new Visibility();
        this.driver = new DriverProvider();
        this.watch = new StopWatch();
    }

    public List<WebElement> getElements(String info){
        Map<String,String> elInfo = getElementInfo(info);
        return elements(elInfo.get("locator"),elInfo.get("value"),elInfo.get("condition"),Integer.parseInt(elInfo.get("timeout")));
    }

    public WebElement getElement(String info){
        Map<String,String> elInfo = getElementInfo(info);
        return element(elInfo.get("locator"),elInfo.get("value"),elInfo.get("condition"),Integer.parseInt(elInfo.get("timeout")));
    }

    private Map<String,String> getElementInfo(String info){
        String[] elmentInfo = info.split("\\|\\|");
        HashMap<String,String> infoMap = new HashMap<>();
        try {
            infoMap.put("locator",elmentInfo[0].split("\\@\\@")[0]);
            infoMap.put("value",elmentInfo[0].split("\\@\\@")[1]);
            infoMap.put("condition",elmentInfo[1].split("\\@\\@")[0]);
            infoMap.put("timeout",elmentInfo[1].split("\\@\\@")[1]);
        }catch (Exception e){
            this.logs.log("Please check the element info : "+e);
        }
        return infoMap;
    }

    private WebElement element(String locator, String value,String visibilityConditon,int timeout) {
        this.logs.log("New WebElement Search : locator ==> "+locator + " : value ==> "+value + " : condition : "+visibilityConditon+" : timeout ==> "+timeout);
        WebElement element = null;
        WebDriver driver;
        try {
            driver = this.driver.getDriver();
            watch.startWatch(timeout);
            while (watch.isWatchRunning() && (element == null)) {
                try {
                    element = elments.getElement(driver,locator,value);
                    if(element != null){
                        if(visibility.isVisible(element,visibilityConditon)){
                            return element;
                        }
                    }
                    element = null;
                }catch (Exception e){
                    logs.log("Error while searching the element : "+e);
                }
                element = null;
            }
        }catch (Exception e){
            logs.log("Exception in element search : "+e);
        }
        return element;
    }

    private List<WebElement> elements(String locator, String value,String visibilityConditon,int timeout) {
        this.logs.log("New WebElement Search : locator ==> "+locator + " : value ==> "+value + " : condition : "+visibilityConditon+" : timeout ==> "+timeout);
        List<WebElement> elementList = null;
        WebDriver driver;
        try {
            driver = this.driver.getDriver();
            watch.startWatch(timeout);
            while (watch.isWatchRunning() && (elementList == null)) {
                elementList = elments.getElements(driver,locator,value);
                if(elementList != null){
                    if(visibility.isElementsVisible(elementList,visibilityConditon)){
                        return elementList;
                    }
                }
                elementList = null;
            }
        }catch (Exception e){
            logs.log("Exception while searching the element : "+e);
        }
        return elementList;
    }
}
