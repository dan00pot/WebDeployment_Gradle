package libs.clients;


import org.openqa.selenium.WebDriver;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidKeyCode;
import libs.common.Selenium;
import libs.clients.AndroidClientLocators;

public class AndroidClientKeywords {
	
	Logger logger = LogManager.getLogger("Android Client");
	Selenium selenium = new Selenium();
	AndroidClientLocators androidClient = new AndroidClientLocators();

	AndroidDriver androidClientDriver;
	int timeout = 50;

	public boolean autoConfigLogin(AndroidDriver androidClientDriver,
			String address, String usr, String pwd) throws Exception {
		boolean n = false;
		try {
			selenium.clickElement(androidClientDriver,	androidClient.FIRST_SCREEN_SETTING_BTN);

			selenium.clickElement(androidClientDriver,	androidClient.FIRST_SCREEN_SETTING_USE_WEB_BTN);

			selenium.clickElement(androidClientDriver,androidClient.FIRST_SCREEN_SETTING_WEB_ADDRESS_TXT);
			selenium.inputText(androidClientDriver,	androidClient.FIRST_SCREEN_SETTING_WEB_ADDRESS_TXT, address);
			selenium.clickElement(androidClientDriver,	androidClient.FIRST_SCREEN_SETTING_USE_WEB_NEXT_BTN);

			selenium.clickElement(androidClientDriver,androidClient.AADS_LOGIN_SCREEN_SETTING_USER_TXT);
			selenium.inputText(androidClientDriver,	androidClient.AADS_LOGIN_SCREEN_SETTING_USER_TXT, usr);

			selenium.clickElement(androidClientDriver,	androidClient.AADS_LOGIN_SCREEN_SETTING_PWD_TXT);
			selenium.inputText(androidClientDriver,	androidClient.AADS_LOGIN_SCREEN_SETTING_PWD_TXT, pwd);
			Thread.sleep(1000);
			selenium.clickElement(androidClientDriver,	androidClient.FIRST_SCREEN_SETTING_USE_WEB_NEXT_BTN);
			androidClientDriver.pressKeyCode(AndroidKeyCode.ENTER);

			for (int i = 0; i < 2; i++) // 4
			{
				selenium.clickElement(androidClientDriver,
						androidClient.AADS_LOGIN_SCREEN_ALLOW_TXT);
				Thread.sleep(1000);
			}
			selenium.clickElement(androidClientDriver,
					androidClient.AADS_LOGIN_SCREEN_OK_BTN);
			selenium.clickElement(androidClientDriver,
					androidClient.AADS_LOGIN_SCREEN_ACCEPT_BTN);
			selenium.clickElement(androidClientDriver,
					androidClient.AADS_LOGIN_SCREEN_ACCEPT_COMFIRM_BTN);
			selenium.clickElement(androidClientDriver,
					androidClient.AADS_LOGIN_SCREEN_SKIP_TUTORIAL_BTN);
			n = true;
		} catch (Exception exception) {
			
		}
		return n;
	}
	
	public void cancelSearch(AndroidDriver androidClientDriver) throws Exception{
		try {
			if (selenium.isElementExisted(androidClientDriver, androidClient.CONTACT_DETAIL_SCREEN_SEARCH_CANCEL_BTN)) {
			selenium.clickElement(androidClientDriver, androidClient.CONTACT_DETAIL_SCREEN_SEARCH_CANCEL_BTN);	
			}
			
		} catch (Exception exception) {
			//throw new Exception("cancelSearch - Failed - Exception occurs: " + exception);
		}
    }
	
	public void clickBackButton(AndroidDriver androidClientDriver) throws Exception{
		try {
			Thread.sleep(3000);
			if (selenium.isElementExisted(androidClientDriver, androidClient.CONTACT_DETAIL_SCREEN_NAVIGATE_UP_BTN	)){
				selenium.clickElement(androidClientDriver, androidClient.CONTACT_DETAIL_SCREEN_NAVIGATE_UP_BTN	);
				}	
			Thread.sleep(3000);
		} catch (Exception exception) { 
			throw new Exception("clickBackButton - Failed - Exception occurs: " + exception);
		}
	
    }
	
	public void Escape(AndroidDriver androidClientDriver) throws Exception{
		try {//
			if(selenium.isElementExisted(androidClientDriver, androidClient.CONTACT_TAB_CONTACTS_EXIST_BUTTON))
				selenium.clickElement(androidClientDriver, androidClient.CONTACT_TAB_CONTACTS_EXIST_BUTTON);
			if(selenium.isElementExisted(androidClientDriver, androidClient.ADD_CONTACT_SCREEN_DONE_BTN)) {
				selenium.clickElement(androidClientDriver, androidClient.ADD_CONTACT_SCREEN_DONE_BTN);
				Thread.sleep(4000);
				if(selenium.isElementExisted(androidClientDriver, androidClient.CONTACT_TAB_CONTACTS_EXIST_BUTTON))
					selenium.clickElement(androidClientDriver, androidClient.CONTACT_TAB_CONTACTS_EXIST_BUTTON);
				if(selenium.isElementExisted(androidClientDriver, androidClient.ADD_CONTACT_SCREEN_DONE_BTN))
					selenium.clickElement(androidClientDriver, androidClient.ADD_CONTACT_SCREEN_CANCEL_BTN	);
					}
			clickBackButton(androidClientDriver);
			cancelSearch(androidClientDriver);
		}
		catch(Exception exception){
		}
	}
	
