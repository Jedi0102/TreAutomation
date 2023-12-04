package pages;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$x;

public class RegistrationPopUp {
    public SelenideElement registrationViaFacebookButton =$x("//div[@class='loginModal__PopupContainerRegistration-sc-g0q4uu-2 pgOTX']//h3[@class='DescriptionMediumText__StyledTitle-sc-1k493e4-0 cWTHQx'][normalize-space()='Facebook']"),
    emailField =$x("//div[@class='loginModal__PopupContainerRegistration-sc-g0q4uu-2 pgOTX']//input[@name='email']"),
    registerButton =$x("//p[normalize-space()='Register']"),
    signInButton =$x("//h3[normalize-space()='Sign In']");

}
