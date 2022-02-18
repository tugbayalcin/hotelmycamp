package tests.US009;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import utilities.Driver;
import utilities.ReusableMethods;
import static utilities.ObjectInitialiser.*;

public class TC003 {
    JavascriptExecutor js = (JavascriptExecutor) Driver.getDriver();
    @Test
    public void testCase3() throws InterruptedException {


        roomReservationsPage.roomReservationsGiris();

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
        roomReservationsPage.codeBox.clear();
        roomReservationsPage.valueBox.clear();
        roomReservationsPage.codeBox.sendKeys("111"+ Keys.TAB+"value");

        roomReservationsPage.updateButon.click();
        WebElement actual=roomReservationsPage.updateSuccesfullyElementi;

        ReusableMethods.waitFor(1);

        Assert.assertTrue(actual.isDisplayed());
        Thread.sleep(1500);
        roomReservationsPage.updateSuccesfullyOk.click();
        // ok'a basinca popUp kapanmiyor
        Driver.closeDriver();
    }

}
