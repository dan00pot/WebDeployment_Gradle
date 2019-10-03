package libs.clients;

import org.openqa.selenium.By;

public class IOSClientLocators {

	public By LICENSE_AGREEMENT_ACCEPT_BTN = By.id("ACCEPT");
	public By LICENSE_AGREEMENT_DECLINE_BTN = By.id("DECLINE");
	
	public By SETTING_SCREEN_SUPPORT_TAB_RESET_ABOUT_BTN = By.id("About");
	public By SETTING_SCREEN_SUPPORT_TAB_RESET_TUTORIAL_BTN = By.id("Tutorial");
	public By SETTING_SCREEN_SUPPORT_TAB_ENABLE_DIANOCTICS_SWT = By.xpath("//XCUIElementTypeSwitch[contains(@Name,'Enable Diagnostics')]");
	public By SETTING_SCREEN_SUPPORT_TAB_QUALITY_IMPROVEMENT_SWT = By.xpath("//XCUIElementTypeSwitch[contains(@Name,'Quality Improvement')]");
	public By SETTING_SCREEN_SUPPORT_TAB_REPORT_BTN = By.id("Report a problem");
	public By SETTING_SCREEN_SUPPORT_TAB_LEGAL_BTN = By.id("Legal");
	public By SETTING_SCREEN_SUPPORT_TAB_EMERGENCY_DISCLAIMER = By.id("Emergency Disclaimer");
	public By SETTING_SCREEN_SUPPORT_TAB_RESET_APP_BTN = By.id("Reset Application");
	
	public By SETTING_SCREEN_SUPPORT_TAB_RESET_APP_WARN = By.xpath("//XCUIElementTypeStaticText[contains(@Name,'as a new install?')]");
	public By SETTING_SCREEN_SUPPORT_TAB_RESET_APP_OK_BTN = By.id("OK");
	public By SETTING_SCREEN_SUPPORT_TAB_RESET_APP_CANCEL_BTN = By.id("Cancel");
	
	
	public By AUTOLOGIN_SCREEN_CONFIGURE_MY_ACCOUNT_BTN = By.id("configure");
	public By AUTOLOGIN_SCREEN_SETTING_USE_WEB_ADDRESS_BTN = By.id("ServiceDiscoverySettingsUse");
	//public By LOGIN_SCREEN_SETTING_USE_WEB_ADDRESS_BTN = By.name("USE A WEB ADDRESS");
	public By AUTOLOGIN_SCREEN_WEB_ADDRESS_TXT = By.xpath("//XCUIElementTypeTextField");
	public By AUTOLOGIN_SCREEN_USER_TXT = By.xpath("//XCUIElementTypeTextField");
	public By AUTOLOGIN_SCREEN_PWD_TXT = By.xpath("//XCUIElementTypeSecureTextField");
	public By AUTOLOGIN_SCREEN_NEXT_BTN = By.id("NEXT");
	public By AUTOLOGIN_SCREEN_OK_BTN = By.id("OK");
	public By AUTOLOGIN_SCREEN_SKIP_BTN = By.id("Skip");
	
	public By MAIN_SCREEN_USER_IMAGE = By.id("UserImage");
	
	//###########################################################################################################################
	//########################################LOCATOR OF ELEMENTS IN FIRST SCREEN WHEN LAUNCHING ANDROID CLIENT##################
	//###########################################################################################################################
	public By FIRST_SCREEN_EBAR_BTN									=	By.id("EBarButton");
	public By FIRST_SCREEN_EBAR_SETTING_BTN							=	By.id("EBarSettings");
	public By FIRST_SCREEN_NAVIGATE_TOP_OF_MIND_TAB_BTN				=	By.id("EBarTopOfMind");
	public By FIRST_SCREEN_NAVIGATE_FAVORITES_TAB_BTN				=	By.id("EBarFavorites");
	public By FIRST_SCREEN_NAVIGATE_CONTACTS_TAB_BTN				=	By.id("EBarContacts");
	public By FIRST_SCREEN_NAVIGATE_HISTORY_TAB_BTN					=	By.id("EBarRecents");
	public By FIRST_SCREEN_NAVIGATE_METTINGS_TAB_BTN				=	By.id("EBarMeetings");
	public By FIRST_SCREEN_NAVIGATE_MESSAGES_TAB_BTN				=	By.id("EBarMessaging");
	public By FIRST_SCREEN_NAVIGATE_FEATURES_TAB_BTN				=	By.id("EBarFeatures");
	public By FIRST_SCREEN_MENU_NEW_MSG_COUNT						=	By.id("ebar.badge");
	public By firstScreenEbarTabLocators(String tabname)			{	return By.id(tabname);}
	
	//###########################################################################################################################
		//########################################LOCATOR OF ELEMENTS IN SETTING SCREEN##############################################
		//###########################################################################################################################
		
