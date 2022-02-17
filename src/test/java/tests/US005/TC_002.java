package tests.US005;

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
    public void test(){

// 1-Yönetici olarak  https://www.hotelmycamp.com/ Url ile giriş yapılır
    reusableMethods.yöneticiGiris();






//2- Yönetici olarak giriş yapılır.
//3-LIST OF HOTELS yazısı görüntülendi
//4-Oda listesinde sayfalar arasında geçiş yapıldıgı görüntülenir
//5-Arama yapılır , SEARCH butonuna tıklanır
//6-girilen bilgiler dogrultusunda tanımlı olan oda görüntülenir
//7- İndirme , yazdırma , details ve add User butonlarının çalıştığını test edelim.




    }



}
