package tests.US003;

import org.testng.annotations.Test;
import utilities.TestBaseRapor;

import static utilities.ObjectInitialiser.*;

public class TC003 extends TestBaseRapor
{
    @Test
    public void negativeRegsistrationTestWithInvalidPassword()
    {
        extentTest=extentReports.createTest("Negative Regsistration Test With Invalid Password","Uygun Koşulları Sağlamayan Password'ler Ile Kayıt Yapılmamalıdır");
        registirationPage.passwordTests(8,13,registirationPage.setPasswordErrorList());
        extentTest.pass("Test Başarılı");

    }
        // pass
}