		public By settingScreenTabLocators(String tabname)			{	return By.id(tabname);}
		
		public By SETTING_SCREEN_DONE_BTN												=	By.id("DONE");
		public By SETTING_SCREEN_BACK_BTN												=	By.id("Back");
		
		public By SETTING_SCREEN_USER_PREFERENCES_TAB_BTN								=	By.id("User Preferences");
		public By SETTING_SCREEN_ACOUNTS_TAB_BTN										=	By.id("Accounts");
		public By SETTING_SCREEN_SERVICES_TAB_BTN										=	By.id("Services");
		public By SETTING_SCREEN_ADVANCED_TAB_BTN										=	By.id("Advanced");
		public By SETTING_SCREEN_SUPPORT_TAB_BTN										=	By.id("Support");
		
		public By settingScreenOptionsInsideTabLocators(String tabname)			{	return By.id(tabname);}
		
		public By SETTING_SCREEN_SERVICES_TAB_SERVICE_DETAILS_SWITCH					=	By.className("XCUIElementTypeSwitch");
		
//		public By SETTING_SCREEN_SERVICES_TAB_UNIFIED_LOGIN_BTN							=	By.id("Unified Login");
//		public By SETTING_SCREEN_SERVICES_TAB_PHONE_SERVICES_BTN						=	By.id("Phone Service");
//		public By SETTING_SCREEN_SERVICES_TAB_MEETING_BTN								=	By.id("Meetings");
//		public By SETTING_SCREEN_SERVICES_TAB_MULTIMEDIA_MESSAGING_BTN					=	By.id("Multimedia Messaging");
//		public By SETTING_SCREEN_SERVICES_TAB_DEVICES_SERVICES_BTN						=	By.id("Device Services");
//		public By SETTING_SCREEN_SERVICES_TAB_CLIENT_ENABLEMENT_BTN						=	By.id("Client Enablement (CES)");
		
		public By SETTING_SCREEN_SERVICES_TAB_PHONE_SERVICE_ON_OFF_SWITCH				=	By.className("XCUIElementTypeSwitch");
		public By SETTING_SCREEN_SERVICES_TAB_PHONE_SERVICES_SV_ADDRESS_TXT				=	By.id("Server Address");
		public By SETTING_SCREEN_SERVICES_TAB_PHONE_SERVICES_DOMAIN_TXT					=	By.id("Domain");
		public By SETTING_SCREEN_SERVICES_TAB_PHONE_SERVICES_SV_PORT_TX					=	By.id("Sever Port");
		
		public By SETTING_SCREEN_SERVICES_TAB_MM_ON_OFF_TOGGLE							=	By.className("XCUIElementTypeSwitch");
		public By SETTING_SCREEN_SERVICES_TAB_MM_SV_ADDRESS_TXT							=	By.id("Server Address");
		public By SETTING_SCREEN_SERVICES_TAB_MM_SV_PORT_TXT							=	By.id("Sever Port");
		public By SETTING_SCREEN_SERVICES_TAB_MM_POLLING_INTERVAL_BTN					=	By.id("Polling Interval");
		
		
		public By SETTING_SCREEN_ACCOUNT_TAB_COMMUNICATOR_USERNAME_TXT					=	By.id("User Name");
		public By SETTING_SCREEN_ACCOUNT_TAB_COMMUNICATOR_PASSWORD_TXT					=	By.id("Password");
		public By SETTING_SCREEN_ACCOUNT_TAB_COMMUNICATOR_CONNECT_BTN					=	By.id("Connect");
//		public By SETTING_SCREEN_ACCOUNT_TAB_COMMUNICATOR_CONNECTED_TXT					=	By.id("com.avaya.android.flare:id/service_connected_as_user");
		
//		public By SETTING_SCREEN_ACCOUNT_TAB_PHONE_EXTENSION_TXT						=	By.id("Extension");
		public By SETTING_SCREEN_ACCOUNT_TAB_PHONE_EXTENSION_TXT						=	By.xpath("//*[contains(@Id,'user_extension_id')]//XCUIElementTypeTextField");
		public By SETTING_SCREEN_ACCOUNT_TAB_PHONE_PASSWORD_TXT							=	By.id("Password");
		public By SETTING_SCREEN_ACCOUNT_TAB_PHONE_SERVICE_CONNECT_BTN					=	By.id("Connect");
//		public By SETTING_SCREEN_ACCOUNT_TAB_PHONE_SERVICE_CONNECTED_TXT				=	By.id("com.avaya.android.flare:id/voip_service_connected_as_user");
		
		public By SETTING_SCREEN_POP_UP_APPLY_CHANGES_BTN								=	By.id("Apply Changes");
		public By SETTING_SCREEN_POP_UP_CONTINUE_EDITING_BTN							=	By.id("Continue Editing");
		public By SETTING_SCREEN_POP_UP_UNDO_CHANGES_BTN								=	By.id("Undo Changes");
		
		
		
