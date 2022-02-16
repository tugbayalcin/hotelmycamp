package tests.US003;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.AnaSayfaPage;
import pages.LoginPage;
import pages.RegistirationPage;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ReusableMethods;

public class TC001
{
    @Test
    public void positiveRegistrationtestWithValidCredentials()
    {
        AnaSayfaPage anaSayfaPage = new AnaSayfaPage();
        LoginPage loginPage = new LoginPage();
        RegistirationPage registirationPage = new RegistirationPage();
        ReusableMethods reusableMethods = new ReusableMethods();

        Driver.getDriver().get(ConfigReader.getProperty("HMCURL"));

        Assert.assertTrue(anaSayfaPage.mainLoginLinki.isDisplayed());
        anaSayfaPage.mainLoginLinki.click();

        Assert.assertTrue(loginPage.CreateNewAccountButonu.isDisplayed());
        loginPage.CreateNewAccountButonu.click();

        Assert.assertTrue(registirationPage.registrationFormGirisYazisiElementi.isDisplayed());

        // registirationPage.fillTextBox(registirationPage.registrationPageUsernameTextBox);

        registirationPage.fillTheForm(registirationPage.setCredentialsWebElementsList(),1,1);

        Assert.assertTrue(registirationPage.takvimWebTable.isDisplayed());
        registirationPage.takvimWebTable.click();
        // bunu yapmazsam takvim acik kaliyor ve send butonu gorunmuyor

        Assert.assertTrue(registirationPage.registrationPageSaveButonu.isDisplayed());
        registirationPage.registrationPageSaveButonu.click();

        String expectedPopupYazisi = "User Data was inserted successfully";
        String actualPopupYazisi = registirationPage.registrationPagePopupYazisi.getText();
        Assert.assertEquals(actualPopupYazisi,expectedPopupYazisi);
        registirationPage.registrationPagePopupOkButonu.click();

        Assert.assertTrue(registirationPage.registrationPageBasariliKayitYazisi.isDisplayed());



    }
}
