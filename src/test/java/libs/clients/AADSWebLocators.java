package libs.clients;

import org.openqa.selenium.By;

public class AADSWebLocators {

	
	By AADS_LOGIN_PAGE_AVAYA_IMG = By.xpath("//div[@id='avayaLogo']");
	By AADS_LOGIN_PAGE_USERNAME_TXT = By.xpath("//input[@id='nameField']");
	By AADS_LOGIN_PAGE_PASSWORD_TXT = By.xpath("//input[@id='passwordField']");
	By AADS_SIGN_IN_BTN = By.xpath("//input[@name='logOnButton']");

	By AADS_MAIN_PAGE_LOGOFF_BTN = By
			.xpath("//button[@id='gwt-debug-logoffButton']");

	By mainPageGroupFeaturesLocators(String Name) {
		return By.xpath("//div[text()='" + Name + "']");
	};

	// ###########################################################################################################################
	// ########################################LOCATOR OF WEB ELEMENTS IN LOG-IN
	// PAGE OF AADS#####################################
	// ###########################################################################################################################

	public By LOGIN_PAGE_USERNAME_TXT = By.xpath("//*[@id='nameField']");
	public By LOGIN_PAGE_PASSWORD_TXT = By.xpath("//*[@id='passwordField']");
	public By LOGIN_PAGE_SUBMIT_BTN = By.xpath("//*[@id='logonSubmitButtonContainer']/input");
	public By MAIN_PAGE_LOGOFF_BTN = By.xpath(".//*[@id='gwt-debug-logoffButton']");
	public By LOGIN_PAGE_WARNING_TXT = By.xpath(".//*[@id='messageLabel']");
	public By LOGIN_PAGE_OK_BTN = By.xpath("//button[text()='OK']");
	// ###########################################################################################################################
	// ########################################LOCATOR OF WEB ELEMENTS IN MAIN
	// PAGE OF AADS#######################################
	// ###########################################################################################################################

	public By AdminHTTPSessionTimeout = By
			.xpath(".//*[@id='gwt-debug-adminSessionTimeout']");
	public By ApplicationHTTPSessionTimeout = By
			.xpath(".//*[@id='gwt-debug-appSessionTimeout']");
	public By MaximumConcurrentHTTPSessions = By
			.xpath(".//*[@id='gwt-debug-maxConcurrentSessions']");
	public By ConcurrentHTTPSessionsperUser = By
			.xpath(".//*[@id='gwt-debug-concurrentSessionsPerUser']");
	public By SAVE_AADS_MAIN_btn = By
			.xpath(".//*[@id='gwt-debug-appPropSave']/div");
	public By CACEL_AADS_MAIN_btn = By
			.xpath(".//*[@id='gwt-debug-appPropSave']/div");
	public By OK1_AADS_MAIN_btn = By
			.xpath(".//*[@id='gwt-debug-Confirm Action-OK']");
	public By OK2_AADS_MAIN_btn = By
			.xpath(".//*[@id='gwt-debug-Saving Application properties-OK']");
	public By YES_AADS_MAIN_btn = By
			.xpath("..//*[@id='gwt-debug-Restart Required-Yes']");

	// ###########################################################################################################################
	// ########################################LOCATOR OF WEB ELEMENTS IN Client
	// Administration OF AADS###########################
	// ###########################################################################################################################
	public By RESTopt = By.xpath(".//*[@id='gwt-debug-clientCertListBox']");
	public By OAMPopt = By.xpath(".//*[@id='gwt-debug-oampCertListBox']");
	public By SAVE_Client_Administration_btn = By
			.xpath(".//*[@id='gwt-debug-saveLimit']/div");
	public By CACEL_Client_Administration_btn = By
			.xpath(".//*[@id='gwt-debug-cancelLimit']/div");

	// ###########################################################################################################################
	// ########################################LOCATOR OF WEB ELEMENTS IN
	// Enterprise LDAP Server Configuration OF AADS############
	// ###########################################################################################################################
	// public By newLDAP_BTN =
	// By.xpath("//div[@class='gwt-TabLayoutPanelTabInner']");
	// public By newLDAP_BTN =
	// By.xpath("//*[@id='gwt-debug-ldapHeader']/div/div[1]/div[3]/div/div[2]/div/div[2]/div/img");
	public By newLDAP_BTN = By
			.xpath("//*[@id='gwt-debug-ldapHeader']/div/div[1]/div[3]/div/div[2]/div/div/div/img");
	public By ADD_NEW_LDAP_BTN_IE = By
			.xpath("//*[@id='gwt-debug-ldapHeader']/div/div[1]/div[3]/div/div[2]/div/div/div/img/..");
	public By newLDAP_SLT = By.xpath("//*[@id='gwt-debug-selectedDirName']");
	public By Priority_TXT = By
			.xpath("//div[@class='gwt-TabLayoutPanelContent' and not(@aria-hidden='true')]//input[@id='gwt-debug-selectedDirProvenance']");
	public By Address_TXT = By
			.xpath("//div[@class='gwt-TabLayoutPanelContent' and not(@aria-hidden='true')]//*[@id='gwt-debug-ldapAddress']");
	public By BindDN_TXT = By
			.xpath("//div[@class='gwt-TabLayoutPanelContent' and not(@aria-hidden='true')]//*[@id='gwt-debug-bindUser']");
	public By port_TXT = By
			.xpath("//div[@class='gwt-TabLayoutPanelContent' and not(@aria-hidden='true')]//*[@id='gwt-debug-ldapPort']");
	public By BindCredential_TXT = By
			.xpath("//div[@class='gwt-TabLayoutPanelContent' and not(@aria-hidden='true')]//*[@id='gwt-debug-password']");
	public By UIDAttributeID_TXT = By
			.xpath("//div[@class='gwt-TabLayoutPanelContent' and not(@aria-hidden='true')]//*[@id='gwt-debug-uidAttributeId']");
	public By SAVE_LDAP_btn = By
			.xpath("//div[@class='gwt-TabLayoutPanelContent' and not(@aria-hidden='true')]//*[@id='gwt-debug-saveLdap']/div");
	public By DELETE_LDAP_btn = By
			.xpath("//div[@class='gwt-TabLayoutPanelContent' and not(@aria-hidden='true')]//*[@id='gwt-debug-deleteServer']");
	public By LDAP_CONFIGURATION_USE_ADDTIONAL_BASE_CONTEXT_CHECKBOX = By
			.xpath("//div[contains(@style,'left: 0%')]//input[@id='gwt-debug-addBaseContextCheckBox-input']");
	public By LDAP_CONFIGURATION_VIEW_EDIT_BTN = By
			.xpath("//div[contains(@style,'left: 0%')]//div[@id='gwt-debug-editAdditionalBaseContextConfig']");
	public By LDAP_CONFIGURATION_BASE_CONTEXT_DN_ADD_BTN = By
			.xpath("//button[@id='gwt-debug-addBaseDNButton']");
	public By LDAP_CONFIGURATION_BASE_CONTEXT_CAPTION_BAR = By
			.xpath("//div[@class='Caption']");
	public By LDAP_CONFIGURATION_BASE_CONTEXT_DN_INPUT_DN_FIELD = By
			.xpath("//tbody[@style='']/tr[last()]/td[2]/div[@style='outline-style:none;']");
	public By LDAP_CONFIGURATION_BASE_CONTEXT_DN_INPUT_DN_TXT = By
			.xpath("//tbody[@style='']/tr[last()]/td[2]/div//input");
	public By LDAP_CONFIGURATION_BASE_CONTEXT_DN_AUTH_CHECKBOX = By
			.xpath("//tbody[@style='']/tr[last()]/td[3]/div[@style='outline-style:none;']/input");
	public By LDAP_CONFIGURATION_BASE_CONTEXT_DN_SAVE_BTN = By
			.xpath("//div[@id='gwt-debug-saveButton']");
	public By LDAP_CONFIGURATION_BASE_CONTEXT_DN_CANCEL_BTN = By
			.xpath("//div[@id='gwt-debug-cancelButton']");
	public By LDAP_CONFIGURATION_BASE_CONTEXT_DN_CONFIRM_ACTION_BTN = By
			.xpath("//button[@id='gwt-debug-Confirm Action-OK']");
	public By LDAP_CONFIGURATION_BASE_CONTEXT_DN_RESTART_REQUIRE_YES_BTN = By
			.xpath("//button[@id='gwt-debug-Restart Required-Yes']");
	public By LDAP_CONFIGURATION_BASE_CONTEXT_DN_RESTART_OK_BTN = By
			.xpath("//button[@id='gwt-debug-Restarting Services-OK']");
	public By LDAP_CONFIGURATION_FORCE_SYNC_BTN = By
			.xpath("//div[@id='gwt-debug-forceUpdate']");
	public By LDAP_CONFIGURATION_CONFIRM_ACTION_OK_BTN = By
			.xpath("//button[@id='gwt-debug-Confirm Action-OK']");
	public By LDAP_CONFIGURATION_SYNC_STATUS_TXT = By
			.xpath("//div[@id='gwt-debug-lastSyncStatus']");
	public By LDAP_CONFIGURATION_SYNC_SUCCESS_OK_BTN = By
			.xpath("//button[@id='gwt-debug-Success-OK']");
	public By LDAP_CONFIGURATION_BASE_CONTEXT_DN_SELECT_CHECKBOX = By
			.xpath("//table[@id='gwt-debug-additionalBaseDnList']//td[1]//input[@type='checkbox']");
	public By LDAP_CONFIGURATION_BASE_CONTEXT_DN_REMOVE_BTN = By
			.xpath("//button[@id='gwt-debug-removeBaseDNButton']");
	public By LDAP_CONFIGURATION_BASE_CONTEXT_DN_RESTART_REQUIRE_NO_BTN = By
			.xpath("//button[@id='gwt-debug-Restart Required-No']");
	public By LDAP_CONFIGURATION_RESTART_LINK = By
			.xpath("//div[text()='A restart is required to complete configuration. Click here to restart.']");

