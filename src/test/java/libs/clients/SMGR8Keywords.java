package libs.clients;

import io.appium.java_client.AppiumDriver;
import libs.common.DriverManagement;
import libs.common.Selenium;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;


public class SMGR8Keywords {
	WebDriver webDriver;
	Selenium selenium = new Selenium();
	SMGR8Locators SMGRWeb = new SMGR8Locators();
	int timeout = 300;
	final static Logger logger = LogManager.getLogger("SMGRWebKeywords");
	DriverManagement driverMgnt = new DriverManagement();
	
	

	public void loginSMGRMainPage(WebDriver webDriver, String user, String password) throws Exception{
		logger.info("LoginSMGRMainPage - starting...\n");
		try {
			Thread.sleep(5000);
			selenium.waitUntilElementClickable(webDriver, SMGRWeb.LOGIN_PAGE_USERNAME_TXT, 2000);
			selenium.inputText(webDriver, SMGRWeb.LOGIN_PAGE_USERNAME_TXT, user);
			selenium.waitUntilElementClickable(webDriver, SMGRWeb.LOGIN_PAGE_PASSWORD_TXT, 200);
			selenium.inputText(webDriver, SMGRWeb.LOGIN_PAGE_PASSWORD_TXT, password);
			Thread.sleep(2000);
			selenium.waitUntilElementClickable(webDriver, SMGRWeb.LOGIN_PAGE_SUBMIT_BTN, 200);
			selenium.clickElement(webDriver, SMGRWeb.LOGIN_PAGE_SUBMIT_BTN);
			Thread.sleep(2000);	
		} catch (Exception exception) { 
			logger.error("LoginSMGRMainPage - Failed with Exception: " + exception + "...\n");
			throw new Exception("LoginSMGRMainPage - Failed - Exception occurs: " + exception);
		}
		logger.info("LoginSMGRMainPage - completed...\n");			
    }
	
	public void logoffSMGRMainPage(WebDriver webDriver) throws Exception{
		logger.info("LogofSMGRMainPage - starting...\n");
		try {
			selenium.switchToDefaultContent(webDriver);
			Thread.sleep(3000);
			selenium.waitUntilElementClickable(webDriver, SMGRWeb.LOGOFF_PAGE, 2000);
			selenium.clickElement(webDriver, SMGRWeb.LOGOFF_PAGE);
			Thread.sleep(2000);	
		} catch (Exception exception) {
			logger.error("LogofSMGRMainPage - Failed with Exception: " + exception + "...\n");
			throw new Exception("LogofSMGRMainPage - Failed - Exception occurs: " + exception);
		}
		logger.info("LogofSMGRMainPage - completed...\n");			
    }
	
	/**
	 * Navigate to User Management 
	 * @param webDriver testing on Web SMGR
	 * @author HoanNguyen
	 * @throws Exception 
	 * 
	 */	
	
