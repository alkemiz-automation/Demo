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

not_run: CucumberKW.runFeatureFile('Include/features/SCRUM-69 Planned Procurements.feature')

WebUI.openBrowser('')

WebUI.navigateToUrl('https://www.tenders.gov.au/')

WebUI.click(findTestObject('Object Repository/AusTender/Page_AusTender Homepage AusTender/a_Planned Procurements'))

WebUI.click(findTestObject('Object Repository/AusTender/Page_Annual Procurement Plan List AusTender/i'))

WebUI.click(findTestObject('Object Repository/AusTender/Page_Annual Procurement Plan List AusTender/a_South Bandiana Building Works, VIC'))

WebUI.click(findTestObject('Object Repository/AusTender/Page_Current ATM View - EST10524 AusTender/a_Annual Procurement Plan List'))

WebUI.click(findTestObject('Object Repository/AusTender/Page_Annual Procurement Plan List AusTender/i'))

WebUI.verifyElementPresent(findTestObject('Object Repository/AusTender/Page_Annual Procurement Plan List AusTender/div_EST10524 South Bandiana Building Works _33adc5'), 
    0)

WebUI.verifyElementPresent(findTestObject('Object Repository/AusTender/Page_Annual Procurement Plan List AusTender/h2_Search Results'), 
    0)

WebUI.verifyElementPresent(findTestObject('Object Repository/AusTender/Page_Annual Procurement Plan List AusTender/a_Download Results'), 
    0)

WebUI.click(findTestObject('Object Repository/AusTender/Page_Annual Procurement Plan List AusTender/span_Last Updated'))

WebUI.click(findTestObject('Object Repository/AusTender/Page_Annual Procurement Plan List AusTender/a_Title'))

WebUI.selectOptionByValue(findTestObject('Object Repository/AusTender/Page_Annual Procurement Plan List AusTender/select_Relevance                           _59b6fc'), 
    'Title', true)

WebUI.click(findTestObject('Object Repository/AusTender/Page_Annual Procurement Plan List AusTender/button_Sort'))

WebUI.click(findTestObject('Object Repository/AusTender/Page_Annual Procurement Plan List AusTender/a_2'))

WebUI.click(findTestObject('Object Repository/AusTender/Page_Annual Procurement Plan List AusTender/a_Planned Procurements'))

WebUI.click(findTestObject('Object Repository/AusTender/Page_Annual Procurement Plan List AusTender/span_List By Agency'))

WebUI.click(findTestObject('Object Repository/AusTender/Page_Annual Procurement Plan List AusTender/button_-- Please select --'))

WebUI.click(findTestObject('Object Repository/AusTender/Page_Annual Procurement Plan List AusTender/span_Administrative Appeals Tribunal'))

WebUI.selectOptionByValue(findTestObject('Object Repository/AusTender/Page_Annual Procurement Plan List AusTender/select_-- Please select ---- Please select _a82724'), 
    '077c76eb-918f-9197-880d-1aa6a58e5874', true)

WebUI.click(findTestObject('Object Repository/AusTender/Page_Annual Procurement Plan List AusTender/input_Workplace Gender Equality Agency_btn-_b78b20'))

WebUI.click(findTestObject('Object Repository/AusTender/Page_Annual Procurement Plan View - Adminis_2c9ef6/a_Planned Procurements'))

WebUI.closeBrowser()

