package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

import java.util.List;

public class HotelListPage {

    public HotelListPage(){
        PageFactory.initElements(Driver.getDriver(),this);
    }

    @FindBy (xpath = "//*[text()='ListOfUsers']")
    public WebElement listofUserYazısı;

    @FindBy(xpath = "(//span[@class='title'])[3]")
    public WebElement hotelManagementButonu;

    @FindBy(xpath = "(//a[@href='/admin/HotelAdmin'])[1]")
    public WebElement hotelListButonu;

    @FindBy (xpath = "//span[text()='List Of Hotels']")
    public WebElement listOfHotelsYazısı;

    @FindBy (xpath = "//a[@class='btn btn-xs default']")
    public WebElement listOfHotelsDetailsButonu;

    @FindBy (xpath = "//*[text()='Search']")
    public WebElement listOfHotelsSearchButonu;

    @FindBy (xpath = "//input[@name='IDHotel']")
    public WebElement listOfHotelsSearchIDHotelBox;

    @FindBy (xpath = "//input[@name='Code']")
    public WebElement listOfHotelsSearchCodeBox;

    @FindBy (xpath = "//input[@name='Name']")
    public WebElement listOfHotelsSearchNameBox;

    @FindBy (xpath = "//input[@name='Address']")
    public WebElement listOfHotelsSearchAddressBox;

    @FindBy (xpath = "//input[@name='Phone']")
    public WebElement listOfHotelsSearchPhoneBox;

    @FindBy (xpath = "//input[@name='Email']")
    public WebElement listOfHotelsSearchEmailBox;

    @FindBy (xpath = "//select[@id='lkpGroups']")
    public WebElement listOfHotelsSearchIDGroupSelect;

    @FindBy (xpath = "(//a[@title='Next'])[1]")
    public WebElement listOfHotelsİleriButonu;

    @FindBy (xpath = "(//input[@type='text'])[1]")
    public WebElement listOfHotelSayfaSayısınıGösterenYazı;

    @FindBy (xpath = "//a[@title='Prev']")
    public WebElement listOfHotelsGeriButonu;

    @FindBy (xpath = "//*[text()='Add Hotel ']")
    public WebElement listOfHotelsAddHotelButonu;

    @FindBy (xpath = "//*[text()='Clear']")
    public WebElement listOfHotelsClearButonu;

    @FindBy (xpath = "//*[@class='fa fa-download']")
    public WebElement listOfHotelsDowloandButonu;

    @FindBy (xpath = "//*[@class='fa fa-print']")
    public WebElement listOfHotelsPrintButonu;

    @FindBy (xpath = "//*[text()='1188']")
    public WebElement listOfHotel1188noluHotelID;

    //*************************
    // ***********************
    // ** Edit Hotel sayfası locateleri *****

    @FindBy (xpath = "(//div[@class='caption'])[1]")
    public WebElement EditHotelYazısı;

    @FindBy (xpath = "//*[text()='General Data']")
    public WebElement  EditHotelGeneralDataButonu;

    @FindBy (xpath = "//*[@id='Code']")
    public WebElement  EditHotelCodeBox;


    @FindBy (xpath = "//*[@id='Name']")
    public WebElement  EditHotelNameBox;


    @FindBy (xpath = "//*[@id='Address']")

    public WebElement  EditUserAddressBox;
    @FindBy (xpath = "//*[@id='WorkingSector']")
    public WebElement EditUserWorkingSectorBox;
    @FindBy (xpath = "//*[@id='BirthDate']")
    public WebElement  EditUserBirthDateBox;
    @FindBy (xpath = "//*[@id='IDRole']")
    public WebElement EditUserRoleSelect;
    @FindBy (xpath = "(//*[@id=\"uniform-Approved\"])[1]")
    public WebElement EditUserApprovedYesButonu;
    @FindBy (xpath = "(//*[@id=\"uniform-Approved\"])[2]")
    public WebElement EditUserApprovedNoButonu;
    @FindBy (xpath = "//*[text()='Save']")
    public WebElement EditUserSaveButonu;
    @FindBy (xpath = "//*[text()='Delete']")
    public WebElement EditUserDeleteButonu;


        //ADDHOTEL   sayfasi

    @FindBy(xpath = "//span[@class='caption-subject font-green-sharp bold uppercase']")
    public WebElement ListOfHotelsButonu;

    @FindBy(xpath = "//span[@class='hidden-480']")
    public WebElement ADDHOTELButonu;


    @FindBy(xpath = "//div[@class='caption']")
    public WebElement CreateHotelButonu;

    @FindBy(xpath = "//input[@id='Code']")
    public WebElement CreateHotelCodeButonu;

    @FindBy(xpath = "//input[@id='Name']")
    public WebElement CreateHotelNameButonu;

    @FindBy(xpath = "//input[@id='Address']")
    public WebElement CreateHotelAddressButonu;

    @FindBy(xpath = "//input[@id='Phone']")
    public WebElement CreateHotelPhoneButonu;

    @FindBy(xpath = "//input[@id='Email']")
    public WebElement CreateHotelEmailButonu;

    @FindBy(xpath = "//select[@id='IDGroup']")
    public WebElement CreateHotelIDGroupButonu;



    @FindBy(xpath = "(//button[@class='btn blue'])[2]")
    public WebElement CreateHotelSaveButonu;

   @FindBy(xpath = "//div[@class='bootbox-body']")
    public WebElement MesajKutusuButonu;


    @FindBy(xpath = "//button[@class='btn btn-primary']")
    public WebElement MesajOkButonu;



}
