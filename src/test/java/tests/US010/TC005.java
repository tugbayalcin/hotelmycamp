package tests.US010;

import com.github.javafaker.Faker;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.AnaSayfaPage;
import pages.HotelRoomsPage;
import pages.LoginPage;
import pages.RoomReservationsPage;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ReusableMethods;
import utilities.TestBaseRapor;

public class TC005 extends TestBaseRapor {
    @Test
    public void test05()  {

        AnaSayfaPage anaSayfaPage = new AnaSayfaPage();
        RoomReservationsPage roomReservationsPage = new RoomReservationsPage();
        LoginPage loginPage = new LoginPage();
        HotelRoomsPage hotelRoomsPage=new HotelRoomsPage();

        extentTest=extentReports.createTest("TC005","Kullanıcı olarak başarılı bir şekilde rezervasyon yapabilme");
        //1- https://www.hotelmycamp.com/ URL adresine gidiniz.
        Driver.getDriver().get(ConfigReader.getProperty("HMCURL"));
        //2- '"Rooms" menüsünü locate ediniz ve "Rooms" butonuna tıklayınız.
        anaSayfaPage.anasayfaRoomsButon.click();
        //3- Açılan sayfada "Advanced Search" menüsününde bulunan "Search" butonunu locate ediniz ve tıklayınız.
        hotelRoomsPage.advancedSearchButonu.click();
        extentTest.info("Search butonu tıklandı");
        //4-Gelen sonuç sayfasında fiyatı "$225.00" olan odanın "Book Now" butonunu locate ediniz ve tıklayınız.
        hotelRoomsPage.bookNowButonuDoubleOda.click();
        extentTest.info("Double room seçeneği tıklandı");
        //5-Açılan sayfada "Log in" butonunu tıklayınız açılan sayfada "username:iyilmaz27", "password:Deneme78."
        //girerek log in olunuz.
        hotelRoomsPage.logInButonuDoubleRoom.click();
        extentTest.info("Oda rezervasyonu için log in linki tıklandı");
        loginPage.LoginUsernameBox.sendKeys(ConfigReader.getProperty("HMCValidUsername"));
        loginPage.LoginPasswordBox.sendKeys(ConfigReader.getProperty("HMCValidPassword"));
        loginPage.GirisLoginButon.click();
        extentTest.info("Giriş yapıldı");
        //6-Açılan rezervasyon sayfasındaki kutucuklarını faker kullanarak doldurunuz ve "Book this room" butonunu tıklayınız.
        Select select=new Select(roomReservationsPage.selectAdultCountButonu);
        select.selectByVisibleText("2 Adult");
        select=new Select(roomReservationsPage.selectChildrenCountButonu);
        select.selectByVisibleText("1 Children");
        select=new Select(roomReservationsPage.krediKartExprationYear);
        select.selectByVisibleText("2024");
        select=new Select(roomReservationsPage.krediKartExprationMonth);
        select.selectByVisibleText("January");
        Actions actions=new Actions(Driver.getDriver());
        Faker faker=new Faker();
        String email=faker.internet().emailAddress();
        actions.click(roomReservationsPage.isimSoyisimKutusuRezevasyonSayfası)
                .sendKeys(faker.name().fullName())
                .sendKeys(Keys.TAB)
                .sendKeys(faker.internet().emailAddress())
                .sendKeys(Keys.TAB)
                .sendKeys(Keys.TAB)
                .sendKeys(faker.name().fullName())
                .sendKeys(Keys.TAB)
                .sendKeys(faker.business().creditCardNumber())
                .sendKeys(Keys.TAB)
                .sendKeys(Keys.TAB)
                .sendKeys(Keys.TAB)
                .sendKeys(faker.business().creditCardNumber())
                .sendKeys(Keys.TAB)
                .sendKeys(faker.address().fullAddress()).perform();
        roomReservationsPage.bookThisRoomButonu.click();
        extentTest.info("Book this room butonu tıklandı");

        //7-Açılan sayfada "Reservation was made successfully" yazısnın çıktığını test ediniz.
        Assert.assertTrue(roomReservationsPage.succesfullyYazısı.isDisplayed());
        extentTest.pass("Rezervasyon işlemi başarılı bir şekilde yapıldı");
        Driver.closeDriver();



    }
}

