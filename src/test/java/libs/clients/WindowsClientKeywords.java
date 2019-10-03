package libs.clients;


import java.awt.Dimension;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.Select;
import org.sikuli.script.Screen;

import io.appium.java_client.windows.WindowsDriver;
import libs.common.Selenium;


public class WindowsClientKeywords {

	Selenium selenium = new Selenium();
	WindowsClientLocators windowsClient = new WindowsClientLocators();
	final static Logger logger = LogManager.getLogger("AADS Web Actions");
	WindowsDriver winClientDriver;
	
	public boolean verifyEnterpriseContactSearch (WindowsDriver winRootDriver, String name, String expected) throws Exception 
	{

		logger.info("verifyEnterpriseContactSearchOn - starting...\n");
		try {
			boolean flag = false;
			winClientDriver = createWinHandleDriver(winRootDriver, "Avaya Equinox");
			logger.info("**** verifyEnterprieseContactSearchOnACA - Get number of result ****");
			selenium.inputText(winClientDriver, windowsClient.SEARCH_TEXT_BOX, name);	
			Thread.sleep(3000);
			String s1 = selenium.getAttribute(winClientDriver, windowsClient.SEARCH_CONTACT_ENTERPRISE_CONTACT_TITLE_BAR,"Name");
			String number = s1.replaceAll("[^0-9]", "");
			int num = Integer.parseInt(number);
			
			logger.info("verifyEnterprieseContactSearch - Number of result: " + num);
			logger.info("**** verifyEnterprieseContactSearch - Verify search ****");
			logger.info("verifyEnterprieseContactSearch - Expected result: " + expected);
			
			for (int i = 0; i < num; i++) {
				String s2 = selenium.getAttribute(winClientDriver, windowsClient.search_contact_enterprise_result(expected), "Name");
				logger.info("verifyEnterprieseContactSearch - result "+(i+1)+": " + s2);
				if (s2.contains(expected)) {
					logger.info("verifyEnterprieseContactSearch - Existed the expected result - PASSED ");
					return true;
				}
			}
			if (flag == false) {
				logger.error("verifyEnterprieseContactSearch - FAILED - Expected result didn't exist");
				throw new Exception("verifyEnterprieseContactSearch - Expected result didn't exist");
			}
			logger.info("verifyEnterprieseContactSearch - PASSED");
			
		} catch (Exception e) {
			
			logger.error("ContactsSearch - Failed with Exception: " + e + "...\n");
			throw new Exception("ContactsUuSearch - Failed - Exception occurs: " + e);
		}
		return false;
	}
	
	public void verifyEquinoxUpdateToDate (WebDriver winClientDriver) throws Exception{
		logger.info("verifyEquinoxUpdateToDate - starting...\n");
		try {
			selenium.clickElement(winClientDriver, windowsClient.SETTING_WINDOWS_SUPPORT_TAB_CHECK_UPDATE_BTN);
			selenium.elementShouldExisted(winClientDriver, windowsClient.SOFTWARE_UPDATE_WINDOW_UP_TO_DATE_TXT);
			selenium.elementShouldExisted(winClientDriver, windowsClient.SOFTWARE_UPDATE_WINDOW_NEWEST_VERSION_TXT);
			selenium.clickElement(winClientDriver, windowsClient.SOFTWARE_UPDATE_WINDOW_CLOSE_BTN);
		} catch (Exception exception) {
			logger.error("verifyEquinoxUpdateToDate - Failed with Exception: " + exception + "...\n");
			throw new Exception("verifyEquinoxUpdateToDate - Failed - Exception occurs: " + exception);
		}
		logger.info("verifyEquinoxUpdateToDate - completed...\n");		
    }
	
	public void openSettingWindows(WindowsDriver winRootDriver) throws Exception{
		logger.info("openSettingWindows - starting...\n");
		Thread.sleep(3000);
		winClientDriver = createWinHandleDriver(winRootDriver, "Avaya Equinox");
		
		try {
			if (selenium.isElementExisted(winClientDriver, windowsClient.MAIN_WINDOWS_OPEN_SETTING_BTN)){
				selenium.clickElement(winClientDriver, windowsClient.MAIN_WINDOWS_OPEN_SETTING_BTN);	
			} else {
		
				selenium.waitUntilElementClickable(winClientDriver, windowsClient.FIRST_WINDOWS_SETTING_BTN);
				selenium.clickElement(winClientDriver, windowsClient.FIRST_WINDOWS_SETTING_BTN);
				selenium.waitUntilElementClickable(winClientDriver, windowsClient.FIRST_WINDOWS_SETTING_MANUALLY_CONF_BTN);
				selenium.clickElement(winClientDriver, windowsClient.FIRST_WINDOWS_SETTING_MANUALLY_CONF_BTN);
				Thread.sleep(2000);
			}
		} catch (Exception exception) {
			logger.error("openSettingWindows - Failed with Exception: " + exception + "...\n");
			throw new Exception("openSettingWindows - Failed - Exception occurs: " + exception);
		}
		logger.info("openSettingWindows - completed...\n");			
    }
	
	public boolean autoConfigLogin(WindowsDriver winRootDriver, String address,  String user, String pwd) throws Exception{
		logger.info("autoConfigLogin - starting...\n");
		try {
			
			Thread.sleep(2000);
			WindowsDriver winClientDriver = createWinHandleDriver(winRootDriver, "Settings");
			
			if(selenium.isElementExisted(winClientDriver, windowsClient.FIRST_SCREEN_SETTING_BTN)) {
				Thread.sleep(1000);
				selenium.clickElement(winClientDriver, windowsClient.FIRST_SCREEN_SETTING_BTN);
			}
			
			selenium.clickElement(winClientDriver, windowsClient.FIRST_WINDOWS_SETTING_BTN);
			Thread.sleep(1000);
			selenium.clickElement(winClientDriver, windowsClient.FIRST_WINDOWS_SETTING_USE_WEB_BTN);
			Thread.sleep(1000);
			selenium.inputText(winClientDriver, windowsClient.FIRST_WINDOWS_SETTING_USE_WEB_TXT,address);
			Thread.sleep(1000);
			Thread.sleep(1000);
			selenium.clickElement(winClientDriver, windowsClient.FIRST_WINDOWS_SETTING_USE_WEB_NEXT_BTN);
			Thread.sleep(3000);
			selenium.inputText(winClientDriver, windowsClient.FIRST_WINDOWS_SETTING_USE_WEB_USER_TXT,user);
			selenium.inputText(winClientDriver, windowsClient.FIRST_WINDOWS_SETTING_USE_WEB_PWD_TXT,pwd);
			Thread.sleep(1000);
			if(selenium.isElementExisted(winClientDriver, windowsClient.FIRST_WINDOWS_SETTING_USE_WEB_USER_TXT)) {
				selenium.inputText(winClientDriver, windowsClient.FIRST_WINDOWS_SETTING_USE_WEB_USER_TXT,user);
				selenium.inputText(winClientDriver, windowsClient.FIRST_WINDOWS_SETTING_USE_WEB_PWD_TXT,pwd);
			}
			selenium.clickElement(winClientDriver, windowsClient.FIRST_WINDOWS_SETTING_USE_WEB_NEXT_BTN);
			Thread.sleep(9000);
			
		//	winClientDriver = createWinHandleDriver(winRootDriver, "Settings");
			selenium.clickElement(winRootDriver, windowsClient.WELCOME_SKIP_TUTORIAL_BTN);
			Thread.sleep(9000);
			
			winClientDriver = createWinHandleDriver(winRootDriver, "Avaya Equinox");
			if(selenium.isElementExisted(winClientDriver, windowsClient.FIRST_WINDOWS_SETTING_USE_WEB_USER_TXT)==true)
			{
				selenium.inputText(winClientDriver, windowsClient.FIRST_WINDOWS_SETTING_USE_WEB_PWD_TXT,pwd);
				Thread.sleep(1000);
				selenium.clickElement(winClientDriver, windowsClient.FIRST_WINDOWS_SETTING_USE_WEB_NEXT_BTN);
			}
		} catch (Exception exception) {
			logger.error("autoConfigLogin - Failed with Exception: " + exception + "...\n");
			return false;
		}
		logger.info("autoConfigLogin - completed...\n");	
		return true;
    }
	