	public void navigatetoUserManagement(WebDriver webDriver) throws Exception{
		logger.info("NavigatetoUSerManagement - starting...\n");
		try {
			Thread.sleep(2000);
			//moveToElement
			selenium.clickElement(webDriver, SMGRWeb.USERS_TAB);
			selenium.moveToElement(webDriver, SMGRWeb.USERS_TAB);
			
			Thread.sleep(1000);
			selenium.clickElement(webDriver, SMGRWeb.USERS_TAB);
			selenium.moveToElement(webDriver, SMGRWeb.MAIN_PAGE_USER_MANAGEMENT);
			
			selenium.clickElement(webDriver, SMGRWeb.USER_MANAGEMENT_PAGE_MANAGE_USER);
			Thread.sleep(1000);
			selenium.switchToFrame(webDriver, SMGRWeb.USER_MANAGEMENT_PAGE_IFRAME);
			Thread.sleep(4000);
		
		} catch (Exception exception) {
			logger.error("NavigatetoUSerManagement - Failed with Exception: " + exception + "...\n");
			throw new Exception("NavigatetoUSerManagement - Failed - Exception occurs: " + exception);
		}
		logger.info("NavigatetoUSerManagement - completed...\n");			
    }
	/**
	 * Navigate to Replica and check server status 
	 * @param webDriver testing on Web SMGR
	 * @author HoanNguyen
	 * @throws Exception 
	 * 
	 */	
	public boolean navigatetoReplicationandCheckStatus(WebDriver webDriver) throws Exception{
		logger.info("NavigatetoUSerManagement - starting...\n");
		boolean s=false;
		try {
			
			Thread.sleep(2000);
			selenium.waitUntilElementClickable(webDriver, SMGRWeb.MAIN_PAGE_REPLICATION	, 200);
			selenium.clickElement(webDriver, SMGRWeb.MAIN_PAGE_REPLICATION);
			selenium.switchToFrame(webDriver, SMGRWeb.USER_MANAGEMENT_PAGE_IFRAME);
			Thread.sleep(4000);
			selenium.waitUntilElementClickable(webDriver, SMGRWeb.GROUP_REPLICA, 2000);
			selenium.clickElement(webDriver, SMGRWeb.GROUP_REPLICA);
			//selenium.switchToFrame(webDriver, SMGRWeb.REPLICA_PAGE_IFRAME);
			Thread.sleep(2000);
			
			selenium.waitUntilElementClickable(webDriver, SMGRWeb.SERVER_STATUS, 2000);
			String status=selenium.getText(webDriver, SMGRWeb.SERVER_STATUS);
			if(status.equals("Synchronized")) {s=true;}
			else s=false;
		} catch (Exception exception) { 
			logger.error("NavigatetoUSerManagement - Failed with Exception: " + exception + "...\n");
			throw new Exception("NavigatetoUSerManagement - Failed - Exception occurs: " + exception);
		}
		logger.info("NavigatetoUSerManagement - completed...\n");
		return s;
    }
	/**
	 * Search user by sip phone
	 * @param webDriver testing on Web SMGR
	 * @param sip phone of user
	 * @author ndkhuong
	 * @throws Exception 
	 * 
	 */	
	public void manageUserSearchUserBySipPhone(WebDriver webDriver, String sip) throws Exception{
		logger.info("ManageUserSearchUserBySipPhone - starting...\n");
		try {
			Thread.sleep(2000);
			selenium.waitUntilElementClickable(webDriver, SMGRWeb.USER_MANAGEMENT_PAGE_FILTER_ENABLE_BTN, 1000);
			selenium.clickElement(webDriver, SMGRWeb.USER_MANAGEMENT_PAGE_FILTER_ENABLE_BTN);
			Thread.sleep(2000);
			selenium.waitUntilElementClickable(webDriver, SMGRWeb.userSearchFilteringTxt("SIP Handle"), 1000);
			selenium.inputText(webDriver, SMGRWeb.userSearchFilteringTxt("SIP Handle"), sip);
			selenium.waitUntilElementClickable(webDriver, SMGRWeb.USER_MANAGEMENT_PAGE_APPLY_FILTER_BTN, 200);
			selenium.clickElement(webDriver, SMGRWeb.USER_MANAGEMENT_PAGE_APPLY_FILTER_BTN);
		} catch (Exception exception) { 
			logger.error("ManageUserSearchUserBySipPhone - Failed with Exception: " + exception + "...\n");
			throw new Exception("ManageUserSearchUserBySipPhone - Failed - Exception occurs: " + exception);
		}
		logger.info("ManageUserSearchUserBySipPhone - completed...\n");			
    }
	
	
	
	/**
	 * Action with user ( view, edit, remove,new)
	 * @param webDriver testing on Web SMGR
	 * @param action
	 * @author ndkhuong
	 * @throws Exception 
	 * 
	 */	
	public void manageUserPageActionUser(WebDriver webDriver, String action) throws Exception{
		logger.info("manageUserPageActionUser - starting...\n");
		try {
			Thread.sleep(2000);
			selenium.waitUntilElementClickable(webDriver, SMGRWeb.USER_MANAGEMENT_PAGE_SELECT_USER_BTN, 200);
			if (selenium.isElementSelected(webDriver, SMGRWeb.USER_MANAGEMENT_PAGE_SELECT_USER_BTN)==false)
			{
				selenium.clickElement(webDriver, SMGRWeb.USER_MANAGEMENT_PAGE_SELECT_USER_BTN);
			}
			Thread.sleep(3200);
			selenium.waitUntilElementClickable(webDriver, SMGRWeb.userManagePageActionbuttonLocators(action), 2000);
			selenium.clickElement(webDriver, SMGRWeb.userManagePageActionbuttonLocators(action));
		} catch (Exception exception) { 
			logger.error("manageUserPageActionUser - Failed with Exception: " + exception + "...\n");
			throw new Exception("manageUserPageActionUser - Failed - Exception occurs: " + exception);
		}
		logger.info("manageUserPageActionUser - completed...\n");			
    }
	
