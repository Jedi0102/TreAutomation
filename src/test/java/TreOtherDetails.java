import data.CommonData.FilePaths;
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
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
public class TreOtherDetails extends BaseTest {
    HelperFunctions helperFunctions = new HelperFunctions();
    FilePaths filePaths = new FilePaths();
    MainPage mainPage = new MainPage();
    List<String> failedTests = new ArrayList<>();
    @BeforeMethod
    public void start() {
        helperFunctions.parseProperties(filePaths.configsPath);
        setUp(helperFunctions.url);
    }
    @Test(priority = 1)
    public void testLanguageChange() {
        mainPage.languageButton.click();
        mainPage.engLanguage.click();
        mainPage.languageButton.click();
        mainPage.rusLanguage.click();
        mainPage.languageButton.click();
        mainPage.goeLanguage.click();
    }
    @Test(priority = 2)
    public void testCurrencyChange() {
        mainPage.currencyButton.click();
        mainPage.usdCurrency.click();
        mainPage.currencyButton.click();
        mainPage.eurCurrency.click();
        mainPage.currencyButton.click();
        mainPage.gelCurrency.click();
    }
    @Test(priority = 3)
    public void testLiveDepartures() {
        mainPage.liveDepartureOne.click();
    }
    @Test(priority = 4)
    public void testTrainTimetable() {
        mainPage.changeRegionButton.click();
        mainPage.regionsToTbilisi.click();
        mainPage.today.click();
        mainPage.tomorrow.click();
        mainPage.showMore.click();
    }
    @Test(priority = 5)
    public void testPopularDestinations() {
    }
    @Test(priority = 6)
    public void testAskedQuestions() {
        mainPage.questionOneField.click();
        mainPage.questionTwoField.click();
        mainPage.questionThreeField.click();
        mainPage.questionFourField.click();
    }
    @Test(priority = 7)
    public void testCustomerService() {
    }
    @AfterMethod
    public void cleanUp(ITestResult result) {
        if (result.getStatus() == ITestResult.FAILURE) {
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            String currentTime = sdf.format(new Date());
            String message = "TRE.GE Other details test failed: " + result.getMethod().getMethodName() + " at " + currentTime;
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