	public void settingWindowsMainClickOnTab(WindowsDriver winRootDriver, String tabName) throws Exception{
		logger.info("settingWindowsMainClickOnTab - starting...\n");
		logger.info("tabName is: " + tabName + "\n");
		Thread.sleep(2000);
		winClientDriver = createWinHandleDriver(winRootDriver, "Avaya Engage Settings");
		try {
			selenium.waitUntilElementClickable(winClientDriver, windowsClient.settingWindowsTabLocators(tabName));
			selenium.clickElement(winClientDriver, windowsClient.settingWindowsTabLocators(tabName));
		} catch (Exception exception) {
			logger.error("settingWindowsMainClickOnTab - Failed with Exception: " + exception + "...\n");
			throw new Exception("settingWindowsMainClickOnTab - Failed - Exception occurs: " + exception);
		}
		logger.info("settingWindowsMainClickOnTab - completed...\n");		
    }
	
	public void resetApplication(WindowsDriver winRootDriver) throws Exception{
		logger.info("resetApplication - starting...\n");
		int i=0;
		//Screen sikuli = new Screen();
		
		while (true) {
			if(i==3) break;
		
		try {
			//if(sikuli.exists("imgs//ACW_Configure.png")!=null) {
			//	break;
			//	}
			
			
			WindowsDriver winClientDriver = createWinHandleDriver(winRootDriver, "Avaya Equinox");

			selenium.clickElement(winClientDriver, windowsClient.MAIN_WINDOWS_OPEN_SETTING_BTN);
			Thread.sleep(3000);

			
			winClientDriver = createWinHandleDriver(winRootDriver, "Avaya Engage Settings");
			
			
			
			selenium.clickElement(winClientDriver, windowsClient.settingWindowsTabLocators("Support"));
		//	selenium.doubleClickElement(winClientDriver, windowsClient.ADD_CONTACT_SCREEN_VERTICAL_SMALL_INCREASE_BTN);
			selenium.doubleClickElement(winClientDriver, windowsClient.ADD_CONTACT_SCREEN_VERTICAL_SMALL_INCREASE_BTN);
			Thread.sleep(3000);
			selenium.clickElement(winClientDriver,windowsClient.settingWindowsOptionsInsideTabLocators("Reset Application"));
			Thread.sleep(3000);
			selenium.clickElement(winClientDriver,windowsClient.settingWindowsOptionsInsideTabLocators("Clear"));
			Thread.sleep(2000);
//			Robot robot = new Robot();
//		    robot.keyPress(KeyEvent.VK_ALT);
//		    robot.keyPress(KeyEvent.VK_F4);
//		    robot.delay(100);
//		    robot.keyRelease(KeyEvent.VK_ALT);
//		    robot.keyRelease(KeyEvent.VK_F4);
		    break;
		} catch (Exception exception) {
//			driverMgnt.setFailedWinClientDriver(winClientDriver);
//			logger.error("resetApplication - Failed with Exception: " + exception + "...\n");
//			throw new Exception("resetApplication - Failed - Exception occurs: " + exception);
			i++;
			selenium.clickElement(winClientDriver,windowsClient.SETTING_WINDOWS_CLOSE_BTN);
			
		}}
		logger.info("resetApplication - completed...\n");		
    }
	
	
	public WindowsDriver createWinHandleDriver(WindowsDriver windowDriver, String window) throws Exception{	
		WindowsDriver windowsClientDriver = null;
	
			try {
				WebElement handle = windowDriver.findElementByName(window);
				String st = handle.getAttribute("NativeWindowHandle");
				logger.info(st);
				
				String s2 = Integer.toHexString(Integer.parseInt(st));
				System.out.println(s2);
				String equinox = "0x"+s2;
				logger.info("Hex: " + equinox);
				
				
	            DesiredCapabilities capabilities = new DesiredCapabilities();
	            capabilities.setCapability("appTopLevelWindow", equinox);
	            windowsClientDriver = new WindowsDriver(new URL("http://10.255.249.9:4724"), capabilities);
	            windowsClientDriver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
			} catch (Exception e) {
				logger.info("createWindowsClientDriver - Failed...\n + E: " + e);
				// TODO: handle exception
			}
			logger.info("createWindowsClientDriver - completed...\n");
	
		return windowsClientDriver;
    }
	
	
	public String getWinHandle(WindowsDriver windowDriver, String windowName) {
		try {
			WebElement handle = windowDriver.findElementByName("Avaya Equinox");
			String st = handle.getAttribute("NativeWindowHandle");
			String s2 = Integer.toHexString(Integer.parseInt(st));
			System.out.println(s2);
			String equinox = "0x"+s2;
			return equinox;
		} catch (Exception e) {
			return null;
		}
	}
	
	public void confirmOpenApp(WindowsDriver winRootDriver) throws Exception{
		try {
			winClientDriver = createWinHandleDriver(winRootDriver, "Other Avaya Equinox instances are detected");
	
            if (selenium.isElementExisted(winClientDriver, windowsClient.ACW_LOGIN_DIALOG_TXT_OPEN_CONFIRM_QUESTION)){
            	selenium.clickElement(winClientDriver,windowsClient.ACW_LOGIN_DIALOG_BTN_NO);
            }

		} catch (Exception exception) {
			logger.error("confirmOpenApp - Failed with Exception: " + exception + "...\n");
			throw new Exception("confirmOpenApp - Failed - Exception occurs: " + exception);
		}
		logger.info("confirmOpenApp - completed...\n");		
    }
	
	public boolean addContactBySearch(WindowsDriver winRootDriver, String user) throws Exception{
		logger.info("addContactBySearch - starting...\n");
		boolean s= false;

		Screen sikuli = new Screen();

		try {
			sikuli.click("imgs/WinClient-SearchBar.PNG");
			sikuli.type(null, user);
			Thread.sleep(1000);
			
			winClientDriver = createWinHandleDriver(winRootDriver, "Avaya Equinox");
			
			
			
			selenium.doubleClickElement(winClientDriver, windowsClient.mainWindowsContactsTabUserLocatorsAfterSearch(user));
			selenium.clickElement(winClientDriver, windowsClient.ADD_CONTACT_SCREEN_ADD_CONTACT_BTN);
			Thread.sleep(10000);
			clickCancelSearch(winClientDriver);
			
			if(selenium.isElementExisted(winClientDriver, windowsClient.CONTACT_IN_CONTACT_LIST(user))) {
				s=true;
			}
			
		} catch (Exception exception) {
			s=false;
			if(selenium.isElementExisted(winClientDriver, windowsClient.ADD_CONTACT_SCREEN_CANCEL_CONTACT_BTN))
			selenium.clickElement(winClientDriver, windowsClient.ADD_CONTACT_SCREEN_CANCEL_CONTACT_BTN);
		}
		logger.info("addContactBySearch - completed...\n");	
		return s;
    }
	
	
	public void mainWindowsNavigateToContactTab (WindowsDriver winRootDriver) throws Exception{
		logger.info("mainWindowsNavigateToContactTab - starting...\n");
		
		try {
			winClientDriver = createWinHandleDriver(winRootDriver, "Avaya Equinox");
			if(!selenium.isElementExisted(winClientDriver, windowsClient.MAIN_WINDOWS_CONTACT_LIST_BOX)){
				selenium.clickElement(winClientDriver, windowsClient.MAIN_WINDOWS_CONTACT_BTN);
				Thread.sleep(1000);		
			}
		} catch (Exception exception) {
			logger.error("mainWindowsNavigateToContactTab - Failed with Exception: " + exception + "...\n");
			throw new Exception("mainWindowsNavigateToContactTab - Failed - Exception occurs: " + exception);
		}
		logger.info("mainWindowsNavigateToContactTab - completed...\n");		
    }
	
