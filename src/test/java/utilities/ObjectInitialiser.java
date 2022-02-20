package utilities;

import org.testng.asserts.SoftAssert;
import pages.*;

import java.text.SimpleDateFormat;
import java.util.Date;

public class ObjectInitialiser
{

   public static AnaSayfaPage anaSayfaPage = new AnaSayfaPage();//bu bir class(static)variable
   public static HotelListPage hotelListPage = new HotelListPage();
   public static HotelRoomsPage hotelRoomsPage = new HotelRoomsPage();
   public static LoginPage loginPage = new LoginPage();
   public static RegistirationPage registirationPage = new RegistirationPage();
   public static RoomReservationsPage roomReservationsPage = new RoomReservationsPage();
   public static String date = new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());
   public static SoftAssert softAssert = new SoftAssert();



}
