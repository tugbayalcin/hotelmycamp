package tests.US009;

import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import utilities.Driver;
import static utilities.ObjectInitialiser.*;
public class TC001 {

    @Test
    public void testCase1() throws InterruptedException {


        roomReservationsPage.roomReservationsGiris();
        WebElement actualListOfReservations=roomReservationsPage.listOfReservations;
        Assert.assertTrue(actualListOfReservations.isDisplayed());
        Driver.closeDriver();
    }
}