		//###########################################################################################################################
		//################################LOCATOR OF ELEMENTS TOP OF MIND SCREEN#####################################################
		//###########################################################################################################################
				
		public By TOP_OF_MIND_SCREEN_CONVERSATION_LIST_TXT							=	By.id("timeStamp");
		
		//ServiceDiscoverySettings
		
		public By MAIN_SCREEN_SERVICE_SETTING_BUTTON							=	By.id("ServiceDiscoverySettings");
		public By MAIN_SCREEN_URL_TXT											=	By.xpath("//XCUIElementTypeTextField");
		public By MAIN_SCREEN_NEXT_BTN											=	By.id("NEXT");
		
		public By LOGIN_BTN_SIGNIN    = By.id("SIGN IN");
		public By MEETING_SIGN_IN_BTN = By.id("Sign In");
		//public By BTN_SIGNOUT     = By.name("SIGN OUT");
		public By BTN_SIGNOUT	  = By.id("Sign Out");
		
		
		//###########################################################################################################################
		//########################################LOCATOR OF ELEMENTS IN CONTACT SCREEN##############################################
		//###########################################################################################################################
		
		public By CONTACT_SCREEN_SEARCH_TXT														=	By.id("find someone");
		public By contactDetailScreenFileNameLocator(String filename)			
		{	return By.xpath("//XCUIElementTypeStaticText[contains(@name,'" +filename+ "')]");}
		public By CONTACT_SCREEN_CONTACT_DETAIL_AMMMSG_BTN										=	By.xpath("//XCUIElementTypeCell[contains(@name,'contactEndPointMessagingCell')]/XCUIElementTypeButton[contains(@name,'primaryEndpointActionButton')]");
		public By contactDetailsAMMmsgBtnNameConversationLocator(String nameconversation)			
		{	return By.xpath("//XCUIElementTypeButton[contains(@name,'" +nameconversation+ "')]");}
		
		public By CONTACT_SCREEN_AMMMSG_BTN_START_NEW_CONVERSATiON								=	By.xpath("//XCUIElementTypeButton[contains(@name,'Start New Conversation')]");
		
		public By CONTACT_SCREEN_LIST_CONTACT_CALLVIDEO_BTN										=	By.xpath("//XCUIElementTypeCell[contains(@name,'contactEndPointPhoneCell')]/XCUIElementTypeButton[contains(@name,'primaryEndpointActionButton')]");
		public By CONTACT_SCREEN_LIST_CONTACT_CALLVOICE_BTN										=	By.xpath("//XCUIElementTypeCell[contains(@name,'contactEndPointPhoneCell')]/XCUIElementTypeButton[contains(@name,'secondaryEndpointActionButton')]");
		public By CONTACT_DETAILS_FAVORITE_BTN													=	By.xpath("//XCUIElementTypeButton[@name='Favorite']");
		public By CONTACT_DETAILS_NOTFAVORITE_BTN												=	By.xpath("//XCUIElementTypeButton[@name='NotFavorite']");
		public By CONTACT_SEARCH_CANCEL_BTN														=	By.xpath("//XCUIElementTypeButton[@name='Cancel']");
		
		
		
	    public By CONTACT_TAB_USER_NAME(String name){
	    	return By.xpath("//XCUIElementTypeStaticText[contains(@label,'"+name+"')]");
	    	//return By.xpath("//XCUIElementTypeStaticText[@label='"+name+"']");
	    }
		
	    public By SEARCH_RESULT_USER_BTN(String name){
	    	return By.xpath("//XCUIElementTypeStaticText[contains(@label,'"+name+"')]");
	    	//return By.xpath("//XCUIElementTypeStaticText[@label='"+name+"']");
	    }
	    public By SEARCH_RESULT_USER_BTN_ID(String name){
	    	return By.id(name);
	    }
	    
	    public By ADD_CONTACT_BTN = By.id("addButton");
	    public By CONTACT_DETAIL_DISMISS=By.xpath("//XCUIElementTypeButton[@name=\"Dismiss\"]");
	    public By CONTACT_DETAIL_REMOVE_CONTACT = By.id("Remove Contact");
	    public By CONTACT_DETAIL_REMOVE_CONTACT_CONFIRM = By.xpath("//XCUIElementTypeButton[contains(@label,'Remove Contact')]");
	    public By CONTACT_DETAIL_EDIT_CONTACT = By.id("Edit");
	    
	    public By EDIT_CONTACT_SCREEN_FIRSTNAME_TXT = By.id("firstNameTextField");
		public By EDIT_CONTACT_SCREEN_LASTNAME_TXT = By.id("lastNameTextField");
		public By EDIT_CONTACT_SCREEN_COMPANY_TXT = By.id("companyTextField");
		public By EDIT_CONTACT_SCREEN_DEPARTMENT_TXT = By.id("departmentTextField");
		public By EDIT_CONTACT_SCREEN_ADDRESS_TXT = By.id("companyStreetAddressTextField");
	    