	public void manageUserPageActionNew(WebDriver webDriver) throws Exception{
		logger.info("manageUserPageActionNew - starting...\n");
		try {
			Thread.sleep(3000);
			
			selenium.waitUntilElementClickable(webDriver, SMGRWeb.userManagePageActionbuttonLocators("New"), 2000);
			selenium.clickElement(webDriver, SMGRWeb.userManagePageActionbuttonLocators("New"));
			
		} catch (Exception exception) { 
			logger.error("manageUserPageActionNew - Failed with Exception: " + exception + "...\n");
			throw new Exception("manageUserPageActionNew - Failed - Exception occurs: " + exception);
		}
		logger.info("manageUserPageActionNewr - completed...\n");			
    }
	/**
	 * create new smgr user by information in excel file
	 * @param webDriver testing on Web SMGR
	 * @author nkhoan
	 * @throws Exception 
	 */
/*	public void createNewUser (WebDriver webDriver,String siptype,String emailtype) throws Exception{
		logger.info("manageUserPageActionNew - starting...\n");
		try {
			Thread.sleep(3000);
			
			selenium.waitUntilElementClickable(webDriver, SMGRWeb.USER_LASTNAME, 2000);
			selenium.inputText(webDriver, SMGRWeb.USER_LASTNAME,ammData.CREATEUSER_USER_LASTNAME );

			selenium.clickElement(webDriver, SMGRWeb.USER_FIRSTNAME);
			Thread.sleep(2000);
			selenium.inputText(webDriver,SMGRWeb.USER_FIRSTNAME,ammData.CREATEUSER_USER_FIRSTNAME);
			
			
			selenium.clickElement(webDriver,  SMGRWeb.USER_LOGINNAME);
			Thread.sleep(2000);
			selenium.inputText(webDriver,SMGRWeb.USER_LOGINNAME,ammData.CREATEUSER_USER_EMAIL_NAME +"@"+ ammData.CREATEUSER_USER_EMAIL_DOMAIN);
			
			
			selenium.clickElement(webDriver, SMGRWeb.USER_PASSWORD);
			Thread.sleep(1000);
			selenium.inputText(webDriver,SMGRWeb.USER_PASSWORD,ammData.CREATEUSER_USER_PWD);
			
			selenium.clickElement(webDriver, SMGRWeb.USER_REPASSWORD);
			
			selenium.inputText(webDriver,SMGRWeb.USER_REPASSWORD,ammData.CREATEUSER_USER_PWD);
			
			selenium.clickElement(webDriver, SMGRWeb.USER_INFORMATION_COMMUNICATION_PROFILE_TAB);
			Thread.sleep(1000);
			selenium.clickElement(webDriver, SMGRWeb.PROFILE_PASSWORD);
			Thread.sleep(1000);
			selenium.inputText(webDriver,SMGRWeb.PROFILE_PASSWORD,ammData.CREATEUSER_PROFILE_PWD);
			selenium.clickElement(webDriver, SMGRWeb.PROFILE_REPASSWORD);
			Thread.sleep(1000);
			selenium.inputText(webDriver,SMGRWeb.PROFILE_REPASSWORD,ammData.CREATEUSER_PROFILE_PWD);
			selenium.clickElement(webDriver, SMGRWeb.CREATE_PROFILE_PWD_BTN);
			Thread.sleep(5000);
			
			selenium.clickElement(webDriver, SMGRWeb.USER_ADDRESS_BTN);
			Thread.sleep(4000);
			selenium.waitUntilElementClickable(webDriver, SMGRWeb.USER_CA_TYPE_LIST, 2000);
		
			selenium.dropDownListBox(webDriver, SMGRWeb.USER_CA_TYPE_LIST,siptype );
			Thread.sleep(2000);
			
			selenium.clickElement(webDriver,SMGRWeb.USER_SIP_NUMBER);
			selenium.inputText(webDriver,SMGRWeb.USER_SIP_NUMBER,ammData.CREATEUSER_HANDLE_NUMBER);
			
			selenium.dropDownListBox(webDriver, SMGRWeb.USER_CA_DOMAIN_LIST,"aam1.com");
			Thread.sleep(2000);
			selenium.waitUntilElementClickable(webDriver, SMGRWeb.USER_CA_ADD_BTN, 2000);
			selenium.clickElement(webDriver, SMGRWeb.USER_CA_ADD_BTN);
			Thread.sleep(3000);
			
			
			selenium.clickElement(webDriver, SMGRWeb.USER_ADDRESS_BTN);
			Thread.sleep(3000);
		
			selenium.dropDownListBox(webDriver, SMGRWeb.USER_CA_TYPE_LIST,emailtype );
			Thread.sleep(2000);
			selenium.clickElement(webDriver,SMGRWeb.USER_SIP_NUMBER);
			selenium.inputText(webDriver,SMGRWeb.USER_SIP_NUMBER,ammData.CREATEUSER_USER_EMAIL_NAME);
		
			selenium.clickElement(webDriver,SMGRWeb.USER_CA_DOMAIN_NAME);
			selenium.inputText(webDriver,SMGRWeb.USER_CA_DOMAIN_NAME,ammData.CREATEUSER_USER_EMAIL_DOMAIN);
			Thread.sleep(300);
			selenium.clickElement(webDriver, SMGRWeb.USER_CA_ADD_BTN);
			Thread.sleep(3000);
			
			selenium.clickElement(webDriver,SMGRWeb.USER_SM_BTN);
			Thread.sleep(2000);
		
			selenium.inputText(webDriver, SMGRWeb.USER_SM_VALUE,ammData.CREATEUSER_USER_SM);Thread.sleep(4000);
			selenium.dropDownListBox(webDriver, SMGRWeb.USER_MAX_DEVICE_LIST,ammData.CREATEUSER_MAX_DEVICE);
			selenium.dropDownListBox(webDriver, SMGRWeb.USER_HOME_LOCATION,ammData.CREATEUSER_LOCATION);
			Thread.sleep(2000);
			selenium.clickElement(webDriver,SMGRWeb.USER_CM_BTN);
			Thread.sleep(1000);
			selenium.dropDownListBox(webDriver, SMGRWeb.USER_CM_VALUE,ammData.CREATEUSER_USER_CM);
			Thread.sleep(2000);
			selenium.inputText(webDriver, SMGRWeb.USER_EXTENSION,"72306");
			selenium.dropDownListBox(webDriver, SMGRWeb.USER_TEMPLATES,ammData.CREATEUSER_TEMPLATE);
			Thread.sleep(1000);
			selenium.clickElement(webDriver,SMGRWeb.USER_SUBMIT_BTN);
		} catch (Exception exception) { driverMgnt.setFailedWinClientDriver(webDriver);
			logger.error("manageUserPageActionNew - Failed with Exception: " + exception + "...\n");
			throw new Exception("manageUserPageActionNew - Failed - Exception occurs: " + exception);
		}
		logger.info("manageUserPageActionNewr - completed...\n");			
    }
	*/
	/**
	 * Get sip phone information
	 * @param webDriver testing on Web SMGR
	 * @author ndkhuong
	 * @throws Exception 
	 * 
	 */	
	public String[] manageUserGetSipPhoneInformation(WebDriver webDriver) throws Exception{
		logger.info("ManageUserSearchUserBySipPhone - starting...\n");
		String s[] = new String[11];
		try {
			Thread.sleep(3000);
			s[0]= selenium.getAttribute(webDriver, SMGRWeb.VIEW_USER_PAGE_SM_PRIMARY_TXT, "value");
			s[1]= selenium.getAttribute(webDriver, SMGRWeb.VIEW_USER_PAGE_SM_PRIMARY_TXT, "value");
			s[2]= selenium.getAttribute(webDriver, SMGRWeb.VIEW_USER_PAGE_SIP_PHONE_NUMBER_TXT, "value");
		} catch (Exception exception) { 
			logger.error("ManageUserSearchUserBySipPhone - Failed with Exception: " + exception + "...\n");
			throw new Exception("ManageUserSearchUserBySipPhone - Failed - Exception occurs: " + exception);
		}
		logger.info("ManageUserSearchUserBySipPhone - completed...\n");
		return s;			
    }
	
