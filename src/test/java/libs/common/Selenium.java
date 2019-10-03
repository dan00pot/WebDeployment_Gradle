package libs.common;

import java.awt.Dimension;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;
import java.time.Duration;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.concurrent.TimeUnit;
import java.util.function.Function;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.TouchAction;
import io.appium.java_client.functions.ExpectedCondition;
import io.appium.java_client.touch.offset.PointOption;
import io.qameta.allure.Allure;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.JavascriptExecutor;

public class Selenium {

	public int timeout = 10;
	Duration duration = Duration.ofMinutes(1);
	final Logger logger = LogManager.getLogger("Selenium Keywords");

	public WebElement waitForElementActive(WebDriver driver, By element, int timeout)
			throws Exception {
		WebElement webElement = null;
		try {
			int expired = 0;
			while (expired <= timeout) {
				expired = expired + 1;
				if (driver.findElements(element).size() <= 3 && driver.findElements(element).size() > 0 ) {
					logger.info("Found element: "+ driver.findElements(element));
					return webElement = driver.findElement(element);
				} else if (driver.findElements(element).size() == 0) {
					logger.info("No matched element- Waiting: "+ expired);
				} else {
					logger.info("Error many element - size: "+ driver.findElements(element).size());
					logger.info("Error many elements - element: "+ element);
				}
				Thread.sleep(1000);
			}
		} catch (Exception e) {
			throw new Exception("waitForElementActive - Failed - Exception occurs: " + e);
		}
		return webElement;
	}
	
	
	public WebElement waitForElementActive(WebDriver driver, By element)
			throws Exception {
		WebElement webElement = null;
		try {
			int expired = 0;
			while (expired <= 30) {
				expired = expired + 1;
				if (driver.findElements(element).size() <= 3 && driver.findElements(element).size() > 0 ) {
					logger.info("Found element: "+ driver.findElements(element));
					return webElement = driver.findElement(element);
				} else if (driver.findElements(element).size() == 0) {
					logger.info("No matched element " + element +"- Waiting: "+ expired );
				} else {
					logger.info("Error many element - size: "+ driver.findElements(element).size());
					logger.info("Error many elements - element: "+ element);
				}
				Thread.sleep(1000);
			}
		} catch (Exception e) {
			throw new Exception("waitForElementActive - Failed - Exception occurs: " + e);
		}
		return webElement;
	}

	public WebElement waitUntilElementVisible(WebDriver driver, By element)
			throws Exception {
		WebElement webElement = null;
		try {
			WebDriverWait wait = new WebDriverWait(driver, timeout);
			webElement = waitForElementActive(driver, element);
			wait.until(ExpectedConditions.visibilityOf(webElement));
		} catch (Exception e) {
			throw e;
		}
		return webElement;
	}
	
	public WebElement waitUntilElementInvisible(WebDriver driver, By element)
			throws Exception {
		WebElement webElement = null;
		try {
			WebDriverWait wait = new WebDriverWait(driver, timeout);
			webElement = waitForElementActive(driver, element);
			wait.until(ExpectedConditions.invisibilityOf(webElement));
		} catch (Exception e) {
			throw e;
		}
		return webElement;
	}

	public WebElement waitUntilElementClickable(WebDriver driver, By element) throws Exception {
		WebElement webElement = null;
		try {
			WebDriverWait wait = new WebDriverWait(driver, timeout);
			webElement = waitForElementActive(driver, element);
			wait.until(ExpectedConditions.elementToBeClickable(webElement));
		} catch (Exception e) {
			throw new Exception("waitUntilElementClickable - Failed - Exception occurs: " + e);
		}
		return webElement;
	}
	
	public WebElement waitUntilElementClickable(WebDriver driver, By element, int timeout) throws Exception {
		WebElement webElement = null;
		try {
			WebDriverWait wait = new WebDriverWait(driver, timeout);
			webElement = waitForElementActive(driver, element);
			wait.until(ExpectedConditions.elementToBeClickable(webElement));
		} catch (Exception e) {
			throw new Exception("waitUntilElementClickable - Failed - Exception occurs: " + e);
		}
		return webElement;
	}

	public void clickElement(WebDriver driver, By element) throws Exception {
		try {
			WebElement webElement = waitUntilElementClickable(driver, element);
			webElement.click();
		} catch (Exception e) {
			throw new Exception("isElementExisted - Failed - Exception occurs: " + e);
		}
	}

