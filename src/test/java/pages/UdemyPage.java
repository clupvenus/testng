package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class UdemyPage {
    public UdemyPage (){
        PageFactory.initElements(Driver.getDriver(),this);
        //Paranetresiz constructor
    }
    @FindBy(xpath = "//*[text()='Log In']")
    public WebElement loginButtonHomePage;








}
