package tests.US003;

import org.testng.Assert;
import org.testng.annotations.Test;
import utilities.ConfigReader;
import utilities.ReusableMethods;
import utilities.TestBaseRapor;

import static utilities.ObjectInitialiser.*;

public class TC002 extends TestBaseRapor
{

    @Test
    public void negativeRegistrationTestWithInvalidUsername()
    {
        extentTest=extentReports.createTest("Negative Registration Test With Invalid Username","Geçersiz Username'ler Ile Kayıt Yapılmamalıdır.");

        registirationPage.usernameTests(3,6,"testDataInvalidUsername"); // bitis dahil degil
        extentTest.pass("Test Başarılı");
    }
    // pass

    @Test
    public void negativeRegistrationTestWithAlreadyExistUsername()
    {
        extentTest=extentReports.createTest("Negative Registration Test With Already Exist Username","Daha Onceden Kullanılmış Bir Username Ile Yeniden Kayıt Yapılmamalıdır");
        registirationPage.usernameAlreadyExistTests(6,7,"testDataAlreadyExistUsername");

        ReusableMethods.waitFor(1);
        Assert.assertTrue(registirationPage.registrationPagePopupYazisi.isDisplayed());
        String expectedInfoText = ConfigReader.getProperty("alreadyExistUsernameExpectedInfoText");
        String actualInfoText = registirationPage.registrationPagePopupYazisi.getAttribute("innerText");

        Assert.assertEquals(actualInfoText,expectedInfoText);
        registirationPage.registrationPagePopupOkButonu.click();

        extentTest.pass("Kayıt Gerçekleştirilmedi. Yani Test Başarılı Oldu.");

        // pass
    }

}