	public void inputText(WebDriver driver, By element, String text)
			throws Exception {
		try {
			WebElement webElement = waitUntilElementVisible(driver, element);
			webElement.clear();
			webElement.sendKeys(text);

		} catch (Exception e) {
			throw new Exception("inputText - Failed - Exception occurs: " + e);
		}
	}

	public boolean isElementExist(WebDriver driver, By element)
			throws Exception {
		try {
			boolean flag = waitUntilElementVisible(driver, element)
					.isDisplayed();

		} catch (Exception e) {
			throw e;
		}
		return true;
	}

	public boolean isElementExisted(WebDriver driver, By byLocator)
			throws Exception {
		try {
			if (driver.findElements(byLocator).size() == 0) {
				return false;
			} else
				return true;

		} catch (Exception ex) {
			throw new Exception(
					"isElementExisted - Failed - Exception occurs: " + ex);
		}
	}

	public void switchToFrame(WebDriver driver, By element) throws Exception {
		try {
			WebElement fr = waitUntilElementVisible(driver, element);
			driver.switchTo().frame(fr);
		} catch (Exception ex) {
			throw new Exception("switchToFrame - Failed - Exception occurs: "
					+ ex);
		}
	}

	public void dropDownListBox(WebDriver driver, By byLocator, String text)
			throws Exception {
		try {
			WebElement element = waitUntilElementClickable(driver, byLocator);
			Select dropDown = new Select(element);
			dropDown.selectByVisibleText(text);
		} catch (Exception ex) {
			throw new Exception("clickElement - Failed - Exception occurs: "
					+ ex);
		}
	}

	public boolean isElementSelected(WebDriver driver, By byLocator)
			throws Exception {
		try {
			WebElement element = driver.findElement(byLocator);
			if (element.isSelected()) {
				return true;
			} else
				return false;

		} catch (Exception ex) {

			throw new Exception(
					"isElementSelected - Failed - Exception occurs: " + ex);
		}

	}

	public void scrollToElement(WebDriver driver, By byLocator)
			throws Exception {
		try {
			WebElement element = driver.findElement(byLocator);
			((JavascriptExecutor) driver).executeScript(
					"arguments[0].scrollIntoView(true);", element);
			Thread.sleep(1500);
		} catch (Exception ex) {
			throw new Exception("scrollToElement - Failed - Exception occurs: "
					+ ex);
		}
	}

	public void clickElementByText(WebDriver driver, String name)
			throws Exception {
		try {
			WebElement element = waitUntilElementClickable(driver,
					By.linkText(name));
			element.click();
		} catch (Exception ex) {
			throw new Exception("clickElement - Failed - Exception occurs: "
					+ ex);
		}
	}

	public String getText(WebDriver driver, By byLocator) throws Exception {
		try {
			WebElement element = waitUntilElementVisible(driver, byLocator);
			String text = element.getText();
			return text;
		} catch (Exception ex) {
			throw new Exception("getText - Failed - Exception occurs: " + ex);
		}
	}

	public void switchToDefaultContent(WebDriver driver) throws Exception {
		try {
			driver.switchTo().defaultContent();
		} catch (Exception ex) {
			throw new Exception(
					"switchToDefaultContent - Failed - Exception occurs: " + ex);
		}
	}

	public void inputText2(WebDriver driver, By byLocator, String text)
			throws Exception {
		try {
			logger.info("inputText starting...\n");
			logger.info("byLocator: " + byLocator + "\n");
			logger.info("text: " + text + "\n");
			WebElement element = driver.findElement(byLocator);

			String currentText = element.getAttribute("value");
			logger.info("getAttribute: " + currentText);
			boolean isExistCharacter = true;
			do {
				currentText = element.getAttribute("value");
				logger.info("getAttribute: " + currentText);
				if (currentText.equals("")) {
					isExistCharacter = false;
				} else {
					element.click();
					element.sendKeys(Keys.CONTROL + "a");
					element.sendKeys(Keys.DELETE);
				}
			} while (isExistCharacter);
			Thread.sleep(200);
			logger.info("clearText completed...\n");
			// element.clear();
			element.sendKeys(text);
			Thread.sleep(1000);
			logger.info("inputText completed...\n");
		} catch (Exception ex) {
			logger.error("inputText - Failed - Exception occurs: " + ex + "\n");
			throw new Exception("inputText - Failed - Exception occurs: " + ex);
		}
	}

