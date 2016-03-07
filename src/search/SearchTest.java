package search;

import org.testng.annotations.Test;
import org.testng.Assert;
import org.testng.annotations.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;


public class SearchTest {
	
	private static WebDriver driver = new FirefoxDriver();
	private static String SpringerUrl = "http://link.springer.com";	

	@AfterTest 
	public void after() {
		driver.manage().deleteAllCookies();
		driver.quit();
	}
	
	
	@BeforeTest 
	public void before() {
		driver.manage().window().maximize();
	}
	
	@Test(priority = 0)
	public void testHappyPath() throws Exception {
		
		String book = "Agile!";
		
		MainPage mainPage = new MainPage(driver);
		driver.get(SpringerUrl);				
		Assert.assertTrue(driver.findElement(By.id("header")).isDisplayed());
		System.out.println("Header is visible");
		SearchPage searchPage = mainPage.navigateSearch(book);		
		System.out.println("Sytem returned: " + driver.findElement(By.xpath("//div[@id = 'kb-nav--main']//*[@class = 'number-of-search-results-and-search-terms']/strong[1]")).getText() + " records");
		searchPage.OpenBook(book);
		Assert.assertEquals(driver.findElement(By.id("title")).getText(), book);
	}
	
	@Test(priority = 1)
	public void testUnhappyPath() throws Exception {
		
		String book = "[[[";		
		
		MainPage mainPage = new MainPage(driver);
		driver.get(SpringerUrl);		
		Assert.assertTrue(driver.findElement(By.id("header")).isDisplayed());
		System.out.println("Header is visible");	
		mainPage.navigateSearch(book);	
		Assert.assertTrue(driver.findElement(By.id("no-results-message")).isDisplayed());
	}
	
}
