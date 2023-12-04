package actions;

import data.UserContactData.UserContactData;
import io.qameta.allure.Description;
import io.qameta.allure.Step;
import pages.ContactUserDetailsPage;

public class ContactUserDetailPageActions {
    UserContactData data = new UserContactData();
    ContactUserDetailsPage page = new ContactUserDetailsPage();
    @Step("Fill user's Email ")
    @Description("This method fills the user's email field")
    public void fillUserEmail(){

        page.userEmail.setValue(data.userEmail);
    }

    @Step("fill user's phone number")
    @Description("This method fills user's phone number field")
    public void fillUserPhoneNumber(){
        page.userPhoneNumber.setValue(data.userPhoneNumber);

    }
    @Step("Submit user Contact")
    @Description("This method  clicks on submit button on user contact Page")
    public void submitUserContact(){
        page.userContactSubmitButton.click();
    }
    @Step("Promo")
    @Description("This method is to copy promo code")
    public void copyPromo(){
        page.promoCode.click();
        page.scrollPromoField.click();
        page.enterPromoField.setValue("freeservice");
    }
    @Step("submit promo")
    @Description("This method submits entered promo code")
    public void submitPromo(){
        page.submitPromo.click();
    }


}
