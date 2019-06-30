package core.actions;

import org.openqa.selenium.WebElement;

public class SelectActions {
    public boolean isSelected(WebElement element){
        return element.isSelected();
    }
}