	public boolean editContact(WindowsDriver winRootDriver, String name ,String fieldname,String value) throws Exception{
		boolean s= false;
		int i=0;
		 Screen img = new Screen();
			while (true) {
				if (i==3) break;
				try {
					Thread.sleep(3000);
					 img.click("imgs//WinClient-SearchBar.PNG");
					 img.write(name);
					Thread.sleep(5000);
					
					winClientDriver = createWinHandleDriver(winRootDriver, "Avaya Equinox");
					if(selenium.isElementExisted(winClientDriver, windowsClient.CONTACT_LIST_CONTACT_RESULT(name))) {
					selenium.doubleClickElement(winClientDriver, windowsClient.CONTACT_LIST_CONTACT_RESULT(name));
			 
					
				selenium.clickElement(winClientDriver, windowsClient.ADD_CONTACT_SCREEN_EDIT_BTN);
				switch (fieldname) {
				case "company":
					selenium.inputText(winClientDriver, windowsClient.ADD_CONTACT_SCREEN_COMPANY_TXT, value);
					break;
				case "last_name":
					selenium.inputText(winClientDriver, windowsClient.ADD_CONTACT_SCREEN_LAST_NAME_TXT, value);
					break;
				}
			
				selenium.clickElement(winClientDriver, windowsClient.ADD_CONTACT_SCREEN_DONE_BTN);
				Thread.sleep(3000);
				if(!selenium.isElementExisted(winClientDriver, windowsClient.ADD_CONTACT_SCREEN_DONE_BTN)) {
				s=true;
				settingWindowsMainClickBackButton(winClientDriver);
				selenium.clickElement(winClientDriver, windowsClient.CONTACT_LIST_CANCLE_SEARCH_BTN);
				//resetcontactTab(windowClientDriver);
				}
				break;
					}else break;
			}catch (Exception e) {
			logger.error("verifyIfContactExisted - Failed with Exception: " + e + "...\n");
			i++;
			settingWindowsMainClickBackButton(winClientDriver);
		}}
		return s;
	}
	
	public boolean removeContact(WindowsDriver winRootDriver, String name) throws Exception{
		boolean s= false;
		int i=0;
		 Screen img = new Screen();
			while (true) {
				if (i==3) break;
				try {
					Thread.sleep(3000);
					 img.click("imgs//WinClient-SearchBar.PNG");
					 img.write(name);
					Thread.sleep(5000);
					winClientDriver = createWinHandleDriver(winRootDriver, "Avaya Equinox");
					if(selenium.isElementExisted(winClientDriver, windowsClient.CONTACT_LIST_CONTACT_RESULT(name))) {
					selenium.doubleClickElement(winClientDriver, windowsClient.CONTACT_LIST_CONTACT_RESULT(name));
			
					Thread.sleep(1000);
					selenium.clickElement(winClientDriver, windowsClient.CONTACT_LIST_REMOVE_CONTACT);
					selenium.clickElement(winClientDriver, windowsClient.CONTACT_LIST_REMOVE_CONTACT_CONFIRM_YES);
				
					selenium.clickElement(winClientDriver, windowsClient.CONTACT_LIST_CANCLE_SEARCH_BTN);
				
					
				if(!selenium.isElementExisted(winClientDriver, windowsClient.ADD_CONTACT_SCREEN_DONE_BTN)) {
				s=true;
				
				clickCancelSearch(winClientDriver);
				
				//resetcontactTab(winClientDriver);
				}
				break;
					}else break;
			}catch (Exception e) {
			logger.error("verifyIfContactExisted - Failed with Exception: " + e + "...\n");
			i++;
			settingWindowsMainClickBackButton(winClientDriver);
		}}
		return s;
	}
	
	public void resetcontactTab (WindowsDriver winRootDriver) throws Exception{
		logger.info("mainWindowsNavigateToContactTab - starting...\n");
		try {
			winClientDriver = createWinHandleDriver(winRootDriver, "Avaya Equinox");
			if(!selenium.isElementExisted(winClientDriver, windowsClient.MAIN_WINDOWS_CONTACT_LIST_BOX)){
				selenium.clickElement(winClientDriver, windowsClient.MAIN_WINDOWS_CONTACT_BTN);}
			Thread.sleep(1000);	
		} catch (Exception exception) {
			logger.error("mainWindowsNavigateToContactTab - Failed with Exception: " + exception + "...\n");
		}
		logger.info("mainWindowsNavigateToContactTab - completed...\n");		
    }
	
	public void settingWindowsMainClickBackButton(WindowsDriver winRootDriver) throws Exception{
		logger.info("settingWindowsMainClickBackButton - starting...\n");
		try {
			winClientDriver = createWinHandleDriver(winRootDriver, "Avaya Equinox");
			selenium.clickElement(winClientDriver, windowsClient.SETTING_WINDOWS_BACK_BTN);
	
		} catch (Exception exception) {
			logger.error("settingWindowsMainClickBackButton - Failed with Exception: " + exception + "...\n");
			throw new Exception("settingWindowsMainClickBackButton - Failed - Exception occurs: " + exception);
		}
		logger.info("settingWindowsMainClickBackButton - completed...\n");		
    }
	
	public void clickCancelSearch (WindowsDriver windowClientDriver) throws Exception{
		logger.info("clickCancelSearch - starting...\n");
		try {
				selenium.clickElement(windowClientDriver, windowsClient.CONTACT_LIST_CANCLE_SEARCH_BTN);
			Thread.sleep(3000);	
		} catch (Exception exception) {
			logger.error("clickCancelSearch - Failed with Exception: " + exception + "...\n");
		}
		logger.info("clickCancelSearch - completed...\n");		
    }
	
	
	
	public boolean verifyUserisExistedContactTab(WebDriver winClientDriver, String user) throws Exception{
		logger.info("verifyUserisExistedContactTab - starting...\n");
		logger.info("user is: " + user + "\n");
		boolean s= false;
		try {
			Thread.sleep(2000);
			s = selenium.isElementExisted(winClientDriver, windowsClient.mainWindowsContactsTabUserLocators(user));
			Thread.sleep(2000);	
			
		} catch (Exception exception) {
//			driverMgnt.setFailedWinClientDriver(winClientDriver);
//			logger.error("verifyUserisExistedContactTab - Failed with Exception: " + exception + "...\n");
//			throw new Exception("verifyUserisExistedContactTab - Failed - Exception occurs: " + exception);
			s=false;
		}
		logger.info("verifyUserisExistedContactTab - completed...\n");		
		return s;
    }
	
	/**
	 * @param winClientDriver
	 * @param status
	 * @throws Exception
	 * @author HuyD
	 */
	public void setStatus(WebDriver winClientDriver, String status) throws Exception{
		String message = "ACW starting set status";
		logger.info(message);
		try {
			selenium.clickElement(winClientDriver, windowsClient.MAIN_WINDOWS_AVATAR_BTN);
			Thread.sleep(2000);
			selenium.clickElement(winClientDriver, windowsClient.MAIN_WINDOWS_STATUS_COMBO_BOX);
			Thread.sleep(2000);
			selenium.clickElement(winClientDriver, windowsClient.mainwindowsstatus(status));
			selenium.clickElement(winClientDriver, windowsClient.MAIN_WINDOWS_CLOSE_AVATAR_BTN);
		} catch (Exception e) {
			logger.error("setStatus - Failed with Exception: " + e + "...\n");
			throw new Exception("setStatus - Failed - Exception occurs: " + e);
		}
	}
	
