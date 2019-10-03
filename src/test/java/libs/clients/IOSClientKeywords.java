package libs.clients;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.ios.IOSDriver;
import libs.common.DriverManagement;
import libs.common.Selenium;;

public class IOSClientKeywords {
	
	final static Logger logger = LogManager.getLogger("iosClient");
	Selenium selenium = new Selenium();
	IOSClientLocators iOSClient = new IOSClientLocators();

	IOSDriver iOSClientDriver;
	int timeout = 10;
	DriverManagement driverMgnt = new DriverManagement();
	
	public void resetApp(IOSDriver iOSClientDriver) throws Exception {
		int i=0;

		logger.info("resetApp- start");
		while (true) {
			if(i==3) break;

		try {
			if (selenium.isElementExisted(iOSClientDriver, iOSClient.LICENSE_AGREEMENT_ACCEPT_BTN)) {
				selenium.clickElement(iOSClientDriver, iOSClient.LICENSE_AGREEMENT_ACCEPT_BTN);		
			}
			Thread.sleep(2000);
			if (!selenium.isElementExisted(iOSClientDriver, iOSClient.AUTOLOGIN_SCREEN_CONFIGURE_MY_ACCOUNT_BTN)) {
				if(!selenium.isElementExisted(iOSClientDriver, iOSClient.FIRST_SCREEN_EBAR_BTN)){
					if(selenium.isElementExisted(iOSClientDriver, iOSClient.SETTING_SCREEN_DONE_BTN)){
					selenium.clickElement(iOSClientDriver, iOSClient.SETTING_SCREEN_DONE_BTN);
					Thread.sleep(4000);}
					selenium.clickElement(iOSClientDriver, iOSClient.MAIN_SCREEN_SERVICE_SETTING_BUTTON);
				} else {
					Thread.sleep(2000);
					selenium.clickElement(iOSClientDriver, iOSClient.FIRST_SCREEN_EBAR_BTN);
					Thread.sleep(2000);
					selenium.clickElement(iOSClientDriver, iOSClient.FIRST_SCREEN_EBAR_SETTING_BTN);
				}
				Thread.sleep(3000);
				selenium.clickElement(iOSClientDriver, iOSClient.SETTING_SCREEN_SUPPORT_TAB_BTN);
				selenium.clickElement(iOSClientDriver, iOSClient.SETTING_SCREEN_SUPPORT_TAB_RESET_APP_BTN);
				if(selenium.isElementExisted(iOSClientDriver, iOSClient.SETTING_SCREEN_SUPPORT_TAB_RESET_APP_OK_BTN)) {
				selenium.clickElement(iOSClientDriver, iOSClient.SETTING_SCREEN_SUPPORT_TAB_RESET_APP_OK_BTN);
				break;}
			}

		} catch (Exception e) {
			logger.error("resetApp - Failed with Exception: " + e + "...\n");
//			throw new Exception("resetApp - Failed - Exception occurs: " + e);
			i++;
		}}

	}
	
	
	public boolean autoConfigLogin(IOSDriver iOSClientDriver, String url, String user, String pwd) throws Exception {
		logger.info("autoConfigLogin - starting...\n");
		boolean n=false;
		try {
			Thread.sleep(2000);
			if (selenium.isElementExisted(iOSClientDriver, iOSClient.LICENSE_AGREEMENT_ACCEPT_BTN)) {
				selenium.clickElement(iOSClientDriver, iOSClient.LICENSE_AGREEMENT_ACCEPT_BTN);
			}
			selenium.waitUntilElementVisible(iOSClientDriver,iOSClient.AUTOLOGIN_SCREEN_CONFIGURE_MY_ACCOUNT_BTN);
			if(selenium.isElementExisted(iOSClientDriver, iOSClient.AUTOLOGIN_SCREEN_CONFIGURE_MY_ACCOUNT_BTN)) {
				selenium.clickElement(iOSClientDriver, iOSClient.AUTOLOGIN_SCREEN_CONFIGURE_MY_ACCOUNT_BTN);
				Thread.sleep(2000);} 
			else {
				if (selenium.isElementExisted(iOSClientDriver, iOSClient.MEETING_SIGN_IN_BTN)) {
				selenium.clickElement(iOSClientDriver, iOSClient.MEETING_SIGN_IN_BTN);}
				Thread.sleep(2000);
			}
			
			if (selenium.isElementExisted(iOSClientDriver, iOSClient.AUTOLOGIN_SCREEN_CONFIGURE_MY_ACCOUNT_BTN)) {
				selenium.clickElement(iOSClientDriver, iOSClient.AUTOLOGIN_SCREEN_CONFIGURE_MY_ACCOUNT_BTN);}
			
			Thread.sleep(2000);
			selenium.clickElement(iOSClientDriver, iOSClient.MAIN_SCREEN_SERVICE_SETTING_BUTTON);
			Thread.sleep(2000);
			selenium.clickElement(iOSClientDriver, iOSClient.AUTOLOGIN_SCREEN_SETTING_USE_WEB_ADDRESS_BTN);
			Thread.sleep(3000);
			Thread.sleep(2000);
			selenium.inputText(iOSClientDriver, iOSClient.AUTOLOGIN_SCREEN_WEB_ADDRESS_TXT, url);
			Thread.sleep(1000);
			selenium.clickElement(iOSClientDriver, iOSClient.AUTOLOGIN_SCREEN_NEXT_BTN);
			Thread.sleep(5000);
			selenium.inputText(iOSClientDriver, iOSClient.AUTOLOGIN_SCREEN_USER_TXT, user);
			Thread.sleep(2000);
			selenium.inputText(iOSClientDriver, iOSClient.AUTOLOGIN_SCREEN_PWD_TXT, pwd);
			Thread.sleep(1000);
			selenium.clickElement(iOSClientDriver, iOSClient.AUTOLOGIN_SCREEN_NEXT_BTN);
			
			if(selenium.isElementExisted(iOSClientDriver, iOSClient.AUTOLOGIN_SCREEN_USER_TXT))
			{
				logger.info("autoConfigLogin - Need to login Multimedia Messaging account starting...\n");
				selenium.inputText(iOSClientDriver, iOSClient.AUTOLOGIN_SCREEN_USER_TXT, user);
				Thread.sleep(2000);
				selenium.inputText(iOSClientDriver, iOSClient.AUTOLOGIN_SCREEN_PWD_TXT, pwd);
				Thread.sleep(1000);
				if(selenium.isElementExisted(iOSClientDriver, iOSClient.AUTOLOGIN_SCREEN_NEXT_BTN)) {
				selenium.clickElement(iOSClientDriver, iOSClient.AUTOLOGIN_SCREEN_NEXT_BTN);}
				else selenium.clickElement(iOSClientDriver, iOSClient.LOGIN_BTN_SIGNIN);
				logger.info("autoConfigLogin - Need to login Multimedia Messaging account completed...\n");
				
			}
			
			
			Thread.sleep(3000);
			if (selenium.isElementExisted(iOSClientDriver, iOSClient.AUTOLOGIN_SCREEN_OK_BTN)) {
				selenium.clickElement(iOSClientDriver, iOSClient.AUTOLOGIN_SCREEN_OK_BTN);
			}
			Thread.sleep(3000);
			if (selenium.isElementExisted(iOSClientDriver, iOSClient.AUTOLOGIN_SCREEN_SKIP_BTN)) {
				selenium.clickElement(iOSClientDriver, iOSClient.AUTOLOGIN_SCREEN_SKIP_BTN);
				n=true;	
			}
			Thread.sleep(2000);

		} catch (Exception exception) {
			logger.error("autoConfigLogin - Failed with Exception: " + exception + "...\n");
			Thread.sleep(2000);
			resetApp(iOSClientDriver);
			Thread.sleep(5000);
			iOSClientDriver = driverMgnt.createIOSClientDriver();
		}
		logger.info("autoConfigLogin - completed...\n");
		return n;
	}
	
	
	public boolean addContactBySearch(IOSDriver iOSClientDriver, String user) throws Exception {
		String message = String.format("*** addContactBySearch - Add Contact by Search ");
		logger.warn(message);
		try {
			selenium.inputText(iOSClientDriver, iOSClient.CONTACT_SCREEN_SEARCH_TXT, user);
			selenium.clickElement(iOSClientDriver, iOSClient.SEARCH_RESULT_USER_BTN(user));
			selenium.clickElement(iOSClientDriver, iOSClient.SEARCH_RESULT_USER_BTN(user));
			selenium.clickElement(iOSClientDriver, iOSClient.ADD_CONTACT_BTN);
			selenium.clickElement(iOSClientDriver, iOSClient.CONTACT_SEARCH_CANCEL_BTN);
			navigateToContactScreen(iOSClientDriver);
			if(selenium.isElementExisted(iOSClientDriver, iOSClient.CONTACT_TAB_USER_NAME(user))) {
				return true;
			} else return false;
		} catch (Exception e) {
			Escape(iOSClientDriver);
			return false;
		}
		
	}
	
