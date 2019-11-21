package pages;

import static utils.GlobalConstants.EXPLICIT_SLEEP_TIMEOUT_MILLIS;
import java.util.ArrayList;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import driver.FactoryDriver;
import utils.ExplicitWait;
import utils.LogUtils;
import utils.ScrollUtils;
/***
 * This class is used for Labcorp all web pages PageFactory elements
 * And to store shared methods
 */

public class LabCorpSearchPage extends BasePage{
	
	   @FindBy(css = "input.search-keyword")
	    private WebElement searchBox;
	   
	   @FindBy(css = "input.search-location")
	    private WebElement searchLoc;
	   
	    @FindBy(xpath = "//button[@class='search-form__submit']")
	    private WebElement searchButton;
	    
	    @FindBy(xpath = "//button[@class='close closebutton ae-button']")
	    private WebElement popUpClose;
	    
	    @FindBy(xpath = "//a[@href='/job/burlington/qa-test-automation-developer-engineer/668/13795412']")
	    private WebElement joblink;
	    
	    @FindBy(css = "h1.job-description__heading")
	    private WebElement jobTitleTxt;
	    
	    @FindBy(css = "span.job-location.job-info")
	    private WebElement joblocation;
	    
	    @FindBy(css = "span.job-id.job-info")
	    private WebElement jobid;
	    
	    @FindBy(css = "div.ats-description > p")
	    private List<WebElement> paragraphElements;
	    
	    @FindBy(css = "div.content > p")
	    private List<WebElement> paragraphElementsApplyPg;
		
	    @FindBy(xpath = "//span[contains(text(),'Prepare test plans, budgets, and schedules')]")
	    private WebElement spandesc1;
	    
	    @FindBy(xpath = "//*[@id=\"content\"]/div[3]/section/div[2]/div[1]/span/div/ul/li[12]/ul/li[1]/span[2]")
	    private WebElement spandesc2;
	   
	    @FindBy(xpath = "//span[contains(text(),'5+ years of experience in QA automation development and scripting')]")
	    private WebElement spandesc3;
	    
	    @FindBy(linkText = "APPLY NOW")
	    private WebElement applynow;

		private List<WebElement> paragraphGeneric;
	    
	    
	    
	    public String getJobTitleTxt() {
	        return jobTitleTxt.getText();
	    }
	    
	    public String getJoblocation() {
	        return joblocation.getText();
	    }
	    
	    public String getJobid() {
	        return jobid.getText();
	    }
	    
	    public String getspandesc1() {
	        return spandesc1.getText();
	    }
	    
	    public String getspandesc2() {
	        return spandesc2.getText();
	    }
	    
	    public String getspandesc3() {
	        return spandesc3.getText();
	    }
	    
	    public List<WebElement> getparagraphElements(){
	    	return paragraphElements;
	    }
	    
	    public List<WebElement> getparagraphElementsApplyPg(){
	    	return paragraphElementsApplyPg;
	    }
	    
	
	    /***
	     * This is a reusable method that reads text in list of web elements with Span Tagname
	     * And converts them to List String
	     */
	 
		
		public List<String> getJobDescriptionByParagraph(List<WebElement> paragraphGeneric) {
			
			List<String> paragraphsText = new ArrayList<String>();
			this.paragraphGeneric = paragraphGeneric;
			
			for(WebElement paragraphElement : this.paragraphGeneric) {
				List<WebElement> paragraphParts = paragraphElement.findElements(By.tagName("span"));
				StringBuilder paragraphText = new StringBuilder();
				for(WebElement paragraphPart : paragraphParts) {
					paragraphText.append(paragraphPart.getText());
				}
				if(paragraphsText.toString().trim().isEmpty()) {
					continue;
				}
				paragraphsText.add(paragraphText.toString());
				System.out.println(paragraphText);
			}
			
			return paragraphsText;
		}
	    

	    public void enterSearchtext(String jobname){
	    	ExplicitWait.elementToBeClickable(searchBox);
	    	ScrollUtils.scrollDown(500);
	        LogUtils.logInfo("Enter 'search' Text");
	        ExplicitWait.sleep(EXPLICIT_SLEEP_TIMEOUT_MILLIS);
	        searchBox.sendKeys(jobname);
	        searchLoc.clear();
	    }

	    public void clickSearchButton(){
	        LogUtils.logInfo("Click 'Search' button");
	        //ExplicitWait.elementToBeClickable(searchButton);
	        ScrollUtils.scrollDown(500);
	        ExplicitWait.visibilityOfElement(searchButton);
	        ExplicitWait.sleep(EXPLICIT_SLEEP_TIMEOUT_MILLIS);
	        searchButton.isEnabled();
	        searchButton.click();
	    }
	    
	    public void selectjob() {
	    	ExplicitWait.sleep(EXPLICIT_SLEEP_TIMEOUT_MILLIS);
	    	LogUtils.logInfo("Select automation job");
	    	ExplicitWait.elementToBeClickable(joblink);
	    	joblink.click();
	    	
	    }
	    
	    public void validJob() {
	    	ExplicitWait.sleep(EXPLICIT_SLEEP_TIMEOUT_MILLIS);
	    	LogUtils.logInfo("validate job details");
	    	ExplicitWait.elementToBeClickable(jobTitleTxt);
	    	ScrollUtils.scrollDown(500);
	    	
	    }
	    
	    public void applynowrole() {
	    	ExplicitWait.sleep(EXPLICIT_SLEEP_TIMEOUT_MILLIS);
	    	LogUtils.logInfo("Apply to role");
	    	ExplicitWait.elementToBeClickable(applynow);
	    	applynow.click();
	    	
	    }
	    
	    public void finalValidation() {
	    	ExplicitWait.sleep(EXPLICIT_SLEEP_TIMEOUT_MILLIS);
	    	LogUtils.logInfo("Applying page");
	    	ExplicitWait.visibilityOfElement(popUpClose);
	    	ExplicitWait.sleep(EXPLICIT_SLEEP_TIMEOUT_MILLIS);
	    	//FactoryDriver.popHandler();
	    	ExplicitWait.elementToBeClickable(popUpClose);
	    	popUpClose.click();
	    }
	    
	    
	    
	   
	    
	    
	    
}
