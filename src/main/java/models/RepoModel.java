package models;

import core.actions.ClickActions;
import core.actions.ElementActions;
import core.actions.TextActions;
import core.actions.WindowsActions;
import core.element.ProcessElement;
import objectRepo.objectProvider.RepoPageObject;

import java.util.List;

public class RepoModel {
    private ProcessElement elements = null;
    private WindowsActions windows = null;
    private ClickActions clickActions = null;
    private TextActions textActions = null;
    private ElementActions elActions = null;
    private RepoPageObject repo = null;

    public RepoModel(){
        elements = new ProcessElement();
        windows = new WindowsActions();
        clickActions = new ClickActions();
        textActions = new TextActions();
        elActions = new ElementActions();
        repo = new RepoPageObject();
    }

    public String getRepoTitle(){
        return textActions.getText(repo.lblRepoTitle());
    }

    public List<String> getLanguageList(){
        return textActions.getTextList(repo.liLanguage());
    }

    public void selectLanguage(String language){
        clickActions.actionClick(repo.language(language));
    }

    public List<String> getLangRepoNumber(){
        return textActions.getTextList(repo.getLangRepoNumber());
    }
}
