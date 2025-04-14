# 🧠 Katalon Object-less Automation Framework

> **Author:** Bharat Sethi (bharat.sethi@espireinfo.com.au)  
> **Version:** 1.0  
> **Framework Type:** Modular | Object-less | BDD-Driven | AI-Extendable  
> **Primary Tool:** Katalon Studio

---

## 🧭 Objective

The primary goal of this framework is to **simplify web automation** by eliminating hardcoded, page-specific object repositories, and instead use a **generic, parameter-driven approach** to automate any application.

This framework allows test authors to write **plain English BDD scenarios** using a **universal object layer**, powered by dynamic XPath logic, AI-augmented validations, and reusable step definitions.

---

## 🚀 Key Features

| Feature                            | Description                                                                 |
|------------------------------------|-----------------------------------------------------------------------------|
| 🔁 **Object-less Repository**       | Uses a small set of dynamic objects (e.g. WebButton, WebTextBox) with parameters. |
| ✍️ **Plain English BDD Support**   | Write Gherkin-style `.feature` files like “When I Click on the Button Login”. |
| 🧩 **Reusable Keywords**           | Generic actions (click, input, select, validate) defined once, used everywhere. |
| 📚 **Properties-driven Config**    | Centralized config, locator, validation, and user data property files.     |
| 📊 **Custom HTML Reports**         | Execution results logged with timestamps and formatted into an HTML report. |
| ⚡ **AI-Ready Architecture**        | Supports NLP-parsing, self-healing locators, and test step reasoning extensions. |
| 🔄 **Excel Integration**           | Test inputs and outputs managed via Excel sheets using Apache POI.          |

---

## 📁 Project Structure

```plaintext
Include/
  └── config/
      ├── config.properties           # Global environment config
      ├── Locator.properties          # Object locators by label
      ├── userInfo.properties         # Test user credentials
      └── validation.properties       # Expected text/assertion messages

Object Repository/
  └── 1. Generic/
      ├── WebButton
      ├── WebTextBox
      ├── WebLink
      ├── WebDropdown
      └── WebTextArea

Keywords/
  ├── generic/GenericActions.groovy  # Core web actions
  └── propertiesFileReader/          # Property & Excel utilities

Test Cases/
  └── BDDSteps/GenericSteps.groovy   # BDD Step Definitions

Include/features/
  └── GenericFeature.feature         # Gherkin Scenarios (Given/When/Then)

GlobalVariables/
  └── ReportList                     # Stores ReportBean instances for test step results

Reports/
  └── HTML output generated per test run
```

---

## ⚙️ Getting Started

### ✅ Prerequisites

- Katalon Studio installed
- Java 8+
- Internet access (for Google Charts in report)
- Apache POI JARs (for Excel support)

---

### 📦 Initial Setup

1. Clone or download this framework.
2. Open it using Katalon Studio.
3. Add the following in the `Drivers` folder if missing:
   - `poi-*.jar`, `poi-ooxml-*.jar`, `xmlbeans-*.jar`
4. Update paths in `config.properties`:
   ```properties
   ExcelFileUrl=/Include/testdata/TestData.xlsx
   TestOutputExcelFileUrl=/Include/reports/Output.xlsx
   ```

---

### 🚀 How to Use

#### 🧪 To Run a Test

1. Open `Include/features/GenericFeature.feature`
2. Choose a `Scenario` or `Scenario Outline`
3. Run using **Cucumber Runner** or via `Test Suite`

#### 🔍 To Add a New Test Step

1. Add a line in `.feature` like:
   ```gherkin
   And I Enter John in the textbox First Name
   ```
2. The step gets automatically mapped via `GenericSteps.groovy`
3. The object gets resolved using:
   ```groovy
   findTestObject('1. Generic/WebTextBox', [('ObjectName') : 'First Name'])
   ```

#### ✍️ To Add Validation

Use:
```gherkin
Then I validate the text displayed for Welcome
```
→ Message for `Welcome` will be retrieved from `validation.properties`

---

### 🛠️ Dynamic Data Usage

You can use `Scenario Outline` + `Examples:` to supply test data:

```gherkin
Scenario Outline: Submitting a form
  When I Enter <email> in the textbox Email

Examples:
  | email                  |
  | john.doe@mailinator.com |
```

---

### 📋 Logging & Reports

- Logs are written to:
  ```
  /GlobalVariables.ReportList → List<ReportBean>
  ```
- At test end, a **timestamped HTML report** is generated under:
  ```
  /katalon_report/YYYY-MM-DD-HH-mm-ss.html
  ```

---

## 🧠 AI Integration Ready

Your test steps, locators, validations, and logs are structured to support:
- ✅ LLM-parsed test step generation
- ✅ Natural language to XPath fallback
- ✅ AI-enhanced locator healing
- ✅ AI-summarized report creation (coming soon)

---

## ✨ Coming Soon

- 📈 Google Chart summary in report
- 📤 JSON export for dashboard integration
- 🤖 AI-based test step generator
- 📡 REST API to execute test plans from CI/CD or web interface

---

## 📞 Support / Contribution

If you're using this framework or wish to extend it:
- Email: `bharat.sethi@espireinfo.com.au`
- Suggest improvements or contribute test scenarios.
- Clone → Use → Customize → Elevate!

---

## 🙌 Acknowledgments

This framework is part of an ongoing mission to simplify test automation with:
- Less maintenance
- More reusability
- Seamless BDD collaboration
- Future-facing AI compatibility
