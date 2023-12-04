package pages;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;

public class LogInPopUp {
    public SelenideElement  signInViaFacebookInLogIn=$(By.xpath("//div[@class='loginModal__PopupContainer-sc-g0q4uu-1 kDiDvZ']//h3[@class='DescriptionMediumText__StyledTitle-sc-1k493e4-0 cWTHQx'][normalize-space()='Facebook']")),
            emailFieldInLogIn=$(By.xpath("//div[@class='loginModal__PopupContainer-sc-g0q4uu-1 kDiDvZ']//input[@name='email']")),
            passwordFieldInLogIn=$(By.xpath("//input[@name='password']")),
            restoreInLogIn=$(By.xpath("//h3[contains(text(),'აღდგენა')]")),
            hidePasswordInLogIn=$(By.xpath("//img[@alt='eye']")),
            signInButtonInLogIn=$(By.xpath("//div[@class='loginModal__PopupContainer-sc-g0q4uu-1 kDiDvZ']//button[@class='Button__ButtonView-sc-obun0b-0 hsoAcB']")),
            SignUpButtonInLogIn=$(By.xpath("//h3[contains(text(),'რეგისტრაცია')]")),
            enterMailForRestore=$(By.xpath("//div[@class='loginModal__PopupContainerRecover-sc-g0q4uu-3 fnBfES']//input[@name='email']")),
            restoreMailSubmit=$(By.xpath("//div[@class='loginModal__PopupContainerRecover-sc-g0q4uu-3 fnBfES']//button[@class='Button__ButtonView-sc-obun0b-0 hsoAcB']")),
            finalSubmit=$(By.xpath("//div[@class='loginModal__PopupContainerRecover-sc-g0q4uu-3 fnBfES']//button[@class='Button__ButtonView-sc-obun0b-0 hsoAcB']"));




}
