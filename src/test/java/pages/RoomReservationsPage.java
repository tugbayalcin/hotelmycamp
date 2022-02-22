package pages;

import com.github.javafaker.Faker;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ReusableMethods;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

public class RoomReservationsPage {

    public RoomReservationsPage(){

        PageFactory.initElements(Driver.getDriver(),this);
    }



    @FindBy(xpath = "//span[text()='Hotel Management']")
    public WebElement hotelManagementList;

    @FindBy(xpath = "(//i[@class='icon-calendar'])[4]")
    public WebElement roomReservationsList;

    @FindBy(xpath = "//span[text()='List Of Reservations']")
    public WebElement listOfReservations;

    @FindBy(xpath = "//input[@name='ContactPhone']")
    public WebElement ContactPhoneBox;

    @FindBy(xpath = "//div[@class='table-scrollable']")
    public WebElement reservationsListSagaKaydir;

    @FindBy(xpath = "//select[@class='form-control form-filter input-sm']")
    public List<WebElement> hotelRoomDropDownElementi;

    @FindBy (xpath = "//button[@class='btn btn-sm yellow filter-submit margin-bottom']")
    public WebElement searchButon;

    @FindBy(xpath = "//button[@class='btn btn-sm red filter-cancel']")
    public WebElement clearButon;

    @FindBy (xpath = "//a[@class='btn btn-xs default']")
    public WebElement detailsButon;

    @FindBy(xpath = "(//input[@class='form-control input valid'])[1]")
    public WebElement dateStart;

    @FindBy (xpath = "(//input[@class='form-control input-lg required'])[1]")
    public WebElement priceBox;

    @FindBy(xpath = "(//button[@class='btn green'])[1]")
    public WebElement saveButon;

    @FindBy (xpath = "(//a[@data-toggle='tab'])[2]")
    public WebElement propertiesButon;

    @FindBy (xpath = "(//input[@type='text'])[11]")
    public WebElement codeBox;

    @FindBy(xpath = "(//textarea[@class='form-control'])[1]")
    public WebElement valueBox;

    @FindBy(xpath = "(//a[@class='btn default btn-sm'])[1]")
    public WebElement updateButon;

    @FindBy (xpath = "//div[text()='Value was updated Succesfully']")
    public WebElement updateSuccesfullyElementi;

    @FindBy (xpath = "(//button[@class='btn btn-primary'])[1]")
    public WebElement updateSuccesfullyOk;

    @FindBy(xpath = "//input[@id='AdultAmount']")
    public WebElement adultAmountBox;

    @FindBy(xpath = "//input[@id='ContactNameSurname']")
    public WebElement contactNameSurnameBox;

    @FindBy(xpath = "//div[@class='caption']")
    public WebElement deleteYazisi;

    @FindBy(xpath = "//button[@id='btnDelete']")
    public WebElement deleteButon;

    @FindBy(xpath = "//div[@class='page-content-wrapper']")
    public WebElement editSayfa;

    @FindBy(xpath = "//span[text()='Try again please']")
    public WebElement girisYapilamadiYazisi;

    @FindBy(xpath = "//div[@class=‘modal-content’]")
    public WebElement roomSuccesfullyYazisi;

    @FindBy(xpath = "//label[text()='DateEnd']")
    public WebElement roomReservationsBosTik;

    @FindBy(xpath = "//select[@id='AdultCount']")
    public WebElement selectAdultCountButonu;

    @FindBy(xpath = "//select[@id='ChildrenCount']")
    public WebElement selectChildrenCountButonu;

    @FindBy(xpath = "//select[@name='CreditCardExpirationYear']")
    public WebElement krediKartExprationYear;

    @FindBy(xpath = "//select[@name='CreditCardExpirationMonth']")
    public WebElement krediKartExprationMonth;

    @FindBy(xpath = "//input[@id='NameSurname']")
    public WebElement isimSoyisimKutusuRezevasyonSayfası;

    @FindBy(xpath = "//input[@value='Book this room']")
    public WebElement bookThisRoomButonu;

