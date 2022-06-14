package seleniumDemo;

import java.io.FileInputStream;
import java.util.Properties;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class AmazonRating {
	WebDriver driver;

	@Test
	public void rating() throws Exception {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get("https://www.amazon.in/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		Properties properties = new Properties();
		FileInputStream fileInputStream = new FileInputStream(System.getProperty("user.dir")+ "\\src\\main\\java\\seleniumDemo\\amazon.properties");
		properties.load(fileInputStream);
		
		driver.findElement(By.xpath(properties.getProperty("Search"))).sendKeys("Y21G");
		driver.findElement(By.xpath(properties.getProperty("SearchClick"))).click();
		driver.findElement(By.xpath(properties.getProperty("Rating"))).click();
	}
}
