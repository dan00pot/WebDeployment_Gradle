package libs.clients;

import org.openqa.selenium.By;

public class SMGR8Locators {

	//###########################################################################################################################
	//########################################LOCATOR OF WEB ELEMENTS IN LOG-IN PAGE OF SMGR for AWS-AADS test#####################################
	//###########################################################################################################################

	/*	
	public By LOGIN_PAGE_USERNAME_TXT										=	By.xpath("//*[@id='IDToken1']");
	public By LOGIN_PAGE_PASSWORD_TXT										=	By.xpath("//*[@id='IDToken2']");
	public By LOGIN_PAGE_SUBMIT_BTN											=	By.xpath("//*[@id='SubmitButton']");
	*/
	//*[@name = 'IDToken2' and @class='input_text']

	//public By LOGIN_PAGE_USERNAME_TXT										=	By.xpath("//*[@id='j_username']");
	//public By LOGIN_PAGE_PASSWORD_TXT										=	By.xpath("//*[@id='j_password']");
	//public By LOGIN_PAGE_USERNAME_TXT										=	By.xpath("//*[@name = 'IDToken1' and @class='input_text']");
	//public By LOGIN_PAGE_PASSWORD_TXT										=	By.xpath("//*[@name = 'IDToken2' and @class='input_text']");
	//public By LOGIN_PAGE_USERNAME_TXT										=	By.xpath("//*[@id='j_username']");
	//public By LOGIN_PAGE_PASSWORD_TXT										=	By.xpath("//*[@id='j_password']");
	//public By LOGIN_PAGE_USERNAME_TXT										=	By.xpath("//*[@name = 'IDToken1' and @class='input_text']");
	//public By LOGIN_PAGE_PASSWORD_TXT										=	By.xpath("//*[@name = 'IDToken2' and @class='input_text']");

	//*[@name = 'IDToken2' and @class='input_text']//a[contains(text(),'Users')]

	
		
	//###########################################################################################################################
	//########################################LOCATOR OF WEB ELEMENTS IN MAIN PAGE OF AADS#####################################
	//###########################################################################################################################
		
	public By mainPageGroupFeaturesLocators(String groupName) {				
		return By.cssSelector("div[class *= 'Tree'] div[id *= '-" + groupName +"-content']");}
		

		
		
	public By USERS_TAB													= By.xpath("//div[@id='smgr-dashboard-header']//div[3]//div[1]");
	public By MAIN_PAGE_USER_MANAGEMENT									= By.xpath("//div[contains(text(),'User Management')]");
	public By MAIN_PAGE_REPLICATION										= By.xpath("//li[contains(text(),'Replication')]");	
	
	//###########################################################################################################################
	//########################################LOCATOR OF WEB ELEMENTS IN USER MANAGEMENT PAGE####################################
	//###########################################################################################################################
		
		public By USER_MANAGEMENT_PAGE_MANAGE_USER							= By.xpath("//*[@id='id_Users/UserManagement/ManageUsers']//li");
		public By USER_MANAGEMENT_PAGE_IFRAME								=	By.xpath("//*[@id='iframe0']");
	
//	public By USER_MANAGEMENT_PAGE_FILTER_ENABLE_BTN						=	By.xpath("//*[@id='table_1_enableFiltering']");
//	public By USER_MANAGEMENT_PAGE_SIP_FILTER_TXT							=	By.xpath("//*[@id='user_e146_handle_name_filter']");
//	public By USER_MANAGEMENT_PAGE_APPLY_FILTER_BTN							=	By.xpath("//*[@id='table_1_filterColumns']");
	
	public By USER_MANAGEMENT_PAGE_FILTER_ENABLE_BTN						=	By.xpath("//li[contains(text(),'Advanced Search']");
	
	public By USER_MANAGEMENT_PAGE_APPLY_FILTER_BTN						=	By.xpath("//li[contains(text(),'Apply Filter']");
	
