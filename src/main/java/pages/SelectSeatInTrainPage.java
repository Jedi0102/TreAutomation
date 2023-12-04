package pages;


import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class SelectSeatInTrainPage {
    public ElementsCollection wagons = $$(By.xpath("//*[contains(@id, 'vagoni')]"));

    public SelenideElement
            chooseReturnButton =$(By.xpath("//div[@class='BottomBar__BottomBarSection-sc-1bhq1k-0 gUTvVK']//button[@class='Button__ButtonView-sc-obun0b-0 hsoAcB']")),


    chooseButton =$(By.xpath("//div[@class='BottomBar__BottomBarSection-sc-1bhq1k-0 gUTvVK']//button[@class='Button__ButtonView-sc-obun0b-0 hsoAcB']"));
















}