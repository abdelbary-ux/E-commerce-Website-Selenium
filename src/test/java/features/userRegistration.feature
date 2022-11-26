Feature: User Registration
		I want to check that a user can register to our website
		
	Scenario: User Registration
	Given the user in the home page
	When I click on register link
	And I entered user credintials
	Then The registration completed successfully