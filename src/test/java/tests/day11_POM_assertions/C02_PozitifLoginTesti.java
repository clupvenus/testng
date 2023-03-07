package tests.day11_POM_assertions;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.QdPage;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ReusableMethods;

public class C02_PozitifLoginTesti {
    @Test (groups = "smoke")

    public void pozitifLoginTesti(){
        //qd anasayfaya gidin

        Driver.getDriver().get(ConfigReader.getProperty("qdUrl"));

        //login linkine tiklayalim.
        QdPage qdPage=new QdPage();
        qdPage.ilkLoginLinki.click();

        //Cookies kabul et

        qdPage.qdCookiesKabul.click();


        //gecerli kullanici adi ve password girin
        qdPage.emailKutusu.sendKeys(ConfigReader.getProperty("qdGecerliUsername"));
        qdPage.passwordKutusu.sendKeys(ConfigReader.getProperty("qdGecerliPassword"));

        ReusableMethods.bekle(2);
        qdPage.loginButonu.click();


        //basarili bir sekilde giris yapildigini test edin.
        Assert.assertTrue(qdPage.basariliGirisElementi.isDisplayed());

         Driver.closeDriver();

    }





}
