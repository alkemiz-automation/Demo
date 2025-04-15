package generic
import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject

import com.kms.katalon.core.annotation.Keyword
import com.kms.katalon.core.checkpoint.Checkpoint
import com.kms.katalon.core.checkpoint.CheckpointFactory
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords
import com.kms.katalon.core.model.FailureHandling
import com.kms.katalon.core.testcase.TestCase
import com.kms.katalon.core.testcase.TestCaseFactory
import com.kms.katalon.core.testdata.TestData
import com.kms.katalon.core.testdata.TestDataFactory
import com.kms.katalon.core.testobject.ObjectRepository
import com.kms.katalon.core.testobject.TestObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI

import internal.GlobalVariable

import org.openqa.selenium.WebElement
import org.openqa.selenium.WebDriver
import org.openqa.selenium.By

import com.kms.katalon.core.mobile.keyword.internal.MobileDriverFactory
import com.kms.katalon.core.webui.driver.DriverFactory

import com.kms.katalon.core.testobject.RequestObject
import com.kms.katalon.core.testobject.ResponseObject
import com.kms.katalon.core.testobject.ConditionType
import com.kms.katalon.core.testobject.TestObjectProperty

import com.kms.katalon.core.mobile.helper.MobileElementCommonHelper
import com.kms.katalon.core.util.KeywordUtil

import com.kms.katalon.core.webui.exception.WebElementNotFoundException

import cucumber.api.java.en.And
import cucumber.api.java.en.Given
import cucumber.api.java.en.Then
import cucumber.api.java.en.When

class GenericSteps {

	TestObject ObjectLocator

	// =============================
	// Navigation Steps
	// =============================

	@Given("I Navigate to (.*)")
	def I_Navigate_To(String URL) {
		WebUI.comment("Navigating to URL: $URL")
		GenericActions.openBrowser(URL)
		try {
			WebUI.takeScreenshotAsCheckpoint('full_view')
		} catch(Exception e) {
			KeywordUtil.logInfo('Error capturing screenshot')
			throw e
		}
	}

	// =============================
	// Validation Steps
	// =============================

	@Then("I should see the heading (.*)")
	def verifyPageHeading(String expectedHeading) {
		getObject("pageheading", expectedHeading)
		GenericActions.verifyHeading(ObjectLocator, expectedHeading)
	}

	@Given("I am on the ATM listing page")
	def navigateToATMListing() {
		String atmListingUrl = "https://www.tenders.gov.au/atm"
		WebUI.comment("Navigating to ATM Listing Page: $atmListingUrl")
		//GenericActions.openUrl(atmListingUrl)

		// Optional: verify we're on the correct page
		TestObject atmHeading = findTestObject('1. Generic/WebPageHeading', [('ObjectName'): 'approaches to market'])
		GenericActions.verifyHeading(atmHeading, "Approaches to Market")
	}


	@Then("I should see the page description containing (.*)")
	def verifyPageDescription(String expectedDescription) {
		getObject("pagedescription", expectedDescription)
		GenericActions.verifyDescription(ObjectLocator, expectedDescription)
	}

	@Then("I verify page heading is (.*)")
	def verifyExactPageHeading(String expectedHeading) {
		getObject("pageheading", expectedHeading)
		GenericActions.verifyHeading(ObjectLocator, expectedHeading)
	}

	@Then("I verify page description contains (.*)")
	def verifyExactPageDescription(String expectedDescription) {
		getObject("pagedescription", expectedDescription)
		GenericActions.verifyDescription(ObjectLocator, expectedDescription)
	}
	@Then("I should see the text (.*) on the page")
	def verifyTextOnPage(String expectedText) {
		getObject("textelement", expectedText)
		GenericActions.verifyText(ObjectLocator, expectedText)
	}

	@Then("I verify image (.*)")
	def verifyNamedImageDisplayed(String imageAltText) {
		getObject("image", imageAltText)
		GenericActions.verifyImagePresent(ObjectLocator)
	}

	@Then("I should see the image (.*)")
	def verifyImageDisplayed(String imageAltText) {
		getObject("image", imageAltText)
		GenericActions.verifyImagePresent(ObjectLocator)
	}

