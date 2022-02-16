package pages;

import org.apache.poi.ss.usermodel.*;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import utilities.Driver;
import utilities.ReusableMethods;

import java.io.FileInputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

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

    @FindBy(xpath = "//div[@class='datepicker datepicker-dropdown dropdown-menu datepicker-orient-left datepicker-orient-top']")
    public WebElement takvimWebTable;

    // METHODS ------------------------------------------------------------------------------------

    public List<WebElement> setCredentialsWebElementsList(){
        List<WebElement> credentialsWebElementsList = new ArrayList<>();

        credentialsWebElementsList.add(0,registrationPageUsernameTextBox);
        credentialsWebElementsList.add(1,registrationPagePasswordTextBox);
        credentialsWebElementsList.add(2,registrationPageEmailTextBox);
        credentialsWebElementsList.add(3,registrationPageFullNameTextBox);
        credentialsWebElementsList.add(4,registrationPagePhoneNoTextBox);
        credentialsWebElementsList.add(5,registrationPageSocialSecurityNumberTextBox);
        credentialsWebElementsList.add(6,registrationPageDrivingLicenceTextBox);
        credentialsWebElementsList.add(7,registrationPageCountryDropDown);
        credentialsWebElementsList.add(8,registrationPageStateDropDown);
        credentialsWebElementsList.add(9,registrationPageAddressTextBox);
        credentialsWebElementsList.add(10,registrationPageWorkingSectorTextBox);
        credentialsWebElementsList.add(11,registrationPageBirthDateTextBox);

        return credentialsWebElementsList;
    }

    public String getCell(String path, int satir, int sutun) {
        // String path = "src/test/java/resources/ulkeler.xlsx"; parametre olarak aldim
        FileInputStream fis = null;
        Workbook workbook = null;
        try {
            fis = new FileInputStream(path);
            workbook = WorkbookFactory.create(fis);
        } catch (IOException e) {
            e.printStackTrace();
        }

        Sheet sheet = workbook.getSheet("Sayfa1");
        Row row = sheet.getRow(satir);
        Cell cell = row.getCell(sutun);

        return cell.toString();
/*
        try {
            return cell.getStringCellValue();
        } catch (IllegalStateException e) {
            e.printStackTrace();
        }
        return cell.toString();
*/

    }


    public void fillTextBox (WebElement element)
    {
        ReusableMethods reusableMethods = new ReusableMethods();
        reusableMethods.hooverByJS(element);
        element.click();
        element.sendKeys(getCell("src/test/java/resources/Credentials.xlsx",1,1));
    }

    public void fillTheForm(List<WebElement> list,int satir, int ignoreEdilecekSutunSayisi)
    {
        ReusableMethods reusableMethods = new ReusableMethods();
        for (int i=0; i<list.size(); i++)
        {
            reusableMethods.hooverByJS(list.get(i));
            if(i<=6 && i!=0 && i!=2){
                list.get(i).sendKeys(getCell("src/test/java/resources/Credentials.xlsx",satir,i+ignoreEdilecekSutunSayisi));

            }
            else if(i==0 || i==2 || i==9 ){
                String date = new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());
                list.get(i).sendKeys(date+getCell("src/test/java/resources/Credentials.xlsx",satir,i+ignoreEdilecekSutunSayisi));

            }
            else if(i==7 && i==8){
                Select select = new Select(list.get(i));
                select.selectByVisibleText(getCell("src/test/java/resources/Credentials.xlsx",satir,i+ignoreEdilecekSutunSayisi));
            }
            else
            {
                list.get(i).sendKeys(getCell("src/test/java/resources/Credentials.xlsx",satir,i+ignoreEdilecekSutunSayisi));

            }
        }
    }



}