	public boolean addContactBySearch(AndroidDriver androidClientDriver, String user) throws Exception{

		try {			
			selenium.clickElement(androidClientDriver, androidClient.CONTACT_SCREEN_SEARCH_TXT);
			selenium.inputText(androidClientDriver, androidClient.CONTACT_SCREEN_SEARCH_TXT, user);
			selenium.clickElement(androidClientDriver, androidClient.CONTACT_SCREEN_LIST_CONTACT_ITEM);
			selenium.clickElement(androidClientDriver, androidClient.CONTACT_DETAIL_SCREEN_ADD_CONTACT_BTN);
			clickBackButton(androidClientDriver);
			cancelSearch(androidClientDriver);
			selenium.waitUntilElementVisible(androidClientDriver, androidClient.CONTACT_LIST);
			if(selenium.isElementExisted(androidClientDriver, androidClient.CONTACT_TAB_USER_NAME(user))) {
				return true;
			} else return false;
			
		} catch (Exception exception) {
			Escape(androidClientDriver);
			cancelSearch(androidClientDriver);
			return false;
		}
		
    }
	
	public boolean addContactBySearch(AndroidDriver androidClientDriver, String searchString, String contact) throws Exception{

		try {			
			selenium.clickElement(androidClientDriver, androidClient.CONTACT_SCREEN_SEARCH_TXT);
			selenium.inputText(androidClientDriver, androidClient.CONTACT_SCREEN_SEARCH_TXT, searchString);
			selenium.clickElement(androidClientDriver, androidClient.enterprise_result_by_name(contact));
			selenium.clickElement(androidClientDriver, androidClient.CONTACT_DETAIL_SCREEN_ADD_CONTACT_BTN);
			clickBackButton(androidClientDriver);
			cancelSearch(androidClientDriver);
			selenium.waitUntilElementVisible(androidClientDriver, androidClient.CONTACT_LIST);
			if(selenium.isElementExisted(androidClientDriver, androidClient.CONTACT_TAB_USER_NAME(contact))) {
				return true;
			} else return false;
			
		} catch (Exception exception) {
			Escape(androidClientDriver);
			cancelSearch(androidClientDriver);
			return false;
		}
		
    }

	public void settingScreenMainClickOnTab(AndroidDriver androidClientDriver, String tabName) throws Exception{
		
		try {
			selenium.clickElement(androidClientDriver, androidClient.settingScreenTabLocators(tabName));
		} catch (Exception exception) { 
			throw new Exception("settingScreenMainClickOnTab - Failed - Exception occurs: " + exception);
		}
				
    }
	
	public void navigateToContactDetailScreen(AndroidDriver androidClientDriver, String user) throws Exception{
		try {
			Thread.sleep(2000);
			selenium.clickElement(androidClientDriver, androidClient.FIRST_SCREEN_MENU_BTN);
			settingScreenMainClickOnTab(androidClientDriver, "Contacts");
			selenium.clickElement(androidClientDriver, androidClient.CONTACT_SCREEN_SEARCH_TXT);
			Thread.sleep(3000);
			selenium.inputText(androidClientDriver, androidClient.CONTACT_SCREEN_SEARCH_TXT, user);
			Thread.sleep(5000);
			selenium.clickElement(androidClientDriver, androidClient.CONTACT_SCREEN_LIST_CONTACT_ITEM);
			Thread.sleep(2000);
		} catch (Exception exception) { 
			throw new Exception("navigateToContactDetailScreen - Failed - Exception occurs: " + exception);
		}

		
    }
	
	public boolean editExistedContactInfo(AndroidDriver androidClientDriver, String user, String fieldname, String value, String lastName) throws Exception{
		try {
			navigateToContactDetailScreen(androidClientDriver, user);
			selenium.clickElement(androidClientDriver, androidClient.CONTACT_SCREEN_EDIT_CONTACT_BTN);	
			switch (fieldname) {
				case "company":
					selenium.inputText(androidClientDriver, androidClient.EDIT_COMPANY_TXT_FIELD, value);
					selenium.clickElement(androidClientDriver, androidClient.EDIT_CONTACT_SCREEN_DONE_BTN);	
					Thread.sleep(4000);

					if(!selenium.isElementExisted(androidClientDriver, androidClient.EDIT_CONTACT_SCREEN_DONE_BTN) && selenium.getText(androidClientDriver,androidClient.CONTACT_DETAILS_COMPANY).contains(value))
					{
					clickBackButton(androidClientDriver);
					cancelSearch(androidClientDriver); 
					return true;
					}
				case "first_name":
					selenium.inputText(androidClientDriver, androidClient.EDIT_FIRST_NAME_TXT_FIELD, value);
					selenium.clickElement(androidClientDriver, androidClient.EDIT_CONTACT_SCREEN_DONE_BTN);	
					Thread.sleep(4000);
					clickBackButton(androidClientDriver);
					cancelSearch(androidClientDriver); 
					String contact = value +" " +lastName;
					if(!selenium.isElementExisted(androidClientDriver, androidClient.EDIT_CONTACT_SCREEN_DONE_BTN) && selenium.isElementExisted(androidClientDriver, androidClient.CONTACT_TAB_USER_NAME(contact)))
					{
					return true;
					}
				}

		} catch (Exception exception) {
			Escape(androidClientDriver);
		}
		clickBackButton(androidClientDriver);
		cancelSearch(androidClientDriver);
		return false;
    }
	
