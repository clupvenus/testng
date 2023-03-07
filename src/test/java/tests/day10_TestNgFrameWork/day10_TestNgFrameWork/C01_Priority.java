package tests.day10_TestNgFrameWork.day10_TestNgFrameWork;

import org.testng.Assert;
import org.testng.annotations.Test;
import utilities.Driver;

public class C01_Priority {
    /*
    Test ng methodlarini calistiirken onceligi harf sirasina gore verir.
    Ancak TestNg siralamayi bizim kontrol etmemize olanak saglar.
     */
    //
    //
    // (priorty ) annotions
    // Istedigimiz onceligi istedigimiz onceligi priorty ile saglayabiliriz. Once en kucuk olan sayi calisir
    //priority sayi degeri esitse harf sirasina gore calisir.
    //priority degeri yazilmazsa default olarak sifir kabul edilir.


    @Test(priority = 5)
    public void amazonTesti(){
       // amazon anasayfaya git, amazona gittigiizi test et
        Driver.getDriver().get("https://www.amazon.com");
        //url amazoniceriyor mu test edelim.

        String expectedIcerik="amazon";
        String actualURL= Driver.getDriver().getCurrentUrl();

        Assert.assertTrue(actualURL.contains(expectedIcerik));
        Driver.closeDriver();
    }
    @Test(priority = 30)
    public void wisequarterTesti() throws InterruptedException {
// wisequarter anasayfaya git, amazona gittigiizi test et
        Driver.getDriver().get("https://www.wisequarter.com");
        //url amazoniceriyor mu test edelim.
        Thread.sleep(2000);
        Driver.getDriver().navigate().refresh();
        String expectedIcerik="wise";
        String actualURL= Driver.getDriver().getCurrentUrl();

        Assert.assertTrue(actualURL.contains(expectedIcerik));
        Driver.closeDriver();


    }

    @Test(priority = 20)

    public void youtubeTesti(){
        //youtube anasayfaya git, amazona gittigiizi test et
        Driver.getDriver().get("https://www.youtube.com");
        //url amazoniceriyor mu test edelim.

        String expectedIcerik="youtube";
        String actualURL= Driver.getDriver().getCurrentUrl();

        Assert.assertTrue(actualURL.contains(expectedIcerik));
        Driver.closeDriver();
    }
    }

