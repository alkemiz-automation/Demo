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

not_run: CucumberKW.runFeatureFile('Include/features/SCRUM-66 Approaches to Market Listing.feature')

not_run: CucumberKW.runFeatureFile('Include/features/SCRUM-66 Approaches to Market Listing.feature')

WebUI.openBrowser('')

WebUI.navigateToUrl('https://www.tenders.gov.au/')

WebUI.click(findTestObject('Object Repository/AusTender/Page_AusTender Homepage AusTender/a_Approaches to Market'))

WebUI.verifyElementText(findTestObject('Object Repository/AusTender/Page_Current ATM List AusTender/p_Provision of Security Risk Assessment Services'), 
    'Provision of Security Risk Assessment Services')

WebUI.verifyElementPresent(findTestObject('Object Repository/AusTender/Page_Current ATM List AusTender/span_Close Date  Time - Ascending'), 
    0)

WebUI.click(findTestObject('Object Repository/AusTender/Page_Current ATM List AusTender/span_Close Date  Time - Ascending'))

WebUI.click(findTestObject('Object Repository/AusTender/Page_Current ATM List AusTender/a_Title'))

WebUI.selectOptionByValue(findTestObject('Object Repository/AusTender/Page_Current ATM List AusTender/select_Close Date  Time - Ascending        _3f828b'), 
    'Title', true)

WebUI.click(findTestObject('Object Repository/AusTender/Page_Current ATM List AusTender/button_Sort'))

WebUI.verifyElementText(findTestObject('Object Repository/AusTender/Page_Current ATM List AusTender/p_ADFA Library Minor Refurbishment, ACT'), 
    'ADFA Library Minor Refurbishment, ACT')

WebUI.setText(findTestObject('Object Repository/AusTender/Page_Current ATM List AusTender/input_Keyword_Keyword'), 'education')

WebUI.click(findTestObject('Object Repository/AusTender/Page_Current ATM List AusTender/button_Search'))

WebUI.click(findTestObject('Object Repository/AusTender/Page_Current ATM List AusTender/a_PROC2010'))

WebUI.rightClick(findTestObject('Object Repository/AusTender/Page_Current ATM View - PROC2010 AusTender/a_ATM Documents'))

WebUI.click(findTestObject('Object Repository/AusTender/Page_Current ATM View - PROC2010 AusTender/a_ATM Documents'))

WebUI.click(findTestObject('Object Repository/AusTender/Page_ATM Documents - PROC2010 AusTender/a_Current ATM View - PROC2010'))

WebUI.click(findTestObject('Object Repository/AusTender/Page_Current ATM View - PROC2010 AusTender/a_Lodgement Page'))

WebUI.click(findTestObject('Object Repository/AusTender/Page_Lodge a Response - PROC2010 AusTender/a_Current ATM View - PROC2010'))

WebUI.rightClick(findTestObject('Object Repository/AusTender/Page_Current ATM View - PROC2010 AusTender/a_View Addenda'))

WebUI.click(findTestObject('Object Repository/AusTender/Page_Current ATM View - PROC2010 AusTender/a_View Addenda'))

WebUI.click(findTestObject('Object Repository/AusTender/Page_ATM Documents - PROC2010 AusTender/a_Current ATM View - PROC2010'))