	@Then("I verify text element (.*)")
	def verifyTextElement(String expectedText) {
		getObject("textelement", expectedText)
		GenericActions.verifyText(ObjectLocator, expectedText)
	}

	@Then("I should see a list of contract notices with publish date, agency, and value")
	def verifyContractNoticesSummaryList() {
		WebUI.comment("Verifying contract notices list displays with key details")

		List<String> expectedColumns = [
			"Publish Date",
			"Agency",
			"Value"
		]
		for (String label : expectedColumns) {
			getObject("textelement", label)
			GenericActions.verifyText(ObjectLocator, label)
		}

		WebUI.comment("Verified contract notices list with Publish Date, Agency, and Value")
	}

	@Given("I am on the Contract Notice search page")
	def navigateViaMenuToContractNoticeSearchPage() {
		getObject("menu", "Contract Notices")
		GenericActions.click(ObjectLocator)
	}
	
	@Then("I should see a list of Senate Order reports")
	def verifySenateOrderReportListDisplayed() {
		WebUI.comment("Verifying list of Senate Order reports is displayed")
	
		getObject("textelement", "Senate Order")
		GenericActions.verifyText(ObjectLocator, "Senate Order")
	
		// Optional: validate table or grid exists (if it's a structured element)
		getObject("default", "ReportTable") // assuming "ReportTable" is a fallback locator for list container
		GenericActions.verifyElementVisible(ObjectLocator)
	}
	
	@Then("I should see results with Agency name, Procurement Title and Status")
	def verifyATMResultsWithAgencyTitleStatus() {
		WebUI.comment("Verifying ATM results show Agency, Procurement Title and Status fields")
	
		List<String> expectedLabels = ["Agency", "Procurement Title", "Status"]
	
		for (String label : expectedLabels) {
			getObject("textelement", label)
			GenericActions.verifyText(ObjectLocator, label)
		}
	}
	
	@Then("I should see textboxes for Email, Password, Confirm Password, Organisation Name, and Contact Details")
	def verifyRegistrationTextboxes() {
		WebUI.comment("Verifying all required textboxes on Registration form")
	
		List<String> textboxLabels = [
			"Email", "Password", "Confirm Password",
			"Organisation Name", "Contact Details"
		]
	
		for (String label : textboxLabels) {
			getObject("textbox", label)
			GenericActions.verifyElementVisible(ObjectLocator)
		}
	}
	
	@Then("I should see the Register button")
	def verifyRegisterButton() {
		WebUI.comment("Verifying the Register button is present")
	
		getObject("button", "Register")
		GenericActions.verifyElementVisible(ObjectLocator)
	}
	
	
	
	@Then("each row should display Agency, Date Published, and PDF Excel links")
	def verifySenateOrderRowDetails() {
		WebUI.comment("Verifying each row contains Agency, Date Published, and PDF/Excel download links")
	
		List<String> expectedLabels = ["Agency", "Date Published", "PDF", "Excel"]
	
		for (String label : expectedLabels) {
			getObject("textelement", label)
			GenericActions.verifyText(ObjectLocator, label)
		}
	
		WebUI.comment("Confirmed presence of expected Senate Order row labels and download options")
	}
	
	
	@When("I select '(.*)' and input date range '(.*) to (.*)'")
	def selectDateFilterAndInputRange(String filterLabel, String startDate, String endDate) {
		WebUI.comment("Selecting filter: $filterLabel and entering date range: $startDate to $endDate")

		// Step 1: Click on the filter dropdown or tab
		getObject("menu", filterLabel)
		GenericActions.click(ObjectLocator)

		// Step 2: Enter Start Date
		getObject("textbox", "start date")
		GenericActions.inputText(ObjectLocator, startDate)

		// Step 3: Enter End Date
		getObject("textbox", "end date")
		GenericActions.inputText(ObjectLocator, endDate)

		WebUI.comment("Date range entered successfully for filter $filterLabel")
	}


	@Then("I should see results matching the supplier with their respective CN ID and Contract Value")
	def verifySupplierSearchResults() {
		WebUI.comment("Verifying supplier search results with CN ID and Contract Value")

		List<String> expectedFields = ["CN ID", "Contract Value"]
		for (String field : expectedFields) {
			getObject("textelement", field)
			GenericActions.verifyText(ObjectLocator, field)
		}

		WebUI.comment("Verified supplier result fields: CN ID and Contract Value")
	}


