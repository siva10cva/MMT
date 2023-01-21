package com.makemytrip.baseclass;
import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;
@Test
public class test {
	
		static WebDriver driver = null;
		public static void passSendKeys(WebElement element, String value) {
			element.sendKeys(value);
		}

		public static void passClick(WebElement element) {
			element.click();
		}

		public static void passClear(WebElement element) {
			element.clear();
		}

		public static void passSleep() throws InterruptedException {
			Thread.sleep(5000);
		}

		public static String passText(WebElement element) {
			String get_Text = element.getText();
			return get_Text;
		}

		public static void passAttribute(WebElement element, String value) {
			String attribute = element.getAttribute(value);
			System.out.println(attribute);
		}

		public static void passSelected(WebElement element) {
			boolean isSelected = element.isSelected();
			System.out.println(isSelected);

		}

		public static void passEnabled(WebElement element) {
			boolean isEnabled = element.isEnabled();
			System.out.println(isEnabled);

		}

		public static void passDisplayed(WebElement element) {
			boolean isDisplayed = element.isDisplayed();
			System.out.println(isDisplayed);
		}

	//WebDriver Methods
		public WebDriver browserLaunch(String browser)
		{
			if (browser.equalsIgnoreCase("chrome")) {
				   ChromeOptions options = new ChromeOptions();
				   options.addArguments("start-maximized");
				   WebDriverManager.chromedriver().setup();
				    driver = new ChromeDriver(options);
				  }
			
			else if (browser.equalsIgnoreCase("edge")) {
				   WebDriverManager.edgedriver().setup();
				    driver = new EdgeDriver();
				  } 

			else if (browser.equalsIgnoreCase("gecko")) {

				   WebDriverManager.firefoxdriver().setup();
				    driver = new FirefoxDriver();

				  } else {
				   System.out.println("the invalid browser");
				  }
				  return driver;
		
		}
		
		public static void maximize() {
			  driver.manage().window().maximize();
			 }
			 public static void close() {
			  driver.close();
			 }
			 public static void quit() {
			  driver.quit();
			 }
			 public static void fullScreen() {
			  driver.manage().window().fullscreen();
			 }
			 public static void navigateTo(String url) {
			  driver.navigate().to(url);
			 }
			 
			 public static void navigateBack() {
			  driver.navigate().back();
			 }
			 public static void navigateForward() {
			  driver.navigate().forward();
			 }
			 public static void navigateRefresh() {
			  driver.navigate().refresh();
			 }
			 
			 public static String getTitle() {
			  String title = driver.getTitle();
			  return title;
			 }
			 
			 public static String getCurrentUrl() {
			  String currentUrl = driver.getCurrentUrl();
			  return currentUrl;
			 }
			 public static void launchUrl(String url) {
			  driver.get(url);
			 }
			 
			 
			 public static String getWindow() {
			  String windowHandle = driver.getWindowHandle();
			  return windowHandle;
			 }
			 
			 public static Set<String> getMultileWindow() {
			  Set<String> windowHandles = driver.getWindowHandles();
			  return windowHandles;
			 }

	public static void keyDown() throws AWTException {
	  Robot r = new Robot();
	  r.keyPress(KeyEvent.VK_DOWN);
	  r.keyRelease(KeyEvent.VK_DOWN);
	 }
	 
	 public static void keyEnter() {

	 }
	 
	 public static void acceptSendkeys(String value) {
	  driver.switchTo().alert().sendKeys(value);
	 }
	 
	 public static void alert(String option) {
	  
	  Alert alert = driver.switchTo().alert();
	  if(option.equalsIgnoreCase("ok")) {
	   alert.accept();
	  }else if(option.equalsIgnoreCase("cancel")) {
	   alert.dismiss();
	  }
	 }
	 
	 public static void frameSwitch(WebElement element) {
	  driver.switchTo().frame(element);
	 }
	 
	 public static void defaultContent() {
	  driver.switchTo().defaultContent();
	 }
	 
	 public static void parentFrame() {
	  driver.switchTo().parentFrame();
	 }
	 
	 public static int totalFrame(List<WebElement> element) {
	  int size = element.size();
	  return size;
	 
	 }
	 
	 public static  void mouseBasedActions(String option,WebDriver driver,WebElement element) {
	  Actions a = new Actions(driver);
	  if(option.equalsIgnoreCase("move")) {
	   a.moveToElement(element).build().perform();
	  }else if(option.equalsIgnoreCase("click")) {
	   a.click(element).perform();
	  }
	 }
	 
	 
	 public static void drpDownSelect(WebElement element,String option,String value) {

	  Select s = new Select(element);
	  
	  if(option.equalsIgnoreCase("value")) {
	   s.selectByValue(value);
	  }else if(option.equalsIgnoreCase("text")) {
	   s.selectByVisibleText(value);
	  }else if(option.equalsIgnoreCase("index")) {
	   int p = Integer.parseInt(value);
	   s.selectByIndex(p);
	   
	  }else {
	   System.out.println("invalid select");
	  }
	  
	 }
	 	}


