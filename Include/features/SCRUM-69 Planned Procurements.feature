Feature: Planned Procurements
URL: [https://www.tenders.gov.au/app/list|https://www.tenders.gov.au/app/list]
Scenario: Search Planned Procurements
Given I Navigate to https://www.tenders.gov.au/app/list
When I Enter 'Infrastructure' in the textbox Keyword
And I select 'Department of Infrastructure' from the Agency dropdown
And I Click on the Search button
Then I should see results with Agency name, Procurement Title and Status