package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import utilities.ConfigReader;
import utilities.Driver;

public class HotelRoomsPage {

    public HotelRoomsPage(){
        PageFactory.initElements(Driver.getDriver(),this);
    }

    @FindBy(xpath="//li[@id='navLogon']")
    public WebElement loginLinki;

    @FindBy(id="UserName")
    public WebElement usernameBox;

    @FindBy(id="Password")
    public WebElement passwordBox;

    @FindBy(id="btnSubmit")
    public WebElement loginButonu;

    @FindBy (xpath="//span[@class='caption-subject font-green-sharp bold uppercase']")
    public WebElement listOfUsersYazisi;

    @FindBy (xpath="(//span[@class=\"title\"])[3]")
    public WebElement hotelManagementLinki;

    @FindBy (xpath="(//i[@class='icon-calendar'])[3]")
    public WebElement hotelRoomsLinki;

    @FindBy(xpath="//span[@class='caption-subject font-green-sharp bold uppercase']")
    public WebElement listOfHotelRoomsYazisi;

    @FindBy(xpath = "(//i[@class='fa fa-angle-right'])[3]")
    public WebElement odaListesiSayfaDegistirmeButonu;

    @FindBy(xpath="//div[@id='datatable_ajax_info']")
    public WebElement FoundTotal20Records;

    @FindBy(xpath="//input[@name='IDHotelRoom']")
    public WebElement odaIdBox;

    @FindBy(xpath="//button[@class='btn btn-sm yellow filter-submit margin-bottom']")
    public WebElement searchButonu;

    @FindBy(xpath="//div[@id='datatable_ajax_info']")
    public WebElement foundTotal1RecordsYazisi;

    @FindBy(xpath="//a[@class='btn btn-xs default']")
    public WebElement detailsButonu;

    @FindBy(xpath="//div[@class='caption']")
    public WebElement editHotelRoomYazisi;

    @FindBy(xpath="//select[@title='Select Hotel']")
    public WebElement degisiklikteOtelSecimBox;

    @FindBy(xpath="//*[@id='Code']")
    public WebElement codeBox;

    @FindBy(xpath="//*[@id='Name']")
    public WebElement nameBox;

    @FindBy (xpath=" //*[@id='Location']")//-->(//input[@class='form-control input-lg required'])[3]
    public WebElement locationBox;

    @FindBy(id="cke_1_contents")
    public WebElement descriptionArea;

    @FindBy(xpath="//*[@id='Price']")
    public WebElement priceBox;

    @FindBy(xpath="//*[@id='IDGroupRoomType']")
    public WebElement roomTypeBox;

    @FindBy(xpath="//*[@id= 'MaxAdultCount']")
    public WebElement maxAdultcountBox;

    @FindBy (xpath="//*[@id= 'MaxChildCount']")
    public WebElement maxChildrenCountbox;

    @FindBy(xpath="//input[@name='IsAvailable']")
    public WebElement isAvaliableCheckBox;

    @FindBy(xpath="//button[@class='btn green']")
    public WebElement saveButonu;

    @FindBy (xpath="//div[@class='bootbox-body']")
    public WebElement hotelRoomWasUpdatedSuccessfullyYazisi;

    @FindBy(xpath = "//button[@class='btn btn-primary']")
    public WebElement okButonu;

    @FindBy (xpath="//button[@type='submit']")
    public WebElement deleteButonu;

    @FindBy(xpath="//div[@class='bootbox-body']")
    public WebElement wouldYouLikeToContinueYazisi;

    @FindBy(xpath = "//div[@class='bootbox-body']")
    public WebElement couldntDeleteRoomYazisi;

    @FindBy(xpath="//div[@class='bootbox-body']")
    public WebElement hotelRoomSuccessfullyDeletedYazisi;

    @FindBy(xpath = "//button[@data-bb-handler='ok']")
    public WebElement alertOKButonu;

    @FindBy(xpath = "(//select[@class='form-control input-xsmall input-sm input-inline'])[1]")
    public WebElement hotelRoomGosterimSayisiDropDown;

    @FindBy(xpath = "//select[@id='lkpHotels']")
    public WebElement listOfHotelRoomSayfasindakiIDHotelDropDownu;

    @FindBy(xpath = "//button[@class='btn btn-sm yellow filter-submit margin-bottom']")
    public WebElement listOfHotelRoomsdakiSearchButonu;

    @FindBy(xpath = "//tbody//tr//td[2]")
    public WebElement bodydekiTumDatalarListElementi;




    public void managerLoginHotelRoomPages() throws InterruptedException {
        HotelRoomsPage hotelRoomsPage=new HotelRoomsPage();
        Driver.getDriver().get(ConfigReader.getProperty("HMCURL"));
        hotelRoomsPage.loginLinki.click();
        Thread.sleep(2000);
        hotelRoomsPage.usernameBox.sendKeys(ConfigReader.getProperty("ManagerUsername"));
        hotelRoomsPage.passwordBox.sendKeys(ConfigReader.getProperty("ManagerPassword"));
        hotelRoomsPage.loginButonu.click();
        Assert.assertTrue(hotelRoomsPage.listOfUsersYazisi.isDisplayed());
        System.out.println("basarili sekilde giris yapildi");
    }

}