	public void Escape(IOSDriver iOSClientDriver) {
		try {
			if(selenium.isElementExisted(iOSClientDriver, iOSClient.CONTACT_DETAIL_DISMISS)) {
				selenium.clickElement(iOSClientDriver, iOSClient.CONTACT_DETAIL_DISMISS);}
			Thread.sleep(2000);
			if(selenium.isElementExisted(iOSClientDriver, iOSClient.ADD_CONTACT_SCREEN_DONE_BTN)) {
				selenium.clickElement(iOSClientDriver, iOSClient.ADD_CONTACT_SCREEN_DONE_BTN);}
			Thread.sleep(2000);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	

	public boolean removeContact(IOSDriver iOSClientDriver, String user) throws Exception {
		String message = String.format("*** removeContact - Add Contact by Search ");
		logger.warn(message);
		boolean s=false;
		try {
/*			selenium.clickElement(iOSClientDriver, iOSClient.FIRST_SCREEN_EBAR_BTN);
			selenium.clickElement(iOSClientDriver, iOSClient.FIRST_SCREEN_NAVIGATE_CONTACTS_TAB_BTN);*/
			selenium.clickElement(iOSClientDriver, iOSClient.SEARCH_RESULT_USER_BTN(user));
			selenium.clickElement(iOSClientDriver, iOSClient.SEARCH_RESULT_USER_BTN(user));
			selenium.clickElement(iOSClientDriver, iOSClient.CONTACT_DETAIL_REMOVE_CONTACT);
			selenium.clickElement(iOSClientDriver, iOSClient.CONTACT_DETAIL_REMOVE_CONTACT_CONFIRM);
			navigateToContactScreen(iOSClientDriver);
			if(!selenium.isElementExisted(iOSClientDriver, iOSClient.CONTACT_TAB_USER_NAME(user))) {
				return true;
			} else return false;
		} catch (Exception e) {
			message = String.format("*** removeContact *** FAILED - %s.", e.toString());
			logger.error(message);

//			throw new AssertionError(message);
		}
		return s;
	}
	
	public boolean addPrivateContact(AppiumDriver iOSClientDriver, String firstname, String lastname, String number,
			String address) throws Exception {
		String message = String.format("*** addLocalContact - Add Contact ");
		logger.warn(message);
		boolean s = false;
		try {
			selenium.waitUntilElementClickable(iOSClientDriver, iOSClient.FIRST_SCREEN_EBAR_BTN, timeout);
			selenium.clickElement(iOSClientDriver, iOSClient.FIRST_SCREEN_EBAR_BTN);
			Thread.sleep(3000);
			selenium.clickElement(iOSClientDriver, iOSClient.FIRST_SCREEN_NAVIGATE_CONTACTS_TAB_BTN);
			Thread.sleep(2000);
			selenium.waitUntilElementClickable(iOSClientDriver, iOSClient.CONTACT_SCREEN_ADD_BTN, timeout);
			selenium.clickElement(iOSClientDriver, iOSClient.CONTACT_SCREEN_ADD_BTN);
			Thread.sleep(3000);
			selenium.waitUntilElementClickable(iOSClientDriver, iOSClient.CONTACT_SCREEN_NEW_CONTACT_BTN, timeout);
			selenium.clickElement(iOSClientDriver, iOSClient.CONTACT_SCREEN_NEW_CONTACT_BTN);
			Thread.sleep(3000);
			selenium.waitUntilElementClickable(iOSClientDriver, iOSClient.ADD_CONTACT_SCREEN_FIRST_NAME_TXT, timeout);
			selenium.inputText(iOSClientDriver, iOSClient.ADD_CONTACT_SCREEN_FIRST_NAME_TXT, firstname);
			selenium.inputText(iOSClientDriver, iOSClient.ADD_CONTACT_SCREEN_LAST_NAME_TXT, lastname);
			selenium.inputText(iOSClientDriver, iOSClient.ADD_CONTACT_SCREEN_PHONE_TXT, number);
			selenium.inputText(iOSClientDriver, iOSClient.ADD_CONTACT_SCREEN_ADDRESS_TXT, address);
			selenium.waitUntilElementClickable(iOSClientDriver, iOSClient.ADD_CONTACT_SCREEN_DONE_BTN, timeout);
			selenium.clickElement(iOSClientDriver, iOSClient.ADD_CONTACT_SCREEN_DONE_BTN);
			selenium.waitUntilElementVisible(iOSClientDriver, iOSClient.CONTACT_SCREEN_SEARCH_TXT);
			String contact = firstname +" "+ lastname;
			if(selenium.isElementExisted(iOSClientDriver, iOSClient.CONTACT_TAB_USER_NAME(contact))) {
				return s=true;
			} 
			else {s=false;}
		} catch (Exception e) {
			
			logger.error(message);
			
		}
		
		logger.info("addLocalContact - completed...\n");
		return s;
	}
	
	public boolean editExistedContactInfo(IOSDriver iOSClientDriver, String user, String fieldname, String value, String lastName) throws Exception{
		try {
			navigateToContactDetailScreen(iOSClientDriver, user);
			selenium.clickElement(iOSClientDriver, iOSClient.CONTACT_DETAIL_EDIT_CONTACT);	
			switch (fieldname) {
				case "company":
					selenium.inputText(iOSClientDriver, iOSClient.EDIT_CONTACT_SCREEN_COMPANY_TXT, value);
					selenium.clickElement(iOSClientDriver, iOSClient.EDIT_CONTACT_SCREEN_DONE_BTN);	
					Thread.sleep(4000);
					if(!selenium.isElementExisted(iOSClientDriver, iOSClient.EDIT_CONTACT_SCREEN_DONE_BTN) && selenium.getText(iOSClientDriver,iOSClient.CONTACT_DETAILS_COMPANY).contains(value))
					{
					return true;
					}
				case "first_name":
					selenium.inputText(iOSClientDriver, iOSClient.EDIT_CONTACT_SCREEN_FIRSTNAME_TXT, value);
					selenium.clickElement(iOSClientDriver, iOSClient.EDIT_CONTACT_SCREEN_DONE_BTN);	
					Thread.sleep(4000);
					String contact = value +" " +lastName;
					if(!selenium.isElementExisted(iOSClientDriver, iOSClient.EDIT_CONTACT_SCREEN_DONE_BTN) && selenium.isElementExisted(iOSClientDriver, iOSClient.CONTACT_TAB_USER_NAME(contact)))
					{
					return true;
					}
				}

		} catch (Exception exception) {
	
		}
	
		return false;
    }

	public void editContactPhone(IOSDriver iOSClientDriver, String user, String number) throws Exception {
		String message = String.format("*** removeContact - Add Contact by Search ");
		logger.warn(message);
		try {
			navigateToContactDetailScreen(iOSClientDriver, user);
			Thread.sleep(3000);
			selenium.clickElement(iOSClientDriver, iOSClient.CONTACT_DETAIL_EDIT_CONTACT);
			Thread.sleep(3000);
			selenium.inputText(iOSClientDriver, iOSClient.EDIT_CONTACT_SCREEN_OLD_PHONE_TXT(user), number);
			selenium.clickElement(iOSClientDriver, iOSClient.EDIT_CONTACT_SCREEN_DONE_BTN);
		} catch (Exception e) {
			message = String.format("*** removeContact *** FAILED - %s.", e.toString());
			logger.error(message);
			throw new AssertionError(message);
		}

	}
	
	public boolean verifyEnterpriseContactSearch(IOSDriver iOSClientDriver, String email, String name)
			throws Exception {
		try {
			boolean flag = false;
			logger.info("**** verifyEnterprieseContactSearch - Start verify contact search****");
			logger.info("verifyEnterprieseContactSearch - Search string: " + email);
			selenium.inputText(iOSClientDriver, iOSClient.CONTACT_SCREEN_SEARCH_TXT, email);
			Thread.sleep(10000);
			logger.info("**** verifyEnterprieseContactSearch - Get number of result ****");
			String s1 = selenium.getAttribute(iOSClientDriver, iOSClient.SEARCH_CONTACT_ENTERPRISE_CONTACT_TITLE_BAR,
					"name");
			String stringNumber = s1.replaceAll("[^0-9]", "");
			int num = Integer.parseInt(stringNumber);
			logger.info("verifyEnterprieseContactSearch - Number of result: " + num);
			logger.info("**** verifyEnterprieseContactSearch - Verify search ****");
			logger.info("verifyEnterprieseContactSearch - Expected result: " + name);
			for (int i = 0; i < num; i++) {
				String order = String.valueOf(i + 1);
				String s2 = selenium.getAttribute(iOSClientDriver, iOSClient.enterprise_result_by_order(order),
						"value");
				logger.info("verifyEnterprieseContactSearch - result " + (i + 1) + ": " + s2);
				if (s2.contains(name)) {
					logger.error("verifyEnterprieseContactSearch - Existed the expected result - PASSED OH YEAH");
					flag = true;
					break;
				}
			}
			if (flag == false) {
				logger.error("verifyEnterprieseContactSearch - FAILED - Expected result didn't exist");
				return false;
			}
			logger.error("verifyEnterprieseContactSearch - PASSED OH YEAH");
			return true;
		} catch (Exception e) {
			logger.error("verifyEnterprieseContactSearch - Failed with Exception: " + e + "...\n");
			throw new Exception("verifyEnterprieseContactSearch - Failed - Exception occurs: " + e);
		}
		
	}
	
	public void navigateToContactDetailScreen(IOSDriver iOSClientDriver, String user) throws Exception {
		logger.info("navigateToContactDetailScreen - starting...\n");
		try {
			Thread.sleep(2000);
			selenium.clickElement(iOSClientDriver, iOSClient.FIRST_SCREEN_EBAR_BTN);
			Thread.sleep(3000);
			selenium.clickElement(iOSClientDriver, iOSClient.FIRST_SCREEN_NAVIGATE_CONTACTS_TAB_BTN);
			Thread.sleep(2000);
			selenium.clickElement(iOSClientDriver, iOSClient.SEARCH_RESULT_USER_BTN(user));
			selenium.clickElement(iOSClientDriver, iOSClient.SEARCH_RESULT_USER_BTN(user));
		} catch (Exception exception) {
			logger.error("navigateToContactDetailScreen - Failed with Exception: " + exception + "...\n");
			throw new Exception("navigateToContactDetailScreen - Failed - Exception occurs: " + exception);
		}
		logger.info("navigateToContactDetailScreen - completed...\n");

	}
	
	public boolean verifyContactIsExistedContactList(AppiumDriver iOSClientDriver, String contact) throws Exception {
		logger.info("verifyContactIsExistedContactList - starting...\n");
		try {
			selenium.clickElement(iOSClientDriver, iOSClient.FIRST_SCREEN_EBAR_BTN);
			Thread.sleep(3000);
			selenium.clickElement(iOSClientDriver, iOSClient.FIRST_SCREEN_NAVIGATE_CONTACTS_TAB_BTN);
			Thread.sleep(3000);
			if (!selenium.isElementExisted(iOSClientDriver, iOSClient.SEARCH_RESULT_USER_BTN(contact))) {
				return false;
			} 
		} catch (Exception exception) {

		}
		logger.info("verifyContactIsExistedContactList - completed...\n");
		return true;
	}
	
	
	public String Presence(AppiumDriver iOSClientDriver)
			throws Exception {
		String s=null;
		try {
			selenium.tapCoordinates(iOSClientDriver, 800, 60);
			Thread.sleep(2000);
			selenium.clickElement(iOSClientDriver, iOSClient.PRESENCES_DETAIL);
			Thread.sleep(2000);
			s=selenium.getAttribute(iOSClientDriver, iOSClient.DETAIL_CONTACT_STATUS, "name");
			Thread.sleep(2000);
			selenium.clickElement(iOSClientDriver, iOSClient.PRESENCES_DETAIL_BACK_BTN);
			Thread.sleep(2000);
			selenium.clickElement(iOSClientDriver, iOSClient.PRESENCES_DETAIL_BACK_BTN);
			}
		catch (Exception e) {
			logger.error("Presence - Failed with Exception: " + e + "...\n");
		}
		return s;
	}
	
	public void SetStatus_T(AppiumDriver iOSClientDriver, String status) throws Exception {
		try {
			selenium.tapCoordinates(iOSClientDriver, 800, 60);
			Thread.sleep(2000);
			selenium.clickElement(iOSClientDriver, iOSClient.PRESENCES_DETAIL);
			Thread.sleep(2000);
			selenium.clickElement(iOSClientDriver, iOSClient.PRESENCES_DETAIL_CONTACT(status));
			Thread.sleep(1000);
			selenium.clickElement(iOSClientDriver, iOSClient.SETTING_SCREEN_DONE_BTN);
			Thread.sleep(2000);
			selenium.clickElement(iOSClientDriver, iOSClient.PRESENCES_DETAIL_DONE_BTN);
		} catch (Exception e) {
			logger.error("Presence - Failed with Exception: " + e + "...\n");
		}
	}

	public boolean SearchContact(AppiumDriver iOSClientDriver, String user)
			throws Exception {
		logger.info("SearchContact - starting...\n");
		try {
			selenium.clickElement(iOSClientDriver, iOSClient.FIRST_SCREEN_EBAR_BTN);
			Thread.sleep(3000);
			settingScreenMainClickOnTab(iOSClientDriver, "Contacts");
			selenium.inputText(iOSClientDriver, iOSClient.CONTACT_SCREEN_SEARCH_TXT, user);
//			appium.tapElement(iOSClientDriver, byLocator);
		} catch (Exception exception) {
			logger.error("mainWindowsContactsTabSearchContactClickContactClickBubble - Failed with Exception: "
					+ exception + "...\n");
			throw new Exception(
					"mainWindowsContactsTabSearchContactClickContactClickBubble - Failed - Exception occurs: "
							+ exception);
		}
		logger.info("mainWindowsContactsTabSearchContactClickContactClickBubble - completed...\n");
		return false;
	}
	
	
	public void settingScreenMainClickOnTab(AppiumDriver iOSClientDriver, String tabName) throws Exception {
		logger.info("settingScreenMainClickOnTab - starting...\n");
		logger.info("tabName is: " + tabName + "\n");
		try {
			// appium.waitUntilElementClickable(iOSClientDriver,
			// iOSClient.settingScreenTabLocators(tabName), timeout);
			selenium.clickElement(iOSClientDriver, iOSClient.settingScreenTabLocators(tabName));
		} catch (Exception exception) {
			logger.error("settingScreenMainClickOnTab - Failed with Exception: " + exception + "...\n");
			throw new Exception("settingScreenMainClickOnTab - Failed - Exception occurs: " + exception);
		}
		logger.info("settingScreenMainClickOnTab - completed...\n");
	}
	
	public void CheckPresence(AppiumDriver iOSClientDriver, String user, String status)throws Exception {
		logger.info("SearchContact - starting...\n");
		String s=null;
		try {
			selenium.clickElement(iOSClientDriver, iOSClient.FIRST_SCREEN_EBAR_BTN);
			Thread.sleep(3000);
			settingScreenMainClickOnTab(iOSClientDriver, "Contacts");
			selenium.inputText(iOSClientDriver, iOSClient.CONTACT_SCREEN_SEARCH_TXT, user);
			if(selenium.isElementExisted(iOSClientDriver, iOSClient.PRESENCES_DETAIL_CONTACT_AUTOMATIC))
//				logger.info("Automatic");
				s="Automatic";
			else if(selenium.isElementExisted(iOSClientDriver, iOSClient.PRESENCES_DETAIL_CONTACT_AVAILABLE))
//			logger.info("Available");
				s="Available";
			else if(selenium.isElementExisted(iOSClientDriver, iOSClient.PRESENCES_DETAIL_CONTACT_Away))
//				logger.info("Away");
				s="Away";
			else if(selenium.isElementExisted(iOSClientDriver, iOSClient.PRESENCES_DETAIL_CONTACT_BUSY))
//				logger.info("Busy");
				s="Busy";
			else if(selenium.isElementExisted(iOSClientDriver, iOSClient.PRESENCES_DETAIL_CONTACT_DO_NOT_DISTURB))
//				logger.info("Do not disturb");
				s="Do not disturb";
			else if(selenium.isElementExisted(iOSClientDriver, iOSClient.PRESENCES_DETAIL_CONTACT_OUT_OF_OFFICE))
//				logger.info("Out of office");
				s="Out of office";
			else if(selenium.isElementExisted(iOSClientDriver, iOSClient.PRESENCES_DETAIL_CONTACT_ON_A_CALL))s="On a call";
			else //logger.info("Offline");
				s="Offline";
			
			if (s.equals(status)) {
				logger.info("Passed");
			}else logger.info("Failed");
			selenium.clickElement(iOSClientDriver, iOSClient.CONTACT_SEARCH_CANCEL_BTN);
			Thread.sleep(1000);
		} catch (Exception exception) {
			
			logger.error("mainWindowsContactsTabSearchContactClickContactClickBubble - Failed with Exception: "
					+ exception + "...\n");
		
		}
		logger.info("mainWindowsContactsTabSearchContactClickContactClickBubble - completed...\n");
	}
	
	public void navigateToMessageScreen_T(AppiumDriver iOSClientDriver) throws Exception {
		logger.info("navigateToMessageScreen - starting...\n");
		try {
			selenium.clickElement(iOSClientDriver, iOSClient.FIRST_SCREEN_EBAR_BTN);
			// appium.waitUntilElementClickable(iOSClientDriver,
			// iOSClient.FIRST_SCREEN_NAVIGATE_MESSAGES_TAB_BTN, timeout);
			Thread.sleep(3000);
			selenium.clickElement(iOSClientDriver, iOSClient.FIRST_SCREEN_NAVIGATE_MESSAGES_TAB_BTN);
			Thread.sleep(2000);
		} catch (Exception exception) {
			logger.error("navigateToMessageScreen - Failed with Exception: " + exception + "...\n");
			//throw new Exception("navigateToMessageScreen - Failed - Exception occurs: " + exception);
		}
		logger.info("navigateToMessageScreen - completed...\n");
	}
	
	public void navigateToContactScreen(AppiumDriver iOSClientDriver) throws Exception {
		logger.info("navigateToMessageScreen - starting...\n");
		try {
			selenium.clickElement(iOSClientDriver, iOSClient.FIRST_SCREEN_EBAR_BTN);
			// appium.waitUntilElementClickable(iOSClientDriver,
			// iOSClient.FIRST_SCREEN_NAVIGATE_MESSAGES_TAB_BTN, timeout);
			selenium.clickElement(iOSClientDriver, iOSClient.FIRST_SCREEN_NAVIGATE_CONTACTS_TAB_BTN);

		} catch (Exception exception) {
			logger.error("navigateToMessageScreen - Failed with Exception: " + exception + "...\n");
			//throw new Exception("navigateToMessageScreen - Failed - Exception occurs: " + exception);
		}
		logger.info("navigateToMessageScreen - completed...\n");
	}
	
	
	public void messagesScreenVerifyConversationShouldBeExisted_T(AppiumDriver iOSClientDriver, String conversationName)
			throws Exception {
		logger.info("messagesScreenVerifyConversationShouldBeExisted - starting...\n");
		logger.info("conversationName is: " + conversationName + "\n");
		try {
			selenium.elementShouldBeExisted(iOSClientDriver,iOSClient.messagesScreenConversationNameLocators(conversationName));
			
		} catch (Exception exception) {
		
			logger.error(
					"messagesScreenVerifyConversationShouldBeExisted - Failed with Exception: " + exception + "...\n");
		}
		logger.info("messagesScreenVerifyConversationShouldBeExisted - completed...\n");
	}
	
	public void messagesScreenOpenConversation_T(AppiumDriver iOSClientDriver, String conversationName) throws Exception {
		logger.info("messagesScreenOpenConversation - starting...\n");
		logger.info("conversationName is: " + conversationName + "\n");
		try {
			selenium.clickElement(iOSClientDriver, iOSClient.messagesScreenConversationNameLocators(conversationName));
			Thread.sleep(2000);
		} catch (Exception exception) {
			

			logger.error("messagesScreenOpenConversation - Failed with Exception: " + exception + "...\n");
			
		}
		logger.info("messagesScreenOpenConversation - completed...\n");
	}
	
	
	public void conversationDetailScreenVerifyConversationShouldContainMessage_T(AppiumDriver iOSClientDriver,String message) throws Exception {
		logger.info("messagesScreenVerifyDisplayedConversationShouldContainsMessage - starting...\n");
		logger.info("message is: " + message + "\n");

		try {
			Thread.sleep(8000);
			if(selenium.isElementExisted(iOSClientDriver, iOSClient.conversationDetailScreenTextMessageLocator(message))|selenium.isElementExisted(iOSClientDriver, iOSClient.conversationDetailScreenTextMessageUrlLocator(message))){
		//		test.log(Status.PASS, "Conversation contains message: "+message);
			} else {
		//		test.log(Status.FAIL, "Conversation contains message: "+message);
							
			}
			
			/*appium.elementShouldBeExisted(iOSClientDriver,
					iOSClient.conversationDetailScreenTextMessageLocator(message));*/
		
		} catch (Exception exception) {
			logger.error("messagesScreenVerifyDisplayedConversationShouldContainsMessage - Failed with Exception: "
					+ exception + "...\n");
		}
		logger.info("messagesScreenVerifyDisplayedConversationShouldContainsMessage - completed...\n");
	}
	
	public void conversationiOSInputTextMsg_T(AppiumDriver iOSClientDriver, String message) throws Exception {
		logger.info("conversationiOSInputTextMsg - starting...\n");
		logger.info("message is: " + message + "\n");
		try {
			selenium.inputText(iOSClientDriver, iOSClient.CONVERSATION_DETAILS_SCREEN_MSG_TXT, message);
		} catch (Exception exception) {
			logger.error("conversationiOSInputTextMsg - Failed with Exception: " + exception + "...\n");
		}
		logger.info("conversationiOSInputTextMsg - completed...\n");
	}
	

	
	public void conversationWindowsSendMsg_T(AppiumDriver iOSClientDriver) throws Exception {
		logger.info("conversationWindowsSendMsg - starting...\n");
		try {
	
			selenium.clickElement(iOSClientDriver, iOSClient.CONVERSATION_DETAILS_SCREEN_SEND_BTN);
			Thread.sleep(1000);
		
		} catch (Exception exception) {

			logger.error("conversationiOSSendMsg - Failed with Exception: " + exception + "...\n");
			
		}
		logger.info("conversationiOSSendMsg - completed...\n");
	}
	
	public void conversationWindowsLeaveConversation(AppiumDriver iOSClientDriver) throws Exception {
		logger.info("conversationWindowsLeaveConversation - starting...\n");
		try {
			selenium.clickElement(iOSClientDriver, iOSClient.CONVERSATION_DETAILS_SCREEN_SUBJECT_TITLE_TXT);
			Thread.sleep(2000);
			Thread.sleep(2000);
			selenium.clickElement(iOSClientDriver, iOSClient.CONVERSATION_DETAILS_SCREEN_LEAVE_CONVERSATION_BTN);
			Thread.sleep(2000);
		} catch (Exception exception) {
			logger.error("conversationWindowsLeaveConversation - Failed with Exception: " + exception + "...\n");
			throw new Exception("conversationWindowsLeaveConversation - Failed - Exception occurs: " + exception);
		}
		logger.info("conversationWindowsLeaveConversation - completed...\n");
	}
	
	public void makeSureContactIsFavorite(AppiumDriver iOSClientDriver, String user) throws Exception {
		logger.info("makeSureContactIsFavorite - starting...\n");
		logger.info("user is: " + user + "\n");
		try {
			navigateToContactsScreen(iOSClientDriver);
			selenium.inputText(iOSClientDriver, iOSClient.CONTACT_SCREEN_SEARCH_TXT, user);
			iOSClientDriver.getKeyboard().sendKeys(Keys.RETURN);
			Thread.sleep(2000);
			selenium.clickElement(iOSClientDriver, iOSClient.contactDetailScreenFileNameLocator(user));
			Thread.sleep(2000);
			if (selenium.isElementExisted(iOSClientDriver, iOSClient.CONTACT_DETAILS_FAVORITE_BTN)) {
				logger.info("Contact has been already marked as Favorite...\n");
			} else {
				if (selenium.isElementExisted(iOSClientDriver, iOSClient.CONTACT_DETAILS_NOTFAVORITE_BTN)) {
					logger.info("Contact hasn't been marked as Favorite yet...\n");
					logger.info("Marking the contact as Favorite - starting...\n");
					selenium.clickElement(iOSClientDriver, iOSClient.CONTACT_DETAILS_NOTFAVORITE_BTN);
					Thread.sleep(7000);
					if (selenium.isElementExisted(iOSClientDriver, iOSClient.CONTACT_DETAILS_FAVORITE_BTN)) {
						logger.info("Contact has been marked as Favorite...\n");
						logger.info("Marking the contact as Favorite - completed...\n");
					} else {
						logger.info(
								"Marking the contact as Favorite - FAILED - Could not mark the contact as Favorite...\n");
					}

				} else {
					logger.info("makeSureContactIsFavorite - FAILED - Favorite icon not found...\n");
				}
			}
			selenium.clickElement(iOSClientDriver, iOSClient.CONTACT_SEARCH_CANCEL_BTN);

		} catch (Exception exception) {
			logger.error("makeSureContactIsFavorite - Failed with Exception: " + exception + "...\n");
			throw new Exception("makeSureContactIsFavorite - Failed - Exception occurs: " + exception);
		}
		logger.info("makeSureContactIsFavorite - completed...\n");
	}

	public void navigateToContactsScreen(AppiumDriver iOSClientDriver) throws Exception {
	logger.info("navigateToContactsScreen - starting...\n");
	try {
		selenium.waitUntilElementClickable(iOSClientDriver, iOSClient.FIRST_SCREEN_EBAR_BTN, timeout);
		//appium.tapElement(iOSClientDriver, iOSClient.FIRST_SCREEN_EBAR_BTN);
		selenium.clickElement(iOSClientDriver, iOSClient.FIRST_SCREEN_EBAR_BTN);
		Thread.sleep(1000);
		settingScreenMainClickOnTab(iOSClientDriver, "Contacts");
	} catch (Exception exception) {
	
		logger.error("navigateToContactsScreen - Failed with Exception: " + exception + "...\n");
		throw new Exception("navigateToContactsScreen - Failed - Exception occurs: " + exception);
	}
	logger.info("navigateToContactsScreen - completed...\n");
}
}
