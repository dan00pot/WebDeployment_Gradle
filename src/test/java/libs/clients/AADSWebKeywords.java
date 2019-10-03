package libs.clients;

import java.awt.Event;
import java.awt.Robot;
import java.awt.event.KeyEvent;

import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.LogManager;
import org.junit.Assert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import io.qameta.allure.Step;
import testData.aadsData;
import libs.common.Selenium;
import libs.clients.AADSWebLocators;

public class AADSWebKeywords {
	final static Logger logger = LogManager.getLogger("AADS Web Actions");
	Selenium selenium = new Selenium();
	AADSWebLocators AADSWeb = new AADSWebLocators();
	aadsData aadsData = new aadsData();

	@Step("Type {user.name} / {user.password}.")
	public void loginAADSMainPage(WebDriver driver, String userName,
			String password) throws Exception {
		try {
			selenium.inputText(driver, AADSWeb.AADS_LOGIN_PAGE_USERNAME_TXT,userName);
			selenium.inputText(driver, AADSWeb.AADS_LOGIN_PAGE_PASSWORD_TXT,password);
			selenium.clickElement(driver, AADSWeb.AADS_SIGN_IN_BTN);
			Assert.assertTrue(true);

		} catch (Exception e) {
			// TODO: handle exception
		}
	}

	public void WarningWhenChangeValue(WebDriver webDriver, String warning)
			throws Exception {
		logger.info("Verify Warning Information - starting...\n");
		try {
			Thread.sleep(2000);
			String result = new String();
			result = selenium.getText(webDriver, AADSWeb.VERIFY_WARING);

			if (result.contentEquals(warning)) {
				logger.info(" successfully...\n");
			} else
				throw new Exception("Configrute user failed....\n");

		} catch (Exception e) {
			logger.error("Test- Failed with Exception: " + e + "...\n");
			throw new Exception("Failed - Exception occurs: " + e);
		}
		logger.info("Test - completed...\n");
	}

	// ╯°□°）╯ //

	public void logoutAADSMainPage(WebDriver driver) throws Exception {
		try {
			selenium.switchToDefaultContent(driver);
			selenium.clickElement(driver, AADSWeb.AADS_MAIN_PAGE_LOGOFF_BTN);
			Assert.assertTrue(true);

		} catch (Exception e) {
			// TODO: handle exception
		}
	}

	
	public void navigateToFeaturesPage(WebDriver webDriver, String featurename)throws Exception {
		logger.info("navigateToFeaturesPage - " + featurename + "\n");
		try {
			selenium.clickElement(webDriver, AADSWeb.mainPageGroupFeaturesLocators(featurename));
		} catch (Exception exception) {
			throw new Exception("navigateToFeaturesPage - Failed - Exception occurs: "+ exception);
		}

	}

	public boolean viewPublishedSettingsVerify(WebDriver webDriver,
			String variable, boolean checked, String value) throws Exception {
		logger.info("viewPublishedSettingsVerify - starting...\n");
		try {
			/*
			 * if (selenium.isElementExisted(webDriver,
			 * AADSWeb.VIEW_PUBLISHED_SETTING_PAGE_IFRAME)) {
			 * selenium.switchToFrame(webDriver,
			 * AADSWeb.VIEW_PUBLISHED_SETTING_PAGE_IFRAME); }
			 */

			if (selenium.isElementExisted(webDriver,
					AADSWeb.VIEW_PUBLISHED_SETTING_NUMBER_OF_RESULT_DROPBOX)) {

				selenium.dropDownListBox(
						webDriver,
						AADSWeb.VIEW_PUBLISHED_SETTING_NUMBER_OF_RESULT_DROPBOX,
						"100");
			}
			Thread.sleep(5000);
			boolean x = selenium.isElementSelected(webDriver, AADSWeb
					.viewPublishedSettingPageValueCheckboxLocators(variable));
			if (checked != selenium.isElementSelected(webDriver, AADSWeb
					.viewPublishedSettingPageValueCheckboxLocators(variable))) {
				return false;
			}
			Thread.sleep(1000);
			String actValue = selenium.getText(webDriver,
					AADSWeb.viewPublishedSettingPageValueLocator(variable));
			if (!value.equalsIgnoreCase(actValue)) {
				return false;
			}
			return true;
		} catch (Exception exception) {
			// driverMgnt.setFailedWinClientDriver(webDriver);
			logger.error("viewPublishedSettingsVerify - Failed with Exception: "
					+ exception + "...\n");
			return false;
		}
	}

	public void configurationPageSelectConfigurationUser(WebDriver webDriver,String user) throws Exception {
		logger.info("configurationPageSelectConfigurationUser - starting...\n");
		try {
			if (selenium.isElementExisted(webDriver,
					AADSWeb.DYNAMIC_CONFIGURATION_CONFIGURATION_PAGE_IFRAME)) {
				selenium.switchToFrame(webDriver,
						AADSWeb.DYNAMIC_CONFIGURATION_CONFIGURATION_PAGE_IFRAME);
			}
			selenium.clickElement(webDriver,AADSWeb.DYNAMIC_CONFIGURATION_CONFIGURATION_PAGE_SELECT_CONFIGURATION_BTN);
			selenium.dropDownListBox(webDriver,	AADSWeb.DYNAMIC_CONFIGURATION_CONFIGURATION_PAGE_SELECT_USER_LIST,user);
		} catch (Exception exception) {
			throw new Exception("configurationPageSelectConfigurationUser - Failed - Exception occurs: "+ exception);

		}

	}

	public void configurationPageSettingVariable(WebDriver webDriver,
			String tab, String variable, boolean checkbox, String text)
			throws Exception {
		try {
			if (selenium.isElementExisted(webDriver,
					AADSWeb.DYNAMIC_CONFIGURATION_CONFIGURATION_PAGE_IFRAME)) {
				selenium.switchToFrame(webDriver,
						AADSWeb.DYNAMIC_CONFIGURATION_CONFIGURATION_PAGE_IFRAME);
			}
			Thread.sleep(1000);
			selenium.clickElementByText(webDriver, tab);
			tab = tab.toLowerCase();
			selenium.dropDownListBox(
					webDriver,
					AADSWeb.autoConfigPageSettingValueDisplayNumberVariableDropListLocators(tab),"All");
			selenium.scrollToElement(webDriver, AADSWeb.autoConfigPageSettingValueCheckboxLocators(tab, variable));
			if (checkbox == true) {
				if (selenium.isElementSelected(webDriver, AADSWeb.autoConfigPageSettingValueCheckboxLocators(tab,variable)) == false) {
					selenium.clickElement(webDriver, AADSWeb.autoConfigPageSettingValueCheckboxLocators(tab,variable));
				}
			} else {
				if (selenium.isElementSelected(webDriver, AADSWeb.autoConfigPageSettingValueCheckboxLocators(tab,variable)) == true) {
					selenium.clickElement(webDriver, AADSWeb.autoConfigPageSettingValueCheckboxLocators(tab,variable));
				}
			}
			selenium.inputText(webDriver, AADSWeb.autoConfigPageSettingValueTextLocators(tab, variable),text);
	//		selenium.scrollToElement(webDriver,AADSWeb.DYNAMIC_CONFIGURATION_CONFIGURATION_PAGE_SELECT_CONFIGURATION_BTN);
		} catch (Exception exception) {
			throw new Exception(
					"configurationPageSettingVariable - Failed - Exception occurs: "
							+ exception);
		}
	}

	public void configurationPagePublishUser(WebDriver webDriver, String user)
			throws Exception {
		try {
			selenium.clickElement(
					webDriver,
					AADSWeb.DYNAMIC_CONFIGURATION_CONFIGURATION_PAGE_SAVE_USER_BTN);
			selenium.clickElement(
					webDriver,
					AADSWeb.DYNAMIC_CONFIGURATION_CONFIGURATION_PAGE_SAVE_USER_COMFIRM_BTN);
			Thread.sleep(5000);
			selenium.clickElement(
					webDriver,
					AADSWeb.DYNAMIC_CONFIGURATION_CONFIGURATION_PAGE_PUBLISH_USER_BTN);
			if (!selenium.isElementSelected(webDriver,
					AADSWeb.PUBLISH_WINDOW_USER_CHECKBOX)) {
				selenium.clickElement(webDriver,
						AADSWeb.PUBLISH_WINDOW_USER_CHECKBOX);
			}
			selenium.inputText(webDriver, AADSWeb.PUBLISH_WINDOW_USER_TXT, user);
			if (!selenium.isElementSelected(webDriver,
					AADSWeb.PUBLISH_WINDOW_GROUP_SET_CHECKBOX)) {
				selenium.clickElement(webDriver,
						AADSWeb.PUBLISH_WINDOW_GROUP_SET_CHECKBOX);
			}
			if (!selenium.isElementSelected(webDriver,
					AADSWeb.PUBLISH_WINDOW_GLOBAL_SET_CHECKBOX)) {
				selenium.clickElement(webDriver,
						AADSWeb.PUBLISH_WINDOW_GLOBAL_SET_CHECKBOX);
			}

			selenium.inputText(webDriver, AADSWeb.PUBLISH_WINDOW_GROUP_SET_TXT,
					aadsData.AADS_USER_GROUP_INPUT_5_CHARACTER);
			selenium.clickElement(webDriver, AADSWeb.PUBLISH_WINDOW_GROUP_NEW);
			selenium.clickElement(webDriver, AADSWeb.PUBLISH_WINDOW_PUBLISH_BTN);
			selenium.clickElement(webDriver,
					AADSWeb.PUBLISH_WINDOW_PUBLISH_YES_CONFIRM_BTN);

			Thread.sleep(5000);
			String message = new String();
			message = selenium.getText(webDriver,AADSWeb.DYNAMIC_CONFIGURATION_CONFIGURATION_PAGE_STATUS_MESSAGE);
			if (message.contains("Settings were published successfully")) {

			} else
				throw new Exception(
						"testAADS001- Failed - Exception occurs:  Publish user failed : " + message);
		} catch (Exception exception) {
			throw new Exception("configurationPagePublishUser - Failed - Exception occurs: "+ exception);
		}
	}

	public void configurationPageHandleType(WebDriver webDriver, String tab,
			String variable, String text) throws Exception {
		try {
			selenium.clickElementByText(webDriver, tab);
			tab = tab.toLowerCase();
			selenium.dropDownListBox(
					webDriver,
					AADSWeb.autoConfigPageSettingValueDisplayNumberVariableDropListLocators(tab),
					"All");
			Thread.sleep(5000);
			selenium.scrollToElement(webDriver, AADSWeb
					.autoConfigPageSettingValueCheckboxLocators(tab, variable));
			selenium.dropDownListBox(webDriver,
					AADSWeb.AUTOCONFIG_GROUP_COMM_ADDR_HANDLE_TYPE, text);
			selenium.scrollToElement(
					webDriver,
					AADSWeb.DYNAMIC_CONFIGURATION_CONFIGURATION_PAGE_SELECT_CONFIGURATION_BTN);
		} catch (Exception exception) {
			throw new Exception(
					"configurationPageHandleType - Failed - Exception occurs: "
							+ exception);
		}
	}

	public void invalidLoginAADSMainPage(WebDriver webDriver, String user,
			String password) throws Exception {
		logger.info("invalidLoginAADSMainPage - starting...\n");
		try {
			selenium.inputText(webDriver, AADSWeb.LOGIN_PAGE_USERNAME_TXT, user);
			selenium.inputText(webDriver, AADSWeb.LOGIN_PAGE_PASSWORD_TXT,
					password);
			selenium.clickElement(webDriver, AADSWeb.LOGIN_PAGE_SUBMIT_BTN);
			String message = selenium.getText(webDriver,
					AADSWeb.LOGIN_PAGE_WARNING_TXT);
			if (message
					.contains("Invalid username or password. Please try again.")) {
				logger.info("invalidLoginAADSMainPage - Success.\n");
			} else
				throw new Exception(
						"deploymentPageDeleteAppcastItem- Failed - Exception occurs:  Delete appcast item failed....\n");

		} catch (Exception exception) {
			logger.error("invalidLoginAADSMainPage - Failed with Exception: "
					+ exception + "...\n");
			throw new Exception(
					"invalidLoginAADSMainPage - Failed - Exception occurs: "
							+ exception);
		}
		logger.info("invalidLoginAADSMainPage - completed...\n");
	}

	public void applicationMGMTPageChangeApplicationPropertiesValues(
			WebDriver webDriver, String browser, String save) throws Exception {
		logger.info("ApplicationMGMTPageChangeApplicationPropertiesValues - starting...\n");
		try {
			// Use inputText2 to clear value of textbox before input text.
			// selenium.waitUntilElementClickable(webDriver,
			// AADSWeb.SERVICE_CONTROL_APPLICATION_MGMT_PAGE_APPLICATION_PROPERTIES_ADMIN,
			// 200);
			selenium.inputText2(
					webDriver,
					AADSWeb.SERVICE_CONTROL_APPLICATION_MGMT_PAGE_APPLICATION_PROPERTIES_ADMIN,
					aadsData.ADMIN_HTTPSESSION_TIMEOUT);
			// selenium.inputText(webDriver,
			// AADSWeb.SERVICE_CONTROL_APPLICATION_MGMT_PAGE_APPLICATION_PROPERTIES_ADMIN,
			// aadsData.ADMIN_HTTPSESSION_TIMEOUT);
			logger.info("Admin HTTP session time out was changed...\n");

			// selenium.waitUntilElementClickable(webDriver,
			// AADSWeb.SERVICE_CONTROL_APPLICATION_MGMT_PAGE_APPLICATION_PROPERTIES_APP,
			// 200);
			selenium.inputText2(
					webDriver,
					AADSWeb.SERVICE_CONTROL_APPLICATION_MGMT_PAGE_APPLICATION_PROPERTIES_APP,
					aadsData.APPLICATION_HTTPSESSION_TIMEOUT);
			// selenium.inputText(webDriver,
			// AADSWeb.SERVICE_CONTROL_APPLICATION_MGMT_PAGE_APPLICATION_PROPERTIES_APP,
			// aadsData.APPLICATION_HTTPSESSION_TIMEOUT);
			logger.info("Application HTTP session time out was changed...\n");

			// selenium.waitUntilElementClickable(webDriver,
			// AADSWeb.SERVICE_CONTROL_APPLICATION_MGMT_PAGE_APPLICATION_PROPERTIES_MAX,
			// 200);
			selenium.inputText2(
					webDriver,
					AADSWeb.SERVICE_CONTROL_APPLICATION_MGMT_PAGE_APPLICATION_PROPERTIES_MAX,
					aadsData.MAX_CONCURRENT_HTTP_SESSIONS);
			// selenium.inputText(webDriver,
			// AADSWeb.SERVICE_CONTROL_APPLICATION_MGMT_PAGE_APPLICATION_PROPERTIES_MAX,
			// aadsData.MAX_CONCURRENT_HTTP_SESSIONS);
			logger.info("Maximun concurrent HTTP session was changed...\n");

			selenium.inputText2(
					webDriver,
					AADSWeb.SERVICE_CONTROL_APPLICATION_MGMT_PAGE_APPLICATION_PROPERTIES_CONCURRENT,
					aadsData.CONCURRENT_HTTP_SESSIONS_PER_USER);
			logger.info("Concurrent HTTP session per user was changed...\n");

			if (save == "Save") {
				// Use click save button 2 times to fix the issue: hold the
				// button after click
				if (browser == "Chrome") {
					selenium.clickElement(
							webDriver,
							AADSWeb.SERVICE_CONTROL_APPLICATION_MGMT_PAGE_APPLICATION_PROPERTIES_SAVE_BTN);
				} else {
					selenium.clickElement(
							webDriver,
							AADSWeb.SERVICE_CONTROL_APPLICATION_MGMT_PAGE_APPLICATION_PROPERTIES_SAVE_BTN);
					selenium.clickElement(
							webDriver,
							AADSWeb.SERVICE_CONTROL_APPLICATION_MGMT_PAGE_APPLICATION_PROPERTIES_SAVE_BTN);
				}

				logger.info("Click save button completed...\n");
				Thread.sleep(3000);
				selenium.clickElement(
						webDriver,
						AADSWeb.SERVICE_CONTROL_APPLICATION_MGMT_PAGE_APPLICATION_PROPERTIES_CONFIRM_SAVE_BTN);
				logger.info("Click ok button to save change ...completed...\n");
				Thread.sleep(3000);
				selenium.clickElement(
						webDriver,
						AADSWeb.SERVICE_CONTROL_APPLICATION_MGMT_PAGE_APPLICATION_PROPERTIES_RESTART_BTN);
				logger.info("Click ok button to restart services ...completed...\n");
				Thread.sleep(3000);
				selenium.clickElement(
						webDriver,
						AADSWeb.SERVICE_CONTROL_APPLICATION_MGMT_PAGE_APPLICATION_PROPERTIES_CONFIRM_RESTART_BTN);
				logger.info("Click ok button to confirm restart services ...completed...\n");
				selenium.clickElement(
						webDriver,
						AADSWeb.SERVICE_CONTROL_APPLICATION_MGMT_PAGE_APPLICATION_PROPERTIES_CONFIRM_RESTART_SUCCESSFUL);
				logger.info("Apply change completed...\n");
			}

			else {
				logger.info("Apply change completed...\n");
			}

		} catch (Exception exception) {
			logger.error("ApplicationMGMTPageChangeApplicationPropertiesValues - Failed with Exception: "
					+ exception + "...\n");
			throw new Exception(
					"ApplicationMGMTPageChangeApplicationPropertiesValues - Failed - Exception occurs: "
							+ exception);
		}
		logger.info("ApplicationMGMTPageChangeApplicationPropertiesValues - completed...\n");
	}

	public void applicationMGMTPageVerifyApplicationPropertiesValues(
			WebDriver webDriver) throws Exception {
		logger.info("ApplicationMGMTPageVerifyApplicationPropertiesValues - starting...\n");
		try {
			if (selenium
					.isElementTexboxContainText(
							webDriver,
							AADSWeb.SERVICE_CONTROL_APPLICATION_MGMT_PAGE_APPLICATION_PROPERTIES_ADMIN,
							aadsData.ADMIN_HTTPSESSION_TIMEOUT)) {
				logger.info("verify admin HTTP session time out value - Passed");
				if (selenium
						.isElementTexboxContainText(
								webDriver,
								AADSWeb.SERVICE_CONTROL_APPLICATION_MGMT_PAGE_APPLICATION_PROPERTIES_APP,
								aadsData.APPLICATION_HTTPSESSION_TIMEOUT)) {
					logger.info("Application HTTP session time out value - Passed");
					if (selenium
							.isElementTexboxContainText(
									webDriver,
									AADSWeb.SERVICE_CONTROL_APPLICATION_MGMT_PAGE_APPLICATION_PROPERTIES_MAX,
									aadsData.MAX_CONCURRENT_HTTP_SESSIONS)) {
						logger.info("Maximun concurrent HTTP session value - Passed");
						// if(selenium.isElementTexboxContainText(webDriver,
						// AADSWeb.SERVICE_CONTROL_APPLICATION_MGMT_PAGE_APPLICATION_PROPERTIES_CONCURRENT,
						// aadsData.CONCURRENT_HTTP_SESSIONS_PER_USER)){
						// logger.info("Concurrent HTTP session per user value - Passed");
						// }
					}
				}
			} else {
				logger.info("ApplicationMGMTPageVerifyApplicationPropertiesValues - Failed");
				throw new Exception(
						"ApplicationMGMTPageVerifyApplicationPropertiesValues - Failed");
			}
		} catch (Exception exception) {
			logger.error("ApplicationMGMTPageVerifyApplicationPropertiesValues - Failed with Exception: "
					+ exception + "...\n");
			throw new Exception(
					"ApplicationMGMTPageVerifyApplicationPropertiesValues - Failed - Exception occurs: "
							+ exception);
		}
	}

	public void verifySmgrCertificateDisplayInfoCorrect(WebDriver webDriver)
			throws Exception {
		logger.info("verifySmgrCertificateDisplayInfoCorrect - starting...\n");
		try {
			if (selenium.isElementTexboxContainText(webDriver,
					AADSWeb.CERTIFICATE_MANAGEMENT_SMGR_CERTIFICATES_SMGR_ADDR,
					aadsData.SMGR_ADDR)) {
				if (selenium
						.isElementTexboxContainText(
								webDriver,
								AADSWeb.CERTIFICATE_MANAGEMENT_SMGR_CERTIFICATES_AADS_COMMON_NAME,
								aadsData.AADS_COMMON_NAME)) {
					logger.info("SMGR certificate page display information correctly...\n");
				} else {
					logger.info("SMGR certificate page display nodes information incorrect - Failed");
					throw new Exception(
							"SMGR certificate page display nodes information incorrect - Failed");
				}
			} else {
				logger.info("SMGR certificate page display SMGR information incorrect - Failed");
				throw new Exception(
						"SMGR certificate page display SMGR information incorrect - Failed");
			}
		} catch (Exception exception) {
			logger.error("verifySmgrCertificateDisplayInfoCorrect - Failed with Exception: "
					+ exception + "...\n");
			throw new Exception(
					"verifySmgrCertificateDisplayInfoCorrect - Failed - Exception occurs: "
							+ exception);
		}
	}

