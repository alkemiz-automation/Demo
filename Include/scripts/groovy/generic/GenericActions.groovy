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
