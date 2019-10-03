package libs.clients;

import org.openqa.selenium.By;

public class WindowsClientLocators {

	public By SEARCH_TEXT_BOX = By.xpath("//*[@ClassName='TextBox']");
	public By SEARCH_CONTACT_ENTERPRISE_CONTACT_TITLE_BAR = By.xpath("//*[contains(@Name,'ENTERPRISE')]");
	public By search_contact_enterprise_result (String name) {
		return By.xpath("//*[contains(@Name,'ENTERPRISE')]//following-sibling::*[contains(@Name,'Search Results')]/*[contains(@Name,'Avaya.UCC.ViewModels.DashboardTabContents.Contacts.ContactViewModel')]/*[contains(@Name,'"+name+"')]");
	}
	
	public By WAITING_CREEN_WHEN_LAUNCH_APP							=	By.id("SplashScreen");
	public By FIRST_WINDOWS											=	By.xpath("//*[@AutomationId='SettingsAutoConfigWindow']");
	public By FIRST_WINDOWS_SETTING_BTN								=	By.xpath("//*[@AutomationId='AutoConfigOpenSettingsButton']");
	
	public By FIRST_WINDOWS_SETTING_MANUALLY_CONF_BTN				=	By.name("MANUALLY CONFIGURE");
	public By FIRST_WINDOWS_SETTING_USE_WEB_BTN						=	By.name("Use web address");
	public By FIRST_WINDOWS_SETTING_MANUALLY_CONFIGURE_BTN			=	By.name("Manually configure (Expert mode)");
	
	public By FIRST_WINDOWS_SETTING_USE_WEB_TXT						=	By.xpath("//*[@AutomationId='LoginUsernameFieldText']");
	public By FIRST_WINDOWS_SETTING_USE_WEB_USER_TXT				=	By.xpath("//*[@AutomationId='LoginUsernameFieldText']");
	public By FIRST_WINDOWS_SETTING_USE_WEB_PWD_TXT					=	By.xpath("//*[@AutomationId='PasswordBox']");  
	public By FIRST_WINDOWS_SETTING_USE_WEB_NEXT_BTN				=	By.name("NEXT");
	
	public By FIRST_WINDOWS_SIGN_IN_BTN								= 	By.name("SIGN IN");
	
	public By WELCOME_SKIP_TUTORIAL_BTN								= 	By.name("SKIP TUTORIAL");
	
	public By FIRST_SCREEN_SETTING_BTN							=	By.name("Configure my account");
	
	public By CONTACT_TAB_SCREEN_ADD_CONTACT_BTN				=	By.name("Create New Contact");
	public By ADD_CONTACT_SCREEN_FISRT_NAME_TXT					=	By.xpath("//*[@AutomationId = 'FirstNameTextBox']");
	//public By ADD_CONTACT_SCREEN_LAST_NAME_TXT					=	By.name("Last Name");
	public By ADD_CONTACT_SCREEN_LAST_NAME_TXT					=	By.xpath("//*[@Name='Last Name']/..");
	//public By ADD_CONTACT_SCREEN_COMPANY_TXT					=	By.name("Company");
	public By ADD_CONTACT_SCREEN_COMPANY_TXT					=	By.xpath("//*[@Name='Company']/..");
	public By ADD_CONTACT_SCREEN_DONE_BTN						=	By.name("DONE");
	//public By ADD_CONTACT_SCREEN_EDIT_BTN						=	By.name("Edit");
	public By ADD_CONTACT_SCREEN_EDIT_BTN						=	By.xpath("//*[@Name='Edit']//*[@Name='Edit']");
	public By ADD_CONTACT_SCREEN_NUMBER_PHONE_TXT				=	By.xpath("//*[@AutomationId = 'PhoneNumberPlaceholder']/..");
	//public By ADD_CONTACT_SCREEN_AMM_ADDRESS_TXT				=	By.id("PART_TextBoxEx");
//	public By ADD_CONTACT_SCREEN_AMM_ADDRESS_TXT				=	By.xpath("//*[@AutomationId = 'PART_TextBoxEx'][2]");
	public By ADD_CONTACT_SCREEN_AMM_ADDRESS_TXT				=	By.xpath("//*[@AutomationId = 'PART_TextBoxEx']");
	public By ADD_CONTACT_SCREEN_EMAIL_ADDRESS_TXT				=	By.xpath("//*[@AutomationId = 'EmailPlaceholder']/..");