	/**
	 * Navigate to Certificate Managerment -> Identity Certificates -> create
	 * new CSR and delete CSR
	 * 
	 * @param webDriver
	 *            testing Web on AADS web
	 * @param user
	 * @author ttkngan
	 * @throws Exception
	 * 
	 */
	public void createNewCSR(WebDriver webDriver, String browser)
			throws Exception {
		// logger.info("createAndDeleteCSR - starting...\n");
		try {
			logger.info("createCSR - starting...\n");
			if (browser == "Chrome") {
				selenium.clickElement(
						webDriver,
						AADSWeb.CERTIFICATE_MANAGEMENT_IDENTITY_CERT_CSR_CREATE_BTN);
			} else {
				// click create button 2 times to fix the issue hold button when
				// click element by automation
				selenium.clickElement(
						webDriver,
						AADSWeb.CERTIFICATE_MANAGEMENT_IDENTITY_CERT_CSR_CREATE_BTN);
				selenium.clickElement(
						webDriver,
						AADSWeb.CERTIFICATE_MANAGEMENT_IDENTITY_CERT_CSR_CREATE_BTN);
			}
			Thread.sleep(3000);
			selenium.inputText(
					webDriver,
					AADSWeb.CERTIFICATE_MANAGEMENT_IDENTITY_CERT_CSR_ALIAS_TEXT_BOX,
					aadsData.ALIAS);

			selenium.clickElement(webDriver,
					AADSWeb.CERTIFICATE_MANAGEMENT_IDENTITY_CERT_CSR_APPLY_BTN);
			Thread.sleep(3000);
			// Runtime.getRuntime().exec("D:\\Ngan\\AutoIT\\tc_browser_030.exe");
			/*
			 * if(selenium.isElementContainText(webDriver,
			 * AADSWeb.CERTIFICATE_MANAGEMENT_IDENTITY_CERT_CSR_ALIAS_VERIFY
			 * (aadsData.CSR_ALIAS), aadsData.CSR_ALIAS)) {
			 * logger.info("create new CSR - successful...\n"); } else {
			 * logger.info("create new CSR - Failed");
			 * driverMgnt.setFailedWinClientDriver(webDriver); throw new
			 * Exception("create new CSR - Failed"); }
			 */
			logger.info("create new CSR - completed...\n");

		} catch (Exception exception) {
			logger.error("createNewCSR - Failed with Exception: " + exception
					+ "...\n");
			throw new Exception("createNewCSR - Failed - Exception occurs: "
					+ exception);
		}
	}

	public void createNewCSRBrowserIE(WebDriver webDriver) throws Exception {
		// logger.info("createAndDeleteCSR - starting...\n");
		try {
			logger.info("createCSR - starting...\n");
			// click create button 2 times to fix the issue hold button when
			// click element by automation
			selenium.clickElement(webDriver,
					AADSWeb.CERTIFICATE_MANAGEMENT_IDENTITY_CERT_CSR_CREATE_BTN);
			selenium.clickElement(webDriver,
					AADSWeb.CERTIFICATE_MANAGEMENT_IDENTITY_CERT_CSR_CREATE_BTN);
			Thread.sleep(3000);
			selenium.inputText(
					webDriver,
					AADSWeb.CERTIFICATE_MANAGEMENT_IDENTITY_CERT_CSR_ALIAS_TEXT_BOX,
					aadsData.ALIAS);
			// Runtime.getRuntime().exec("D:\\Ngan\\AutoIT\\tc_browser_030_IE.exe");
			Runtime.getRuntime().exec(
					"C:\\seleniumDriver\\AutoIT\\tc_browser_030_IE.exe");
			Thread.sleep(10000);
			selenium.clickElement(webDriver,
					AADSWeb.CERTIFICATE_MANAGEMENT_IDENTITY_CERT_CSR_APPLY_BTN);

			// Thread.sleep(3000);

			/*
			 * if(selenium.isElementExisted(webDriver,
			 * AADSWeb.CERTIFICATE_MANAGEMENT_IDENTITY_CERT_CSR_ALREADY_EXIT)) {
			 * Runtime.getRuntime().exec(
			 * "C:\\seleniumDriver\\AutoIT\\tc_browser_030_IE.exe");
			 * selenium.clickElement(webDriver,
			 * AADSWeb.CERTIFICATE_MANAGEMENT_IDENTITY_CERT_CSR_ALREADY_EXIT);
			 * Thread.sleep(3000); }
			 */
			// Runtime.getRuntime().exec("D:\\Ngan\\AutoIT\\tc_browser_030.exe");
			/*
			 * if(selenium.isElementContainText(webDriver,
			 * AADSWeb.CERTIFICATE_MANAGEMENT_IDENTITY_CERT_CSR_ALIAS_VERIFY
			 * (aadsData.CSR_ALIAS), aadsData.CSR_ALIAS)) {
			 * logger.info("create new CSR - successful...\n"); } else {
			 * logger.info("create new CSR - Failed");
			 * driverMgnt.setFailedWinClientDriver(webDriver); throw new
			 * Exception("create new CSR - Failed"); }
			 */
			logger.info("create new CSR - completed...\n");

		} catch (Exception exception) {
			logger.error("createNewCSR - Failed with Exception: " + exception
					+ "...\n");
			throw new Exception("createNewCSR - Failed - Exception occurs: "
					+ exception);
		}
	}

	public void deleteCSR(WebDriver webDriver, String browser) throws Exception {
		logger.info("deleteCSR - starting...\n");
		try {

			String alias = aadsData.ALIAS.toLowerCase();
			Thread.sleep(3000);
			selenium.clickElement(
					webDriver,
					AADSWeb.CERTIFICATE_MANAGEMENT_IDENTITY_CERT_CSR_ALIAS_VERIFY(alias));
			// selenium.waitUntilElementClickable(webDriver,
			// AADSWeb.CERTIFICATE_MANAGEMENT_IDENTITY_CERT_CSR_ALIAS_VERIFY,
			// 200);
			// selenium.clickElement(webDriver,
			// AADSWeb.CERTIFICATE_MANAGEMENT_IDENTITY_CERT_CSR_ALIAS_VERIFY);
			Thread.sleep(3000);
			if (browser == "Chrome") {
				selenium.clickElement(
						webDriver,
						AADSWeb.CERTIFICATE_MANAGEMENT_IDENTITY_CERT_CSR_DELETE_BTN);
			} else {
				selenium.clickElement(
						webDriver,
						AADSWeb.CERTIFICATE_MANAGEMENT_IDENTITY_CERT_CSR_DELETE_BTN);
				selenium.clickElement(
						webDriver,
						AADSWeb.CERTIFICATE_MANAGEMENT_IDENTITY_CERT_CSR_DELETE_BTN);
			}
			Thread.sleep(3000);
			logger.info("Click delete button completed...\n");
			selenium.clickElement(
					webDriver,
					AADSWeb.CERTIFICATE_MANAGEMENT_IDENTITY_CERT_CSR_DELETE_OK_BTN);
			logger.info("Confirm delete CSR completed...\n");
			Thread.sleep(2000);
			selenium.clickElement(
					webDriver,
					AADSWeb.CERTIFICATE_MANAGEMENT_IDENTITY_CERT_CSR_DELETE_DONE_BTN);
			logger.info("Delete CSR done...\n");

		} catch (Exception exception) {

			logger.error("deleteCSR - Failed with Exception: " + exception
					+ "...\n");
			throw new Exception("deleteCSR - Failed - Exception occurs: "
					+ exception);
		}
	}

	public void configurationPageSaveConfigurationOverride(WebDriver webDriver,
			String config) throws Exception {
		logger.info("configurationPageSaveConfigurationOverride - stating save new configuration override "
				+ config);
		try {
			logger.info("configurationPageSaveConfigurationOverride - Click save button");
			selenium.clickElement(
					webDriver,
					AADSWeb.DYNAMIC_CONFIGURATION_CONFIGURATION_PAGE_SAVE_USER_BTN);
			Thread.sleep(1000);
			logger.info("configurationPageSaveConfigurationOverride - Select Config");
			selenium.dropDownListBox(
					webDriver,
					AADSWeb.DYNAMIC_CONFIGURATION_CONFIGURATION_PAGE_SAVE_SELECT_CONFIG_LIST,
					config);
			selenium.clickElement(
					webDriver,
					AADSWeb.DYNAMIC_CONFIGURATION_CONFIGURATION_PAGE_SAVE_SELECT_CONFIG_LIST);
			logger.info("configurationPageSaveConfigurationOverride - Confirm save configuration");
			selenium.clickElement(
					webDriver,
					AADSWeb.DYNAMIC_CONFIGURATION_CONFIGURATION_PAGE_SAVE_USER_COMFIRM_BTN);
			Thread.sleep(1000);
			logger.info("configurationPageSaveConfigurationOverride - Configuration save successfully");
		} catch (Exception e) {
			logger.error("configurationPageSaveConfigurationOverride - Failed with Exception: "
					+ e + "...\n");
			throw new Exception(
					"configurationPageSaveConfigurationOverride - Failed - Exception occurs: "
							+ e);
		}
	}

	/**
	 * TC Browser_09 Check Enable Cross-Origin Resource Sharing and input CORS
	 * domain in Specific Domain(s) -> Save
	 * 
	 * @param webDriver
	 *            testing Web on AADS web
	 * @param user
	 * @author ttkngan
	 * @throws Exception
	 * 
	 */

	public void serverConnetionsPageAddTrustedHost(WebDriver webDriver,
			String trustedHost) throws Exception {
		logger.info("serverConnetionsPageAddTrustedHost - stating save new configuration override ");
		try {
			selenium.clickElementInObjectUsingJavascriptById(webDriver,
					AADSWeb.SERVER_CONNECTION_TRUSTED_HOSTS_OBJECT,
					AADSWeb.SERVER_CONNECTION_TRUSTED_HOSTS_ADD_BTN_ID);
			selenium.setTextElementInObjectUsingJavascriptbyClass(webDriver,
					AADSWeb.SERVER_CONNECTION_TRUSTED_HOSTS_OBJECT,
					AADSWeb.SERVER_CONNECTION_TRUSTED_HOSTS_HOST_TXT_CLASS,
					trustedHost);
			Thread.sleep(3000);
			selenium.clickElementInObjectUsingJavascriptById(webDriver,
					AADSWeb.SERVER_CONNECTION_TRUSTED_HOSTS_OBJECT,
					AADSWeb.SERVER_CONNECTION_TRUSTED_HOSTS_SAVE_BTN_ID);
		} catch (Exception e) {

			logger.error("serverConnetionsPageAddTrustedHost - Failed with Exception: "
					+ e + "...\n");
			throw new Exception(
					"serverConnetionsPageAddTrustedHost - Failed - Exception occurs: "
							+ e);
		}
	}

	public void serverConnetionsPageEditTrustedHost(WebDriver webDriver,
			String trustedHost, String newhost) throws Exception {
		logger.info("serverConnetionsPageAddTrustedHost - stating save new configuration override ");
		try {
			selenium.clickElementInObjectUsingJavascriptbyCSS(webDriver,
					AADSWeb.SERVER_CONNECTION_TRUSTED_HOSTS_OBJECT,
					AADSWeb.SERVER_CONNECTION_TRUSTED_HOSTS_FIRST_HOST);
			Thread.sleep(1000);
			selenium.clickElementInObjectUsingJavascriptById(webDriver,
					AADSWeb.SERVER_CONNECTION_TRUSTED_HOSTS_OBJECT,
					AADSWeb.SERVER_CONNECTION_TRUSTED_HOSTS_EDIT_BTN_ID);
			Thread.sleep(5000);
			selenium.setTextElementInObjectUsingJavascriptbyCSS(webDriver,
					AADSWeb.SERVER_CONNECTION_TRUSTED_HOSTS_OBJECT,
					AADSWeb.SERVER_CONNECTION_TRUSTED_HOSTS_EDITING_HOST,
					newhost);
			Thread.sleep(5000);
			selenium.clickElementInObjectUsingJavascriptById(webDriver,
					AADSWeb.SERVER_CONNECTION_TRUSTED_HOSTS_OBJECT,
					AADSWeb.SERVER_CONNECTION_TRUSTED_HOSTS_SAVE_BTN_ID);
		} catch (Exception e) {

			logger.error("serverConnetionsPageAddTrustedHost - Failed with Exception: "
					+ e + "...\n");
			throw new Exception(
					"serverConnetionsPageAddTrustedHost - Failed - Exception occurs: "
							+ e);
		}
	}

	public void serverConnetionsPageDeleteTrustedHost(WebDriver webDriver,
			String trustedHost) throws Exception {
		logger.info("serverConnetionsPageAddTrustedHost - stating save new configuration override ");
		try {
			selenium.clickElementInObjectUsingJavascriptbyCSS(webDriver,
					AADSWeb.SERVER_CONNECTION_TRUSTED_HOSTS_OBJECT,
					AADSWeb.SERVER_CONNECTION_TRUSTED_HOSTS_FIRST_HOST);
			Thread.sleep(3000);
			selenium.clickElementInObjectUsingJavascriptById(webDriver,
					AADSWeb.SERVER_CONNECTION_TRUSTED_HOSTS_OBJECT,
					AADSWeb.SERVER_CONNECTION_TRUSTED_HOSTS_DELETE_BTN_ID);
			selenium.clickElementInObjectUsingJavascriptById(webDriver,
					AADSWeb.SERVER_CONNECTION_TRUSTED_HOSTS_OBJECT,
					AADSWeb.SERVER_CONNECTION_TRUSTED_HOSTS_SAVE_BTN_ID);
		} catch (Exception e) {
			logger.error("serverConnetionsPageAddTrustedHost - Failed with Exception: "
					+ e + "...\n");
			throw new Exception(
					"serverConnetionsPageAddTrustedHost - Failed - Exception occurs: "
							+ e);
		}
	}

	public void serverConnectionsPageCORSconfigure(WebDriver webDriver,
			boolean enable, boolean any, String domain) throws Exception {
		logger.info("serverConnectionsPageCORSconfigure - stating save new configuration override ");
		try {
			boolean x = selenium.isElementcheckedJavascriptExecutor(webDriver,
					AADSWeb.SERVER_CONNECTION_TRUSTED_HOSTS_OBJECT,
					AADSWeb.SERVER_CONNECTION_CORS_ENABLE_CORS_CHECKBOX_ID);
			logger.info(x);
			if (!selenium.isElementcheckedJavascriptExecutor(webDriver,
					AADSWeb.SERVER_CONNECTION_TRUSTED_HOSTS_OBJECT,
					AADSWeb.SERVER_CONNECTION_CORS_ENABLE_CORS_CHECKBOX_ID) != enable) {

				selenium.clickElementInObjectUsingJavascriptById(webDriver,
						AADSWeb.SERVER_CONNECTION_TRUSTED_HOSTS_OBJECT,
						AADSWeb.SERVER_CONNECTION_CORS_ENABLE_CORS_CHECKBOX_ID);
			}
			Thread.sleep(3000);
			if (enable) {
				boolean y = selenium
						.isElementcheckedJavascriptExecutor(
								webDriver,
								AADSWeb.SERVER_CONNECTION_TRUSTED_HOSTS_OBJECT,
								AADSWeb.SERVER_CONNECTION_CORS_ALLOW_ANY_ORIGIN_CHECKBOX_ID);
				logger.info(y);
				if (!selenium
						.isElementcheckedJavascriptExecutor(
								webDriver,
								AADSWeb.SERVER_CONNECTION_TRUSTED_HOSTS_OBJECT,
								AADSWeb.SERVER_CONNECTION_CORS_ALLOW_ANY_ORIGIN_CHECKBOX_ID) != any) {
					selenium.clickElementInObjectUsingJavascriptById(
							webDriver,
							AADSWeb.SERVER_CONNECTION_TRUSTED_HOSTS_OBJECT,
							AADSWeb.SERVER_CONNECTION_CORS_ALLOW_ANY_ORIGIN_CHECKBOX_ID);
				}
				Thread.sleep(5000);
				if (!any) {
					logger.info("set text");
					selenium.clickElementInObjectUsingJavascriptById(webDriver,
							AADSWeb.SERVER_CONNECTION_TRUSTED_HOSTS_OBJECT,
							AADSWeb.SERVER_CONNECTION_CORS_DOMAINS_INPUT_TXT_ID);
					Thread.sleep(5000);

					// selenium.setTextElementInObjectUsingJavascriptbyCSS(webDriver,
					// AADSWeb.SERVER_CONNECTION_TRUSTED_HOSTS_OBJECT,
					// AADSWeb.SERVER_CONNECTION_CORS_DOMAINS_INPUT_TXT,
					// domain);

					// selenium.inputTextElementInObjectUsingJavascriptbyCSS2(webDriver,
					// AADSWeb.SERVER_CONNECTION_TRUSTED_HOSTS_OBJECT,
					// AADSWeb.SERVER_CONNECTION_CORS_DOMAINS_INPUT_TXT_CSS,
					// domain);
					// selenium.setTextElementInObjectUsingJavascriptbyId(webDriver,
					// AADSWeb.SERVER_CONNECTION_TRUSTED_HOSTS_OBJECT,
					// AADSWeb.SERVER_CONNECTION_CORS_DOMAINS_INPUT_TXT_ID,
					// domain);
					// selenium.inputText2(webDriver, AADSWeb.TestLungTung,
					// domain);

					// selenium.inputTextElementInObjectUsingJavascriptbyCSS2(webDriver,
					// AADSWeb.SERVER_CONNECTION_TRUSTED_HOSTS_OBJECT,
					// AADSWeb.SERVER_CONNECTION_CORS_DOMAINS_INPUT_TXT_CSS,
					// domain);
					selenium.setTextElementInObjectUsingJavascriptbyId(
							webDriver,
							AADSWeb.SERVER_CONNECTION_TRUSTED_HOSTS_OBJECT,
							AADSWeb.SERVER_CONNECTION_CORS_DOMAINS_INPUT_TXT_ID,
							domain);

				}
			}

			selenium.clickElementInObjectUsingJavascriptById(webDriver,
					AADSWeb.SERVER_CONNECTION_TRUSTED_HOSTS_OBJECT,
					AADSWeb.SERVER_CONNECTION_CORS_SAVE_BTN_ID);
			Thread.sleep(1000);
			selenium.clickElementInObjectUsingJavascriptbyCSS(webDriver,
					AADSWeb.SERVER_CONNECTION_TRUSTED_HOSTS_OBJECT,
					AADSWeb.SERVER_CONNECTION_CORS_CONFIRM_ACTION_SAVE_BTN);

		} catch (Exception e) {
			logger.error("serverConnetionsPageAddTrustedHost - Failed with Exception: "
					+ e + "...\n");
			throw new Exception(
					"serverConnetionsPageAddTrustedHost - Failed - Exception occurs: "
							+ e);
		}
	}

	public void clientAdministrationPageVerifyRestValues(WebDriver webDriver)
			throws Exception {
		logger.info("clientAdministrationPageVerifyRestValues - starting...\n");
		try {
			if (selenium
					.compareValueFromTheList(
							webDriver,
							AADSWeb.CLIENT_ADMINISTRATION_HTTP_CLIENTS_PAGE_REST_DROPDOWN_LISTBOX)) {
				logger.info("dropbox have items as expected - Passed");
			} else {
				logger.info("dropbox do not have items as expected - Failed");
				throw new Exception(
						"clientAdministrationPageVerifyRestValues - Failed");
			}
		} catch (Exception exception) {
			logger.error("clientAdministrationPageVerifyRestValues - Failed with Exception: "
					+ exception + "...\n");
			throw new Exception(
					"clientAdministrationPageVerifyRestValues - Failed - Exception occurs: "
							+ exception);
		}
	}

