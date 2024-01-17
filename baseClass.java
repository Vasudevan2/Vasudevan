package ebay;
import java.io.File;
import java.io.IOException;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class baseClass {

	 private static WebDriver driver;

	public static void browserLaunch() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
	}
public static void loadurl(String url) {
	
}

public static void fill(WebElement webelement,String text) {
	(webelement).sendKeys(text);
}
public static void click(WebElement enter) {
	enter.click();	
}
public static void findelementname(String name ){
	driver.findElement(By.name(name));
}
public static void pageTitle() {
	String title = driver.getTitle();
	System.out.println(title);
}
public static void pageUrl() {
	String currentUrl = driver.getCurrentUrl();
	System.out.println(currentUrl);
}
public static void windowMaximize() {
	driver.manage().window().maximize();
}
public static void applyWaitToAllElement() {
	driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);	
}
 public static void takesnap(String filename) throws IOException {
	 TakesScreenshot ts=(TakesScreenshot)driver;
	 File source = ts.getScreenshotAs(OutputType.FILE);
	 File destination =new File("C:\\Users\\janus\\eclipse-workspace\\Maven\\screenshots"+filename+".png");
	 FileUtils.copyFile(source, destination);
	
}
 public static void findsDateTime() {
	 java.util.Date d=new java.util.Date();
	
}
 public static void closeWebBrowser() {
	 driver.quit();
	
}
 public static void windowshandle() {
	
	 String parentid = driver.getWindowHandle();
     Set<String> allwindowsid = driver.getWindowHandles();
     for (String id:allwindowsid ) {
     	if (!id.equals(allwindowsid )) {
				driver.switchTo().window(id);
			}
}

	
 }
 public static void gettext() {
String title = driver.getTitle();
System.out.println(title);
}
 }