	public By ADD_CONTACT_SCREEN_ADD_CONTACT_BTN				=	By.name("Add Contact");
	public By ADD_CONTACT_SCREEN_CANCEL_CONTACT_BTN				=	By.id("CancelAddContactButton");
	public By ADD_CONTACT_SCREEN_ADD_CONTACT_PLUS_BTN			=	By.name("Add New Contact");
	public By ADD_CONTACT_SCREEN_VERTICAL_SMALL_INCREASE_BTN	=	By.xpath("//*[@AutomationId='VerticalSmallIncrease']");	

	public By CONTACT_TAB_SCREEN_SEARCH_CONTACT_TXT				=	By.className("TextBlock");
	
	public By CONTACT_BUBBLE									=	By.id("ContactsStatusChatButton");
	public By CONTACT_BUBBLE_IN_CONTACT_DETAILS
	= 	By.xpath("//*[@Name = 'Send a Message' and @LocalizedControlType = 'group']//*[@ClassName = 'Button' and @LocalizedControlType = 'button'][3]");
	public By CONTACT_DETAIL_BTN (String user)					{ return By.id("ContactDetailsButton(" + user + ")");}
	public By CONTACT_OPEN_CONTACT_DETAILS						=	By.name("Open Contact Details");
	
	public By CONTACT_IN_CONTACT_LIST(String user) {
		return By.xpath("//*[@AutomationId='ContactsListBox']//*[@Name='"+user+"']");
	}
	//public By CONTACT_BUBBLE_START_NEW_CONVERSATION 			= 	By.xpath("//*[@Name='Start New Conversation']/..");
	//public By CONTACT_BUBBLE_START_NEW_CONVERSATION 			= 	By.xpath("//*[@ClassName='Button']/*[@Name='Start New Conversation']");
	//public By CONTACT_BUBBLE_CONTINUE_EXISTING_CONVERSATION 	= 	By.name("Continue Existing Conversation");
	public By CONTACT_BUBBLE_CONTINUE_EXISTING_CONVERSATION(String convName) 	{ return 	By.name(convName);}
//	public By CONTACT_BUBBLE_CONTINUE_EXISTING_CONVERSATION(String convName) 	{ return 	By.xpath("//*[@Name='" + convName + "']");}
	//public By CONTACT_BUBBLE_START_NEW_CONVERSATION 			= 	By.name("Start New Conversation");
	//public By CONTACT_BUBBLE_START_NEW_CONVERSATION 			= 	By.id("StartNewConversationTextBlock");/*[contains(@Name,'Start New Conversation')]
	//public By CONTACT_BUBBLE_START_NEW_CONVERSATION 			= 	By.xpath("//*[@ClassName='Popup']/*[@ClassName='Button'][2]");
	public By CONTACT_BUBBLE_START_NEW_CONVERSATION 			= 	By.name("WORK");
	//===============================================================NEW KEYWORDS=================================================
	//Huy Dao
	public By SETTING_WINDOWS_ACCOUNT_SETTING_TOGGLE_SWITCH 		=	By.id("OnOffSettingToggleSwitchButton");
	public By SETTING_WINDOWS_LDAP_SERVER = By.id("LdapServerAddressAutomationIdTextSettingTextBox");
	public By SETTING_WINDOWS_LDAP_PORT = By.id("LdapPortAutomationIdNumericSettingTextBox");
/*	public By SETTING_WINDOWS_SERVER_ADDRESS (String server)
	{return By.xpath("//*[@Previous='Server Address']");}
	
	public By SETTING_WINDOWS_SERVER_PORT (String port)
	{return By.xpath("//*[contains(@Name,'"+port+"')]/[contains(@Previous,'Server Port')]");}
	*/
	
	
	public By SETTING_WINDOWS_CLOSE_BTN = By.xpath("//*[contains(@Name,'Avaya Engage Settings')]/*[contains(@Name,'Close Window')]");
	
	
	public By SEARCH_ENTERPRISE_DIRECTORY_RESULT (String name){
	return By.xpath("//*[contains(@Name,'Search Results')]/*[contains(@Name,'Avaya.UCC.ViewModels.DashboardTabContents.Contacts.ContactViewModel')]/*[contains(@Name,'"+name+"')]")
			;}
	
	
	public By CONTACT_LIST_CONTACT_NAME (String name){
		return By.xpath("//*[contains(@Name,'Contact list')]//*[contains(@Name,'"+name+"')]");
	}
	
