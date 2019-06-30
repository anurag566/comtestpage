package objectRepo.objectProvider;

import core.element.ProcessElement;
import core.utility.Logs;
import objectRepo.objectInfo.DataPageInfo;
import org.openqa.selenium.WebElement;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DataPageObject {
    private ProcessElement element;
    private DataPageInfo dataInfo;
    private Logs logs;

    public DataPageObject(){
        this.element = new ProcessElement();
        this.dataInfo = new DataPageInfo();
        this.logs = new Logs();
    }

    public WebElement getSearch(){
        return element.getElement(dataInfo.search);
    }

    public List<WebElement> getDataPageLinks() {
        return element.getElements(dataInfo.dataPageLink);
    }

    public List<WebElement> getRepoText(){
        return element.getElements(dataInfo.repotext);
    }

    public List<WebElement> getRepoNumbers() {
        return element.getElements(dataInfo.repoNumber);
    }

}
