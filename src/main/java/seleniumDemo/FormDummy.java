package seleniumDemo;

import java.util.Scanner;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class FormDummy {

	public static void main(String[] args) {
		
		Scanner scanner = new Scanner(System.in);
		System.out.println("Enter the url : ");
		String url = scanner.next();
		
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.get(url);
		scanner.close();
		
		
		WebElement fullName = driver.findElement(By.xpath("//*[@id='username']"));
		fullName.sendKeys("krishnasamy");
		
		WebElement email = driver.findElement(By.xpath("//*[@id='email']"));
		email.sendKeys("test@gmail.com");
		
		WebElement telephone = driver.findElement(By.xpath("//*[@id='tel']"));
		telephone.sendKeys("9551958709");

		WebElement gender = driver.findElement(By.xpath("//*[@id='container']/div[7]/select"));
		Select select = new Select(gender);
		select.selectByIndex(1);
		
		WebElement yearOfExperience = driver.findElement(By.xpath("//*[@id='container']/div[8]/input[6]"));
		yearOfExperience.click();

		WebElement skills = driver.findElement(By.xpath("//*[@id='ip'][2]"));
		skills.click();
		
		WebElement tools = driver.findElement(By.xpath("//*[@id='tools']"));
		Select multiSelect = new Select(tools);
		multiSelect.selectByIndex(1);
		
		WebElement submit = driver.findElement(By.xpath("//*[@id='submit']"));
		submit.click();
		
	}

}