	public By FAVORITE_LIST_CONTACT_NAME (String name){
		return By.xpath("//*[contains(@Name,'Favorites list')]//*[contains(@Name,'"+name+"')]");
	}
	
	public By CONTACT_LIST_CONTACT_STATUS (String name){
		return By.xpath("//*[contains(@Name,'Contact list')]//*[contains(@Name,'"+name+"')]/*[@AutomationId = 'ContactsStatusTextBlock']");
	}
	
	public By CONTACT_LIST_CONTACT_DETAIL (String name){
		return By.id("ContactDetailsButton("+name+")");
		//return By.xpath("//*[contains(@Name,'"+name+"')]//*[contains(@Name,'Details')]");
		
	}
	
	public By CONTACT_LIST_REMOVE_CONTACT = By.name("Remove contact");
	public By CONTACT_LIST_REMOVE_CONTACT_CONFIRM_YES = By.name("Yes");
//	public By CONTACT_LIST_CANCLE_SEARCH_BTN	=	By.id("UnifiedSearchCancelButton");
	public By CONTACT_LIST_CANCLE_SEARCH_BTN = By.name("Cancel");
//	public By CONTACT_LIST_CANCLE_SEARCH_BTN = By.xpath("//*[@Name='Cancel']");
	
	public By CALL_HISTORY_CONTACT_NAME = By.name("name");
	
	
	
	public By CALL_HISTORY_CONTACT_NAME (String name){
	return By.xpath("//*[contains(@Name,'Avaya.UCC.ViewModels.DashboardTabContents.CallHistory')]/*[contains(@Name,'"+name+"')]");
	}
	
	
	public By settingWindowsTabLocators(String tabName)									{	return By.name(tabName);}
	public By settingWindowsOptionsInsideTabLocators(String option) 					{	return By.name(option);}
	public By SETTING_WINDOWS_BACK_BTN													=	By.name("Back");
	public By SETTING_WINDOWS_DONE_BTN													=	By.name("DONE");//"Close Window"
	public By SETTING_WINDOWS_UPDATE_BTN												=	By.name("UPDATE");
	public By SETTING_WINDOWS_OK_BTN													=	By.name("OK");
	
	public By SETTING_WINDOWS_SUPPORT_TAB_CLEAR_ALL_SETTING_BTN							=	By.name("Reset Application");
	public By SETTING_WINDOWS_SUPPORT_TAB_CLEAR_ALL_SETTING_CONFIRM_BTN					=	By.name("Clear");
	
	public By SETTING_WINDOWS_SERVICES_OK_BTN											=	By.xpath("//*[@Name = 'OK' and @LocalizedControlType = 'text']");
	public By SETTING_WINDOWS_SERVICES_UPDATE_BTN										=	By.xpath("//*[@Name = 'Update' and @LocalizedControlType = 'button']");
	public By SETTING_WINDOWS_SERVICES_CANCEL_BTN										=	By.xpath("//*[@Name = 'Cancel' and @LocalizedControlType = 'button']");
	public By SETTING_WINDOWS_SERVICES_CHECK_STATUS(String num)							{	return	By.xpath("//*[@Name = '"+ num+"' and @LocalizedControlType = 'text']");}
	
