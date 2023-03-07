package tests.day11_POM_assertions;

import org.openqa.selenium.Keys;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.AmazonPage;
import utilities.ConfigReader;
import utilities.Driver;

public class C01_ConfigReaderKullanimi {

    @Test

    public void test01(){
        //amazon anasayfaya git
        Driver.getDriver().get(ConfigReader.getProperty("amazonUrl"));

        //Test datasi icin verilen kelimeyi iciin arama yapalim.
        AmazonPage amazonPage=new AmazonPage();

        amazonPage.aramaKutusu.sendKeys(ConfigReader.getProperty("amazonAranacakKelime")+ Keys.ENTER);

        //arama sonuclarinin arattiginiz test datasini icerdeigini test edelim.

        String ecpectedIcerik=ConfigReader.getProperty("amazonAranacakKelime");
        String actualAramaSonuc=amazonPage.aramaSonucElementi.getText();

        Assert.assertTrue(actualAramaSonuc.contains(ecpectedIcerik));


       Driver.closeDriver();

    }





}