	// ###########################################################################################################################
	// ########################################LOCATOR OF WEB ELEMENTS IN
	// CONFIGURATION PAGE######################################
	// ###########################################################################################################################

	public By DYNAMIC_CONFIGURATION_CONFIGURATION_STATUS_MESSAGE_ERROR = By
			.xpath("//div[@class='statusmessageerror' and @style='display: block;']");
	public By DYNAMIC_CONFIGURATION_CONFIGURATION_PAGE_IFRAME = By
			.xpath("//iframe[contains(@src,'protected/acwd/pages/index.html')]");
	public By DYNAMIC_CONFIGURATION_CONFIGURATION_PAGE_HEADER_TITLE = By
			.xpath("//*[@id='gwt-debug-configurationHeader']/legend");
	public By DYNAMIC_CONFIGURATION_CONFIGURATION_PAGE_USER_SELECT_BTN = By
			.xpath("//*[@id='radioUserFilter']");
	public By DYNAMIC_CONFIGURATION_CONFIGURATION_PAGE_USER_TXT = By
			.xpath("//input[@id='inputUsername']");
	public By DYNAMIC_CONFIGURATION_CONFIGURATION_PAGE_GROUP_SELECT_BTN = By
			.xpath("//*[@id='radioGroupFilter']");
	public By DYNAMIC_CONFIGURATION_CONFIGURATION_PAGE_GROUP_TXT = By
			.xpath("//*[@id='groupSelector2']");
	public By DYNAMIC_CONFIGURATION_CONFIGURATION_PAGE_RETRIEVE_BTN = By
			.xpath("//*[@id='apply-filter']");
	public By DYNAMIC_CONFIGURATION_CONFIGURATION_PAGE_SELECT_CONFIGURATION_BTN = By
			.xpath("//*[@id='radioCfgFilter']");
	public By DYNAMIC_CONFIGURATION_CONFIGURATION_PAGE_SELECT_USER_LIST = By
			.xpath("//*[@id='testCfgSelector']");
	public By DYNAMIC_CONFIGURATION_CONFIGURATION_PAGE_SAVE_SELECT_CONFIG_LIST = By
			.xpath("//*[@id='testCfgDlgSelector']");
	public By DYNAMIC_CONFIGURATION_CONFIGURATION_PAGE_PUBLISH_USER_BTN = By
			.xpath("//*[@id='cfg_publish_1']");
	public By DYNAMIC_CONFIGURATION_CONFIGURATION_PAGE_SAVE_USER_BTN = By
			.xpath("//*[@id='cfg_save_1']");

	public By DYNAMIC_CONFIGURATION_CONFIGURATION_PAGE_CREATE_NEW_CHECKBOX = By
			.xpath("//*[@id='radioNew']");
	public By DYNAMIC_CONFIGURATION_CONFIGURATION_PAGE_CONFIG_NAME_TXT = By
			.xpath("//*[@id='testCfgInputName']");

	public By DYNAMIC_CONFIGURATION_CONFIGURATION_PAGE_SELECT_IMPORT_TYPE = By
			.xpath("//*[@id='selectImportType']");
	public By DYNAMIC_CONFIGURATION_CONFIGURATION_PAGE_IMPORT_STATUS = By
			.xpath("//span[@id='statusmessagespan_bulkimport']");
	public By DYNAMIC_CONFIGURATION_CONFIGURATION_PAGE_IMPORT_STATUS_COMPLETE = By
			.xpath("//span[@id='statusmessagespan_bulkimport'and contains(text(),'completed')]");
	public By DYNAMIC_CONFIGURATION_CONFIGURATION_PAGE_IMPORT_BTN = By
			.xpath("//*[@id='cfg_import_1']");
	public By DYNAMIC_CONFIGURATION_CONFIGURATION_PAGE_BULK_IMPORT_BTN = By
			.xpath("//*[@id='import_Import_button']");
	public By DYNAMIC_CONFIGURATION_CONFIGURATION_PAGE_BULK_STATUS_BTN = By
			.xpath("//*[@id='import_Status_button']");
	public By DYNAMIC_CONFIGURATION_CONFIGURATION_PAGE_IMPORT_FILE_BTN = By
			.xpath("//label[@for='import_file']");

	public By DYNAMIC_CONFIGURATION_CONFIGURATION_PAGE_SAVE_USER_COMFIRM_BTN = By
			.xpath("html/body/div[4]/div[3]/div/button[1]");
	public By DYNAMIC_CONFIUGRATION_CONFIGURATION_PAGE_DELETE_CONFIGURATION_BTN = By
			.xpath("//*[@id='cfg_cancel_1']");
	public By DYNAMIC_CONFIGURATION_CONFIGURATION_PAGE_DELETE_CONFIRM_BTN = By
			.xpath("//span[@class='ui-button-text' and contains(text(),'Yes')]");

	public By autoConfigPageDeleteConfigurationMessage(String config) {
		return By
				.xpath("//*[@id='statusmessagespan' and contains(text(),'Test Configuration "
						+ config + " was removed successfully')]");
	}

