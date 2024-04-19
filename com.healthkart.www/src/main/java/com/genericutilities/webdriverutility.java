package com.genericutilities;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.Iterator;
import java.util.Set;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.Point;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class webdriverutility {
     /**
      * to maximize window
      * @param driver
      */
	public void maximizewindow(WebDriver driver)
	{
		driver.manage().window().maximize();
	}
	
	
	/**
	 * wait until page get loaded
	 * @param driver
	 * @param sec
	 */
	public void waitforpageload(WebDriver driver, int sec)
	{
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(sec));
	}
	
     ////////////////////////
   public WebDriverWait webdriverwaitobj(WebDriver driver, int sec)
   {
	   WebDriverWait wait= new WebDriverWait(driver, Duration.ofSeconds(sec));
	   return wait;
   }
	  
	public void waituntilEleToBeVisible(WebDriver driver, int sec, WebElement ele)
	{
		
	webdriverwaitobj(driver, sec).until(ExpectedConditions.visibilityOf(ele));
	}

	public void waituntilEleToBeClickable(WebDriver driver, int sec, WebElement ele)
	{
		webdriverwaitobj(driver, sec).until(ExpectedConditions.elementToBeClickable(ele));
	}
	
	
	public void waituntilToGetTitle(WebDriver driver, int sec, String title)
	{
		webdriverwaitobj(driver, sec).until(ExpectedConditions.titleContains(title));
	}
	
	public void waitUntilAlertToBEPresent(WebDriver driver, int sec)
	{
		webdriverwaitobj(driver, sec).until(ExpectedConditions.alertIsPresent());
	}
	//////////////////////////////////////////////
	
	public Select performDropdown(WebElement ele)
	{
		Select sel= new Select(ele);
		return sel;
	}
	public void handleDropdown(WebElement ele, String text)
	{
		
		performDropdown(ele).selectByVisibleText(text);
	}
	
	public void handleDropdown(WebElement ele, int index)
	{
		
		performDropdown(ele).selectByIndex(index);
	}

	public void handleDropdown( String text, WebElement ele)
	{
		
		performDropdown(ele).selectByValue(text);
	}
	
	
	//////////////////////////////////////////
	
	public void mousehover(WebDriver driver, WebElement element)
	{
		Actions act = new Actions(driver);
		act.click(element).perform();
	}
	
	
	//////////////////////////////////////////////
	
	public Actions performActions(WebDriver driver)
	{
		Actions act = new Actions(driver);
		return act;
	}

	public void dragAndDrop(WebDriver driver,WebElement src, WebElement dst)
	{
		performActions(driver).dragAndDrop(src, dst).perform();
	}	
	
	public void dragAndDrop(WebDriver driver,WebElement ele, int x, int y)
	{
		
		performActions(driver).dragAndDropBy(ele, x,y).perform();
	}

	public void doubleClick(WebDriver driver)
	{
		performActions(driver).doubleClick().perform();
	}
	
	public void doubleClick(WebDriver driver, WebElement element)
	{
		performActions(driver).doubleClick(element).perform();
	}
	
	public void rightClick(WebDriver driver)
	{
		performActions(driver).contextClick().perform();
	}
	
	public void rightClick(WebDriver driver, WebElement element)
	{
		performActions(driver).contextClick(element).perform();
	}

    public void enterKeyPress(WebDriver driver, WebElement element)
     {
      performActions(driver).sendKeys(element, Keys.ENTER).perform();
     }	
	
	public void switchtowindow(WebDriver driver, String expwind)
	{
		     Set<String> wins = driver.getWindowHandles();
		     Iterator<String> it = wins.iterator();
		     while(it.hasNext())
		     {
		    	 String win = it.next();
		    	 String currentTitle = driver.switchTo().window(win).getTitle();
		    	 if(currentTitle.contains(expwind))
		    	 {
		    		 break;
		    	 }
		     }
	}
	
	public Robot robotobj() throws AWTException {
		Robot rb = new Robot();
		return rb;
		
	}
	
	public void enterkey(WebDriver driver) throws AWTException
	{
		robotobj().keyPress(KeyEvent.VK_ENTER);
	}
	
	public void enterrelease(WebDriver driver) throws AWTException
	{
		robotobj().keyRelease(KeyEvent.VK_ENTER);
	}
	
	
	
	
	///////////////////////////////
	/**
	 * switch window based on index
	 * @param driver
	 * @param index
	 */
	
	public void switchtoframe(WebDriver driver,int index)
	{
		driver.switchTo().frame(index);
	}
	
	
	/**
	 * switch window based on name or ID
	 * @param driver
	 * @param nameorid
	 */
	public void switchtoframe(WebDriver driver,String nameorid)
	{
		driver.switchTo().frame(nameorid);
	}
	
	/**
	 * switch window based on address
	 * @param driver
	 * @param address
	 */
	public void switchtoframe(WebDriver driver, WebElement address)
	{
		driver.switchTo().frame(address);
	}
	
	////////////////////////////
	
	// alert PopUPs
	/**
	 * 
	 * @param driver
	 */
	public void acceptAlert(WebDriver driver)
	{
		driver.switchTo().alert().accept();
	}
	
	public void cancelAlert(WebDriver driver)
	{
		driver.switchTo().alert().dismiss();
	}
	
	//////////////////////
	
	/**
	 * to take screenshot
	 * @param driver
	 * @param screenshotname
	 * @return
	 * @throws IOException
	 */
	public static String getscreenshot(WebDriver driver, String screenshotname) throws IOException
	{
		javautility jutil = new javautility();
		String sysdate = jutil.getsystemdateInformat();
		TakesScreenshot ts= (TakesScreenshot) driver;
	    File src = ts.getScreenshotAs(OutputType.FILE);
	    String path= "./screenshot/"+screenshotname+""+sysdate+".png";
	    File dst = new File(path);
	    String srcpath=dst.getAbsolutePath();
	    FileUtils.copyFile(src, dst);
	     return srcpath;
	
	}
	
	
	/**
	 * this will perform random scroll
	 * @param driver
	 */
	public void scrollBarAction(WebDriver driver)
	{
		JavascriptExecutor jse= (JavascriptExecutor) driver;
		jse.executeScript("window.scrollBy(0,800)");
		
	}
	
	public void scrollAction(WebDriver driver, WebElement ele)
	{
		JavascriptExecutor jse= (JavascriptExecutor) driver;
		int y= ele.getLocation().getY();
		jse.executeScript("window.scrollBy(0,"+y+")", ele);
	}
	
	
	public void scrolltillEle(WebDriver driver, WebElement ele)
	{
		JavascriptExecutor jse= (JavascriptExecutor) driver;
		jse.executeScript("arguments[0].scrollIntoView()", ele);
	}
	
	
	public void  clickonelement(WebDriver driver, WebElement ele) 
	{
		JavascriptExecutor jse= (JavascriptExecutor) driver;
		jse.executeScript("arguments[0].click()", ele);
	}
	
	public void jseusingSendKeys(WebDriver driver, WebElement ele, String expData) 
	{
		JavascriptExecutor jse= (JavascriptExecutor) driver;
      jse.executeScript("arguments[0].value=arguments[1]", ele, expData);
	}
	
	public void scrollTillBottomofThePage(WebDriver driver) 
	{
		JavascriptExecutor jse= (JavascriptExecutor) driver;
		jse.executeScript("window.scrollBy(0,document.body.scrollHeight)");
	}
		
	public void scrollUPTillEleTobeVisible(WebDriver driver, WebElement ele)
	{
		JavascriptExecutor jse= (JavascriptExecutor) driver;
         Point loc = ele.getLocation();
         int x= loc.getX();
         int y= loc.getY();
         jse.executeScript("window.scrollBy("+x+","+y+")");
	
	}
		
	public ChromeOptions notificationPopUp() 
	{
		ChromeOptions opt= new ChromeOptions();
		opt.addArguments("--diasable-notifications");
		return opt;
	}
	
}
