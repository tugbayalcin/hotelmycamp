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

    @FindBy (xpath = "//span[text()='List Of Hotels']")
    public WebElement listOfHotelsYazısı;
    @FindBy (xpath = "//a[@class='btn btn-xs default']")
    public List<WebElement> listOfHotelsDetailsButonları;
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
    @FindBy (xpath = "//a[@title='Next']")
    public List<WebElement> listOfHotelsİleriButonları;
    @FindBy (xpath = "//a[@title='Prev']")
    public List<WebElement> listOfHotelsGeriButonları;
    @FindBy (xpath = "//*[text()='Add Hotel ']")
    public List<WebElement> listOfHotelsAddHotelButonu;
    @FindBy (xpath = "//*[text()='Clear']")
    public List<WebElement> listOfHotelsClearButonu;
    @FindBy (xpath = "//*[@class='fa fa-download']")
    public List<WebElement> listOfHotelsDowloandButonu;
    @FindBy (xpath = "//*[@class='fa fa-print']")
    public List<WebElement> listOfHotelsPrintButonu;
    //Edit USer sayfası
    @FindBy (xpath = "(//div[@class='caption'])[1]")
    public WebElement EditUserYazısı;
    @FindBy (xpath = "//*[text()='General Data']")
    public WebElement EditUserGeneralDataButonu;
    @FindBy (xpath = "//*[text()='Files']")
    public WebElement EditUserFilesButonu;
    @FindBy (xpath = "//*[@id='UserName']")
    public WebElement EditUserUsernameBox;
    @FindBy (xpath = "//*[@id='Password']")
    public WebElement EditUserPasswordBox;
    @FindBy (xpath = "//*[@id='Email']")
    public WebElement EditUserEmail;
    @FindBy (xpath = "//*[@id='NameSurname']")
    public WebElement EditUserFullNameBox;
    @FindBy (xpath = "//*[@id='PhoneNo']")
    public WebElement EditUserPhoneNoBox;
    @FindBy (xpath = "//*[@id='SSN']")
    public WebElement EditUserSSNBox;
    @FindBy(xpath = "//*[@id='DrivingLicense']")
    public WebElement EditUserDrivinglicenceBox;
    @FindBy (xpath = "//*[@id='IDCountry']")
    public WebElement EditUserCountrySelect;
    @FindBy (xpath = "//*[@id='IDState']")
    public WebElement EditUserStateSelect;
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

    //dddd

}
