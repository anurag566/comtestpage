package models;

import core.actions.ClickActions;
import core.actions.ElementActions;
import core.actions.TextActions;
import core.actions.WindowsActions;
import core.element.ProcessElement;
import objectRepo.objectProvider.RepoPageObject;
import objectRepo.objectProvider.UserPageObject;

import java.util.List;

public class UserModel {
    private ProcessElement elements = null;
    private WindowsActions windows = null;
    private ClickActions clickActions = null;
    private TextActions textActions = null;
    private ElementActions elActions = null;
    private UserPageObject user = null;

    public UserModel(){
        elements = new ProcessElement();
        windows = new WindowsActions();
        clickActions = new ClickActions();
        textActions = new TextActions();
        elActions = new ElementActions();
        user = new UserPageObject();
    }

    public String getUserTitle(){
        return textActions.getText(user.lblUserTitle());
    }

    public List<String> getuserTypes(){
        return textActions.getTextList(user.getLiUserType());
    }

    public List<String> getUserTypeNumber() {
        return textActions.getTextList(user.getLblUserNumber());
    }
}
