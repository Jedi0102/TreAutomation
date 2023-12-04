import actions.LogInPopUpActions;
import actions.MainPageActions;
import data.CommonData.FilePaths;
import data.UserLogInData.UserLogInData;
import io.qameta.allure.Description;
import io.qameta.allure.Step;
import org.apache.hc.client5.http.classic.methods.HttpPost;
import org.apache.hc.client5.http.impl.classic.CloseableHttpClient;
import org.apache.hc.client5.http.impl.classic.HttpClients;
import org.apache.hc.core5.http.io.entity.StringEntity;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.MainPage;
import utility.BaseTest;
import utility.HelperFunctions;
import java.text.SimpleDateFormat;
import java.util.Date;
public class TreLogInTest extends BaseTest {
    HelperFunctions helperFunctions = new HelperFunctions();
    FilePaths filePaths = new FilePaths();
    MainPageActions mainPageActions = new MainPageActions();
    LogInPopUpActions login = new LogInPopUpActions();
    UserLogInData userData = new UserLogInData();
    MainPage mainPage = new MainPage();
    private boolean testLogInPassed = false;
    private boolean testPasswordRestorePassed = false;
    @Step("Startying Test ")
    @Description("Opening Tre.ge ")
    @BeforeMethod
    public void start() {
        helperFunctions.parseProperties(filePaths.configsPath);
        setUp(helperFunctions.url);
    }
    @Step("LogIn Test")
    @Description("Testing LogIn Function Of Website ")
    @Test
    public void testLogInProcess() throws InterruptedException {
        mainPage.signInButton.click();
        login.enterEmail();
        login.enterPassword();
        login.showAndHidePassword();
        login.signInButton();
        testLogInPassed = true;
    }
    @Step("Password Reset ")
    @Description("Testing Password Reset ")
    @Test
    public void testPasswordRestoreProcess() throws InterruptedException{
        mainPage.signInButton.click();
        login.restorePasswordOpen();
        login.enterMail();
        login.submitRestore();
        login.finalSubmit();
        testPasswordRestorePassed = true;
    }
    @Step("After Method")
    @Description("Closing window and sending result on slack")
    @AfterMethod
    public void cleanUp(ITestResult result) {
        if (result.getStatus() == ITestResult.FAILURE) {
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            String currentTime = sdf.format(new Date());
            String message = "TRE.GE LogIn and Password Restore test failed: " + result.getMethod().getMethodName() + " at " + currentTime;
            sendSlackNotification(message);
        }
        tearDown();
    }
    private void sendSlackNotification(String message) {
        String webhookUrl = "https://hooks.slack.com/services/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";
        String messagePayload = "{\"text\": \"" + message + "\"}";
        try (CloseableHttpClient httpClient = HttpClients.createDefault()) {
            HttpPost httpPost = new HttpPost(webhookUrl);
            httpPost.setHeader("Content-Type", "application/json");
            httpPost.setEntity(new StringEntity(messagePayload));
            httpClient.execute(httpPost);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