	public void setStatus_T(WebDriver winClientDriver, String status) throws Exception{
		String message = "ACW starting set status";
		logger.info(message);
		try {
			selenium.clickElement(winClientDriver, windowsClient.MAIN_WINDOWS_AVATAR_BTN);
			Thread.sleep(2000);
			selenium.clickElement(winClientDriver, windowsClient.MAIN_WINDOWS_STATUS_COMBO_BOX);
			Thread.sleep(2000);
			selenium.clickElement(winClientDriver, windowsClient.mainwindowsstatus(status));
			selenium.clickElement(winClientDriver, windowsClient.MAIN_WINDOWS_CLOSE_AVATAR_BTN);
		} catch (Exception e) {
			logger.error("setStatus - Failed with Exception: " + e + "...\n");}
	}
	/**
	 * @param winClientDriver
	 * @param status
	 * @throws Exception
	 * @author HoanNguyen
	 */
	public void selfStatusCheck_T(WebDriver winClientDriver) throws Exception{
		String message = "ACW starting selfStatusCheck";
		Screen s= new Screen();
		logger.info(message);
		try {
			selenium.clickElement(winClientDriver, windowsClient.MAIN_WINDOWS_AVATAR_BTN);
			Thread.sleep(2000);
			if(s.exists("imgs//Avai.PNG")!=null) {
				logger.info("Status Avaiable - Passed");
				logger.info(""+s.exists("imgs//Avai.PNG"));
				}
			else{
				if(s.exists("imgs//Off.PNG")!=null) logger.info("Status offline - Failed");
				else logger.info("Status other - Passed");
				}
			selenium.clickElement(winClientDriver, windowsClient.MAIN_WINDOWS_CLOSE_AVATAR_BTN);
		} catch (Exception e) {
			logger.error("selfStatusCheck - Failed with Exception: " + e + "...\n");
//			throw new Exception("setStatus - Failed - Exception occurs: " + e);
		}
	}
	public void getStatus(WebDriver winClientDriver, String status) throws Exception{
		String message = "ACW starting set status";
		logger.info(message);
		try {
			selenium.clickElement(winClientDriver, windowsClient.MAIN_WINDOWS_AVATAR_BTN);
			Thread.sleep(2000);
			//selenium.waitUntilElementClickable(winClientDriver, windowsClient.MAIN_WINDOWS_STATUS_COMBO_BOX, 5);
			//selenium.clickElement(winClientDriver, windowsClient.MAIN_WINDOWS_STATUS_COMBO_BOX);
			
			String n = selenium.getAttribute(winClientDriver, windowsClient.mainwindowsstatusSelected(status), "IsSelected");
			System.out.println("Selected combo value: " + n);
			//String n = selenium.getAttribute(winClientDriver, windowsClient.MAIN_WINDOWS_AVATAR_BTN, "Selection");
			System.out.println("Selected combo value: " + n);
			Select comboBox = new Select(winClientDriver.findElement(windowsClient.MAIN_WINDOWS_AVATAR_BTN));
			Point location = comboBox.getFirstSelectedOption().getLocation();
			String selectedComboValue = comboBox.getFirstSelectedOption().getCssValue("id");
			
	
			System.out.println("Selected combo value: " + selectedComboValue);
			System.out.println("Selected combo value: " + location);
			

		} catch (Exception e) {
			logger.error("setStatus - Failed with Exception: " + e + "...\n");
			throw new Exception("setStatus - Failed - Exception occurs: " + e);
		}
	}
	
	public void verifyContactStatus(WebDriver winClientDriver,String user, String status) throws Exception{
		logger.info("verifyContactStatus - starting...\n");
		try {
			Thread.sleep(7000);
			String s = selenium.getAttribute(winClientDriver, windowsClient.CONTACT_LIST_CONTACT_STATUS(user), "Name");
			if(s.contains(status)){
				logger.info("PASSED");
			}else{
			logger.info("FAILED");
			throw new Exception("verifyContactStatus - Failed - Exception occurs: ");
			}
		} catch (Exception exception) {
		
			logger.error("verifyContactStatus - Failed with Exception: " + exception + "...\n");
			throw new Exception("verifyContactStatus - Failed - Exception occurs: " + exception);
		}
		logger.info("verifyContactStatus - completed...\n");		
    }
	
	public void conversationWindowsEditSubject_T (WebDriver winClientDriver, String subject) throws Exception{
		logger.info("conversationWindowsEditSubject - starting...\n");
		logger.info("subject is: " + subject + "\n");
		try {
			Thread.sleep(1000);
			
			WebElement element = winClientDriver.findElement(windowsClient.CONVERSATION_WINDOWS_MENU_BTN);
			Actions build = new Actions(winClientDriver);
			build.moveToElement(element, 5, 5).click().build().perform();
			selenium.clickElement(winClientDriver, windowsClient.CONVERSATION_WINDOWS_MENU_EDIT_SUBJECT_BTN);
			
		
			selenium.inputText(winClientDriver, windowsClient.CONVERSATION_WINDOWS_MENU_EDIT_SUBJECT_TXT, subject);
			selenium.clickElement(winClientDriver, windowsClient.CONVERSATION_WINDOWS_MENU_EDIT_SUBJECT_DONE_BTN);
			Thread.sleep(1000);	
		} catch (Exception exception) {
			logger.error("conversationWindowsEditSubject - Failed with Exception: " + exception + "...\n");
			//throw new Exception("conversationWindowsEditSubject - Failed - Exception occurs: " + exception);
		}
		logger.info("conversationWindowsEditSubject - completed...\n");		
    }
	
	
	public void moveConversationWindow(WebDriver winClientDriver) throws Exception{
		logger.info("mainElementToPosition - starting...\n");
		try {
			Dimension screen = Toolkit.getDefaultToolkit().getScreenSize();
			logger.info("screen x is: " + screen.getWidth() + "\n");
			logger.info("screen y is: " + screen.getHeight() + "\n");
			selenium.dragAndDropFromElementToPosion(winClientDriver, windowsClient.MAIN_WINDOWS_TITLE, (int) screen.getWidth()-900, 100);
		} catch (Exception exception) {
			logger.error("mainElementToPosition - Failed with Exception: " + exception + "...\n");
			throw new Exception("mainElementToPosition - Failed - Exception occurs: " + exception);
		}
		logger.info("mainElementToPosition - completed...\n");		
    }
	
	/**
	 * Leave the current conversation
	 * @param winClientDriver testing Client on Windows
	 * @author nmquan
	 * @throws Exception 
	 */	
	public void conversationWindowsLeaveConversation(WebDriver winClientDriver) throws Exception{
		logger.info("conversationWindowsLeaveConversation - starting...\n");
		try {
			WebElement element = winClientDriver.findElement(windowsClient.CONVERSATION_WINDOWS_MENU_BTN);
			Actions build = new Actions(winClientDriver);
			build.moveToElement(element, 5, 5).click().build().perform();
			selenium.clickElement(winClientDriver, windowsClient.CONVERSATION_WINDOWS_MENU_LEAVE_CONVERSATION_BTN);
			Thread.sleep(1000);	
		} catch (Exception exception) {
			
			logger.error("conversationWindowsLeaveConversation - Failed with Exception: " + exception + "...\n");
			throw new Exception("conversationWindowsLeaveConversation - Failed - Exception occurs: " + exception);
		}
		logger.info("conversationWindowsLeaveConversation - completed...\n");		
    }
	