	/**
	 * Edit Presence Profile
	 * @param webDriver testing on Web SMGR
	 * @param checkbox (true/false)
	 * @param IMgateway
	 * @author ndkhuong
	 * @throws Exception 
	 * 
	 */	
	public String[] manageUserEditPresenceProfile(WebDriver webDriver, boolean checkbox, String IMgateway) throws Exception{
		logger.info("manageUserEditPresenceProfile - starting...\n");
		String s[] = new String[11];
		try {
			Thread.sleep(7000);
			selenium.scrollToElement(webDriver, SMGRWeb.EDIT_USER_PRESENCE_PROFILE_CHECKBOX);
			if(checkbox==true)
			{
				if (selenium.isElementSelected(webDriver, SMGRWeb.EDIT_USER_PRESENCE_PROFILE_CHECKBOX) == false)
				{
					selenium.clickElement(webDriver, SMGRWeb.EDIT_USER_PRESENCE_PROFILE_CHECKBOX);
				
				}
				Thread.sleep(2000);
				selenium.dropDownListBoxByValue(webDriver, SMGRWeb.EDIT_USER_PRESENCE_SYSTEM_DROPLIST, "0");
				Thread.sleep(2000);
				selenium.dropDownListBox(webDriver, SMGRWeb.EDIT_USER_IM_GATEWAY_DROPLIST, IMgateway);
				Thread.sleep(2000);
			}
			else
			{
				if (selenium.isElementSelected(webDriver, SMGRWeb.EDIT_USER_PRESENCE_PROFILE_CHECKBOX) == true)
				{
					selenium.clickElement(webDriver, SMGRWeb.EDIT_USER_PRESENCE_PROFILE_CHECKBOX);
				}	
			}
			Thread.sleep(2000);
			selenium.scrollToElement(webDriver, SMGRWeb.EDIT_USER_PAGE_COMMIT_BTN);
			selenium.clickElement(webDriver, SMGRWeb.EDIT_USER_PAGE_COMMIT_BTN);
			Thread.sleep(7000);
			selenium.clickElement(webDriver, SMGRWeb.USER_MANAGEMENT_PAGE_STATUS_BTN);
			Thread.sleep(5000);
			selenium.elementShouldExisted(webDriver, SMGRWeb.USER_MANAGEMENT_PAGE_STATUS_SUCESSFULLY_TXT);
		} catch (Exception exception) { 
			logger.error("manageUserEditPresenceProfile - Failed with Exception: " + exception + "...\n");
			throw new Exception("manageUserEditPresenceProfile - Failed - Exception occurs: " + exception);
		}
		logger.info("manageUserEditPresenceProfile - completed...\n");
		return s;			
    }
	
