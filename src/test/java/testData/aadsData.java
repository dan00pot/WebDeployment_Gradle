package testData;

import excel.ExcelData;

public class aadsData {
	ExcelData excelData = new ExcelData();
	ExcelData setting = new ExcelData();
	
	public String lab = excelData.getTestSetting("Setting", 1, 1);
	public String user = excelData.getTestSetting("Setting", 2, 1);

	public String AADS_SERVER = excelData.getLabInfo(lab, 2, 1);

	public String AADS_SERVER_ADDRESS = AADS_SERVER + ":8445/admin";
	public String SM_ADDRESS = excelData.getLabInfo(lab, 5, 1);
	public String SIP_CONTROL_LIST = SM_ADDRESS + ":5061;transport=TLS";
	public String AADS_ADD_CONTACT_USER1_FULL_NAME	= "amm user2";
	public String SMGR_ADDR = excelData.getLabInfo(lab, 4, 1);
	public String SMGR_WEB_ADDR = "https://"+SMGR_ADDR;
	public String SMGR_ADMIN_USR	= "admin";
	public String SMGR_ADMIN_PWD	= "tma_12Tma";
	public String AADS_COMMON_NAME = "aads.aam1.com";

	public String ALIAS = "AADSCluster";
	public String AADS_VERSION = "7.1.3.1.23";
	public String SMGRCA = "smgrca";
	public String WEBLMURL = "https://smgr245146.aam1.com:443/WebLM/LicenseServer";

	public String AADS_ADMIN_ROLE_USER = excelData.getLabInfo(user, 2, 1);
	public String AADS_USER_1_NAME = excelData.getLabInfo(user, 5, 1);
	public String SECURITY_ROLE_USER = excelData.getLabInfo(user, 3, 1);
	public String AADS_USER_NAME = excelData.getLabInfo(user, 5, 1);
	public String AADS_USER_1_NAME_SIP_PHONE = excelData.getLabInfo(user, 6, 1);
	public String AADS_USER_1_STANDARD_CONFIG = excelData.getLabInfo(user, 7, 1);
	public String AADS_USER_1_GROUP_CN = excelData.getLabInfo(user, 8, 1);
	public String AADS_USER_GROUP = excelData.getLabInfo(user, 8, 1);
//	public String AADS_USER_GROUP = "CN=Users,CN=Builtin,DC=aam1,DC=com";
	public String AADS_USER_PWD = "tma_12Tma";
	public int AADS_ADD_PRIVATE_CONTACT_USER1 = 739400;
	
	public String AADS_RETRIEVE_ESMSRVR = "amm25076.aam1.com";

	public String AADS_SERVER_ADDRESS_AUTOCONFIG = AADS_SERVER + ":443/acs/resources/configurations";
	public String AADS_USER_1_GROUP = "USERS";

	public String AADS_VERIFY_SMGR_CONTACT_LIST_ON_SMGR		= "usersmgr";
	public String AADS_ADD_CONTACT_SEARCH_BY_LAST_NAME2		= "71007";
	public String AADS_ADD_CONTACT_USER_2_FULL_NAME			= "AMM 71007";
	//public String SM_ADDRESS = excelData.getLabInfo(lab, 5, 1);
	//public String SIP_CONTROL_LIST = SM_ADDRESS + ":5061;transport=TLS";

	public String SECURITY_ROLE_PWD = "tma_12Tma";


	public String AADS_USER_NAME_SIP_PHONE = "83807";

	// Constant
	public static String AADS_USER_GROUP_INPUT_5_CHARACTER = "AMMUsers"; // AD
																			// 2016

	public String AADS_EMAIL_SEARCH_CRQS = "amm83910@aam1.com";

	public String AADS_USER_PWD_INVALID = "invalidPass";
	public String AADS_USER_PWD_BLANK = "";
	public String AADS_USER_NAME_INVALID = "invalidUser";
	public String AADS_USER_NAME_BLANK = "";

	// Application Property
	public String ADMIN_HTTPSESSION_TIMEOUT = "15";
	public String APPLICATION_HTTPSESSION_TIMEOUT = "15";
	public String MAX_CONCURRENT_HTTP_SESSIONS = "200000";
	public String CONCURRENT_HTTP_SESSIONS_PER_USER = "50";

	// New enterprise directory_2016 data
	public String NEW_ENTERPRISE_DIRECTORY_TYPE = "ActiveDirectory_2016";
	public String NEW_ENTERPRISE_DIRECTORY_PRIORITY = "6";
	public String NEW_ENTERPRISE_DIRECTORY_ADRR = "10.255.253.47";
	public String NEW_ENTERPRISE_DIRECTORY_BINDDN = "adminex16";
	public String NEW_ENTERPRISE_DIRECTORY_PORT = "3268";
	public String NEW_ENTERPRISE_DIRECTORY_BIND_CREDENTIAL = "tma_12Tma";
	public String NEW_ENTERPRISE_DIRECTORY_UID = "sAMAccountName";
	public String NEW_ENTERPRISE_DIRECTORY__BASE_CONTEXT_DN = "dc=aam1,dc=com";
	public String NEW_ENTERPRISE_DIRECTORY__LAST_UPDATE_TIME_ATTRIBUTE_ID = "whenChanged";

	public String AADS_CLUSTER_NODES_CLUSTER = "10.255.250.36";
	public String AADS_CLUSTER_NODES_SINGLE = "10.255.250.72";


	public String CORS_CONFIG_SPECIFIC_DOMAIN = "aam1.com";

