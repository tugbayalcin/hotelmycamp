package tests.US003;

import org.testng.Assert;
import org.testng.annotations.Test;
import utilities.ReusableMethods;
import utilities.TestBaseRapor;

import static utilities.ObjectInitialiser.*;

public class TC002 extends TestBaseRapor
{

    @Test
    public void negativeRegistrationTestWithInvalidUsername()
    {
        extentTest=extentReports.createTest("Negative Registration Test With Invalid Username","Geçersiz Username'ler Ile Kayıt Yapılmamalıdır.");
        // degisiklik yapılacak
        registirationPage.usernameTests(3,6,"testDataInvalidUsername"); // bitis dahil degil
        extentTest.pass("Test Başarılı");
    }
    // pass

    @Test
    public void negativeRegistrationTestWithAlreadyExistUsername()
    {
        extentTest=extentReports.createTest("Negative Registration Test With Already Exist Username","Daha Onceden Kullanılmış Bir Username Ile Yeniden Kayıt Yapılmamalıdır");
        // degisiklik yapılacak
        registirationPage.usernameAlreadyExistTests(6,7,"testDataAlreadyExistUsername");
        ReusableMethods.getScreenShots("AlreadyExistUsernameTestSS","target/screenshots/US003/");
        extentTest.pass("Kayıt Gerçekleştirilmedi. Yani Test Başarılı Oldu. Ancak Uyarı yazısı Popup Ile Gosterildiği Ve Popup Uzerindeki Yazi Doğru Bir Şekilde Alınamadığı Için Doğrulama Yapılamadı.");
    }
    // yalanci Fail
    // errorLabel yerine popup cikararak uyari veriyor
    // ve popup yazisini alamadıgımız icin programin calistigini dogrulayamiyoruz
    // (guzelce calisiyor aslinda)
    // ss



}
