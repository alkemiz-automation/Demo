Feature: Contract Notice Search and Results
URL: [[https://www.tenders.gov.au/cn/search|https://www.tenders.gov.au/cn/search]|https://www.tenders.gov.au/cn/search%7Chttps://www.tenders.gov.au/cn/search%5D]
Scenario: Search Contract Notices by Date
Given I Navigate to https://www.tenders.gov.au/cn/search
When I select 'Publish Date' and input date range '01/01/2024 to 31/03/2025'
And I Click on the button View
Then I should see a list of contract notices with publish date, agency, and value
Scenario: Advanced Search with Supplier Name
Given I am on the Contract Notice search page
When I Enter 'Dynamic Aspect' in the Supplier Name textbox
And I Click on the search button
Then I should see results matching the supplier with their respective CN ID and Contract Value