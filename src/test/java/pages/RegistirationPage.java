package pages;

import org.apache.poi.ss.usermodel.*;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import utilities.*;

import java.io.FileInputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static utilities.ObjectInitialiser.*;

public class RegistirationPage extends TestBaseRapor {


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

    @FindBy(xpath = "//label[@for='IDState']")
    public WebElement registrationPageStateErrorLabel;

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

    @FindBy(xpath = "//h1[@class='mb-4 bread']")
    public WebElement registerPageHeader;


    //<editor-fold desc="Methods">

    /**
     * @author tugba
     * This method is includes first 4 step for Registration Page Test Cases
     */
    public void beginnerStepsForRegistrationPageTests()
    {
        Driver.getDriver().get(ConfigReader.getProperty("HMCURL"));

        ReusableMethods.waitFor(1);
        Assert.assertTrue(anaSayfaPage.mainLoginLinki.isDisplayed());
        ReusableMethods.waitFor(1);
        anaSayfaPage.mainLoginLinki.click();

        Assert.assertTrue(loginPage.CreateNewAccountButonu.isDisplayed());
        loginPage.CreateNewAccountButonu.click();

        Assert.assertTrue(registrationFormGirisYazisiElementi.isDisplayed());
    }

    /**
     * @author tugba
     * This method puts the Web Elements of the textbox to be filled into a list
     * And it returns this list
     * Method is not dynamic
     * It created for only Registration Page textbox element's
     */
    public List<WebElement> setCredentialsWebElementsList()
    {
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

    /**
     * @author tugba
     * This method puts the Web Elements Error Line into a list
     * And it returns this list
     * Method is not dynamic
     * It created for only Registration Page error line element's
     */
    public List<WebElement> setCredentialsWebElementsErrorLineList()
    {
        List<WebElement> credentialsWebElementsErrorLineList = new ArrayList<>();

        credentialsWebElementsErrorLineList.add(0,registrationPageUsernameErrorLabel);
        credentialsWebElementsErrorLineList.add(1,registrationPagePasswordErrorLabel);
        credentialsWebElementsErrorLineList.add(2,registrationPageEmailErrorLabel);
        credentialsWebElementsErrorLineList.add(3,registrationPageFullNameErrorLabel);
        credentialsWebElementsErrorLineList.add(4,registrationPagePhoneNoErrorLabel);
        credentialsWebElementsErrorLineList.add(5,registrationPageSocialSecurityNumberErrorLabel);
        credentialsWebElementsErrorLineList.add(6,registrationPageDrivingLicenceErrorLabel);
        credentialsWebElementsErrorLineList.add(7,registrationPageCountryErrorLabel);
        credentialsWebElementsErrorLineList.add(8,registrationPageStateErrorLabel);
        credentialsWebElementsErrorLineList.add(9,registrationPageAddressErrorLabel);
        credentialsWebElementsErrorLineList.add(10,registrationPageWorkingSectorErrorLabel);
        credentialsWebElementsErrorLineList.add(11,registrationPageBirthDateErrorLabel);

        return credentialsWebElementsErrorLineList;
    }

    /**
     * @author tugba
     * This method puts only the Error Line Elements of the password element in the list
     * And it returns this list
     * Method is not dynamic
     * It created for only Registration Page Password WebElement error line element's
     */
    public List<String> setPasswordErrorList()
    {
        List<String> passwordErrorList = new ArrayList<>();

        passwordErrorList.add(0,"testDataInvalidPassword1");
        passwordErrorList.add(1,"testDataInvalidPassword2");
        passwordErrorList.add(2,"testDataInvalidPassword3");
        passwordErrorList.add(3,"testDataInvalidPassword4");
        passwordErrorList.add(4,"testDataInvalidPassword5");

        return passwordErrorList;
    }

    /**
     * @author tugba
     * This method puts the Web Elements Error Line's Text into a list
     * And it returns this list
     * Method is not dynamic
     * It created for only Registration Page error line element's
     */
    public List<String> setMissingCredentialErrorList()
    {
        List<String> missingCredentialErrorList = new ArrayList<>();
        missingCredentialErrorList.add(0,"testDataMissingUsername");
        missingCredentialErrorList.add(1,"testDataMissingPassword");
        missingCredentialErrorList.add(2,"testDataMissingEmail");
        missingCredentialErrorList.add(3,"testDataMissingFullName");
        missingCredentialErrorList.add(4,"testDataMissingPhoneNo");
        missingCredentialErrorList.add(5,"testDataMissingSSN");
        missingCredentialErrorList.add(6,"testDataMissingDrivingLicence");
        missingCredentialErrorList.add(7,"testDataMissingCountry");
        missingCredentialErrorList.add(8,"testDataMissingState");
        missingCredentialErrorList.add(9,"testDataMissingAddress");
        missingCredentialErrorList.add(10,"testDataMissingWorkingSector");
        missingCredentialErrorList.add(11,"testDataMissingBirthDate");

        return  missingCredentialErrorList;
    }

    /**
     * @author tugba
     * This method read the excel file
     * And it returns cell's text as a String
     * Method is not full dynamic, because we have to give row and column index
     */
    public String getCellValue(String path, int satir, int sutun)
    {
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

    /**
     * @author tugba
     * This method fill the only one textbox
     * And it fill textbox with cell value as a String
     * Method is not full dynamic, because we have to give row and column index
     */
    public void fillTextBox (String filePathNameFromConfigProp,WebElement element, int satir, int sutun)
    {
        ReusableMethods.hooverByJS(element);
        element.sendKeys(getCellValue(ConfigReader.getProperty(filePathNameFromConfigProp),satir,sutun));
        // "testDataExcelFile"
    }

    /**
     * @author tugba
     * This method fill the all Registration Form
     * It created for only Registration Page textbox element's and only Credentials.xlxs file
     * If the file is change, this method will not working
     * So please be carefull use that method
     * And also this method fills the form with unique values
     */
    public void fillTheForm(String filePathNameFromConfigProp,List<WebElement> list, int satir)
    {
        for (int i=0; i<list.size(); i++)
        {
            ReusableMethods.hooverByJS(list.get(i));
            if(i<=6 && i!=0 && i!=2){
                list.get(i).sendKeys(getCellValue("src/test/java/resources/Credentials.xlsx",satir,i+2));

            }
            else if(i==0 || i==2 || i==9 ){
                list.get(i).sendKeys(date+getCellValue("src/test/java/resources/Credentials.xlsx",satir,i+2));

            }
            else if(i==7 || i==8){
                Select select = new Select(list.get(i));
                select.selectByVisibleText(getCellValue("src/test/java/resources/Credentials.xlsx",satir,i+2));
            }
            else
            {
                list.get(i).sendKeys(getCellValue("src/test/java/resources/Credentials.xlsx",satir,i+2));

            }
        }
    }

    /**
     * @author tugba
     * This method fill the all Registration Form
     * It created for only Registration Page textbox element's and only Credentials.xlxs file
     * If the file is change, this method will not working
     * So please be carefull use that method
     * And also this method fills the form without unique values
     */
    public void fillTheFormWithoutDate(String filePathNameFromConfigProp,List<WebElement> list, int satir)
    {
        for (int i=0; i<list.size(); i++)
        {
            ReusableMethods.hooverByJS(list.get(i));

            if(i==7 || i==8){
                Select select = new Select(list.get(i));
                select.selectByVisibleText(getCellValue("src/test/java/resources/Credentials.xlsx",satir,i+2));
            }
            else
            {
                list.get(i).sendKeys(getCellValue("src/test/java/resources/Credentials.xlsx",satir,i+2));
            }
        }
    }

    /**
     * @author tugba
     * This method fill the all Registration Form without Birth Date textbox
     * It created for only Registration Page textbox element's and only Credentials.xlxs file
     * If the file is change, this method will not working
     * So please be carefull use that method
     * And also this method fills the form without unique values
     */
    public void fillTheFormWithoutBirthDate(String filePathNameFromConfigProp,List<WebElement> list, int satir)
    {
        for (int i=0; i<list.size()-1; i++)
        {
            ReusableMethods.hooverByJS(list.get(i));

            if(i==7 || i==8){
                Select select = new Select(list.get(i));
                select.selectByVisibleText(getCellValue("src/test/java/resources/Credentials.xlsx",satir,i+2));
            }
            else
            {
                list.get(i).sendKeys(getCellValue("src/test/java/resources/Credentials.xlsx",satir,i+2));
            }
        }
    }

    /**
     * @author tugba
     * This method contains the loops that the username test method needs
     */
    public void fillTheFormForUsernameTests(String filePathNameFromConfigProp,List<WebElement> list, int satir)
    {
        for (int i=0; i<list.size(); i++)
        {
            ReusableMethods.hooverByJS(list.get(i));
            if(i<=6 && i!=0 && i!=2){
                list.get(i).sendKeys(getCellValue("src/test/java/resources/Credentials.xlsx",satir,i+2));

            }
            else if(i==0){
                list.get(i).sendKeys(getCellValue("src/test/java/resources/Credentials.xlsx",satir,i+2));


            }
            else if(i==2 || i==9 ){
                String date = new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());
                list.get(i).sendKeys(date+getCellValue("src/test/java/resources/Credentials.xlsx",satir,i+2));

            }
            else if(i==7 && i==8){
                Select select = new Select(list.get(i));
                select.selectByVisibleText(getCellValue("src/test/java/resources/Credentials.xlsx",satir,i+2));
            }
            else
            {
                list.get(i).sendKeys(getCellValue("src/test/java/resources/Credentials.xlsx",satir,i+2));

            }
        }
    }

    /**
     * @author tugba
     * This method is USERNAME TEST METHOD
     */
    public void usernameTests(int baslangicSatir, int bitisSatir,String errorTestData)
    {

        for (int i=baslangicSatir; i<bitisSatir ; i++)
        {
            // DRY'dan kurtulduk
            beginnerStepsForRegistrationPageTests();

            // unitlrrin ve componentlerin calismasinda sikintilar var
            // ben  burada unit test veya component test yapmiyorum
            // dolayisiyla bu sebeplerden kaynaklanan hatalardan kacarak test case'imi gerceklestirmeye calisacagim
            // undan oturu tekrarli kullanimlar yapmak zorundayim
            // unitler ve component duzgun cslistiginda tum bu adimlar teb bir method ile dry'dan kurtularak
            // cok daha kisa ve oz bir sekilde yapilabilir

            fillTheFormForUsernameTests("testDataExcelFile",setCredentialsWebElementsList(),i);

            Assert.assertTrue(takvimWebTable.isDisplayed());
            takvimWebTable.click();
            // bunu yapmazsam takvim acik kaliyor ve send butonu gorunmuyor

            Assert.assertTrue(registrationPageSaveButonu.isDisplayed());
            registrationPageSaveButonu.click();

            ReusableMethods.hooverByJS(registrationPageUsernameTextBox);
            Assert.assertTrue(registrationPageUsernameErrorLabel.isDisplayed());
            String expectedUsernameErrorLabelText = ConfigReader.getProperty(errorTestData);
            softAssert.assertEquals(registrationPageUsernameErrorLabel.getText(), expectedUsernameErrorLabelText);
            softAssert.assertAll();

        }
    }


    /**
     * @author tugba
     * This method is ALREADY EXIST USERNAME TEST METHOD
     */
    public void usernameAlreadyExistTests(int baslangicSatir, int bitisSatir,String errorTestData)
    {

        for (int i=baslangicSatir; i<bitisSatir ; i++)
        {
            // DRY'dan kurtulduk
            beginnerStepsForRegistrationPageTests();

            // unitlrrin ve componentlerin calismasinda sikintilar var
            // ben  burada unit test veya component test yapmiyorum
            // dolayisiyla bu sebeplerden kaynaklanan hatalardan kacarak test case'imi gerceklestirmeye calisacagim
            // undan oturu tekrarli kullanimlar yapmak zorundayim
            // unitler ve component duzgun cslistiginda tum bu adimlar teb bir method ile dry'dan kurtularak
            // cok daha kisa ve oz bir sekilde yapilabilir

            fillTheFormForUsernameTests("testDataExcelFile",setCredentialsWebElementsList(),i);

            Assert.assertTrue(takvimWebTable.isDisplayed());
            takvimWebTable.click();
            // bunu yapmazsam takvim acik kaliyor ve send butonu gorunmuyor

            Assert.assertTrue(registrationPageSaveButonu.isDisplayed());
            registrationPageSaveButonu.click();

            ReusableMethods.waitFor(3);
            Assert.assertTrue(registrationPagePopupYazisi.isDisplayed());
            String expectedPopupYazisi= ConfigReader.getProperty("testDataAlreadyTakenUsernameAddress");
            softAssert.assertEquals(registrationPagePopupYazisi.getText(),expectedPopupYazisi);
            ReusableMethods.getScreenShots("AlreadyExistUsernameTestSS","target/screenshots/US003/");
            softAssert.assertAll();

        }
    }


    /**
     * @author tugba
     * This method is PASSWORD TEST METHOD
     */
    public void passwordTests(int baslangicSatir, int bitisSatir, List<String> errorList)
    {
        int errorIndex=0;
        for (int i=baslangicSatir; i<bitisSatir ; i++)
        {
            registirationPage.beginnerStepsForRegistrationPageTests();
            fillTheForm("testDataExcelFile",registirationPage.setCredentialsWebElementsList(),i);

            Assert.assertTrue(registirationPage.takvimWebTable.isDisplayed());
            registirationPage.takvimWebTable.click();
            // bunu yapmazsam takvim acik kaliyor ve send butonu gorunmuyor

            Assert.assertTrue(registirationPage.registrationPageSaveButonu.isDisplayed());
            registirationPage.registrationPageSaveButonu.click();

            ReusableMethods.hooverByJS(registirationPage.registrationPagePasswordTextBox);
            Assert.assertTrue(registirationPage.registrationPagePasswordErrorLabel.isDisplayed());

            String expectedPasswordErrorLabelText = ConfigReader.getProperty(errorList.get(errorIndex));
            Assert.assertEquals(registirationPage.registrationPagePasswordErrorLabel.getText(),expectedPasswordErrorLabelText);


            errorIndex++;

        }
    }

    /**
     * @author tugba
     * This method is EMAIL TEST METHOD
     */
    public void emailTests(int baslangicSatir, int bitisSatir, String error)
    {

        for (int i=baslangicSatir; i<bitisSatir ; i++)
        {
            registirationPage.beginnerStepsForRegistrationPageTests();
            fillTheForm("testDataExcelFile",registirationPage.setCredentialsWebElementsList(),i);

            Assert.assertTrue(registirationPage.takvimWebTable.isDisplayed());
            registirationPage.takvimWebTable.click();
            // bunu yapmazsam takvim acik kaliyor ve send butonu gorunmuyor

            Assert.assertTrue(registirationPage.registrationPageSaveButonu.isDisplayed());
            registirationPage.registrationPageSaveButonu.click();

            ReusableMethods.hooverByJS(registirationPage.registrationPageEmailTextBox);
            Assert.assertTrue(registirationPage.registrationPageEmailErrorLabel.isDisplayed());

            String expectedEmailErrorLabelText = ConfigReader.getProperty(error);
            softAssert.assertEquals(registirationPage.registrationPageEmailErrorLabel.getText(),expectedEmailErrorLabelText);
            softAssert.assertAll();




        }
    }

    /**
     * @author tugba
     * This method is EMAIL TEST METHOD
     */
    public void emailTestsWithPopup(int baslangicSatir, int bitisSatir, String error)
    {

        for (int i=baslangicSatir; i<bitisSatir ; i++)
        {
            registirationPage.beginnerStepsForRegistrationPageTests();
            fillTheFormWithoutDate("testDataExcelFile",registirationPage.setCredentialsWebElementsList(),i);

            Assert.assertTrue(registirationPage.takvimWebTable.isDisplayed());
            registirationPage.takvimWebTable.click();
            // bunu yapmazsam takvim acik kaliyor ve send butonu gorunmuyor

            Assert.assertTrue(registirationPage.registrationPageSaveButonu.isDisplayed());
            registirationPage.registrationPageSaveButonu.click();

            ReusableMethods.waitFor(3);
            Assert.assertTrue(registrationPagePopupYazisi.isDisplayed());
            String expectedPopupYazisi= ConfigReader.getProperty("testDatanoneExistEmailAddress");
            softAssert.assertEquals(registrationPagePopupYazisi.getText(),expectedPopupYazisi);
            ReusableMethods.getScreenShots("AlreadyExistUsernameTestSS","target/screenshots/US003/");
            //softAssert.assertAll();

        }
    }

    /**
     * @author tugba
     * This method is EMAIL TEST METHOD
     */
    public void emailTestsWithPopupWithDate(int baslangicSatir, int bitisSatir, String error)
    {

        for (int i=baslangicSatir; i<bitisSatir ; i++)
        {
            registirationPage.beginnerStepsForRegistrationPageTests();
            fillTheForm("testDataExcelFile",registirationPage.setCredentialsWebElementsList(),i);

            Assert.assertTrue(registirationPage.takvimWebTable.isDisplayed());
            registirationPage.takvimWebTable.click();
            // bunu yapmazsam takvim acik kaliyor ve send butonu gorunmuyor

            Assert.assertTrue(registirationPage.registrationPageSaveButonu.isDisplayed());
            registirationPage.registrationPageSaveButonu.click();

            ReusableMethods.waitFor(3);
            Assert.assertTrue(registrationPagePopupYazisi.isDisplayed());
            String expectedPopupYazisi= ConfigReader.getProperty("testDatanoneExistEmailAddress");
            softAssert.assertEquals(registrationPagePopupYazisi.getText(),expectedPopupYazisi);
            ReusableMethods.getScreenShots("AlreadyExistUsernameTestSS","target/screenshots/US003/");
            //softAssert.assertAll();

        }
    }

    /**
     * @author tugba
     * This method is MISSING CREDENTİAL TEST METHOD
     */
    public void missingCredentialsTests(List<WebElement> list, List<WebElement> errorLineElementList, List<String> errorList, int baslangicSatir, int bitisSatir)
    {
        // state icin 8'e if koy

        for (int i=0; i<list.size(); i++)
        {


            if(i!=11)
            {
                registirationPage.beginnerStepsForRegistrationPageTests();
                fillTheFormWithoutDate("testDataExcelFile",registirationPage.setCredentialsWebElementsList(),baslangicSatir);

                Assert.assertTrue(registirationPage.takvimWebTable.isDisplayed());
                registirationPage.takvimWebTable.click();
                // bunu yapmazsam takvim acik kaliyor ve send butonu gorunmuyor

                Assert.assertTrue(registirationPage.registrationPageSaveButonu.isDisplayed());
                registirationPage.registrationPageSaveButonu.click();

                ReusableMethods.hooverByJS(list.get(i));
                Assert.assertTrue(errorLineElementList.get(i).isDisplayed());

                String expectedText = ConfigReader.getProperty(errorList.get(i));
                Assert.assertEquals(errorLineElementList.get(i).getText(),expectedText);
            }
            else if(i==11)
            {
                registirationPage.beginnerStepsForRegistrationPageTests();

                fillTheFormWithoutBirthDate("testDataExcelFile",registirationPage.setCredentialsWebElementsList(),baslangicSatir);

                //Assert.assertTrue(registirationPage.takvimWebTable.isDisplayed());
                //registirationPage.takvimWebTable.click();
                // bunu yapmazsam takvim acik kaliyor ve send butonu gorunmuyor

                Assert.assertTrue(registirationPage.registrationPageSaveButonu.isDisplayed());
                registirationPage.registrationPageSaveButonu.click();

                ReusableMethods.hooverByJS(list.get(i));
                Assert.assertTrue(errorLineElementList.get(i).isDisplayed());

                String expectedText = ConfigReader.getProperty(errorList.get(i));
                Assert.assertEquals(errorLineElementList.get(i).getText(),expectedText);
            }



            if(baslangicSatir<bitisSatir)
            {
                baslangicSatir++;
            }


        }
    }

    /**
     * @author tugba
     * This method is MISSING CREDENTİAL TEST METHOD For Only Country-State Couple
     * If select Country=United States, you have to choose any State
     * If you select a country other than United States, you can's choose any State
     * This method tested about that
     */
    public void missingCountryStateRelationshipTest() {
        // formu dolduracagiz
        beginnerStepsForRegistrationPageTests();

        ReusableMethods.hooverByJS(registrationPageCountryDropDown);
        Select select = new Select(registrationPageCountryDropDown);
        String selectText = ReusableMethods.selectRandomTextFromDropdown(select).getText();

            if (selectText.equals("United States")) {
                registrationPageSaveButonu.click();
                ReusableMethods.hooverByJS(registrationPageStateDropDown);
                Assert.assertTrue(registrationPageStateErrorLabel.isDisplayed());
                String expectedErrorText = ""+ConfigReader.getProperty("testDataMissingState");
                Assert.assertEquals(registrationPageStateErrorLabel.getText(),expectedErrorText);
                ReusableMethods.getScreenShots("CountryTest_UnitedStates_SS","target/screenshots/US003/");
            } else {

                ReusableMethods.hooverByJS(registrationPageUsernameTextBox);
                registrationPageUsernameTextBox.sendKeys(date+ConfigReader.getProperty("testDataUsername"));
                ReusableMethods.hooverByJS(registrationPagePasswordTextBox);
                registrationPagePasswordTextBox.sendKeys(ConfigReader.getProperty("testDataPassword"));
                ReusableMethods.hooverByJS(registrationPageEmailTextBox);
                registrationPageEmailTextBox.sendKeys(date+ConfigReader.getProperty("testDataEmail"));
                ReusableMethods.hooverByJS(registrationPageFullNameTextBox);
                registrationPageFullNameTextBox.sendKeys(ConfigReader.getProperty("testDataFullName"));
                ReusableMethods.hooverByJS(registrationPagePhoneNoTextBox);
                registrationPagePhoneNoTextBox.sendKeys(ConfigReader.getProperty("testDataPhoneNo"));
                ReusableMethods.hooverByJS(registrationPageSocialSecurityNumberTextBox);
                registrationPageSocialSecurityNumberTextBox.sendKeys(ConfigReader.getProperty("testDataSSN"));
                ReusableMethods.hooverByJS(registrationPageDrivingLicenceTextBox);
                registrationPageDrivingLicenceTextBox.sendKeys(ConfigReader.getProperty("testDataDrivingLicence"));
                ReusableMethods.hooverByJS(registrationPageAddressTextBox);
                registrationPageAddressTextBox.sendKeys(ConfigReader.getProperty("testDataAddress"));
                ReusableMethods.hooverByJS(registrationPageWorkingSectorTextBox);
                registrationPageWorkingSectorTextBox.sendKeys(ConfigReader.getProperty("testDataWorkingSector"));
                ReusableMethods.hooverByJS(registrationPageBirthDateTextBox);
                registrationPageBirthDateTextBox.sendKeys(ConfigReader.getProperty("testDataBirthDate"));

                ReusableMethods.hooverByJS(registrationPageBirthDateTextBox);
                Assert.assertTrue(registirationPage.takvimWebTable.isDisplayed());
                registirationPage.takvimWebTable.click();

                ReusableMethods.hooverByJS(registrationPageBirthDateTextBox);
                registrationPageSaveButonu.click();

                ReusableMethods.waitFor(3);
                Assert.assertTrue(registrationPagePopupYazisi.isDisplayed());

                String expectedPopupYazisi = ConfigReader.getProperty("validCredentialsTestDataExpectedPopupYazisi");
                String actualPopupYazisi = registirationPage.registrationPagePopupYazisi.getAttribute("innerText");
                softAssert.assertEquals(actualPopupYazisi,expectedPopupYazisi);

                registrationPagePopupOkButonu.click();
                ReusableMethods.hooverByJS(registerPageHeader);

                softAssert.assertTrue(registirationPage.registrationPageBasariliKayitYazisi.isDisplayed(),"Kayıt Gerçekleşti Ancak Register Sayfası Açılamadı. Detaylı Bilgi Için Screenshot'a Bakınız");

                ReusableMethods.getScreenShots("CountryTest_OtherCountries_SS","target/screenshots/US003/");


                softAssert.assertAll();
            }

    }


    /**
     * @author tugba
     * This method is clear all the form
     */
    public void clearTheForm(List<WebElement> list)
    {
        for (int i=0; i<list.size(); i++) {

            ReusableMethods.hooverByJS(list.get(i)); // burasi click de yapiyor
            if(i!=7 && i!=8) {
                list.get(i).clear();
            }
            else if(i==7){
                Select select = new Select(list.get(i));
                select.selectByVisibleText("Select Country");
            }
            else{
                Select select = new Select(list.get(i));
                select.selectByVisibleText("Select State");
            }
            // ByIndex yapabilirdim ama state'in dropdown'i duzgun degil, surekli degisiyor,
            // ilk sıradakilerin indexlerinin 0 oldugundan emin degilim
            // select test ekranindsyken tamamen bozuluyor

        }
    }


    //</editor-fold>


    //<editor-fold desc="Excel Header Okuma Methodları">

    // bu method  sutun isimlerini aldı
    public List<String> setFileColumnHeaderList(String filePathNameFromConfigProp,String sheetName,int HeaderLineIndex, int beginningColumnIndex)
    {
        List<String> columnHeaderList = new ArrayList<>();

        // int lastColumnIndex = getColumnCount(filePathNameFromConfigProp,sheetName)-1;
        ExcelUtil excelUtil = new ExcelUtil(filePathNameFromConfigProp,sheetName);
        int lastColumnIndex = excelUtil.columnCount();
        int listIndex = 0;
        for (int i=beginningColumnIndex; i<lastColumnIndex; i++)
        {
            String cell = getCellValue(filePathNameFromConfigProp,HeaderLineIndex,i);
            columnHeaderList.add(listIndex,cell);
            listIndex++;
        }
        return columnHeaderList;
    }

    //  bu method satir isimlerini aldi --> tablo revize olunca index revizesi gelece
    public List<String> setFileRowHeaderList(String filePathNameFromConfigProp,String sheetName)
    {

        List<String> rowHeaderList = new ArrayList<>();
        ExcelUtil excelUtil = new ExcelUtil(filePathNameFromConfigProp,sheetName);
        FileInputStream fis = null;
        Workbook workbook = null;
        int listIndex=0;
        try {
            fis = new FileInputStream(filePathNameFromConfigProp);
            workbook = WorkbookFactory.create(fis);
        } catch (IOException e) {
            e.printStackTrace();
        }
        Sheet sheet = workbook.getSheet(sheetName);
        int rowCount = excelUtil.rowCount();

        for (int i = 1; i < rowCount; i++) {
            // get each row
            Row row = workbook.getSheet(sheetName).getRow(i);
            Cell cell = null;
            String rowName = null;

            //row!=null ? cell = row.getCell(1) : cell=null;
            //cell!=null ? rowName=cell.toString() : rowName=null;

            try{
                cell = row.getCell(0); // yeni tabloya gecince burayi 1 yap !!!!
                rowName = cell.toString();
            }
            catch(NullPointerException e){
                e.printStackTrace();
            };
            rowHeaderList.add(listIndex,rowName);
            listIndex++;
        }

        return rowHeaderList;
    }

    public void fillTheForm2(String filePathNameFromConfigProp,List<WebElement> list, List<String> columnHeaderList, List<String> rowHeaderList)
    {

        for (int i=0; i<columnHeaderList.size(); i++) {

            for (int j=0; j<rowHeaderList.size() ; j++) {

                // if(columnHeaderList.get(i)=="USERNMAE")
                // bu yaptıgımı mantık olarak cozume kavusturammadım, bu sebeple digeri uzerinde sorunuma cozum olacak
                // duzenlemeler yapacagim

            }

        }

    }


    //</editor-fold>











}
