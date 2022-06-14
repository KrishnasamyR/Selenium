package seleniumDemo;

import java.io.FileInputStream;
import java.time.Duration;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Properties;
import java.util.TreeSet;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Flipcard {

	String totalRate;
	WebDriver driver;

	@Test
	public void rating() throws Exception {

		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get("https://www.flipkart.com/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		//driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		Properties properties = new Properties();

		FileInputStream fileInputStream = new FileInputStream(
				System.getProperty("user.dir") + "\\src\\main\\java\\seleniumDemo\\flipcard.properties");
		properties.load(fileInputStream);

		driver.findElement(By.xpath(properties.getProperty("cancel"))).click();

		driver.findElement(By.xpath(properties.getProperty("search"))).sendKeys("y21g");

		driver.findElement(By.xpath(properties.getProperty("submit"))).click();

		String ratingString = driver.findElement(By.xpath(properties.getProperty("rating"))).getText();

		System.out.println("Rating is : " + ratingString);

		List<WebElement> lists = driver.findElements(By.xpath(properties.getProperty("totalProduct")));
		
		List<String> ratingList = new ArrayList<String>();

		for (WebElement webElement : lists) {
			totalRate = webElement.getText();
			System.out.println("Total product Rating is : " + totalRate);
			ratingList.add(totalRate);
		}

		TreeSet<Double> overallRating = new TreeSet<Double>();
		
		for (String string : ratingList) {
			double totalRating = Double.parseDouble(string);
			overallRating.add(totalRating);

		}
		System.out.println("Highest rating is : " + overallRating.last());
		System.out.println("Lowest rating is : " + overallRating.first());
	}
}
