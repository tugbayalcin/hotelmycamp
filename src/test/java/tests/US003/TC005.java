package tests.US003;

import org.testng.Assert;
import org.testng.annotations.Test;
import utilities.ConfigReader;
import utilities.TestBaseRapor;

import java.io.IOException;

import static utilities.ObjectInitialiser.*;

public class TC005 extends TestBaseRapor
{
    @Test
    public void negativeRegistrationTestWithMissingCredentialsEntry()
    {
        extentTest=extentReports.createTest("Negative Registration Test With Missing Credentials Entry","Eksik Bilgi Girişi Ile Kayıt Yapılmamalıdır");
        // degisiklik yapılacak
        registirationPage.missingCredentialsTests(registirationPage.setCredentialsWebElementsList(),
                registirationPage.setCredentialsWebElementsErrorLineList(),
                registirationPage.setMissingCredentialErrorList(),20,32);

        extentTest.pass("Test Başarılı");
    }
    // pass
    // country'yi bos irakmak demek, oraya hic dokunmamak demek
    // ve country bir dropdown oldugu icin, o hucre tamamen bos olamiyor,
    // default degeri select country kalmasi gerekiyor, test datasi buna gore olusturuldu

    // ulke united state oldugu zaman state secmek zorunlu
    // olmadıgı zaman zorunly degil

    @Test
    public void countryStateRelationshipTest() {
        extentTest=extentReports.createTest("Country State Relationship Test","Ulke United States Olarak Secildiginde State Secilmeli Aksi Takdirde Kayıt Yapılmamalı, Ulke united States Dışında Bir Ulke Olarak Seçildiginde State Doldurulmak Zorunda Olmamalı Ve Kayıt Başarıyla Gerçekleşmeli");

        registirationPage.missingCountryStateRelationshipTest();
        // ss method icerisinde aliniyor
        Assert.assertTrue(registirationPage.registrationPagePopupYazisi.isDisplayed());
        String expectedPopupYazisi = ConfigReader.getProperty("validCredentialsTestDataExpectedPopupYazisi");
        //String actualPopupYazisi = registirationPage.registrationPagePopupYazisi.getText();
        String actualPopupYazisi = registirationPage.registrationPagePopupYazisi.getAttribute("innerText");
        Assert.assertEquals(actualPopupYazisi,expectedPopupYazisi);
        registirationPage.registrationPagePopupOkButonu.click();
        extentTest.pass("Ulke United States Ise State Bilgisi Doldurulmalıdır Hata Yazısı Gorundu, Değilse Kayıt Başarı Ile Gerçekleştirildi.");

        // pass

    }

}