	/**
	 * Search contact for removing
	 * @param webDriver testing on Web SMGR
	 * @param user
	 * @author ndkhuong
	 * @throws Exception 
	 * 
	 */	
	public void removeContactSearchUserByLastName(WebDriver webDriver, String user) throws Exception{
		logger.info("ManageUserSearchUserBySipPhone - starting...\n");
		try {
			Thread.sleep(15000);
			selenium.waitUntilElementClickable(webDriver, SMGRWeb.USER_MANAGEMENT_PAGE_FILTER_ENABLE_BTN, 8000);
			selenium.clickElement(webDriver, SMGRWeb.USER_MANAGEMENT_PAGE_FILTER_ENABLE_BTN);
			Thread.sleep(10000);
			selenium.waitUntilElementClickable(webDriver, SMGRWeb.userSearchFilteringTxt("Last Name"), 8000);
			selenium.inputText(webDriver, SMGRWeb.userSearchFilteringTxt("Last Name"), user);
			selenium.waitUntilElementClickable(webDriver, SMGRWeb.USER_MANAGEMENT_PAGE_APPLY_FILTER_BTN, 8000);
			selenium.clickElement(webDriver, SMGRWeb.USER_MANAGEMENT_PAGE_APPLY_FILTER_BTN);
		} catch (Exception exception) { 
			logger.error("ManageUserSearchUserBySipPhone - Failed with Exception: " + exception + "...\n");
			throw new Exception("ManageUserSearchUserBySipPhone - Failed - Exception occurs: " + exception);
		}
		logger.info("ManageUserSearchUserBySipPhone - completed...\n");			
    }
	
