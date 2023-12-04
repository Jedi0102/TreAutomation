package actions;

import io.qameta.allure.Description;
import io.qameta.allure.Step;
import pages.ChooseTicketPage;

public class ChooseTicketPageActions {
    ChooseTicketPage page = new ChooseTicketPage();

@Step("Choosing First Ticket")
@Description("This Method Chooses the first Ticket")
    public void  chooseFirstOptionOfFirstTicket(){
        page.firstOutboundFirstOption.click();
    }

@Step("Choosing Second Ticket")
@Description("This Method Chooses the first Ticket ")
    public void chooseReturnFirstOptionOfFirstTicket(){

        page.firstReturnOutboundFirstOption.click();
    }
@Step("Submit Button ")
@Description("This Method Click on Submit Button")
    public void submitTicketButton(){
        page.submitTicketButton.click();
    }



}