	public void clientAdministrationPageVerifyOAMPValues(WebDriver webDriver)
			throws Exception {
		logger.info("clientAdministrationPageVerifyOAMPValues - starting...\n");
		try {
			if (selenium
					.compareValueFromTheList(
							webDriver,
							AADSWeb.CLIENT_ADMINISTRATION_HTTP_CLIENTS_PAGE_OAMP_DROPDOWN_LISTBOX)) {
				logger.info("dropbox have items as expected - Passed");
			} else {
				logger.info("dropbox do not have items as expected - Failed");
				throw new Exception(
						"clientAdministrationPageVerifyRestValues - Failed");
			}
		} catch (Exception exception) {
			logger.error("clientAdministrationPageVerifyOAMPValues - Failed with Exception: "
					+ exception + "...\n");
			throw new Exception(
					"clientAdministrationPageVerifyOAMPValues - Failed - Exception occurs: "
							+ exception);
		}
	}

	public void clientAdministrationPageVerifyFeatureEntitlements(
			WebDriver webDriver) throws Exception {
		logger.info("clientAdministrationPageVerifyFeatureEntitlements - starting...\n");
		try {
			if (selenium
					.isElementTexboxContainText(
							webDriver,
							AADSWeb.CLIENT_ADMINISTRATION_FEATURE_ENTITLEMENTS_PAGE_URL,
							aadsData.WEBLMURL)) {
				logger.info("Correct WebLM URL - Passed");
			} else {
				logger.info("WebLM URL incorrect - Failed");
				throw new Exception("WebLM URL incorrect - Failed");
			}
			logger.info("clientAdministrationPageVerifyFeatureEntitlements - Passed");
		} catch (Exception exception) {
			logger.error("clientAdministrationPageVerifyFeatureEntitlements - Failed with Exception: "
					+ exception + "...\n");
			throw new Exception(
					"clientAdministrationPageVerifyFeatureEntitlements - Failed - Exception occurs: "
							+ exception);
		}
	}

	public void ldapConfigAddNewDirectory(WebDriver webDriver, String browser)
			throws Exception {
		logger.info("ldapConfigAddNewDirectory - starting...\n");
		try {
			// add new Directory
			selenium.clickElement(webDriver, AADSWeb.ADD_NEW_LDAP_BTN_IE);
			logger.info("Input valid value to the required fields starting...\n");
			selenium.dropDownListBoxByValue(
					webDriver,
					AADSWeb.SERVER_CONNECTIONS_LDAP_CONFIG_ENTERPRISE_PAGE_ENTERPRISE_TYPE,
					aadsData.NEW_ENTERPRISE_DIRECTORY_TYPE);
			logger.info("Choose Enterprise-Directory Type completed...\n");
			selenium.inputText(webDriver, AADSWeb.Priority_TXT,
					aadsData.NEW_ENTERPRISE_DIRECTORY_PRIORITY);
			selenium.inputText(webDriver, AADSWeb.Address_TXT,
					aadsData.NEW_ENTERPRISE_DIRECTORY_ADRR);
			logger.info("Input Enterprise-Directory IP address completed...\n");
			selenium.inputText(webDriver, AADSWeb.BindDN_TXT,
					aadsData.NEW_ENTERPRISE_DIRECTORY_BINDDN);
			logger.info("Input Enterprise-Directory BindDN completed...\n");
			selenium.inputText(webDriver, AADSWeb.port_TXT,
					aadsData.NEW_ENTERPRISE_DIRECTORY_PORT);
			logger.info("Input Enterprise-Directory port completed...\n");
			selenium.inputText(webDriver, AADSWeb.BindCredential_TXT,
					aadsData.NEW_ENTERPRISE_DIRECTORY_BIND_CREDENTIAL);
			logger.info("Input Enterprise-Directory bind credential completed...\n");
			selenium.inputText(webDriver, AADSWeb.UIDAttributeID_TXT,
					aadsData.NEW_ENTERPRISE_DIRECTORY_UID);
			logger.info("Input Enterprise-Directory UID completed...\n");

			// click save button
			if (browser == "Chrome") {
				Thread.sleep(500);
				selenium.clickElement(webDriver, AADSWeb.SAVE_LDAP_btn);
			} else {
				// click element 2 times to fix the issue hold button when click
				// on element by automation
				Thread.sleep(500);
				selenium.clickElement(webDriver, AADSWeb.SAVE_LDAP_btn);
				selenium.clickElement(webDriver, AADSWeb.SAVE_LDAP_btn);
			}
			logger.info("Save Enterprise Directory starting...\n");
			selenium.clickElement(
					webDriver,
					AADSWeb.SERVER_CONNECTIONS_LDAP_CONFIG_ENTERPRISE_PAGE_CONFIRM_SAVE_BTN);
			Thread.sleep(60000);
			selenium.clickElement(
					webDriver,
					AADSWeb.SERVER_CONNECTIONS_LDAP_CONFIG_ENTERPRISE_PAGE_SAVE_AND_APPLY_LDAP_OK_BTN);
			logger.info("Save  and apply new LDAP completed...\n");
			logger.info("Restart require...\n");
			selenium.clickElement(
					webDriver,
					AADSWeb.SERVER_CONNECTIONS_LDAP_CONFIG_ENTERPRISE_PAGE_RESTART_AFTER_CONFIG_YES_BTN);
			Thread.sleep(30000);
			selenium.clickElement(
					webDriver,
					AADSWeb.SERVER_CONNECTIONS_LDAP_CONFIG_ENTERPRISE_PAGE_RESTART_COMPLETED_OK_BTN);
			logger.info("Restart after config new LDAP completed...\n");

			logger.info("ldapConfigAddNewDirectory - completed...\n");
		} catch (Exception exception) {
			logger.error("ldapConfigAddNewDirectory - Failed with Exception: "
					+ exception + "...\n");
			throw new Exception(
					"ldapConfigAddNewDirectory - Failed - Exception occurs: "
							+ exception);
		}

	}

	public void ApplicationMGMTPageSelectStartDeviceServices(WebDriver webDriver)
			throws Exception {
		logger.info("ApplicationMGMTPageSelectStopDeviceServices - starting...\n");
		try {
			selenium.clickElement(
					webDriver,
					AADSWeb.SERVICE_CONTROL_APPLICATION_MGMT_PAGE_DEVICE_SERVICES_CHECKBOX);
			selenium.clickElement(
					webDriver,
					AADSWeb.SERVICE_CONTROL_APPLICATION_MGMT_PAGE_DEVICE_SERVICES_SELECT_START_BTN);
			// selenium.clickElement(webDriver,AADSWeb.SERVICE_CONTROL_APPLICATION_MGMT_PAGE_DEVICE_SERVICES_SELECT_START_BTN);
			Thread.sleep(90000);
			selenium.clickElement(
					webDriver,
					AADSWeb.SERVICE_CONTROL_APPLICATION_MGMT_PAGE_DEVICE_SERVICES_START_SUCESSFUL);

		} catch (Exception exception) {
			logger.error("ApplicationMGMTPageSelectStartDeviceServices - Failed with Exception: "
					+ exception + "...\n");
			throw new Exception(
					"ApplicationMGMTPageSelectStartDeviceServices - Failed - Exception occurs: "
							+ exception);
		}
		logger.info("configurationPageSelectConfigurationUser - completed...\n");
	}

	public void ldapConfigEditDirectory(WebDriver webDriver, String browsers)
			throws Exception {
		logger.info("ldapConfigEditDirectory - starting...\n");
		try {
			// Choose directory
			selenium.clickElement(
					webDriver,
					AADSWeb.SERVER_CONNECTIONS_LDAP_CONFIG_ENTERPRISE_PAGE_NEW_DIRECTORY_TAB);
			logger.info("Edit directory - starting...\n");
			selenium.inputText(
					webDriver,
					AADSWeb.SERVER_CONNECTIONS_LDAP_CONFIG_ENTERPRISE_PAGE_BASE_CONTEXT_DN,
					aadsData.NEW_ENTERPRISE_DIRECTORY__BASE_CONTEXT_DN);
			selenium.inputText(
					webDriver,
					AADSWeb.SERVER_CONNECTIONS_LDAP_CONFIG_ENTERPRISE_PAGE_LAST_UPDATE_TIME_ATTRIBUTE_ID,
					aadsData.NEW_ENTERPRISE_DIRECTORY__LAST_UPDATE_TIME_ATTRIBUTE_ID);
			logger.info("Edit directory - completed...\n");
			logger.info("Save edit result  - starting...\n");
			if (browsers == "Chrome") {
				selenium.clickElement(webDriver, AADSWeb.SAVE_LDAP_btn);
			} else {
				selenium.clickElement(webDriver, AADSWeb.SAVE_LDAP_btn);
				selenium.clickElement(webDriver, AADSWeb.SAVE_LDAP_btn);
			}
			selenium.clickElement(
					webDriver,
					AADSWeb.SERVER_CONNECTIONS_LDAP_CONFIG_ENTERPRISE_PAGE_CONFIRM_SAVE_BTN);
			Thread.sleep(60000);
			selenium.clickElement(
					webDriver,
					AADSWeb.SERVER_CONNECTIONS_LDAP_CONFIG_ENTERPRISE_PAGE_SAVE_AND_APPLY_LDAP_OK_BTN);
			logger.info("Save  and apply edit LDAP completed...\n");
			logger.info("Restatrt require...\n");
			selenium.clickElement(
					webDriver,
					AADSWeb.SERVER_CONNECTIONS_LDAP_CONFIG_ENTERPRISE_PAGE_RESTART_AFTER_CONFIG_YES_BTN);
			Thread.sleep(30000);
			selenium.clickElement(
					webDriver,
					AADSWeb.SERVER_CONNECTIONS_LDAP_CONFIG_ENTERPRISE_PAGE_RESTART_COMPLETED_OK_BTN);
			logger.info("Restart after edit LDAP completed...\n");

			logger.info("ldapConfigEditDirectory - completed...\n");
		} catch (Exception exception) {
			logger.error("ldapConfigEditDirectory - Failed with Exception: "
					+ exception + "...\n");
			throw new Exception(
					"ldapConfigEditDirectory - Failed - Exception occurs: "
							+ exception);
		}
	}

	public void ApplicationMGMTPageSelectStopDeviceServices(WebDriver webDriver)
			throws Exception {
		logger.info("ApplicationMGMTPageSelectStopDeviceServices - starting...\n");
		try {
			selenium.clickElement(
					webDriver,
					AADSWeb.SERVICE_CONTROL_APPLICATION_MGMT_PAGE_DEVICE_SERVICES_CHECKBOX);
			Thread.sleep(2000);

			logger.info("ApplicationMGMTPageSelectStopDeviceServices select stop button - starting...\n");
			selenium.clickElement(
					webDriver,
					AADSWeb.SERVICE_CONTROL_APPLICATION_MGMT_PAGE_DEVICE_SERVICES_SELECT_STOP_BTN);
			Thread.sleep(200);
			// selenium.clickElement(webDriver,
			// AADSWeb.SERVICE_CONTROL_APPLICATION_MGMT_PAGE_DEVICE_SERVICES_SELECT_STOP_BTN);

			logger.info("ApplicationMGMTPageSelectStopDeviceServices confirm stop service - starting...\n");
			selenium.clickElement(
					webDriver,
					AADSWeb.SERVICE_CONTROL_APPLICATION_MGMT_PAGE_DEVICE_SERVICES_STOP_SELECT_COFIRM_BTN);
			Thread.sleep(90000);

			logger.info("ApplicationMGMTPageSelectStopDeviceServices infor stop service successful - starting...\n");
			selenium.clickElement(
					webDriver,
					AADSWeb.SERVICE_CONTROL_APPLICATION_MGMT_PAGE_DEVICE_SERVICES_STOP_SUCESSFUL);

		} catch (Exception exception) {
			logger.error("ApplicationMGMTPageSelectStopDeviceServices - Failed with Exception: "
					+ exception + "...\n");
			throw new Exception(
					"ApplicationMGMTPageSelectStopDeviceServices - Failed - Exception occurs: "
							+ exception);

		}
	}

	public void ldapConfigDeletedDirectory(WebDriver webDriver, String browser)
			throws Exception {
		logger.info("ldapConfigDeletedDirectory - starting...\n");
		try {
			// Choose directory
			selenium.clickElement(
					webDriver,
					AADSWeb.SERVER_CONNECTIONS_LDAP_CONFIG_ENTERPRISE_PAGE_NEW_DIRECTORY_TAB);
			// Deleted Directory
			logger.info("Deleted directory - starting...\n");
			if (browser == "Chrome") {
				selenium.clickElement(
						webDriver,
						AADSWeb.SERVER_CONNECTIONS_LDAP_CONFIG_ENTERPRISE_PAGE_DELETED_BTN);
			} else {
				// click element 2 times to fix the issue hold button when click
				// on element by automation
				selenium.clickElement(
						webDriver,
						AADSWeb.SERVER_CONNECTIONS_LDAP_CONFIG_ENTERPRISE_PAGE_DELETED_BTN);
				selenium.clickElement(
						webDriver,
						AADSWeb.SERVER_CONNECTIONS_LDAP_CONFIG_ENTERPRISE_PAGE_DELETED_BTN);
			}
			logger.info("Confirm action deleted directory - starting...\n");
			selenium.clickElement(
					webDriver,
					AADSWeb.SERVER_CONNECTIONS_LDAP_CONFIG_ENTERPRISE_PAGE_CONFIRM_ACTION_OK_BTN);
			logger.info("Confirm action deleted directory completed...\n");
			Thread.sleep(3000);
			selenium.clickElement(
					webDriver,
					AADSWeb.SERVER_CONNECTIONS_LDAP_CONFIG_ENTERPRISE_PAGE_DELETED_SUCCESS_OK_BTN);
			logger.info("Directory was deleted successfully...\n");
			logger.info("ldapConfigDeletedDirectory completed...\n");
		} catch (Exception exception) {
			logger.error("ldapConfigDeletedDirectory - Failed with Exception: "
					+ exception + "...\n");
			throw new Exception(
					"ldapConfigDeletedDirectory - Failed - Exception occurs: "
							+ exception);
		}
	}

	public void serviceInterfacePageImportSecurityRole(WebDriver webDriver,
			String browser) throws Exception {
		logger.info("serviceInterfacePageImportSecurityRole - stating");
		try {
			logger.info("serviceInterfacePageImportSecurityRole - Click import button");
			if (browser == "Chrome") {
				selenium.clickElement(
						webDriver,
						AADSWeb.CERTIFICATE_MANAGEMENT_IDENTITY_CERT_IMPORT_KEYSTORE_BTN);
			} else {

				selenium.clickElement(
						webDriver,
						AADSWeb.CERTIFICATE_MANAGEMENT_IDENTITY_CERT_IMPORT_KEYSTORE_BTN);
				selenium.clickElement(
						webDriver,
						AADSWeb.CERTIFICATE_MANAGEMENT_IDENTITY_CERT_IMPORT_KEYSTORE_BTN);
			}

			Thread.sleep(1000);
			logger.info("serviceInterfacePageImportSecurityRole - Click Choose File button");
			// OpenQA.Selenium.Interactions.Actions actions = new
			// OpenQA.Selenium.Interactions.Actions(webDriver);
			// 2 command below to fix the issue cannot click element input type
			// = "file" on system AWS
			WebElement input = webDriver
					.findElement(AADSWeb.CERTIFICATE_MANAGEMENT_IDENTITY_CERT_IMPORT_KEYSTORE_CHOOSE_FILE_BTN);
			new Actions(webDriver).moveToElement(input).click().perform();
			// command below using for aads or aads cluster test
			// selenium.clickElement(webDriver,
			// AADSWeb.CERTIFICATE_MANAGEMENT_IDENTITY_CERT_IMPORT_KEYSTORE_CHOOSE_FILE_BTN);
			// selenium.clickElement(webDriver,
			// AADSWeb.CERTIFICATE_MANAGEMENT_IDENTITY_CERT_IMPORT_KEYSTORE_CHOOSE_FILE_BTN);
			Thread.sleep(5000);
			if (browser == "IE") {
				Runtime.getRuntime().exec(
						"C:\\seleniumDriver\\AutoIT\\tc_browser_031_IE.exe");
				Thread.sleep(6000);
			} else {
				Runtime.getRuntime().exec(
						"C:\\seleniumDriver\\AutoIT\\tc_browser_031.exe");
			}
			logger.info("serviceInterfacePageImportSecurityRole - Input secirity password");
			selenium.inputText2(
					webDriver,
					AADSWeb.CERTIFICATE_MANAGEMENT_IDENTITY_CERT_IMPORT_KEYSTORE_PWD_TXT,
					aadsData.SECURITY_ROLE_PWD);
			logger.info("serviceInterfacePageImportSecurityRole - Input secirity alias");
			selenium.inputText2(
					webDriver,
					AADSWeb.CERTIFICATE_MANAGEMENT_IDENTITY_CERT_IMPORT_KEYSTORE_ALIAS_TXT,
					aadsData.ALIAS);
			logger.info("serviceInterfacePageImportSecurityRole - press apply button");
			selenium.clickElement(
					webDriver,
					AADSWeb.CERTIFICATE_MANAGEMENT_IDENTITY_CERT_IMPORT_KEYSTORE_APPLY_BTN);
			Thread.sleep(1000);
			if (selenium
					.isElementExisted(
							webDriver,
							AADSWeb.CERTIFICATE_MANAGEMENT_IDENTITY_CERT_IMPORT_KEYSTORE_CONFIRM_OVERRIDE_BTN)) {
				selenium.clickElement(
						webDriver,
						AADSWeb.CERTIFICATE_MANAGEMENT_IDENTITY_CERT_IMPORT_KEYSTORE_CONFIRM_OVERRIDE_BTN);
				Thread.sleep(1000);
				logger.info("serviceInterfacePageImportSecurityRole -  Alias is already exist in Keystore list --> Override it");
			}
			if (selenium
					.isElementExisted(
							webDriver,
							AADSWeb.CERTIFICATE_MANAGEMENT_IDENTITY_CERT_IMPORT_KEYSTORE_CONFIRM_IMPORT_OK_BTN)) {
				logger.info("serviceInterfacePageImportSecurityRole - Confirm import, press ok button");
				selenium.clickElement(
						webDriver,
						AADSWeb.CERTIFICATE_MANAGEMENT_IDENTITY_CERT_IMPORT_KEYSTORE_CONFIRM_IMPORT_OK_BTN);
				Thread.sleep(1000);
			}
			if (selenium
					.isElementExisted(
							webDriver,
							AADSWeb.CERTIFICATE_MANAGEMENT_IDENTITY_CERT_IMPORT_KEYSTORE_DONE_BTN)) {
				logger.info("serviceInterfacePageImportSecurityRole - import successful, press done button");
				selenium.clickElement(
						webDriver,
						AADSWeb.CERTIFICATE_MANAGEMENT_IDENTITY_CERT_IMPORT_KEYSTORE_DONE_BTN);
			}
			logger.info("serviceInterfacePageImportSecurityRole - import certificate successfully");

		} catch (Exception e) {
			logger.error("serviceInterfacePageImportSecurityRole - Failed with Exception: "
					+ e + "...\n");
			throw new Exception(
					"serviceInterfacePageImportSecurityRole - Failed - Exception occurs: "
							+ e);
		}
	}

