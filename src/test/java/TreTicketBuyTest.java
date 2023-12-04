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
public class TreTicketBuyTest extends BaseTest {
    FilePaths filePaths = new FilePaths();
    HelperFunctions helperFunctions = new HelperFunctions();
    MainPageActions mainPageActions = new MainPageActions();
    ChooseTicketPageActions chooseTicketPageActions = new ChooseTicketPageActions();
    SelectSeatInTrainPageActions selectSeatInTrainPageActions = new SelectSeatInTrainPageActions();
    PassengerDetailsPageActions passengerDetailsPageActions = new PassengerDetailsPageActions();
    ContactUserDetailPageActions contactUserDetailPageActions = new ContactUserDetailPageActions();
    @BeforeMethod
    public void start() {
        helperFunctions.parseProperties(filePaths.configsPath);
        setUp(helperFunctions.url);
    }
    @Test
    public void testPurchaseProcess(){
        mainPageActions.fromFieldClick();
        mainPageActions.selectTbilisi();
        mainPageActions.toFieldClick();
        mainPageActions.selectBatumi();
        mainPageActions.departureFieldClick();
        mainPageActions.selectFirstAvailableDepartureDate(); // New method
        mainPageActions.clickReturnField();
        mainPageActions.selectFirstAvailableReturnDate(); // New method
        mainPageActions.clickSearchButton();
        chooseTicketPageActions.chooseFirstOptionOfFirstTicket();
        chooseTicketPageActions.chooseReturnFirstOptionOfFirstTicket();
        chooseTicketPageActions.submitTicketButton();
        selectSeatInTrainPageActions.selectTrainTicket();
        selectSeatInTrainPageActions.selectReturnTrainTicket();
        passengerDetailsPageActions.fillUserNameField();
        passengerDetailsPageActions.fillUserLastNameField();
        passengerDetailsPageActions.fillUserIdField();
        passengerDetailsPageActions.submitUserDetails();
        contactUserDetailPageActions.fillUserEmail();
        contactUserDetailPageActions.fillUserPhoneNumber();
        contactUserDetailPageActions.copyPromo();
        contactUserDetailPageActions.submitPromo();
        contactUserDetailPageActions.submitUserContact();
    }
    @AfterMethod
    public void cleanUp(ITestResult result) {
        if (result.getStatus() == ITestResult.FAILURE) {
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            String currentTime = sdf.format(new Date());
            String message = "TRE.GE Ticket Buy Proccess test failed: " + result.getMethod().getMethodName() + " at " + currentTime;
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
