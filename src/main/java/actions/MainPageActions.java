package actions;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Description;
import io.qameta.allure.Step;
import pages.MainPage;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

import static com.codeborne.selenide.Condition.disappear;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;
public class MainPageActions {
    MainPage page = new MainPage();
@Step("From field button")
@Description("To click on from field")
    public void fromFieldClick() {
        page.fromField.click();
    }
@Step("Select tbilisi")
@Description("To select tbilisi in the from field")
    public void selectTbilisi(){
        for (SelenideElement loc : page.locations) {
            if (loc.getText().contains("თბილისი")) {
                loc.click();
                break;
            }
        }
    }
    @Step("To field button")
    @Description("To click on To field")
    public void toFieldClick() {
        page.toField.click();
    }
    @Step("Select batumi")
    @Description("To select batumi in the To field")
    public void selectBatumi(){
        for (SelenideElement loc : page.destination) {
            if (loc.getText().contains("ბათუმი")) {
                loc.click();
                break;
            }
        }
    }
    @Step("Departure Field ")
    @Description("Clicking on the deoarture field")
    public void departureFieldClick() {
        page.departureField.click();
    }
    @Step("Select First Available Date")
    @Description("This method searches for Available ticket for Departure  and clicks on it but it will start from the fifth avaliable ticket")
    public void selectFirstAvailableDepartureDate() {
        selectAvailableDate(5); // Select the third available date for departure
        waitForPageToLoad(); // Wait for the page to load after selecting the date
    }
    @Step("Return Field")
    @Description("Clicking on the deoarture field")
    public void clickReturnField() {
        page.addReturnField.click();
    }
    @Step("Select First Avaliable Data for Return Date")
    @Description("This method searches for avaliable ticket for Return and clicks on it but it will start from the fifth avaliable ticket")
    public void selectFirstAvailableReturnDate() {
        selectAvailableDate(6); // Select the fourth available date for return
        waitForPageToLoad(); // Wait for the page to load after selecting the date
    }
    @Step("Search button")
    @Description("search button for main page to confirm ticket information")
    public void clickSearchButton() {
        page.searchButton.click();
        waitForPageToLoad(); // Wait for the page to load after clicking the search button
    }
    @Step("Select location")
    @Description("This is logic for selecting available date")
    private void selectLocation(String locationName) {
        List<SelenideElement> locations = $$(".react-datepicker__day");
        locations.stream()
                .filter(loc -> loc.getText().contains(locationName))
                .findFirst()
                .ifPresent(SelenideElement::click);
    }
    @Step("Select avaliable date")
    @Description("This is logic for selecting available date")
    private void selectAvailableDate(int dateIndex) {
        LocalDate currentDate = LocalDate.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("d-ე LLL, yyyy");

        while (true) {
            List<SelenideElement> availableDates = $$(".react-datepicker__day:not(.react-datepicker__day--disabled)");
            if (availableDates.size() >= dateIndex) {
                availableDates.get(dateIndex - 1).click(); // Select the desired available date
                break;
            }
            $(".react-datepicker__navigation--next").click();
        }
    }
    @Step("wait method")
    @Description("")
    private void waitForPageToLoad() {
        $(".page-loader").should(disappear); // Assuming a page loader element is displayed while the page loads
    }
    @Step("Return to main Page")
    @Description("Its used to click on TRE logo to go back in the main page")
    public void returnToMainPage(){
        page.returnToMainPage.click();
    }
}