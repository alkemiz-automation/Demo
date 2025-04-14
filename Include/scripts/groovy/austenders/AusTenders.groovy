package austenders
import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject

import com.kms.katalon.core.annotation.Keyword
import com.kms.katalon.core.checkpoint.Checkpoint
import com.kms.katalon.core.checkpoint.CheckpointFactory
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
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



class AusTenders {
	/**
	 * The step definitions below match with Katalon sample Gherkin steps
	 */
	@Then("I should see a list of ATM records displayed")
def verifyATMListDisplayed() {
    TestObject listLocator = findTestObject('1. Generic/WebTextElement', [('ObjectName'): 'atm records']) // adjust locator
    WebUI.verifyElementVisible(listLocator)
}


	@Then("I should see text '(.*)' on each record")
def verifyTextOnEachRecord(String expectedText) {
    WebDriver driver = DriverFactory.getWebDriver()
    List<WebElement> elements = driver.findElements(By.xpath("//*[contains(text(), '${expectedText}')]"))
    assert elements.size() > 0 : "Expected text not found on any record"
}


@Then("I should see the ATM ID, Agency, Category, and Description for each record")
def verifyATMCardDetailsDisplayed() {
	List<String> labels = ['ATM ID', 'Agency', 'Category', 'Description']
	WebDriver driver = DriverFactory.getWebDriver()
	labels.each {
		List<WebElement> elements = driver.findElements(By.xpath("//*[contains(text(),'${it}')]"))
		assert elements.size() > 0 : "Missing expected label: ${it}"
	}
}

@Then("each ATM record should have a Full Details link")
def verifyFullDetailsLinkExists() {
	WebDriver driver = DriverFactory.getWebDriver()
	List<WebElement> links = driver.findElements(By.xpath("//a[contains(text(),'Full Details')]"))
	assert links.size() > 0 : "Full Details link not found on ATM records"
}


}