	public By DYNAMIC_CONFIGURATION_CONFIGURATION_PAGE_STATUS_MESSAGE = By
			.xpath("//*[@id='statusmessagespan']");

	public By autoConfigPageSettingValueCheckboxLocators(String tab,String variable) {
		return By.xpath("//*[@id='" + tab + "tablejson_wrapper']//div[text()='"+ variable + "']/../..//*[@type='checkbox']");
	};

	public By autoConfigPageSettingValueTextLocators(String tab, String variable) {
		return By.xpath("//*[@id='" + tab + "tablejson_wrapper']//div[text()='"
				+ variable + "']/../..//*[@type='text']");
	};

	public By autoConfigPageDiscoverdTabSettingValueTextLocators(String variable) {
		return By.xpath("//*[@id='accounts']//div[text()='" + variable
				+ "']/../..//*[@type='text']");
	};

	public By autoConfigPageSettingValueTabDisplayLocators(String tab) {
		return By.xpath("//a[text()='" + tab + "']");
	};

	public By autoConfigPageSettingValueDisplayNumberVariableDropListLocators(
			String tab) {
		return By.xpath("//*[@id='" + tab + "tablejson_length']/label/select");
	};

	// ###########################################################################################################################
	// ##################################LOCATOR OF WEB ELEMENTS IN
	// CONFIGURATION PAGE PUBLISH WINDOW#############################
	// ###########################################################################################################################

	public By PUBLISH_WINDOW_USER_CHECKBOX = By
			.xpath("//*[@id='cfg-publish-cb-user']");
	public By PUBLISH_WINDOW_USER_TXT = By
			.xpath("//*[@id='cfg-publish-edit-user']");

	public By PUBLISH_WINDOW_GROUP_SET_CHECKBOX = By
			.xpath("//*[@id='cfg-publish-cb-group']");
	public By PUBLISH_WINDOW_GROUP_SET_TXT = By
			.xpath("//*[@id='cfg-publish-select-group2']");

	public By PUBLISH_WINDOW_FLATFORM_CHECKBOX = By
			.xpath("//*[@id='cfg-publish-cb-platform']");
	public By PUBLISH_WINDOW_PLATFORM_SELECT = By
			.xpath("//*[@id='cfg-publish-select-platform']");

	public By PUBLISH_WINDOW_PHONEMODEL_CHECKBOX = By
			.xpath("//*[@id='cfg-publish-cb-phonemodel']");
	public By PUBLISH_WINDOW_PHONEMODEL_SELECT = By
			.xpath("//*[@id='cfg-publish-select-phonemodel']");

	public By PUBLISH_WINDOW_GLOBAL_SET_CHECKBOX = By
			.xpath("//*[@id='cfg-publish-cb-global']");
	public By PUBLISH_WINDOW_PUBLISH_BTN = By
			.xpath("html/body/div[6]/div[3]/div/button[1]");
	public By PUBLISH_WINDOW_PUBLISH_YES_CONFIRM_BTN = By
			.xpath("//*[@aria-describedby='dialog_publish_confirm']//*[@class='ui-button-text' and text()='Yes']");

	// ############################################################################################################################
	// ########################################LOCATOR OF WEB ELEMENTS IN WEB
	// DEPLOYMENT PAGE######################################
	// ############################################################################################################################

	public By DEPLOYMENT_PAGE_IFRAME = By
			.xpath("//iframe[contains(@src,'protected/acwd/pages/deployment.html')]");
	public By WEB_DEPLOYMENT_PAGE_RESET_BTN = By
			.xpath("//*[@id='reset_button']");
	public By WEB_DEPLOYMENT_PAGE_SAVE_BTN = By.xpath("//*[@id='save_button']");
	public By WEB_DEPLOYMENT_PAGE_DELETE_BTN = By
			.xpath("//*[@id='delete_button']");
	public By WEB_DEPLOYMENT_PAGE_DELETE_CONFIRM_BTN = By
			.xpath("//span[text()='Yes']");
	public By WEB_DEPLOYMENT_PAGE_TYPE_DROPLIST = By
			.xpath("//*[@id='type_input']");
	public By WEB_DEPLOYMENT_PAGE_TITLE_TXT = By
			.xpath("//*[@id='title_input']");
	public By WEB_DEPLOYMENT_PAGE_DESCRIPTION_TXT = By
			.xpath("//*[@id='description_input']");
	public By WEB_DEPLOYMENT_PAGE_VERSION_TXT = By
			.xpath("//*[@id='version_input']");
	public By WEB_DEPLOYMENT_PAGE_OS_DROPLIST = By.xpath("//*[@id='os_input']");
	public By WEB_DEPLOYMENT_PAGE_FILE_BTN = By.xpath("//*[@id='item_file']");
	public By WEB_DEPLOYMENT_PAGE_USERNAME_DIALOG_TXT = By
			.xpath("//*[@id='upload_dialog_username']");
	public By WEB_DEPLOYMENT_PAGE_PASSWORD_DIALOG_TXT = By
			.xpath("//*[@id='upload_dialog_password']");
	public By WEB_DEPLOYMENT_PAGE_UPLOAD_BTN = By
			.xpath("//*[@id='upload_button']");
	public By WEB_DEPLOYMENT_PAGE_UPLOAD_CONTINUE_BTN = By
			.xpath("//*[@id='upload_dialog_continue_button']");
	public By WEB_DEPLOYMENT_PAGE_UPLOAD_SUCCESS_TXT = By
			.xpath("//td[text()='Success']");
	public By WEB_DEPLOYMENT_PAGE_UPLOAD_CLOSE_BTN = By
			.xpath("html/body/div[3]/div[3]/div");
	public By WEB_DEPLOYMENT_PAGE_CUSTOM_URL_CHECKBOX = By
			.xpath("//*[@id='radio_download_custom']");
	public By WEB_DEPLOYMENT_PAGE_CUSTOM_URL_TXT = By
			.xpath("//*[@id='download_custom_url']");
	public By WEB_DEPLOYMENT_PAGE_DOWNLOAD_STATISTIC_MAC_FRESH_INSTALL_TXT = By
			.xpath("//td[contains(text(),'Mac')]/../td[2]");
	public By WEB_DEPLOYMENT_PAGE_DOWNLOAD_STATISTIC_MAC_UPDATES_TXT = By
			.xpath("//td[contains(text(),'Mac')]/../td[3]");
	public By WEB_DEPLOYMENT_PAGE_DOWNLOAD_STATISTIC_WINDOWS_FRESH_INSTALL_TXT = By
			.xpath("//td[contains(text(),'Windows')]/../td[2]");
	public By WEB_DEPLOYMENT_PAGE_DOWNLOAD_STATISTIC_WINDOWS_UPDATES_TXT = By
			.xpath("//td[contains(text(),'Windows')]/../td[3]");

	public By webDeploymentPageAppcastitemLocators(String Name) {
		return By.xpath("//td[text()='" + Name + "']");
	};

	/*
	 * ======================================================NEW
	 * LOCATOR==========
	 * ================================================================
	 */
	// Huy Dao
	public By AUTOCONFIG_GROUP_COMM_ADDR_HANDLE_TYPE = By
			.xpath("//*[@id='grouptablejson_wrapper']//div[text()='COMM_ADDR_HANDLE_TYPE']/../..//select");
	public By DINAMIC_CONFIGURATION_CONFIGURATION_PAGE_GROUP_RESULT = By
			.xpath("//*[@id='ui-id-8']");

