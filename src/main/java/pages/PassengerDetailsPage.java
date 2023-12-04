package pages;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;

public class PassengerDetailsPage {
    public  SelenideElement userName = $(By.xpath("//input[@name='name']")),
            userLastName =$(By.xpath("//input[@name='LastName']")),
            userId =$(By.xpath("//input[@name='IdNumber']")),
            submitUserDetails =$(By.xpath("//p[contains(text(),'გაგრძელება')]"));


}