	/**
	 * Search contact for adding
	 * @param webDriver testing on Web SMGR
	 * @param user
	 * @author ndkhuong
	 * @throws Exception 
	 * 
	 */	
	public void addContactSearchUserByLastName(WebDriver webDriver, String user) throws Exception{
		logger.info("addContactSearchUserByLastName - starting...\n");
		try {
			Thread.sleep(2000);
			selenium.waitUntilElementClickable(webDriver, SMGRWeb.USER_MANAGEMENT_PAGE_FILTER_ENABLE_BTN, 200);
			selenium.clickElement(webDriver, SMGRWeb.USER_MANAGEMENT_PAGE_FILTER_ENABLE_BTN);
			Thread.sleep(2000);
			selenium.waitUntilElementClickable(webDriver, SMGRWeb.userSearchFilteringTxt("Last Name"), 1000);
			selenium.inputText(webDriver, SMGRWeb.userSearchFilteringTxt("Last Name"), user);
			selenium.waitUntilElementClickable(webDriver, SMGRWeb.USER_MANAGEMENT_PAGE_APPLY_FILTER_BTN, 200);
			selenium.clickElement(webDriver, SMGRWeb.USER_MANAGEMENT_PAGE_APPLY_FILTER_BTN);
		} catch (Exception exception) { 
			logger.error("ManageUserSearchUserBySipPhone - Failed with Exception: " + exception + "...\n");
			throw new Exception("ManageUserSearchUserBySipPhone - Failed - Exception occurs: " + exception);
		}
		logger.info("ManageUserSearchUserBySipPhone - completed...\n");			
    }
	/**
	 * Add new contact 
	 * @param webDriver testing on Web SMGR
	 * @param user
	 * @author ndkhuong
	 * @throws Exception 
	 * @Edit by HuyD
	 */	
	public void editUserAddNewContact(WebDriver webDriver, String user) throws Exception{
		logger.info("editUserAddNewContact - starting...\n");
		try {
			Thread.sleep(8000);
			selenium.waitUntilElementVisible(webDriver, SMGRWeb.USER_INFORMATION_CONTACTS_TAB);
			WebElement tab = webDriver.findElement(SMGRWeb.USER_INFORMATION_CONTACTS_TAB); 
			new Actions(webDriver).moveToElement(tab).click().click().perform();
			selenium.waitUntilElementClickable(webDriver, SMGRWeb.USER_INFORMATION_CONTACTS_TAB_ADD_BTN, 200);
			selenium.clickElement(webDriver, SMGRWeb.USER_INFORMATION_CONTACTS_TAB_ADD_BTN);
			Thread.sleep(5000);
			addContactSearchUserByLastName(webDriver, user);
			Thread.sleep(5000);
			selenium.waitUntilElementClickable(webDriver, SMGRWeb.USER_INFORMATION_CONTACTS_TAB_ADD_USER_CONTACT_USER_CHECKBOX, 2000);
			selenium.clickElement(webDriver, SMGRWeb.USER_INFORMATION_CONTACTS_TAB_ADD_USER_CONTACT_USER_CHECKBOX);
			Thread.sleep(5000);
			selenium.waitUntilElementClickable(webDriver, SMGRWeb.USER_INFORMATION_CONTACTS_TAB_ADD_SELECT_BTN, 200);
			selenium.clickElement(webDriver, SMGRWeb.USER_INFORMATION_CONTACTS_TAB_ADD_SELECT_BTN);
			Thread.sleep(15000);
			selenium.scrollToElement(webDriver, SMGRWeb.EDIT_USER_PAGE_COMMIT_BTN);
			selenium.waitUntilElementClickable(webDriver, SMGRWeb.EDIT_USER_PAGE_COMMIT_BTN, 200);
			selenium.clickElement(webDriver, SMGRWeb.EDIT_USER_PAGE_COMMIT_BTN);
			Thread.sleep(10000);
			selenium.elementShouldExisted(webDriver, SMGRWeb.USER_MANAGEMENT_PAGE_STATUS_SUCESSFULLY_TXT);
			
		} catch (Exception exception) { 
			logger.error("editUserAddNewContact - Failed with Exception: " + exception + "...\n");
			throw new Exception("editUserAddNewContact - Failed - Exception occurs: " + exception);
		}
		logger.info("editUserAddNewContact - completed...\n");			
    }
	