	public boolean isElementTexboxContainText(WebDriver driver, By byLocator,
			String text) throws Exception {
		try {
			logger.info("isElementContainText starting...\n");
			logger.info("byLocator: " + byLocator + "\n");
			WebElement element = driver.findElement(byLocator);
			String etext = element.getAttribute("value");

			if (etext.contains(text)) {
				logger.info("isElementContainText completed - Text: " + etext);
				return true;
			} else
				logger.info("isElementContainText completed - Expected text: "
						+ text + " but actual: " + etext);
			return false;

		} catch (Exception e) {
			logger.error("isElementContainText - Failed - Exception occurs: "
					+ e + "\n");
			throw new Exception(
					"isElementContainText - Failed - Exception occurs: " + e);
		}
	}

	public void clickElementInObjectUsingJavascriptById(WebDriver driver,
			By object, String stringLocator) throws Exception {
		try {
			logger.info("clickElementInObjectUsingJavascript starting...\n");
			logger.info("byLocator: " + object + "\n");
			WebElement objectPage = driver.findElement(object);

			JavascriptExecutor executor = (JavascriptExecutor) driver;
			executor.executeScript(
					"return (arguments[0].contentDocument.getElementById('"
							+ stringLocator + "')).click()", objectPage);
			// executor.executeScript("return (arguments[0].contentDocument.getElementBy('"+stringLocator+"')).click()",objectPage);
		} catch (Exception ex) {
			logger.error("clickElementUsingJavascript - Failed - Exception occurs: "
					+ ex + "\n");
			throw new Exception(
					"clickElementUsingJavascript - Failed - Exception occurs: "
							+ ex);
		}
	}

	public void clickElementInObjectUsingJavascriptByClass(WebDriver driver,
			By object, String stringLocator) throws Exception {
		try {
			logger.info("clickElementInObjectUsingJavascript starting...\n");
			logger.info("byLocator: " + object + "\n");
			WebElement objectPage = driver.findElement(object);

			JavascriptExecutor executor = (JavascriptExecutor) driver;
			executor.executeScript(
					"return (arguments[0].contentDocument.getElementById('"
							+ stringLocator + "')).click()", objectPage);
			// executor.executeScript("return (arguments[0].contentDocument.getElementBy('"+stringLocator+"')).click()",objectPage);
		} catch (Exception ex) {
			logger.error("clickElementUsingJavascript - Failed - Exception occurs: "
					+ ex + "\n");
			throw new Exception(
					"clickElementUsingJavascript - Failed - Exception occurs: "
							+ ex);
		}
	}

	public void inputTextElementInObjectUsingJavascript(WebDriver driver,
			By object, String stringLocator, String text) throws Exception {
		try {
			logger.info("inputTextElementInObjectUsingJavascript starting...\n");
			logger.info("byLocator: " + object + "\n");
			WebElement objectPage = driver.findElement(object);
			JavascriptExecutor executor = (JavascriptExecutor) driver;
			executor.executeScript(
					"return (arguments[0].contentDocument.getElementById('"
							+ stringLocator
							+ "')).setAttribute('value','Huy.com')", objectPage);
		} catch (Exception ex) {
			logger.error("clickElementUsingJavascript - Failed - Exception occurs: "
					+ ex + "\n");
			throw new Exception(
					"clickElementUsingJavascript - Failed - Exception occurs: "
							+ ex);
		}
	}

	public void setTextElementInObjectUsingJavascriptbyClass(WebDriver driver,
			By object, String stringLocator, String text) throws Exception {
		try {
			logger.info("inputTextElementInObjectUsingJavascript starting...\n");
			logger.info("byLocator: " + object + "\n");
			WebElement objectPage = driver.findElement(object);
			JavascriptExecutor executor = (JavascriptExecutor) driver;
			executor.executeScript(
					"return (arguments[0].contentDocument.getElementsByClassName('"
							+ stringLocator + "'))[0].setAttribute('value','"
							+ text + "')", objectPage);

		} catch (Exception ex) {
			logger.error("clickElementUsingJavascript - Failed - Exception occurs: "
					+ ex + "\n");
			throw new Exception(
					"clickElementUsingJavascript - Failed - Exception occurs: "
							+ ex);
		}
	}

