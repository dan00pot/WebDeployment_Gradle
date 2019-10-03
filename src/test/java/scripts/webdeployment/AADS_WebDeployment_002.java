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


public class AADS_WebDeployment_002 {

	static WebDriver webDriver;
	static WiniumDriver winClientDriver;
	static WindowsDriver<?> windowsDriver;
	static WindowsDriver<?> windowsDriverRoot;
	WindowsClientKeywords winClient = new WindowsClientKeywords();
	AADSWebKeywords AADSWebDriver = new AADSWebKeywords();
	Selenium selenium = new Selenium();
	DriverManagement driverMgnt = new DriverManagement();
	aadsData aadsData = new aadsData();
	
	final static Logger logger = LogManager.getLogger("AADS_WebDeployment_002");

	@Before
	public void beforetestAADS_WebDeployment_002() throws Exception {
		logger.info("beforetest AADS_WebDeployment_002 starting...\n");
		windowsDriverRoot = driverMgnt.createWinAppDriver("http://10.255.249.9:4724");
		logger.info("beforetest AADS_WebDeployment_002 completed...\n");
	}
	

	@Test 
	public void AADS_WebDeployment_002 () throws Exception {
		logger.info("AADS_WebDeployment_002 - starting...\n");
		try {
			winClient.installEquinoxforWindows(windowsDriverRoot, "C:\\AADS\\AADS_TestingFiles", "AvayaEquinox22.msi");
			Thread.sleep(8000);
			winClient.autoConfigLogin(windowsDriverRoot, "https://aads25036.aam1.com:443/acs/resoucres/configuration", "ammuser2", "tma_12Tma");

			winClient.openSettingWindows(windowsDriverRoot);
			winClient.settingWindowsMainClickOnTab(windowsDriverRoot, "Support");
			Thread.sleep(1000);
			winClient.installUpdateEquinoxforWindows(windowsDriverRoot, "3.4.0.102", "3.4.0.110");
			Thread.sleep(1000);
			winClient.openSettingWindows(windowsDriverRoot);
			winClient.settingWindowsMainClickOnTab(windowsDriverRoot, "Services");
			Thread.sleep(1000);
			winClient.settingWindowsServicesTabShowDetails(windowsDriverRoot);
			winClient.settingWindowsMainClickOnTab(windowsDriverRoot, "Enterprise Directory");
			winClient.verifyServerConfig(windowsDriverRoot, "Enterprise Directory", "10.255.253.47", "336");
			winClient.closeSettingWindow(windowsDriverRoot);	
			winClient.verifyEquinoxUpdateToDate(windowsDriverRoot);
			winClient.uninstallEquinoxforWindows(windowsDriverRoot);
			logger.info("AADS_WebDeployment_002 - Passed\n");
			
		} catch (Exception exception) {
			logger.error("AADS_WebDeployment_002 - Failed with Exception:" + exception
					+ "...\n");
			fail("AADS_WebDeployment_002 - Failed - Exception occurs: "
					+ exception.toString());
		}
		logger.info("AADS_WebDeployment_002 - completed...\n");
	}

	public void tearDown() throws Exception {
		logger.info("tearDown starting...\n");
		
		webDriver.close();
		winClientDriver.close();
		logger.info("tearDown completed...\n");
	}
}