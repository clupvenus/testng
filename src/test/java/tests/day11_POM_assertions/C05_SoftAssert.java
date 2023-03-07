package tests.day11_POM_assertions;

import org.openqa.selenium.Keys;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import pages.AmazonPage;
import utilities.ConfigReader;
import utilities.Driver;

public class C05_SoftAssert {
   @Test (groups = {"mr1","mr2"})
    public void amazonTesti(){
       /*
       genelde dogrulayin denirse soft assert kasdedilir.
        */

       //amazon anasayfaya git. Dogru sayfaya gittiginizi Dogrulayin(verify)

       Driver.getDriver().get(ConfigReader.getProperty("amazonUrl"));
       String expectedIcerik="amazon";
       String actualUrl=Driver.getDriver().getCurrentUrl();

       SoftAssert softAssert=new SoftAssert();

       softAssert.assertTrue(actualUrl.contains(expectedIcerik));


       //nutella icin arama yapip sonuclarin nutella icerdigini test edin.
       AmazonPage amazonPage=new AmazonPage();
       amazonPage.aramaKutusu.sendKeys(ConfigReader.getProperty("amazonAranacakKelime")+ Keys.ENTER);

       expectedIcerik="Nutella";
       String actualAramaSonucYazisi=amazonPage.aramaSonucElementi.getText();

       softAssert.assertTrue(actualAramaSonucYazisi.contains(expectedIcerik));


       //ilk urune tiklayip urun isminde Nutella gectigini dogrulayin.

       amazonPage.ilkUrun.click();
       expectedIcerik="Nutella";
       String actualIlkurunIsim=amazonPage.ilkUrunIsimElementi.getText();

       softAssert.assertTrue(actualIlkurunIsim.contains(expectedIcerik));




       softAssert.assertAll();


       Driver.closeDriver();


    }


}
