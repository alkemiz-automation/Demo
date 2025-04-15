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

not_run: CucumberKW.runFeatureFile('Include/features/SCRUM-72 Validate CN search.feature')

WebUI.openBrowser('')

WebUI.navigateToUrl('https://www.tenders.gov.au/')

WebUI.click(findTestObject('Object Repository/AusTender/Page_AusTender Homepage AusTender/a_Contract Notices'))

WebUI.setText(findTestObject('Object Repository/AusTender/Page_Contract Notices AusTender/input_Use the drop down menu to specify an _43aab4'), 
    'education')

WebUI.click(findTestObject('Object Repository/AusTender/Page_Contract Notices AusTender/i'))

WebUI.click(findTestObject('Object Repository/AusTender/Page_Contract Notice List AusTender/a_CN4144091'))

WebUI.click(findTestObject('Object Repository/AusTender/Page_Contract Notice View - CN4144091 AusTender/a_Contract Notices'))

WebUI.closeBrowser()

