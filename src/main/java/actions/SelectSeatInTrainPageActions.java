package actions;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Description;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.interactions.Actions;
import pages.MainPage;
import pages.SelectSeatInTrainPage;

import static com.codeborne.selenide.WebDriverRunner.getWebDriver;
public class SelectSeatInTrainPageActions {
    SelectSeatInTrainPage page = new SelectSeatInTrainPage();
    MainPage mainPage = new MainPage();
    @Step("Select Train Seats")
    @Description("This is Logic To search for avaliable Seats in Train and click on it in this method this works when there is avaliable seats in wagon 4")
    public void selectTrainTicket(){
        page.wagons.get(3).scrollIntoView(true);
        if (page.wagons.size() > 3 && page.wagons.get(3).isDisplayed()) {
            SelenideElement wagon = page.wagons.get(3);
            ElementsCollection paths = wagon.findAll(By.tagName("path"));
            for (SelenideElement path : paths) {
                if (path.isDisplayed() && path.isEnabled()) {
                    new Actions(getWebDriver()).click(path).perform();
                    page.chooseReturnButton.click();
                }
            }
        }
    }
    @Step("Select Train Seats for Return Seats ")
    @Description("This is Logic To search for avaliable Seats in Train and click on it in this method this works when there is avaliable seats in wagon 4")
    public void selectReturnTrainTicket(){
        page.wagons.get(3).scrollIntoView(true);
        if ( page.wagons.get(3).isDisplayed()) {
            SelenideElement wagon = page.wagons.get(3);
            ElementsCollection paths = wagon.findAll(By.tagName("path"));
            for (SelenideElement path : paths) {
                if (path.isDisplayed() && path.isEnabled()) {
                    new Actions(getWebDriver()).click(path).perform();
                    page.chooseButton.click();
                }
            }
        }
    }
}