	public boolean removeContactInContactList(AndroidDriver androidClientDriver, String user) throws Exception{
		try {
			navigateToContactDetailScreen(androidClientDriver, user);
			selenium.clickElement(androidClientDriver, androidClient.CONTACT_DETAIL_SCREEN_REMOVE_CONTACT_BTN);
			selenium.clickElement(androidClientDriver, androidClient.CONTACT_DETAIL_SCREEN_REMOVE_CONTACT_BTN);
			selenium.waitUntilElementVisible(androidClientDriver, androidClient.CONTACT_SCREEN_SEARCH_TXT);
			if(!selenium.isElementExisted(androidClientDriver, androidClient.CONTACT_DETAIL_SCREEN_REMOVE_CONTACT_BTN)) {
				logger.info("removeContactInContactList: Remove button disappear");
				clickBackButton(androidClientDriver);
				cancelSearch(androidClientDriver);
				selenium.waitUntilElementVisible(androidClientDriver, androidClient.CONTACT_SCREEN_SEARCH_TXT);
				if(!selenium.isElementExisted(androidClientDriver, androidClient.CONTACT_TAB_USER_NAME(user))) {
					logger.info("removeContactInContactList: Contact "+user+" was removed from contact list");
					return true;
				} else
					{
					logger.info("removeContactInContactList - FAILED: Contact "+user+" still exists in contact list");
					return false;
					}
				}
		} catch (Exception exception) { 
			Escape(androidClientDriver);
		}
		return false;
    }
	
	public boolean TestSearchContact(AndroidDriver androidClientDriver, String input, String result) throws Exception{
		boolean s = false;
	
			Thread.sleep(2000);
		
			selenium.clickElement(androidClientDriver, androidClient.CONTACT_SCREEN_SEARCH_TXT);
			Thread.sleep(2000);
			selenium.inputText(androidClientDriver, androidClient.CONTACT_SCREEN_SEARCH_TXT, input);
			Thread.sleep(5000);
			s=selenium.isElementExisted(androidClientDriver, androidClient.CONTACT_SCREN_STRING_MUST_CONTAIN(result));
	
		cancelSearch(androidClientDriver);
		return s;
    }
	
	
	public boolean verifyContactIsExistedContactList_T(AndroidDriver androidClientDriver, String user) throws Exception{
		logger.info("verifyContactIsExistedContactList - starting...\n");
		boolean s= false;
		try {
			
			Thread.sleep(2000);
			selenium.clickElement(androidClientDriver, androidClient.FIRST_SCREEN_MENU_BTN);
			settingScreenMainClickOnTab(androidClientDriver, "Contacts");
			//appium.waitUntilElementClickable(androidClientDriver, androidClient.CONTACT_TAB_CONTACT_VIEW_OPTON_BUTTON, timeout);
			//appium.tapElement(androidClientDriver, androidClient.CONTACT_TAB_CONTACT_VIEW_OPTON_BUTTON);
			//Thread.sleep(2000);
			//appium.waitUntilElementClickable(androidClientDriver, androidClient.CONTACT_TAB_CONTACT_EQUINOX_CONTACTS_BUTTON, timeout);
			//appium.tapElement(androidClientDriver, androidClient.CONTACT_TAB_CONTACT_EQUINOX_CONTACTS_BUTTON);
			Thread.sleep(2000);
			if(selenium.isElementExisted(androidClientDriver, androidClient.contactDetailScreenUserNameLocator(user)))
			{
				return true;
			}
			else s = false;
		} catch (Exception exception) {
			logger.error("verifyContactIsExistedContactList - Failed with Exception: " + exception + "...\n");
//			throw new Exception("verifyContactIsExistedContactList - Failed - Exception occurs: " + exception);
			return false;
		}
		logger.info("verifyContactIsExistedContactList - completed...\n");
		return s;
    }

	
	public String CheckPresence(AndroidDriver androidClientDriver) throws Exception{
		logger.info("CheckPresence - starting...\n");
		String s=null;
		try {
//				SetStatus(androidClientDriver,"1");
				s=GetStatus(androidClientDriver);
		} catch (Exception exception) {
			logger.error("CheckPresence - Failed with Exception: " + exception + "...\n");
		}
		logger.info("CheckPresence - completed...\n");
		return s;
    }
	
	
	
