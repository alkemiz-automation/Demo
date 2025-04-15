Feature: Senate Order Viewing
URL: [https://www.tenders.gov.au/senateorder/list|https://www.tenders.gov.au/senateorder/list]
Scenario: Verify Senate Order Listings
Given I Navigate to https://www.tenders.gov.au/senateorder/list
Then I should see a list of Senate Order reports
And each row should display Agency, Date Published, and PDF Excel links