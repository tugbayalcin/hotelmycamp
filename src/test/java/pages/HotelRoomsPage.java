package pages;
import com.github.javafaker.Faker;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.Test;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ReusableMethods;
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
    @FindBy (xpath="//span[text()='Hotel Management']")         //  degistirildi
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
    @FindBy(xpath="(//a[@class='btn btn-xs default'])[1]")
    public WebElement dinamikDetailsButonu;
    @FindBy(xpath="//div[@class='caption']")
    public WebElement editHotelRoomYazisi;
    @FindBy(xpath="//select[@title='Select Hotel']")
    public WebElement ddHotelLink;
    @FindBy(xpath="//*[@id='Code']")
    public WebElement ddCodeBox;
    @FindBy(xpath="//*[@id='Name']")
    public WebElement ddNameBox;
    @FindBy (xpath=" //*[@id='Location']")//-->(//input[@class='form-control input-lg required'])[3]
    public WebElement ddLocationBox;
    @FindBy(xpath="(//textarea[@dir='ltr'])[1]")
    public WebElement ddDescriptionArea;
    @FindBy(xpath = "//div[@id='cke_1_contents']")
    public WebElement descriptionArea;
    @FindBy(xpath="//*[@id='Price']")
    public WebElement ddPriceBox;
    @FindBy(xpath="//*[@id='IDGroupRoomType']")
    public WebElement ddRoomTypeBox;
    @FindBy(xpath="//*[@id= 'MaxAdultCount']")
    public WebElement ddMaxAdultcountBox;
    @FindBy (xpath="//*[@id= 'MaxChildCount']")
    public WebElement ddMaxChildrenCountbox;
    @FindBy(xpath="//input[@name='IsAvailable']")
    public WebElement ddIsAvaliableCheckBox;
    @FindBy(xpath="//button[@class='btn green']")
    public WebElement ddSaveButonu;
    @FindBy(xpath="//button[@id='btnSubmit']")      // xpati degistirdim
    public WebElement saveButonu;
    @FindBy (xpath="//div[@class='bootbox-body']")
    public WebElement hotelRoomWasUpdatedSuccessfullyYazisi;
    @FindBy(xpath = "//button[@class='btn btn-primary']")
    public WebElement deleteOkButonu;
    @FindBy (xpath="//button[@id='btnDelete']")
    public WebElement deleteButonu;
    @FindBy(xpath="//div[@class='bootbox-body']")
    public WebElement wouldYouLikeToContinueYazisi;
    @FindBy(xpath = "//div[@class='bootbox-body']")
    public WebElement error;
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
    @FindBy(xpath = "//tbody//tr//td[4]")
    public WebElement bodydekiTumDatalarListElementi;
    @FindBy(xpath = "//a[@class='btn btn-circle btn-default']")     // eklendi
    public WebElement addHotelRoomsButonu;
    @FindBy(xpath = "//div[@class='caption']")                      //  eklendi
    public WebElement createHotelroomYazisiElementi;
    @FindBy(xpath = "//select[@id='IDHotel']")                      //  eklendi
    public WebElement idHotelDropDownButonu;
    @FindBy(xpath = "//span[@class='checked']")                     //  eklendi
    public WebElement approvedCheckBox;
    @FindBy(xpath = "//input[@name='Name']")                        //  EKLENDI
    public WebElement listOfHotelRoomSayfasindakiNameBox;
    @FindBy(xpath = "//div[text()='HotelRoom was inserted successfully']")
    public WebElement hotelRoomBasariylaEklendiYazisi;


    @FindBy(xpath = "//a[@href='/Rooms/8']")
    public WebElement tripleOdaSeçeneğiButonu;

    @FindBy(xpath = "//span[text()='$225.00']")
    public WebElement doubleRoom225DolarYazısı;

    @FindBy(xpath ="//a[@href='/account/logon?returnUrl=%2FRoomDetail%2F2']")
    public WebElement logInButonuDoubleRoom;

    @FindBy(xpath = "//select[@id='AdultCount']")
    public WebElement selectAdultCountButonu;

    @FindBy(xpath = "//select[@id='IDRoomType']")
    public WebElement selectRoomTypeButonu;

    @FindBy(xpath = "//input[@type='submit']")
    public  WebElement advancedSearchButonu;

    @FindBy(xpath = "//a[text()='Book Now ']")
    public WebElement bookNowButonuDoubleOda;



    public void managerLoginHotelRoomPages() {
        ReusableMethods reusableMethods=new ReusableMethods();
        HotelRoomsPage hotelRoomsPage=new HotelRoomsPage();
        Driver.getDriver().get(ConfigReader.getProperty("HMCURL"));
        hotelRoomsPage.loginLinki.click();
        ReusableMethods.waitFor(2);
        hotelRoomsPage.usernameBox.sendKeys(ConfigReader.getProperty("ManagerUsername"));
        hotelRoomsPage.passwordBox.sendKeys(ConfigReader.getProperty("ManagerPassword"));
        hotelRoomsPage.loginButonu.click();
        Assert.assertTrue(hotelRoomsPage.listOfUsersYazisi.isDisplayed());
        ReusableMethods.waitFor(2);
        System.out.println("basarili sekilde giris yapildi");
    }

    public WebElement detailsRnd() {
        Faker faker=new Faker();
        int rnd=faker.random().nextInt(1,11);
        String dinamikDetailsButonu="(//a[@class='btn btn-xs default'])["+rnd+"]";
        WebElement dinamikDetailsButonuElement= Driver.getDriver().findElement(By.xpath(dinamikDetailsButonu));
        return dinamikDetailsButonuElement;

    }



}