	public By USER_MANAGEMENT_PAGE_SELECT_USER_BTN							=	By.xpath("//*[@id='table_1:0']");
	public By userManagePageActionbuttonLocators (String action)			{	return By.xpath("//button[text()='"+action+"']");};
	
	public By USER_MANAGEMENT_PAGE_STATUS_BTN								=	By.xpath("//*[@id='statusIcon']/a[2]/span");
	public By USER_MANAGEMENT_PAGE_STATUS_SUCESSFULLY_TXT					=	By.xpath("//span[contains(text(),'User updated successfully.')]");
	//###########################################################################################################################
	//########################################LOCATOR OF WEB ELEMENTS USER INFORMATIOM PAGE######################################
	//###########################################################################################################################
	
	public By VIEW_USER_PAGE_SM_PRIMARY_TXT									=	By.xpath("//*[@id='asm_inputAsm1']");
	public By VIEW_USER_PAGE_SM_SECONDARY_TXT								=	By.xpath("//*[@id='asm_inputAsm2']");
	public By VIEW_USER_PAGE_SIP_PHONE_NUMBER_TXT							=	By.xpath("//*[@id='extn']");
	
	//public By EDIT_USER_PAGE_COMMIT_BTN									=	By.xpath("//button[text()='Commit']");
	public By EDIT_USER_PAGE_COMMIT_BTN										=	By.xpath("//*[@id='btn_bottom1']");
	public By EDIT_USER_PAGE_CANCEL_BTN										=	By.xpath("//*[@id='btn_bottom2']");
	
	public By USER_INFORMATION_CONTACTS_TAB									=	By.xpath("//div[text()='Contacts']");
	//public By USER_INFORMATION_CONTACTS_TAB									=	By.xpath("//*[@id='avTabs0']/ul/li[4]/a");
	public By USER_INFORMATION_IDENTITY_TAB									=	By.xpath("//*[@id='avTabs0']/ul/li[1]/a");
	public By USER_INFORMATION_COMMUNICATION_PROFILE_TAB					=	By.xpath("//*[@id='avTabs0']/ul/li[2]/a");
	
	//###########################################################################################################################
	//########################################LOCATOR OF PRESENCE PROFILE ELEMENT USER INFORMATIOM PAGE######################################
	//###########################################################################################################################
		
	public By EDIT_USER_PRESENCE_PROFILE_CHECKBOX							=	By.xpath("//span[text()='Presence Profile']/../..//*[@type='checkbox']");
	public By EDIT_USER_PRESENCE_SYSTEM_DROPLIST							=	By.xpath("//*[@id='selectOnePresenceServer']");
	public By EDIT_USER_IM_GATEWAY_DROPLIST									=	By.xpath("//*[@id='selectOneImGatewaySipEntity']");
	
	

	//###########################################################################################################################
	//########################################LOCATOR OF USER INFORMATION PAGE######################################
	//###########################################################################################################################
			