	public By SETTING_WINDOWS_SERVICES_TAB_REFESH_AUTOCONFIGURE							=	By.xpath("//*[@Name = 'Refresh Auto Configuration' and @LocalizedControlType = 'button']");
	public By SETTING_WINDOWS_SERVICES_TAB_AUTO_CONFIGURE_BTN							=	By.name("Auto configure");
	public By SETTING_WINDOWS_SERVICES_TAB_SHOW_DETAILS_BTN								=	By.name("Show Details");
	public By SETTING_WINDOWS_SERVICES_TAB_PHONE_SERVICES_SV_ADDRESS_TXT				=	By.id("SipServerAddressTextSettingTextBox");
	public By SETTING_WINDOWS_SERVICES_TAB_PHONE_SERVICES_DOMAIN_TXT					=	By.id("SipDomainTextSettingTextBox");
	public By SETTING_WINDOWS_SERVICES_TAB_PHONE_SERVICES_SV_PORT_TX					=	By.id("SipServerPortNumericSettingTextBox");
	public By SETTING_WINDOWS_SERVICES_TAB_MM_ON_OFF_TOGGLE								=	By.id("OnOffSettingToggleSwitchButton");
	public By SETTING_WINDOWS_SERVICES_TAB_MM_SV_ADDRESS_TXT							=	By.id("AmmServerAddressTextSettingTextBox");
	public By SETTING_WINDOWS_SERVICES_TAB_MM_SV_PORT_TXT								=	By.id("AmmPortNumericSettingTextBox");
	public By SETTING_WINDOWS_SERVICES_TAB_MM_TIME_POLLING_INTERVAL_COMBO_BOX_BTN		=	By.id("RefreshTimeListSettingComboBox");
	public By SETTING_WINDOWS_SERVICES_TAB_MM_TIME_POLLING_INTERVAL_LIST1				=	By.id("RefreshTimeListSettingComboBoxItem1"); //continuous
	public By SETTING_WINDOWS_SERVICES_TAB_MM_TIME_POLLING_INTERVAL_LIST2				=	By.id("RefreshTimeListSettingComboBoxItem2"); //1 minute
	public By SETTING_WINDOWS_SERVICES_TAB_MM_TIME_POLLING_INTERVAL_LIST3				=	By.id("RefreshTimeListSettingComboBoxItem3"); //2 minutes
	public By SETTING_WINDOWS_SERVICES_TAB_MM_TIME_POLLING_INTERVAL_LIST4				=	By.id("RefreshTimeListSettingComboBoxItem4"); //5 minutes
	public By SETTING_WINDOWS_SERVICES_TAB_MM_TIME_POLLING_INTERVAL_LIST5				=	By.id("RefreshTimeListSettingComboBoxItem5"); //15 minutes
	public By SETTING_WINDOWS_SERVICES_TAB_MM_TIME_POLLING_INTERVAL_LIST6				=	By.id("RefreshTimeListSettingComboBoxItem6"); //60 minutes
	
	public By SETTING_WINDOWS_ACCOUNT_TAB_COMMUNICATOR_USERNAME_TXT						=	By.id("CommunicatorUsernameAutomationIdTextSettingTextBox");
	public By SETTING_WINDOWS_ACCOUNT_TAB_COMMUNICATOR_PASSWORD_TXT						=	By.id("CommunicatorPasswordAutomationId");
	public By SETTING_WINDOWS_ACCOUNT_TAB_PHONE_EXTENSION_TXT							=	By.id("SipExtensionAutomationIdTextSettingTextBox");
	public By SETTING_WINDOWS_ACCOUNT_TAB_PHONE_PASSWORD_TXT							=	By.id("SipPasswordAutomationId");
	public By SETTING_WINDOWS_ACCOUNT_TAB_SIGN_OUT_BTN									=	By.name("SIGN OUT");
	
	
	public By MAIN_WINDOWS_TITLE									=	By.id("DefaultWindowTitleTemplate");
	//public By MAIN_WINDOWS_OPEN_SETTING_BTN							=	By.id("DashboardOpenSettingsButton");
	public By MAIN_WINDOWS_OPEN_SETTING_BTN							=	By.name("Options and Settings");
	public By MAIN_WINDOWS_TOP_OF_MIND_BTN							=	By.id("TabBarHomeContentToggleButton");
	public By MAIN_WINDOWS_FAVORITES_BTN							=	By.id("TabBarFavoritesContentToggleButton");
	public By MAIN_WINDOWS_FAVORITES_ICON_ENABLED(String user)	
	{	return By.xpath("//*[@AutomationId='ContactFavoriteButton(" + user + ")' and @HelpText='Remove from Favorites']");}
	public By MAIN_WINDOWS_FAVORITES_ICON_DISABLED(String user)	
	{	return By.xpath("//*[@AutomationId='ContactFavoriteButton(" + user + ")' and @HelpText='Add to Favorites']");}
	//public By MAIN_WINDOWS_CONTACT_BTN								=	By.id("TabBarContactsContentToggleButton");
	public By MAIN_WINDOWS_CONTACT_BTN								=	By.name("Contacts");
	
