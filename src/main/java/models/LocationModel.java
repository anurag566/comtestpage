package models;

import core.actions.ClickActions;
import core.actions.ElementActions;
import core.actions.TextActions;
import core.actions.WindowsActions;
import core.element.ProcessElement;
import objectRepo.objectProvider.LocationPageObject;

public class LocationModel {
    private ProcessElement elements = null;
    private WindowsActions windows = null;
    private ClickActions clickActions = null;
    private TextActions textActions = null;
    private ElementActions elActions = null;
    private LocationPageObject loc = null;

    public LocationModel(){
        elements = new ProcessElement();
        windows = new WindowsActions();
        clickActions = new ClickActions();
        textActions = new TextActions();
        elActions = new ElementActions();
        loc = new LocationPageObject();
    }

    public void clickOXlabLocation(){
        windows.switchToIframe(0);
        clickActions.click(loc.getOpenXlab());
    }

}
