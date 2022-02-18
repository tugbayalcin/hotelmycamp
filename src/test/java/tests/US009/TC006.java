package tests.US009;

import org.testng.Assert;
import org.testng.annotations.Test;
import utilities.ConfigReader;
import utilities.Driver;
import static utilities.ObjectInitialiser.*;

public class TC006 {

    @Test
    public void testCase1() {

        Driver.getDriver().get(ConfigReader.getProperty("HMCURL"));
        anaSayfaPage.mainLoginLinki.click();
        loginPage.LoginUsernameBox.sendKeys(ConfigReader.getProperty("ManagerUsername"));
        loginPage.LoginPasswordBox.sendKeys(ConfigReader.getProperty("WrongPassword"));
        loginPage.GirisLoginButon.click();
        Assert.assertTrue(roomReservationsPage.girisYapilamadiYazisi.isDisplayed());


        Driver.closeDriver();
    }

}
