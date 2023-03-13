package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class AmazonPage {

    //Pages class lari surekli kullandigimiz locate leri tekrar tekrar locate etmek zorunda kalaktan
    //kurtulmak icin kullanilir.
    //her pages class'i Driver class'inda olusturulan webdriveri kullanir

    //@FindBy notasyonu  Driver clasindaki webDriveri kullanabilmek icin
    // bu class a tanimlamamiz lazim
    //bunun icin her pages sayfasi icin basina parametresiz constructor olusturup
    // icerisinde driveri bu class a tanitiyoruz.

    public AmazonPage(){
        PageFactory.initElements(Driver.getDriver(),this);
    }


    @FindBy(id="twotabsearchtextbox")
    public WebElement aramaKutusu;

    @FindBy(xpath = "//h1[@class='a-size-base s-desktop-toolbar a-text-normal']")
    public WebElement aramaSonucElementi;

    @FindBy(xpath = "(//img[@class='s-image'])[2]")
    public WebElement ilkUrun;

    @FindBy(xpath = "//span[@id='productTitle']")
    public WebElement ilkUrunIsimElementi;
}
