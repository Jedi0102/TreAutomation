package pages;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import data.MainPageData.DataForDepartureTime;
import data.MainPageData.DataForReturnTime;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;

public class MainPage {
    public SelenideElement  treLogo =$(By.xpath("//img[@src='/icons/logo-text-black.svg']")),
    //SignIn
    signInButton =$(By.xpath("//div[@class='Header__NavItem-sc-117hobk-17 dmyonM']//img[@alt='sign-in']")),
    //Header
    returnToMainPage =$(By.xpath("//img[@src='/icons/logo-text-black.svg']")),



    //Language
    languageButton =$(By.xpath("//div[@class='Header__SelectButtonInner-sc-117hobk-4 fGscJY']//img[@alt='earth']")),
    goeLanguage =$(By.xpath("//div[@class='Header__Select-sc-117hobk-0 iiQgep']//img[@alt='geo']")),
    engLanguage =$(By.xpath("//div[@class='Header__Select-sc-117hobk-0 iiQgep']//img[@alt='eng']")),
    rusLanguage =$(By.xpath("//div[@class='Header__Select-sc-117hobk-0 iiQgep']//img[@alt='rus']")),


    //Currency
    currencyButton =$(By.xpath("//div[@class='Header__SelectButtonInner-sc-117hobk-4 fGscJY']//img[@alt='currency']")),
    gelCurrency=$(By.xpath("//div[@class='Header__Select-sc-117hobk-0 iiQgep']//img[@alt='gel']")),
    usdCurrency=$(By.xpath("//div[@class='Header__Select-sc-117hobk-0 iiQgep']//img[@alt='usd']")), eurCurrency=$(By.xpath("//div[@class='Header__Select-sc-117hobk-0 iiQgep']//img[@alt='eur']")),


    //Popular Destination
    tbilisiToBatumi =$(By.xpath("//img[@src='/images/batumi.png']")),
    batumiToTbilisi =$(By.xpath("//div[@class='popularDestinations__InfoTo-sc-2evecp-5 heQynF'][normalize-space()='Tbilisi']")),
    tbilisiToZugdidi =$(By.xpath("//div[@class='popularDestinations__Info-sc-2evecp-3 kGXrnw']")),
    zugdidiToTbilisi =$(By.xpath("//div[@class='popularDestinations__PopularDestinationsSection-sc-2evecp-0 gQPzso']//div[4]//div[1]//div[2]")),
    //Live Departures

     liveDepartureOne =$(By.xpath("//div[@class='style__TextContainer-sc-ujbn5a-2 goUXbm']")),


    //Frequently asked question.
    questionOneField =$(By.xpath("//p[contains(text(),'რა მჭირდება მატარებელში ჩასხდომისას?')]")),
    questionTwoField =$(By.xpath("//p[contains(text(),'როგორ შევიძინო ბილეთი ონლაინ?')]")),
    questionThreeField =$(By.xpath("//p[contains(text(),'როგორ დავაბრუნო შეძენილი ბილეთი?')]")),
    questionFourField =$(By.xpath("//p[contains(text(),'შემიძლია თუ არა ვიყიდო ბილეთები ერთი პირადობით?')]")),


    //Train Timetable
    changeRegionButton =$(By.xpath("//div[@class='TimeTable__TrainTimeTableNavItem-sc-1t3ru5s-4 laGGGj']//img")),
    tbilisiToRegions=$(By.xpath("//p[contains(text(),'თბილისი - რეგიონები')]")),
    regionsToTbilisi=$(By.xpath("//p[contains(text(),'რეგიონები - თბილისი')]")),
    regions=$(By.xpath("//div[@class='DropModal__DropModalCont-sc-xtrqg8-0 iIGcsw']//p[1]")),
    today=$(By.xpath("//div[@class='TimeTable__TrainTimeTableNavItem-sc-1t3ru5s-4 gefmAb']")),
    tomorrow=$(By.xpath("//p[contains(text(),'ხვალ')]")),
    showMore=$(By.xpath("//img[@src='/icons/down-arrow.svg']")),


    //Popular Destinations





    //Customer Service.
    treePhoneNumberButton =$(By.xpath("//div[@class='customerService__CustomerServiceSection-sc-1p9qpn4-0 gvKOic']//a[1]")),
    treeSupportMailButton =$(By.xpath("//div[@class='customerService__CustomerServiceSection-sc-1p9qpn4-0 gvKOic']//a[2]")),
    treMessenerButton =$(By.xpath("//a[@href='https://m.me/TRE.Tickets']")),
    treFacebookButton =$(By.xpath("//p[normalize-space()='fb.com/TRE.Tickets']"));




    //Ticket info.
    DataForDepartureTime data = new DataForDepartureTime();
    DataForReturnTime returnData = new DataForReturnTime();
    public SelenideElement fromField =$(By.xpath("//div[@class='style__HomeFilterBox-sc-ek4s6p-1 iTbEUM']//div[@class='style__CitySelectionFrom-sc-l8bt9w-2 danKgy']")),
    locationsContainer =$(By.xpath("//div[@class='style__PopupCont-sc-c74shx-0 ejgLHn']")),

    toField =$(By.xpath(" //div[@class='style__HomeFilterBox-sc-ek4s6p-1 iTbEUM']//div[@class='style__CitySelectionTo-sc-khotwm-2 duYdet']")),
    destinationContainer =$(By.xpath("//div[@class='style__PopupCont-sc-nwsjnf-2 jVEolC']")),
    departureField =$(By.xpath("//div[@class='style__HomeFilterBox-sc-ek4s6p-1 iTbEUM']//div[@class='style__Departure-sc-1oi4v0a-0 kwcdXN']")),
    addReturnField =$(By.xpath("//div[@class='style__HomeFilterBox-sc-ek4s6p-1 iTbEUM']//div[@class='style__Return-sc-1oi4v0a-5 lerQbA']")),
    searchButton =$(By.xpath("//div[contains(@class,'style__HomeFilterBox-sc-ek4s6p-1 iTbEUM')]//div[contains(@class,'style__FilterSection-sc-1np62kc-0 bBuXfS')]//button[contains(@class,'Button__ButtonView-sc-obun0b-0 hsoAcB')]")),
    dateForDeparture =$(By.xpath("//div[@aria-label='Choose ოთხშაბათი, 6-ე სექტემბერი, 2023']")),
    dateForReturn=$(By.xpath("//div[contains(@aria-label,'"+returnData.returnTime+"')]")),




    returnHeader=$(By.xpath("//div[@class='style__DataPickerHeader-sc-313ylx-5 SRioX']")),
    departureHeader =$(By.xpath("//div[@class='style__DataPickerHeader-sc-313ylx-5 SRioX']")),
    switchMonthsButton = $(By.xpath("//img[@src='/icons/monthIncrease.svg']")),
    switchMonthButtonForReturn =$(By.xpath("//img[@src='/icons/monthIncrease.svg']"));
    public ElementsCollection locations =locationsContainer.findAll(By.tagName("div")),
            destination =destinationContainer.findAll(By.tagName("div"));






}