	/**
	 * Send the composed message
	 * @param winClientDriver testing Client on Windows
	 * @author nmquan
	 * @throws Exception 
	 */	
	public void conversationWindowsSendMsg (WebDriver winClientDriver) throws Exception{
		logger.info("conversationWindowsSendMsg - starting...\n");
		try {
			Thread.sleep(2000);
			selenium.clickElement(winClientDriver, windowsClient.CONVERSATION_WINDOWS_TEXT_MSG_TXT);
			Robot robot = new Robot();
			robot.keyPress(KeyEvent.VK_ENTER);
		    robot.keyRelease(KeyEvent.VK_ENTER);
		    robot.delay(3000);
		} catch (Exception exception) {
			logger.error("conversationWindowsSendMsg - Failed with Exception: " + exception + "...\n");
			throw new Exception("conversationWindowsSendMsg - Failed - Exception occurs: " + exception);
		}
		logger.info("conversationWindowsSendMsg - completed -- PASSED...\n");		
    }
	
	
	public void conversationWindowsSendMsg_T (WebDriver winClientDriver) throws Exception{
		logger.info("conversationWindowsSendMsg - starting...\n");
		try {
			Thread.sleep(2000);
			selenium.clickElement(winClientDriver, windowsClient.CONVERSATION_WINDOWS_TEXT_MSG_TXT);
			Robot robot = new Robot();
			robot.keyPress(KeyEvent.VK_ENTER);
		    robot.keyRelease(KeyEvent.VK_ENTER);
		    robot.delay(3000);
		    
		} catch (Exception exception) {
			logger.error("conversationWindowsSendMsg - Failed with Exception: " + exception + "...\n");
			//throw new Exception("conversationWindowsSendMsg - Failed - Exception occurs: " + exception);
		}
		logger.info("conversationWindowsSendMsg - completed -- PASSED...\n");		
    }
	/**
	 * Input text message into message text box in Conversation Windows
	 * @param winClientDriver testing Client on Windows
	 * @param message Text Message to input into Text Msg box
	 * @author nmquan
	 * @throws Exception 
	 */	
	public void conversationWindowsInputTextMsg (WebDriver winClientDriver, String message) throws Exception{
		logger.info("conversationWindowsInputTextMsg - starting...\n");
		logger.info("message is: " + message + "\n");
		try {
			selenium.inputText(winClientDriver, windowsClient.CONVERSATION_WINDOWS_TEXT_MSG_TXT, message);
			
		} catch (Exception exception) {
			logger.error("conversationWindowsInputTextMsg - Failed with Exception: " + exception + "...\n");
			throw new Exception("conversationWindowsInputTextMsg - Failed - Exception occurs: " + exception);
		}
		logger.info("conversationWindowsInputTextMsg - completed -- ...\n");		
    }
	
	
	public void conversationWindowsInputTextMsg_T (WebDriver winClientDriver, String message) throws Exception{
		logger.info("conversationWindowsInputTextMsg - starting...\n");
		logger.info("message is: " + message + "\n");
		try {
			selenium.inputText(winClientDriver, windowsClient.CONVERSATION_WINDOWS_TEXT_MSG_TXT, message);
		} catch (Exception exception) {
			logger.error("conversationWindowsInputTextMsg - Failed with Exception: " + exception + "...\n");
			//throw new Exception("conversationWindowsInputTextMsg - Failed - Exception occurs: " + exception);
		}
		logger.info("conversationWindowsInputTextMsg - completed -- ...\n");		
    }
	
	public void mainWindowsContactsTabOpenNewConversationWithUser_T(WebDriver winClientDriver, String user) throws Exception{
		logger.info("mainWindowsContactsTabOpenNewConversationWithUser - starting...\n");
		logger.info("user is: " + user + "\n");
		try {
		
			selenium.mouseHover(winClientDriver, windowsClient.mainWindowsContactsTabUserLocators(user));
			Thread.sleep(3000);
			selenium.clickElement(winClientDriver, windowsClient.mainWindowsContactsTabUserActionLocators("Chat",user));
			Thread.sleep(4000);
//			selenium.waitUntilElementClickable(winClientDriver, windowsClient.MAIN_WINDONS_CONTACT_TAB_START_CONVERSATION_BTN, timeout);
//			selenium.clickElement(winClientDriver, windowsClient.MAIN_WINDONS_CONTACT_TAB_START_CONVERSATION_BTN);
//			Thread.sleep(2000);
		    Robot r =  new Robot();
			r.mousePress(InputEvent.BUTTON1_MASK);
			r.mouseRelease(InputEvent.BUTTON1_MASK);

		} catch (Exception exception) {
	
			logger.error("mainWindowsContactsTabOpenNewConversationWithUser - Failed with Exception: " + exception + "...\n");

			//throw new Exception("mainWindowsContactsTabOpenNewConversationWithUser - Failed - Exception occurs: " + exception);
		}	
    }
	
	public void addUserToConversationOnConversationTab_T(WebDriver winClientDriver, String user, String subject) throws Exception{
		logger.info("addUserToConversationOnConversationTab - starting...\n");
		logger.info("user: " + user + "\n");
		logger.info("subject: " + subject + "\n");
		try {
			selenium.rightClickElement(winClientDriver, windowsClient.CONVERSATION_WINDOWS_ADD_USER_BTN);
			//selenium.rightClickElement(winClientDriver, windowsClient.conversationWindowsSubjectTabLeftBtn(subject));
			selenium.clickElement(winClientDriver, windowsClient.CONVERSATION_WINDOWS_ADD_PARTICIPANTS_TXT);
			selenium.clickElement(winClientDriver, windowsClient.CONVERSATION_WINDOWS_SEARCH_USER_ADD_TXT);
			selenium.inputText(winClientDriver, windowsClient.CONVERSATION_WINDOWS_SEARCH_USER_ADD_TXT, user);
			Thread.sleep(2000);
			selenium.mouseHover(winClientDriver, windowsClient.CONVERSATION_WINDOWS_ADD_PARTICIPANTS_USER_ITEM(user));
			Thread.sleep(1000);
			selenium.clickElement(winClientDriver, windowsClient.CONVERSATION_WINDOWS_ADD_PARTICIPANTS_USER_ITEM(user));
			//selenium.clickElement(winClientDriver, windowsClient.CONVERSATION_WINDOWS_ADD_PARTICIPANTS_USER_ITEM(user));
			Thread.sleep(1000);
			//selenium.clickElement(winClientDriver, windowsClient.CONVERSATION_WINDOWS_ADD_ITEM_BTN);
			selenium.clickElement(winClientDriver, windowsClient.CONVERSATION_WINDOWS_ADD_USER_CONFIRM_ADD_BTN);
			selenium.clickElement(winClientDriver, windowsClient.ADD_CONTACT_SCREEN_ADD_CONTACT_BTN);	
		} catch (Exception exception) {

			logger.error("addUserToConversation - Failed with Exception: " + exception + "...\n");
			//throw new Exception("addUserToConversation - Failed - Exception occurs: " + exception);
		}
		logger.info("addUserToConversation - completed...\n");			
    }
	
	public void conversationWindowsVerifyConversationShouldContainMessage_T (WebDriver winClientDriver, String text) throws Exception{
		logger.info("conversationWindowsVerifyConversationShouldContainMessage - starting...\n");	
		logger.info("Message is: " + text + "\n");
		try {
			Thread.sleep(4000);
			selenium.elementShouldExisted(winClientDriver, windowsClient.conversationWindowsFileNameLocator(text));
			logger.info("*** conversationWindowsVerifyConversationShouldContainMessage - PASSED ***");
			
		} catch (Exception exception) {
			logger.error("conversationWindowsVerifyConversationShouldContainMessage - Failed with Exception: " + exception + "...\n");
//			/throw new Exception("conversationWindowsVerifyConversationShouldContainMessage - Failed - Exception occurs: " + exception);
		}
		logger.info("conversationWindowsVerifyConversationShouldContainMessage - completed -- ...\n");			
    }
	
