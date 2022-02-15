package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class RegistirationPage {

    public RegistirationPage(){
        PageFactory.initElements(Driver.getDriver(),this);
    }

    @FindBy(xpath = "//a[@class='btn-custom']")
    public WebElement createANewAccountButonu;
    @FindBy(xpath = "//h2[text()='Registration Form']")
    public WebElement registrationFormGirisYazisiElementi;
    @FindBy(xpath = "//input[@id='UserName']")
    public WebElement registrationPageUsernameTextBox;
    @FindBy(xpath = "//input[@id='Password']")
    public WebElement registrationPagePasswordTextBox;
    @FindBy(xpath = "//input[@id='Email']")
    public WebElement registrationPageEmailTextBox;
    @FindBy(xpath = "//input[@id='NameSurname']")
    public WebElement registrationPageFullNameTextBox;
    @FindBy(xpath = "//input[@id='PhoneNo']")
    public WebElement registrationPagePhoneNoTextBox;
    @FindBy(xpath = "//input[@id='SSN']")
    public WebElement registrationPageSocialSecurityNumberTextBox;
    @FindBy(xpath = "//input[@id='DrivingLicense']")
    public WebElement registrationPageDrivingLicenceTextBox;
    // country dropdown ***
    @FindBy(xpath = "//select[@id='IDCountry']")
    public WebElement registrationPageCountryDropDown;
    // state dropdown ***
    @FindBy(xpath = "//select[@id='IDState']")
    public WebElement registrationPageStateDropDown;
    @FindBy(xpath = "//input[@id='Address']")
    public WebElement registrationPageAddressTextBox;
    @FindBy(xpath = "//input[@id='WorkingSector']")
    public WebElement registrationPageWorkingSectorTextBox;
    @FindBy(xpath = "//input[@id='BirthDate']")
    public WebElement registrationPageBirthDateTextBox;
    @FindBy(xpath = "//input[@id='btnSubmit']")
    public WebElement registrationPageSaveButonu;
    @FindBy(xpath = "//label[@for='UserName']")
    public WebElement registrationPageUsernameErrorLabel;
    @FindBy(xpath = "//label[@for='Password']")
    public WebElement registrationPagePasswordErrorLabel;
    @FindBy(xpath = "//label[@for='Email']")
    public WebElement registrationPageEmailErrorLabel;
    @FindBy(xpath = "//label[@for='NameSurname']")
    public WebElement registrationPageFullNameErrorLabel;
    @FindBy(xpath = "//label[@for='PhoneNo']")
    public WebElement registrationPagePhoneNoErrorLabel;
    @FindBy(xpath = "//label[@for='SSN']")
    public WebElement registrationPageSocialSecurityNumberErrorLabel;
    @FindBy(xpath = "//label[@for='DrivingLicense']")
    public WebElement registrationPageDrivingLicenceErrorLabel;
    @FindBy(xpath = "//label[@for='IDCountry']")
    public WebElement registrationPageCountryErrorLabel;
    // state icin error label yok
    @FindBy(xpath = "//label[@for='Address']")
    public WebElement registrationPageAddressErrorLabel;
    @FindBy(xpath = "//label[@for='WorkingSector']")
    public WebElement registrationPageWorkingSectorErrorLabel;
    @FindBy(xpath = "//label[@for='BirthDate']")
    public WebElement registrationPageBirthDateErrorLabel;
    @FindBy(xpath = "//div[@class='bootbox-body']")
    public WebElement registrationPagePopupYazisi;
    @FindBy(xpath = "//button[@class='btn btn-primary']")
    public WebElement registrationPagePopupOkButonu;
    @FindBy(xpath = "//div[@id='divMessage']")
    public WebElement registrationPageBasariliKayitYazisi;

}
