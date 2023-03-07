package tests.day10_TestNgFrameWork.day10_TestNgFrameWork;

import org.openqa.selenium.Keys;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.AmazonPage;
import utilities.Driver;

public class C02_dependsOnMethods {
    /*
    Priority oncelik belirler ama testleri birbirine baglamaz.
    Eger bir test methodunun calismasin baska bir test methoduna bagli ise bu durumda
    Priority yerine depends on methodu kullanmak daha guzel olur.
    DependsonMethod ile baska bir methoda bagli olan methodu bagimsiz calistirmak istersek
    once bagli oldugu methodu calistirir.
    Sonra kendisi calisir.
    Ancak bu 2 method icin gecerli 3 methodu calistirmaz.
    Depends on  methodu siralamayi belirlemez.
    sira bagli olan bir methoda geldiginde oncelikle calismasina bagli olan methodun calismasini ve
    passed olmasini bekler

    Eger bagli olunan method failed olursa bagli olan method calistirilmaz ignore edilir.

     */


    //uc test methodu olusturun
    //1. de amazona gidip amazona gittiginzi test edin.
    //2. de nutella aratip sonucun nutella icerdigini test edin.
    //3. de ilk urune click() yapip urun isminin nutella icerdigini test edin.



    AmazonPage amazonPage=new AmazonPage();
    @Test
    public void amazonTesti(){
        Driver.getDriver().get("https://www.amazon.com");
        String expectedIcerik="amazon";
        String actualURL=Driver.getDriver().getCurrentUrl();

        Assert.assertTrue(actualURL.contains(expectedIcerik));
    }


    @Test (dependsOnMethods = "amazonTesti")
    public void nutellaTesti(){

        amazonPage.aramaKutusu.sendKeys("Nutella" + Keys.ENTER);

        String expectedIcerik = "Nutella";
        String actualSonucYazisi = amazonPage.aramaSonucElementi.getText();

        Assert.assertTrue(actualSonucYazisi.contains(expectedIcerik));

    }



    @Test (dependsOnMethods = "nutellaTesti")
    public void ilkUrunTesti(){

       amazonPage.ilkUrun.click();
        String expectedIcerik="Nutella";

        String actualUrunIsmi= amazonPage.ilkUrunIsimElementi.getText();

        Assert.assertTrue(actualUrunIsmi.contains(expectedIcerik));

    Driver.closeDriver();
    }
}
