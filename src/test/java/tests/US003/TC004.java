package tests.US003;

import org.testng.annotations.Test;
import utilities.ReusableMethods;
import utilities.TestBaseRapor;

import static utilities.ObjectInitialiser.*;

public class TC004 extends TestBaseRapor
{
    @Test
    public void negativeRegistrationTestWithInvalidEmail()
    {
        extentTest=extentReports.createTest("Negative Registration Test With Invalid Email","Gecersiz Bir Email Adresi Ile Kayıt Yapılmamalıdır");
        // degisiklik yapılacak
        registirationPage.emailTests(14,16,"testDataInvalidEmail");
        extentTest.pass("Test Başarılı");
    }
    // burasi pass oldu ve olmasi gerekiyordu

    @Test
    public void negativeRegistrationTestWithNoneExistentEmail()
    {
        extentTest=extentReports.createTest("Negative Registration Test With None Existent Email","Var Olmayan Bir Email Adresi Ile Kayıt Yapılmamalıdır");
        // degisiklik yapılacak
        registirationPage.emailTestsWithPopup(17,18,"testDataInvalidEmail");
        ReusableMethods.getScreenShots("NoneExistEmailTestSS","target/screenshots/US003/");
        extentTest.pass("Test Failed. Kayıt Gerçekleşmemesi Gerekirken Başarılı Bir Şekilde Gerçekleşiyor Ve Bu Bilgi Popup Ile Gosterildiği Ve Popup Uzerindeki Yazi Doğru Bir Şekilde Alınamadığı Için Doğrulama Yapılamadı.");

    }
    // gercek FAIL oluyor, cunku hata yazisi cikmiyor ve kayıt gerceklesiyor,
    // program duzgun calismiyor!!!!!!!!
    // bunu gosteren popup yazisini alamıyorum
    // popup cikan her yerde ss alma methodu kullanilsin

    @Test
    public void negativeRegistrationTestWithAlreadyExistEmail()
    {
        extentTest=extentReports.createTest("Negative Registration Test With Already Exist Email","Zaten kullanilmiş Bir Email Ile Yeniden Kayıt Oluşturulmamalıdır");
        // degisiklik yapılacak
        registirationPage.emailTestsWithPopup(18,19,"testDataAlreadyExistEmail");
        ReusableMethods.getScreenShots("AlreadyExistEmailTestSS","target/screenshots/US003/");
        extentTest.pass("Kayıt Gerçekleştirilmedi. Yani Test Başarılı Oldu. Ancak Uyarı yazısı Popup Ile Gosterildiği Ve Popup Uzerindeki Yazi Doğru Bir Şekilde Alınamadığı Için Doğrulama Yapılamadı.");

    }
    // yalanci FAIL
    // kayıt gerceklesmiyor, yani program calisiyor ancak uyari yazisi popup ile cıktıgı icin dogrulayamıyorum
}
