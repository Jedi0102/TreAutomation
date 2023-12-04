package actions;

import data.PassengersDetailsData.PassengersDetailsData;
import io.qameta.allure.Description;
import io.qameta.allure.Step;
import pages.PassengerDetailsPage;
public class PassengerDetailsPageActions {
    PassengerDetailsPage page = new PassengerDetailsPage();
    PassengersDetailsData data = new PassengersDetailsData();
    @Step("Fill User's Name")
    @Description("Passenger Details Page")
    public void fillUserNameField () {
        page.userName.setValue(data.userName);
    }
    @Step("Fill User's Last Name")
    @Description("Passenger Details Page")
    public void fillUserLastNameField(){
        page.userLastName.setValue(data.userLastName);
    }
    @Step("Fill User's ID")
    @Description("Passenger Details Page")
    public void fillUserIdField(){
        page.userId.setValue(data.userId);
    }
    @Step("Submit User's Details")
    @Description("Passenger Details Page")
    public void submitUserDetails(){
        page.submitUserDetails.click();
    }
}
