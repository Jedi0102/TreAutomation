package actions;

import io.qameta.allure.Description;
import io.qameta.allure.Step;
import pages.ReturnToSessionPage;
import pages.SelectSeatInTrainPage;

public class ReturnToSessionActions {
    ReturnToSessionPage session = new ReturnToSessionPage();
    SelectSeatInTrainPage selectSeatInTrainPage = new SelectSeatInTrainPage();
    @Step("Return To Session")
    @Description("Clicking on return to session PopUp")
    public void returnToSession(){
        session.returnToSessionButton.click();
    }
    @Step("Submit First Seat")
    @Description("You need to select at least First Seat to create Session and return to it")
    public void submitFirtSeat(){
        selectSeatInTrainPage.chooseReturnButton.click();
    }
}