	public By DYNAMIC_CONFIGURATION_CONFIGURATION_PAGE_TEST_BTN = By
			.xpath("//*[@id='cfg_test_1']");
	public By DYNAMIC_CONFIGURATION_TESTCONFIG_RESULT = By.xpath("//pre");
	// public By DYNAMIC_CONFIGURATION_RETRIEVE_FLATFORM =
	// By.id("flatformSelectorForUser");//select[@id='platformSelectorForUser']
	public By DYNAMIC_CONFIGURATION_DNS_MAPPING_PAGE_IFRAME = By
			.xpath("//iframe[contains(@src,'protected/acwd/pages/dnsmapping.html')]");
	public By DYNAMIC_CONFIGURATION_RETRIEVE_FLATFORM = By
			.xpath("//select[@id='platformSelectorForUser']");
	public By DYNAMIC_CONFIGURATION_CONFIGURATION_PAGE_CREATE_USER_TXT = By
			.id("testCfgInputName");
	public By DYNAMIC_CONFIGURATION_DNS_MAPPING_ADD_BTN = By
			.id("dns_Add_button");
	public By DYNAMIC_CONFIGURATION_DNS_MAPPING_SAVE_BTN = By
			.id("dns_Save_button");
	public By DYNAMIC_CONFIGURATION_DNS_IP_TXT = By
			.xpath("//table[@id='dns_table']/tbody//td[@class='sorting_1']/input");
	public By DYNAMIC_CONFIGURATION_DNS_DOMAIN_TXT = By
			.xpath("//table[@id='dns_table']/tbody//td[@class='sorting_1']/input/../following-sibling::td/input");

	public By dynamicConfigurationDNSip(String ip) {
		return By
				.xpath("//table[@id='dns_table']/tbody//td[@class='sorting_1' and contains(text(),'"
						+ ip + "')]");
	}

	public By dynamicConfigurationDNSdomainFollowIp(String ip) {
		return By
				.xpath("//table[@id='dns_table']/tbody//td[@class='sorting_1' and contains(text(),'"
						+ ip + "')]/following-sibling::td/input");
	}

	public By dynamicConfigurationDNSdomain(String domain) {
		return By.xpath("//table[@id='dns_table']/tbody//td/input[@value='"
				+ domain + "']");
	}

	public By PICTURE_CONFIGURATION_PAGE_IFRAME = By
			.xpath("//iframe[contains(@src,'protected/acwd/pages/picturecfg.html')]");

	public By DYNAMIC_CONFIGURATION_DEFAULT_ALLOW_PWD_CHECKBOX = By
			.id("allowpasswords_checkbox");
	public By DYNAMIC_CONFIGURATION_DEFAULT_LOCK_PREF_CHECKBOX = By
			.id("lockedpreferences_checkbox");
	public By DYNAMIC_CONFIGURATION_DEFAULT_OBSCURED_PREF_CHECKBOX = By
			.id("obscuredpreferences_checkbox");
	public By DYNAMIC_CONFIGURATION_DEFAULT_PAGE_IFRAME = By
			.xpath("//iframe[contains(@src,'protected/acwd/pages/defaults.html')]");
	public By DYNAMIC_CONFIGURATION_DEFAULT_SAVE_BTN = By
			.id("defaults_Save_button");

	public By CONTACT_INTEGRITY_TEXTBOX = By.id("gwt-debug-userListTextArea");
	public By CONTACT_INTEGRITY_SUBMIT_BTN = By.id("gwt-debug-submitButton");
	public By CONTACT_INTEGRITY_CANCEL_BTN = By.id("gwt-debug-cancelButton");
	// public By CONTACT_INTEGRITY_POPUP_TXT =
	// By.xpath("//div[@style='white-space: pre-wrap; overflow: auto;']");
	public By CONTACT_INTEGRITY_POPUP_TXT = By
			.xpath("//div[contains(@class, 'dialogMiddleCenter')]//div[contains(@class, 'gwt-HTML')]");
	// public By CONTACT_INTEGRITY_POPUP_TXT =
	// By.xpath("//div[contains(@style, 'overflow: auto; white-space: pre-wrap;')]");
	// public By CONTACT_INTEGRITY_OK_BTN = By.id("gwt-debug-Success-OK");
	public By CONTACT_INTEGRITY_OK_BTN = By.id("gwt-debug-Submit-OK");

	public By LOGIN_INFO_USER_NAME = By.id("gwt-debug-welcomeLabel");
	public By LOGIN_INFO_USER_ROLE = By.id("gwt-debug-loginRole");

	public By CONFIRM_DISCARD_OK = By.id("gwt-debug-Confirm Action-OK");
	public By CONFIRM_DISCARD_CANCEL = By.id("gwt-debug-Confirm Action-Cancel");

	public By ABOUT_BTN = By.id("gwt-debug-aboutButton");
	// public By ABOUT_BTN_ABOUT_TAB =
	// By.xpath("//div[@class ='gwt-Label' and text()='About']");
	// public By ABOUT_BTN_LICENSE_TAB =
	// By.xpath("//div[@class ='gwt-Label' and text()='Third Party Licenses']");
	public By ABOUT_BTN_VERSION = By.id("gwt-debug-aboutVersions");
	public By ABOUT_BTN_LICENSE = By.id("gwt-debug-acknowledgementsText");
	public By ABOUT_BTN_CLOSE_BTN = By.id("gwt-debug-closeAbout");
	public By ABOUT_BTN_ABOUT_TAB = By
			.xpath("//div[@class ='gwt-Label' and text()='About']/../..");
	public By ABOUT_BTN_LICENSE_TAB = By
			.xpath("//div[@class ='gwt-Label' and text()='Third Party Licenses']/../..");

	public By aboutBtnTab(String tab) {
		return By.xpath("//div[@class ='gwt-Label' and contains(text(),'" + tab
				+ "')]");
	}

	/*
	 * ======================================================NEW LOCATOR FOR
	 * AADS
	 * BROWSER==============================================================
	 * ============
	 */
	// TTKNgan
	// SERVICE CONTROL PAGE
	public By SERVICE_CONTROL_APPLICATION_MGMT_PAGE_DEVICE_SERVICES_CHECKBOX = By
			.xpath("//*[@id='gwt-debug-appCheckbox-input']");
	public By SERVICE_CONTROL_APPLICATION_MGMT_PAGE_DEVICE_SERVICES_SELECT_STOP_BTN = By
			.xpath("//*[@id='gwt-debug-appStop']");
	public By SERVICE_CONTROL_APPLICATION_MGMT_PAGE_DEVICE_SERVICES_STOP_SELECT_COFIRM_BTN = By
			.xpath("//*[@id='gwt-debug-Confirm Action-OK']");
	public By SERVICE_CONTROL_APPLICATION_MGMT_PAGE_DEVICE_SERVICES_SELECT_START_BTN = By
			.xpath("//*[@id='gwt-debug-appStart']");
	public By SERVICE_CONTROL_APPLICATION_MGMT_PAGE_DEVICE_SERVICES_START_SUCESSFUL = By
			.xpath("//*[@id='gwt-debug-Success-OK']");
	public By SERVICE_CONTROL_APPLICATION_MGMT_PAGE_DEVICE_SERVICES_STOP_SUCESSFUL = By
			.xpath("//*[@id='gwt-debug-Success-OK']");

