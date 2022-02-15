package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class LoginPage {

    public LoginPage (){

        PageFactory.initElements(Driver.getDriver(),this);

    }

    @FindBy(xpath = "//a[@class='nav-link']")
    public WebElement AnasayfaloginButon;
    @FindBy(xpath = "//input[@id='UserName']")
    public WebElement LoginUsernameBox;
    @FindBy(xpath = "//input[@id='Password']")
    public WebElement LoginPasswordBox;
    @FindBy(xpath = "//input[@id='btnSubmit']")
    public WebElement GirisLoginButon;
    @FindBy(xpath = "//a[@class='btn-custom']")
    public WebElement CreateNewAccountButonu;
    @FindBy(xpath = "//div[@class='caption']")
    public WebElement ListOfUsers;
    @FindBy(xpath = "//div[@class='actions']")
    public WebElement AddUserButon;
    @FindBy(xpath = "//*[@id='itemsExportTypes']")
    public WebElement ListOfUsersDosyaTipiSec;
    @FindBy(xpath = "//*[@class='fa fa-download']")
    public WebElement ListOfUsersDownloadButon;
    @FindBy(xpath = "//*[@class='fa fa-print']")
    public WebElement ListOfUsersPrintButon;
    @FindBy(xpath = "//div[@class='margin-bottom-5']")
    public WebElement SearchButon;
    @FindBy(xpath = "//*[@class='btn btn-sm red filter-cancel']")
    public WebElement ClearButon;
    @FindBy(xpath = "//a[@class='btn btn-xs default']")
    public WebElement DetailsButon;
    @FindBy(xpath = "//*[@name='IDUser']")
    public WebElement ListOfUsersIDBox;
    @FindBy(xpath = "//*[@name='UserName']")
    public WebElement ListOfUsersUsernameBox;
    @FindBy(xpath = "//*[@name='Email']")
    public WebElement ListOfUsersEmailBox;
    @FindBy(xpath = "//*[@name='NameSurname']")
    public WebElement ListOfUsersNameSurnameBox;
    @FindBy(xpath = "//*[@class='fa fa-calendar']")
    public WebElement ListOfUsersBirthDateButon ;
    @FindBy(xpath = "//*[@name='PhoneNo']")
    public WebElement ListOfUsersPhoneNoBox;
    @FindBy(xpath = "//*[@id='lkpRoles']")
    public WebElement ListOfUsersRoleBox ;
    @FindBy(xpath = "//*[@name='Approved']")
    public WebElement ListOfUsersApprovedBox ;

}
