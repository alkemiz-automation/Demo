Feature: Approaches to Market Listing
  URL: [https://www.tenders.gov.au/atm|https://www.tenders.gov.au/atm]

  Scenario: Search and View ATM Listings
    Given I Navigate to https://www.tenders.gov.au/atm
    When I Enter Education in the textbox Keyword
    And I Click on the button Search
    Then I should see a list of ATM records displayed
    And I should see text 'Close Date & Time' on each record

  Scenario: Validate ATM Card Details
    Given I am on the ATM listing page
    Then I should see the ATM ID, Agency, Category, and Description for each record
    And each ATM record should have a Full Details link