	public void clusterConfigClusterNodeVerify(WebDriver webDriver, int node,
			String seednode) throws Exception {
		logger.info("clusterConfigClusterNodeVerify - starting...\n");
		try {
			logger.info("Verify virtual ip field - starting...\n");
			if (selenium.isElementExisted(webDriver,
					AADSWeb.CLUSTER_CONFIG_CLUSTER_NODES_PAGE_VIRTUAL_IP_FIELD)) {
				Thread.sleep(2000);
				logger.info("Verify virtual ip masster field - starting...\n");
				if (selenium
						.isElementExisted(
								webDriver,
								AADSWeb.CLUSTER_CONFIG_CLUSTER_NODES_PAGE_VIRTUAL_IP_MASTER_FIELD)) {
					Thread.sleep(2000);
					logger.info("Verify virtual ip backup field - starting...\n");
					if (selenium
							.isElementExisted(
									webDriver,
									AADSWeb.CLUSTER_CONFIG_CLUSTER_NODES_PAGE_VIRTUAL_IP_BACKUP_FIELD)) {
						Thread.sleep(2000);
						logger.info("Verify seed node ip field - starting...\n");
						if (selenium
								.isElementExisted(
										webDriver,
										AADSWeb.CLUSTER_CONFIG_CLUSTER_NODES_PAGE_SEED_NODE_IP_FIELD)) {
							Thread.sleep(2000);
							logger.info("Verify the value of seed node ip field - starting...\n");
							if (selenium
									.isElementContainText(
											webDriver,
											AADSWeb.CLUSTER_CONFIG_CLUSTER_NODES_PAGE_SEED_NODE_IP_TXT,
											seednode)) {
								Thread.sleep(2000);
								// Node = 1 for single
								if (node == 1) {
									// if(selenium.isElementContainText(webDriver,
									// AADSWeb.CLUSTER_CONFIG_CLUSTER_NODES_PAGE_STATUS_SINGLE,
									// "ACTIVE")&&selenium.isElementContainText(webDriver,
									// AADSWeb.CLUSTER_CONFIG_CLUSTER_NODES_PAGE_SINGLETON_SVR_SINGLE,
									// "Yes"))
									if (selenium
											.isElementContainText(
													webDriver,
													AADSWeb.CLUSTER_CONFIG_CLUSTER_NODES_PAGE_STATUS_SINGLE,
													"ACTIVE")) {
										Thread.sleep(2000);
										logger.info("Status display correctly - passed...\n");
									} else {
										logger.info("Status display incorrect - Failed");
										throw new Exception(
												"Status display incorrect - Failed");
									}
								} else {
									Thread.sleep(2000);
									// if(selenium.isElementContainText(webDriver,
									// AADSWeb.CLUSTER_CONFIG_CLUSTER_NODES_PAGE_STATUS_CLUSTER,
									// "ACTIVE")&&selenium.isElementContainText(webDriver,
									// AADSWeb.CLUSTER_CONFIG_CLUSTER_NODES_PAGE_SINGLETON_SVR_CLUSTER,
									// "Yes"))
									if (selenium
											.isElementContainText(
													webDriver,
													AADSWeb.CLUSTER_CONFIG_CLUSTER_NODES_PAGE_STATUS_CLUSTER,
													"ACTIVE")) {
										Thread.sleep(2000);
										logger.info("Status display correctly - passed...\n");
									} else {
										logger.info("Status display incorrect - Failed");
										throw new Exception(
												"Status display incorrect - Failed");
									}
								}
							}
						}
					}
				}
				logger.info("clusterConfigClusterNodeVerify - passed...\n");
			} else {
				logger.info("clusterConfigClusterNodeVerify - Failed");
				throw new Exception("clusterConfigClusterNodeVerify - Failed");
			}
		} catch (Exception exception) {
			logger.error("clusterConfigClusterNodeVerify - Failed with Exception: "
					+ exception + "...\n");
			throw new Exception(
					"clusterConfigClusterNodeVerify - Failed - Exception occurs: "
							+ exception);
		}
	}

	public void changeLogLevel(WebDriver webDriver, String browser)
			throws Exception {
		logger.info("changeLogLevel - starting...\n");
		try {
			/*
			 * if(selenium.isElementContainText(webDriver, AADSWeb.
			 * LOGS_MANAGEMENT_LOG_LEVEL_PAGE_CURRENT_LOGGING_LEVEL_DROPDOWN_BOX
			 * , "FINEST")) { logger.info("Log level aready set FINIEST...\n");
			 * } else {
			 */
			logger.info("Change Current logging level to FINEST - starting...\n");
			selenium.dropDownListBoxByValue(
					webDriver,
					AADSWeb.LOGS_MANAGEMENT_LOG_LEVEL_PAGE_CURRENT_LOGGING_LEVEL_DROPDOWN_BOX,
					"FINEST - All possible messages");
			logger.info("Save change - starting...\n");
			if (browser == "Firefox") {
				selenium.clickElement(webDriver,
						AADSWeb.LOGS_MANAGEMENT_LOG_LEVEL_PAGE_SAVE_BTN);
				selenium.clickElement(webDriver,
						AADSWeb.LOGS_MANAGEMENT_LOG_LEVEL_PAGE_SAVE_BTN);
			} else {
				selenium.clickElement(webDriver,
						AADSWeb.LOGS_MANAGEMENT_LOG_LEVEL_PAGE_SAVE_BTN);
			}
			selenium.clickElement(webDriver,AADSWeb.LOGS_MANAGEMENT_LOG_LEVEL_PAGE_CONFIRM_ACTION_SAVE_BTN);
			//Thread.sleep(50000);
			selenium.clickElement(webDriver,AADSWeb.LOGS_MANAGEMENT_LOG_LEVEL_PAGE_SAVE_SUCCESS_OK_BTN);
			logger.info("Save change - completed...\n");
			logger.info("changeLogLevel- completed...\n");

		} catch (Exception exception) {
			logger.error("changeLogLevel - Failed with Exception: " + exception
					+ "...\n");
			throw new Exception("changeLogLevel - Failed - Exception occurs: "
					+ exception);
		}
	}

	public void collectLogIE(WebDriver webDriver, String host) throws Exception {
		logger.info("collectLog - starting...\n");
		try {
			logger.info("Change Current logging level to FINEST - starting...\n");
			selenium.clickElement(webDriver,
					AADSWeb.logsManagementLogLevelPageCollectBtn(host));
			logger.info("Save change - starting...\n");
			selenium.clickElement(webDriver,
					AADSWeb.LOGS_MANAGERMENT_LOG_LEVEL_PAGE_COLLECT_LOG_OK_BTN);

			selenium.clickElement(webDriver,
					AADSWeb.logsManagementLogLevelPageDownloadBtn(host));
			Thread.sleep(8000);
			Robot r = new Robot();
			r.keyPress(Event.TAB);
			r.keyRelease(Event.TAB);
			r.keyPress(Event.TAB);
			r.keyRelease(Event.TAB);
			r.keyPress(Event.TAB);
			r.keyRelease(Event.TAB);
			r.keyPress(Event.ENTER);
			r.keyRelease(Event.ENTER);
			logger.info("collectLog - completed...\n");
			logger.info("collectLog- completed...\n");

		} catch (Exception exception) {
			logger.error("changeLogLevel - Failed with Exception: " + exception
					+ "...\n");
			throw new Exception("changeLogLevel - Failed - Exception occurs: "
					+ exception);
		}
	}

	public void configurationPageAddNewConfig(WebDriver webDriver, String user)
			throws Exception {
		logger.info("configurationPagePublishUser - starting...\n");
		try {
			Thread.sleep(2000);
			selenium.clickElement(
					webDriver,
					AADSWeb.DYNAMIC_CONFIGURATION_CONFIGURATION_PAGE_SAVE_USER_BTN);
			Thread.sleep(1000);
			selenium.inputText(
					webDriver,
					AADSWeb.DYNAMIC_CONFIGURATION_CONFIGURATION_PAGE_CREATE_USER_TXT,
					user);
			Thread.sleep(1000);
			selenium.clickElement(
					webDriver,
					AADSWeb.DYNAMIC_CONFIGURATION_CONFIGURATION_PAGE_SAVE_USER_COMFIRM_BTN);
			Thread.sleep(3000);
			String message = new String();
			message = selenium
					.getText(
							webDriver,
							AADSWeb.DYNAMIC_CONFIGURATION_CONFIGURATION_PAGE_STATUS_MESSAGE);
			if (message.contains("Test Configuration " + user
					+ " was saved successfully")) {
				logger.info("configurationPagePublishUser - Publish successfully...\n");
			} else
				throw new Exception(
						"testAADS001- Failed - Exception occurs:  Publish user failed....\n");
		} catch (Exception exception) {
			logger.error("configurationPagePublishUser - Failed with Exception: "
					+ exception + "...\n");
			throw new Exception(
					"configurationPagePublishUser - Failed - Exception occurs: "
							+ exception);
		}
		logger.info("configurationPagePublishUser - completed...\n");
	}

	public void configurationPagePublishUserIncludeFlatform(
			WebDriver webDriver, String user, String flatform) throws Exception {
		logger.info("configurationPagePublishUser - starting...\n");
		try {
			Thread.sleep(2000);
			selenium.clickElement(webDriver,AADSWeb.DYNAMIC_CONFIGURATION_CONFIGURATION_PAGE_SAVE_USER_BTN);
			Thread.sleep(2000);
			selenium.clickElement(webDriver,AADSWeb.DYNAMIC_CONFIGURATION_CONFIGURATION_PAGE_SAVE_USER_COMFIRM_BTN);
			Thread.sleep(5000);

			selenium.clickElement(webDriver,AADSWeb.DYNAMIC_CONFIGURATION_CONFIGURATION_PAGE_PUBLISH_USER_BTN);
			Thread.sleep(2000);

			if (!selenium.isElementSelected(webDriver,
					AADSWeb.PUBLISH_WINDOW_FLATFORM_CHECKBOX)) {
				selenium.clickElement(webDriver,AADSWeb.PUBLISH_WINDOW_FLATFORM_CHECKBOX);
			}
			Thread.sleep(3000);
			selenium.dropDownListBox(webDriver,	AADSWeb.PUBLISH_WINDOW_PLATFORM_SELECT, flatform);

			if (!selenium.isElementSelected(webDriver,
					AADSWeb.PUBLISH_WINDOW_USER_CHECKBOX)) {
				selenium.clickElement(webDriver,AADSWeb.PUBLISH_WINDOW_USER_CHECKBOX);
			}
			selenium.inputText(webDriver, AADSWeb.PUBLISH_WINDOW_USER_TXT, user);
			if (!selenium.isElementSelected(webDriver,	AADSWeb.PUBLISH_WINDOW_GROUP_SET_CHECKBOX)) {
				selenium.clickElement(webDriver,AADSWeb.PUBLISH_WINDOW_GROUP_SET_CHECKBOX);
			}
			Thread.sleep(2000);
			if (!selenium.isElementSelected(webDriver,
					AADSWeb.PUBLISH_WINDOW_GLOBAL_SET_CHECKBOX)) {
				selenium.clickElement(webDriver,AADSWeb.PUBLISH_WINDOW_GLOBAL_SET_CHECKBOX);
			}

			/*
			 * selenium.inputText(webDriver,
			 * AADSWeb.PUBLISH_WINDOW_GROUP_SET_TXT, aadsData.AADS_USER_GROUP);
			 * Thread.sleep(2000);
			 */

			selenium.inputText(webDriver, AADSWeb.PUBLISH_WINDOW_GROUP_SET_TXT,	aadsData.AADS_USER_1_GROUP);
			selenium.clickElement(webDriver, AADSWeb.PUBLISH_WINDOW_GROUP_NEW);

			if (!selenium.isElementSelected(webDriver,
					AADSWeb.PUBLISH_WINDOW_FLATFORM_CHECKBOX)) {
				selenium.clickElement(webDriver,AADSWeb.PUBLISH_WINDOW_FLATFORM_CHECKBOX);
			}
			selenium.dropDownListBox(webDriver,	AADSWeb.PUBLISH_WINDOW_PLATFORM_SELECT, flatform);

			selenium.clickElement(webDriver, AADSWeb.PUBLISH_WINDOW_PUBLISH_BTN);
			selenium.clickElement(webDriver, AADSWeb.PUBLISH_WINDOW_PUBLISH_YES_CONFIRM_BTN);
			Thread.sleep(5000);
			String message = new String();
			message = selenium.getText(webDriver,AADSWeb.DYNAMIC_CONFIGURATION_CONFIGURATION_PAGE_STATUS_MESSAGE);
			System.out.println(message);
			if (message.contains("Settings were published successfully")) {
				logger.info("configurationPagePublishUserIncludeFlatform - Publish successfully...\n");
			} else
				throw new Exception("testAADS001- Failed - Exception occurs:  Publish user failed : " + message);
		} catch (Exception exception) {
			logger.error("configurationPagePublishUserIncludeFlatform - Failed with Exception: "	+ exception + "...\n");
			throw new Exception("configurationPagePublishUserIncludeFlatform - Failed - Exception occurs: "+ exception);
		}
		logger.info("configurationPagePublishUserIncludeFlatform - completed...\n");
	}

	public void configurationPageDeleteConfiguration(WebDriver webDriver,String config) throws Exception {
		logger.info("configurationPageDeleteConfiguration - stating");
		try {
			if (selenium.isElementExisted(webDriver,AADSWeb.DYNAMIC_CONFIGURATION_CONFIGURATION_PAGE_IFRAME)) {
				selenium.switchToFrame(webDriver,AADSWeb.DYNAMIC_CONFIGURATION_CONFIGURATION_PAGE_IFRAME);
			}
			
			configurationPageSelectConfigurationUser(webDriver, config);
			logger.info("configurationPageDeleteConfiguration - Click Delete button to delete configuration\n");
			selenium.clickElement(webDriver,AADSWeb.DYNAMIC_CONFIUGRATION_CONFIGURATION_PAGE_DELETE_CONFIGURATION_BTN);
			logger.info("configurationPageDeleteConfiguration - Confirm delete configuration\n");
			selenium.clickElement(webDriver,AADSWeb.DYNAMIC_CONFIGURATION_CONFIGURATION_PAGE_DELETE_CONFIRM_BTN);
			logger.info("configurationPageDeleteConfiguration - Verify message label\n");
			if (!selenium.isElementExisted(webDriver,AADSWeb.autoConfigPageDeleteConfigurationMessage(config))) {
				throw new Exception(
						"configurationPageDeleteConfiguration - Failed");
			}
		} catch (Exception e) {
			logger.error("configurationPageDeleteConfiguration - Failed with Exception: "
					+ e + "...\n");
			throw new Exception(
					"configurationPageDeleteConfiguration - Failed - Exception occurs: "
							+ e);
		}
	}

	public void configurationPageRetriveUserData(WebDriver webDriver,
			String user) throws Exception {
		logger.info("configurationPageRetriveUserData - starting...\n");
		try {
			if (selenium.isElementExisted(webDriver,
					AADSWeb.DYNAMIC_CONFIGURATION_CONFIGURATION_PAGE_IFRAME)) {
				selenium.switchToFrame(webDriver,
						AADSWeb.DYNAMIC_CONFIGURATION_CONFIGURATION_PAGE_IFRAME);
			}
			selenium.clickElement(
					webDriver,
					AADSWeb.DYNAMIC_CONFIGURATION_CONFIGURATION_PAGE_USER_SELECT_BTN);
			selenium.inputText(webDriver,
					AADSWeb.DYNAMIC_CONFIGURATION_CONFIGURATION_PAGE_USER_TXT,
					user);
			selenium.clickElement(
					webDriver,
					AADSWeb.DYNAMIC_CONFIGURATION_CONFIGURATION_PAGE_RETRIEVE_BTN);
			Thread.sleep(3000);
		} catch (Exception exception) {
			logger.error("configurationPageRetriveUserData - Failed with Exception: "
					+ exception + "...\n");
			throw new Exception(
					"configurationPageRetriveUserData - Failed - Exception occurs: "
							+ exception);
		}
		logger.info("configurationPageRetriveUserData - completed...\n");

	}

	public void configurationPageRetriveGroup(WebDriver webDriver, String group)
			throws Exception {
		logger.info("configurationPageRetriveGroup - starting...\n");
		try {
			if (selenium.isElementExisted(webDriver,
					AADSWeb.DYNAMIC_CONFIGURATION_CONFIGURATION_PAGE_IFRAME)) {
				selenium.switchToFrame(webDriver,
						AADSWeb.DYNAMIC_CONFIGURATION_CONFIGURATION_PAGE_IFRAME);
			}
			selenium.clickElement(
					webDriver,
					AADSWeb.DYNAMIC_CONFIGURATION_CONFIGURATION_PAGE_GROUP_SELECT_BTN);
			selenium.inputText(webDriver,
					AADSWeb.DYNAMIC_CONFIGURATION_CONFIGURATION_PAGE_GROUP_TXT,
					group);
			selenium.clickElement(
					webDriver,
					AADSWeb.DYNAMIC_CONFIGURATION_CONFIGURATION_PAGE_RETRIEVE_BTN);
			Thread.sleep(2000);
			// selenium.clickElementByText(webDriver, "Discovered");
			Thread.sleep(3000);
		} catch (Exception e) {
			logger.error("configurationPageRetriveGroup - Failed with Exception: "
					+ e + "...\n");
			throw new Exception(
					"configurationPageRetriveGroup - Failed - Exception occurs: "
							+ e);
		}
	}

	public void dnsPageAddDNSMapping(WebDriver webDriver, String ip,
			String domain) throws Exception {
		logger.info("dnsPageAddDNSMapping - starting...\n");
		try {
			if (selenium.isElementExisted(webDriver,
					AADSWeb.DYNAMIC_CONFIGURATION_DNS_MAPPING_PAGE_IFRAME)) {
				selenium.switchToFrame(webDriver,
						AADSWeb.DYNAMIC_CONFIGURATION_DNS_MAPPING_PAGE_IFRAME);
			}
			selenium.clickElement(webDriver,
					AADSWeb.DYNAMIC_CONFIGURATION_DNS_MAPPING_ADD_BTN);
			selenium.inputText(webDriver,
					AADSWeb.DYNAMIC_CONFIGURATION_DNS_IP_TXT, ip);
			selenium.inputText(webDriver,
					AADSWeb.DYNAMIC_CONFIGURATION_DNS_DOMAIN_TXT, domain);
			selenium.clickElement(webDriver,
					AADSWeb.DYNAMIC_CONFIGURATION_DNS_MAPPING_SAVE_BTN);
		} catch (Exception e) {
			logger.error("dnsPageAddDNSMapping - Failed with Exception: " + e
					+ "...\n");
			throw new Exception(
					"dnsPageAddDNSMapping - Failed - Exception occurs: " + e);
		}
	}

	public void dnsPageDeleteDNSMapping(WebDriver webDriver, String domain)
			throws Exception {
		logger.info("dnsPageDeleteDNSMapping - starting...\n");
		try {
			if (selenium.isElementExisted(webDriver,
					AADSWeb.DYNAMIC_CONFIGURATION_DNS_MAPPING_PAGE_IFRAME)) {
				selenium.switchToFrame(webDriver,
						AADSWeb.DYNAMIC_CONFIGURATION_DNS_MAPPING_PAGE_IFRAME);
			}
			selenium.clearText(webDriver,
					AADSWeb.dynamicConfigurationDNSdomain(domain));
			selenium.clickElement(webDriver,
					AADSWeb.DYNAMIC_CONFIGURATION_DNS_MAPPING_SAVE_BTN);
		} catch (Exception e) {
			logger.error("dnsPageDeleteDNSMapping - Failed with Exception: "
					+ e + "...\n");
			throw new Exception(
					"dnsPageDeleteDNSMapping - Failed - Exception occurs: " + e);
		}
	}

	public void dnsPageVerifyDNSMapping(WebDriver webDriver, String ip,
			String domain, Boolean exist) throws Exception {
		logger.info("dnsPageVerifyDNSMapping - starting...\n");
		try {

			if (selenium.isElementExisted(webDriver,
					AADSWeb.DYNAMIC_CONFIGURATION_DNS_MAPPING_PAGE_IFRAME)) {
				selenium.switchToFrame(webDriver,
						AADSWeb.DYNAMIC_CONFIGURATION_DNS_MAPPING_PAGE_IFRAME);
			}
			Thread.sleep(5000);

			if (exist) {
				if (selenium.isElementExisted(webDriver,
						AADSWeb.dynamicConfigurationDNSip(ip))) {
					String actualDomain = selenium.getAttribute(webDriver,
							AADSWeb.dynamicConfigurationDNSdomainFollowIp(ip),
							"value");
					if (!actualDomain.equalsIgnoreCase(domain)) {
						throw new Exception(
								"dnsPageVerifyDNSMapping - Failed - Domain is incorrect");
					}
					logger.info("dnsPageVerifyDNSMapping - Passed");
				} else {
					throw new Exception(
							"dnsPageVerifyDNSMapping - Expected mapping isn't exist");
				}
			} else {
				if (selenium.isElementExisted(webDriver,
						AADSWeb.dynamicConfigurationDNSip(ip))) {
					throw new Exception(
							"dnsPageVerifyDNSMapping - Expected mapping is exist");
				}
				logger.info("dnsPageVerifyDNSMapping - Passed");
			}
			logger.info("configurationPagePublishUser - completed...\n");
		} catch (Exception e) {

			logger.error("dnsPageVerifyDNSMapping - Failed with Exception: "
					+ e + "...\n");
			throw new Exception(
					"dnsPageVerifyDNSMapping - Failed - Exception occurs: " + e);
		}
	}

