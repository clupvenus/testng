package tests.day11_POM_assertions;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.QdPage;
import utilities.ConfigReader;
import utilities.Driver;

import static utilities.ReusableMethods.bekle;

public class C03_NegatifLoginTest {
    //qd anasayfaya gidin.
// 3 test method'u olusturun ve
// asagidaki durumlarda giris yapilamadigini test edin
// 1- gecerli username, gecersiz password
// 2- gecersiz username, gecerli password
// 3- gecersiz username, gecersiz password

    QdPage qdPage;

    @Test (groups = {"smoke","mr1"})
    public void negatifLogin1(){


        Driver.getDriver().get(ConfigReader.getProperty("qdUrl"));
        qdPage=new QdPage();
        //Cookies kabul et

        qdPage.qdCookiesKabul.click();

        qdPage.ilkLoginLinki.click();

        qdPage.emailKutusu.sendKeys(ConfigReader.getProperty("qdGecerliUsername"));
        qdPage.passwordKutusu.sendKeys(ConfigReader.getProperty("qdGecersizPassword"));

        qdPage.loginButonu.click();

        Assert.assertTrue(qdPage.emailKutusu.isEnabled());
        Driver.closeDriver();
    }
    @Test
    public void negatifLogin2(){
        qdPage=new QdPage();
        bekle(5);
        Driver.getDriver().get(ConfigReader.getProperty("qdUrl"));
        //Cookies kabul et

        qdPage.qdCookiesKabul.click();

        qdPage.ilkLoginLinki.click();
        qdPage.emailKutusu.sendKeys(ConfigReader.getProperty("qdGecersizUsername"));
        qdPage.passwordKutusu.sendKeys(ConfigReader.getProperty("qdGecerliPassword"));
        qdPage.loginButonu.click();

        Assert.assertTrue(qdPage.emailKutusu.isEnabled());
        Driver.closeDriver();
    }
    @Test
    public void negatifLogin3(){
        qdPage=new QdPage();

        Driver.getDriver().get(ConfigReader.getProperty("qdUrl"));

        //Cookies kabul et

        qdPage.qdCookiesKabul.click();

        qdPage.ilkLoginLinki.click();
        qdPage.emailKutusu.sendKeys(ConfigReader.getProperty("qdGecersizUsername"));
        qdPage.passwordKutusu.sendKeys(ConfigReader.getProperty("qdGecersizPassword"));
        qdPage.loginButonu.click();

        Assert.assertTrue(qdPage.emailKutusu.isEnabled());
        Driver.closeDriver();
    }





}
