import actions.RegistrationPopUpActions;
import data.CommonData.FilePaths;
import org.apache.hc.client5.http.classic.methods.HttpPost;
import org.apache.hc.client5.http.impl.classic.CloseableHttpClient;
import org.apache.hc.client5.http.impl.classic.HttpClients;
import org.apache.hc.core5.http.io.entity.StringEntity;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.LogInPopUp;
import pages.MainPage;
import utility.BaseTest;
import utility.HelperFunctions;
import java.text.SimpleDateFormat;
import java.util.Date;

public class TreRegistrationTest extends BaseTest {
    HelperFunctions helperFunctions = new HelperFunctions();
    FilePaths filePaths = new FilePaths();
    MainPage mainPage = new MainPage();
    LogInPopUp logInPopUp = new LogInPopUp();
    RegistrationPopUpActions registrationPopUpActions = new RegistrationPopUpActions();
    @BeforeMethod
    public void start() {
        helperFunctions.parseProperties(filePaths.configsPath);
        setUp(helperFunctions.url);
    }
    @Test
    public void testRegistrationProcess() {
        mainPage.signInButton.click();
        logInPopUp.SignUpButtonInLogIn.click();
        registrationPopUpActions.enterMail();
    }
    @AfterMethod
    public void cleanUp(ITestResult result) {
        if (result.getStatus() == ITestResult.FAILURE) {
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            String currentTime = sdf.format(new Date());
            String message = "TRE.GE Registration test failed: " + result.getMethod().getMethodName() + " at " + currentTime;
            sendSlackNotification(message);
        }
        tearDown();
    }
    private void sendSlackNotification(String message) {
        String webhookUrl = "https://hooks.slack.com/services/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"; // Replace with your actual Slack webhook URL
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