	    public By ADD_CONTACT_SCREEN_DONE_BTN = By.id("Done");
		public By EDIT_CONTACT_SCREEN_TXT_FIELD_TEXT 			= By.id("companyTextField");
		
		public By CONTACT_DETAILS_COMPANY = By.xpath("//XCUIElementTypeStaticText[@name='company']");
		
		public By PRESENCES_DETAIL_CONTACT (String status) {
			return By.id(status);
		}
	    public By EDIT_CONTACT_SCREEN_DONE_BTN 					= By.id("Done");
	    
	    public By EDIT_CONTACT_SCREEN_OLD_PHONE_TXT(String phoneNumber){
	    	return By.xpath("//XCUIElementTypeTextField[contains(@value,'"+phoneNumber+"')]");
	    }
	    
	    public By enterprise_result_by_order(String order){
			return By.xpath("//XCUIElementTypeTable[@name='unifiedSearchResultsTable']/XCUIElementTypeOther[contains(@name,'Enterprise')]/following-sibling::XCUIElementTypeCell["+order+"]/XCUIElementTypeStaticText");
		}
		
		public By SEARCH_CONTACT_ENTERPRISE_CONTACT_TITLE_BAR = By.xpath("//XCUIElementTypeTable[@name='unifiedSearchResultsTable']/XCUIElementTypeOther[contains(@name,'Enterprise')]");

	    public By PRESENCES_DETAIL_CONTACT_AUTOMATIC			= By.id("Automatic");
	    public By PRESENCES_DETAIL_CONTACT_AVAILABLE 			= By.id("Available");
	    public By PRESENCES_DETAIL_CONTACT_BUSY 				= By.id("Busy");
	    public By PRESENCES_DETAIL_CONTACT_Away 				= By.id("Away");
	    public By PRESENCES_DETAIL_CONTACT_DO_NOT_DISTURB 		= By.id("Do not disturb");
	    public By PRESENCES_DETAIL_CONTACT_OUT_OF_OFFICE 		= By.id("Out of office");
	    public By PRESENCES_DETAIL_CONTACT_ON_A_CALL			= By.id("On a call");
	    
	    public By PRESENCES_DETAIL_BACK_BTN						=By.id("Back");
	    public By PRESENCES_DETAIL_DONE_BTN						=By.id("Done");
	    public By PRESENCES_DETAIL					= By.xpath("//XCUIElementTypeButton[@name='Presence']");
	    //public By PRESENCES_DETAIL					= By.id("Presence");
	    public By DETAIL_CONTACT_STATUS				= By.xpath("//XCUIElementTypeButton[@name='More Info']/preceding-sibling::XCUIElementTypeStaticText");
		public By messagesScreenConversationNameLocators(String conversationName)			{	return By.name(conversationName);}
		
		public By conversationDetailScreenTextMessageLocator(String textMessage)			
		{	return By.xpath("//XCUIElementTypeTextView[contains(@value,'" +textMessage+ "')]");}
		public By conversationDetailScreenTextMessageUrlLocator(String textMessage)			
		{	return By.xpath("//XCUIElementTypeLink[contains(@name,'" +textMessage+ "')]");}
		public By conversationDetailScreenTextMessageLink(String link)			
		{	return By.xpath("//XCUIElementTypeLink[@label='" + link + "']");}
		
		public By CONVERSATION_DETAILS_SCREEN_MSG_TXT							=	By.id("ammMsgTextField");
		public By CONVERSATION_DETAILS_SCREEN_SEND_BTN							=	By.id("ammSendButton");
		public By CONVERSATION_DETAILS_SCREEN_SUBJECT_TITLE_TXT									=	By.id("ammSubjectTitle");
		public By CONVERSATION_DETAILS_SCREEN_LEAVE_CONVERSATION_BTN							=	By.id("Leave Conversation");
		public By CONTACT_SCREEN_ADD_BTN = By.id("addChatCallConatctButton");
		public By CONTACT_SCREEN_NEW_CONTACT_BTN = By.id("New Contact");
		public By ADD_CONTACT_SCREEN_FIRST_NAME_TXT = By.id("firstNameTextField");
		public By ADD_CONTACT_SCREEN_LAST_NAME_TXT = By.id("lastNameTextField");
		public By ADD_CONTACT_SCREEN_PHONE_TXT = By.xpath("//XCUIElementTypeTextField[contains(@value,'Number')]");
		    
		public By ADD_CONTACT_SCREEN_ADDRESS_TXT = By.xpath("//XCUIElementTypeTextField[contains(@value,'Address')]");
		
}
