package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class AnaSayfaPage {

    public AnaSayfaPage() {
        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy(xpath = "//a[text()='Log in']")
    public WebElement mainLoginLinki;

    @FindBy(xpath = "//a[text()='Home']")
    public WebElement anaSayfaHomeButon;

    @FindBy(xpath = "//li[@id='navRooms']")
    public WebElement anasayfaRoomsButon;

    @FindBy(xpath = "//li[@id='navRestaurant']")
    public WebElement anasayfaRestaurantButon;

    @FindBy(xpath = "//li[@id='navAbout']")
    public WebElement anasayfaAboutButon;

    @FindBy(xpath = "//li[@id='navBlog']")
    public WebElement anasayfaBlogButon;

    @FindBy(xpath = "//li[@id='navContact']")
    public WebElement anasayfaContactButon;

    @FindBy(xpath = "//li[@id='navProfile']")
    public WebElement anasayfaProfileButon;

    @FindBy(xpath = "//li[@id='navLogout']")
    public WebElement anasayfaLogoutButon;

    @FindBy(xpath = "//input[@id='checkin_date']")
    public WebElement anasayfaCheckinDateBox;

    @FindBy(xpath = "//input[@id='checkout_date']")
    public WebElement anasayfaCheckoutDateBox;

    @FindBy(xpath = "//select[@id='IDRoomType']")
    public WebElement anasayfaRoomDropdown;

    @FindBy(xpath = "//select[@id='AdultCount']")
    public WebElement anasayfaCustomerDropdown;

    @FindBy(xpath = "//input[@type='submit']")
    public WebElement anasayfaCheckAvailabilityButon;

    @FindBy(xpath = "//h2[text()='Welcome To Our Hotel']")
    public WebElement anasayfaWelcomeToOurHotelYazisi;

    @FindBy(xpath = "(//div[@class='text p-3 text-center'])[1]")
    public WebElement anasayfaWiewRoomDetails1;

    @FindBy(xpath = "(//div[@class='text p-3 text-center'])[2]")
    public WebElement anasayfaWiewRoomDetails2;

    @FindBy(xpath = "(//div[@class='text p-3 text-center'])[3]")
    public WebElement anasayfaWiewRoomDetails3;


    @FindBy(xpath = "(//div[@class='owl-stage-outer'])[2]")
    public WebElement anasayfaMisafirYorumlari;

    @FindBy(xpath = "//h2[text()='Recent Blog']")
    public WebElement anasayfaRecentBlogBaslik;

    @FindBy(xpath = "//a[text()='Even the all-powerful Pointing has no control about the blind texts 6']")
    public WebElement anasayfaRecentBlogElementi1;

    @FindBy(xpath = "//a[text()='Even the all-powerful Pointing has no control about the blind texts 5']")
    public WebElement anasayfaRecentBlogElementi2;

    @FindBy(xpath = "//a[text()='Even the all-powerful Pointing has no control about the blind texts 4']")
    public WebElement anasayfaRecentBlogElementi3;

    @FindBy(xpath = "//a[text()='Even the all-powerful Pointing has no control about the blind texts 3']")
    public WebElement anasayfaRecentBlogElementi4;

    @FindBy(xpath = "//span[text()='Instagram']")
    public WebElement anasayfaInstagramBaslik;

    @FindBy(xpath = "(//span[@class='icon-instagram align-self-center'])[2]")
    public WebElement anasayfaInstagramFotograf2;

    @FindBy(xpath = "//footer[@class='ftco-footer ftco-bg-dark ftco-section']")
    public WebElement anasayfaFooter;

    @FindBy(xpath = "//a[text()='Career']")
    public WebElement anasayfaFooterCareer;

    @FindBy(xpath = "//a[text()='About Us']")
    public WebElement anasayfaFooterAboutUs;

    @FindBy(xpath = "//a[text()='Contact Us']")
    public WebElement anasayfaFooterContactUs;

    @FindBy(xpath = "//a[text()='Career']")
    public WebElement anasayfaFooterServices;

    @FindBy(xpath = "//nav[@id='ftco-navbar']")
    public WebElement anasayfaSayfaTamami;

}
