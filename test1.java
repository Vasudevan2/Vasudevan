package ebay;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class test1 {
	class EbayTest {

	    private WebDriver driver;

	    @BeforeMethod
	    public void setUp() {
	        System.setProperty("webdriver.chrome.driver", "path/to/chromedriver"); // Update with the path to your ChromeDriver
	        driver = new ChromeDriver();
	        driver.manage().window().maximize();
	        driver.get("https://www.ebay.com");
	    }

	    @AfterMethod
	    public void tearDown() {
	        if (driver != null) {
	            driver.quit();
	        }
	    }

	    @Test
	    public void testScenario1() {
	        // Navigate to Cell Phones & accessories via category and apply multiple filters
	        driver.findElement(By.id("gh-shop-ei")).click(); // Click on "Shop by category"
	        driver.findElement(By.linkText("Electronics")).click(); // Click on Electronics
	        driver.findElement(By.linkText("Cell Phones & Accessories")).click(); // Click on Cell Phones & Accessories
	        driver.findElement(By.linkText("Cell Phones & Smartphones")).click(); // Click on Cell Phones & Smartphones

	        // Click on "All Filters"
	        WebElement allFiltersButton = driver.findElement(By.xpath("//button[text()='All Filters']"));
	        allFiltersButton.click();

	        // Apply filters - Condition, Price, Item location
	        selectFilter("Condition", "New");
	        selectFilter("Price", "$100 - $200");
	        selectFilter("Item Location", "United States");

	        // Verify that filter tags are applied
	        int filterTagCount = driver.findElements(By.className("x-close-icon")).size();
	        Assert.assertEquals(filterTagCount, 3, "Expected 3 filter tags, but found " + filterTagCount);
	    }

	    @Test
	    public void testScenario2() {
	        // Access a Product via Search
	        String searchString = "MacBook";
	        driver.findElement(By.name("_nkw")).sendKeys(searchString + Keys.RETURN);

	        // Change the Search category to Computers/Tablets & Networking
	        WebElement categoryDropdown = driver.findElement(By.id("gh-cat"));
	        categoryDropdown.click();
	        driver.findElement(By.xpath("//option[text()='Computers/Tablets & Networking']")).click();
	        driver.findElement(By.id("gh-btn")).click();

	        // Verify that the page loads completely
	        WebDriverWait wait = new WebDriverWait(driver, null);
	        wait.until(ExpectedConditions.presenceOfElementLocated(By.className("s-item")));

	        // Verify that the first result name matches with the search string
	        String firstResultName = driver.findElement(By.className("s-item__title")).getText();
	        Assert.assertTrue(firstResultName.toLowerCase().contains(searchString.toLowerCase()),
	                "Search string not found in the first result");
	    }

	    private void selectFilter(String filterName, String option) {
	        WebElement filterButton = driver.findElement(By.xpath("//span[text()='" + filterName + "']/ancestor::button"));
	        filterButton.click();
	        WebElement filterOption = driver.findElement(By.xpath("//span[text()='" + option + "']"));
	        new Actions(driver).moveToElement(filterOption).click().perform();
	    }
	}
}



