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

not_run: CucumberKW.runFeatureFile('Include/features/SCRUM-68 Senate Order Viewing.feature')

not_run: CucumberKW.runFeatureFile('Include/features/SCRUM-68 Senate Order Viewing.feature')

WebUI.openBrowser('')

WebUI.navigateToUrl('https://www.tenders.gov.au/')

WebUI.click(findTestObject('Object Repository/AusTender/Page_AusTender Homepage AusTender/a_Standing Offers'))

WebUI.click(findTestObject('Object Repository/AusTender/Page_Standing Offer Notices AusTender/span_13-Apr-2025 to 19-Apr-2025'))

WebUI.click(findTestObject('Object Repository/AusTender/Page_Standing Offer Notices AusTender/span_30-Mar-2025 to 05-Apr-2025'))

WebUI.selectOptionByValue(findTestObject('Object Repository/AusTender/Page_Standing Offer Notices AusTender/select_13-Apr-2025 to 19-Apr-202506-Apr-202_2ac82c'), 
    '30-Mar-2025,05-Apr-2025', true)

WebUI.click(findTestObject('Object Repository/AusTender/Page_Standing Offer Notices AusTender/button_View'))

WebUI.click(findTestObject('Object Repository/AusTender/Page_Standing Offer Notice List AusTender/a_SON4139337'))

WebUI.click(findTestObject('Object Repository/AusTender/Page_Standing Offer Notice View - SON413933_6dafb6/a_Current Suppliers (2)'))

WebUI.click(findTestObject('Object Repository/AusTender/Page_Standing Offer Notice View - SON413933_6dafb6/a_Previous Suppliers'))

WebUI.click(findTestObject('Object Repository/AusTender/Page_Standing Offer Notice View - SON413933_6dafb6/a_Participant Agencies'))

WebUI.click(findTestObject('Object Repository/AusTender/Page_Standing Offer Notice View - SON413933_6dafb6/a_Standing Offer Notice List'))

WebUI.click(findTestObject('Object Repository/AusTender/Page_Standing Offer Notice List AusTender/a_Standing Offers'))

WebUI.closeBrowser()

