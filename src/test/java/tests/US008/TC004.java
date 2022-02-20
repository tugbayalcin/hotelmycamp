package tests.US008;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.AnaSayfaPage;
import pages.LoginPage;
import pages.RoomReservationsPage;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ReusableMethods;
import utilities.TestBaseRapor;

public class TC004 extends TestBaseRapor {

    Select select;
    @Test
    public void testCase5() throws InterruptedException {
        extentTest=extentReports.createTest("TC004","SAVE butonu tiklanir olmali");
        Driver.getDriver().get(ConfigReader.getProperty("HMCURL"));
        AnaSayfaPage anaSayfaPage=new AnaSayfaPage();
        RoomReservationsPage roomReservationsPage=new RoomReservationsPage();
        LoginPage loginPage=new LoginPage();
        anaSayfaPage.mainLoginLinki.click();
        loginPage.LoginUsernameBox.sendKeys(ConfigReader.getProperty("ManagerUsername"));
        loginPage.LoginPasswordBox.sendKeys(ConfigReader.getProperty("ManagerPassword"));
        loginPage.GirisLoginButon.click();
        extentTest.info("Giris butonu tiklandi");
        roomReservationsPage.hotelManagementList.click();
        roomReservationsPage.roomReservationsList.click();
        roomReservationsPage.addRoomReservationsWebElement.click();
        roomReservationsPage.createReservationspriceBoxElementi.sendKeys("300");
        roomReservationsPage.adultAmountWebElement.sendKeys("4");
        roomReservationsPage.childrenAmountWebElement.sendKeys("3");
        roomReservationsPage.contactNameSurnameWebElement.sendKeys("mehmet sari");
        ReusableMethods.waitFor(1);
        JavascriptExecutor js = (JavascriptExecutor) Driver.getDriver();
        js.executeScript("scroll(0, 250);");
        roomReservationsPage.contactPhoneWebElement.sendKeys("(212) 111-1111");
        roomReservationsPage.contactEmailWebElement.sendKeys("mehmet@gmail.com");
        roomReservationsPage.notesWebElement.sendKeys("bos");
        extentTest.info("Degerler gonderildi");
        roomReservationsPage.approvedWebElementCheckBox.click();
        roomReservationsPage.isPaidWebElementCheckBox.click();
        roomReservationsPage.saveButtonWebElement.click();
        extentTest.info("Save butonu tiklandi");





      //  Driver.closeDriver();
    }

}
