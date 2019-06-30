package models;

import core.actions.ClickActions;
import core.actions.ElementActions;
import core.actions.WindowsActions;
import core.actions.TextActions;
import core.element.ProcessElement;
import objectRepo.objectInfo.DataPageInfo;
import objectRepo.objectProvider.DataPageObject;

import java.util.List;

public class DataModel {
    private ProcessElement elements = null;
    private WindowsActions windows = null;
    private ClickActions clickActions = null;
    private TextActions textActions = null;
    private ElementActions elActions = null;
    private DataPageObject data = null;

    public DataModel(){
        elements = new ProcessElement();
        windows = new WindowsActions();
        clickActions = new ClickActions();
        textActions = new TextActions();
        elActions = new ElementActions();
        data = new DataPageObject();
    }

    public void openMainPage(String url){
        windows.openWebPage(url);
    }

    public String searchAttribute(String attribute) {
        return elActions.getAttribute(data.getSearch(),attribute);
    }

    public List<String> getPageLinks(String attribute) {
        return elActions.getAttributes(data.getDataPageLinks(),attribute);
    }

    public List<String> getRepoText() {
        return textActions.getTextList(data.getRepoText());
    }

    public List<String> getRepoNumber() {
        return textActions.getTextList(data.getRepoNumbers());
    }
}
