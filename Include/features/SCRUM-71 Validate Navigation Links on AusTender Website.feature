@Navigation
Feature: Validate Navigation Links on AusTender Website

  Background: 
    Given I Navigate to [https://www.tenders.gov.au/|https://www.tenders.gov.au/]

  @TopNavigation
  Scenario: Validate Top Menu Navigation Works
    When I Click on the menu Approaches to Market
    Then I should see the heading Current ATM List
    When I Click on the menu Contract Notices
    Then I should see the heading Contract Notices
    When I Click on the menu Standing Offers
    Then I should see the heading Standing Offers
    When I Click on the menu Planned Procurements
    Then I should see the heading Planned Procurements
    When I Click on the menu Senate Order
    Then I should see the heading Senate Order
    When I Click on the menu Help
    Then I should see the heading Help

  @SideNavigation
  Scenario: Validate Side Navigation Links Work
    Given I Navigate to [https://www.tenders.gov.au/|https://www.tenders.gov.au/]
    When I Click on the menu Info & Links
    And I Click on the side menu Agency Addresses
    Then I should see the heading Agency Addresses
    When I Click on the side menu Policy Documents
    Then I should see the heading Policy Documents