	public boolean SetStatus(AndroidDriver androidClientDriver, String statusNumber) throws Exception{
		logger.info("SetStatus - starting...\n");
		boolean s=false;
		try {
			Thread.sleep(2000);

//			selenium.clickElement(androidClientDriver, androidClient.PROFILE_AVATAR);

			if(selenium.isElementExisted(androidClientDriver, androidClient.PROFILE_AVATAR))
			selenium.clickElement(androidClientDriver, androidClient.PROFILE_AVATAR);

			Thread.sleep(2000);
			if(selenium.isElementExisted(androidClientDriver,  androidClient.CONTACTS_DETAIL_PREFERENCES))
			selenium.clickElement(androidClientDriver, androidClient.CONTACTS_DETAIL_PREFERENCES);
			Thread.sleep(2000);
			if(selenium.isElementExisted(androidClientDriver, androidClient.CONTACTS_DETAIL_PREFERENCES_F(statusNumber)))
					selenium.clickElement(androidClientDriver, androidClient.CONTACTS_DETAIL_PREFERENCES_F(statusNumber));
			else selenium.clickElement(androidClientDriver, androidClient.CONTACTS_DETAIL_PREFERENCES_T(statusNumber));
			s=true;
			Thread.sleep(2000);
			selenium.clickElement(androidClientDriver, androidClient.NAV_UP_BTN);
		} catch (Exception exception) {
			logger.error("SetStatus - Failed with Exception: " + exception + "...\n");
		}
		logger.info("SetStatus - completed...\n");
		return s;
    }
	
	public void SetStatus_T(AndroidDriver androidClientDriver, String statusNumber) throws Exception{
		logger.info("SetStatus - starting...\n");

		try {
			Thread.sleep(2000);

//			selenium.clickElement(androidClientDriver, androidClient.PROFILE_AVATAR);

			if(selenium.isElementExisted(androidClientDriver, androidClient.PROFILE_AVATAR))
			selenium.clickElement(androidClientDriver, androidClient.PROFILE_AVATAR);

			Thread.sleep(2000);
			if(selenium.isElementExisted(androidClientDriver,  androidClient.CONTACTS_DETAIL_PREFERENCES))
			selenium.clickElement(androidClientDriver, androidClient.CONTACTS_DETAIL_PREFERENCES);
			Thread.sleep(2000);
			if(selenium.isElementExisted(androidClientDriver, androidClient.CONTACTS_DETAIL_PREFERENCES_F(statusNumber)))
					selenium.clickElement(androidClientDriver, androidClient.CONTACTS_DETAIL_PREFERENCES_F(statusNumber));
			else selenium.clickElement(androidClientDriver, androidClient.CONTACTS_DETAIL_PREFERENCES_T(statusNumber));
			Thread.sleep(2000);
			selenium.clickElement(androidClientDriver, androidClient.NAV_UP_BTN);
			
		} catch (Exception exception) {
			logger.error("SetStatus - Failed with Exception: " + exception + "...\n");
		}
		logger.info("SetStatus - completed...\n");
    }
	
	
	
	public String GetStatus(AndroidDriver androidClientDriver) throws Exception{
		logger.info("GetStatus - starting...\n");
		String s=null;
		try {
			Thread.sleep(2000);
			selenium.clickElement(androidClientDriver, androidClient.PROFILE_AVATAR);
			Thread.sleep(2000);
//			selenium.clickElement(androidClientDriver, androidClient.CONTACTS_DETAIL_PREFERENCES);
			Thread.sleep(2000);
			s=selenium.getAttribute(androidClientDriver, androidClient.CONTACTS_DETAIL_PREFERENCES, "text");
			Thread.sleep(2000);
			selenium.clickElement(androidClientDriver, androidClient.NAV_UP_BTN);
			} catch (Exception exception) {
			logger.error("GetStatus - Failed with Exception: " + exception + "...\n");
		}
		logger.info("GetStatus - completed...\n");
		return s;
    }
	

	public String CheckPresenceContact_T(AndroidDriver androidClientDriver,String user, String status) throws Exception{
		logger.info("CheckPresenceContact - starting...\n");
		String s=null;
		try {
			selenium.clickElement(androidClientDriver, androidClient.CONTACT_SCREEN_SEARCH_TXT);
			Thread.sleep(2000);
			selenium.inputText(androidClientDriver, androidClient.CONTACT_SCREEN_SEARCH_TXT, user);
			Thread.sleep(2000);
			selenium.clickElement(androidClientDriver, androidClient.CONTACT_SCREEN_LIST_CONTACT_ITEM);
			Thread.sleep(5000);

			s=selenium.getAttribute(androidClientDriver, androidClient.CONTACTS_DETAIL_STATUS_SUMMARY, "text");
			clickBackButton(androidClientDriver);
			cancelSearch(androidClientDriver);
				
			if (s.equals(status)) {
				logger.info("Passed");
			}else logger.info("Failed");
				
		} catch (Exception exception) {
			logger.error("CheckPresenceContact - Failed with Exception: " + exception + "...\n");
			clickBackButton(androidClientDriver);
			cancelSearch(androidClientDriver);
		}
		logger.info("CheckPresenceContact - completed...\n");
		return s;
    }
	