	public void selectAllowPasswordsCheckbox(WebDriver webDriver, boolean select)
			throws Exception {
		logger.info("selectAllowPasswordsCheckbox - starting...\n");
		try {
			Thread.sleep(2000);
			if (selenium.isElementExisted(webDriver,
					AADSWeb.DYNAMIC_CONFIGURATION_DEFAULT_FRAME)) {
				selenium.switchToFrame(webDriver,
						AADSWeb.DYNAMIC_CONFIGURATION_DEFAULT_FRAME);
				if (select == true) {
					if (!selenium
							.isElementSelected(
									webDriver,
									AADSWeb.DYNAMIC_CONFIGURATION_DEFAULT_ALLOW_PWD_CHECKBOX)) {
						selenium.clickElement(
								webDriver,
								AADSWeb.DYNAMIC_CONFIGURATION_DEFAULT_ALLOW_PWD_CHECKBOX);
					}
				} else {
					if (selenium
							.isElementSelected(
									webDriver,
									AADSWeb.DYNAMIC_CONFIGURATION_DEFAULT_ALLOW_PWD_CHECKBOX)) {
						selenium.clickElement(
								webDriver,
								AADSWeb.DYNAMIC_CONFIGURATION_DEFAULT_ALLOW_PWD_CHECKBOX);
					}
				}
			}

			if (selenium.isElementExisted(webDriver,
					AADSWeb.DYNAMIC_CONFIGURATION_DEFAULT_PAGE_IFRAME)) {
				selenium.switchToFrame(webDriver,
						AADSWeb.DYNAMIC_CONFIGURATION_DEFAULT_PAGE_IFRAME);
			}
			if (select == true) {
				Thread.sleep(3000);
				if (!selenium
						.isElementSelected(
								webDriver,
								AADSWeb.DYNAMIC_CONFIGURATION_DEFAULT_ALLOW_PWD_CHECKBOX)) {
					selenium.clickElement(
							webDriver,
							AADSWeb.DYNAMIC_CONFIGURATION_DEFAULT_ALLOW_PWD_CHECKBOX);
				}
			} else {
				if (selenium
						.isElementSelected(
								webDriver,
								AADSWeb.DYNAMIC_CONFIGURATION_DEFAULT_ALLOW_PWD_CHECKBOX)) {
					selenium.clickElement(
							webDriver,
							AADSWeb.DYNAMIC_CONFIGURATION_DEFAULT_ALLOW_PWD_CHECKBOX);
				}
			}

		} catch (Exception e) {
			logger.error("selectAllowPasswordsCheckbox - Failed with Exception: "
					+ e + "...\n");
			throw new Exception(
					"selectAllowPasswordsCheckbox - Failed - Exception occurs: "
							+ e);
		}
	}

	public void selectObsecuredPreferenceCheckbox(WebDriver webDriver,
			boolean exist, boolean select) throws Exception {
		try {
			Thread.sleep(2000);
			if (selenium.isElementExisted(webDriver,
					AADSWeb.DYNAMIC_CONFIGURATION_DEFAULT_PAGE_IFRAME)) {
				selenium.switchToFrame(webDriver,
						AADSWeb.DYNAMIC_CONFIGURATION_DEFAULT_PAGE_IFRAME);
			}
			if (exist == selenium
					.isElementExisted(
							webDriver,
							AADSWeb.DYNAMIC_CONFIGURATION_DEFAULT_OBSCURED_PREF_CHECKBOX)) {
				if (select == true) {
					if (!selenium
							.isElementSelected(
									webDriver,
									AADSWeb.DYNAMIC_CONFIGURATION_DEFAULT_OBSCURED_PREF_CHECKBOX)) {
						selenium.clickElement(
								webDriver,
								AADSWeb.DYNAMIC_CONFIGURATION_DEFAULT_OBSCURED_PREF_CHECKBOX);
					}
				} else {
					if (selenium
							.isElementSelected(
									webDriver,
									AADSWeb.DYNAMIC_CONFIGURATION_DEFAULT_OBSCURED_PREF_CHECKBOX)) {
						selenium.clickElement(
								webDriver,
								AADSWeb.DYNAMIC_CONFIGURATION_DEFAULT_OBSCURED_PREF_CHECKBOX);
					}
				}
			} else {
				throw new Exception("selectObsecuredPreferenceCheckbox - False");
			}
		} catch (Exception e) {
			logger.error("selectObsecuredPreferenceCheckbox - Failed with Exception: "
					+ e + "...\n");
			throw new Exception(
					"selectObsecuredPreferenceCheckbox - Failed - Exception occurs: "
							+ e);
		}
	}

	public void selectLockedPreferencesCheckbox(WebDriver webDriver,
			boolean select) throws Exception {
		logger.info("selectLockedPreferencesCheckbox- starting...\n");
		try {
			Thread.sleep(2000);
			if (selenium.isElementExisted(webDriver,
					AADSWeb.DYNAMIC_CONFIGURATION_DEFAULT_PAGE_IFRAME)) {
				selenium.switchToFrame(webDriver,
						AADSWeb.DYNAMIC_CONFIGURATION_DEFAULT_PAGE_IFRAME);
			}
			if (select == true) {
				if (!selenium
						.isElementSelected(
								webDriver,
								AADSWeb.DYNAMIC_CONFIGURATION_DEFAULT_LOCK_PREF_CHECKBOX)) {
					selenium.clickElement(
							webDriver,
							AADSWeb.DYNAMIC_CONFIGURATION_DEFAULT_LOCK_PREF_CHECKBOX);
				}
			} else {
				if (selenium
						.isElementSelected(
								webDriver,
								AADSWeb.DYNAMIC_CONFIGURATION_DEFAULT_LOCK_PREF_CHECKBOX)) {
					selenium.clickElement(
							webDriver,
							AADSWeb.DYNAMIC_CONFIGURATION_DEFAULT_LOCK_PREF_CHECKBOX);
				}
			}

			if (selenium.isElementExisted(webDriver,
					AADSWeb.DYNAMIC_CONFIGURATION_DEFAULT_PAGE_IFRAME)) {
				selenium.switchToFrame(webDriver,
						AADSWeb.DYNAMIC_CONFIGURATION_DEFAULT_PAGE_IFRAME);
			}

			if (select == true) {
				if (!selenium
						.isElementSelected(
								webDriver,
								AADSWeb.DYNAMIC_CONFIGURATION_DEFAULT_LOCK_PREF_CHECKBOX)) {
					selenium.clickElement(
							webDriver,
							AADSWeb.DYNAMIC_CONFIGURATION_DEFAULT_LOCK_PREF_CHECKBOX);
				}
			} else {
				if (selenium
						.isElementSelected(webDriver,AADSWeb.DYNAMIC_CONFIGURATION_DEFAULT_LOCK_PREF_CHECKBOX)) {
					selenium.clickElement(
							webDriver,
							AADSWeb.DYNAMIC_CONFIGURATION_DEFAULT_LOCK_PREF_CHECKBOX);
				}
			}

		} catch (Exception e) {
			logger.error("selectLockedPreferencesCheckbox - Failed with Exception: "
					+ e + "...\n");
			throw new Exception(
					"selectLockedPreferencesCheckbox - Failed - Exception occurs: "
							+ e);
		}
	}

	public void saveAndVerifyDefaultPage(WebDriver webDriver, String message)
			throws Exception {
		logger.info("saveAndVerifyDefaultPage - starting...\n");
		try {
			Thread.sleep(1000);
			if (selenium.isElementExisted(webDriver,
					AADSWeb.DYNAMIC_CONFIGURATION_DEFAULT_PAGE_IFRAME)) {
				selenium.switchToFrame(webDriver,
						AADSWeb.DYNAMIC_CONFIGURATION_DEFAULT_PAGE_IFRAME);
			}
			selenium.clickElement(webDriver,
					AADSWeb.DYNAMIC_CONFIGURATION_DEFAULT_SAVE_BTN);
			Thread.sleep(5000);
			verifyMessageLabel(webDriver, message);
		} catch (Exception e) {
			logger.error("saveAndVerifyDefaultPage - Failed with Exception: "
					+ e + "...\n");
			throw new Exception(
					"saveAndVerifyDefaultPage - Failed - Exception occurs: "
							+ e);
		}
	}

	public void deploymentPageAddAppcastItem(WebDriver webDriver, String type,
			String title, String description, String version, String OS,
			String user, String password, String downloadURL) throws Exception {
		logger.info("deploymentPageAddAppcastItem - starting...\n");
		try {
			selenium.switchToFrame(webDriver, AADSWeb.DEPLOYMENT_PAGE_IFRAME);
			selenium.clickElement(webDriver,
					AADSWeb.WEB_DEPLOYMENT_PAGE_RESET_BTN);
			// selenium.waitUntilElementPresent(webDriver,
			// AADSWeb.WEB_DEPLOYMENT_PAGE_TYPE_DROPLIST, 200);
			// selenium.dropDownListBox(webDriver,
			// AADSWeb.WEB_DEPLOYMENT_PAGE_TYPE_DROPLIST,type);
			selenium.inputText(webDriver,
					AADSWeb.WEB_DEPLOYMENT_PAGE_TITLE_TXT, title);
			selenium.inputText(webDriver,
					AADSWeb.WEB_DEPLOYMENT_PAGE_DESCRIPTION_TXT, description);
			selenium.inputText(webDriver,
					AADSWeb.WEB_DEPLOYMENT_PAGE_VERSION_TXT, version);
			selenium.dropDownListBox(webDriver,
					AADSWeb.WEB_DEPLOYMENT_PAGE_OS_DROPLIST, OS);
			selenium.clickElement(webDriver,
					AADSWeb.WEB_DEPLOYMENT_PAGE_FILE_BTN);

			Thread.sleep(5000);
			Runtime.getRuntime().exec(
					"C:\\seleniumDriver\\AutoIT\\FileUploadIE.exe");
			// Thread.sleep(3000);
			// Runtime.getRuntime().exec("D:\\FileUpload.exe");
			Thread.sleep(4000);
			selenium.clickElement(webDriver,
					AADSWeb.WEB_DEPLOYMENT_PAGE_UPLOAD_BTN);
			/*
			 * selenium.waitUntilElementClickable(webDriver,
			 * AADSWeb.WEB_DEPLOYMENT_PAGE_USERNAME_DIALOG_TXT, timeout);
			 * selenium.inputText(webDriver,
			 * AADSWeb.WEB_DEPLOYMENT_PAGE_USERNAME_DIALOG_TXT,user);
			 * selenium.waitUntilElementClickable(webDriver,
			 * AADSWeb.WEB_DEPLOYMENT_PAGE_PASSWORD_DIALOG_TXT, timeout);
			 * selenium.inputText(webDriver,
			 * AADSWeb.WEB_DEPLOYMENT_PAGE_PASSWORD_DIALOG_TXT,password);
			 */

			selenium.clickElement(webDriver,
					AADSWeb.WEB_DEPLOYMENT_PAGE_UPLOAD_CONTINUE_BTN);
			Thread.sleep(3000);
			selenium.clickElement(webDriver,
					AADSWeb.WEB_DEPLOYMENT_PAGE_UPLOAD_CLOSE_BTN);
			Thread.sleep(4000);
			selenium.scrollToElement(webDriver,
					AADSWeb.WEB_DEPLOYMENT_PAGE_SAVE_BTN);

			selenium.clickElement(webDriver,
					AADSWeb.WEB_DEPLOYMENT_PAGE_CUSTOM_URL_CHECKBOX);
			selenium.inputText(webDriver,
					AADSWeb.WEB_DEPLOYMENT_PAGE_CUSTOM_URL_TXT, downloadURL
							+ title);

			selenium.clickElement(webDriver,
					AADSWeb.WEB_DEPLOYMENT_PAGE_SAVE_BTN);

			Thread.sleep(2000);
			String message = selenium
					.getText(
							webDriver,
							AADSWeb.DYNAMIC_CONFIGURATION_CONFIGURATION_PAGE_STATUS_MESSAGE);
			if (message.contains("Appcast item was saved successfully")) {
				logger.info("deploymentPageAddAppcastItem - Add appcast item successfully...\n");
			} else
				throw new Exception(
						"deploymentPageAddAppcastItem- Failed - Exception occurs:  Add appcast item failed....\n");
		} catch (Exception exception) {
			logger.error("deploymentPageAddAppcastItem - Failed with Exception: "
					+ exception + "...\n");
			throw new Exception(
					"deploymentPageAddAppcastItem - Failed - Exception occurs: "
							+ exception);
		}
		logger.info("deploymentPageAddAppcastItem - completed...\n");

	}

	public void contactIntegrityInputContactEmailAddress(WebDriver webDriver,
			String message) throws Exception {
		logger.info("contactIntegrityInputContactEmailAddress - starting...\n");
		try {
			Thread.sleep(2000);
			selenium.inputText(webDriver, AADSWeb.CONTACT_INTEGRITY_TEXTBOX,
					message);
			selenium.clickElement(webDriver,
					AADSWeb.CONTACT_INTEGRITY_SUBMIT_BTN);
			selenium.clickElement(webDriver,
					AADSWeb.CONTACT_INTEGRITY_SUBMIT_BTN);
		} catch (Exception e) {
			logger.error("contactIntegrityInputContactEmailAddress - Failed with Exception: "
					+ e + "...\n");
			throw new Exception(
					"contactIntegrityInputContactEmailAddress - Failed - Exception occurs: "
							+ e);
		}
	}

	public void contactIntegrityVerifyAnnoncement(WebDriver webDriver,
			String expectedNumber, String browser) throws Exception {
		logger.info("contactIntegrityVerifyAnnoncement - starting...\n");
		try {
			String expected = expectedNumber
					+ " user submitted successfully for contact integrity.";
			String announcement = selenium.getText(webDriver,
					AADSWeb.CONTACT_INTEGRITY_POPUP_TXT);
			if (!expected.contains(announcement)) {
				throw new Exception("contactIntegrityVerifyAnnoncement - False");
			}
			if (browser == "Chrome") {
				WebElement input = webDriver
						.findElement(AADSWeb.CONTACT_INTEGRITY_OK_BTN);
				new Actions(webDriver).moveToElement(input).click().perform();
				new Actions(webDriver).moveToElement(input).click().perform();
			} else {
				WebElement input = webDriver
						.findElement(AADSWeb.CONTACT_INTEGRITY_OK_BTN);
				new Actions(webDriver).moveToElement(input).click().perform();
			}

			logger.info("configurationPageSelectConfigurationUser - completed...\n");
		}

		catch (Exception e) {
			logger.error("contactIntegrityVerifyAnnoncement - Failed with Exception: "
					+ e + "...\n");
			throw new Exception(
					"contactIntegrityVerifyAnnoncement - Failed - Exception occurs: "
							+ e);
		}
	}

	public void verify46xx(WebDriver webDriver, String data, String user)
			throws Exception {
		logger.info("verify46xx - " + data);
		try {
			webDriver.get(aadsData.AADS_SERVER
					+ ":8445/acs/resources/configurations/testconfigs/" + user
					+ "");
			// Thread.sleep(3000);
			String result = selenium.getText(webDriver,
					AADSWeb.DYNAMIC_CONFIGURATION_TESTCONFIG_RESULT);
			if (selenium.isElementContainText(webDriver,
					AADSWeb.DYNAMIC_CONFIGURATION_TESTCONFIG_RESULT, data)) {
				logger.info("verify46xx - Passed");
			} else {
				logger.info("verify46xx - Failed");
				throw new Exception("Failed - " + result + " but expected: "
						+ data);
			}
		} catch (Exception e) {
			logger.error("configurationPageVerifyGroupDisplay - Failed with Exception: "
					+ e + "...\n");
			throw new Exception(
					"configurationPageVerifyGroupDisplay - Failed - Exception occurs: "
							+ e);
		}

	}
//############################################################################################################################################################
//																																				DUY NGUYEN
//############################################################################################################################################################
	public boolean verifyPortalSettingsPageChangeImg(WebDriver webDriver) throws Exception {
		logger.info("esgPortalSettingsPageChangeImg - starting...\n");
		boolean s = false;
		try {
			Thread.sleep(5000);
			selenium.waitUntilElementClickable(webDriver, AADSWeb.ESG_PORTAL_SETTINGS_PAGE, 200);
			selenium.clickElement(webDriver, AADSWeb.ESG_PORTAL_SETTINGS_PAGE);
			Thread.sleep(5000);
			WebElement element1 = webDriver.findElement(AADSWeb.ESG_PORTAL_SETTINGS_PAGE_DETAIL_IMG);
			String src1= ((JavascriptExecutor)webDriver).executeScript("return arguments[0].attributes['src'].value", element1).toString();
			selenium.waitUntilElementClickable(webDriver, AADSWeb.ESG_PORTAL_SETTINGS_PAGE_CHANGE_IMG, 1000);
			WebElement input = webDriver.findElement(AADSWeb.ESG_PORTAL_SETTINGS_PAGE_CHANGE_IMG);
			new Actions(webDriver).moveToElement(input).click().perform();
			Thread.sleep(5000);
			Runtime.getRuntime().exec("C:\\seleniumDriver\\AutoIT\\FileUploadEsgPortal.exe");
			Thread.sleep(4000);
			WebElement element = webDriver.findElement(AADSWeb.ESG_PORTAL_SETTINGS_PAGE_DETAIL_IMG);
			String src= ((JavascriptExecutor)webDriver).executeScript("return arguments[0].attributes['src'].value", element).toString();
			Thread.sleep(5000);
			if(src.equals(src1))
			{
				logger.info("esgPortalSettingsPageChangeImg - Failed...\n");
			}
			else {
				s= true;
				logger.info("esgPortalSettingsPageChangeImg - Passed...\n");
				
			}
			selenium.waitUntilElementClickable(webDriver, AADSWeb.ESG_PORTAL_SETTINGS_PAGE_OK_BTN, 200);
			selenium.clickElement(webDriver, AADSWeb.ESG_PORTAL_SETTINGS_PAGE_OK_BTN);
			webDriver.get(src);
			
		} catch (Exception exception) {
		
			logger.error("esgPortalSettingsPageChangeImg - Failed with Exception: " + exception + "...\n");
			throw new Exception("esgPortalSettingsPageChangeImg - Failed - Exception occurs: " + exception);
		}
		logger.info("esgPortalSettingsPageChangeImg - completed...\n");
		return s;
	}
	
	public boolean verifyAllowUserUploadPictureCheckbox(WebDriver webDriver, String expectedMessage)throws Exception  {
		boolean n = false;
		logger.info("verifyAllowUserUploadPictureCheckbox - Start...\n");
		try {
			logger.info("verfiy message status alllow user upload picture checkbox ");
			if (selenium.isElementExisted(webDriver, AADSWeb.DYNAMIC_CONFIGURATION_CONFIGURATION_PAGE_STATUS_MESSAGE)) {
				String actualMessage = selenium.getText(webDriver,AADSWeb.DYNAMIC_CONFIGURATION_CONFIGURATION_PAGE_STATUS_MESSAGE);
				logger.info("get status user upload picture checkbox ");
				if (actualMessage.equals(expectedMessage)) {
					logger.info("AllowUserUploadPictureCheckbox - Passed...\n");
					n = true;
				}else {
					logger.info("AllowUserUploadPictureCheckbox - Failed...\n");
					}
			}else {
				logger.info("AllowUserUploadPictureCheckbox - Failed...\n");
				}
		}catch (Exception e) {
			throw new Exception("verifyAllowUserUploadPictureCheckbox - Failed - Exception occurs: " + e);
		}
		return n;
	}

