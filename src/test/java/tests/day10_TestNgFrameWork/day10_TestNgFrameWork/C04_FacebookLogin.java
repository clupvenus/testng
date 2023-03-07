package tests.day10_TestNgFrameWork.day10_TestNgFrameWork;

import com.github.javafaker.Faker;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.FacebookPage;
import utilities.Driver;

public class C04_FacebookLogin {

//1 - https://www.facebook.com/ adresine gidin
//2- POM’a uygun olarak email, sifre kutularini ve giris yap butonunu locate edin
//3- Faker class’ini kullanarak email ve sifre degerlerini yazdirip, giris butonuna basin
//4- Basarili giris yapilamadigini test edin

    @Test (groups = "smoke")
    public void facebookTesti(){
        FacebookPage facebookPage=new FacebookPage();
        //1 - https://www.facebook.com/ adresine gidin
        Driver.getDriver().get("https://www.facebook.com/");

        //2- POM’a uygun olarak email, sifre kutularini ve giris yap butonunu locate edin
        //cookies kabul et
        facebookPage.cookiesKabulButonu.click();

        //3- Faker class’ini kullanarak email ve sifre degerlerini yazdirip, giris butonuna basin
        Faker faker=new Faker();
        facebookPage.emailKutusu.sendKeys(faker.internet().emailAddress());
        facebookPage.password.sendKeys(faker.internet().password());
        facebookPage.loginButonu.click();
        //4- Basarili giris yapilamadigini test edin
        Assert.assertTrue(facebookPage.girisYapilamadi.isDisplayed());

        Driver.closeDriver();

    }



}