	// =============================
	// Form Input & Interaction Steps
	// =============================

	@When("I Click on the (.*) (.*)")
	def clickOnObject(String ObjectType, String ObjectName) {
		getObject(ObjectType, ObjectName)
		GenericActions.click(ObjectLocator)
	}

	@When("I Enter (.*) in the ([A-Za-z]*) (.*)")
	def enterValueIntoObject(String DataValue, String ObjectType, String ObjectName) {
		getObject(ObjectType, ObjectName)
		GenericActions.inputText(ObjectLocator, DataValue)
	}

	@When("I select (.*) from ([A-Za-z]*) (.*)")
	def selectDropdownValue(String DataValue, String ObjectType, String ObjectName) {
		getObject("dropdown", ObjectName)
		GenericActions.click(ObjectLocator)
		getObject("dropdownitem", DataValue)
		GenericActions.click(ObjectLocator)
	}

	@Then("I Click on the checkbox (.*)")
	def clickCheckbox(String checkboxLabel) {
		getObject("checkbox", checkboxLabel)
		GenericActions.click(ObjectLocator)
	}

	@Then("I Click on the radio button (.*)")
	def clickRadioButton(String radioLabel) {
		getObject("radiobutton", radioLabel)
		GenericActions.click(ObjectLocator)
	}

	// =============================
	// Object Resolution Helper
	// =============================

	def getObject(String ObjectType, String ObjectName) {
		switch(ObjectType.toLowerCase()) {
			case "textbox":
				ObjectLocator = findTestObject('1. Generic/WebTextBox', [('ObjectName'): ObjectName.toLowerCase()])
				break
			case "button":
				ObjectLocator = findTestObject('1. Generic/WebButton', [('ObjectName'): ObjectName.toLowerCase()])
				break
			case "link":
				ObjectLocator = findTestObject('1. Generic/WebLink', [('ObjectName'): ObjectName.toLowerCase()])
				break
			case "menu":
				ObjectLocator = findTestObject('1. Generic/WebMenu', [('ObjectName'): ObjectName.toLowerCase()])
				break
			case "sidemenu":
			case "side menu":
				ObjectLocator = findTestObject('1. Generic/WebSideNavigation', [('ObjectName'): ObjectName.toLowerCase()])
				break
			case "dropdown":
				ObjectLocator = findTestObject('1. Generic/WebDropdown', [('ObjectName'): ObjectName.toLowerCase()])
				break
			case "dropdownitem":
				ObjectLocator = findTestObject('1. Generic/WebDropdownItem', [('ObjectName'): ObjectName.toLowerCase()])
				break
			case "textarea":
				ObjectLocator = findTestObject('1. Generic/WebTextArea', [('ObjectName'): ObjectName.toLowerCase()])
				break
			case "textelement":
				ObjectLocator = findTestObject('1. Generic/WebTextElement', [('ObjectName'): ObjectName.toLowerCase()])
				break
			case "radiobutton":
				ObjectLocator = findTestObject('1. Generic/WebRadioButton', [('ObjectName'): ObjectName.toLowerCase()])
				break
			case "checkbox":
				ObjectLocator = findTestObject('1. Generic/WebCheckBox', [('ObjectName'): ObjectName.toLowerCase()])
				break
			case "image":
				ObjectLocator = findTestObject('1. Generic/WebImage', [('ObjectName'): ObjectName.toLowerCase()])
				break
			case "pageheading":
				ObjectLocator = findTestObject('1. Generic/WebPageHeading', [('ObjectName'): ObjectName.toLowerCase()])
				break
			case "pagedescription":
				ObjectLocator = findTestObject('1. Generic/WebPageDesciption', [('ObjectName'): ObjectName.toLowerCase()])
				break
			default:
				ObjectLocator = findTestObject('1. Generic/WebDefault', [('ObjectName'): ObjectName.toLowerCase()])
				break
		}
		println "Created object for $ObjectType: $ObjectLocator"
	}
}