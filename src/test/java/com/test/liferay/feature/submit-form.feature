#Author: your.email@your.domain.com
#Keywords Summary :
#Feature: List of scenarios.
#Scenario: Business rule through list of steps with arguments.
#Given: Some precondition step
#When: Some key actions
#Then: To observe outcomes or validation
#And,But: To enumerate more Given,When,Then steps
#Scenario Outline: List of steps for data-driven as an Examples and <placeholder>
#Examples: Container for s table
#Background: List of steps run before each of the scenarios
#""" (Doc Strings)
#| (Data Tables)
#@ (Tags/Labels):To group Scenarios
#<> (placeholder)
#""
## (Comments)
#Sample Feature Definition Template
@tag
Feature: Submit Form

  @tag1
  Scenario: Submit form with all fields filled correctly 
			Given user is on page
    	And party rock text is visible  
    	When name field filled in by the user with only letters
    	And why test field filled in by the user with only letters
    	And birthday field filled in by the user with valid date
    	And press submit button
    	Then success message is displayed
   
  @Tag2  	
  Scenario: Submit form with all fields filled incorrectly 
    	Given user is on page
    	And party rock text is visible  
    	When name field filled in by the user with only numbers
    	And why field filled in by the user with only numbers
    	And birthday field filled in by the user with future date
    	And press submit button
    	Then Required field message is displayed to birthday field
    	And Required field message is displayed to name field
    	And Required field message is displayed to why field
    	
  @Tag3  	
  Scenario: Submit form without fields filled 
    	Given user is on page
    	And party rock text is visible
    	When press submit button 
    	Then Required field message is displayed to birthday field
    	And Required field message is displayed to name field
    	And Required field message is displayed to why field
    	
 @Tag4  	
  Scenario: Submit form with data field in nineteenth century  
    	Given user is on page
    	And party rock text is visible  
    	When name field filled in by the user with only special characters
    	And why field filled in by the user with only special characters
    	And birthday field filled in by the user with nineteenth century date
    	And press submit button
    	Then Required field message is displayed to birthday field
    	And Required field message is displayed to name field
    	And Required field message is displayed to why field   	