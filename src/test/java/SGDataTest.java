import models.DataModel;
import models.LocationModel;
import models.RepoModel;
import models.UserModel;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class SGDataTest {
    DataModel data;
    RepoModel repo;
    UserModel user;
    LocationModel loc;
    SGTestData test;

    @Before
    public void createInit(){
        data = new DataModel();
        repo = new RepoModel();
        user = new UserModel();
        loc = new LocationModel();
        test = new SGTestData();
    }

    @Test
    public void testLoginPage(){
        data.openMainPage("https://webuildsg.github.io/data/");
        Assert.assertEquals("search data",data.searchAttribute("placeholder"));
        List<String> links = data.getPageLinks("data-index");
        List<String> exlinks = test.getDataPageLinks();
        if(links.size() == exlinks.size()){
            for (int i=0; i<links.size(); i++){
                Assert.assertEquals(exlinks.get(i),links.get(i));
            }
        }else{
            Assert.fail("All Links are not available on the data page.");
        }

        List<String> repoText = data.getRepoText();
        List<String> reponumber = data.getRepoNumber();
        List<String> exRepoData = test.getRepoData();

        if(repoText.size() == reponumber.size()){
            for (int i=0; i<reponumber.size(); i++){
                System.out.println(repoText.get(i) +" "+reponumber.get(i));
                Assert.assertEquals(exRepoData.get(i),(repoText.get(i) +" "+reponumber.get(i)));
            }
        }
    }

    @Test
    public void testProgrammingLanguage(){
        data.openMainPage("https://webuildsg.github.io/data/dataset/repos-per-programming-language/");
        Assert.assertEquals("repositories per programming languages",repo.getRepoTitle());
        List<String> language = repo.getLanguageList();
        List<String> exlanguage = test.getLanguageList();

        if(language.size() == exlanguage.size()){
            for(int i=0; i<language.size(); i++){
                // System.out.println(language.get(i));
                Assert.assertEquals(exlanguage.get(i),language.get(i));
            }
        }else {
            Assert.fail("All language list is not available on the page.");
        }

        // C language Validation
        repo.selectLanguage("c");
        List<String> langNumber = repo.getLangRepoNumber();
        List<String> exLangNumber = test.getCLangRepoNumber();
        if(langNumber.size()==exLangNumber.size()){
            for(int i=0;i<langNumber.size(); i++){
                System.out.println(langNumber.get(i).replace("★",""));
                Assert.assertEquals(exLangNumber.get(i),langNumber.get(i).replace("★",""));
            }
        }else {
            Assert.fail("All c repo is not available.");
        }

        // Java Language Validation
        repo.selectLanguage("java");
        List<String> jLangNumber = repo.getLangRepoNumber();
        List<String> exJLangNumber = test.getJavaLangRepoNumber();
        if(jLangNumber.size() == exJLangNumber.size()){
            for(int i=0;i<jLangNumber.size(); i++){
                System.out.println(jLangNumber.get(i).replace("★",""));
                Assert.assertEquals(exJLangNumber.get(i),jLangNumber.get(i).replace("★",""));
            }
        }else {
            Assert.fail("All java repo is not available.");
        }
    }

    @Test
    public void activeGroupTest(){
        data.openMainPage("https://webuildsg.github.io/data/dataset/events-per-group/");
        Assert.assertEquals("active user groups with > 5 events",user.getUserTitle());
        List<String> userTypes = user.getuserTypes();
        List<String> userTypesNumber = user.getUserTypeNumber();
        List<String> exUserData = test.getActiveUserData();
        if(exUserData.size() == userTypesNumber.size()){
            for (int i = 0; i<userTypes.size();i++) {
                System.out.println(userTypes.get(i)+" : "+userTypesNumber.get(i));
                Assert.assertEquals(exUserData.get(i),userTypes.get(i)+" : "+userTypesNumber.get(i));
            }
        }else {
            Assert.fail("All user data is not available on the page.");
        }

    }
}
