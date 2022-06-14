package seleniumDemo;

import java.util.List;
import java.util.Scanner;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class AmazonProductList {

	String brand;

	@Test
	public void searchList() {

		Scanner scanner = new Scanner(System.in);
		
		System.out.println("Enter the url to launch the websites : ");
		
		String url = scanner.next();

		WebDriverManager.chromedriver().setup();

		WebDriver driver = new ChromeDriver();
		
		driver.get(url);
		
		WebElement search = driver.findElement(By.xpath("//input[@id='twotabsearchtextbox']"));
		search.sendKeys("phone" + Keys.ENTER);

		List<WebElement> checkboxes = driver.findElements(By.xpath("//*[@aria-labelledby='p_89-title']"));

		driver.findElement(By.xpath("(//*[@class='a-expander-prompt'])[2]")).click();
		
		int index = 0;
		for (WebElement webElement : checkboxes) {
			
		
		
		//for (int index = 0; index < checkboxes.size(); index++) {
			brand = checkboxes.get(index).getText();
			System.out.println("List the All brands : \n" + brand);

		}

		System.out.println("Enter the brand you want : ");
		String string = scanner.next();
		scanner.close();

		if (brand.contains(string)) {
			System.out.println("Brand searches is matches with entered");
			
		} else {
			System.out.println("Brand is not matches with you entered");
		}
	}
}
