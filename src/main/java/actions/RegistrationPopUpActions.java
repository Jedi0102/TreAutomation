package actions;

import data.UserRegistrationData.UserRegistrationData;
import io.qameta.allure.Description;
import io.qameta.allure.Step;
import pages.RegistrationPopUp;
import utility.HelperFunctions;
public class RegistrationPopUpActions {
    RegistrationPopUp registrationPopUp = new RegistrationPopUp();
    HelperFunctions helperFunctions = new HelperFunctions();
    UserRegistrationData data = new UserRegistrationData();
    @Step("Enter Mail")
    @Description("Registration PopUp")
    public void enterMail(){
        registrationPopUp.emailField.click();
        registrationPopUp.emailField.setValue(data.Email);
    }
    @Step("Submit Registration")
    @Description("Registration PopUp")
    public void submitRegistration(){
        registrationPopUp.registerButton.click();
    }
}
