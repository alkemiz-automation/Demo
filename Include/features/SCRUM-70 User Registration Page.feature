Feature: User Registration Page
URL: [https://www.tenders.gov.au/RegisteredUser/Register|https://www.tenders.gov.au/RegisteredUser/Register]
Scenario: Verify Registration Fields
Given I Navigate to https://www.tenders.gov.au/RegisteredUser/Register
Then I should see textboxes for Email, Password, Confirm Password, Organisation Name, and Contact Details
And I should see the Register button