	public boolean verifyPortalSettingsPageUploadImgExisted(WebDriver webDriver) throws Exception{
		logger.info("verifyMultimediaMessagingExisted - starting...\n");
		boolean s = false;
		try {
			Thread.sleep(1000);
			selenium.waitUntilElementClickable(webDriver, AADSWeb.ESG_PORTAL_SETTINGS_PAGE, 200);
			selenium.clickElement(webDriver, AADSWeb.ESG_PORTAL_SETTINGS_PAGE);
			
			Thread.sleep(2000);
			if(selenium.isElementExisted(webDriver, AADSWeb.ESG_PORATL_SETTINGS_PAGE_UPLOAD_IMG_CLASS))
			{
				s = false;
				logger.info("verifyMultimediaMessagingExisted - FAILED...\n");
			}
			else {
				s = true;
				logger.info("verifyMultimediaMessagingExisted - PASSED...\n");
			}
			Thread.sleep(2000);
			selenium.waitUntilElementClickable(webDriver, AADSWeb.ESG_PORTAL_SETTINGS_PAGE_OK_BTN, 200);
			selenium.clickElement(webDriver, AADSWeb.ESG_PORTAL_SETTINGS_PAGE_OK_BTN);
		} catch (Exception exception) {
			logger.error("esgPortalSettingsPageChangeImg - Failed with Exception: " + exception + "...\n");
			throw new Exception("esgPortalSettingsPageChangeImg - Failed - Exception occurs: " + exception);
		}
		logger.info("esgPortalSettingsPageChangeImg - completed...\n");
		return s;
    }
//############################################################################################################################################################
//																																				DUY NGUYEN
//############################################################################################################################################################
	public void verifyMessageLabel(WebDriver webDriver, String expectedMessage)
			throws Exception {
		logger.info("verifyMessageLabel - Start");
		try {
			Thread.sleep(5000);
			logger.info("Verify if message label existed");
			if (selenium
					.isElementExisted(
							webDriver,
							AADSWeb.DYNAMIC_CONFIGURATION_CONFIGURATION_PAGE_STATUS_MESSAGE)) {
				String actualMessage = selenium
						.getText(
								webDriver,
								AADSWeb.DYNAMIC_CONFIGURATION_CONFIGURATION_PAGE_STATUS_MESSAGE);
				// String actualMessage = selenium.getAttribute(webDriver,
				// AADSWeb.DYNAMIC_CONFIGURATION_CONFIGURATION_PAGE_STATUS_MESSAGE,"value");
				logger.info("Verify message content");

				/*
				 * if(actualMessage!=expectedMessage){
				 * 
				 * if(!actualMessage.equalsIgnoreCase(expectedMessage)){
				 * 
				 * throw new Exception(
				 * "configurationPageDeleteConfiguration - Failed: Actual Message is: "
				 * +actualMessage+" but expected: "+expectedMessage); }
				 */
				if (actualMessage.equals(expectedMessage)) {
					// throw new
					// Exception("configurationPageDeleteConfiguration - Failed: Actual Message is: "+actualMessage+" but expected: "+expectedMessage);
					logger.info("Passed");
				}
			} else {
				throw new Exception(
						"verifyMessageLabel - Failed - Message label didn't exist");
			}
		} catch (Exception e) {

			logger.error("verifyMessageLabel - Failed with Exception: " + e
					+ "...\n");
			throw new Exception(
					"verifyMessageLabel - Failed - Exception occurs: " + e);
		}
	}

	public void deploymentPageEditAppcastItem(WebDriver webDriver,
			String description, String titlenew, String descriptionnew)
			throws Exception {
		logger.info("deploymentPageEditAppcastItem - starting...\n");
		try {
			selenium.switchToFrame(webDriver, AADSWeb.DEPLOYMENT_PAGE_IFRAME);
			selenium.clickElement(webDriver,
					AADSWeb.WEB_DEPLOYMENT_PAGE_RESET_BTN);
			Thread.sleep(2000);
			selenium.scrollToElement(webDriver,
					AADSWeb.webDeploymentPageAppcastitemLocators(description));
			selenium.clickElement(webDriver,
					AADSWeb.webDeploymentPageAppcastitemLocators(description));
			Thread.sleep(2000);
			selenium.scrollToElement(webDriver,
					AADSWeb.WEB_DEPLOYMENT_PAGE_TITLE_TXT);
			selenium.inputText(webDriver,
					AADSWeb.WEB_DEPLOYMENT_PAGE_TITLE_TXT, titlenew);
			selenium.inputText(webDriver,
					AADSWeb.WEB_DEPLOYMENT_PAGE_DESCRIPTION_TXT, descriptionnew);

			selenium.scrollToElement(webDriver,
					AADSWeb.WEB_DEPLOYMENT_PAGE_SAVE_BTN);
			selenium.clickElement(webDriver,
					AADSWeb.WEB_DEPLOYMENT_PAGE_SAVE_BTN);
			Thread.sleep(2000);
			String message = selenium
					.getText(
							webDriver,
							AADSWeb.DYNAMIC_CONFIGURATION_CONFIGURATION_PAGE_STATUS_MESSAGE);
			if (message.contains("Appcast item was saved successfully")) {
				logger.info("deploymentPageEditAppcastItem - Add appcast item successfully...\n");
			} else
				throw new Exception(
						"deploymentPageEditAppcastItem- Failed - Exception occurs:  Add appcast item failed....\n");
		} catch (Exception exception) {
			logger.error("deploymentPageEditAppcastItem - Failed with Exception: "
					+ exception + "...\n");
			throw new Exception(
					"deploymentPageEditAppcastItem - Failed - Exception occurs: "
							+ exception);
		}
		logger.info("deploymentPageEditAppcastItem - completed...\n");
	}

	public void deploymentPageDeleteAppcastItem(WebDriver webDriver,
			String description) throws Exception {
		logger.info("deploymentPageDeleteAppcastItem - starting...\n");
		try {
			selenium.switchToFrame(webDriver, AADSWeb.DEPLOYMENT_PAGE_IFRAME);
			selenium.clickElement(webDriver,
					AADSWeb.WEB_DEPLOYMENT_PAGE_RESET_BTN);
			Thread.sleep(2000);
			selenium.scrollToElement(webDriver,
					AADSWeb.webDeploymentPageAppcastitemLocators(description));
			selenium.clickElement(webDriver,
					AADSWeb.webDeploymentPageAppcastitemLocators(description));
			Thread.sleep(2000);
			selenium.scrollToElement(webDriver,
					AADSWeb.WEB_DEPLOYMENT_PAGE_DELETE_BTN);
			selenium.clickElement(webDriver,
					AADSWeb.WEB_DEPLOYMENT_PAGE_DELETE_BTN);
			Thread.sleep(2000);
			selenium.scrollToElement(webDriver,
					AADSWeb.WEB_DEPLOYMENT_PAGE_DELETE_CONFIRM_BTN);
			selenium.clickElement(webDriver,
					AADSWeb.WEB_DEPLOYMENT_PAGE_DELETE_CONFIRM_BTN);
			Thread.sleep(2000);

			String message = selenium
					.getText(
							webDriver,
							AADSWeb.DYNAMIC_CONFIGURATION_CONFIGURATION_PAGE_STATUS_MESSAGE);
			if (message.contains("was deleted successfully")) {
				logger.info("deploymentPageDeleteAppcastItem - Delete appcast item successfully...\n");
			} else
				throw new Exception(
						"deploymentPageDeleteAppcastItem- Failed - Exception occurs:  Delete appcast item failed....\n");
		} catch (Exception exception) {
			logger.error("deploymentPageDeleteAppcastItem - Failed with Exception: "
					+ exception + "...\n");
			throw new Exception(
					"deploymentPageDeleteAppcastItem - Failed - Exception occurs: "
							+ exception);
		}
		logger.info("deploymentPageDeleteAppcastItem - completed...\n");
	}

	public void selectAllowUserUploadPictureCheckbox(WebDriver webDriver,
			boolean select) throws Exception {
		try {

			if (selenium.isElementExisted(webDriver,
					AADSWeb.DYNAMIC_CONFIGURATION)) {
				selenium.switchToFrame(webDriver, AADSWeb.DYNAMIC_CONFIGURATION);
				if (select == true) {
					// modified

					if (!selenium
							.isElementSelected(
									webDriver,
									AADSWeb.PICTURES_CONFIGURATION_ALLOW_USER_UPLOAD_PHOTO_CHECKBOX)) {
						selenium.clickElement(
								webDriver,
								AADSWeb.PICTURES_CONFIGURATION_ALLOW_USER_UPLOAD_PHOTO_CHECKBOX);
					}
				} else {
					if (selenium
							.isElementSelected(
									webDriver,
									AADSWeb.PICTURES_CONFIGURATION_ALLOW_USER_UPLOAD_PHOTO_CHECKBOX)) {
						selenium.clickElement(
								webDriver,
								AADSWeb.PICTURES_CONFIGURATION_ALLOW_USER_UPLOAD_PHOTO_CHECKBOX);
					}
				}
				selenium.isElementExisted(webDriver,
						AADSWeb.BTN_SAVE_ALLOW_UPLOAP_PICTURE);
				selenium.clickElement(webDriver,
						AADSWeb.BTN_SAVE_ALLOW_UPLOAP_PICTURE);
			}

			if (selenium.isElementExisted(webDriver,
					AADSWeb.PICTURE_CONFIGURATION_PAGE_IFRAME)) {
				selenium.switchToFrame(webDriver,
						AADSWeb.PICTURE_CONFIGURATION_PAGE_IFRAME);
			}
			if (select == true) {
				if (!selenium
						.isElementSelected(
								webDriver,
								AADSWeb.PICTURES_CONFIGURATION_ALLOW_USER_UPLOAD_PHOTO_CHECKBOX)) {
					selenium.clickElement(
							webDriver,
							AADSWeb.PICTURES_CONFIGURATION_ALLOW_USER_UPLOAD_PHOTO_CHECKBOX);
				}
			} else {
				if (selenium
						.isElementSelected(
								webDriver,
								AADSWeb.PICTURES_CONFIGURATION_ALLOW_USER_UPLOAD_PHOTO_CHECKBOX)) {
					selenium.clickElement(
							webDriver,
							AADSWeb.PICTURES_CONFIGURATION_ALLOW_USER_UPLOAD_PHOTO_CHECKBOX);
				}
			}

			selenium.clickElement(webDriver,
					AADSWeb.PICTURES_CONFIGURATION_SAVE_BTN);

		} catch (Exception e) {

			logger.error("selectAllowUserUploadPictureCheckbox - Failed with Exception: "
					+ e + "...\n");
			throw new Exception(
					"selectAllowUserUploadPictureCheckbox - Failed - Exception occurs: "
							+ e);
		}

	}

	public void selectAllowUserUploadPictureCheckboxWithoutSave(
			WebDriver webDriver, boolean select) throws Exception {
		logger.info("selectAllowUserUploadPictureCheckbox - Start");
		try {

			/*
			 * if(selenium.isElementExisted(webDriver,
			 * AADSWeb.DYNAMIC_CONFIGURATION)) {
			 * selenium.switchToFrame(webDriver, AADSWeb.DYNAMIC_CONFIGURATION);
			 * if (select == true){ //modified
			 * 
			 * if (!selenium.isElementSelected(webDriver,
			 * AADSWeb.PICTURES_CONFIGURATION_ALLOW_USER_UPLOAD_PHOTO_CHECKBOX))
			 * { selenium.clickElement(webDriver,
			 * AADSWeb.PICTURES_CONFIGURATION_ALLOW_USER_UPLOAD_PHOTO_CHECKBOX);
			 * }} else { if (selenium.isElementSelected(webDriver,
			 * AADSWeb.PICTURES_CONFIGURATION_ALLOW_USER_UPLOAD_PHOTO_CHECKBOX))
			 * { selenium.clickElement(webDriver,
			 * AADSWeb.PICTURES_CONFIGURATION_ALLOW_USER_UPLOAD_PHOTO_CHECKBOX);
			 * }} selenium.isElementExisted(webDriver,
			 * AADSWeb.BTN_SAVE_ALLOW_UPLOAP_PICTURE);
			 * selenium.clickElement(webDriver,
			 * AADSWeb.BTN_SAVE_ALLOW_UPLOAP_PICTURE); }
			 */

			if (selenium.isElementExisted(webDriver,
					AADSWeb.PICTURE_CONFIGURATION_PAGE_IFRAME)) {
				selenium.switchToFrame(webDriver,
						AADSWeb.PICTURE_CONFIGURATION_PAGE_IFRAME);
			}
			if (select == true) {
				if (!selenium.isElementSelected(webDriver,AADSWeb.PICTURES_CONFIGURATION_ALLOW_USER_UPLOAD_PHOTO_CHECKBOX)) {
					selenium.clickElement(webDriver,AADSWeb.PICTURES_CONFIGURATION_ALLOW_USER_UPLOAD_PHOTO_CHECKBOX);
				}
			} else {
				if (selenium.isElementSelected(webDriver,AADSWeb.PICTURES_CONFIGURATION_ALLOW_USER_UPLOAD_PHOTO_CHECKBOX)) {
					selenium.clickElement(webDriver,AADSWeb.PICTURES_CONFIGURATION_ALLOW_USER_UPLOAD_PHOTO_CHECKBOX);
				}
			}

			// selenium.clickElement(webDriver,
			// AADSWeb.PICTURES_CONFIGURATION_SAVE_BTN);

		} catch (Exception e) {

			logger.error("selectAllowUserUploadPictureCheckbox - Failed with Exception: "
					+ e + "...\n");
			throw new Exception(
					"selectAllowUserUploadPictureCheckbox - Failed - Exception occurs: "
							+ e);
		}

	}

	public void configurationPageRetriveUser(WebDriver webDriver, String user)
			throws Exception {
		logger.info("ConfigurationPageRetriveUser - starting...\n");
		try {
			selenium.switchToFrame(webDriver,
					AADSWeb.DYNAMIC_CONFIGURATION_CONFIGURATION_PAGE_IFRAME);
			selenium.clickElement(
					webDriver,
					AADSWeb.DYNAMIC_CONFIGURATION_CONFIGURATION_PAGE_USER_SELECT_BTN);
			selenium.inputText(webDriver,
					AADSWeb.DYNAMIC_CONFIGURATION_CONFIGURATION_PAGE_USER_TXT,
					user);
			selenium.clickElement(
					webDriver,
					AADSWeb.DYNAMIC_CONFIGURATION_CONFIGURATION_PAGE_RETRIEVE_BTN);
			Thread.sleep(2000);
			selenium.clickElementByText(webDriver, "Discovered");
			Thread.sleep(3000);
		} catch (Exception e) {

			logger.error("configurationPageRetriveUser - Failed with Exception: "
					+ e + "...\n");
			throw new Exception(
					"configurationPageRetriveUser - Failed - Exception occurs: "
							+ e);
		}
	}

	public void verifyLoginInformation(WebDriver webDriver, String userName,
			String role) throws Exception {
		logger.info("verifyLoginInformation - starting...\n");
		try {
			String aUserName = selenium.getText(webDriver,
					AADSWeb.LOGIN_INFO_USER_NAME);
			String aRole = selenium.getText(webDriver,
					AADSWeb.LOGIN_INFO_USER_ROLE);
			if (aUserName.contains(userName) && aRole.contains(role)) {
				logger.info("verifyLoginInformation - PASSED");

				// selenium.clickElement(webDriver,
				// AADSWeb.CONTACT_INTEGRITY_OK_BTN);
			} else
				throw new Exception("verifyLoginInformation - False");

		} catch (Exception e) {

			logger.error("verifyLoginInformation - Failed with Exception: " + e
					+ "...\n");
			throw new Exception(
					"verifyLoginInformation - Failed - Exception occurs: " + e);
		}
	}

	public void aboutButtonVerifyTabContent(WebDriver webDriver, String tab,
			String content) throws Exception {
		logger.info("");
		try {

			selenium.clickElement(webDriver, AADSWeb.ABOUT_BTN);
			if (!selenium
					.isElementSelected(webDriver, AADSWeb.aboutBtnTab(tab))) {
				selenium.clickElement(webDriver, AADSWeb.aboutBtnTab(tab));
			}
			String aContent = selenium.getText(webDriver,
					AADSWeb.ABOUT_BTN_VERSION);

			if (!aContent.contains(content)) {
				logger.info("aboutButtonVerifyTabConten - Failed");
			}

			if (aContent.contains(content)) {
				throw new Exception("aboutButtonVerifyTabContent - PASSED");
			}
			selenium.clickElement(webDriver, AADSWeb.ABOUT_BTN_CLOSE_BTN);
			logger.info("aboutButtonVerifyTabContent-Passed");

		} catch (Exception e) {

			logger.error("aboutButtonVerifyTabContent - Failed with Exception: "
					+ e + "...\n");
			throw new Exception(
					"aboutButtonVerifyTabContent - Failed - Exception occurs: "
							+ e);
		}
	}

	public void aboutButtonVerifyTabContent1(WebDriver webDriver, String tab,
			String content) throws Exception {
		logger.info("");
		try {

			selenium.clickElement(webDriver, AADSWeb.ABOUT_BTN);
			if (!selenium
					.isElementSelected(webDriver, AADSWeb.aboutBtnTab(tab))) {
				selenium.clickElement(webDriver, AADSWeb.aboutBtnTab(tab));
			}
			String aContent = selenium.getText(webDriver,
					AADSWeb.ABOUT_BTN_LICENSE);
			if (aContent.equals(content)) {
				throw new Exception("aboutButtonVerifyTabContent - Failed");
			}
			selenium.clickElement(webDriver, AADSWeb.ABOUT_BTN_CLOSE_BTN);
			logger.info("aboutButtonVerifyTabContent-Passed");

		} catch (Exception e) {

			logger.error("aboutButtonVerifyTabContent - Failed with Exception: "
					+ e + "...\n");
			throw new Exception(
					"aboutButtonVerifyTabContent - Failed - Exception occurs: "
							+ e);
		}
	}

	public void confirmDiscardConfiguration(WebDriver webDriver)
			throws Exception {
		logger.info("confirmDiscardConfiguration - starting...\n");
		try {

			selenium.clickElement(webDriver, AADSWeb.CONFIRM_DISCARD_OK);
		} catch (Exception e) {
			logger.error("confirmDiscardConfiguration - Failed with Exception: "
					+ e + "...\n");
			throw new Exception(
					"confirmDiscardConfiguration - Failed - Exception occurs: "
							+ e);
		}
	}

	public void serviceInterfacePageDeleteSecurityRole(WebDriver webDriver,
			String browser) throws Exception {
		logger.info("serviceInterfacePageDeleteSecurityRole - stating");
		try {
			Thread.sleep(5000);
			String alias = aadsData.ALIAS.toLowerCase();
			if (selenium
					.isElementExisted(
							webDriver,
							AADSWeb.CERTIFICATE_MANAGEMENT_IDENTITY_CERT_EXPORT_KEYSTORE_SELECT_CERT(alias))) {
				logger.info("serviceInterfacePageDeleteSecurityRole - Select certificate");
				selenium.clickElement(
						webDriver,
						AADSWeb.CERTIFICATE_MANAGEMENT_IDENTITY_CERT_EXPORT_KEYSTORE_SELECT_CERT(alias));
				logger.info("serviceInterfacePageDeleteSecurityRole - press delete button");
				if (browser == "Chrome") {

					selenium.clickElement(
							webDriver,
							AADSWeb.CERTIFICATE_MANAGEMENT_IDENTITY_CERT_DELETE_KEYSTORE_BTN);
				} else {

					selenium.clickElement(
							webDriver,
							AADSWeb.CERTIFICATE_MANAGEMENT_IDENTITY_CERT_DELETE_KEYSTORE_BTN);
					selenium.clickElement(
							webDriver,
							AADSWeb.CERTIFICATE_MANAGEMENT_IDENTITY_CERT_DELETE_KEYSTORE_BTN);
				}

				logger.info("serviceInterfacePageDeleteSecurityRole - press ok button");

				selenium.clickElement(
						webDriver,
						AADSWeb.CERTIFICATE_MANAGEMENT_IDENTITY_CERT_DELETE_KEYSTORE_CONFIRM_OK_BTN);
				Thread.sleep(3000);
				if (selenium
						.isElementExisted(
								webDriver,
								AADSWeb.CERTIFICATE_MANAGEMENT_IDENTITY_CERT_DELETE_KEYSTORE_SUCCESSFUL_DONE_BTN)) {
					logger.info("serviceInterfacePageDeleteSecurityRole - press done button");
					selenium.clickElement(
							webDriver,
							AADSWeb.CERTIFICATE_MANAGEMENT_IDENTITY_CERT_DELETE_KEYSTORE_SUCCESSFUL_DONE_BTN);
				}
				logger.info("serviceInterfacePageDeleteSecurityRole - Delete certificate successfully");

			} else {
				logger.info("serviceInterfacePageDeleteSecurityRole - Don't have any security role in list");

				throw new Exception(
						"serviceInterfacePageDeleteSecurityRole - Don't have any security role in list - Failed");
			}

		} catch (Exception e) {
			logger.error("serviceInterfacePageDeleteSecurityRole - Failed with Exception: "
					+ e + "...\n");
			throw new Exception(
					"serviceInterfacePageDeleteSecurityRole - Failed - Exception occurs: "
							+ e);
		}
	}

