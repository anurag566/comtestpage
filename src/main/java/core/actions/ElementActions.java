package core.actions;

import core.element.Elements;
import core.utility.Logs;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;

public class ElementActions {
    private Logs logs = null;

    public ElementActions() {
        this.logs = new Logs();
    }

    public String getAttribute(WebElement element,String attribute){
        try {
            return element.getAttribute(attribute);
        }catch (Exception e){
            logs.log("Error while getting attribute from the element : "+e);
        }
        return "";
    }

    public List<String> getAttributes(List<WebElement> elements,String attribute) {
        List<String> values = new ArrayList<>();
        try {
            for(WebElement element : elements){
                values.add(element.getAttribute(attribute));
            }
        }catch (Exception e){
            logs.log("Error while getting attribute from the element : "+e);
        }
        return values;
    }
}
