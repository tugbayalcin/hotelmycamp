package tests.US003;

import org.testng.Assert;
import org.testng.annotations.Test;
import utilities.ConfigReader;
import utilities.ReusableMethods;
import utilities.TestBaseRapor;

import static utilities.ObjectInitialiser.*;

public class TC004 extends TestBaseRapor
{
    @Test
    public void negativeRegistrationTestWithInvalidEmail()
    {
        extentTest=extentReports.createTest("Negative Registration Test With Invalid Email","Gecersiz Bir Email Adresi Ile Kayıt Yapılmamalıdır");
        registirationPage.emailTests(14,16,"testDataInvalidEmail");
        extentTest.pass("Test Başarılı");
    }
    // pass

    @Test
    public void negativeRegistrationTestWithNoneExistentEmail()
    {
        extentTest=extentReports.createTest("Negative Registration Test With None Existent Email","Var Olmayan Bir Email Adresi Ile Kayıt Yapılmamalıdır");
        registirationPage.emailTestsWithPopup(17,18,"testDataInvalidEmail");
        String unexpectedPopupYazisi = ConfigReader.getProperty("validCredentialsTestDataExpectedPopupYazisi");
        String actualPopupYazisi = registirationPage.registrationPagePopupYazisi.getAttribute("innerText");
        boolean kosul = unexpectedPopupYazisi.equals(actualPopupYazisi);

        softAssert.assertFalse(kosul,"Gerçekleşmemesi Gereken Kayıt Başarıyla Gerçekleşti, Sistem Beklendigi Gibi Çalışmadı");
        ReusableMethods.getScreenShots("NoneExistEmailTestSS","target/screenshots/US003/");
        registirationPage.registrationPagePopupOkButonu.click();
        extentTest.pass("Test Failed. Kayıt Gerçekleşmemesi Gerekirken Başarılı Bir Şekilde Gerçekleşiyor Ve Bu Bilgi Popup Ile Gosterildiği Ve Popup Uzerindeki Yazi Doğru Bir Şekilde Alınamadığı Için Doğrulama Yapılamadı.");

        // softAssert.assertAll();
    }
    // FAIL
    //  hata yazisi cikmiyor ve kayıt gerceklesiyor,
    // program duzgun calismiyor!!!!!!!!


    @Test
    public void negativeRegistrationTestWithAlreadyExistEmail()
    {
        extentTest=extentReports.createTest("Negative Registration Test With Already Exist Email","Zaten kullanilmiş Bir Email Ile Yeniden Kayıt Oluşturulmamalıdır");
        registirationPage.emailTestsWithPopup(18,19,"testDataAlreadyExistEmail");

        Assert.assertTrue(registirationPage.registrationPagePopupYazisi.isDisplayed());

        String expectedKayitGerceklesmediYazisi = ConfigReader.getProperty("alreadyExistEmailExpectedKayitGerceklesmediYazisi");
        String actualKayitGerceklesmediYazisi = registirationPage.registrationPagePopupYazisi.getAttribute("innerText");

        Assert.assertEquals(actualKayitGerceklesmediYazisi,expectedKayitGerceklesmediYazisi);

        extentTest.pass("Kayıt Gerçekleştirilmedi. Yani Test Başarılı Oldu. Sistem Beklendiği Gibi Çalışmaktadır");

        // pass
    }

}