    @FindBy(xpath = "(//div[text()='Reservation was made successfully'])[2]")
    public WebElement succesfullyYazısı;



    public void roomReservationsGiris() throws InterruptedException {

        Driver.getDriver().get(ConfigReader.getProperty("HMCURL"));
        AnaSayfaPage anaSayfaPage = new AnaSayfaPage();
        RoomReservationsPage roomReservationsPage = new RoomReservationsPage();
        LoginPage loginPage = new LoginPage();
        anaSayfaPage.mainLoginLinki.click();
        loginPage.LoginUsernameBox.sendKeys(ConfigReader.getProperty("ManagerUsername"));
        loginPage.LoginPasswordBox.sendKeys(ConfigReader.getProperty("ManagerPassword"));
        loginPage.GirisLoginButon.click();
        roomReservationsPage.hotelManagementList.click();
        roomReservationsPage.roomReservationsList.click();

        Thread.sleep(500);
    }


   // US008
   @FindBy (xpath = "//select[@id='IDUser']")
   public WebElement createReservationsidUserDropDownElementi;

    @FindBy (xpath = "//select[@id='IDHotelRoom']")
    public WebElement createReservationsidUserHotelRoomDropDownElementi;

    @FindBy (xpath = "//input[@id='Price']")
    public WebElement createReservationspriceBoxElementi;

    @FindBy(xpath = "//input[@id='AdultAmount']")
    public WebElement createReservationsAdultAmount;

    @FindBy(xpath = "(//button[@type='button'])[8]")
    public WebElement createReservationsOkButon;


    //-----------------------

    Faker faker = new Faker();
    //ADD ROOM RESERVATIONS butonu
    @FindBy(xpath = "//span[text()='Add Room Reservation ']")
    public WebElement addRoomReservationsWebElement;

    //selectUser dropdown
    @FindBy(xpath = "(//select[@class='form-control input-lg required'])[1]")
    public WebElement selectUserDropdownWebElement;

    //selecthotelroom dropdown
    @FindBy(xpath = "(//select[@class='form-control input-lg required'])[2]")
    public WebElement selecthotelroomDropdownWebElement;

    //price webelement
    @FindBy(id = "Price")
    public WebElement priceWebElement;

    //dateStart webelement
    @FindBy(id = "DateStart")
    public WebElement dateStartWebElement;

    //dateEnd webelement
    @FindBy(id = "DateEnd")
    public WebElement dateEndWebElement;

    //AdultAmount webelement
    @FindBy(xpath = "//input[@id='AdultAmount']")
    public WebElement adultAmountWebElement;

    //ChildrenAmount webelement
    @FindBy(xpath="//input[@id='ChildrenAmount']")
    public WebElement childrenAmountWebElement;

    //ContactNameSurname webelement
    @FindBy (xpath="//input[@id='ContactNameSurname']")
    public WebElement contactNameSurnameWebElement;

    //ContactPhone webelement
    @FindBy (xpath="//input[@id='ContactPhone']")
    public WebElement contactPhoneWebElement;

    //ContactEmail webelement
    @FindBy (xpath = "//input[@id='ContactEmail']")
    public WebElement contactEmailWebElement;

    //Notes webelement
    @FindBy (xpath = "//input[@id='Notes']")
    public WebElement notesWebElement;

    //Approved webelement
    @FindBy (xpath = "//div[@id='uniform-Approved']")
    public WebElement approvedWebElementCheckBox;

    //IsPaid webelement
    @FindBy (xpath = "//div[@id='uniform-IsPaid']")
    public WebElement isPaidWebElementCheckBox;

    //Save button webelement
    @FindBy(id = "btnSubmit")
    public WebElement saveButtonWebElement;


    //alert text webelement
    @FindBy (className = "bootbox-body")
    public WebElement alertTextWebElement;

    //alert button webelement
    @FindBy (xpath = "//button[@class='btn btn-primary']")
    public WebElement alertButtonWebElement;

    public void addRoomReservations() {
        hotelManagementList.click();
        roomReservationsList.click();
        addRoomReservationsWebElement.click();
    }