	public boolean CheckPresencenaCall(AndroidDriver androidClientDriver,String user) throws Exception{
		logger.info("CheckPresencenaCall - starting...\n");
		boolean s=false;
		try {
			Thread.sleep(2000);
			selenium.clickElement(androidClientDriver, androidClient.FIRST_SCREEN_MENU_BTN);
			settingScreenMainClickOnTab(androidClientDriver, "Contacts");
			selenium.clickElement(androidClientDriver, androidClient.CONTACT_SCREEN_SEARCH_TXT);
			Thread.sleep(3000);
			selenium.inputText(androidClientDriver, androidClient.CONTACT_SCREEN_SEARCH_TXT, user);
			selenium.clickElement(androidClientDriver, androidClient.CONTACT_SCREEN_LIST_CONTACT_ITEM);
			Thread.sleep(2000);
			if(selenium.isElementExisted(androidClientDriver, androidClient.CONTACTS_DETAIL_CALL)) {
			selenium.clickElement(androidClientDriver, androidClient.CONTACTS_DETAIL_CALL );s=true;}
		} catch (Exception exception) {
			logger.error("CheckPresencenaCall - Failed with Exception: " + exception + "...\n");
			s=false;
		}
		logger.info("CheckPresencenaCall - completed...\n");
		return s;
    }
	
	public boolean CheckPresencenaCall1(AndroidDriver androidClientDriver) throws Exception{
		logger.info("CheckPresence - starting...\n");
		boolean s=false;
		try {
			Thread.sleep(5000);
			selenium.clickElement(androidClientDriver, androidClient.CONTACTS_DETAIL_END_CALL );
		} catch (Exception exception) {
			logger.error("addLocalContactManual - Failed with Exception: " + exception + "...\n");
		}
		logger.info("addLocalContactManual - completed...\n");
		return s;
    }
	
	public void navigateToContactScreen(AppiumDriver androidClientDriver) throws Exception{
		logger.info("navigateToMessageScreen - starting...\n");
		try {
			selenium.clickElement(androidClientDriver, androidClient.FIRST_SCREEN_MENU_BTN);
			selenium.clickElement(androidClientDriver, androidClient.firstScreenMenuTabLocators("Contacts"));
		} catch (Exception exception) {
			logger.error("navigateToMessageScreen - Failed with Exception: " + exception + "...\n");
		}
		logger.info("navigateToMessageScreen - completed...\n");			
    }
	
	public void navigateToMessageScreen_T(AppiumDriver androidClientDriver) throws Exception{
		logger.info("navigateToMessageScreen - starting...\n");
		try {
			Thread.sleep(4000);
			selenium.clickElement(androidClientDriver, androidClient.FIRST_SCREEN_MENU_BTN);
			Thread.sleep(2000);
			//appium.waitUntilElementClickable(androidClientDriver, androidClient.firstScreenMenuTabLocators("Messages"), 300);
			//appium.tapElement(androidClientDriver, androidClient.firstScreenMenuTabLocators("Messages"));
			selenium.clickElement(androidClientDriver, androidClient.firstScreenMenuTabLocators("Messages"));
			Thread.sleep(2000);
		} catch (Exception exception) {
			logger.error("navigateToMessageScreen - Failed with Exception: " + exception + "...\n");
			//throw new Exception("navigateToMessageScreen - Failed - Exception occurs: " + exception);
		}
		logger.info("navigateToMessageScreen - completed...\n");			
    }
	
	public void messagesScreenOpenConversation_T(AppiumDriver androidClientDriver, String conversationName) throws Exception{
		logger.info("messagesScreenOpenConversation - starting...\n");	
		logger.info("conversationName is: " + conversationName + "\n");
		try {
		
			selenium.clickElement(androidClientDriver, androidClient.messagesScreenConversationNameLocators(conversationName));
			Thread.sleep(2000);
		} catch (Exception exception) { 
			logger.error("messagesScreenOpenConversation - Failed with Exception: " + exception + "...\n");
		//	throw new Exception("messagesScreenOpenConversation - Failed - Exception occurs: " + exception);
		}
		logger.info("messagesScreenOpenConversation - completed...\n");			
    }
	
	public void conversationDetailScreenVerifyConversationShouldContainMessage_T(AppiumDriver androidClientDriver, String text) throws Exception{
		logger.info("conversationDetailScreenVerifyConversationShouldContainMessage - starting...\n");	
		logger.info("Message is: " + text + "\n");
		try {
			selenium.elementShouldBeExisted(androidClientDriver, androidClient.conversationDetailScreenTextMessageLocator(text));
		} catch (Exception exception) {
			logger.error("conversationDetailScreenVerifyConversationShouldContainMessage - Failed with Exception: " + exception + "...\n");
			//throw new Exception("conversationDetailScreenVerifyConversationShouldContainMessage - Failed - Exception occurs: " + exception);
		}
		logger.info("conversationDetailScreenVerifyConversationShouldContainMessage - completed...\n");			
    }
	
