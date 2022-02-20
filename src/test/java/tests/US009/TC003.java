package tests.US009;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import utilities.Driver;
import utilities.ReusableMethods;
import utilities.TestBaseRapor;

import static utilities.ObjectInitialiser.*;

public class TC003 extends TestBaseRapor {
    JavascriptExecutor js = (JavascriptExecutor) Driver.getDriver();
    @Test
    public void testCase3() throws InterruptedException {

        extentTest=extentReports.createTest("TC003","Properties update edilmeli");
        roomReservationsPage.roomReservationsGiris();
        extentTest.info("giris yapildi");

        js.executeScript("scroll(0, 250);");

        roomReservationsPage.ContactPhoneBox.sendKeys("(312) 321-3211");

        js.executeScript("arguments[0].scrollBy(500,0);", roomReservationsPage.reservationsListSagaKaydir);
        ReusableMethods.waitFor(1);
        roomReservationsPage.searchButon.click();
        ReusableMethods.waitFor(1);
        roomReservationsPage.detailsButon.click();
        ReusableMethods.waitFor(1);

        roomReservationsPage.propertiesButon.click();
        ReusableMethods.waitFor(2);
        extentTest.info("room reservations properties buton tiklandi");
        roomReservationsPage.codeBox.clear();
        roomReservationsPage.valueBox.clear();
        roomReservationsPage.codeBox.sendKeys("111"+ Keys.TAB+"value");
        extentTest.info("Update bilgileri girildi");
        roomReservationsPage.updateButon.click();
        WebElement actual=roomReservationsPage.updateSuccesfullyElementi;

        ReusableMethods.waitFor(1);

        Assert.assertTrue(actual.isDisplayed());
        extentTest.pass("Update Succesfully yazisi goruntulendi");
        Thread.sleep(1500);
        roomReservationsPage.updateSuccesfullyOk.click();
        extentTest.info("Update Succesfully yazisi onaylandi");
        // ok'a basinca popUp kapanmiyor
        Driver.closeDriver();
    }

}
