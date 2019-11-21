@labcorp_search
Feature: Searching specific job on www.jobs.labcorp.com
	As a user
	I want to be able to search for a specific job 
	On www.jobs.labcorp.com

  Scenario: Searching a latest QA automation Job
		Given I am on main page
		When I make a search for'QA Test Automation Developer'
		When I select the specific job role
		When I validate the title, location and jobid
		When I validate the description in a Paragraph
		When I validate the description in a applypage
		