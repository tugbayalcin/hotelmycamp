package tests.US005;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.AnaSayfaPage;
import pages.HotelListPage;
import pages.LoginPage;
import utilities.ReusableMethods;

public class TC_002 {
    AnaSayfaPage anaSayfaPage=new AnaSayfaPage();
    LoginPage loginPage=new LoginPage();
    HotelListPage hotelListPage=new HotelListPage();
    ReusableMethods reusableMethods=new ReusableMethods();


    @Test
    public void test() throws InterruptedException {

// 1-Yönetici olarak  https://www.hotelmycamp.com/ Url ile giriş yapılır
    reusableMethods.yöneticiGiris();

//2-LIST OF USERS yazısı görüntülendi
        Assert.assertTrue(hotelListPage.listofUserYazısı.isDisplayed());
//3- Hotel Management buttonuna tıklanır
        hotelListPage.hotelManagementButonu.click();
//4- Hotel List butonuna tıklanır
        hotelListPage.hotelListButonu.click();
//5-LIST OF HOTELS yazısı görüntülendi
    Assert.assertTrue(hotelListPage.listOfHotelsYazısı.isDisplayed());

//4-Oda listesinde sayfalar arasında geçiş yapıldıgı görüntülenir
        Thread.sleep(2000);
        hotelListPage.listOfHotelsİleriButonu.click();

      //  String sayfasayısı=hotelListPage.listOfHotelSayfaSayısınıGösterenYazı.toString();
      //    String expectedSayfaSayısı="2";
      //     Assert.assertEquals(sayfasayısı,expectedSayfaSayısı);


//5-Arama yapılır , SEARCH butonuna tıklanır
        hotelListPage.listOfHotelsSearchIDHotelBox.sendKeys("1188");
        Thread.sleep(2000);
        hotelListPage.listOfHotelsSearchButonu.click();

//6-girilen bilgiler dogrultusunda tanımlı olan oda görüntülenir
        Thread.sleep(2000);

   //     Assert.assertEquals(hotelListPage.listOfHotelsSearchIDHotelBox.getText(),hotelListPage.listOfHotel1188noluHotelID.getText());

//7- İndirme , yazdırma , details butonlarının çalıştığını test edelim.

    //indirme ıslemının yapılıp yapıladıgını nasıl kontroledecegım  hotelListPage.listOfHotelsDowloandButonu.click();

          hotelListPage.listOfHotelsDetailsButonu.click();
        Assert.assertTrue(hotelListPage.EditHotelYazısı.isDisplayed());

    }



}