	public By USER_INFORMATION_CONTACTS_TAB_ADD_BTN									=	By.xpath("//*[@id='btnAddContactMember']");
	public By USER_INFORMATION_CONTACTS_TAB_REMOVE_BTN								=	By.xpath("//*[@id='btnRemoveContactMember']");
	public By USER_INFORMATION_CONTACTS_TAB_EDIT_BTN								=	By.xpath("//*[@id='btnEditContactMember']");

	
	public By USER_INFORMATION_CONTACTS_TAB_ADD_USER_CONTACT_USER_CHECKBOX			=	By.xpath("//*[@id='publicContactsTable:0']");
	public By USER_INFORMATION_CONTACTS_TAB_ADD_SELECT_BTN							=	By.xpath("//*[@id='btn_select1']");
	
	
	public By userInformationContactsTabRemoveContactCheckboxLocator (String user)			{	return By.xpath("//span[text()='"+user+"']//..//..//*[@type='checkbox']");};
	
	
	public By userSearchFilteringTxt 		(String name)			{	return By.xpath("//input[@title='Enter "+ name +" for Filtering']");};

		
	//###########################################################################################################################
		//########################################LOCATOR OF WEB ELEMENTS IN LOG-IN PAGE OF SMGR - VMWare#####################################
		//###########################################################################################################################

		
		public By LOGIN_PAGE_USERNAME_TXT										=	By.xpath("//*[@id='IDToken1']");
		public By LOGIN_PAGE_PASSWORD_TXT										=	By.xpath("//*[@id='IDToken2']");	
		//public By LOGIN_PAGE_USERNAME_TXT										=	By.xpath("//*[@id='j_username']");
		//public By LOGIN_PAGE_PASSWORD_TXT										=	By.xpath("//*[@id='j_password']");

			
		public By LOGIN_PAGE_SUBMIT_BTN											=	By.xpath("//*[@id='SubmitButton']");
		
		
		public By LOGOFF_PAGE													=	By.xpath("//*[@id='logoff']");
		public By USER_DELETE_CONFIRMATION										= 	By.xpath("//*[@id='deleteButtonBottom']");
		public By MORE_ACTION													=	By.xpath("//*[@id='dropDownButton_button']");
		//public By SHOW_DELETED_USERS											= 	By.xpath("//*[@title='Show Deleted Users']");
		public By SHOW_DELETED_USERS											= 	By.xpath("//a[@title='Show Deleted Users']");
		//public By SHOW_DELETED_USERS											= 	By.xpath("//div[contains(@style,'visible')]//*[@title='Show Deleted Users']/..");
		public By SHOW_DELETED_USERS2											=	By.xpath("//td[@class='r1_dropdown_data_col_onmouseover']/a[@title='Show Deleted Users']");
		public By DELETE_USER_HARD												=   By.xpath("//*[@id='deleteButtonTop']");
		//###########################################################################################################################
		//########################################LOCATOR OF CREATE USERS SITE#####################################
		//###########################################################################################################################
		public By USER_LASTNAME													= By.xpath("//*[@id='inputcommonName1']");
		public By USER_FIRSTNAME												= By.xpath("//*[@id='inputUserId']");
		public By USER_LOGINNAME												= By.xpath("//*[@id='textLogin']");
		public By USER_PASSWORD													= By.xpath("//*[@id='newPassword']");
		public By USER_REPASSWORD												= By.xpath("//*[@id='confrmPassword']");
		public By PROFILE_PASSWORD												= By.xpath("//*[@id='exsisitingCommPassword']");
		public By PROFILE_REPASSWORD											= By.xpath("//*[@id='confirmComprofilePassword']");
		public By CREATE_PROFILE_PWD_BTN										= By.xpath("//*[@id='btnGenerateCommProfilePassword']");
		public By USER_ADDRESS_BTN												= By.id("btn_addCP");
		public By USER_SIP_NUMBER												= By.id("cq_handle");
		public By USER_CA_TYPE_LIST												= By.id("cp_Type");
		public By USER_CA_DOMAIN_LIST											= By.id("cp_domains");
		public By USER_CA_DOMAIN_NAME											= By.id("cq_domainName");
		public By USER_CA_ADD_BTN												= By.id("btn_CreateHandle");
		public By USER_SM_BTN													= By.id("subSectionBoolean0_1_0_1");
		public By USER_CM_BTN													= By.id("subSectionBoolean0_1_0_3");
		public By USER_SM_VALUE													= By.id("asm_inputAsm1");
		public By USER_MAX_DEVICE_LIST											= By.xpath("//label[contains(text(),'Max. Simultaneous Devices')]//..//../..//td[2]/table");
		public By USER_HOME_LOCATION											= By.id("asm_inputLocation");
		public By USER_CM_VALUE													= By.id("cmList");
		public By USER_EXTENSION												= By.id("extn");
		public By USER_TEMPLATES												= By.id("templateList");
		public By USER_SUBMIT_BTN												= By.id("btn_top1");
		public By GROUP_REPLICA													= By.xpath("//a[contains(text(),'UCAppsServer_70')]");
		public By SERVER_STATUS													= By.xpath("//a[contains(text(),'amm249195.aam1.com')]//..//../TD[4]");
		
}
