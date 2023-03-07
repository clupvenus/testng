package utilities;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class Driver {

    //Daha fazla kontrol imkani ve extends kullanmadandrivera ulasmak icin
    //wedriver objesini Driver clasinda static bir method ile olusturacagiz.
//Ancak getdriver methodu her kullanildiginda yeni bir driver olusturuyor.
    //Bunu engellemek ve kodumuzun duzgun calismasini saglamak icin ilk kullanimda
    //ChromeDriver() calissin sonrakinde calismasin diye bir yontem gelistirmeliyiz.


    public static WebDriver driver;
    public static WebDriver getDriver(){
        WebDriverManager.chromedriver().setup();
        if (driver == null) {
            driver=new ChromeDriver();
        }

        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        return driver;
    }

    public static void closeDriver(){
        if (driver!=null){
        driver.close();}
        driver=null;
    }
    public static void quitDriver(){
        if (driver!=null){
            driver.quit();}
        driver=null;
    }




}