	public void setTextElementInObjectUsingJavascriptbyCSS(WebDriver driver,
			By object, String stringCSS, String text) throws Exception {
		try {
			logger.info("Input text to element inside object by CSS starting...\n");
			logger.info("Object: " + object + "\n");
			logger.info("Text: " + text);
			WebElement objectPage = driver.findElement(object);
			JavascriptExecutor executor = (JavascriptExecutor) driver;
			executor.executeScript(
					"return (arguments[0].contentDocument.querySelectorAll(\""
							+ stringCSS + "\"))[0].setAttribute('value','"
							+ text + "')", objectPage);
		} catch (Exception ex) {
			logger.error("setTextElementInObjectUsingJavascriptbyCSS - Failed - Exception occurs: "
					+ ex + "\n");
			throw new Exception(
					"setTextElementInObjectUsingJavascriptbyCSS - Failed - Exception occurs: "
							+ ex);
		}
	}

	public void setTextElementInObjectUsingJavascriptbyId(WebDriver driver,
			By object, String stringId, String text) throws Exception {
		try {
			logger.info("Input text to element inside object by CSS starting...\n");
			logger.info("Object: " + object + "\n");
			logger.info("Text: " + text);
			WebElement objectPage = driver.findElement(object);
			JavascriptExecutor executor = (JavascriptExecutor) driver;
			executor.executeScript(
					"return (arguments[0].contentDocument.getElementById('"
							+ stringId + "')).setAttribute('value','" + text
							+ "')", objectPage);
		} catch (Exception ex) {
			logger.error("setTextElementInObjectUsingJavascriptbyCSS - Failed - Exception occurs: "
					+ ex + "\n");
			throw new Exception(
					"setTextElementInObjectUsingJavascriptbyCSS - Failed - Exception occurs: "
							+ ex);
		}
	}

	public void clickElementInObjectUsingJavascriptbyCSS(WebDriver driver,
			By object, String stringCSS) throws Exception {
		try {
			logger.info("inputTextElementInObjectUsingJavascript starting...\n");
			logger.info("byLocator: " + object + "\n");
			WebElement objectPage = driver.findElement(object);
			JavascriptExecutor executor = (JavascriptExecutor) driver;
			executor.executeScript(
					"return (arguments[0].contentDocument.querySelectorAll(\""
							+ stringCSS + "\"))[0].click()", objectPage);
		} catch (Exception ex) {
			logger.error("clickElementUsingJavascript - Failed - Exception occurs: "
					+ ex + "\n");
			throw new Exception(
					"clickElementUsingJavascript - Failed - Exception occurs: "
							+ ex);
		}
	}

	public boolean isElementcheckedJavascriptExecutor(WebDriver driver,
			By object, String stringId) throws Exception {
		try {
			logger.info("isElementSeclectedJavascriptExecutor starting...\n");
			logger.info("byLocator: " + object + "\n");
			WebElement objectPage = driver.findElement(object);
			JavascriptExecutor executor = (JavascriptExecutor) driver;
			return executor.executeScript(
					"return (arguments[0].contentDocument.getElementById('"
							+ stringId + "')).checked", objectPage) != null;

		} catch (Exception ex) {
			logger.error("clickElementUsingJavascript - Failed - Exception occurs: "
					+ ex + "\n");
			throw new Exception(
					"clickElementUsingJavascript - Failed - Exception occurs: "
							+ ex);
		}
	}

	public boolean compareValueFromTheList(WebDriver driver, By byLocator)
			throws Exception {
		logger.info("compareValueFromTheList starting...\n");

		try {
			WebElement option = driver.findElement(byLocator);
			Select dropDown = new Select(option);
			List<WebElement> element = dropDown.getOptions();
			String[] exp = { "NONE", "OPTIONAL", "OPTIONAL_NO_CA", "REQUIRED" };
			Boolean found = false;
			for (WebElement e : element) {
				for (int i = 0; i < exp.length; i++) {
					if (e.getText().equals(exp[i])) {
						found = true;
						logger.info("Element exist as expected - Text: "
								+ exp[i]);
					}
				}
				if (!found) {
					logger.info("Actual:" + e.getText() + "not as expected"
							+ "...\n");
					break;
				}
			}
			return found;
		} catch (Exception exception) {
			logger.error("compareValueFromTheList - Failed - Exception occurs: "
					+ exception + "\n");
			throw new Exception(
					"compareValueFromTheList - Failed - Exception occurs: "
							+ exception);
		}
	}

