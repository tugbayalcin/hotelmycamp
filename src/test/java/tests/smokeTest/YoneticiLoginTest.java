package tests.smokeTest;

import org.testng.annotations.Test;
import pages.RoomReservationsPage;
import tests.US002.TC002;

import java.io.IOException;

public class YoneticiLoginTest {
    @Test
    public void YoneticiLoginTest() throws IOException, InterruptedException {
        RoomReservationsPage roomReservationsPage=new RoomReservationsPage();
        roomReservationsPage.roomReservationsGiris();
    }



}
