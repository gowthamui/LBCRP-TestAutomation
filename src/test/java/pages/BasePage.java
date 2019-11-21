package pages;

import driver.FactoryDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.LogUtils;

/***
 * This class is used to initialize PageFactory elements
 * And to store shared methods
 */
public class BasePage {

    protected BasePage(){
        PageFactory.initElements(FactoryDriver.getInstance(), this);
    }

    @FindBy(xpath = "//a[contains(@href,'http://www.labcorpcareers.com')]")
    private WebElement careerLink;
    

    public void clickCareerLinkFromMainPage() {
        LogUtils.logInfo("Click 'Careers' link");
        careerLink.click();
    }
    
    

}