	public By MAIN_WINDOWS_CONTACT_LIST_BOX								=	By.id("ContactsListBox");

	
	public By MAIN_WINDOWS_HISTORY_BTN								=	By.id("TabBarCallHistoryContentToggleButton");
	public By MAIN_WINDOWS_CALENDAR_BTN								=	By.id("TabBarCalendarContentToggleButton");
	public By MAIN_WINDOWS_CONVERSATIONS_BTN						=	By.id("TabBarConversationsContentToggleButton");
	public By MAIN_WINDOWS_NUMBER_OF_NEW_MSG_BADGE
	=	By.xpath("//*[@AutomationId='TabBarConversationsContentToggleButton']/..//*[@ClassName='NumberBadgeControl']//*[@ClassName='TextBlock']");
	public By MAIN_WINDOWS_AVATAR_BTN								=	By.id("UserDashboardOpenAvatarButton");
	public By MAIN_WINDOWS_CLOSE_AVATAR_BTN								=	By.id("PresencePopupCloseAvatarButton");
	public By MAIN_WINDOWS_SIGN_OUT_TEXT							= 	By.id("PresencePopupLogOutTextBlock");
	public By MAIN_WINDOWS_NEW_CONVERSATION_BTN						= 	By.name("New Conversation");
	public By MAIN_WINDOWS_NEW_CONVERSATION_BUBBLE					=	By.xpath("//*[@HelpText='Message']");
	//public By MAIN_WINDOWS_STATUS_COMBO_BOX = By.xpath("//*[@ClassName='ComboBox']");
	public By MAIN_WINDOWS_STATUS_COMBO_BOX = By.className("ComboBox");
	public By MAIN_WINDOWS_STATUS_AVAILABLE = By.name("Available");
	public By MAIN_WINDOWS_STATUS_AWAY = By.name("Away");
	public By MAIN_WINDOWS_STATUS_BUSY = By.name("Busy");
	public By MAIN_WINDOWS_STATUS_DND = By.name("Do not disturb");
	public By MAIN_WINDOWS_STATUS_OFFLINE = By.name("Offline");
	public By MAIN_WINDOWS_STATUS_OUTOFFICE = By.name("Out of office");
	public By mainwindowsstatus(String status){
		return By.name(status);
	}
	public By mainwindowsstatusSelected(String status) {
		
		return By.xpath("//*[@Name='Avaya.UCC.ViewModels.Presence.PresenceItem']");//*[@Name='"+status+"']/..
	}

//	public By equinoxInTaskbar = By.xpath("//*[@Name = 'Avaya Equinox' and @LocalizedControlType = 'menu item']");
	public By equinoxInTaskbar = By.name("Avaya Equinox - 3 running windows");
	public By equinoxConversationInTaskbar(String convName)	
	{	return By.xpath("//*[@Name = '" + convName + "' and @LocalizedControlType = 'list item']");}
	public By onexInTaskbar = By.xpath("//*[@Name = 'Avaya one-X Communicator' and @LocalizedControlType = 'menu item']");
	public By onexConversationInTaskbar(String convName)	
	{	return By.xpath("//*[@Name = '" + convName + "' and @LocalizedControlType = 'button']");}
	
	public By onexWindowInTaskBar	= By.name("Avaya one-X® Communicator");
	
    public By ACW_LOGIN_DIALOG_TXT_OPEN_CONFIRM_QUESTION = By.name("Other Avaya Equinox instances are detected");
    public By ACW_LOGIN_DIALOG_BTN_YES = By.xpath("//*[@AutomationId='6']");
    public By ACW_LOGIN_DIALOG_BTN_NO = By.xpath("//*[@AutomationId='7']");
    public By mainWindowsContactsTabUserLocators(String user)	
    {	return By.xpath("//*[contains(@Name,'Contact list')]//*[contains(@Name,'"+user+"')]");}
    