	public void serviceInterfacePageExportSecurityRole(WebDriver webDriver,
			String browser) throws Exception {
		logger.info("serviceInterfacePageExportSecurityRole - stating");
		try {
			logger.info("serviceInterfacePageExportSecurityRole - Select certificate");
			String alias = aadsData.ALIAS.toLowerCase();
			selenium.clickElement(
					webDriver,
					AADSWeb.CERTIFICATE_MANAGEMENT_IDENTITY_CERT_EXPORT_KEYSTORE_SELECT_CERT(alias));
			logger.info("serviceInterfacePageExportSecurityRole - press export button");
			if (browser == "Chrome") {
				selenium.clickElement(
						webDriver,
						AADSWeb.CERTIFICATE_MANAGEMENT_IDENTITY_CERT_EXPORT_KEYSTORE_BTN);
			} else {
				selenium.clickElement(
						webDriver,
						AADSWeb.CERTIFICATE_MANAGEMENT_IDENTITY_CERT_EXPORT_KEYSTORE_BTN);
				selenium.clickElement(
						webDriver,
						AADSWeb.CERTIFICATE_MANAGEMENT_IDENTITY_CERT_EXPORT_KEYSTORE_BTN);
			}
			logger.info("serviceInterfacePageExportSecurityRole - input security role password");
			selenium.inputText2(
					webDriver,
					AADSWeb.CERTIFICATE_MANAGEMENT_IDENTITY_CERT_IMPORT_KEYSTORE_PWD_TXT,
					aadsData.SECURITY_ROLE_PWD);
			logger.info("serviceInterfacePageExportSecurityRole - confirm export, press ok button");
			// Runtime.getRuntime().exec("C:\\seleniumDriver\\AutoIT\\tc_browser_030_IE.exe");
			selenium.clickElement(
					webDriver,
					AADSWeb.CERTIFICATE_MANAGEMENT_IDENTITY_CERT_EXPORT_KEYSTORE_OK_BTN);

			logger.info("serviceInterfacePageExportSecurityRole -  export certificate successfull");
		} catch (Exception e) {
			logger.error("serviceInterfacePageExportSecurityRole - Failed with Exception: "
					+ e + "...\n");
			throw new Exception(
					"serviceInterfacePageExportSecurityRole - Failed - Exception occurs: "
							+ e);
		}
	}

	public void corsConfigurationServiceInterface(WebDriver webDriver)
			throws Exception {
		logger.info("corsConfiguration - starting...\n");
		try {
			// if(selenium.isElementExisted(webDriver,
			// AADSWeb.Ser_DEFAULT_FRAME))
			// {
			// selenium.switchToFrame(webDriver, AADSWeb.Ser_DEFAULT_FRAME);
			if (selenium.isElementSelected(webDriver,
					AADSWeb.SERVER_CONNECTION_CORS_OBJECT)) {
				if (!selenium
						.isElementSelected(
								webDriver,
								AADSWeb.SERVER_CONNECTIONS_CORS_CONFIG_SERVICE_INTERFACE_CORS_CHECKBOX)) {
					selenium.clickElement(
							webDriver,
							AADSWeb.SERVER_CONNECTIONS_CORS_CONFIG_SERVICE_INTERFACE_CORS_CHECKBOX);
				}
				if (selenium
						.isElementSelected(
								webDriver,
								AADSWeb.SERVER_CONNECTIONS_CORS_CONFIG_SERVICE_INTERFACE_ORIGIN_CHECKBOX)) {
					selenium.clickElement(
							webDriver,
							AADSWeb.SERVER_CONNECTIONS_CORS_CONFIG_SERVICE_INTERFACE_ORIGIN_CHECKBOX);
				}
				logger.info("Input specific domain - starting...\n");
				selenium.inputText(
						webDriver,
						AADSWeb.SERVER_CONNECTIONS_CORS_CONFIG_SERVICE_INTERFACE_DOMAIN_TXT,
						aadsData.CORS_CONFIG_SPECIFIC_DOMAIN);
				logger.info("save service interface config - starting...\n");
				selenium.clickElement(
						webDriver,
						AADSWeb.SERVER_CONNECTIONS_CORS_CONFIG_SERVICE_INTERFACE_SAVE_BTN);
				Thread.sleep(3000);
				selenium.clickElement(
						webDriver,
						AADSWeb.SERVER_CONNECTIONS_CORS_CONFIG_SERVICE_INTERFACE_CONFIRM_ACTION_SAVE_BTN);
				logger.info("save service interface config - completed...\n");
				logger.info("corsConfigurationServiceInterface - completed...\n");
			}
			// }
			/*
			 * if(!selenium.isElementSelected(webDriver, AADSWeb.
			 * SERVER_CONNECTIONS_CORS_CONFIG_SERVICE_INTERFACE_CORS_CHECKBOX))
			 * { selenium.waitUntilElementClickable(webDriver, AADSWeb.
			 * SERVER_CONNECTIONS_CORS_CONFIG_SERVICE_INTERFACE_CORS_CHECKBOX,
			 * 200); selenium.clickElement(webDriver, AADSWeb.
			 * SERVER_CONNECTIONS_CORS_CONFIG_SERVICE_INTERFACE_CORS_CHECKBOX);
			 * } if(selenium.isElementSelected(webDriver, AADSWeb.
			 * SERVER_CONNECTIONS_CORS_CONFIG_SERVICE_INTERFACE_ORIGIN_CHECKBOX
			 * )) { selenium.waitUntilElementClickable(webDriver, AADSWeb.
			 * SERVER_CONNECTIONS_CORS_CONFIG_SERVICE_INTERFACE_ORIGIN_CHECKBOX,
			 * 200); selenium.clickElement(webDriver, AADSWeb.
			 * SERVER_CONNECTIONS_CORS_CONFIG_SERVICE_INTERFACE_ORIGIN_CHECKBOX
			 * ); } logger.info("Input specific domain - starting...\n");
			 * selenium.waitUntilElementClickable(webDriver,
			 * AADSWeb.SERVER_CONNECTIONS_CORS_CONFIG_SERVICE_INTERFACE_DOMAIN_TXT
			 * , 200); selenium.inputText(webDriver,
			 * AADSWeb.SERVER_CONNECTIONS_CORS_CONFIG_SERVICE_INTERFACE_DOMAIN_TXT
			 * , aadsData.CORS_CONFIG_SPECIFIC_DOMAIN);
			 * logger.info("save service interface config - starting...\n");
			 * selenium.waitUntilElementClickable(webDriver,
			 * AADSWeb.SERVER_CONNECTIONS_CORS_CONFIG_SERVICE_INTERFACE_SAVE_BTN
			 * , 200); selenium.clickElement(webDriver,
			 * AADSWeb.SERVER_CONNECTIONS_CORS_CONFIG_SERVICE_INTERFACE_SAVE_BTN
			 * ); Thread.sleep(3000);
			 * selenium.waitUntilElementClickable(webDriver, AADSWeb.
			 * SERVER_CONNECTIONS_CORS_CONFIG_SERVICE_INTERFACE_CONFIRM_ACTION_SAVE_BTN
			 * , 200); selenium.clickElement(webDriver, AADSWeb.
			 * SERVER_CONNECTIONS_CORS_CONFIG_SERVICE_INTERFACE_CONFIRM_ACTION_SAVE_BTN
			 * ); logger.info("save service interface config - completed...\n");
			 * logger
			 * .info("corsConfigurationServiceInterface - completed...\n");
			 */
		} catch (Exception exception) {
			logger.error("corsConfigurationServiceInterface - Failed with Exception: "
					+ exception + "...\n");
			throw new Exception(
					"corsConfigurationServiceInterface - Failed - Exception occurs: "
							+ exception);
		}
	}

	public void collectLog(WebDriver webDriver, String host, String browser)
			throws Exception {
		logger.info("collectLog - starting...\n");
		try {
			logger.info("Change Current logging level to FINEST - starting...\n");
			selenium.clickElement(webDriver,
					AADSWeb.logsManagementLogLevelPageCollectBtn(host));
			logger.info("Save change - starting...\n");
			selenium.clickElement(webDriver,
					AADSWeb.LOGS_MANAGERMENT_LOG_LEVEL_PAGE_COLLECT_LOG_OK_BTN);
			Thread.sleep(5000);
			selenium.clickElement(webDriver,
					AADSWeb.logsManagementLogLevelPageDownloadBtn(host));

			Thread.sleep(2000);
			if (browser == "Firefox") {
				Thread.sleep(8000);
				Robot r = new Robot();
				r.keyPress(Event.ENTER);
				r.keyRelease(Event.ENTER);
				r.keyPress(Event.ENTER);
				r.keyRelease(Event.ENTER);
			}

			logger.info("collectLog - completed...\n");
			logger.info("collectLog- completed...\n");

		} catch (Exception exception) {
			logger.error("changeLogLevel - Failed with Exception: " + exception
					+ "...\n");
			throw new Exception("changeLogLevel - Failed - Exception occurs: "
					+ exception);
		}
	}

	public void viewPublishedSettingsSelectCategory(WebDriver webDriver,
			String category, String value) throws Exception {
		logger.info("viewPublishedSettingsSelectCategory - starting...\n");
		try {
			if (selenium.isElementExisted(webDriver,
					AADSWeb.VIEW_PUBLISHED_SETTING_PAGE_IFRAME)) {
				selenium.switchToFrame(webDriver,
						AADSWeb.VIEW_PUBLISHED_SETTING_PAGE_IFRAME);
			}
			selenium.dropDownListBox(webDriver,
					AADSWeb.VIEW_PUBLISHED_SETTING_CATEGORY_DROPBOX, category);
			// selenium.getText(webDriver,
			// AADSWeb.VIEW_PUBLISHED_SETTING_VALUE_DROPBOX_TEST);
			// selenium.getAttribute(webDriver,
			// AADSWeb.VIEW_PUBLISHED_SETTING_VALUE_DROPBOX_TEST, "value");
			// Thread.sleep(5000);
			selenium.dropDownListBox(webDriver,
					AADSWeb.VIEW_PUBLISHED_SETTING_VALUE_DROPBOX, value);
			// Thread.sleep(3000);
		} catch (Exception exception) {
			logger.error("viewPublishedSettingsSelectCategory - Failed with Exception: "
					+ exception + "...\n");
			// throw new
			// Exception("viewPublishedSettingsSelectCategory - Failed - Exception occurs: "
			// + exception);
		}
		logger.info("viewPublishedSettingsSelectCategory - completed...\n");
	}

	public void openNewTab(WebDriver webDriver) throws Exception {
		logger.info("openNewTab - starting...\n");
		try {
			Robot r = new Robot();
			r.keyPress(KeyEvent.VK_CONTROL);
			r.keyPress(KeyEvent.VK_T);
			r.keyRelease(KeyEvent.VK_CONTROL);
			r.keyRelease(KeyEvent.VK_T);
		} catch (Exception exception) {

			logger.error("openNewTab - Failed with Exception: " + exception
					+ "...\n");
			throw new Exception("openNewTab - Failed - Exception occurs: "
					+ exception);
		}
		logger.info("openNewTab - completed...\n");

	}

	public void verifyOkAndCancelbtn(WebDriver webDriver, boolean result)
			throws Exception {
		logger.info("changeValueApplicationProperties - starting...\n");
		Thread.sleep(3000);
		try {

			if (result) {
				selenium.clickElement(webDriver, AADSWeb.APP_MANGEMENT_BTN_OK);
			} else {
				selenium.clickElement(webDriver,
						AADSWeb.APP_MANGEMENT_BTN_CANCEL);
			}

		} catch (Exception e) {
			logger.error("changeValueApplicationProperties - Failed with Exception: "
					+ e + "...\n");
			throw new Exception(
					"changeValueApplicationProperties - Failed - Exception occurs: "
							+ e);
		}
		logger.info("changeValueApplicationProperties - completed...\n");
	}

	public void truststorePageExportSecurityRole(WebDriver webDriver,
			String browser) throws Exception {
		logger.info("truststorePageExportSecurityRole - stating");
		try {
			logger.info("truststorePageExportSecurityRole - Select alias");
			String alias = aadsData.SMGRCA.toLowerCase();
			selenium.clickElement(
					webDriver,
					AADSWeb.CERTIFICATE_MANAGEMENT_IDENTITY_CERT_EXPORT_KEYSTORE_SELECT_CERT(alias));
			Thread.sleep(1000);
			logger.info("truststorePageExportSecurityRole  - press export button");
			if (browser == "Chrome") {
				selenium.clickElement(webDriver,
						AADSWeb.CERTIFICATE_MANAGEMENT_TRUSTSTORE_EXPORT_BTN);
			} else {
				selenium.clickElement(webDriver,
						AADSWeb.CERTIFICATE_MANAGEMENT_TRUSTSTORE_EXPORT_BTN);
				selenium.clickElement(webDriver,
						AADSWeb.CERTIFICATE_MANAGEMENT_TRUSTSTORE_EXPORT_BTN);
			}
			Thread.sleep(1000);
			logger.info("truststorePageExportSecurityRole -  export successfull");
		} catch (Exception e) {
			logger.error("truststorePageExportSecurityRole - Failed with Exception: "
					+ e + "...\n");
			throw new Exception(
					"struststorePageExportSecurityRole - Failed - Exception occurs: "
							+ e);
		}
	}
	
	public boolean configurationPageCommAddrHandle(WebDriver webDriver, String type, String length) throws Exception {
		String tab = "Group";
		logger.info("configurationPageHandleType - starting...\n");
		try {
			if (selenium.isElementExisted(webDriver,AADSWeb.DYNAMIC_CONFIGURATION_CONFIGURATION_PAGE_IFRAME)) {
				selenium.switchToFrame(webDriver,AADSWeb.DYNAMIC_CONFIGURATION_CONFIGURATION_PAGE_IFRAME);
			}
			selenium.clickElementByText(webDriver, tab);
			tab = tab.toLowerCase();
			selenium.dropDownListBox(webDriver,
					AADSWeb.autoConfigPageSettingValueDisplayNumberVariableDropListLocators(tab), "All");
			Thread.sleep(5000);
			selenium.scrollToElement(webDriver, AADSWeb.autoConfigPageSettingValueCheckboxLocators(tab, "COMM_ADDR_HANDLE_TYPE"));
			selenium.dropDownListBox(webDriver, AADSWeb.AUTOCONFIG_GROUP_COMM_ADDR_HANDLE_TYPE, type);
			selenium.scrollToElement(webDriver, AADSWeb.autoConfigPageSettingValueCheckboxLocators(tab, "COMM_ADDR_HANDLE_TYPE"));
			selenium.inputText(webDriver, AADSWeb.autoConfigPageSettingValueTextLocators(tab, "COMM_ADDR_HANDLE_LENGTH"),length);
		//	selenium.scrollToElement(webDriver,	AADSWeb.DYNAMIC_CONFIGURATION_CONFIGURATION_PAGE_SELECT_CONFIGURATION_BTN);
			
		} catch (Exception exception) {
			logger.error("configurationPageHandleType - Failed with Exception: " + exception + "...\n");
			return false;
		}
		logger.info("configurationPageHandleType - completed...\n");
		return true;
	}
	
	public boolean configurationPageSettingVariablePhoneModel(WebDriver webDriver, String tab, String variable, boolean checkbox,
			String text) throws Exception {
		logger.info("configurationPageSettingVariable - starting...\n");
		int i=0;
		while(true) {
			if ( i==3) return false;
		try {
			if (selenium.isElementExisted(webDriver, AADSWeb.DYNAMIC_CONFIGURATION_CONFIGURATION_PAGE_IFRAME)) {
				selenium.switchToFrame(webDriver, AADSWeb.DYNAMIC_CONFIGURATION_CONFIGURATION_PAGE_IFRAME);
			}
			selenium.clickElementByText(webDriver, "Phone Model");
			tab = tab.toLowerCase();
			selenium.dropDownListBox(webDriver,
					AADSWeb.autoConfigPageSettingValueDisplayNumberVariableDropListLocators(tab), "All");
			Thread.sleep(5000);
			selenium.scrollToElement(webDriver, AADSWeb.autoConfigPageSettingValueCheckboxLocators(tab, variable));
			if (checkbox == true) {
				if (selenium.isElementSelected(webDriver,
						AADSWeb.autoConfigPageSettingValueCheckboxLocators(tab, variable)) == false) {
					selenium.clickElement(webDriver, AADSWeb.autoConfigPageSettingValueCheckboxLocators(tab, variable));
				}
			} else {
				if (selenium.isElementSelected(webDriver,
						AADSWeb.autoConfigPageSettingValueCheckboxLocators(tab, variable)) == true) {
					selenium.clickElement(webDriver, AADSWeb.autoConfigPageSettingValueCheckboxLocators(tab, variable));
				}
			}
			selenium.inputText(webDriver, AADSWeb.autoConfigPageSettingValueTextLocators(tab, variable), text);
			selenium.scrollToElement(webDriver,
					AADSWeb.DYNAMIC_CONFIGURATION_CONFIGURATION_PAGE_SELECT_CONFIGURATION_BTN);break;
		} catch (Exception exception) {
			logger.error("configurationPageSettingVariable - Failed with Exception: " + exception + "...\n");
			
//			throw new Exception("configurationPageSettingVariable - Failed - Exception occurs: " + exception);
			i++;
		}}
		logger.info("configurationPageSettingVariable - completed...\n");
		return true;
	}
	
	public void configurationPageSaveConfigurationNew (WebDriver webDriver, String config) throws Exception{
		logger.info("configurationPageSaveConfigurationOverride - stating save new configuration override " + config);
		try {
			logger.info("configurationPageSaveConfigurationOverride - Click save button");
			selenium.clickElement(webDriver, AADSWeb.DYNAMIC_CONFIGURATION_CONFIGURATION_PAGE_SAVE_USER_BTN);
			Thread.sleep(1000);
			logger.info("configurationPageSaveConfigurationOverride - Select Config");
			selenium.clickElement(webDriver, AADSWeb.DYNAMIC_CONFIGURATION_CONFIGURATION_PAGE_CREATE_NEW_CHECKBOX);
			selenium.inputText(webDriver, AADSWeb.DYNAMIC_CONFIGURATION_CONFIGURATION_PAGE_CONFIG_NAME_TXT, config);
			logger.info("configurationPageSaveConfigurationOverride - Confirm save configuration");
			selenium.clickElement(webDriver, AADSWeb.DYNAMIC_CONFIGURATION_CONFIGURATION_PAGE_SAVE_USER_COMFIRM_BTN);
			Thread.sleep(1000);
			logger.info("configurationPageSaveConfigurationOverride - Configuration save successfully");
		} catch (Exception e) {
			logger.error("configurationPageSaveConfigurationOverride - Failed with Exception: " + e + "...\n");
			throw new Exception("configurationPageSaveConfigurationOverride - Failed - Exception occurs: " + e);
		}
	}
	
