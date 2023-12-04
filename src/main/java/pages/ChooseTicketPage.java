package pages;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;

public class ChooseTicketPage {
    public SelenideElement firstReturnOutboundFirstOption =$(By.xpath("//div[@id='web-return-section']//div[1]//div[1]//div[1]//div[2]//div[2]//div[1]//div[1]//img[1]")),
            firstOutboundFirstOption =$(By.xpath("(//img[@alt='chair'])[1]")),
            submitTicketButton =$(By.xpath("//p[contains(text(),'გაგრძელება')]"));
}