	public By SERVICE_CONTROL_APPLICATION_MGMT_PAGE_APPLICATION_PROPERTIES_ADMIN = By
			.id("gwt-debug-adminSessionTimeout");
	// public By
	// SERVICE_CONTROL_APPLICATION_MGMT_PAGE_APPLICATION_PROPERTIES_ADMIN =
	// By.xpath("//*[@id='gwt-debug-adminSessionTimeout']");
	public By SERVICE_CONTROL_APPLICATION_MGMT_PAGE_APPLICATION_PROPERTIES_APP = By
			.id("gwt-debug-appSessionTimeout");
	public By SERVICE_CONTROL_APPLICATION_MGMT_PAGE_APPLICATION_PROPERTIES_MAX = By
			.id("gwt-debug-maxConcurrentSessions");
	public By SERVICE_CONTROL_APPLICATION_MGMT_PAGE_APPLICATION_PROPERTIES_CONCURRENT = By
			.id("gwt-debug-concurrentSessionsPerUser");
	public By SERVICE_CONTROL_APPLICATION_MGMT_PAGE_APPLICATION_PROPERTIES_SAVE_BTN = By
			.id("gwt-debug-appPropSave");
	public By SERVICE_CONTROL_APPLICATION_MGMT_PAGE_APPLICATION_PROPERTIES_CONFIRM_SAVE_BTN = By
			.xpath("//*[@id='gwt-debug-Confirm Action-OK']");
	public By SERVICE_CONTROL_APPLICATION_MGMT_PAGE_APPLICATION_PROPERTIES_RESTART_BTN = By
			.id("gwt-debug-Saving Application properties-OK");
	public By SERVICE_CONTROL_APPLICATION_MGMT_PAGE_APPLICATION_PROPERTIES_CONFIRM_RESTART_BTN = By
			.id("gwt-debug-Restart Required-Yes");
	public By SERVICE_CONTROL_APPLICATION_MGMT_PAGE_APPLICATION_PROPERTIES_CONFIRM_RESTART_SUCCESSFUL = By
			.id("gwt-debug-Restarting Services-OK");

	// Client Administration page
	public By CLIENT_ADMINISTRATION_HTTP_CLIENTS_PAGE_REST_DROPDOWN_LISTBOX = By
			.id("gwt-debug-clientCertListBox");
	public By CLIENT_ADMINISTRATION_HTTP_CLIENTS_PAGE_OAMP_DROPDOWN_LISTBOX = By
			.id("gwt-debug-oampCertListBox");
	public By CLIENT_ADMINISTRATION_FEATURE_ENTITLEMENTS_PAGE_URL = By
			.id("gwt-debug-weblmUrl");

	// ###########################################################################################################################
	// ########################################LOCATOR OF WEB ELEMENTS IN SERVER
	// CONNECTIONS PAGE OF AADS ####################
	// ###########################################################################################################################
	// public By SERVER_CONNECTIONS_LDAP_CONFIG_ENTERPRISE_PAGE_ADD_BTN =
	// By.xpath("//div[@class='gwt-TabLayoutPanelTabInner']//img[@class='gwt-Image']");
	public By SERVER_CONNECTIONS_LDAP_CONFIG_ENTERPRISE_PAGE_ENTERPRISE_TYPE = By
			.xpath("//div[@class='gwt-TabLayoutPanelContent' and not(@aria-hidden='true')]//*[@id='gwt-debug-selectedDirName']");
	// public By SERVER_CONNECTIONS_LDAP_CONFIG_ENTERPRISE_PAGE_CONFIRM_SAVE_BTN
	// = By.id("gwt-debug-warnDialogBox");

	public By SERVER_CONNECTIONS_LDAP_CONFIG_ENTERPRISE_PAGE_CONFIRM_SAVE_BTN = By
			.id("gwt-debug-Confirm Action-OK");
	public By SERVER_CONNECTIONS_LDAP_CONFIG_ENTERPRISE_PAGE_SAVE_AND_APPLY_LDAP_OK_BTN = By
			.id("gwt-debug-Saving and applying LDAP configuration...-OK");
	public By SERVER_CONNECTIONS_LDAP_CONFIG_ENTERPRISE_PAGE_RESTART_AFTER_CONFIG_YES_BTN = By
			.id("gwt-debug-Restart Required-Yes");
	public By SERVER_CONNECTIONS_LDAP_CONFIG_ENTERPRISE_PAGE_RESTART_COMPLETED_OK_BTN = By
			.id("gwt-debug-Restarting Services-OK");
	// public By
	// SERVER_CONNECTIONS_LDAP_CONFIG_ENTERPRISE_PAGE_NEW_DIRECTORY_TAB =
	// By.xpath("//div[@class='gwt-HTML' and text()='ActiveDirectory_2016']");
	// public By
	// SERVER_CONNECTIONS_LDAP_CONFIG_ENTERPRISE_PAGE_NEW_DIRECTORY_TAB =
	// By.xpath("//div[@class='gwt-TabLayoutPanelTab GHTHW0DCHC gwt-TabLayoutPanelTab-selected']");
	public By SERVER_CONNECTIONS_LDAP_CONFIG_ENTERPRISE_PAGE_NEW_DIRECTORY_TAB = By
			.xpath("//*[@id='gwt-debug-ldapHeader']/div/div[1]/div[3]/div/div[2]/div/div/div/img/../..//"
					+ "div[1]");
	public By SERVER_CONNECTIONS_LDAP_CONFIG_ENTERPRISE_PAGE_DELETED_BTN = By
			.xpath("//*[@class='gwt-TabLayoutPanelContentContainer']/div[last()]/preceding-sibling::div[1]//*[@id='gwt-debug-deleteServer']");

	// public By SERVER_CONNECTIONS_LDAP_CONFIG_ENTERPRISE_PAGE_DELETED_BTN =
	// By.id("gwt-debug-deleteServer");
	public By SERVER_CONNECTIONS_LDAP_CONFIG_ENTERPRISE_PAGE_CONFIRM_ACTION_OK_BTN = By
			.id("gwt-debug-Confirm Action-OK");
	public By SERVER_CONNECTIONS_LDAP_CONFIG_ENTERPRISE_PAGE_DELETED_SUCCESS_OK_BTN = By
			.id("gwt-debug-Success-OK");

	public By ldapTab(String tabName) {
		return By.xpath("//div[contains(text(),'" + tabName + "')]");
	}

	public By SERVER_CONNECTIONS_LDAP_CONFIG_ENTERPRISE_PAGE_BASE_CONTEXT_DN = By
			.xpath("//div[@class='gwt-TabLayoutPanelContent' and not(@aria-hidden='true')]//*[@id='gwt-debug-baseDn']");
	public By SERVER_CONNECTIONS_LDAP_CONFIG_ENTERPRISE_PAGE_LAST_UPDATE_TIME_ATTRIBUTE_ID = By
			.xpath("//div[@class='gwt-TabLayoutPanelContent' and not(@aria-hidden='true')]//*[@id='gwt-debug-lastUpdatedTimeAttr']");
	// public By SERVER_CONNECTIONS_LDAP_CONFIG_ENTERPRISE_PAGE_SAVE_BTN =
	// By.id("gwt-debug-saveLdap");
	public By SERVER_CONNECTIONS_CORS_CONFIG_SERVICE_INTERFACE_CORS_CHECKBOX = By
			.id("enable_cors_checkbox");
	public By SERVER_CONNECTIONS_CORS_CONFIG_SERVICE_INTERFACE_ORIGIN_CHECKBOX = By
			.id("any_origin_checkbox");
	public By SERVER_CONNECTIONS_CORS_CONFIG_SERVICE_INTERFACE_DOMAIN_TXT = By
			.id("domains_input");
	public By SERVER_CONNECTIONS_CORS_CONFIG_SERVICE_INTERFACE_SAVE_BTN = By
			.id("cors_save_button");
	public By SERVER_CONNECTIONS_CORS_CONFIG_SERVICE_INTERFACE_CONFIRM_ACTION_SAVE_BTN = By
			.xpath("//*[@class='ui-button-text' and text() = 'Save']");