	public void mainWindowsContactsTabCallUser_T(WebDriver winClientDriver, String user) throws Exception{
		logger.info("mainWindowsContactsTabOpenNewConversationWithUser - starting...\n");
		logger.info("user is: " + user + "\n");
		try {
			selenium.mouseHover(winClientDriver, windowsClient.mainWindowsContactsTabUserLocators(user));
			winClientDriver.getWindowHandle();
			Thread.sleep(3000);
			selenium.clickElement(winClientDriver, windowsClient.mainWindowsContactsTabUserActionLocators("Call",user));

//			selenium.waitUntilElementClickable(winClientDriver, windowsClient.MAIN_WINDONS_CONTACT_TAB_START_CONVERSATION_BTN, timeout);
//			selenium.clickElement(winClientDriver, windowsClient.MAIN_WINDONS_CONTACT_TAB_START_CONVERSATION_BTN);
//			Thread.sleep(2000);
		    Robot r =  new Robot();
			r.mousePress(InputEvent.BUTTON1_MASK);
			r.mouseRelease(InputEvent.BUTTON1_MASK);
			
		} catch (Exception exception) {

			logger.error("mainWindowsContactsTabOpenNewConversationWithUser - Failed with Exception: " + exception + "...\n");
			//throw new Exception("mainWindowsContactsTabOpenNewConversationWithUser - Failed - Exception occurs: " + exception);
		}
		logger.info("mainWindowsContactsTabOpenNewConversationWithUser - completed...\n");		
    }
	
	
	public boolean verifyContactIsExistedInContactList(WebDriver winClientDriver, String name) throws Exception{
		try {
			if(selenium.isElementExisted(winClientDriver, windowsClient.CONTACT_LIST_CONTACT_NAME(name))){
				logger.info("verifyEnterpriseSearch - PASSED");
				return true;
			} else {
				return false;
			}
			
		} catch (Exception e) {
			logger.error("verifyIfContactExisted - Failed with Exception: " + e + "...\n");
			throw new Exception("verifyIfContactExisted - Failed - Exception occurs: " + e);
		}
	}
	
	public void mainWindowsNavigateToTopOfMind (WebDriver winClientDriver) throws Exception{
		logger.info("mainWindowsNavigateToTopMind - starting...\n");
		try {
	
			selenium.clickElement(winClientDriver, windowsClient.MAIN_WINDOWS_TOP_OF_MIND_BTN);
			Thread.sleep(1000);	
		} catch (Exception exception) {
			
			logger.error("mainWindowsNavigateToTopMind - Failed with Exception: " + exception + "...\n");
			throw new Exception("mainWindowsNavigateToTopMind - Failed - Exception occurs: " + exception);
		}
		logger.info("mainWindowsNavigateToTopMind - completed...\n");		
    }
	
	
	public boolean addPrivateContact(WindowsDriver winRootDriver, String firstname, String lastname, String phone, String address) throws Exception{
		logger.info("addContactBySearch - starting...\n");
		boolean s= false;
		try {
			winClientDriver = createWinHandleDriver(winRootDriver, "Avaya Equinox");
			
			selenium.clickElement(winClientDriver, windowsClient.CONTACT_TAB_SCREEN_ADD_CONTACT_BTN);
			selenium.inputText(winClientDriver, windowsClient.ADD_CONTACT_SCREEN_LAST_NAME_TXT, lastname);
			selenium.inputText(winClientDriver, windowsClient.ADD_CONTACT_SCREEN_FISRT_NAME_TXT, firstname);
	
			selenium.inputText(winClientDriver, windowsClient.ADD_CONTACT_SCREEN_NUMBER_PHONE_TXT,phone);
			Thread.sleep(1000);
			if(selenium.isElementExisted(winClientDriver, windowsClient.ADD_CONTACT_SCREEN_VERTICAL_SMALL_INCREASE_BTN)) {
			selenium.doubleClickElement(winClientDriver, windowsClient.ADD_CONTACT_SCREEN_VERTICAL_SMALL_INCREASE_BTN);
			selenium.doubleClickElement(winClientDriver, windowsClient.ADD_CONTACT_SCREEN_VERTICAL_SMALL_INCREASE_BTN);
			}
			selenium.inputText(winClientDriver, windowsClient.ADD_CONTACT_SCREEN_EMAIL_ADDRESS_TXT,address);
			if(selenium.isElementExisted(winClientDriver, windowsClient.ADD_CONTACT_SCREEN_ADD_CONTACT_BTN)) {
			selenium.clickElement(winClientDriver, windowsClient.ADD_CONTACT_SCREEN_ADD_CONTACT_BTN);}
			Thread.sleep(5000);
			selenium.waitUntilElementVisible(winClientDriver, windowsClient.SEARCH_TEXT_BOX);
			String contact = firstname + " " + lastname;
			if(selenium.isElementExisted(winClientDriver, windowsClient.CONTACT_LIST_CONTACT_NAME(contact))) {
				s=true;
			} else s = false;
			
		} catch (Exception exception) {
			logger.info("addContactBySearch - Failed: Exception: " + exception);
			s=false;
			if(selenium.isElementExisted(winClientDriver, windowsClient.ADD_CONTACT_SCREEN_CANCEL_CONTACT_BTN))
			selenium.clickElement(winClientDriver, windowsClient.ADD_CONTACT_SCREEN_CANCEL_CONTACT_BTN);
		}
		logger.info("addContactBySearch - completed...\n");	
		return s;
    }
	
	public boolean contactsIsContactFavorite (WindowsDriver winRootDriver, String user) throws Exception{
		logger.info("contactsIsContactFavorite - starting...\n");
		try {
			winClientDriver = createWinHandleDriver(winRootDriver, "Avaya Equinox");
			selenium.inputText(winClientDriver, windowsClient.SEARCH_TEXT_BOX, user);	
			
			selenium.mouseHover(winClientDriver, windowsClient.mainWindowsContactsTabUserLocatorsAfterSearch(user));
			if (selenium.isElementExisted(winClientDriver, windowsClient.MAIN_WINDOWS_FAVORITES_ICON_ENABLED(user))) {
				logger.info(user + " is favorite");
				return true;
			} else {
				if (selenium.isElementExisted(winClientDriver, windowsClient.MAIN_WINDOWS_FAVORITES_ICON_DISABLED(user))) {
					logger.info(user + " is not favorite");
					return false;
				} else {
					logger.info("Favorites icon is not present");
					throw new Exception("contactsMarkContactAsFavorites - Failed - Favorites icon is not present");
				}
			}

		} catch (Exception exception) {
		
			logger.error("contactsMarkContactAsFavorites - Failed with Exception: " + exception + "...\n");
			throw new Exception("contactsMarkContactAsFavorites - Failed - Exception occurs: " + exception);
		}
	   }
	
	public void pressEnterToSend (WebDriver winClientDriver) throws Exception{
		logger.info("pressEnterToSend - starting...\n");
		try {
			Thread.sleep(2000);
			//selenium.clickElement(winClientDriver, windowsClient.CONVERSATION_WINDOWS_TEXT_MSG_TXT);
			Robot robot = new Robot();
			robot.keyPress(KeyEvent.VK_ENTER);
		    robot.keyRelease(KeyEvent.VK_ENTER);
		    robot.delay(1000);
		} catch (Exception exception) {
			logger.error("pressEnterToSend - Failed with Exception: " + exception + "...\n");
			throw new Exception("pressEnterToSend - Failed - Exception occurs: " + exception);
		}
		logger.info("pressEnterToSend - completed...\n");		
    }
	