	/**
	 * Editer on Remove contact
	 * @param webDriver testing on Web SMGR
	 * @param user
	 * @author ndkhuong
	 * @throws Exception 
	 * 
	 */	
	public void editUserRemoveContact(WebDriver webDriver, String user) throws Exception{
		logger.info("manageUserPageActionUser - starting...\n");
		try {
			Thread.sleep(8000);
			selenium.waitUntilElementClickable(webDriver, SMGRWeb.USER_INFORMATION_CONTACTS_TAB, 200);
			selenium.clickElement(webDriver, SMGRWeb.USER_INFORMATION_CONTACTS_TAB);
			Thread.sleep(8000);
			removeContactSearchUserByLastName(webDriver, user);
			Thread.sleep(8000);
			selenium.waitUntilElementClickable(webDriver, SMGRWeb.userInformationContactsTabRemoveContactCheckboxLocator(user), 200);
			selenium.clickElement(webDriver, SMGRWeb.userInformationContactsTabRemoveContactCheckboxLocator(user));
			Thread.sleep(8000);
			selenium.waitUntilElementClickable(webDriver, SMGRWeb.USER_INFORMATION_CONTACTS_TAB_REMOVE_BTN, 2000);
			selenium.clickElement(webDriver, SMGRWeb.USER_INFORMATION_CONTACTS_TAB_REMOVE_BTN);
			selenium.clickElement(webDriver, SMGRWeb.USER_INFORMATION_CONTACTS_TAB_REMOVE_BTN);
			Thread.sleep(10000);
			selenium.waitUntilElementClickable(webDriver, SMGRWeb.EDIT_USER_PAGE_COMMIT_BTN, 200);
			selenium.clickElement(webDriver, SMGRWeb.EDIT_USER_PAGE_COMMIT_BTN);
			Thread.sleep(10000);
			selenium.elementShouldExisted(webDriver, SMGRWeb.USER_MANAGEMENT_PAGE_STATUS_SUCESSFULLY_TXT);
			
		} catch (Exception exception) { 
			logger.error("manageUserPageActionUser - Failed with Exception: " + exception + "...\n");
			throw new Exception("manageUserPageActionUser - Failed - Exception occurs: " + exception);
		}
		logger.info("manageUserPageActionUser - completed...\n");			
    }
	
	/**
	 * Verify Contact is existed in contact list
	 * @param webDriver testing on Web SMGR
	 * @param user
	 * @return true/false
	 * @author ndkhuong
	 * @throws Exception 
	 * 
	 */	
	public boolean verifyNameContactisExsitedInContactList(WebDriver webDriver, String user) throws Exception{
		logger.info("manageUserPageActionUser - starting...\n");
		boolean s= false;
		try {
			Thread.sleep(10000);
			selenium.waitUntilElementClickable(webDriver, SMGRWeb.USER_INFORMATION_CONTACTS_TAB, 8000);
			selenium.clickElement(webDriver, SMGRWeb.USER_INFORMATION_CONTACTS_TAB);
			Thread.sleep(5000);
			removeContactSearchUserByLastName(webDriver, user);
			Thread.sleep(5000);
			if (selenium.isElementExisted(webDriver, SMGRWeb.userInformationContactsTabRemoveContactCheckboxLocator(user)))
			{
				s = true;
			}
			else s= false;
			selenium.waitUntilElementClickable(webDriver, SMGRWeb.EDIT_USER_PAGE_COMMIT_BTN, 8000);
			selenium.clickElement(webDriver, SMGRWeb.EDIT_USER_PAGE_COMMIT_BTN);
			Thread.sleep(13000);
			//selenium.elementShouldExisted(webDriver, SMGRWeb.USER_MANAGEMENT_PAGE_STATUS_SUCESSFULLY_TXT);
			
		} catch (Exception exception) { 
			logger.error("manageUserPageActionUser - Failed with Exception: " + exception + "...\n");
			throw new Exception("manageUserPageActionUser - Failed - Exception occurs: " + exception);
		}
		logger.info("manageUserPageActionUser - completed...\n");	
		return s;
    }
	
	/**
	 * @author HuyD
	 * To verify contact isn't existed
	 * 
	 * 
	 * */
	