	public void conversationAndroidInputTextMsg (AppiumDriver androidClientDriver, String message) throws Exception{
		logger.info("conversationAndroidInputTextMsg - starting...\n");
		logger.info("message is: " + message + "\n");
		try {
			selenium.inputText(androidClientDriver, androidClient.CONVERSATION_DETAILS_SCREEN_MSG_TXT, message);
			String newValue = selenium.getText(androidClientDriver, androidClient.CONVERSATION_DETAILS_SCREEN_MSG_TXT);
			Thread.sleep(5000);
			while (!newValue.equals(message)) {
				selenium.clearText(androidClientDriver, androidClient.CONVERSATION_DETAILS_SCREEN_MSG_TXT);
				selenium.inputText(androidClientDriver, androidClient.CONVERSATION_DETAILS_SCREEN_MSG_TXT, message);
				newValue = selenium.getText(androidClientDriver, androidClient.CONVERSATION_DETAILS_SCREEN_MSG_TXT);
			}
		} catch (Exception exception) {
		logger.error("conversationAndroidInputTextMsg - Failed with Exception: " + exception + "...\n");
		throw new Exception("conversationAndroidInputTextMsg - Failed - Exception occurs: " + exception);
	}
	logger.info("conversationAndroidInputTextMsg - completed...\n");		
    }
	
	
	public void conversationAndroidInputTextMsg_T (AppiumDriver androidClientDriver, String message) throws Exception{
		logger.info("conversationAndroidInputTextMsg - starting...\n");
		logger.info("message is: " + message + "\n");
		try {
			selenium.inputText(androidClientDriver, androidClient.CONVERSATION_DETAILS_SCREEN_MSG_TXT, message);
			String newValue = selenium.getText(androidClientDriver, androidClient.CONVERSATION_DETAILS_SCREEN_MSG_TXT);
			Thread.sleep(5000);
			while (!newValue.equals(message)) {
				selenium.clearText(androidClientDriver, androidClient.CONVERSATION_DETAILS_SCREEN_MSG_TXT);
				selenium.inputText(androidClientDriver, androidClient.CONVERSATION_DETAILS_SCREEN_MSG_TXT, message);
				newValue = selenium.getText(androidClientDriver, androidClient.CONVERSATION_DETAILS_SCREEN_MSG_TXT);
			}
			
		} catch (Exception exception) { 
		logger.error("conversationAndroidInputTextMsg - Failed with Exception: " + exception + "...\n");
		//throw new Exception("conversationAndroidInputTextMsg - Failed - Exception occurs: " + exception);
	}
	logger.info("conversationAndroidInputTextMsg - completed...\n");		
    }
	/**
	 * Send the composed message
	 * @param androidClientDriver testing Client on Android
	 * @author ndkhuong
	 * @throws Exception 
	 */	
	public void conversationWindowsSendMsg (AppiumDriver androidClientDriver) throws Exception{
		logger.info("conversationWindowsSendMsg - starting...\n");
		try {
			selenium.clickElement(androidClientDriver, androidClient.CONVERSATION_DETAILS_SCREEN_SEND_BTN);	
			Thread.sleep(1000);
		} catch (Exception exception) {
			logger.error("conversationAndroidSendMsg - Failed with Exception: " + exception + "...\n");
			throw new Exception("conversationAndroidSendMsg - Failed - Exception occurs: " + exception);
		}
		logger.info("conversationAndroidSendMsg - completed...\n");		
    }
	
	
	public void conversationWindowsSendMsg_T (AppiumDriver androidClientDriver) throws Exception{
		logger.info("conversationWindowsSendMsg - starting...\n");
		try {
			logger.info("Send button is enabled...");
			selenium.clickElement(androidClientDriver, androidClient.CONVERSATION_DETAILS_SCREEN_SEND_BTN);		
			Thread.sleep(1000);
		} catch (Exception exception) {
			logger.error("conversationAndroidSendMsg - Failed with Exception: " + exception + "...\n");
			//throw new Exception("conversationAndroidSendMsg - Failed - Exception occurs: " + exception);
		}
		logger.info("conversationAndroidSendMsg - completed...\n");		
    }

	public void incomingCallScreenClickAnswerButton(AppiumDriver androidClientDriver) throws Exception{
		logger.info("IncomingCallScreenClickAnswerButton - starting...\n");
		try {
			selenium.clickElement(androidClientDriver, androidClient.INCOMING_CALL_SCREEN_ANSWER_BTN);
			Thread.sleep(1000);
			
		} catch (Exception exception) {
			logger.error("IncomingCallScreenClickAnswerButton - Failed with Exception: " + exception + "...\n");
			throw new Exception("IncomingCallScreenClickAnswerButton - Failed - Exception occurs: " + exception);
		}
		logger.info("IncomingCallScreenClickAnswerButton - completed...\n");		
    }
	
	public void messagesScreenOpenConversationWhenExistCall_T(AppiumDriver androidClientDriver, String conversationName) throws Exception{
		logger.info("messagesScreenOpenConversation - starting...\n");	
		logger.info("conversationName is: " + conversationName + "\n");
		try {
			selenium.clickElement(androidClientDriver, androidClient.messagesScreenConversationNameLocatorsWhenExistCall(conversationName));
			Thread.sleep(2000);
		} catch (Exception exception) {
			logger.error("messagesScreenOpenConversation - Failed with Exception: " + exception + "...\n");
		//	throw new Exception("messagesScreenOpenConversation - Failed - Exception occurs: " + exception);
		}
		logger.info("messagesScreenOpenConversation - completed...\n");			
    }
	