	// ###########################################################################################################################
	// ########################################LOCATOR OF WEB ELEMENTS IN
	// CLUSTER CONFIGURATION PAGE ###########################
	// ###########################################################################################################################
	public By CLUSTER_CONFIG_CLUSTER_NODES_PAGE_VIRTUAL_IP_FIELD = By
			.xpath("//span[@class='gwt-InlineLabel GHTHW0DCMK' and text()='Virtual IP:']");
	public By CLUSTER_CONFIG_CLUSTER_NODES_PAGE_VIRTUAL_IP_MASTER_FIELD = By
			.xpath("//span[@class='gwt-InlineLabel GHTHW0DCMK' and text()='Virtual IP Master:']");
	public By CLUSTER_CONFIG_CLUSTER_NODES_PAGE_VIRTUAL_IP_BACKUP_FIELD = By
			.xpath("//span[@class='gwt-InlineLabel GHTHW0DCMK' and text()='Virtual IP Backup:']");
	public By CLUSTER_CONFIG_CLUSTER_NODES_PAGE_SEED_NODE_IP_FIELD = By
			.xpath("//span[@class='gwt-InlineLabel GHTHW0DCMK' and text()='Seed Node IP:']");
	public By CLUSTER_CONFIG_CLUSTER_NODES_PAGE_SEED_NODE_IP_TXT = By
			.id("gwt-debug-seedNodeValue");
	public By CLUSTER_CONFIG_CLUSTER_NODES_PAGE_STATUS_CLUSTER = By
			.xpath("//*[@class='GHTHW0DCOE GHTHW0DCAG']//div[@style='outline-style:none;' and text()='ACTIVE']");
	public By CLUSTER_CONFIG_CLUSTER_NODES_PAGE_SINGLETON_SVR_CLUSTER = By
			.xpath("//*[@class='GHTHW0DCOE GHTHW0DCAG GHTHW0DCLF GHTHW0DCI']//div[@style='outline-style:none;']");
	public By CLUSTER_CONFIG_CLUSTER_NODES_PAGE_STATUS_SINGLE = By
			.xpath("//*[@class = 'GHTHW0DCOE GHTHW0DCAF']//div[@style = 'outline-style:none;' and text() = 'ACTIVE']");
	public By CLUSTER_CONFIG_CLUSTER_NODES_PAGE_SINGLETON_SVR_SINGLE = By
			.xpath("//*[@class = 'GHTHW0DCOE GHTHW0DCAF GHTHW0DCLF GHTHW0DCI']//div[@style = 'outline-style:none;']");

	// ###########################################################################################################################
	// ########################################LOCATOR OF WEB ELEMENTS IN LOGS
	// MANAGEMENT PAGE ###########################
	// ###########################################################################################################################
	public By LOGS_MANAGEMENT_LOG_LEVEL_PAGE_CURRENT_LOGGING_LEVEL_DROPDOWN_BOX = By
			.id("gwt-debug-logLevelList");
	public By LOGS_MANAGEMENT_LOG_LEVEL_PAGE_SAVE_BTN = By
			.id("gwt-debug-saveLogLevel");
	// public By LOGS_MANAGEMENT_LOG_LEVEL_PAGE_CONFIRM_ACTION_SAVE_BTN =
	// By.id("gwt-debug-Confirm Action-Save");
	public By LOGS_MANAGEMENT_LOG_LEVEL_PAGE_CONFIRM_ACTION_SAVE_BTN = By
			.xpath("//div[@class='gwt-DialogBox']//button[@id='gwt-debug-Confirm Action-Save']/..");

	public By LOGS_MANAGEMENT_LOG_LEVEL_PAGE_SAVE_SUCCESS_OK_BTN = By
			.id("gwt-debug-Success-OK");
	public By LOGS_MANAGEMENT_LOG_LEVEL_PAGE_COLLECT_BTN = By
			.xpath("//div[text()='10.255.250.38']/../following-sibling::td//button[text()='Collect']");

	public By logsManagementLogLevelPageCollectBtn(String host) {
		return By.xpath("//div[text()='" + host
				+ "']/../following-sibling::td//button[text()='Collect']");
	}

	public By LOGS_MANAGERMENT_LOG_LEVEL_PAGE_COLLECT_LOG_OK_BTN = By
			.id("gwt-debug-Collect Logs-OK");

	public By logsManagementLogLevelPageDownloadBtn(String host) {
		return By.xpath("//div[text()='" + host
				+ "']/../following-sibling::td//button[text()='Download']");
	}

	// ###########################################################################################################################
	// ########################################LOCATOR OF WEB ELEMENTS IN
	// CERTIFICATE MANAGEMENT PAGE ###########################
	// ###########################################################################################################################
	public By CERTIFICATE_MANAGEMENT_SMGR_CERTIFICATES_SMGR_ADDR = By
			.id("gwt-debug-smgrAddress");
	public By CERTIFICATE_MANAGEMENT_SMGR_CERTIFICATES_AADS_COMMON_NAME = By
			.id("gwt-debug-frontEndAddress");
	public By CERTIFICATE_MANAGEMENT_IDENTITY_CERT_CSR_CREATE_BTN = By
			.xpath("//*[@class='html-face' and text() = 'Create...']");
	public By CERTIFICATE_MANAGEMENT_IDENTITY_CERT_CSR_ALIAS_TEXT_BOX = By
			.id("gwt-debug-alias");
	public By CERTIFICATE_MANAGEMENT_IDENTITY_CERT_CSR_APPLY_BTN = By
			.id("gwt-debug-Create Certificate Signing Request-Apply");
	public By CERTIFICATE_MANAGEMENT_IDENTITY_CERT_CSR_ALREADY_EXIT = By
			.id("gwt-debug-Confirmation Required -OK");

	// public By CERTIFICATE_MANAGEMENT_IDENTITY_CERT_CSR_ALIAS_VERIFY (String
	// alias) { return
	// By.xpath("//div[@style='outline-style:none;' and text() ='"+alias+"']");};
	// public By CERTIFICATE_MANAGEMENT_IDENTITY_CERT_CSR_ALIAS_VERIFY =
	// By.xpath("//*[@class='GHTHW0DCOE GHTHW0DCAF GHTHW0DCBF GHTHW0DCCG']");
	public By CERTIFICATE_MANAGEMENT_IDENTITY_CERT_CSR_ALIAS_VERIFY(String alias) {
		return By.xpath("//div[contains(text(), '" + alias + "')]");
	};

	public By CERTIFICATE_MANAGEMENT_IDENTITY_CERT_CSR_DELETE_BTN = By
			.id("gwt-debug-deleteCSRButton");
	public By CERTIFICATE_MANAGEMENT_IDENTITY_CERT_CSR_DELETE_OK_BTN = By
			.id("gwt-debug-Delete Signing Request-OK");
	public By CERTIFICATE_MANAGEMENT_IDENTITY_CERT_CSR_DELETE_DONE_BTN = By
			.id("gwt-debug--Done");

