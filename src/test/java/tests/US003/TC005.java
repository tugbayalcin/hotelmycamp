package tests.US003;

import org.testng.annotations.Test;
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
    // country'yi bos irakmak demek, oraya hic dokunmamak demek
    // ve country bir dropdown oldugu icin, o hucre tamamen bos olamiyor,
    // default degeri select country kalmasi gerekiyor, test datasi buna gore olusturuldu

    // ulke united state oldugu zaman state secmek zorunlu
    // olmadıgı zaman zorunly degil

    @Test
    public void countryStateRelationshipTest() {
        extentTest=extentReports.createTest("Country State Relationship Test","Ulke United States Olarak Secildiginde State Secilmeli Aksi Takdirde Kayıt Yapılmamalı, Ulke united States Dışında Bir Ulke Olarak Seçildiginde State Doldurulmak Zorunda Olmamalı Ve Kayıt Başarıyla Gerçekleşmeli");
        // degisiklik yapılacak
        registirationPage.missingCountryStateRelationshipTest();
        // ss method icerisinde aliniyor
        extentTest.pass("Kayıt Başarı Ile Gerçekleştirildi Ancak Popup Uzerindeki Yazi Doğru Bir Şekilde Alınamadığı Için Doğrulama Yapılamadı.");

    }

}