	public void conversationWindowsBackToPhoneCallScreen (AppiumDriver androidClientDriver) throws Exception{
		logger.info("conversationWindowsBackToVideoCallScreen - starting...\n");

		try {	
			selenium.clickElement(androidClientDriver, androidClient.CONTACT_SCREEN_LIST_VIDEO_CALL_BANNER);
		} catch (Exception exception) { 
		logger.error("conversationWindowsBackToVideoCallScreen - Failed with Exception: " + exception + "...\n");
		throw new Exception("conversationWindowsBackToVideoCallScreen - Failed - Exception occurs: " + exception);
	}
	logger.info("conversationWindowsBackToVideoCallScreen - completed...\n");		
    }
	
	public void phoneCallMainScreenCickVideoCallButton(AppiumDriver androidClientDriver) throws Exception{
		logger.info("PhoneCallMainScreenEndCallButton - starting...\n");
		try {
			selenium.clickElement(androidClientDriver, androidClient.PHONE_CALL_MAIN_SCREEN_VIDEO_CALL_BTN);
		} catch (Exception exception) {
			logger.error("PhoneCallMainScreenEndCallButton - Failed with Exception: " + exception + "...\n");
			throw new Exception("PhoneCallMainScreenEndCallButton - Failed - Exception occurs: " + exception);
		}
		logger.info("PhoneCallMainScreenEndCallButton - completed...\n");		
    }
	
	public void phoneCallMainScreenEndCallButton(AppiumDriver androidClientDriver) throws Exception{
		logger.info("PhoneCallMainScreenEndCallButton - starting...\n");
		try {

			selenium.clickElement(androidClientDriver, androidClient.PHONE_CALL_MAIN_SCREEN_END_CALL_BTN);
		} catch (Exception exception) { 
			logger.error("PhoneCallMainScreenEndCallButton - Failed with Exception: " + exception + "...\n");
			throw new Exception("PhoneCallMainScreenEndCallButton - Failed - Exception occurs: " + exception);
		}
		logger.info("PhoneCallMainScreenEndCallButton - completed...\n");		
    }
	
	public void messagesScreenOpenConversation(AppiumDriver androidClientDriver, String conversationName) throws Exception{
		logger.info("messagesScreenOpenConversation - starting...\n");	
		logger.info("conversationName is: " + conversationName + "\n");
		try {
			selenium.clickElement(androidClientDriver, androidClient.messagesScreenConversationNameLocators(conversationName));
			Thread.sleep(2000);
		} catch (Exception exception) { 
			logger.error("messagesScreenOpenConversation - Failed with Exception: " + exception + "...\n");
			throw new Exception("messagesScreenOpenConversation - Failed - Exception occurs: " + exception);
		}
		logger.info("messagesScreenOpenConversation - completed...\n");			
    }
	
	public void conversationWindowsLeaveConversation (AppiumDriver androidClientDriver) throws Exception{
		logger.info("conversationWindowsLeaveConversation - starting...\n");
		try {
			Thread.sleep(4000);
			selenium.clickElement(androidClientDriver, androidClient.CONVERSATION_DETAILS_SCREEN_SUBJECT_TITLE_TXT);
			Thread.sleep(2000);
			selenium.clickElement(androidClientDriver, androidClient.CONVERSATION_DETAILS_SCREEN_LEAVE_CONVERSATION_BTN);
			selenium.clickElement(androidClientDriver, androidClient.CONVERSATION_DETAILS_SCREEN_LEAVE_CONVERSATION_OK_BTN);
		} catch (Exception exception) {
			logger.error("conversationWindowsLeaveConversation - Failed with Exception: " + exception + "...\n");
			throw new Exception("conversationWindowsLeaveConversation - Failed - Exception occurs: " + exception);
		}
		logger.info("conversationWindowsLeaveConversation - completed...\n");		
    }
	
	public boolean addPrivateContact(AndroidDriver androidClientDriver, String firstname,String lastname, String numberphone ,String address) throws Exception{
		logger.info("addLocalContact - starting...\n");
		boolean s = false;
		try {
			selenium.clickElement(androidClientDriver, androidClient.FIRST_SCREEN_MENU_BTN);
			settingScreenMainClickOnTab(androidClientDriver, "Contacts");
			selenium.waitUntilElementClickable(androidClientDriver, androidClient.CONTACT_TAB_SCREEN_ADD_CONTACT_BTN, timeout);
			selenium.clickElement(androidClientDriver, androidClient.CONTACT_TAB_SCREEN_ADD_CONTACT_BTN);
			selenium.clickElement(androidClientDriver, androidClient.CONTACT_TAB_SCREEN_ADD_CONTACT_CONTACT_BTN);
			selenium.inputText(androidClientDriver, androidClient.ADD_CONTACT_SCREEN_FIRST_NAME_TXT, firstname);
			selenium.inputText(androidClientDriver, androidClient.ADD_CONTACT_SCREEN_LAST_NAME_TXT, lastname);
			selenium.inputText(androidClientDriver, androidClient.ADD_CONTACT_SCREEN_NUMBER_PHONE_TXT,numberphone);
			selenium.inputText(androidClientDriver, androidClient.ADD_CONTACT_SCREEN_EMAIL_TXT,address);
			selenium.clickElement(androidClientDriver, androidClient.ADD_CONTACT_SCREEN_DONE_BTN);
			selenium.waitUntilElementVisible(androidClientDriver, androidClient.CONTACT_DETAIL_SCREEN_REMOVE_CONTACT_BTN);
			clickBackButton(androidClientDriver);
			String contact = firstname +" "+ lastname;
			selenium.waitUntilElementVisible(androidClientDriver, androidClient.CONTACT_LIST);
			if(!selenium.isElementExisted(androidClientDriver, androidClient.ADD_CONTACT_SCREEN_DONE_BTN) && selenium.isElementExisted(androidClientDriver, androidClient.CONTACT_TAB_USER_NAME(contact))) {
				s=true;
			}
			
			
		} catch (Exception exception) { 
			logger.error("addLocalContact - Failed with Exception: " + exception + "...\n");
			Escape(androidClientDriver);
		}
		logger.info("addLocalContact - completed...\n");
		return s;
    }
	
