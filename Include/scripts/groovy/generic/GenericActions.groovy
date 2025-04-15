/*
 *  Provide generic actions for web automation tasks.
 *
 *      - First method: openBrowser
 *          - Parameters:
 *              - String url: the URL to navigate to
 *          - Steps:
 *              Open a browser, navigate to the specified URL, and maximize the window. Log an error if any exception occurs.
 *      - Second method: inputText
 *          - Parameters:
 *              - TestObject to: the test object where text will be input
 *              - String value: the text value to input
 *          - Steps:
 *              Wait for the element to be visible, highlight it, clear any existing text, and send the new text value. Log an error if any exception occurs.
 *      - Third method: click
 *          - Parameters:
 *              - TestObject to: the test object to click
 *          - Steps:
 *              Wait for the element to be clickable, highlight it, and perform the click action. Log an error if any exception occurs.
 *      - Fourth method: selectDropdownItem
 *          - Parameters:
 *              - String dropdownLocator: the locator for the dropdown
 *              - String itemLabel: the label of the item to select
 *          - Steps:
 *              Click the dropdown, find the item by its label using XPath, and click the item. Log an error if any exception occurs.
 *      - Fifth method: verifyText
 *          - Parameters:
 *              - TestObject to: the test object to verify text
 *              - String expectedText: the expected text to verify
 *          - Steps:
 *              Wait for the element to be visible, get the actual text, and assert that it contains the expected text. Log an error if any exception occurs.
 *      - Sixth method: verifyExactText
 *          - Parameters:
 *              - TestObject to: the test object to verify exact text
 *              - String expectedText: the expected exact text to verify
 *          - Steps:
 *              Wait for the element to be visible, get the actual text, and assert that it matches the expected text exactly. Log an error if any exception occurs.
 *      - Seventh method: verifyImage
 *          - Parameters:
 *              - TestObject to: the test object representing the image
 *              - String altText: the alternative text for the image (optional)
 *          - Steps:
 *              Verify that the image element is visible and highlight it. Log an error if any exception occurs.
 *      - Eighth method: checkCheckbox
 *          - Parameters:
 *              - TestObject to: the test object representing the checkbox
 *          - Steps:
 *              Wait for the checkbox to be visible, check if it is not already checked, and click it if necessary. Log an error if any exception occurs.
 *      - Ninth method: selectRadioButton
 *          - Parameters:
 *              - TestObject to: the test object representing the radio button
 *          - Steps:
 *              Wait for the radio button to be visible and click it. Log an error if any exception occurs.
 *      - Tenth method: verifyHeading
 *          - Parameters:
 *              - TestObject to: the test object representing the heading
 *              - String expected: the expected heading text
 *          - Steps:
 *              Call verifyExactText method to validate the heading text.
 *      - Eleventh method: verifyDescription
 *          - Parameters:
 *              - TestObject to: the test object representing the description
 *              - String expected: the expected description text
 *          - Steps:
 *              Call verifyText method to validate the description text.
 */
package generic

import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import com.kms.katalon.core.webui.driver.DriverFactory
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.core.testobject.TestObject
import com.kms.katalon.core.logging.KeywordLogger
import org.openqa.selenium.By
import org.openqa.selenium.WebDriver
import org.openqa.selenium.WebElement

class GenericActions {

	static KeywordLogger log = new KeywordLogger()
	static int defaultWait = 10

	static void openBrowser(String url) {
		try {
			WebUI.openBrowser('')
			WebUI.navigateToUrl(url)
			WebUI.maximizeWindow()
		} catch (Exception e) {
			log.logError("❌ Failed to open browser at URL: $url", e)
			throw e
		}
	}

	static void inputText(TestObject to, String value) {
		try {
			WebUI.waitForElementVisible(to, defaultWait)
			WebUI.highlight(to)
			WebUI.clearText(to)
			WebUI.sendKeys(to, value)
		} catch (Exception e) {
			log.logError("❌ Error inputting text in object: $to", e)
			WebUI.takeScreenshot()
			throw e
		}
	}

	static void click(TestObject to) {
		try {
			WebUI.waitForElementClickable(to, defaultWait)
			WebUI.highlight(to)
			WebUI.click(to)
		} catch (Exception e) {
			log.logError("❌ Error clicking object: $to", e)
			WebUI.takeScreenshot()
			throw e
		}
	}

	static void selectDropdownItem(String dropdownLocator, String itemLabel) {
		try {
			click(findTestObject(dropdownLocator))
			WebDriver driver = DriverFactory.getWebDriver()
			WebElement item = driver.findElement(By.xpath("//ul[contains(@class,'dropdown-menu')]//span[text()='" + itemLabel + "']"))
			item.click()
		} catch (Exception e) {
			log.logError("❌ Failed to select dropdown item: $itemLabel", e)
			WebUI.takeScreenshot()
			throw e
		}
	}

	static void verifyText(TestObject to, String expectedText) {
		try {
			WebUI.waitForElementVisible(to, defaultWait)
			String actual = WebUI.getText(to).trim()
			assert actual.contains(expectedText) : "❌ Expected: '$expectedText' but found: '$actual'"
		} catch (Exception e) {
			log.logError("❌ Text validation failed for: $to", e)
			WebUI.takeScreenshot()
			throw e
		}
	}

	static void verifyExactText(TestObject to, String expectedText) {
		try {
			WebUI.waitForElementVisible(to, defaultWait)
			String actual = WebUI.getText(to).trim()
			assert actual == expectedText : "❌ Expected exact text: '$expectedText' but found: '$actual'"
		} catch (Exception e) {
			log.logError("❌ Exact text validation failed for: $to", e)
			WebUI.takeScreenshot()
			throw e
		}
	}

	static void verifyImage(TestObject to, String altText = "") {
		try {
			WebUI.verifyElementVisible(to)
			WebUI.highlight(to)
		} catch (Exception e) {
			log.logError("❌ Image not found: $altText", e)
			WebUI.takeScreenshot()
			throw e
		}
	}

	static void checkCheckbox(TestObject to) {
		try {
			WebUI.waitForElementVisible(to, defaultWait)
			if (!WebUI.isChecked(to)) {
				WebUI.click(to)
			}
		} catch (Exception e) {
			log.logError("❌ Error checking checkbox: $to", e)
			WebUI.takeScreenshot()
			throw e
		}
	}

	static void selectRadioButton(TestObject to) {
		try {
			WebUI.waitForElementVisible(to, defaultWait)
			WebUI.click(to)
		} catch (Exception e) {
			log.logError("❌ Error selecting radio button: $to", e)
			WebUI.takeScreenshot()
			throw e
		}
	}

	static void verifyHeading(TestObject to, String expected) {
		verifyExactText(to, expected)
	}

	static void verifyDescription(TestObject to, String expected) {
		verifyText(to, expected)
	}
}

