package search;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;


public class MainPage {
	
	private WebDriver driver;
	
	public MainPage (WebDriver driver) {
		this.driver = driver;
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
	}
	
	public String getPageTitle() {
		return driver.findElement(By.xpath("//*/span[contains(@class, 'messaging')]")).getText();
	}
	
	public SearchPage navigateSearch(String search) {
		driver.findElement(By.id("query")).clear();		
		driver.findElement(By.id("query")).sendKeys(search);
		driver.findElement(By.id("search")).click();	
		return new SearchPage(driver);
	}
	

	
	
}
