import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import static com.kms.katalon.core.testobject.ObjectRepository.findWindowsObject
import com.kms.katalon.core.checkpoint.Checkpoint as Checkpoint
import com.kms.katalon.core.cucumber.keyword.CucumberBuiltinKeywords as CucumberKW
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.model.FailureHandling as FailureHandling
import com.kms.katalon.core.testcase.TestCase as TestCase
import com.kms.katalon.core.testdata.TestData as TestData
import com.kms.katalon.core.testng.keyword.TestNGBuiltinKeywords as TestNGKW
import com.kms.katalon.core.testobject.TestObject as TestObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.core.windows.keyword.WindowsBuiltinKeywords as Windows
import internal.GlobalVariable as GlobalVariable
import org.openqa.selenium.Keys as Keys

WebUI.openBrowser('')

WebUI.navigateToUrl('https://www.tenders.gov.au/')

WebUI.verifyElementText(findTestObject('Object Repository/AusTender/Page_AusTender Homepage AusTender/h1_Welcome to the Australian Governments pr_7a1f86'), 
    'Welcome to the Australian Government\'s procurement information system')

not_run: WebUI.verifyElementText(findTestObject('Object Repository/AusTender/Page_AusTender Homepage AusTender/p_AusTender provides centralised publicatio_944297'), 
    'AusTender provides centralised publication of Australian Government business opportunities, annual procurement plans and contracts awarded. For more information visit AusTender Help and Information Centre.')

WebUI.verifyElementText(findTestObject('Object Repository/AusTender/Page_AusTender Homepage AusTender/div_Due to Good Friday and Easter public ho_5090eb'), 
    'Due to Good Friday and Easter public holiday, the AusTender Helpdesk will be unavailable between Friday 18 April 2025 - Monday 21 April 2025. \nThe AusTender Helpdesk will recommence on Tuesday 22 April 2025, 9:00am (AEST).')

WebUI.verifyElementText(findTestObject('Object Repository/AusTender/Page_AusTender Homepage AusTender/h2_Business Opportunities'), 
    'Business Opportunities')

WebUI.verifyElementPresent(findTestObject('Object Repository/AusTender/Page_AusTender Homepage AusTender/a_Find Business Opportunities'), 
    0)

WebUI.verifyElementPresent(findTestObject('Object Repository/AusTender/Page_AusTender Homepage AusTender/a_State and Territory Opportunties'), 
    0)

WebUI.verifyElementPresent(findTestObject('Object Repository/AusTender/Page_AusTender Homepage AusTender/a_Trading Partner Opportunities'), 
    0)

WebUI.verifyElementPresent(findTestObject('Object Repository/AusTender/Page_AusTender Homepage AusTender/span_Panel Buyers'), 
    0)

WebUI.verifyElementPresent(findTestObject('Object Repository/AusTender/Page_AusTender Homepage AusTender/span_Reports'), 
    0)

WebUI.verifyElementPresent(findTestObject('Object Repository/AusTender/Page_AusTender Homepage AusTender/span_Multi Agency Access'), 
    0)

WebUI.click(findTestObject('Object Repository/AusTender/Page_AusTender Homepage AusTender/a_Approaches to Market'))

WebUI.verifyElementPresent(findTestObject('Object Repository/AusTender/Page_Current ATM List AusTender/input_Keyword_Keyword'), 
    0)

WebUI.setText(findTestObject('Object Repository/AusTender/Page_Current ATM List AusTender/input_Keyword_Keyword'), 'education')

WebUI.click(findTestObject('Object Repository/AusTender/Page_Current ATM List AusTender/i'))

WebUI.click(findTestObject('Object Repository/AusTender/Page_Current ATM List AusTender/a_PRN2025-032'))

WebUI.verifyElementText(findTestObject('Object Repository/AusTender/Page_Current ATM View - PRN2025-032 AusTender/div_86000000 - Education and Training Services'), 
    '86000000 - Education and Training Services')

WebUI.verifyElementPresent(findTestObject('Object Repository/AusTender/Page_Current ATM View - PRN2025-032 AusTender/p_Contact Details'), 
    0)

WebUI.verifyElementPresent(findTestObject('Object Repository/AusTender/Page_Current ATM View - PRN2025-032 AusTender/a_ATM Documents'), 
    0)

WebUI.verifyElementPresent(findTestObject('Object Repository/AusTender/Page_Current ATM View - PRN2025-032 AusTender/a_Lodgement Page'), 
    0)

WebUI.click(findTestObject('Object Repository/AusTender/Page_Current ATM View - PRN2025-032 AusTender/a_ATM Documents'))

WebUI.click(findTestObject('Object Repository/AusTender/Page_ATM Documents - PRN2025-032 AusTender/li_ATM Documents - PRN2025-032'))

WebUI.click(findTestObject('Object Repository/AusTender/Page_ATM Documents - PRN2025-032 AusTender/a_Current ATM View - PRN2025-032'))

WebUI.click(findTestObject('Object Repository/AusTender/Page_Current ATM View - PRN2025-032 AusTender/a_Lodgement Page'))

WebUI.click(findTestObject('Object Repository/AusTender/Page_Lodge a Response - PRN2025-032 AusTender/a_Current ATM View - PRN2025-032'))

WebUI.click(findTestObject('Object Repository/AusTender/Page_Current ATM View - PRN2025-032 AusTender/a_View Addenda'))

WebUI.click(findTestObject('Object Repository/AusTender/Page_ATM Documents - PRN2025-032 AusTender/a_Current ATM View - PRN2025-032'))

WebUI.closeBrowser()

