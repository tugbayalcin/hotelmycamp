package tests.US003;

import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import utilities.ConfigReader;
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

        ReusableMethods.waitFor(1);
        Assert.assertTrue(registirationPage.registrationPagePopupYazisi.isDisplayed());

        String expectedPopupYazisi = ConfigReader.getProperty("validCredentialsTestDataExpectedPopupYazisi");
        //String actualPopupYazisi = registirationPage.registrationPagePopupYazisi.getText();
        String actualPopupYazisi = registirationPage.registrationPagePopupYazisi.getAttribute("innerText");
        // bu kodu kullanabilirler bununla textti aliniyor

        Assert.assertEquals(actualPopupYazisi,expectedPopupYazisi);

        registirationPage.registrationPagePopupOkButonu.click();
        ReusableMethods.waitFor(1);

        ReusableMethods.hooverByJS(registirationPage.registerPageHeader);
        Assert.assertTrue(registirationPage.registrationPageBasariliKayitYazisi.isDisplayed());
        String expectedBasariliKayitYazisi= ConfigReader.getProperty("validCredentialsTestDataExpectedexpectedBasariliKayitYazisi");
        String actualBasariliKayitYazisi= registirationPage.registrationPageBasariliKayitYazisi.getAttribute("innerText");
        Assert.assertEquals(actualBasariliKayitYazisi,expectedBasariliKayitYazisi);

        extentTest.pass("Kayıt Başarı Ile Gerçekleştirildi");



        // pass




    }
}
