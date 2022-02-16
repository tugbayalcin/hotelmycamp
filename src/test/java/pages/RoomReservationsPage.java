package pages;

import com.github.javafaker.Faker;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
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

    @FindBy (xpath = "//input[@id='product_barcodeCode_170']")
    public WebElement codeBox;

    @FindBy(xpath = "//textarea[@id='product_barcode_170']")
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
    @FindBy(id="AdultAmount")
    public WebElement adultAmountWebElement;

    //ChildrenAmount webelement
    @FindBy(id="ChildrenAmount")
    public WebElement childrenAmountWebElement;

    //ContactNameSurname webelement
    @FindBy (id="ContactNameSurname")
    public WebElement contactNameSurnameWebElement;

    //ContactPhone webelement
    @FindBy (id="ContactPhone")
    public WebElement contactPhoneWebElement;

    //ContactEmail webelement
    @FindBy (id = "ContactEmail")
    public WebElement contactEmailWebElement;

    //Notes webelement
    @FindBy (id = "Notes")
    public WebElement notesWebElement;

    //Approved webelement
    @FindBy (id="Approved")
    public WebElement approvedWebElement;

    //IsPaid webelement
    @FindBy (id = "IsPaid")
    public WebElement isPaidWebElement;

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
        dateStartWebElement.sendKeys(localDateStr);
    }
    //dateEnd
    public void dateEnd() {
        LocalDate localDate = LocalDate.now();
        LocalDate eklenmisLocalDate = localDate.plusDays(15);
        DateTimeFormatter duzenliDateStart = DateTimeFormatter.ofPattern("MM/dd/yyyy");
        String localDateStr = eklenmisLocalDate.format(duzenliDateStart);
        dateStartWebElement.click();
        dateEndWebElement.sendKeys(localDateStr);
    }
    public void createHotelRoomReservation() {
        Actions actions = new Actions(Driver.getDriver());
        selectUserDropdownElementSecimi();
        selecthotelroomDropdownElementSecimi();
        priceWebElement.sendKeys("300");
        dateStart();
        //ReusableMethods.waitFor(1);
        dateEnd();
        //ReusableMethods.waitFor(2);
        actions.click(adultAmountWebElement).sendKeys("2").sendKeys(Keys.TAB).
                sendKeys("2").sendKeys(Keys.TAB).
                sendKeys(faker.name().lastName()).sendKeys(Keys.TAB).
                sendKeys(faker.phoneNumber().cellPhone()).sendKeys(Keys.TAB).
                sendKeys(faker.internet().emailAddress()).sendKeys(Keys.TAB).
                sendKeys(faker.letterify("lkdflk").toLowerCase()).sendKeys(Keys.TAB).
                click(approvedWebElement).sendKeys(Keys.TAB).
                click(isPaidWebElement).sendKeys(Keys.TAB).
                click(saveButtonWebElement).perform();
        ReusableMethods.waitFor(5);

    }
}
