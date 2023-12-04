package actions;

import data.UserLogInData.DataForRestore;
import data.UserLogInData.UserLogInData;
import io.qameta.allure.Description;
import io.qameta.allure.Step;
import pages.LogInPopUp;

public class LogInPopUpActions {
    LogInPopUp login = new LogInPopUp();
    UserLogInData data = new UserLogInData();
    DataForRestore restoreData = new DataForRestore();
    @Step("Enter Email ")
    @Description("This method is used to enter email in Login Popup")
    public void enterEmail(){
       // helperFunctions.switchToNewWindow();
        login.emailFieldInLogIn.click();
        login.emailFieldInLogIn.setValue(data.Email);
       // helperFunctions.switchBack();
    }
    @Step("Enter Password")
    @Description("This method is used to enter password in Login Popup")
    public void enterPassword(){
        //helperFunctions.switchToNewWindow();
        login.passwordFieldInLogIn.click();
        login.passwordFieldInLogIn.setValue(data.Password);
       // helperFunctions.switchBack();
    }
    @Step("Sign In Button")
    @Description("This Method is used to open Sign In Popup")
    public void signInButton(){
        login.signInButtonInLogIn.click();
    }
    @Step("Show and Hide Password")
    @Description("this method is used to show and hide password")
    public void showAndHidePassword(){
        login.hidePasswordInLogIn.click();
    }
    @Step("Reset Password")
    @Description("To open password restore form")
    public void restorePasswordOpen(){
        login.restoreInLogIn.click();
    }
    @Step("Enter Mail in password reset")
    @Description("To enter mail in password Restore form")
    public void enterMail (){
        login.enterMailForRestore.click();
        login.enterMailForRestore.setValue(restoreData.Email);
    }
    @Step("Submit Restore")
    @Description("To submit password Restore form")
    public void submitRestore(){
        login.restoreMailSubmit.click();


    }
    @Step("Final Submit Button")
    @Description("to submit entered email and password in LogIn form")
    public void finalSubmit(){
        login.finalSubmit.click();
    }
}
