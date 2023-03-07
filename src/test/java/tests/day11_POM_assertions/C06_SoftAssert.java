package tests.day11_POM_assertions;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import pages.ZeroPage;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ReusableMethods;

import java.util.ArrayList;
import java.util.List;

public class C06_SoftAssert {
    //1. “http://zero.webappsecurity.com/” Adresine gidin

    // 2. Sign in butonuna basin
    // 3. Login kutusuna “username” yazin
    // 4. Password kutusuna “password” yazin
    // 5. Sign in tusuna basin
    // 6. Online banking menusu icinde Pay Bills sayfasina gidin
    // 7. “Purchase Foreign Currency” tusuna basin
    // 8. “Currency” drop down menusunden Eurozone’u secin
    // 9. soft assert kullanarak "Eurozone (euro)" secildigini test edin
    // 10. soft assert kullanarak DropDown listesinin su secenekleri oldugunu test edin "
    // Select One", "Australia (dollar)", "Canada (dollar)","Switzerland (franc)","China (yuan)",
    // "Denmark (krone)","Eurozone (euro)","Great Britain (pound)","Hong Kong (dollar)","Japan (yen)",
    // "Mexico (peso)","Norway (krone)",
    // "New Zealand (dollar)","Sweden (krona)","Singapore (dollar)","Thailand (baht)"

    @Test
    public void test(){
        //1. “https://zero.webappsecurity.com/” Adresine gidin
        Driver.getDriver().get(ConfigReader.getProperty("zeroUrl"));
        // 2. Sign in butonuna basin
        ZeroPage zeroPage=new ZeroPage();
        zeroPage.signInButonu.click();
        // 3. Login kutusuna “username” yazin
        zeroPage.usernameKutusu.sendKeys("username");
        // 4. Password kutusuna “password” yazin
        zeroPage.passwordKutusu.sendKeys("password");
        // 5. Sign in tusuna basin
        zeroPage.signInButonu.click();
        //navigate back yapalim.
        Driver.getDriver().navigate().back();
        // 6. Online banking menusu icinde Pay Bills sayfasina gidin
        zeroPage.payBillLinki.click();
        // 7. “Purchase Foreign Currency” tusuna basin
        zeroPage.purchaseFCButonu.click();
        // 8. “Currency” drop down menusunden Eurozone’u secin
        Select select=new Select(zeroPage.currencyDropdown);
        select.selectByVisibleText("Eurozone");

        // 9. soft assert kullanarak "Eurozone (euro)" secildigini test edin
        SoftAssert softAssert=new SoftAssert();
        String expectedSecim="Eurozone (euro)";
        String actualsecim= select.getFirstSelectedOption().getText();

        softAssert.assertEquals(actualsecim,expectedSecim,"dropdownda eurozone secili degil");

        // 10. soft assert kullanarak DropDown listesinin su secenekleri oldugunu test edin "
        // Select One", "Australia (dollar)", "Canada (dollar)","Switzerland (franc)","China (yuan)",
        // "Denmark (krone)","Eurozone (euro)","Great Britain (pound)","Hong Kong (dollar)","Japan (yen)",
        // "Mexico (peso)","Norway (krone)",
        // "New Zealand (dollar)","Sweden (krona)","Singapore (dollar)","Thailand (baht)"

        List<WebElement> optionsStringListesi=select.getOptions();
          List<String>   optionsStringList= ReusableMethods.stringListCevir(optionsStringListesi);

          String[] expectedArr={"Select One", "Australia (dollar)", "Canada (dollar)","Switzerland (franc)","China (yuan)",
                   "Denmark (krone)","Eurozone (euro)","Great Britain (pound)","Hong Kong (dollar)","Japan (yen)",
                  "Mexico (peso)","Norway (krone)",
                  "New Zealand (dollar)","Sweden (krona)","Singapore (dollar)","Thailand (baht)"};
          List<String> expectedOptionListeso=new ArrayList<>();
        for (String each:expectedArr
             ) {
            expectedOptionListeso.add(each);
            /*
            eksik nott varrrrrr
             */
        }





        softAssert.assertAll();
        Driver.closeDriver();
    }


}
