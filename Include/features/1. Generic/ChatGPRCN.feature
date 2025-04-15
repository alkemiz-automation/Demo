@StandingOfferSearch
Feature: Standing Offer Notices Search Filters and Form Validation
  This feature validates all interactive elements, dropdowns, and text inputs on the Standing Offer Notices page.

  Background:
    Given I navigate to https://www.tenders.gov.au/standing-offer

  @BasicFormValidation
  Scenario: Validate presence and visibility of all form fields
    Then I should see the heading Standing Offer Notices
    And I should see the page description containing "The Notice displays the details"
    And I should see the textbox Keyword
    And I should see the textbox SON ID
    And I should see the dropdown Status
    And I should see the dropdown Multi Agency Access
    And I should see the dropdown Panel Arrangement
    And I should see the textbox Supplier Name
    And I should see the textbox Supplier ABN
    And I should see the dropdown Category
    And I should see the textbox ATM ID
    And I should see the textbox Agency Reference ID
    And I should see the button View

  @SearchUsingKeywordAndSONID
  Scenario: Search using keyword and SON ID fields
    When I Enter "health" in the textbox Keyword
    And I Enter "SON0472331" in the textbox SON ID
    And I Click on the button View
    Then I should see the text "Results" on the page

  @FilterByStatusDateRange
  Scenario: Use Status filter and date range to filter results
    When I Click on the radio button Closed
    And I Enter "01-01-2024" in the textbox from date
    And I Enter "31-12-2024" in the textbox to date
    And I Click on the button View
    Then I should see the text "Results" on the page

  @FilterBySupplierAndABN
  Scenario: Use supplier name and ABN for search
    When I Enter "Sparke Helmore" in the textbox Supplier Name
    And I Enter "78848387938" in the textbox Supplier ABN
    And I Click on the button View
    Then I should see the text "Results" on the page

  @FilterUsingDropdowns
  Scenario: Apply dropdown filters for category and arrangement
    When I select "Consultancy Services" from the dropdown Category
    And I select "Yes" from the dropdown Multi Agency Access
    And I select "Panel" from the dropdown Panel Arrangement
    And I Click on the button View
    Then I should see the text "Results" on the page
