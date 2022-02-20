package tests.US002;

import org.openqa.selenium.JavascriptExecutor;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.AnaSayfaPage;
import pages.LoginPage;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ReusableMethods;
import utilities.TestBaseRapor;

import java.io.IOException;

public class TC005 extends TestBaseRapor {

    JavascriptExecutor js = (JavascriptExecutor) Driver.getDriver();

    @Test
    public void testCase5() throws InterruptedException, IOException {

        extentTest=extentReports.createTest("TC004","Yönetici bilgileri değiştirilemez");

        Driver.getDriver().get(ConfigReader.getProperty("HMCURL"));
        AnaSayfaPage anaSayfaPage = new AnaSayfaPage();

        LoginPage loginPage = new LoginPage();
        anaSayfaPage.mainLoginLinki.click();
        loginPage.LoginUsernameBox.sendKeys(ConfigReader.getProperty("ManagerUsername"));
        loginPage.LoginPasswordBox.sendKeys(ConfigReader.getProperty("ManagerPassword"));
        loginPage.GirisLoginButon.click();
        ReusableMethods.waitFor(2);
        loginPage.ListOfUsersUsernameBox.click();
        loginPage.ListOfUsersUsernameBox.sendKeys(ConfigReader.getProperty("ManagerUsername"));
        loginPage.SearchButon.click();
        ReusableMethods.waitFor(2);
        loginPage.DetailsButon.click();


        js.executeScript("arguments[0].scrollBy(500,0);", loginPage.EditUserAddress);

        ReusableMethods.waitFor(2);
        loginPage.EditUserAddress.click();
        loginPage.EditUserAddress.sendKeys(" Hello Sokak");
        ReusableMethods.waitFor(2);

        js.executeScript("arguments[0].scrollBy(500,0);", loginPage.EditUserSaveButon);
        ReusableMethods.waitFor(2);
        loginPage.EditUserSaveButon.click();
        ReusableMethods.waitFor(2);

        Assert.assertTrue(loginPage.NoPermissions.isDisplayed());

        ReusableMethods.getScreenShots("UsernamesS", "target/screenShot/US002");

        loginPage.NoPermissionsOKButton.click();

        extentTest.pass("Yönetici bilgileri değiştirilemedi");

        //Driver.closeDriver();

    }
}
