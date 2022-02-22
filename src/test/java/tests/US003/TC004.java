package tests.US003;

import org.openqa.selenium.JavascriptExecutor;
import org.testng.Assert;
import org.testng.annotations.Test;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ReusableMethods;
import utilities.TestBaseRapor;

import static utilities.ObjectInitialiser.*;

public class TC004 extends TestBaseRapor
{
    @Test (priority = 1)
    public void negativeRegistrationTestWithInvalidEmail()
    {
        extentTest=extentReports.createTest("Negative Registration Test With Invalid Email","Gecersiz Bir Email Adresi Ile Kayıt Yapılmamalıdır");
        registirationPage.emailTests(14,16,"testDataInvalidEmail");
        extentTest.pass("Test Başarılı");
    }
    // pass

    @Test (priority = 2)
    public void negativeRegistrationTestWithNoneExistentEmail()
    {
        extentTest=extentReports.createTest("Negative Registration Test With None Existent Email","Var Olmayan Bir Email Adresi Ile Kayıt Yapılmamalıdır");
        registirationPage.emailTestsWithPopupWithDate(17,18,"testDataInvalidEmail");

        Assert.assertTrue(registirationPage.registrationPagePopupYazisi.isDisplayed());

        String unexpectedPopupYazisi = ConfigReader.getProperty("validCredentialsTestDataExpectedPopupYazisi");
        String actualPopupYazisi = registirationPage.registrationPagePopupYazisi.getAttribute("innerText");
        boolean kosul = unexpectedPopupYazisi.equals(actualPopupYazisi);

        softAssert.assertFalse(kosul,"Kayıt Gerçekleşmedi, Detaylı Popup Yazısı Için Screenshot'a Bakınız.");
       // registirationPage.registrationPagePopupOkButonu.click();
        ReusableMethods.getScreenShots("NoneExistEmailTestSS","target/screenshots/US003/");

        extentTest.pass("Test Failed. Kayıt Gerçekleşmemesi Gerekirken Başarılı Bir Şekilde Gerçekleşiyor Ve Bu Bilgi Popup Ile Gosterildiği Ve Popup Uzerindeki Yazi Doğru Bir Şekilde Alınamadığı Için Doğrulama Yapılamadı.");

        softAssert.assertAll();

    }
    // FAIL
    //  hata yazisi cikmiyor ve kayıt gerceklesiyor,
    // program duzgun calismiyor!!!!!!!!


    @Test (priority = 3)
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
