package objectRepo.objectProvider;

import core.element.ProcessElement;
import core.utility.Logs;
import objectRepo.objectInfo.RepoPageInfo;
import objectRepo.objectInfo.UserInfo;
import org.openqa.selenium.WebElement;

import java.util.List;

public class UserPageObject {
    private ProcessElement element;
    private UserInfo user;
    private Logs logs;

    public UserPageObject(){
        this.element = new ProcessElement();
        this.user = new UserInfo();
        this.logs = new Logs();
    }

    public WebElement lblUserTitle(){
        return element.getElement(user.pageTitle);
    }

    public List<WebElement> getLiUserType(){
        return element.getElements(user.liUserType);
    }

    public List<WebElement> getLblUserNumber(){
        return element.getElements(user.lblUserNumber);
    }
}
