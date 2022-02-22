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

public class TC005 extends TestBaseRapor {
Select select;

    @Test
    public void testCase5() throws InterruptedException {
        extentTest=extentReports.createTest("TC005","OK butonu tiklanir olmali");
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
        select=new Select(roomReservationsPage.createReservationsidUserDropDownElementi);
        select.selectByIndex(3);
        select=new Select(roomReservationsPage.createReservationsidUserHotelRoomDropDownElementi);
        select.selectByIndex(2);
        extentTest.pass("Dropdown'a degerler gonderildi");
        roomReservationsPage.createReservationspriceBoxElementi.sendKeys("300");
        roomReservationsPage.dateStart();
        roomReservationsPage.dateEnd();
        roomReservationsPage.adultAmountWebElement.sendKeys("4");
        roomReservationsPage.childrenAmountWebElement.sendKeys("3");
        roomReservationsPage.contactNameSurnameWebElement.sendKeys("mehmet sari");
        JavascriptExecutor js = (JavascriptExecutor) Driver.getDriver();
        js.executeScript("scroll(0, 250);");
        roomReservationsPage.contactPhoneWebElement.sendKeys("(212) 111-1111");
        roomReservationsPage.contactEmailWebElement.sendKeys("mehmet@gmail.com");
        roomReservationsPage.notesWebElement.sendKeys("bos");
        roomReservationsPage.approvedWebElementCheckBox.click();
        roomReservationsPage.isPaidWebElementCheckBox.click();
        extentTest.info("Tum degerler girildi");
        roomReservationsPage.saveButtonWebElement.click();
        extentTest.info("Save butonu tiklandi");
        roomReservationsPage.createReservationsOkButon.click();
        ReusableMethods.waitFor(2);
        extentTest.info("OK butonu tiklandi");

        

        Driver.closeDriver();

    }

}