	public By CERTIFICATE_MANAGEMENT_IDENTITY_CERT_IMPORT_KEYSTORE_BTN = By
			.id("gwt-debug-importCertButton");
	// public By
	// CERTIFICATE_MANAGEMENT_IDENTITY_CERT_IMPORT_KEYSTORE_CHOOSE_FILE_BTN =
	// By.id("gwt-debug-certFile");
	public By CERTIFICATE_MANAGEMENT_IDENTITY_CERT_IMPORT_KEYSTORE_CHOOSE_FILE_BTN = By
			.xpath("//input[@type='file' and @id='gwt-debug-certFile']");
	public By CERTIFICATE_MANAGEMENT_IDENTITY_CERT_IMPORT_KEYSTORE_PWD_TXT = By
			.id("gwt-debug-password");
	public By CERTIFICATE_MANAGEMENT_IDENTITY_CERT_IMPORT_KEYSTORE_ALIAS_TXT = By
			.id("gwt-debug-alias");
	public By CERTIFICATE_MANAGEMENT_IDENTITY_CERT_IMPORT_KEYSTORE_APPLY_BTN = By
			.id("gwt-debug-Import Certificate-Apply");
	public By CERTIFICATE_MANAGEMENT_IDENTITY_CERT_IMPORT_KEYSTORE_CONFIRM_IMPORT_OK_BTN = By
			.id("gwt-debug--OK");
	public By CERTIFICATE_MANAGEMENT_IDENTITY_CERT_IMPORT_KEYSTORE_DONE_BTN = By
			.id("gwt-debug--Done");
	public By CERTIFICATE_MANAGEMENT_IDENTITY_CERT_IMPORT_KEYSTORE_CONFIRM_OVERRIDE_BTN = By
			.id("gwt-debug-Confirmation Required -OK");

	// public By
	// CERTIFICATE_MANAGEMENT_IDENTITY_CERT_EXPORT_KEYSTORE_SELECT_CERT =
	// By.xpath("//*[@class='GHTHW0DCOE GHTHW0DCAF GHTHW0DCBF GHTHW0DCCG']");
	// public By
	// CERTIFICATE_MANAGEMENT_IDENTITY_CERT_EXPORT_KEYSTORE_SELECT_CERT (String
	// alias) { return
	// By.xpath("//div[@style='outline-style:none;' and text() ='"+alias+"']");};
	public By CERTIFICATE_MANAGEMENT_IDENTITY_CERT_EXPORT_KEYSTORE_SELECT_CERT(
			String alias) {
		return By.xpath("//div[contains(text(), '" + alias + "')]");
	};

	public By CERTIFICATE_MANAGEMENT_IDENTITY_CERT_EXPORT_KEYSTORE_BTN = By
			.id("gwt-debug-exportCertButton");
	public By CERTIFICATE_MANAGEMENT_IDENTITY_CERT_EXPORT_KEYSTORE_OK_BTN = By
			.id("gwt-debug-Export Certificate-OK");
	public By CERTIFICATE_MANAGEMENT_IDENTITY_CERT_DELETE_KEYSTORE_BTN = By
			.id("gwt-debug-deleteCertButton");
	public By CERTIFICATE_MANAGEMENT_IDENTITY_CERT_DELETE_KEYSTORE_CONFIRM_OK_BTN = By
			.id("gwt-debug-Delete Certificate-OK");
	public By CERTIFICATE_MANAGEMENT_IDENTITY_CERT_DELETE_KEYSTORE_SUCCESSFUL_DONE_BTN = By
			.id("gwt-debug--Done");

	public By PICTURES_CONFIGURATION_ALLOW_USER_UPLOAD_PHOTO_CHECKBOX = By
			.id("allowupload_checkbox");
	public By PICTURES_CONFIGURATION_SAVE_BTN = By.id("pictures_Save_button");

	public By CERTIFICATE_MANAGEMENT_TRUSTSTORE_EXPORT_BTN = By
			.id("gwt-debug-exportTrustCertButton");

	// for Certificate error with IE browser
	public By IE_BROWSER_CERTIFICATE_ERROR = By.id("overridelink");
	public By IE_BROWSER_CERTIFICATE_ERROR_MORE_INFORMATION = By
			.linkText("More information");

	public By SERVER_CONNECTION_TRUSTED_HOSTS_OBJECT = By.id("embeddedObj");
	String SERVER_CONNECTION_TRUSTED_HOSTS_ADD_BTN = "trustedhosts_Add_button";
	String SERVER_CONNECTION_TRUSTED_HOSTS_EDIT_BTN_ID = "trustedhosts_Edit_button";
	String SERVER_CONNECTION_TRUSTED_HOSTS_DELETE_BTN_ID = "trustedhosts_Delete_button";
	String SERVER_CONNECTION_TRUSTED_HOSTS_ADD_BTN_ID = "trustedhosts_Add_button";
	String SERVER_CONNECTION_TRUSTED_HOSTS_SAVE_BTN_ID = "trustedhosts_Save_button";
	String SERVER_CONNECTION_TRUSTED_HOSTS_CANCEL_BTN_ID = "trustedhosts_Cancel_button";
	String SERVER_CONNECTION_TRUSTED_HOSTS_HOST_TXT = "td.sorting_1 input";
	String SERVER_CONNECTION_TRUSTED_HOSTS_HOST_TXT_CLASS = "editing";
	String SERVER_CONNECTION_TRUSTED_HOSTS_FIRST_HOST = "table[class='cctable dataTable no-footer table_font']>tbody>tr>td";

	String SERVER_CONNECTION_TRUSTED_HOSTS_EDITING_HOST = "td.sorting_1 input.editing";

	public By SERVER_CONNECTION_CORS_OBJECT = By.id("embeddedObj");
	String SERVER_CONNECTION_CORS_ENABLE_CORS_CHECKBOX_ID = "enable_cors_checkbox";
	String SERVER_CONNECTION_CORS_ALLOW_ANY_ORIGIN_CHECKBOX_ID = "any_origin_checkbox";
	String SERVER_CONNECTION_CORS_DOMAINS_INPUT_TXT_ID = "domains_input";
	// String SERVER_CONNECTION_CORS_DOMAINS_INPUT_TXT_ID =
	// "//td[@id='domains_cell' and not(contains(@style, 'none'))]//input[@id='domains_input']";
	String SERVER_CONNECTION_CORS_DOMAINS_INPUT_TXT_CSS = "tr>td[id='domains_cell']>input";
	String SERVER_CONNECTION_CORS_DOMAINS_INPUT_TXT = "input#domains_input";
	String SERVER_CONNECTION_CORS_SAVE_BTN_ID = "cors_save_button";
	String SERVER_CONNECTION_CORS_STATUS_MESSAGE_SPAN_ID = "statusmessagespan";
	String SERVER_CONNECTION_CORS_CONFIRM_ACTION_SAVE_BTN = "div.ui-dialog-buttonset > button[title='Click to save and apply Cross-Origin Resource Sharing (CORS) configuration.']";

	/*
	 * ======================================================NEW LOCATOR FOR
	 * AADS
	 * BROWSER==============================================================
	 * ============
	 */
	// NTTTRUC

