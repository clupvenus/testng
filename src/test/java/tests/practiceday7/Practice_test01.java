package tests.practiceday7;

import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.*;
import utilities.ConfigReader;
import utilities.Driver;

import javax.swing.*;

public class Practice_test01 {
    // Kullanici https://www.iienstitu.com/en sayfasina gider
    // Login butonuna tiklar
    // Giris bilgilerini girer ve basarili sekilde giris yaptigini test eder
    // headers da bulunan egitimler kismina tiklar
    // acilan egitimler sayfasindan fiyat araligi olarak artan fiyat olarak secer
    // ucretsiz egitimlerden herhangi birini alir
    // kimlik dogrulama islemlerini girer
    // egitimin ucretsiz oldugunu test eder ve siparisi tamamlar
    // Kullanici profil kismindan dersi basarili bir sekilde kaydedildigini test eder
UdemyPage homepage=new UdemyPage();
UdemyLoginPage loginPage=new UdemyLoginPage();
MyPage myPage=new MyPage();
OnlineEgitimlerPage online=new OnlineEgitimlerPage();
KimlikDogrulama kimlik=new KimlikDogrulama();
    @Test
    public void test01(){
        // Kullanici https://www.iienstitu.com/en sayfasina gider
        Driver.getDriver().get("https://www.iienstitu.com/en");
        // Login butonuna tiklar
        homepage.loginButtonHomePage.click();

        loginPage.loginEmailBox.sendKeys(ConfigReader.getProperty("email"));

        loginPage.loginPasswordBox.sendKeys(ConfigReader.getProperty("password"));
        loginPage.submitElement.click();

        Assert.assertTrue(myPage.loggedCheckKontrol.isDisplayed());
        // headers da bulunan egitimler kismina tiklar
        myPage.egitimlerOnHeaders.click();

        // acilan egitimler sayfasindan fiyat araligi olarak artan fiyat olarak secer
        Select select=new Select(online.onlineSiralama);
        select.selectByValue("price_ASC");
        online.lessonStresYonetimi.click();

        // kimlik dogrulama islemlerini girer
        online.hemenBaslaButton.click();
        Actions action=new Actions(Driver.getDriver());
         action.sendKeys(kimlik.kimlikDogrulamMail,ConfigReader.getProperty("email"))
                 .sendKeys(Keys.TAB)
                 .sendKeys(Keys.TAB)
                 .sendKeys(Keys.TAB)
                 .sendKeys("nevzat")
                 .sendKeys(Keys.TAB)
                 .sendKeys("Celik")
                 .sendKeys(Keys.TAB)
                 .sendKeys("Varsova")
                 .sendKeys(Keys.TAB)
                 .sendKeys("1560BR")
                 .sendKeys(Keys.TAB)
                 .sendKeys("Groot-Ammers")
                 .sendKeys(Keys.TAB)
                 .sendKeys("1111111111")
                  .perform();
            kimlik.odemeyeGec.click();

        // egitimin ucretsiz oldugunu test eder ve siparisi tamamlar
        Assert.assertTrue(kimlik.ucretsizEgitimCheck.isDisplayed());

        kimlik.siparisiTamamlaButton.click();








    }


}
