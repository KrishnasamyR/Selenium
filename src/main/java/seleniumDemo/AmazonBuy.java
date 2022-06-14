package seleniumDemo;

import java.io.File;
import java.time.Duration;
import java.util.Iterator;
import java.util.Scanner;
import java.util.Set;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.io.FileHandler;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.Assertion;

import io.github.bonigarcia.wdm.WebDriverManager;

public class AmazonBuy {
    @Test
	public void buy() throws Exception {

		Scanner scanner = new Scanner(System.in);
		System.out.println("Enter the url to launch");
		String url = scanner.next();
		
		WebDriverManager.chromedriver().setup();

		WebDriver driver = new ChromeDriver();
		driver.get(url);
		scanner.close();

		WebElement search = driver.findElement(By.xpath("//*[@id='twotabsearchtextbox']"));
		search.sendKeys("Vivo Y21G" + Keys.ENTER);
		
		WebElement messagElement = driver.findElement(By.xpath("(//span[@class='a-size-medium a-color-base a-text-normal'])[2]"));
		String result = "Vivo Y21G (Diamond Glow, 4GB RAM, 64GB ROM) with No Cost EMI/Additional Exchange Offers";
		
		String actualMessage = messagElement.getText();
		Assert.assertEquals(actualMessage, result,"Actual search is not same");
		
		WebElement select = driver
				.findElement(By.xpath("(//span[@class='a-size-medium a-color-base a-text-normal'])[2]"));
		select.click();

		Set<String> set = driver.getWindowHandles();

		Iterator<String> iterator = set.iterator();

		String urlOne = iterator.next();
		String urlTwo = iterator.next();
		driver.switchTo().window(urlTwo);

		WebElement addToCart = driver.findElement(By.xpath("//*[@id='add-to-cart-button']"));
		addToCart.click();
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		//Thread.sleep(5000);
		WebElement proceed = driver.findElement(By.xpath("(//input[@type=\"submit\"])[23]"));
		proceed.click();
		
		WebElement email = driver.findElement(By.xpath("//*[@id='ap_email']"));
		email.sendKeys("krishnait33@gmail.com");
		
		WebElement continueTo = driver.findElement(By.xpath("//input[@id='continue']"));
		continueTo.click();
		
		WebElement password = driver.findElement(By.xpath("//*[@id='ap_password']"));
		password.sendKeys("ramsenthilit33");
		
		WebElement signIn = driver.findElement(By.xpath("//*[@id='signInSubmit']"));
		signIn.click();
		
		TakesScreenshot screenshot = (TakesScreenshot) driver;
		
		File path = screenshot.getScreenshotAs(OutputType.FILE);
		
		File source = new File("C:\\Users\\krishnasamy.r\\eclipse-workspace\\Selenium\\krish.jpeg");
		FileHandler.copy(path, source);
	}

}