	public void dropDownListBoxByValue(WebDriver driver, By byLocator, String i)
			throws Exception {
		try {
			logger.info("clickElement starting...\n");
			logger.info("byLocator: " + byLocator + "\n");
			WebElement element = driver.findElement(byLocator);
			Select dropDown = new Select(element);
			dropDown.selectByValue(i);
			logger.info("clickElement completed...\n");
		} catch (Exception ex) {
			logger.error("clickElement - Failed - Exception occurs: " + ex
					+ "\n");
			throw new Exception("clickElement - Failed - Exception occurs: "
					+ ex);
		}
	}

	public boolean isElementContainText(WebDriver driver, By byLocator,
			String text) throws Exception {
		try {
			logger.info("isElementContainText starting...\n");
			logger.info("byLocator: " + byLocator + "\n");
			WebElement element = driver.findElement(byLocator);
			String etext = element.getText();

			if (etext.contains(text)) {
				logger.info("isElementContainText completed - Text: " + etext);
				return true;
			} else
				logger.info("isElementContainText completed - Expected text: "
						+ text + " but actual: " + etext);
			return false;

		} catch (Exception e) {
			logger.error("isElementContainText - Failed - Exception occurs: "
					+ e + "\n");
			throw new Exception(
					"isElementContainText - Failed - Exception occurs: " + e);
		}
	}

	public String getAttribute(WebDriver driver, By byLocator, String attribute)
			throws Exception {
		try {
			logger.info("getAttribute starting...\n");
			logger.info("byLocator: " + byLocator + "\n");
			logger.info("attribute: " + attribute + "\n");
			WebElement element = driver.findElement(byLocator);
			String attributeValue = element.getAttribute(attribute);
			logger.info("value is: " + attributeValue);
			logger.info("getAttribute completed...\n");

			return attributeValue;
		} catch (Exception ex) {
			logger.error("clickElement - Failed - Exception occurs: " + ex
					+ "\n");
			throw new Exception("clickElement - Failed - Exception occurs: "
					+ ex);
		}
	}

	public void clearText(WebDriver driver, By byLocator) throws Exception {
		try {
			logger.info("clearText starting...\n");
			logger.info("byLocator: " + byLocator + "\n");
			WebElement element = driver.findElement(byLocator);
			String currentText = element.getAttribute("value");
			logger.info("Hoang: getAttribute: " + currentText);
			boolean isExistCharacter = true;
			do {
				currentText = element.getAttribute("value");
				if (currentText.equals("")) {
					isExistCharacter = false;
				} else {
					element.click();
					element.sendKeys(Keys.CONTROL + "a");
					element.sendKeys(Keys.DELETE);
				}
			} while (isExistCharacter);
			Thread.sleep(200);
			logger.info("clearText completed...\n");
		} catch (Exception ex) {
			logger.error("clearText - Failed - Exception occurs: " + ex + "\n");
			throw new Exception("clearText - Failed - Exception occurs: " + ex);
		}
	}
	
	
	public void clickElementOverTop(WebDriver driver, By byLocator) throws Exception {
		logger.info("clickElementOverTop starting...\n");
		try {
			WebElement webElement = waitUntilElementClickable(driver, byLocator);
			Actions builder = new Actions(driver);
			builder.moveToElement(webElement).click().perform();
		} catch (Exception e) {
			logger.error("clickElementOverTop - Failed - Exception occurs: " + 3 + "\n");
			throw new Exception("clickElementOverTop - Failed - Exception occurs: " + 3);
		}
	}

	public void doubleClickElement(WebDriver driver, By byLocator)
			throws Exception {
		try {
			logger.info("doubleClickElement starting...\n");
			logger.info("byLocator: " + byLocator + "\n");
			WebElement element = waitUntilElementClickable(driver, byLocator);
			Actions action = new Actions(driver);
			action.doubleClick(element).build().perform();
			logger.info("doubleClickElement completed...\n");
		} catch (Exception ex) {
			logger.error("doubleClickElement - Failed - Exception occurs: "
					+ ex + "\n");
			throw new Exception(
					"doubleClickElement - Failed - Exception occurs: " + ex);
		}
	}
	