    //selectUser dropdown elementinden eleman seçer
    public void selectUserDropdownElementSecimi() {
        Faker faker = new Faker();
        Select select = new Select(selectUserDropdownWebElement);
        List<WebElement> idUserDropdownList = select.getOptions();
        int rnd = faker.random().nextInt(1, idUserDropdownList.size() - 1);
        select.selectByIndex(rnd);
    }

    //selecthotelroom dropdown elementinden eleman seçer
    public void selecthotelroomDropdownElementSecimi() {

        Select select = new Select(selecthotelroomDropdownWebElement);
        List<WebElement> idUserDropdownList = select.getOptions();
        int rnd = faker.random().nextInt(1, idUserDropdownList.size() - 1);
        select.selectByIndex(rnd);
    }
    //dateStart
    public void dateStart() {
        LocalDate localDate = LocalDate.now();
        LocalDate eklenmisLocalDate = localDate.plusDays(5);
        DateTimeFormatter duzenliDateStart = DateTimeFormatter.ofPattern("MM/dd/yyyy");
        String localDateStr = eklenmisLocalDate.format(duzenliDateStart);
        dateStartWebElement.click();
        dateStartWebElement.clear();
        dateStartWebElement.sendKeys(localDateStr);
    }
    //dateEnd
    public void dateEnd() throws InterruptedException {
        LocalDate localDate = LocalDate.now();
        LocalDate eklenmisLocalDate = localDate.plusDays(15);
        DateTimeFormatter duzenliDateStart = DateTimeFormatter.ofPattern("MM/dd/yyyy");
        String localDateStr = eklenmisLocalDate.format(duzenliDateStart);
        dateStartWebElement.click();
        dateEndWebElement.clear();
        dateEndWebElement.sendKeys(localDateStr);
        roomReservationsBosTik.click();
    }
    JavascriptExecutor js= (JavascriptExecutor) Driver.getDriver();;
    public void createHotelRoomReservation() throws InterruptedException {
        Actions actions = new Actions(Driver.getDriver());
        selectUserDropdownElementSecimi();
        Thread.sleep(1500);
        js.executeScript("javascript:window.scrollBy(250,350)");
        selecthotelroomDropdownElementSecimi();
        priceWebElement.clear();
        priceWebElement.sendKeys("300");
        dateStart();
        //ReusableMethods.waitFor(1);
        dateEnd();

        //ReusableMethods.waitFor(2);
        adultAmountWebElement.click();
        adultAmountWebElement.clear();


        adultAmountWebElement.sendKeys("3"); //calisti
        childrenAmountWebElement.clear();
        childrenAmountWebElement.sendKeys("4");
        contactNameSurnameWebElement.clear();
        contactNameSurnameWebElement.sendKeys("mehmet bulut");
        contactPhoneWebElement.clear();
        contactPhoneWebElement.sendKeys("(312) 111-1111");
        contactEmailWebElement.clear();
        contactEmailWebElement.sendKeys("mehmet@gmail.com");
        notesWebElement.clear();
        notesWebElement.sendKeys("null");
        if(!approvedWebElementCheckBox.isSelected()){
            approvedWebElementCheckBox.click();
        }
        if(isPaidWebElementCheckBox.isSelected()){
            isPaidWebElementCheckBox.click();
        }
        saveButon.click();


     //   actions.click(adultAmountWebElement).sendKeys("2").sendKeys(Keys.TAB).
     //           sendKeys("2").sendKeys(Keys.TAB).
     //           sendKeys(faker.name().lastName()).sendKeys(Keys.TAB).
     //           sendKeys(faker.phoneNumber().cellPhone()).sendKeys(Keys.TAB).
     //           sendKeys(faker.internet().emailAddress()).sendKeys(Keys.TAB).
     //           sendKeys(faker.letterify("lkdflk").toLowerCase()).sendKeys(Keys.TAB).
     //           click(approvedWebElementCheckBox).sendKeys(Keys.TAB).
     //           click(isPaidWebElementCheckBox).sendKeys(Keys.TAB).
     //           click(saveButtonWebElement).perform();
        ReusableMethods.waitFor(5);

    }
}
