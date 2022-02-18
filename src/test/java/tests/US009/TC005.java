package tests.US009;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.LoginPage;
import utilities.ConfigReader;
import utilities.Driver;
import static utilities.ObjectInitialiser.*;

public class TC005 {


    @Test
    public void testCase5() {

        Driver.getDriver().get(ConfigReader.getProperty("HMCURL"));
        LoginPage loginPage = new LoginPage();
        anaSayfaPage.mainLoginLinki.click();
        loginPage.LoginUsernameBox.sendKeys(ConfigReader.getProperty("WrongUsername"));
        loginPage.LoginPasswordBox.sendKeys(ConfigReader.getProperty("ManagerPassword"));
        loginPage.GirisLoginButon.click();
        Assert.assertTrue(roomReservationsPage.girisYapilamadiYazisi.isDisplayed());

        Driver.closeDriver();
    }

}