	public void tapCoordinates(AppiumDriver mobileClientDriver, int x, int y) throws Exception {
		try {
			logger.info("clickCoordinates starting...\n");
			TouchAction tapCoordinates = new TouchAction(mobileClientDriver);
	//		tapCoordinates.tap(x, y).perform();		
			tapCoordinates.tap(PointOption.point(x, y)).perform();
			logger.info("clickCoordinates completed...\n");
		} catch (Exception ex) {
			logger.error("clickCoordinates - Failed - Exception occurs: " + ex
					+ "\n");
			throw new Exception("clickCoordinates - Failed - Exception occurs: "
					+ ex);
		}
	}
	
	public void dragAndDropFromElementToPosion(WebDriver driver,
			By fromElementLocator, int xDemension, int yDimension)
			throws Exception {
		try {
			logger.info("dragAndDropElementToElement starting...\n");
			logger.info("fromElementLocator: " + fromElementLocator + "\n");
			logger.info("xDemension: " + xDemension + "\n");
			logger.info("yDimension: " + yDimension + "\n");

			String fromLocation = getAttribute(driver, fromElementLocator,
					"ClickablePoint");
			String xFrom = fromLocation.split(",")[0];
			String yFrom = fromLocation.split(",")[1];

			Robot robot = new Robot();
			robot.mouseMove(Integer.parseInt(xFrom), Integer.parseInt(yFrom));
			robot.delay(1000);
			robot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
			robot.delay(2000);
			robot.mouseMove(Integer.parseInt(xFrom) - 20,
					Integer.parseInt(yFrom));
			robot.delay(2000);
			robot.mouseMove(xDemension, yDimension);
			robot.delay(1000);
			robot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
			robot.delay(1000);

			logger.info("dragAndDropElementToElement completed...\n");

		} catch (Exception ex) {
			
			logger.error("dragAndDropElementToElement - Failed - Exception occurs: "
					+ ex + "\n");
			throw new Exception(
					"dragAndDropElementToElement - Failed - Exception occurs: "
							+ ex);
		}
	}
	
	public void elementShouldBeExisted(AppiumDriver mobileClientDriver, By byLocator)
			throws Exception {
		try {
			logger.info("elementShouldBeExisted starting...\n");
			logger.info("byLocator: " + byLocator + "\n");
			if (mobileClientDriver.findElements(byLocator).size() == 0) {
				logger.error("elementShouldBeExisted - Failed - Element not existed: ");
				throw new Exception(
						"elementShouldBeExisted - Failed - Element not Existed: ");
			}
			logger.info("elementShouldBeExisted completed...\n");
		} catch (Exception ex) { 
			logger.error("elementShouldBeExisted - Failed - Exception occurs: "
					+ ex + "\n");
			throw new Exception(
					"elementShouldBeExisted - Failed - Exception occurs: " + ex);
		}
	}
	
	public void mouseHover(WebDriver driver, By byLocator) throws Exception {
		try {
			logger.info("mouseHover starting...\n");
			logger.info("byLocator: " + byLocator + "\n");
			moveMouseToTheCornorOfScreen(driver);
			WebElement element = driver.findElement(byLocator);
			Actions action = new Actions(driver);
			action.moveToElement(element).build().perform();
			Thread.sleep(1500);
			logger.info("mouseHover completed...\n");
		} catch (Exception ex) {
			logger.error("mouseHover - Failed - Exception occurs: " + ex + "\n");
			throw new Exception("mouseHover - Failed - Exception occurs: " + ex);
		}
	}
	
	public void moveMouseToTheCornorOfScreen(WebDriver driver) throws Exception {
		try {
			logger.info("moveMouseToTheCornorOfScreen starting...\n");
			Robot robot = new Robot();
			Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
			int height = (int) screenSize.getHeight();
			robot.mouseMove(0, (int) height);
			Thread.sleep(1500);
			logger.info("moveMouseToTheCornorOfScreen completed...\n");
		} catch (Exception ex) {
			logger.error("moveMouseToTheCornorOfScreen - Failed - Exception occurs: "
					+ ex + "\n");
			throw new Exception(
					"moveMouseToTheCornorOfScreen - Failed - Exception occurs: "
							+ ex);
		}
	}
	
