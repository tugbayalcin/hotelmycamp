package tests.US001;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pages.AnaSayfaPage;
import pages.LoginPage;
import utilities.ConfigReader;
import utilities.Driver;
import java.time.Duration;
public class TC_0001 {
    @Test
    public void logInTest(){
        AnaSayfaPage anaSayfaPage=new AnaSayfaPage();

        LoginPage loginPage=new LoginPage();
        Driver.getDriver().get(ConfigReader.getProperty("HMCURL"));
        loginPage.AnasayfaloginButon.click();
        String sonucUsername=loginPage.LoginUsernameBox.getText();
        Assert.assertTrue(sonucUsername.contains("Username"));
        String sonucPassword=loginPage.LoginPasswordBox.getText();
        Assert.assertTrue(sonucPassword.contains("Password"));
    }
}
