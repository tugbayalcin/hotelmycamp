package tests.smokeTest;

import org.testng.annotations.Test;
import pages.LoginPage;
import tests.US001.TC001;

public class KullaniciLoginTest {

    @Test
    public void KullaniciLoginTest(){

        LoginPage loginPage=new LoginPage();
        loginPage.kullaniciLoginTest();

    }

}