	public void rightClickElement(WebDriver driver, By byLocator)
			throws Exception {
		try {
			logger.info("rightClickElement starting...\n");
			logger.info("byLocator: " + byLocator + "\n");
			WebElement element = driver.findElement(byLocator);
			Actions action = new Actions(driver);
			action.contextClick(element).build().perform();
			logger.info("rightClickElement completed...\n");
		} catch (Exception ex) {
			logger.error("rightClickElement - Failed - Exception occurs: " + ex
					+ "\n");
			throw new Exception(
					"rightClickElement - Failed - Exception occurs: " + ex);
		}
	}
	
	public void elementShouldExisted(WebDriver driver, By byLocator)
			throws Exception {
		try {
			logger.info("elementShouldExisted starting...\n");
			logger.info("byLocator: " + byLocator + "\n");
			if (driver.findElements(byLocator).size() == 0) {
				logger.error("elementShouldExisted - Failed - Element not existed: ");
				throw new Exception(
						"elementShouldExisted - Failed - Element not Existed: ");
			}
			logger.info("elementShouldExisted completed...\n");
		} catch (Exception ex) {
			logger.error("elementShouldExisted - Failed - Exception occurs: "
					+ ex + "\n");
			throw new Exception(
					"elementShouldExisted - Failed - Exception occurs: " + ex);
		}
	}
	
	public void moveToElement(WebDriver driver, By elementLocator)
			throws Exception {
		try {
			logger.info("moveToElement starting...\n");
			logger.info("elementLocator: " + elementLocator + "\n");

			String fromLocation = getAttribute(driver, elementLocator,
					"ClickablePoint");
			String xFrom = fromLocation.split(",")[0];
			String yFrom = fromLocation.split(",")[1];

			Robot robot = new Robot();
			robot.mouseMove(Integer.parseInt(xFrom), Integer.parseInt(yFrom));
			robot.delay(1000);

			logger.info("moveToElement completed...\n");

		} catch (Exception ex) {
			
			logger.error("moveToElement - Failed - Exception occurs: " + ex
					+ "\n");
			throw new Exception("moveToElement - Failed - Exception occurs: "
					+ ex);
		}
	}
	public void enter(WebDriver driver)	throws Exception {
		try {
			logger.info("Press ENTER - starting...\n");
		
			Robot robot = new Robot();
			robot.keyPress(KeyEvent.VK_ENTER);
		    robot.keyRelease(KeyEvent.VK_ENTER);
		    robot.delay(1000);
			logger.info("Press ENTER completed...\n");
		} catch (Exception ex) {
			
			logger.error("Press ENTER - Failed - Exception occurs: "
					+ ex + "\n");
			throw new Exception(
					"Press ENTER - Failed - Exception occurs: " + ex);
		}
	}
	
	public boolean checkElementExistedOrNotExisted(WebDriver driver, By byLocator)
			throws Exception {
		try {
			logger.info("checkElementExistedOrNotExisted starting...\n");
			logger.info("byLocator: " + byLocator + "\n");
			if (driver.findElements(byLocator).size() != 0) {
				logger.info("checkElementExistedOrNotExisted completed - Not Existed...\n");
				return false;
			} else 
				logger.info("checkElementExistedOrNotExisted completed - Existed...\n");
			return true;

		} catch (Exception ex) {
			
			logger.error("checkElementExistedOrNotExisted - Failed - Exception occurs: " + ex
					+ "\n");
			throw new Exception(
					"checkElementExistedOrNotExisted - Failed - Exception occurs: " + ex);
		}
	}
	
	public void windowsE(WebDriver driver)	throws Exception {
		try {

			Robot robot = new Robot();
			robot.keyPress(KeyEvent.VK_WINDOWS);
			robot.keyPress(KeyEvent.VK_E);
		    robot.keyRelease(KeyEvent.VK_WINDOWS);
		    robot.keyRelease(KeyEvent.VK_E);
		    
			logger.info("Press Windows + E - completed...\n");
		} catch (Exception ex) {
			
			logger.error("Press Windows + E - Failed - Exception occurs: "
					+ ex + "\n");
			throw new Exception(
					"Press Windows + E - Failed - Exception occurs: " + ex);
		}
	}
}
