import actions.*;
import data.CommonData.FilePaths;
import org.apache.hc.client5.http.classic.methods.HttpPost;
import org.apache.hc.client5.http.impl.classic.CloseableHttpClient;
import org.apache.hc.client5.http.impl.classic.HttpClients;
import org.apache.hc.core5.http.io.entity.StringEntity;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import utility.BaseTest;
import utility.HelperFunctions;

import java.text.SimpleDateFormat;
import java.util.Date;

public class TreReturnToSessionTest extends BaseTest {
    ReturnToSessionActions returnToSessionActions = new ReturnToSessionActions();
    ChooseTicketPageActions chooseTicketPageActions = new ChooseTicketPageActions();
    SelectSeatInTrainPageActions selectSeatInTrainPageActions = new SelectSeatInTrainPageActions();
    PassengerDetailsPageActions passengerDetailsPageActions = new PassengerDetailsPageActions();
    ContactUserDetailPageActions contactUserDetailPageActions = new ContactUserDetailPageActions();
    MainPageActions mainPageActions = new MainPageActions();
    HelperFunctions helperFunctions = new HelperFunctions();
    FilePaths filePaths = new FilePaths();
    @BeforeMethod
    public void start() {
        helperFunctions.parseProperties(filePaths.configsPath);
        setUp(helperFunctions.url);
    }
    @Test
    public void testSession() throws InterruptedException {
        mainPageActions.fromFieldClick();
        mainPageActions.selectTbilisi();
        mainPageActions.toFieldClick();
        mainPageActions.selectBatumi();
        mainPageActions.departureFieldClick();
        mainPageActions.selectFirstAvailableDepartureDate();
        mainPageActions.clickReturnField();
        mainPageActions.selectFirstAvailableReturnDate();
        mainPageActions.clickSearchButton();
        chooseTicketPageActions.chooseFirstOptionOfFirstTicket();
        chooseTicketPageActions.chooseReturnFirstOptionOfFirstTicket();
        chooseTicketPageActions.submitTicketButton();
        selectSeatInTrainPageActions.selectTrainTicket();
        mainPageActions.returnToMainPage();
        returnToSessionActions.returnToSession();
    }
    @AfterMethod
    public void cleanUp(ITestResult result) {
        if (result.getStatus() == ITestResult.FAILURE) {
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            String currentTime = sdf.format(new Date());
            String message = "TRE.GE ReturnToSession Test failed at:" + currentTime;
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