	public boolean configurationPagePublishPhoneModelOnly(WebDriver webDriver, String phoneModel) throws Exception {
		logger.info("configurationPagePublishPhoneModelOnly_T - starting...\n");
		boolean n=false;
		int i=0;
		while (!n) {
			if (i==3) break;
			i++;
		try {
			selenium.clickElement(webDriver, AADSWeb.DYNAMIC_CONFIGURATION_CONFIGURATION_PAGE_SAVE_USER_BTN);
			selenium.clickElement(webDriver, AADSWeb.DYNAMIC_CONFIGURATION_CONFIGURATION_PAGE_SAVE_USER_COMFIRM_BTN);
			Thread.sleep(5000);
			selenium.clickElement(webDriver, AADSWeb.DYNAMIC_CONFIGURATION_CONFIGURATION_PAGE_PUBLISH_USER_BTN);
			Thread.sleep(2000);
			if (!selenium.isElementSelected(webDriver, AADSWeb.PUBLISH_WINDOW_PHONEMODEL_CHECKBOX)) {
				selenium.clickElement(webDriver, AADSWeb.PUBLISH_WINDOW_PHONEMODEL_CHECKBOX);
			}
			Thread.sleep(3000);
			selenium.dropDownListBox(webDriver, AADSWeb.PUBLISH_WINDOW_PHONEMODEL_SELECT, phoneModel);
			selenium.clickElement(webDriver, AADSWeb.PUBLISH_WINDOW_PUBLISH_BTN);
			Thread.sleep(2000);
			selenium.clickElement(webDriver, AADSWeb.PUBLISH_WINDOW_PUBLISH_YES_CONFIRM_BTN);
			Thread.sleep(2000);

			String message = new String();
			message = selenium.getText(webDriver, AADSWeb.DYNAMIC_CONFIGURATION_CONFIGURATION_PAGE_STATUS_MESSAGE);
			if (message.contains("Settings were published successfully")) {
				logger.info("configurationPagePublishUser - Publish successfully...\n");
				n=true;
			} else {
				logger.info("testAADS001- Failed - Exception occurs:  Publish user failed....\n");
				n=false;
			}
		} catch (Exception exception) {
			logger.error("configurationPagePublishUser - Failed with Exception: " + exception + "...\n");
			return n;
		//	throw new Exception("configurationPagePublishUser - Failed - Exception occurs: " + exception);
		}}
		return n;
	}
	
	
	public void configurationPagePublishUserOnly(WebDriver webDriver, String user) throws Exception {
		logger.info("configurationPagePublishUser - starting...\n");
		try {
			Thread.sleep(3000);
			
			selenium.clickElement(webDriver, AADSWeb.DYNAMIC_CONFIGURATION_CONFIGURATION_PAGE_SAVE_USER_BTN);
			Thread.sleep(2000);
			selenium.clickElement(webDriver, AADSWeb.DYNAMIC_CONFIGURATION_CONFIGURATION_PAGE_SAVE_USER_COMFIRM_BTN);
			Thread.sleep(4000);
			selenium.clickElement(webDriver, AADSWeb.DYNAMIC_CONFIGURATION_CONFIGURATION_PAGE_PUBLISH_USER_BTN);
			if (selenium.isElementSelected(webDriver, AADSWeb.PUBLISH_WINDOW_GROUP_SET_CHECKBOX)) {
				selenium.clickElement(webDriver, AADSWeb.PUBLISH_WINDOW_GROUP_SET_CHECKBOX);
			}
			if (!selenium.isElementSelected(webDriver, AADSWeb.PUBLISH_WINDOW_USER_CHECKBOX)) {
				selenium.clickElement(webDriver, AADSWeb.PUBLISH_WINDOW_USER_CHECKBOX);
			}
			selenium.inputText(webDriver, AADSWeb.PUBLISH_WINDOW_USER_TXT, user);
			selenium.clickElement(webDriver, AADSWeb.PUBLISH_WINDOW_PUBLISH_BTN);
			Thread.sleep(3000);
			selenium.clickElement(webDriver, AADSWeb.PUBLISH_WINDOW_PUBLISH_YES_CONFIRM_BTN);
			Thread.sleep(3000);

			String message = new String();
			message = selenium.getText(webDriver, AADSWeb.DYNAMIC_CONFIGURATION_CONFIGURATION_PAGE_STATUS_MESSAGE);
			if (message.contains("Settings were published successfully")) {
				logger.info("configurationPagePublishUser - Publish successfully...\n");
			} else
				logger.info("testAADS001- Failed - Exception occurs:  Publish user failed....\n");
		} catch (Exception exception) {
	//		driverMgnt.setFailedWinClientDriver(webDriver);
			logger.error("configurationPagePublishUser - Failed with Exception: " + exception + "...\n");
			webDriver.get(aadsData.AADS_SERVER_ADDRESS);
			Thread.sleep(2000);
			navigateToFeaturesPage(webDriver, "Dynamic Configuration");
			Thread.sleep(5000);
			navigateToFeaturesPage(webDriver, "Configuration");
			Thread.sleep(3000);
		
	//		throw new Exception("configurationPagePublishUser - Failed - Exception occurs: " + exception);
		}
		logger.info("configurationPagePublishUser - completed...\n");
	}
	
	public void configurationPagePublishGroupOnly(WebDriver webDriver, String group) throws Exception {
		logger.info("configurationPagePublishUser - starting...\n");
		try {
			Thread.sleep(2000);
			selenium.clickElement(webDriver, AADSWeb.DYNAMIC_CONFIGURATION_CONFIGURATION_PAGE_SAVE_USER_BTN);
			Thread.sleep(3000);
			selenium.clickElement(webDriver, AADSWeb.DYNAMIC_CONFIGURATION_CONFIGURATION_PAGE_SAVE_USER_COMFIRM_BTN);
			selenium.clickElement(webDriver, AADSWeb.DYNAMIC_CONFIGURATION_CONFIGURATION_PAGE_PUBLISH_USER_BTN);
			if (selenium.isElementSelected(webDriver, AADSWeb.PUBLISH_WINDOW_USER_CHECKBOX)) {
				selenium.clickElement(webDriver, AADSWeb.PUBLISH_WINDOW_USER_CHECKBOX);
			}
			if (!selenium.isElementSelected(webDriver, AADSWeb.PUBLISH_WINDOW_GROUP_SET_CHECKBOX)) {
				selenium.clickElement(webDriver, AADSWeb.PUBLISH_WINDOW_GROUP_SET_CHECKBOX);
			}
			selenium.inputText(webDriver, AADSWeb.PUBLISH_WINDOW_GROUP_SET_TXT,
					group);
			selenium.clickElement(webDriver, AADSWeb.PUBLISH_WINDOW_PUBLISH_BTN);
			Thread.sleep(3000);
			selenium.clickElement(webDriver, AADSWeb.PUBLISH_WINDOW_PUBLISH_YES_CONFIRM_BTN);
			Thread.sleep(3000);

			String message = new String();
			message = selenium.getText(webDriver, AADSWeb.DYNAMIC_CONFIGURATION_CONFIGURATION_PAGE_STATUS_MESSAGE);
			if (message.contains("Settings were published successfully")) {
				logger.info("configurationPagePublishUser - Publish successfully...\n");
			} else
				logger.info("configurationPagePublishUser - Publish fail...\n");
		} catch (Exception exception) {
			//driverMgnt.setFailedWinClientDriver(webDriver);
			logger.error("configurationPagePublishUser - Failed with Exception: " + exception + "...\n");
			//throw new Exception("configurationPagePublishUser - Failed - Exception occurs: " + exception);
			logger.error("configurationPagePublishUser - Failed with Exception: " + exception + "...\n");
			webDriver.get(aadsData.AADS_SERVER_ADDRESS);
			Thread.sleep(2000);
			navigateToFeaturesPage(webDriver, "Dynamic Configuration");
			Thread.sleep(5000);
			navigateToFeaturesPage(webDriver, "Configuration");
			Thread.sleep(3000);
		}
		logger.info("configurationPagePublishUser - completed...\n");
	}
	
	
	public boolean esgPortalSettingsPageUploadImg(WebDriver webDriver) throws Exception {
		logger.info("esgPortalSettingsPageUploadImg - starting...\n");
		boolean s = false;
		try {
			Thread.sleep(3000);
			selenium.waitUntilElementClickable(webDriver, AADSWeb.ESG_PORTAL_SETTINGS_PAGE, 200);
			selenium.clickElement(webDriver, AADSWeb.ESG_PORTAL_SETTINGS_PAGE);
			Thread.sleep(5000);
			selenium.waitUntilElementClickable(webDriver, AADSWeb.ESG_PORTAL_SETTINGS_PAGE_UPLOAD_IMG, 200);
			WebElement input = webDriver.findElement(AADSWeb.ESG_PORTAL_SETTINGS_PAGE_UPLOAD_IMG);
			new Actions(webDriver).moveToElement(input).click().perform();
			Thread.sleep(2000);
			Runtime.getRuntime().exec("C:\\seleniumDriver\\AutoIT\\FileUploadEsgPortal.exe");
			Thread.sleep(10000);
			WebElement element = webDriver.findElement(AADSWeb.ESG_PORTAL_SETTINGS_PAGE_DETAIL_IMG);
			String src= ((JavascriptExecutor)webDriver).executeScript("return arguments[0].attributes['src'].value", element).toString();
			Thread.sleep(5000);
			if(selenium.checkElementExistedOrNotExisted(webDriver, AADSWeb.ESG_PORTAL_SETTINGS_PAGE_DETAIL_IMG))
			{
				s = false;
			}
			else {
				s = true;
			}
			selenium.waitUntilElementClickable(webDriver, AADSWeb.ESG_PORTAL_SETTINGS_PAGE_OK_BTN, 200);
			selenium.clickElement(webDriver, AADSWeb.ESG_PORTAL_SETTINGS_PAGE_OK_BTN);
			webDriver.get(src);
			
		} catch (Exception exception) {
			logger.error("esgPortalSettingsPageUploadImg - Failed with Exception: " + exception + "...\n");
			throw new Exception("esgPortalSettingsPageUploadImg - Failed - Exception occurs: " + exception);
		}
		logger.info("esgPortalSettingsPageUploadImg - completed...\n");
		return s; 
	}
	
	public void loginEsgPortalMainPage(WebDriver webDriver, String user, String password) throws Exception {
		logger.info("loginEsgPortalMainPage - starting...\n");
		try {
			Thread.sleep(5000);
			selenium.waitUntilElementClickable(webDriver, AADSWeb.ESG_PORTAL_SIGN_IN_BTN, 200);
			selenium.clickElement(webDriver, AADSWeb.ESG_PORTAL_SIGN_IN_BTN);
			selenium.waitUntilElementClickable(webDriver, AADSWeb.ESG_PORTAL_USERNAME_TXT, 200);
			selenium.inputText(webDriver, AADSWeb.ESG_PORTAL_USERNAME_TXT, user);
			selenium.waitUntilElementClickable(webDriver, AADSWeb.ESG_PORTAL_PASSWORD_TXT, 200);
			selenium.inputText(webDriver, AADSWeb.ESG_PORTAL_PASSWORD_TXT, password);
			selenium.waitUntilElementClickable(webDriver, AADSWeb.ESG_PORTAL_LOGIN_PAGE_SUBMIT_BTN, 200);
			selenium.clickElement(webDriver, AADSWeb.ESG_PORTAL_LOGIN_PAGE_SUBMIT_BTN);
		} catch (Exception exception) {
			logger.error("loginEsgPortalMainPage - Failed with Exception: " + exception + "...\n");
			throw new Exception("loginEsgPortalMainPage - Failed - Exception occurs: " + exception);
		}
		logger.info("loginEsgPortalMainPage - completed...\n");
	}
	
	public void logoffEsgPortalMainPage(WebDriver webDriver) throws Exception {
		logger.info("logoffEsgPortalMainPage - starting...\n");
		try {
			Thread.sleep(5000);
			if(selenium.isElementExisted(webDriver, AADSWeb.ESG_PORTAL_AVATAR_IMG))
			{
				selenium.waitUntilElementClickable(webDriver, AADSWeb.ESG_PORTAL_AVATAR_IMG, 200);
				selenium.clickElement(webDriver, AADSWeb.ESG_PORTAL_AVATAR_IMG);
			}
			else {
				selenium.waitUntilElementClickable(webDriver, AADSWeb.ESG_PORTAL_AVATAR_NOT_IMG, 200);
				selenium.clickElement(webDriver, AADSWeb.ESG_PORTAL_AVATAR_NOT_IMG);
			}
			
			Thread.sleep(2000);
			selenium.waitUntilElementClickable(webDriver, AADSWeb.ESG_PORTAL_SIGN_OUT_BTN, 200);
			selenium.clickElement(webDriver, AADSWeb.ESG_PORTAL_SIGN_OUT_BTN);
		} catch (Exception exception) {
			logger.error("logoffEsgPortalMainPage - Failed with Exception: " + exception + "...\n");
			throw new Exception("logoffEsgPortalMainPage - Failed - Exception occurs: " + exception);
		}
		logger.info("logoffEsgPortalMainPage - completed...\n");
	}
	
	public void esgPortalSettingsPageChangeImg(WebDriver webDriver) throws Exception {
		logger.info("esgPortalSettingsPageChangeImg - starting...\n");
		try {
			Thread.sleep(5000);
			selenium.waitUntilElementClickable(webDriver, AADSWeb.ESG_PORTAL_SETTINGS_PAGE, 200);
			selenium.clickElement(webDriver, AADSWeb.ESG_PORTAL_SETTINGS_PAGE);
			Thread.sleep(5000);
			WebElement element1 = webDriver.findElement(AADSWeb.ESG_PORTAL_SETTINGS_PAGE_DETAIL_IMG);
			String src1= ((JavascriptExecutor)webDriver).executeScript("return arguments[0].attributes['src'].value", element1).toString();
			selenium.waitUntilElementClickable(webDriver, AADSWeb.ESG_PORTAL_SETTINGS_PAGE_CHANGE_IMG, 1000);
			WebElement input = webDriver.findElement(AADSWeb.ESG_PORTAL_SETTINGS_PAGE_CHANGE_IMG);
			new Actions(webDriver).moveToElement(input).click().perform();
			Thread.sleep(5000);
			Runtime.getRuntime().exec("C:\\seleniumDriver\\AutoIT\\FileUploadEsgPortal.exe");
			Thread.sleep(4000);
			WebElement element = webDriver.findElement(AADSWeb.ESG_PORTAL_SETTINGS_PAGE_DETAIL_IMG);
			String src= ((JavascriptExecutor)webDriver).executeScript("return arguments[0].attributes['src'].value", element).toString();
			Thread.sleep(5000);
			if(src.equals(src1))
			{
				System.out.println("Failed");
			}
			else {
				System.out.println("Passed");
			}
			selenium.waitUntilElementClickable(webDriver, AADSWeb.ESG_PORTAL_SETTINGS_PAGE_OK_BTN, 200);
			selenium.clickElement(webDriver, AADSWeb.ESG_PORTAL_SETTINGS_PAGE_OK_BTN);
			webDriver.get(src);
			
		} catch (Exception exception) {
		
			logger.error("esgPortalSettingsPageChangeImg - Failed with Exception: " + exception + "...\n");
			throw new Exception("esgPortalSettingsPageChangeImg - Failed - Exception occurs: " + exception);
		}
		logger.info("esgPortalSettingsPageChangeImg - completed...\n");
	}
	
	public boolean esgPortalSettingsPageDeleteImg(WebDriver webDriver) throws Exception {
		logger.info("esgPortalSettingsPageDeleteImg - starting...\n");
		boolean s = false;
		try {
			Thread.sleep(5000);
			selenium.waitUntilElementClickable(webDriver, AADSWeb.ESG_PORTAL_SETTINGS_PAGE, 200);
			selenium.clickElement(webDriver, AADSWeb.ESG_PORTAL_SETTINGS_PAGE);
			Thread.sleep(5000);
			selenium.waitUntilElementClickable(webDriver, AADSWeb.ESG_PORTAL_SETTINGS_PAGE_DETAIL_IMG, 200);
			selenium.mouseHover(webDriver, AADSWeb.ESG_PORTAL_SETTINGS_PAGE_DELETE_BTN);
			WebElement input = webDriver.findElement(AADSWeb.ESG_PORTAL_SETTINGS_PAGE_DELETE_BTN);
			new Actions(webDriver).moveToElement(input).click().perform();
			selenium.waitUntilElementClickable(webDriver, AADSWeb.ESG_PORTAL_SETTINGS_PAGE_CONFIRM_DELETE_BTN, 200);
			selenium.clickElement(webDriver, AADSWeb.ESG_PORTAL_SETTINGS_PAGE_CONFIRM_DELETE_BTN);
			Thread.sleep(3000);
			if(selenium.checkElementExistedOrNotExisted(webDriver, AADSWeb.ESG_PORTAL_SETTINGS_PAGE_DETAIL_IMG))
			{
				s = false;
				logger.info("esgPortalSettingsPageDeleteImg - FAILED ...\n");
			}
			else {
				logger.info("esgPortalSettingsPageDeleteImg - PASSED ...\n");
				s = true;
			}
			Thread.sleep(1000);
			selenium.waitUntilElementClickable(webDriver, AADSWeb.ESG_PORTAL_SETTINGS_PAGE_OK_BTN, 200);
			selenium.clickElement(webDriver, AADSWeb.ESG_PORTAL_SETTINGS_PAGE_OK_BTN);
		} catch (Exception exception) {
			logger.error("esgPortalSettingsPageDeleteImg - Failed with Exception: " + exception + "...\n");
			throw new Exception("esgPortalSettingsPageDeleteImg - Failed - Exception occurs: " + exception);
		}
		logger.info("esgPortalSettingsPageDeleteImg - completed...\n");
		return s;
	}
	
	public boolean verifyEsgPortalSettingsPageUploadImgExisted(WebDriver webDriver) throws Exception{
		logger.info("verifyMultimediaMessagingExisted - starting...\n");
		boolean s = false;
		try {
			Thread.sleep(1000);
			selenium.waitUntilElementClickable(webDriver, AADSWeb.ESG_PORTAL_SETTINGS_PAGE, 200);
			selenium.clickElement(webDriver, AADSWeb.ESG_PORTAL_SETTINGS_PAGE);
			
			Thread.sleep(2000);
			if(selenium.checkElementExistedOrNotExisted(webDriver, AADSWeb.ESG_PORATL_SETTINGS_PAGE_UPLOAD_IMG_CLASS))
			{
				s = true;
			}
			else {
				s = false;
			}
			Thread.sleep(2000);
			selenium.waitUntilElementClickable(webDriver, AADSWeb.ESG_PORTAL_SETTINGS_PAGE_OK_BTN, 200);
			selenium.clickElement(webDriver, AADSWeb.ESG_PORTAL_SETTINGS_PAGE_OK_BTN);
		} catch (Exception exception) {
			logger.error("esgPortalSettingsPageChangeImg - Failed with Exception: " + exception + "...\n");
			throw new Exception("esgPortalSettingsPageChangeImg - Failed - Exception occurs: " + exception);
		}
		logger.info("esgPortalSettingsPageChangeImg - completed...\n");
		return s;
    }
	
	public void configurationPagePublishFlatformOnly(WebDriver webDriver, String flatform) throws Exception {
		logger.info("configurationPagePublishUser - starting...\n");
		try {
			Thread.sleep(2000);
			selenium.waitUntilElementClickable(webDriver,
					AADSWeb.DYNAMIC_CONFIGURATION_CONFIGURATION_PAGE_SAVE_USER_BTN, 200);
			selenium.clickElement(webDriver, AADSWeb.DYNAMIC_CONFIGURATION_CONFIGURATION_PAGE_SAVE_USER_BTN);
			Thread.sleep(5000);
			selenium.waitUntilElementClickable(webDriver,
					AADSWeb.DYNAMIC_CONFIGURATION_CONFIGURATION_PAGE_SAVE_USER_COMFIRM_BTN, 200);
			selenium.clickElement(webDriver, AADSWeb.DYNAMIC_CONFIGURATION_CONFIGURATION_PAGE_SAVE_USER_COMFIRM_BTN);
			Thread.sleep(5000);
			selenium.waitUntilElementClickable(webDriver,
					AADSWeb.DYNAMIC_CONFIGURATION_CONFIGURATION_PAGE_PUBLISH_USER_BTN, 200);
			selenium.clickElement(webDriver, AADSWeb.DYNAMIC_CONFIGURATION_CONFIGURATION_PAGE_PUBLISH_USER_BTN);
			Thread.sleep(2000);
			selenium.waitUntilElementClickable(webDriver, AADSWeb.PUBLISH_WINDOW_FLATFORM_CHECKBOX, 200);

			if (!selenium.isElementSelected(webDriver, AADSWeb.PUBLISH_WINDOW_FLATFORM_CHECKBOX)) {
				selenium.clickElement(webDriver, AADSWeb.PUBLISH_WINDOW_FLATFORM_CHECKBOX);
			}
			Thread.sleep(3000);
			selenium.dropDownListBox(webDriver, AADSWeb.PUBLISH_WINDOW_PLATFORM_SELECT, flatform);

			selenium.waitUntilElementClickable(webDriver, AADSWeb.PUBLISH_WINDOW_PUBLISH_BTN, 200);
			selenium.clickElement(webDriver, AADSWeb.PUBLISH_WINDOW_PUBLISH_BTN);
			Thread.sleep(2000);
			selenium.waitUntilElementClickable(webDriver, AADSWeb.PUBLISH_WINDOW_PUBLISH_YES_CONFIRM_BTN, 200);
			selenium.clickElement(webDriver, AADSWeb.PUBLISH_WINDOW_PUBLISH_YES_CONFIRM_BTN);
			Thread.sleep(2000);

			String message = new String();
			message = selenium.getText(webDriver, AADSWeb.DYNAMIC_CONFIGURATION_CONFIGURATION_PAGE_STATUS_MESSAGE);
			if (message.contains("Settings were published successfully")) {
				logger.info("configurationPagePublishUser - Publish successfully...\n");
			} else
				throw new Exception("testAADS001- Failed - Exception occurs:  Publish user failed....\n");
		} catch (Exception exception) {
			logger.error("configurationPagePublishUser - Failed with Exception: " + exception + "...\n");
			throw new Exception("configurationPagePublishUser - Failed - Exception occurs: " + exception);
		}
		logger.info("configurationPagePublishUser - completed...\n");
	}
	
	public String getDownloadStatistic (WebDriver webDriver) throws Exception {
		logger.info("getDownloadStatistic - starting...\n");
		try {
			String s = selenium.getText(webDriver, AADSWeb.WEB_DEPLOYMENT_PAGE_DOWNLOAD_STATISTIC_WINDOWS_UPDATES_TXT);
			logger.info("getDownloadStatistic - Download: " + s);
			return s;
			} catch (Exception exception) {
			logger.error("getDownloadStatistic - Failed with Exception: " + exception + "...\n");
			throw new Exception("getDownloadStatistic - Failed - Exception occurs: " + exception);
		}
	}

	

	
	
}

	