	public boolean verifyNameContactisNotExsitedInContactList(WebDriver webDriver, String user) throws Exception{
		logger.info("manageUserPageActionUser - starting...\n");
		boolean s= false;
		try {
			Thread.sleep(5000);
			//selenium.waitUntilElementClickable(webDriver, SMGRWeb.USER_INFORMATION_CONTACTS_TAB, 200);
			selenium.clickElement(webDriver, SMGRWeb.USER_INFORMATION_CONTACTS_TAB);
			Thread.sleep(3000);
			removeContactSearchUserByLastName(webDriver, user);
			Thread.sleep(3000);
			if (!selenium.isElementExisted(webDriver, SMGRWeb.userInformationContactsTabRemoveContactCheckboxLocator(user)))
			{
				s = true;
			}
			else s= false;
			selenium.waitUntilElementClickable(webDriver, SMGRWeb.EDIT_USER_PAGE_COMMIT_BTN, 200);
			selenium.clickElement(webDriver, SMGRWeb.EDIT_USER_PAGE_COMMIT_BTN);
			Thread.sleep(3000);
			selenium.elementShouldExisted(webDriver, SMGRWeb.USER_MANAGEMENT_PAGE_STATUS_SUCESSFULLY_TXT);
			
		} catch (Exception exception) { 
			logger.error("manageUserPageActionUser - Failed with Exception: " + exception + "...\n");
			throw new Exception("manageUserPageActionUser - Failed - Exception occurs: " + exception);
		}
		logger.info("manageUserPageActionUser - completed...\n");	
		return s;
    }
	
	public void navigatetoContactTabAndSearchContacts(WebDriver webDriver, String searchString) throws Exception{
		logger.info("navigatetoContactTabAndSearchContacts - starting...\n");
		boolean s= false;
		try {
			Thread.sleep(10000);
			selenium.waitUntilElementClickable(webDriver, SMGRWeb.USER_INFORMATION_CONTACTS_TAB, 8000);
			selenium.clickElement(webDriver, SMGRWeb.USER_INFORMATION_CONTACTS_TAB);
			Thread.sleep(5000);
			removeContactSearchUserByLastName(webDriver, searchString);
		} catch (Exception exception) { 
			logger.error("navigatetoContactTabAndSearchContacts - Failed with Exception: " + exception + "...\n");
			throw new Exception("navigatetoContactTabAndSearchContacts - Failed - Exception occurs: " + exception);
		}
		logger.info("navigatetoContactTabAndSearchContacts - completed...\n");	
		
	}
	
	
	
	public boolean verifyIfContactisExsitedInContactList(WebDriver webDriver, String user) throws Exception{
		logger.info("verifyIfContactisExsitedInContactList - starting...\n");
		boolean s= false;
		try {
			if (selenium.isElementExisted(webDriver, SMGRWeb.userInformationContactsTabRemoveContactCheckboxLocator(user)))
			{
				s = true;
			}
			else s= false;
			 
		} catch (Exception exception) { 
			logger.error("verifyIfContactisExsitedInContactList - Failed with Exception: " + exception + "...\n");
			throw new Exception("verifyIfContactisExsitedInContactList - Failed - Exception occurs: " + exception);
		}
		logger.info("verifyIfContactisExsitedInContactList - completed...\n");	
		return s;
    }
	
	
	/**
	 * @author TrucNguyen
	 * Hard detele SMGR user
	 * 
	 * 
	 * */
	
	public void hardDeleteSMGRUser (WebDriver webDriver, String user) throws Exception
	{
		logger.info("hardDeleteSMGRUser - starting...\n");
		try {
			Thread.sleep(2000);
			selenium.waitUntilElementClickable(webDriver, SMGRWeb.USER_DELETE_CONFIRMATION, 2000);
			selenium.clickElement(webDriver, SMGRWeb.USER_DELETE_CONFIRMATION);
			Thread.sleep(2000);
			selenium.waitUntilElementClickable(webDriver, SMGRWeb.MORE_ACTION, 2000);
			selenium.clickElement(webDriver, SMGRWeb.MORE_ACTION);
			Thread.sleep(10000);
			WebElement input = webDriver.findElement(SMGRWeb.SHOW_DELETED_USERS);
			new Actions(webDriver).moveToElement(input).click().perform();
			Thread.sleep(2000);
			removeContactSearchUserByLastName(webDriver, user);
			manageUserPageActionUser(webDriver,"Delete");
			Thread.sleep(2000);
			selenium.waitUntilElementClickable(webDriver, SMGRWeb.USER_DELETE_CONFIRMATION, 2000);
			selenium.clickElement(webDriver, SMGRWeb.USER_DELETE_CONFIRMATION);
			
		} catch (Exception e) {
			logger.error("verifyIfContactisExsitedInContactList - Failed with Exception: " + e + "...\n");
			throw new Exception("verifyIfContactisExsitedInContactList - Failed - Exception occurs: " + e);
		}
		logger.info("verifyIfContactisExsitedInContactList - completed...\n");	
	}
	
}
