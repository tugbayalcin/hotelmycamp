package tests.US005;

import com.github.javafaker.Faker;
import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import pages.AnaSayfaPage;
import pages.HotelListPage;
import pages.LoginPage;
import utilities.Driver;
import utilities.ReusableMethods;
import utilities.TestBaseRapor;

import java.io.IOException;

public class TC_003  extends TestBaseRapor {

    AnaSayfaPage anaSayfaPage=new AnaSayfaPage();
    LoginPage loginPage=new LoginPage();
    HotelListPage hotelListPage=new HotelListPage();
    ReusableMethods reusableMethods=new ReusableMethods();
    SoftAssert softAssert=new SoftAssert();

    @Test
    public void test() throws InterruptedException, IOException {
        extentTest=extentReports.createTest("US-005-TC003","Otel bilgilerını güncelleme Testi");

        // 1-Yönetici olarak  https://www.hotelmycamp.com/ Url ile giriş yapılır
        reusableMethods.yöneticiGiris();
        extentTest.info("yönetici olarak giriş yapıldı");


        //2-LIST OF USERS yazısı görüntülendi
        softAssert.assertTrue(hotelListPage.listofUserYazısı.isDisplayed());

        //3- Hotel Management buttonuna tıklanır
        hotelListPage.hotelManagementButonu.click();

        //4- Hotel List butonuna tıklanır
        hotelListPage.hotelListButonu.click();

        //5-LIST OF HOTELS yazısı görüntülendi
        softAssert.assertTrue(hotelListPage.listOfHotelsYazısı.isDisplayed());
        String listOfHotelWindowHandle=Driver.getDriver().getWindowHandle();
        extentTest.info("List of Hotels sayfasına ulaşıldı");


        //6-Biliglerini güncellemek istediğimiz otele ait DETAILS butonuna tıklanır.
            hotelListPage.listOfHotelsDetailsButonu.click();

        //7-Değişiklik yapılacak olan sayfada "Edit Hotel" yazısı görüntülenir
        reusableMethods.switchToWindow("Admin - Edit Hotel");
        softAssert.assertEquals(hotelListPage.EditHotelYazısı.getText(),"Edit Hotel");
        extentTest.info("Edit Hotel  sayfasına ulaşıldı");


        //8-Tüm değişiklikler ilgili alanlarda yapıldıktan sonra SAVE butonuna tıklanır
        Faker faker=new Faker();
        Actions actions=new Actions(Driver.getDriver());
        String code=faker.number().digits(6);
        String name=faker.name().fullName();
        String address=faker.address().fullAddress();
        String phone=faker.phoneNumber().phoneNumber();
        String email=faker.internet().emailAddress();

        actions.doubleClick(hotelListPage.EditHotelCodeBox)
                .sendKeys(code)
                .sendKeys(Keys.TAB)
                .sendKeys(name)
                .sendKeys(Keys.TAB)
                .sendKeys(address)
                .sendKeys(Keys.TAB)
                .sendKeys(phone)
                .sendKeys(Keys.TAB)
                .sendKeys(Keys.PAGE_DOWN)
                .sendKeys(email)
                .sendKeys(Keys.TAB)
                .sendKeys(Keys.TAB)
                .perform();

        Thread.sleep(2000);
        hotelListPage.EditHotelSaveButonu.click();
        extentTest.info("İstene Güncellemeler yapıldı");


        //9-Güncellemeler yapıldıktan sonra ""Hotel was updated successfully"" yazısı görüntülenir"
        Thread.sleep(3000);
       // reusableMethods.getScreenShots("guncelleme","target/screenShot/US005");
        softAssert.assertTrue(hotelListPage.EditHotelGüncellemeSavePopUp.isDisplayed());
        Thread.sleep(3000);
        hotelListPage.EditHotelPopUpOkButonu.click();

        //10-İlk safyaya donulup guncelleme yapılan otelın lıstede olup olmadıgını kontrol et
        Driver.getDriver().switchTo().window(listOfHotelWindowHandle);
        Thread.sleep(3000);
        hotelListPage.listOfHotelsSearchCodeBox.sendKeys(code);
        hotelListPage.listOfHotelsSearchButonu.click();
        softAssert.assertTrue(hotelListPage.ListOfHotelSayfasındaGuncellenenHotelınKontrolu.isDisplayed());
        softAssert.assertAll();
        extentTest.pass("Otel bilgileri güncellendıgı dogrulandı");



    }
}
