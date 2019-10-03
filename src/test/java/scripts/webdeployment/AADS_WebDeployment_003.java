package scripts.webdeployment;

import static org.junit.Assert.fail;

import libs.clients.WindowsClientKeywords;
import libs.common.DriverManagement;
import libs.common.Selenium;
import libs.clients.AADSWebKeywords;
import testData.*;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.winium.WiniumDriver;

import io.appium.java_client.windows.WindowsDriver;


public class AADS_WebDeployment_003 {

	static WebDriver webDriver;
	static WiniumDriver winClientDriver;
	static WindowsDriver<?> windowsDriver;
	static WindowsDriver<?> windowsDriverRoot;
	WindowsClientKeywords winClient = new WindowsClientKeywords();
	AADSWebKeywords AADSWebDriver = new AADSWebKeywords();
	Selenium selenium = new Selenium();
	DriverManagement driverMgnt = new DriverManagement();
	aadsData aadsData = new aadsData();
	
	final static Logger logger = LogManager.getLogger("AADS_WebDeployment_001");

	@Before
	public void beforetestAADS_WebDeployment_003() throws Exception {
		logger.info("beforetest AADS_WebDeployment_003 starting...\n");
		webDriver = driverMgnt.createChromeDriver();
		windowsDriverRoot = driverMgnt.createWinAppDriver("http://10.255.249.9:4724");
		logger.info("beforetest AADS_WebDeployment_003 completed...\n");
	}
	

	@Test 
	public void AADS_WebDeployment_003 () throws Exception {
		logger.info("AADS_WebDeployment_003 - starting...\n");
		try {
			webDriver.get(aadsData.AADS_SERVER_ADDRESS);
			AADSWebDriver.loginAADSMainPage(webDriver, aadsData.AADS_ADMIN_ROLE_USER, aadsData.AADS_USER_PWD);
			AADSWebDriver.navigateToFeaturesPage(webDriver, "Web Deployment");
			AADSWebDriver.navigateToFeaturesPage(webDriver, "Deployment");
			//AADSWebDriver.deploymentPageAddAppcastItem(webDriver,"Avaya Communicator ",aadsData.AADS_APPCAST_FILE_NAME,aadsData.AADS_APPCAST_FILE_NAME,aadsData.AADS_APPCAST_VERSION,"windows",aadsData.AADS_USER_1_NAME, aadsData.AADS_USER_PWD,"https://aads25036.aam1.com:8442/acs/resources/webdeployment/downloads/AvayaEquinox22.msi");
			
			selenium.switchToDefaultContent(webDriver);
			
			AADSWebDriver.navigateToFeaturesPage(webDriver, "Dynamic Configuration");
			AADSWebDriver.navigateToFeaturesPage(webDriver, "Configuration");
			
			AADSWebDriver.configurationPageSelectConfigurationUser(webDriver, aadsData.AADS_USER_1_NAME_SIP_PHONE);
			AADSWebDriver.configurationPageSettingVariable(webDriver, "Platform", "APPCAST_ENABLED", true, "1");
			AADSWebDriver.configurationPageSettingVariable(webDriver, "Platform", "APPCAST_URL", true, "https://aads25036.aam1.com:8442/acs/resources/webdeployment/");
			AADSWebDriver.configurationPagePublishFlatformOnly(webDriver, "Windows");
			webDriver.close();
			
			winClient.installEquinoxforWindows(windowsDriverRoot, "C:\\AADS\\AADS_TestingFiles", "AvayaEquinox22.msi");
			Thread.sleep(8000);
			winClient.autoConfigLogin(windowsDriverRoot, "https://aads25036.aam1.com:443/acs/resoucres/configuration", "ammuser2", "tma_12Tma");

			winClient.openSettingWindows(windowsDriverRoot);
			winClient.settingWindowsMainClickOnTab(windowsDriverRoot, "Support");
			Thread.sleep(1000);
			
			winClient.verifyEquinoxUpdateAvailable(windowsDriverRoot, "3.4.0.102", "3.4.0.110");
			
			webDriver = driverMgnt.createChromeDriver();
			webDriver.get(aadsData.AADS_SERVER_ADDRESS);
			AADSWebDriver.loginAADSMainPage(webDriver, aadsData.AADS_ADMIN_ROLE_USER, aadsData.AADS_USER_PWD);
			AADSWebDriver.navigateToFeaturesPage(webDriver, "Web Deployment");
			AADSWebDriver.navigateToFeaturesPage(webDriver, "Deployment");
			AADSWebDriver.deploymentPageAddAppcastItem(webDriver,"Avaya Communicator ",aadsData.AADS_APPCAST_FILE_NAME,aadsData.AADS_APPCAST_FILE_NAME,aadsData.AADS_APPCAST_VERSION,"windows",aadsData.AADS_USER_1_NAME, aadsData.AADS_USER_PWD,"https://aads25036.aam1.com:8442/acs/resources/webdeployment/downloads/AvayaEquinox22.msi");
			webDriver.close();
			
			winClient.openSettingWindows(windowsDriverRoot);
			winClient.settingWindowsMainClickOnTab(windowsDriverRoot, "Support");
			Thread.sleep(1000);
			winClient.installUpdateEquinoxforWindows(windowsDriverRoot, "3.4.0.102", "3.4.0.110");
			winClient.verifyEquinoxUpdateAvailable(windowsDriverRoot, "3.4.0.102", "3.4.0.110");
			
			
			winClient.uninstallEquinoxforWindows(windowsDriverRoot);
			logger.info("AADS_WebDeployment_003 - Passed\n");
			
		} catch (Exception exception) {
			logger.error("AADS_WebDeployment_003 - Failed with Exception:" + exception
					+ "...\n");
			fail("AADS_WebDeployment_003 - Failed - Exception occurs: "
					+ exception.toString());
		}
		logger.info("AADS_WebDeployment_003 - completed...\n");
	}

	public void tearDown() throws Exception {
		logger.info("tearDown starting...\n");
		
		webDriver.close();
		winClientDriver.close();
		logger.info("tearDown completed...\n");
	}
}