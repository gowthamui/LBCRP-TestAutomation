package steps;

import static org.junit.Assert.assertTrue;

import java.util.List;

import org.junit.Assert;

import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import driver.FactoryDriver;
import pages.LabCorpSearchPage;
import utils.ExplicitWait;

public class LabCorpSearchSteps {

	
	private LabCorpSearchPage page;

    public LabCorpSearchSteps(){
        page = new LabCorpSearchPage();
    }
	
	
	@When("^I make a search for'([^\"]*)'$")
    public void iMakeSearch(String jobname) {
		page.enterSearchtext(jobname);
		
		page.clickSearchButton();

    }
	
	@When("^I select the specific job role$")
    public void seletjobrole() {
		page.selectjob();

    }
	
	@When("^I validate the title, location and jobid$")
    public void valjobrole() {
		page.validJob();
		Assert.assertTrue("Jobtile is displayed", page.getJobTitleTxt().contentEquals("QA Test Automation Developer/Engineer"));
		Assert.assertTrue("Joblocation is displayed", page.getJoblocation().contentEquals("Location Burlington, North Carolina"));
		Assert.assertTrue("Joblocation is displayed", page.getJobid().contains("19-86756"));
		
    }
	
	
	
	
	@When("^I validate the description in a Paragraph$")
	public void valDescription() {
		
		String secondParagraph = page.getJobDescriptionByParagraph(page.getparagraphElements()).get(3);
		Assert.assertTrue(secondParagraph.startsWith("The right candidate for this role will participate inthe test automation technology development and best practice models."));
		Assert.assertTrue("Description 1", page.getspandesc1().contains("Prepare test plans, budgets, and schedules"));
		System.out.println(page.getspandesc1());
		Assert.assertTrue("Description 2", page.getspandesc2().contains("Selenium"));
		Assert.assertTrue("Description 3", page.getspandesc3().contains("5+ years of experience in QA automation development and scripting"));
		page.applynowrole();
		page.finalValidation();
		
    }
	
	@When("^I validate the description in a applypage$")
	public void applyPageVal() {
		
	String secondParagraphApplypage = page.getJobDescriptionByParagraph(page.getparagraphElementsApplyPg()).get(3);
	Assert.assertTrue(secondParagraphApplypage.startsWith("The right candidate for this role will participate inthe test automation technology development and best practice models."));
	Assert.assertTrue("Description 1", page.getspandesc1().contentEquals("Prepare test plans, budgets, and schedules."));
	FactoryDriver.windHandleBack();
	}
}
