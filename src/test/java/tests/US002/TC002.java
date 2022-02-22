package tests.US002;

import org.checkerframework.checker.units.qual.A;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.AnaSayfaPage;
import pages.LoginPage;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ReusableMethods;
import utilities.TestBaseRapor;

import java.io.IOException;

public class TC002 extends TestBaseRapor {

    @Test
    public void testCase2() throws InterruptedException, IOException {

        extentTest=extentReports.createTest("TC002","ListOfUsers görüntülenmeli");

        Driver.getDriver().get(ConfigReader.getProperty("HMCURL"));
        AnaSayfaPage anaSayfaPage = new AnaSayfaPage();
        LoginPage loginPage = new LoginPage();

        anaSayfaPage.mainLoginLinki.click();

        loginPage.LoginUsernameBox.sendKeys(ConfigReader.getProperty("ManagerUsername"));
        loginPage.LoginPasswordBox.sendKeys(ConfigReader.getProperty("ManagerPassword"));

        loginPage.GirisLoginButon.click();

        Assert.assertTrue(loginPage.ListOfUsers.isDisplayed());

        loginPage.AddUserButon.click();
        Assert.assertTrue(loginPage.CreateUser.isDisplayed());
        Driver.getDriver().navigate().back();

        Assert.assertTrue(loginPage.DownloadButon.isDisplayed());


        Assert.assertTrue(loginPage.PrintButon.isDisplayed());
        loginPage.PrintButon.click();

        ReusableMethods.waitFor(2);

        extentTest.pass("ListOfUsers görüntülendi");

        //Driver.closeDriver();

    }
}
