package objectRepo.objectProvider;

import core.element.ProcessElement;
import core.utility.Logs;
import objectRepo.objectInfo.RepoPageInfo;
import org.openqa.selenium.WebElement;

import java.util.List;

public class RepoPageObject {
    private ProcessElement element;
    private RepoPageInfo repoInfo;
    private Logs logs;

    public RepoPageObject(){
        this.element = new ProcessElement();
        this.repoInfo = new RepoPageInfo();
        this.logs = new Logs();
    }

    public WebElement lblRepoTitle(){
        return element.getElement(repoInfo.pageTitle);
    }

    public List<WebElement> liLanguage() {
        return element.getElements(repoInfo.liLanguage);
    }

    public WebElement language(String language){
        return element.getElement(repoInfo.selectLanguage.replace("TEMP",language));
    }

    public List<WebElement> getLangRepoNumber(){
        return element.getElements(repoInfo.lblLangRepo);
    }
}
