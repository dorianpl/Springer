package search;
import java.util.concurrent.TimeUnit;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SearchPage {

	private WebDriver driver;
	
	public SearchPage (WebDriver driver) {
		this.driver = driver;
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
	}
	
	public void OpenBook (String book) {
		driver.findElement(By.xpath("//*[contains(@title , '" + book + "')]")).click();		
	}
	
}
