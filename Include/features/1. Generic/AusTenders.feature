#Author: bharat.sethi@espireinfo.com.au
#Keywords Summary : Generic Steps to validate the Test Framework on AusTender
#Feature: Verifies all generic Katalon objects on the site
#Comments: This feature verifies navigation, input, dropdown, button, image, and heading objects
#Tags: @GenericFeature
@AusTenderValidation
Feature: Validate Generic Objects Using Katalon Framework
  This feature validates all the generic object definitions for the AusTender website.

  Background: 
    Given I Navigate to https://www.tenders.gov.au/

  @VerifyAllGenericObjects
  Scenario: Navigate and verify all generic objects work correctly
    When I Click on the Planned Procurements menu
    Then I should see the heading Planned Procurements
    And I should see the page description containing Agencies' Planned Procurements
    When I select Attorney-General's Department from the Agency dropdown
    And I Click on the button Search
    Then I should see the text "Results" on the page
    When I Click on the "Info & Links" menu
    And I Click on the side navigation "Policy Documents"
    Then I should see the heading "Policy Documents"
    When I Enter "This is a test" in the textarea Comments
    And I Enter "Test User" in the textbox Name
    And I Click on the checkbox I agree to the terms
    And I Click on the radio button Yes
    And I Click on the button Submit
    Then I should see the text "Thank you for your feedback" on the page
    And I should see the image "Australian Government"
    And I should see the image "AusTender"

  @DataDrivenValidation
  Scenario Outline: Validate multiple dropdown selections and inputs
    Given I Navigate to https://www.tenders.gov.au/app/list
    When I Enter <searchText> in the textbox Keyword
    And I select <agency> from the "Agency" dropdown
    And I Click on the button Search
    Then I should see the text <expectedResult> on the page

    Examples: 
      | searchText  | agency                          | expectedResult |
      | procurement | Austrade                        | Procurement    |
      | finance     | Department of Finance           | Finance        |
      | statistics  | Australian Bureau of Statistics | Statistics     |

  @BasicGenericTest
  Scenario: Validate navigation and interaction with all generic objects
    Given I Navigate to https://www.tenders.gov.au/
    Then I Click on the menu Approaches to Market
    And I Click on the menu Contract Notices
    And I Click on the menu Standing Offers
    And I Click on the menu Planned Procurements
    And I Click on the menu Senate Order
    Then I Click on the link Help
    Then I Click on the menu Info & Links
    Then I Click on the side menu Agency Addresses
    And I Click on the side menu Policy Documents
    And I verify image Australian Government
    And I verify image AusTender
    And I Enter "Test Search" in the textbox Keyword
    And I Enter "Comments about agency" in the textarea comments
    And I select "Australian Bureau of Statistics" from the "Agency" dropdown
    And I Click on the button Search
    Then I verify text element "Contract Notices"
    And I verify page heading is "Contract Notices"
    And I verify page description contains "Contract Notice (CN)"

  @GenericScenarioWithData
  Scenario Outline: Fill search form and validate result
    Given I Navigate to https://www.tenders.gov.au/
    When I Enter <keyword> in the textbox Keyword
    And I Enter <comment> in the textarea comments
    And I select <agency> from the "Agency" dropdown
    And I Click on the button Search
    Then I verify text element <expectedText>
    And I verify image AusTender

    Examples: 
      | keyword        | comment                  | agency                       | expectedText   |
      | Defence        | Defence related comment  | Department of Defence        | Defence        |
      | Infrastructure | Rail project information | Department of Infrastructure | Infrastructure |
      | Education      | School facilities tender | Department of Education      | Education      |
