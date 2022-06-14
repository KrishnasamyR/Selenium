package seleniumDemo;

import java.awt.Window;
import java.util.List;
import java.util.Scanner;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TestNgBuyProduct {
	@Test 
	public void search() {
	
	Scanner scanner = new Scanner(System.in);
	System.out.println("Enter the url : ");
	String url = scanner.next();
	
	WebDriverManager.chromedriver().setup();
	WebDriver driver = new ChromeDriver();
	driver.get(url);
	scanner.close();

	WebElement search = driver.findElement(By.xpath("//*[@id='search_query_top']"));
	search.sendKeys("Faded Short Sleeve T-shirt"+Keys.ENTER);
	
	List<WebElement> searchResult = driver.findElements(By.xpath("//*[@id='center_column']/h1"));

	for (WebElement webElement : searchResult) {
	if (webElement.getText().equals("Faded Short Sleeve T-shirt")) {
	webElement.click();
	break;
	}
	}
	JavascriptExecutor executor = (JavascriptExecutor) driver;
	executor.executeScript("window.scrollBy(0,2000)", "");
	
	WebElement addToCard = driver.findElement(By.xpath("//*[@id='center_column']/ul/li/div/div[2]/div[2]/a[1]/span"));
	addToCard.click();
	
}
}
//http://automationpractice.com/index.php
//*[@id="search_query_top"]
//*[@id="searchbox"]/button
//*[@id="center_column"]/ul/li/div/div[2]/div[2]/a[1]/span