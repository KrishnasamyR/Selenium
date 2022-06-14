package seleniumDemo;

import java.util.Scanner;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class FormFillingUsingXpath {

	public static void main(String[] args) {
		
		Scanner scanner = new Scanner(System.in);
		System.out.println("Enter the url : ");
		String url = scanner.next();
		
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.get(url);
		scanner.close();
		
		WebElement firstName = driver.findElement(By.xpath("//*[@id='firstName']"));
		firstName.sendKeys("krishna");
		
		WebElement lastName = driver.findElement(By.xpath("//*[@id='lastName']"));
		lastName.sendKeys("samy");
		
		WebElement email = driver.findElement(By.xpath("//*[@id='userEmail']"));
		email.sendKeys("test@gmail.com");
		
		WebElement gender = driver.findElement(By.xpath("//*[@class='custom-control-label']"));
		gender.click();
		
		WebElement mobile = driver.findElement(By.xpath("//*[@id='userNumber']"));
		mobile.sendKeys("9361273739");
		
		WebElement subjects = driver.findElement(By.xpath("(//*[@type='text'])[6]")); //("//*[@id=\"subjectsInput\"]"));  
		subjects.sendKeys("Maths");
		
//		WebElement hobbies= driver.findElement(By.xpath("//*[@id='hobbiesWrapper']/div[2]/div[1]/label"));
//		hobbies.click();
		
		WebElement currentAddress = driver.findElement(By.xpath("//*[@id=\"currentAddress\"]"));
		currentAddress.sendKeys("Chennai");
		
		WebElement state = driver.findElement(By.xpath("//*[@id='react-select-3-input']"));
		
		Select stateSelect = new Select(state);
	
		stateSelect.selectByIndex(2);
	}

}
//*[@id="stateCity-label"]