	public By VERIFY_ROLE_INFORMATION_DISPLAY = By
			.xpath("//*[@id='gwt-debug-loginRole']");
	public By VERIFY_USER_INFORMATION_DISPLAY = By
			.xpath("//*[@id='gwt-debug-welcomeLabel']");
	public By VERIFY_NUMBER = By
			.xpath("//*[@id='gwt-debug-adminSessionTimeout']");
	public By VERIFY_WARING = By
			.xpath("//*[@class='gwt-HTML' and text()='You have unsaved changes. Click OK to discard changes and continue, or Cancel to stay on the current page.']");
	public By APP_MANGEMENT_BTN_OK = By
			.xpath("//*[@id='gwt-debug-Confirm Action-OK']");
	public By APP_MANGEMENT_BTN_CANCEL = By
			.xpath("//*[@id='gwt-debug-Confirm Action-Cancel']");
	public By SERVER_CONNECTIONS_TRUSTEDHOST_BTN_ADD = By
			.id("trustedhosts_Add_button");
	public By SERVER_CONNECTIONS_TRUSTEDHOST_EDIT_HOST = By
			.xpath("//input[@class='editing']");
	public By SERVER_CONNETCIONS_TRUSTEDHOST = By
			.xpath("//iframe[contains(@src,'protected/trustedhosts/pages/trustedhosts.html')]");
	public By TEST_WITH_AUTOIT = By.id("photo");
	public By DYNAMIC_CONFIGURATION = By
			.xpath("//iframe[contains(@src,'protected/acwd/pages/picturecfg.html')]");
	public By BTN_SAVE_ALLOW_UPLOAP_PICTURE = By.id("pictures_Save_button");

	public By DYNAMIC_CONFIGURATION_DEFAULT_FRAME = By
			.xpath("//iframe[contains(@src,'protected/acwd/pages/defaults.html')]");
	public By Ser_DEFAULT_FRAME = By
			.xpath("//iframe[contains(@data,'protected/cors/pages/corsservice.html')]");
	public By TestLungTung = By.id("domains_input");

	/**/
	public By VIEW_PUBLISHED_SETTING_PAGE_IFRAME = By
			.xpath("//iframe[contains(@src,'protected/acwd/pages/publishedsettings.html')]");
	public By VIEW_PUBLISHED_SETTING_CATEGORY_DROPBOX = By
			.id("settingsCategorySelector");
	public By VIEW_PUBLISHED_SETTING_VALUE_DROPBOX = By
			.id("settingsSubCategorySelector");
	public By VIEW_PUBLISHED_SETTING_VALUE_DROPBOX_TEST = By
			.xpath("//select[@id='settingsSubCategorySelector']/option[8]");

	public By VIEW_PUBLISHED_SETTING_NUMBER_OF_RESULT_DROPBOX = By
			.xpath("//div[@id='settingstablejson_length']//select");

	public By viewPublishedSettingPageValueCheckboxLocators(String variable) {
		return By.xpath("//td[text()='" + variable
				+ "']/..//*[@type='checkbox']");
	};

	public By viewPublishedSettingPageValueLocator(String variable) {
		return By
				.xpath("//td[text()='" + variable + "']/following-sibling::td");
	};

	public By PUBLISH_WINDOW_GROUP_NEW = By.xpath("//*[@id='ui-id-9']");
	public By PUBLISH_WINDOW_GROUP_NEW_Old_Build = By
			.xpath("//*[@id='ui-id-8']");

	public By EMS_SETTINGS_PAGE_IFRAME = By
			.xpath("//iframe[contains(@src,'protected/acwd/pages/emssettings.html')]");
	// public By EMS_SETTINGS_PAGE_GROUP_ID_J1XX =
	// By.xpath("//*[@id='ems_c1_r0']");
	public By EMS_SETTINGS_PAGE_GROUP_ID_J1XX = By
			.xpath("//td[contains(text(),'J1XX')]/following-sibling::td/input");
	// public By EMS_SETTINGS_PAGE_GROUP_ID_VANTAGE =
	// By.xpath("//*[@id='ems_c1_r1']");
	public By EMS_SETTINGS_PAGE_GROUP_ID_VANTAGE = By
			.xpath("//td[contains(text(),'Vantage')]/following-sibling::td/input");
	// public By EMS_SETTINGS_PAGE_GROUP_ID_96XX =
	// By.xpath("//*[@id='ems_c1_r2']");
	public By EMS_SETTINGS_PAGE_GROUP_ID_96XX = By
			.xpath("//td[contains(text(),'96XX')]/following-sibling::td/input");
	public By EMS_SETTINGS_PAGE_GROUP_ID_BTN_SAVE = By
			.xpath("//*[@id='emsSaveButton']");
	public By EMS_SETTINGS_PAGE_SAVE_CONFIRM_BTN = By
			.xpath("//span[@class='ui-button-text' and contains(text(),'Yes')]");
	
//##################################################################################################################################
//																													DUY NGUYEN
//##################################################################################################################################	
	public By ESG_PORTAL_SIGN_IN_BTN 									=	By.xpath("//span[contains(text(),'Sign in')]");
	public By ESG_PORTAL_USERNAME_TXT									= 	By.xpath("//*[@name='login']");
	public By ESG_PORTAL_PASSWORD_TXT									= 	By.xpath("//*[@name='password']");
	public By ESG_PORTAL_LOGIN_PAGE_SUBMIT_BTN 							=	By.xpath("//button[@type='submit']");
	public By ESG_PORTAL_SETTINGS_PAGE 									=   By.xpath("//*[@class='ng-scope']//a[text() ='Settings']");
	public By ESG_PORTAL_SETTINGS_PAGE_UPLOAD_IMG 						=	By.xpath("//input[@class='upload-avatar-image']");
	public By DELETE_PICTURES_USER_PORTAL 								=	By.xpath("//div[contains(text(),'Delete')]");
	public By SUBMIT_DELETE_PICTURES_USER_PORTAL 						=	By.xpath("//button[contains(text(),'Delete')]");
	public By ESG_PORTAL_SETTINGS_PAGE_CHANGE_IMG 						=	By.xpath("//span[contains(text(),'Upload New Photo')");
	public By ESG_PORATL_SETTINGS_PAGE_UPLOAD_IMG_CLASS 				=	By.xpath("//*[@class='settings-avatar ng-scope ng-hide']");
	public By ESG_PORTAL_SETTINGS_PAGE_DELETE_BTN 						=	By.xpath("//div[contains(text(),'Delete')]");
	public By ESG_PORTAL_SETTINGS_PAGE_CONFIRM_DELETE_BTN 				=	By.xpath("//button[contains(text(),'Delete')]");
	
	
	
	public By ESG_PORTAL_SETTINGS_PAGE_DETAIL_IMG 						=	By.xpath("//*[@class='img-container']/img");
	public By ESG_PORTAL_SETTINGS_PAGE_OK_BTN 							=	By.xpath("//*[@class='white-button' and text()='OK']");
	
	
	
	
	public By ESG_PORTAL_SIGN_OUT_BTN = By.xpath("//*[@class='sign-out toggled']//*[@class='default-button' and text()='Sign out']");
	public By ESG_PORTAL_AVATAR_IMG = By.xpath("//*[@class='avatar']/img");
	public By ESG_PORTAL_AVATAR_NOT_IMG = By.xpath("//*[@class='avatar']");
	
	
	
	public By ESG_PORTAL_ABOUT_PAGE = By
			.xpath("//*[@class='ng-scope']//*[@class='header-link ng-scope' and text() = 'About']");

	
	
	public By ESG_PORTAL_SETTINGS_PAGE_CANCEL_BTN = By
			.xpath("//*[@class='white-button' and text()='Cancel']");
	public By ESG_PORTAL_SETTINGS_PAGE_APPLY_BTN = By
			.xpath("//*[@class='white-button' and text()='Apply']");
	


}
