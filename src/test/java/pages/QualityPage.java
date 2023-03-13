package pages;

import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class QualityPage {


    public QualityPage(){
        PageFactory.initElements(Driver.getDriver(),this);
    }


}