	public By mainWindowsContactsTabUserLocatorsAfterSearch(String user)	
	{	return By.xpath("//*[@Name='Search Results']//..//*[@Name='" + user + "']");}

	public By CONTACT_LIST_CONTACT_RESULT (String name){
		return By.xpath("//*[contains(@Name,'CONTACTS')]/following-sibling::*[contains(@Name,'Search Results')]//*[contains(@Name,'Avaya.UCC.ViewModels.DashboardTabContents.Contacts.ContactViewModel')]");
	}
	
	public By conversationWindowsFileNameLocator(String fileName)			
	{	return By.name(fileName);}
	
	
	public By CONVERSATION_WINDOWS_ADD_PARTICIPANTS_USER_ITEM (String user) { return By.xpath("//*[@AutomationId='ContactDisplayName' and @Name='"+user+"']");}
	
	public By CONVERSATION_WINDOWS_MENU_EDIT_SUBJECT_TXT				=	By.id("TextBoxEx");
	public By CONVERSATION_WINDOWS_MENU_EDIT_SUBJECT_DONE_BTN			=	By.name("Done");
	public By CONVERSATION_WINDOWS_TITLE								=	By.id("DefaultWindowTitleTemplate"); // get Name to have displayed title
	public By CONVERSATION_WINDOWS_TEXT_MSG_TXT							=	By.id("MessageRichTextBox");
	public By CONVERSATION_WINDOWS_MSG_BOX								=	By.id("MessagesListBox");
	public By CONVERSATION_WINDOWS_ATTACHMENT_BTN						=	By.id("AddMessageAttachmentDataTemplateContentButton");
	public By CONVERSATION_WINDOWS_ADD_PARTICIPANTS_TXT					=	By.name("Add Participant(s)...");
	public By CONVERSATION_WINDOWS_SEARCH_USER_ADD_TXT					=	By.id("SearchTextBox");
	public By CONVERSATION_WINDOWS_ADD_ITEM_BTN							= 	By.id("ItemButton");
	public By CONVERSATION_WINDOWS_ADD_USER_BTN							=	By.className("ListBoxItem");
	
	public By CONVERSATION_WINDOWS_MENU_BTN								=	By.id("ConversationsWindowMenu");
	public By CONVERSATION_WINDOWS_MENU_LEAVE_CONVERSATION_BTN			=	By.id("ConversationsMenuItemLeaveConversation");
	public By CONVERSATION_WINDOWS_MENU_EDIT_SUBJECT_BTN				=	By.id("ConversationsMenuItemEditSubject");
	public By CONVERSATION_WINDOWS_MENU_PHONE_CALL_MENU_BTN				=	By.id("PhoneCallButton");
	public By CONVERSATION_WINDOWS_MENU_VIDEO_CALL_MENU_BTN				=	By.id("VideoCallButton");
	public By CONVERSATION_WINDOWS_MENU_PHONE_NUMBER_TEXT_BLOCK_BTN		=	By.id("ItemButton");
	public By CONVERSATION_WINDOWS_MENU_PHONE_START_VOICE_CONFERENCE_BTN = By.xpath("//*[@Name='Start a Voice Conference']");
	public By mainWindowsContactsTabUserActionLocators(String action, String user)					{	return By.xpath("//*[contains(@Name,'Contact list')]//*[contains(@Name,'"+user+"')]//*[contains(@Name,'"+action+"')]");}

	
	public By CONVERSATION_WINDOWS_ADD_USER_CONFIRM_ADD_BTN						=	By.name("Add");
	public By CONVERSATION_WINDOWS_ADD_USER_CONFIRM_CANCEL_BTN					=	By.name("Cancel");

	

	//Install  
	  public By DESKTOP_SECURITY_WARNING_RUN_BTN = By.xpath("//*[contains(@Name,'Open File - Security Warning')]//*[contains(@Name,'Run')]");
	  public By DESKTOP_SETUP_WINDOW_INSTALL_BTN = By.xpath("//*[contains(@Name,'Install')]");
	  public By DESKTOP_SETUP_WINDOW_FINISH_BTN = By.xpath("//*[contains(@Name,'Finish')]");
	  public By DESKTOP_SETUP_WINDOW_NEXT_BTN = By.xpath("//*[contains(@Name,'Next')]");
	  
