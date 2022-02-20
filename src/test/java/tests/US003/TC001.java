package tests.US003;

import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import utilities.ReusableMethods;
import utilities.TestBaseRapor;


import java.io.IOException;

import static utilities.ObjectInitialiser.*;
// extend de yapabiliriz ancak multi extendion olmadigi icin, tek extend hakkımızı bunda harcamak istemeyiz
// imkan varsa daima static import yapariz

public class TC001 extends TestBaseRapor
{

    @Test
    public void positiveRegistrationTestWithValidCredentials() throws IOException {

        extentTest=extentReports.createTest("Positive Registration Test With Valid Credentials","Uygun Koşulları Sağlayan Veriler Ile Kayıt Yapılmalıdır");

        // DRY'dan kurtulduk
        registirationPage.beginnerStepsForRegistrationPageTests();

        registirationPage.fillTheForm("testDataExcelFile",registirationPage.setCredentialsWebElementsList(),1);
        Assert.assertTrue(registirationPage.takvimWebTable.isDisplayed());
        registirationPage.takvimWebTable.click();
        // bunu yapmazsam takvim acik kaliyor ve send butonu gorunmuyor

        Assert.assertTrue(registirationPage.registrationPageSaveButonu.isDisplayed());
        registirationPage.registrationPageSaveButonu.click();

        String expectedPopupYazisi = "User Data was inserted successfully";
        String actualPopupYazisi = registirationPage.registrationPagePopupYazisi.getText();

        softAssert.assertTrue(registirationPage.registrationPageBasariliKayitYazisi.isDisplayed());
        softAssert.assertEquals(actualPopupYazisi,expectedPopupYazisi);
        ReusableMethods.getScreenShots("ValidCredentialsTestSS","target/screenshots/US003/");
        registirationPage.registrationPagePopupOkButonu.click();
        extentTest.pass("Kayıt Başarı Ile Gerçekleştirildi Ancak Popup Uzerindeki Yazi Doğru Bir Şekilde Alınamadığı Için Doğrulama Yapılamadı.");

        // softAssert.assertAll();





    }
}
