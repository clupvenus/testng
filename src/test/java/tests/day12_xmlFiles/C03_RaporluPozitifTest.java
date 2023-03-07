package tests.day12_xmlFiles;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.QdPage;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ReusableMethods;
import utilities.TestBaseRapor;

public class C03_RaporluPozitifTest extends TestBaseRapor {


        @Test
        public void pozitifLoginTesti() {
            extentTest = extentReports.createTest("Pozitif login testi","Gecerli bilhilerle giris yapilabilmeli");

            //qd anasayfaya gidin

            Driver.getDriver().get(ConfigReader.getProperty("qdUrl"));
             extentTest.info("QualityDemy sayfasina gidildi.");
            //login linkine tiklayalim.
            QdPage qdPage = new QdPage();
            qdPage.ilkLoginLinki.click();
            extentTest.info("Ilk login linkine tiklandi.");

            //Cookies kabul et

            qdPage.qdCookiesKabul.click();


            //gecerli kullanici adi ve password girin
            qdPage.emailKutusu.sendKeys(ConfigReader.getProperty("qdGecerliUsername"));
            qdPage.passwordKutusu.sendKeys(ConfigReader.getProperty("qdGecerliPassword"));

            ReusableMethods.bekle(2);
            qdPage.loginButonu.click();


            //basarili bir sekilde giris yapildigini test edin.
            Assert.assertTrue(qdPage.basariliGirisElementi.isDisplayed());
            extentTest.pass("Basarili bir sekilde giris yapidi test edildi.");

        }
    }