	public boolean verifyContactIsExistedInContactList(AndroidDriver androidClientDriver, String contact) {
		boolean s = false;
		try {
			Escape(androidClientDriver);
			selenium.waitUntilElementVisible(androidClientDriver, androidClient.CONTACT_LIST);
			if(!selenium.isElementExisted(androidClientDriver, androidClient.ADD_CONTACT_SCREEN_DONE_BTN) && selenium.isElementExisted(androidClientDriver, androidClient.CONTACT_TAB_USER_NAME(contact))) {
				s=true;
			}
			else {Escape(androidClientDriver); s=false;}
			return s;
		} catch (Exception e) {
			return s;
		}
	}
	
	public void addFavoriteContact(AndroidDriver androidClientDriver, String user) throws Exception{
		logger.info("addFavoriteContact - starting...\n");
		boolean s = false;
		try {
			navigateToContactDetailScreen(androidClientDriver, user);
			Thread.sleep(3000);
			selenium.clickElement(androidClientDriver, androidClient.CONTACT_DETAIL_SCREEN_FAVORITE_CONTACT_BTN);	
			Thread.sleep(3000);
		} catch (Exception exception) { 
			logger.error("addFavoriteContact - Failed with Exception: " + exception + "...\n");
			throw new Exception("addFavoriteContact - Failed - Exception occurs: " + exception);
		}
		logger.info("addFavoriteContact - completed...\n");
	
    }
	
	public boolean verifyUserIsFavoriteContact(AndroidDriver androidClientDriver, String user) throws Exception{
		logger.info("removeFavoriteContact - starting...\n");
		boolean s = false;
		try {
			navigateToFavoriteTab(androidClientDriver);
			s= selenium.isElementExisted(androidClientDriver,androidClient.contactDetailScreenUserNameLocator(user) );
		} catch (Exception exception) { 
			logger.error("removeFavoriteContact - Failed with Exception: " + exception + "...\n");
			throw new Exception("removeFavoriteContact - Failed - Exception occurs: " + exception);
		}
		logger.info("removeFavoriteContact - completed...\n");
		return s;
   }
	
	public void navigateToFavoriteTab(AppiumDriver androidClientDriver) throws Exception{
		logger.info("navigateToMessageScreen - starting...\n");
		try {
			selenium.clickElement(androidClientDriver, androidClient.FIRST_SCREEN_MENU_BTN);
			selenium.clickElement(androidClientDriver, androidClient.firstScreenMenuTabLocators("Favorites"));
		} catch (Exception exception) {
			logger.error("navigateToMessageScreen - Failed with Exception: " + exception + "...\n");
			throw new Exception("navigateToMessageScreen - Failed - Exception occurs: " + exception);
		}
		logger.info("navigateToMessageScreen - completed...\n");			
    }
	
	public void removeFavoriteContact(AndroidDriver androidClientDriver, String user) throws Exception{
		logger.info("removeFavoriteContact - starting...\n");
		boolean s = false;
		try {
			navigateToContactDetailScreen(androidClientDriver, user);
			Thread.sleep(3000);
			selenium.clickElement(androidClientDriver, androidClient.CONTACT_DETAIL_SCREEN_FAVORITE_CONTACT_BTN);	
			Thread.sleep(3000);
		} catch (Exception exception) { 
			logger.error("removeFavoriteContact - Failed with Exception: " + exception + "...\n");
			throw new Exception("removeFavoriteContact - Failed - Exception occurs: " + exception);
		}
		logger.info("removeFavoriteContact - completed...\n");
	
    }
	
	public void backFromContactDetailToContactTab(AndroidDriver androidClientDriver) throws Exception{
		logger.info("clickBackButton - starting...\n");
		boolean s = false;
		try {
			Thread.sleep(3000);
			if (selenium.isElementExisted(androidClientDriver, androidClient.HISTORY_DETAILS_SCREEN_BACK_BUTTON)){
				selenium.clickElement(androidClientDriver, androidClient.HISTORY_DETAILS_SCREEN_BACK_BUTTON);
				Thread.sleep(2000);
				selenium.clickElement(androidClientDriver, androidClient.CONVERSATION_DETAILS_SCREEN_ADD_PARTICIPANT_BACK_BTN);
				}	
			Thread.sleep(3000);
		} catch (Exception exception) { 
			logger.error("clickBackButton - Failed with Exception: " + exception + "...\n");
			throw new Exception("clickBackButton - Failed - Exception occurs: " + exception);
		}
		logger.info("clickBackButton - completed...\n");
	
    }
	
}