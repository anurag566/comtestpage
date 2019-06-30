package core.actions;

import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;

public class TextActions {
    public String getText(WebElement element){
        return element.getText();
    }

    public List<String> getTextList(List<WebElement> elements) {
        List<String> values = new ArrayList<>();
        try {
            for(WebElement element : elements){
                values.add(element.getText());
            }
        }catch (Exception e){

        }
        return values;
    }

    public void inputValue(WebElement element, String value) {
        element.sendKeys(value);
    }
}