	// public String AADS_ADMIN_ROLE_USER = excelData.getLabInfo(user, 2, 1);
	public String AADS_SECURITY_ROLE_USER = excelData.getLabInfo(user, 3, 1);
	public String AADS_AUDITOR_ROLE_USER = excelData.getLabInfo(user, 4, 1);


	public String AADS_ADD_CONTACT_DISPLAY_IN_CONTACT_LIST_1		= "smgr user01";
	public String AADS_ADD_CONTACT_SEARCH_BY_LAST_NAME1				= "user1";
	// public String AADS_USER_2_NAME = dataExcel.getDataFromExcel(user, 8, 1);
	// public String AADS_USER_2_FULL_NAME = dataExcel.getDataFromExcel(user, 9,
	// 1);

	// public String AADS_USER_3_NAME = dataExcel.getDataFromExcel(user, 10, 1);
	// public String AADS_USER_3_FULL_NAME = dataExcel.getDataFromExcel(user,
	// 11, 1);

	public String AADS_APPCAST_FILE_NAME = "Avaya Equinox Setup 3.4.0.146.37";
	public String AADS_APPCAST_FILE_NAME_NEW = "Avaya Equinox Setup 3.4.0.146.37 new";
	public String AADS_APPCAST_VERSION = "3.4.0.146.37";

	public String AADS_GROUP_VIEW = "CN=AMMUsers,OU=Roles,OU=AMM,DC=aam1,DC=com";

	public String User_Switch_ID(int row){try {
		String ID=excelData.getCellFromFreeExcel("C:\\AADS\\AADS_Configuration\\T-test-User.xlsx", "Users", row, 0);
		return ID;
	} catch (Exception e) {
		e.printStackTrace();
		return null;
	}}
	
	public String User_Switch_EXT(int row){try {
		String ID=excelData.getCellFromFreeExcel("C:\\AADS\\AADS_Configuration\\T-test-User.xlsx", "Users",row,1);
		return ID;
	} catch (Exception e) {
		e.printStackTrace();
		return null;
	}}
	
	public String User_Switch_MAIL(int row){try {
		String ID=excelData.getCellFromFreeExcel("C:\\AADS\\AADS_Configuration\\T-test-User.xlsx", "Users",row,2);
		return ID;
	} catch (Exception e) {
		e.printStackTrace();
		return null;
	}}
	
	public String User_Switch_DN(int row){try {
		String ID=excelData.getCellFromFreeExcel("C:\\AADS\\AADS_Configuration\\T-test-User.xlsx", "Users",row,3);
		return ID;
	} catch (Exception e) {
		e.printStackTrace();
		return null;
	}}
	
	
	//user A-Android
	public String User_A_ID =excelData.getCellFromFreeExcel("C:\\AADS\\AADS_Configuration\\T-test-User.xlsx", "Users", 1, 0);
	public String User_A_EXT =excelData.getCellFromFreeExcel("C:\\AADS\\AADS_Configuration\\T-test-User.xlsx", "Users", 1, 1);
	public String User_A_MAIL =excelData.getCellFromFreeExcel("C:\\AADS\\AADS_Configuration\\T-test-User.xlsx", "Users", 1, 2);
	public String User_A_DN =excelData.getCellFromFreeExcel("C:\\AADS\\AADS_Configuration\\T-test-User.xlsx", "Users", 1, 3);
	//user B- Window
	public String User_B_ID =excelData.getCellFromFreeExcel("C:\\AADS\\AADS_Configuration\\T-test-User.xlsx", "Users", 2, 0);
	public String User_B_EXT =excelData.getCellFromFreeExcel("C:\\AADS\\AADS_Configuration\\T-test-User.xlsx", "Users", 2, 1);
	public String User_B_MAIL =excelData.getCellFromFreeExcel("C:\\AADS\\AADS_Configuration\\T-test-User.xlsx", "Users", 2, 2);
	public String User_B_DN =excelData.getCellFromFreeExcel("C:\\AADS\\AADS_Configuration\\T-test-User.xlsx", "Users", 2, 3);
	//user C iOS
	public String User_C_ID =excelData.getCellFromFreeExcel("C:\\AADS\\AADS_Configuration\\T-test-User.xlsx", "Users", 3, 0);
	public String User_C_EXT =excelData.getCellFromFreeExcel("C:\\AADS\\AADS_Configuration\\T-test-User.xlsx", "Users", 3, 1);
	public String User_C_MAIL =excelData.getCellFromFreeExcel("C:\\AADS\\AADS_Configuration\\T-test-User.xlsx", "Users", 3, 2);
	public String User_C_DN =excelData.getCellFromFreeExcel("C:\\AADS\\AADS_Configuration\\T-test-User.xlsx", "Users", 3, 3);
	//user D Mac
	public String User_D_ID =excelData.getCellFromFreeExcel("C:\\AADS\\AADS_Configuration\\T-test-User.xlsx", "Users", 4, 0);
	public String User_D_EXT =excelData.getCellFromFreeExcel("C:\\AADS\\AADS_Configuration\\T-test-User.xlsx", "Users", 4, 1);
	public String User_D_MAIL =excelData.getCellFromFreeExcel("C:\\AADS\\AADS_Configuration\\T-test-User.xlsx", "Users", 4, 2);
	public String User_D_DN =excelData.getCellFromFreeExcel("C:\\AADS\\AADS_Configuration\\T-test-User.xlsx", "Users", 4, 3);
	
}