	public void installEquinoxforWindows (WindowsDriver winRootDriver, String filePath, String fileName) throws Exception{
		logger.info("installEquinoxforWindows - starting...\n");
		try {
			selenium.windowsE(winRootDriver);
			Thread.sleep(2000);
			winClientDriver = createWinHandleDriver(winRootDriver, "This PC");
			selenium.clickElement(winClientDriver, windowsClient.DESKTOP_COMPUTER_ADDRESS);
			selenium.inputText(winClientDriver, windowsClient.DESKTOP_COMPUTER_ADDRESS_AFTER_CLICK, filePath);
			pressEnterToSend(winClientDriver);
	        selenium.doubleClickElement(winClientDriver,windowsClient.FILE(fileName));
	        Thread.sleep(15000);
	        winClientDriver = createWinHandleDriver(winRootDriver, "Avaya Equinox Setup");
	        if(selenium.isElementExisted(winClientDriver, windowsClient.DESKTOP_SECURITY_WARNING_RUN_BTN)) {
	        	selenium.clickElement(winClientDriver,windowsClient.DESKTOP_SECURITY_WARNING_RUN_BTN);
	        }
	        Thread.sleep(3000);
	        selenium.clickElement(winClientDriver,windowsClient.DESKTOP_SETUP_WINDOW_NEXT_BTN);
	        Thread.sleep(1000);
	        winClientDriver = createWinHandleDriver(winRootDriver, "Avaya Equinox Setup");
	        selenium.clickElement(winClientDriver, windowsClient.DESKTOP_SETUP_WINDOW_ACCEPT_CHECKBOX);
	        selenium.clickElement(winClientDriver,windowsClient.DESKTOP_SETUP_WINDOW_NEXT_BTN);
	        winClientDriver = createWinHandleDriver(winRootDriver, "Avaya Equinox Setup");
	        selenium.clickElement(winClientDriver,windowsClient.DESKTOP_SETUP_WINDOW_NEXT_BTN);
	        winClientDriver = createWinHandleDriver(winRootDriver, "Avaya Equinox Setup");
	        selenium.clickElement(winClientDriver,windowsClient.DESKTOP_SETUP_WINDOW_NEXT_BTN);
	        winClientDriver = createWinHandleDriver(winRootDriver, "Avaya Equinox Setup");
	        selenium.clickElement(winClientDriver,windowsClient.DESKTOP_SETUP_WINDOW_NEXT_BTN);
	        winClientDriver = createWinHandleDriver(winRootDriver, "Avaya Equinox Setup");
	        selenium.clickElement(winClientDriver,windowsClient.DESKTOP_SETUP_WINDOW_INSTALL_BTN);
	        winClientDriver = createWinHandleDriver(winRootDriver, "Avaya Equinox Setup");
	        selenium.waitUntilElementInvisible(winClientDriver,windowsClient.DESKTOP_SETUP_WINDOW_INSTALL_BTN);
	        winClientDriver = createWinHandleDriver(winRootDriver, "Avaya Equinox Setup");
	        selenium.clickElement(winClientDriver,windowsClient.DESKTOP_SETUP_WINDOW_FINISH_BTN);
	        winClientDriver = createWinHandleDriver(winRootDriver, "AADS_TestingFiles");
	        selenium.clickElement(winClientDriver,windowsClient.DESKTOP_WINDOWS_BTN_CLOSE);
	        
		} catch (Exception exception) {
			logger.error("installEquinoxforWindows - Failed with Exception: " + exception + "...\n");
			throw new Exception("installEquinoxforWindows - Failed - Exception occurs: " + exception);
		}
		logger.info("installEquinoxforWindows - completed...\n");		
    }
	
	public void uninstallEquinoxforWindows (WindowsDriver winRootDriver) throws Exception{
		logger.info("installEquinoxforWindows - starting...\n");
		
		
		try {
			selenium.windowsE(winRootDriver);
			Thread.sleep(2000);
			winClientDriver = createWinHandleDriver(winRootDriver, "This PC");
			selenium.clickElement(winClientDriver, windowsClient.DESKTOP_COMPUTER_ADDRESS);
			selenium.inputText(winClientDriver, windowsClient.DESKTOP_COMPUTER_ADDRESS_AFTER_CLICK, "Control Panel\\All Control Panel Items\\Programs and Features");
			pressEnterToSend(winClientDriver);
			
	        selenium.doubleClickElement(winClientDriver,windowsClient.CONTROL_PANEL_AVAYA_EQUINOX_ICON);
	        Thread.sleep(2000);
	        
	        winClientDriver = createWinHandleDriver(winRootDriver, "Programs and Features");
	        
	        selenium.clickElement(winClientDriver,windowsClient.CONTACT_LIST_REMOVE_CONTACT_CONFIRM_YES);
	        if(selenium.isElementExisted(winClientDriver, windowsClient.DESKTOP_SECURITY_WARNING_RUN_BTN)) {
	        	selenium.clickElement(winClientDriver,windowsClient.DESKTOP_SECURITY_WARNING_RUN_BTN);
	        }
	        Thread.sleep(25000);

	        selenium.clickElement(winClientDriver,windowsClient.DESKTOP_WINDOWS_BTN_CLOSE);
	        
		} catch (Exception exception) {
			logger.error("installEquinoxforWindows - Failed with Exception: " + exception + "...\n");
			throw new Exception("installEquinoxforWindows - Failed - Exception occurs: " + exception);
		}
		logger.info("installEquinoxforWindows - completed...\n");		
    }
	
	
	public void verifyEquinoxUpdateAvailable (WindowsDriver winRootDriver, String currentVersion, String newVersion) throws Exception{
		logger.info("verifyEquinoxUpdateAvailabl - starting...\n");
		winClientDriver = createWinHandleDriver(winRootDriver, "Avaya Engage Settings");
		try {
			Thread.sleep(1000);
			selenium.clickElement(winClientDriver, windowsClient.SETTING_WINDOWS_SUPPORT_TAB_CHECK_UPDATE_BTN);
			Thread.sleep(10000);
			winClientDriver = createWinHandleDriver(winRootDriver, "Software Update");
			selenium.elementShouldExisted(winClientDriver, windowsClient.SOFTWARE_UPDATE_MAIN_ANNOUNCEMENT_TXT);
			selenium.elementShouldExisted(winClientDriver, windowsClient.softwareUpdateContent(newVersion, currentVersion));
			selenium.clickElement(winClientDriver, windowsClient.SOFTWARE_UPDATE_WINDOW_SKIP_VERSION_BTN);
		} catch (Exception exception) {
		
			logger.error("verifyEquinoxUpdateAvailabl - Failed with Exception: " + exception + "...\n");
			throw new Exception("verifyEquinoxUpdateAvailabl - Failed - Exception occurs: " + exception);
		}
		logger.info("verifyEquinoxUpdateAvailabl - completed...\n");		
    }
	