	  public By DESKTOP_SETUP_WINDOW_ACCEPT_CHECKBOX = By.name("I accept the terms in the License Agreement");
	//  public By DESKTOP_SETUP_WINDOW_ACCEPT_CHECKBOX = By.xpath("//*[contains(@Name, 'I accept the terms in the License Agreement')]");//@LocalizedControlType = 'check box' and 
	  public By DESKTOP_SETUP_WINDOW_INSTALL_LOCATOR_TXT = By.xpath("//*[contains(@Name,'WixUI_Bmp_BannerBy.xpath')]");
	  public By DESKTOP_SETUP_WINDOW_RUN_ACW_CHECKBOX = By.xpath("//*[@LocalizedControlType = 'check box' and contains(@Name, 'Run Avaya Equinox')]");
	  
	  
	  //Control Panel\All Control Panel Items\Programs and Features 
	  
	  
	  
	  public By CONTROL_PANEL_AVAYA_EQUINOX_ICON = By.xpath("//*[contains(@Name,'Avaya Equinox')]");
	  public By SETTING_WINDOWS_SUPPORT_TAB_CHECK_UPDATE_BTN = By.xpath("//*[contains(@Name,'Check for Updates')]");
	  public By SETTING_WINDOWS_SUPPORT_TAB_ABOUT_BTN = By.xpath("//*[contains(@Name,'Avaya Engage Settings')]//*[contains(@Name,'Check for Updates')]");
	  public By SETTING_WINDOWS_SUPPORT_TAB_ABOUT_CONTENT = By.xpath("//*[contains(@Name,'Avaya Engage Settings')]//*[@ClassName='RichTextBox']");
	  
	 
	  public By SOFTWARE_UPDATE_WINDOW_SKIP_VERSION_BTN = By.xpath("//*[contains(@Name,'Skip this version')]");
	  public By SOFTWARE_UPDATE_WINDOW_INSTALL_UPDATE_BTN = By.xpath("//*[contains(@Name,'Install update')]");
	  public By SOFTWARE_UPDATE_MAIN_ANNOUNCEMENT_TXT = By.xpath("//*[contains(@Name,'A new version of Avaya Equinox is available')]");
	  public By SOFTWARE_UPDATE_WINDOW_REMIND_LATER_BTN = By.xpath("//*[contains(@Name,'Remind me later')]");
	  public By softwareUpdateContent(String newVersion, String currentVersion) {
		 return By.xpath("//*[contains(@Name,'Avaya Equinox "+newVersion+" is now available (you have "+currentVersion+"). Would you like')]");
		  }
	  public By SOFTWARE_UPDATE_WINDOW_UP_TO_DATE_TXT = By.xpath("//*[contains(@Name,'up to date')]");
	  public By SOFTWARE_UPDATE_WINDOW_NEWEST_VERSION_TXT = By.xpath("//*[contains(@Name,'newest version')]");
	  public By SOFTWARE_UPDATE_WINDOW_CLOSE_BTN = By.xpath("//*[contains(@Name,'Close')]");
	  
	  
	  	//nttruc new
	  	public By CONTACT_ALREADY_EXISTED_ACW			= By.xpath("//*[contains(@Name,'Contact already exists.')]");
	  
	  	public By DESKTOP_COMPUTER = By.name("Computer");
	  	public By DESKTOP_COMPUTER_ADDRESS = By.xpath("//*[@Name = 'Address: This PC']/..");
	  	public By DESKTOP_COMPUTER_ADDRESS_AFTER_CLICK = By.xpath("//*[@Name = 'Address']");
	//    public By DESKTOP_COMPUTER_ADDRESS = By.name("Address: This PC");
	    //public By DESKTOP_COMPUTER_ADDRESS = By.xpath("//*[@Name='Address: Computer']");
	    public By DESKTOP_WINDOWS_BTN_CLOSE = By.name("Close");
	    
		public By MAIN_WINDONS_CONTACT_TAB_POPUP_DISMISS_BTN								=	By.name("Dismiss");
		
	    public By FILE(String name) {
	     	return By.name(name);
	     	
	     }
}