	public void installUpdateEquinoxforWindows (WindowsDriver winRootDriver, String currentVersion, String newVersion) throws Exception{
		logger.info("verifyEquinoxUpdateAvailabl - starting...\n");
		try {
			winClientDriver = createWinHandleDriver(winRootDriver, "Avaya Engage Settings");
			Thread.sleep(1000);
			selenium.clickElement(winClientDriver, windowsClient.SETTING_WINDOWS_SUPPORT_TAB_CHECK_UPDATE_BTN);
			winClientDriver = createWinHandleDriver(winRootDriver, "Software Update");
			selenium.elementShouldExisted(winClientDriver, windowsClient.SOFTWARE_UPDATE_MAIN_ANNOUNCEMENT_TXT);
			selenium.elementShouldExisted(winClientDriver, windowsClient.softwareUpdateContent(newVersion, currentVersion));
			selenium.clickElement(winClientDriver, windowsClient.SOFTWARE_UPDATE_WINDOW_INSTALL_UPDATE_BTN);
			
			Thread.sleep(10000);
			winClientDriver = createWinHandleDriver(winRootDriver, "Software Update");
			selenium.clickElement(winClientDriver, windowsClient.SOFTWARE_UPDATE_WINDOW_INSTALL_UPDATE_BTN);
			
			winClientDriver = createWinHandleDriver(winRootDriver, "Software Update");
			if(selenium.isElementExisted(winClientDriver, windowsClient.DESKTOP_SECURITY_WARNING_RUN_BTN)) {
		        	selenium.clickElement(winClientDriver,windowsClient.DESKTOP_SECURITY_WARNING_RUN_BTN);
		        }
		    Thread.sleep(3000);
			winClientDriver = createWinHandleDriver(winRootDriver, "Avaya Equinox Setup");
		    selenium.clickElement(winClientDriver,windowsClient.DESKTOP_SETUP_WINDOW_NEXT_BTN);
		    Thread.sleep(1000);
			winClientDriver = createWinHandleDriver(winRootDriver, "Avaya Equinox Setup");
		    selenium.clickElement(winClientDriver, windowsClient.DESKTOP_SETUP_WINDOW_ACCEPT_CHECKBOX);
			winClientDriver = createWinHandleDriver(winRootDriver, "Avaya Equinox Setup");
		    selenium.clickElement(winClientDriver,windowsClient.DESKTOP_SETUP_WINDOW_NEXT_BTN);
			winClientDriver = createWinHandleDriver(winRootDriver, "Avaya Equinox Setup");
		    selenium.clickElement(winClientDriver,windowsClient.DESKTOP_SETUP_WINDOW_NEXT_BTN);
			winClientDriver = createWinHandleDriver(winRootDriver, "Avaya Equinox Setup");
		    selenium.clickElement(winClientDriver,windowsClient.DESKTOP_SETUP_WINDOW_NEXT_BTN);
			winClientDriver = createWinHandleDriver(winRootDriver, "Avaya Equinox Setup");
		    selenium.clickElement(winClientDriver,windowsClient.DESKTOP_SETUP_WINDOW_NEXT_BTN);
			winClientDriver = createWinHandleDriver(winRootDriver, "Avaya Equinox Setup");
		    selenium.clickElement(winClientDriver,windowsClient.DESKTOP_SETUP_WINDOW_INSTALL_BTN);
		    Thread.sleep(5000);
		    
			winClientDriver = createWinHandleDriver(winRootDriver, "Avaya Equinox Setup");
		    selenium.clickElement(winClientDriver,windowsClient.DESKTOP_SETUP_WINDOW_FINISH_BTN);
			winClientDriver = createWinHandleDriver(winRootDriver, "AADS_TestingFiles");
		    selenium.clickElement(winClientDriver,windowsClient.DESKTOP_WINDOWS_BTN_CLOSE);
			
			
		} catch (Exception exception) {
			logger.error("verifyEquinoxUpdateAvailabl - Failed with Exception: " + exception + "...\n");
			throw new Exception("verifyEquinoxUpdateAvailabl - Failed - Exception occurs: " + exception);
		}
		logger.info("verifyEquinoxUpdateAvailabl - completed...\n");		
    }
	
	public void verifyEquinoxUpdateToDate (WindowsDriver winRootDriver) throws Exception{
		logger.info("verifyEquinoxUpdateToDate - starting...\n");
		try {
			winClientDriver = createWinHandleDriver(winRootDriver, "Avaya Engage Settings");
			Thread.sleep(1000);
			selenium.clickElement(winClientDriver, windowsClient.SETTING_WINDOWS_SUPPORT_TAB_CHECK_UPDATE_BTN);
			winClientDriver = createWinHandleDriver(winRootDriver, "Software Update");
			selenium.elementShouldExisted(winClientDriver, windowsClient.SOFTWARE_UPDATE_WINDOW_UP_TO_DATE_TXT);
			selenium.elementShouldExisted(winClientDriver, windowsClient.SOFTWARE_UPDATE_WINDOW_NEWEST_VERSION_TXT);
			selenium.clickElement(winClientDriver, windowsClient.SOFTWARE_UPDATE_WINDOW_CLOSE_BTN);
		} catch (Exception exception) {
			logger.error("verifyEquinoxUpdateToDate - Failed with Exception: " + exception + "...\n");
			throw new Exception("verifyEquinoxUpdateToDate - Failed - Exception occurs: " + exception);
		}
		logger.info("verifyEquinoxUpdateToDate - completed...\n");		
    }
	public void Escape(WindowsDriver winRootDriver) throws Exception{
		logger.info("Escape - starting...\n");
		int i=0;
		while (true) {
		try {
			if(i==3) break;
			if(selenium.isElementExisted(winClientDriver, windowsClient.MAIN_WINDONS_CONTACT_TAB_POPUP_DISMISS_BTN)) {
				selenium.waitUntilElementClickable(winClientDriver, windowsClient.MAIN_WINDONS_CONTACT_TAB_POPUP_DISMISS_BTN, 200);
				selenium.clickElement(winClientDriver, windowsClient.MAIN_WINDONS_CONTACT_TAB_POPUP_DISMISS_BTN);
			}
			if(selenium.isElementExisted(winClientDriver, windowsClient.SETTING_WINDOWS_CLOSE_BTN))
			selenium.clickElement(winClientDriver, windowsClient.SETTING_WINDOWS_CLOSE_BTN);
			Thread.sleep(3000);
			selenium.clickElement(winClientDriver, windowsClient.MAIN_WINDOWS_AVATAR_BTN);
			selenium.clickElement(winClientDriver, windowsClient.MAIN_WINDOWS_SIGN_OUT_TEXT);
			Thread.sleep(7000);
			selenium.clickElement(winClientDriver, windowsClient.FIRST_WINDOWS_SIGN_IN_BTN);
			break;
		}
		catch(Exception exception){
			logger.error("Escape - Failed with Exception: " + exception + "...\n");
			i++;
		}}
		logger.info("Escape -complete...\n");
	}
	
	public void settingWindowsServicesTabShowDetails(WindowsDriver winRootDriver) throws Exception{
		logger.info("settingWindowsServicesTabShowDetails - starting...\n");

		try {
			if (selenium.isElementExisted(winClientDriver, windowsClient.SETTING_WINDOWS_SERVICES_TAB_SHOW_DETAILS_BTN)){
				selenium.clickElement(winClientDriver, windowsClient.SETTING_WINDOWS_SERVICES_TAB_SHOW_DETAILS_BTN);
				Thread.sleep(2000);		
			}
		} catch (Exception exception) {
			logger.error("settingWindowsServicesTabShowDetails - Failed with Exception: " + exception + "...\n");
			throw new Exception("settingWindowsServicesTabShowDetails - Failed - Exception occurs: " + exception);
		}
		logger.info("settingWindowsServicesTabShowDetails - completed...\n");		
    }
	
	
	public void closeSettingWindow(WebDriver winClientDriver) throws Exception{
		try {
			selenium.waitUntilElementClickable(winClientDriver, windowsClient.SETTING_WINDOWS_CLOSE_BTN, 200);
			selenium.clickElement(winClientDriver, windowsClient.SETTING_WINDOWS_CLOSE_BTN);
		} catch (Exception e) {
			logger.error("closeSettingWindow - Failed with Exception: " + e + "...\n");
			throw new Exception("closeSettingWindow - Failed - Exception occurs: " + e);
		}
	}
	
	public void verifyServerConfig(WebDriver winClientDriver, String serverName, String add, String port ) throws Exception{
		logger.info("Verify Server Config");
		try {
			String server = selenium.getAttribute(winClientDriver, windowsClient.SETTING_WINDOWS_LDAP_SERVER, "Name");
			String aport = selenium.getAttribute(winClientDriver, windowsClient.SETTING_WINDOWS_LDAP_PORT, "Name");
			if(add.equalsIgnoreCase(server)){
				logger.info("Verify Server Config - PASSED");
			}else
			{
				throw new Exception("Failed - Actual Address: " + server + " and Port: " + aport );
				
			}
		} catch (Exception e) {
			logger.error("checkForUpdates - Failed with Exception: " + e + "...\n");
			throw new Exception("checkForUpdates - Failed - Exception occurs: " + e);
		}}
}
