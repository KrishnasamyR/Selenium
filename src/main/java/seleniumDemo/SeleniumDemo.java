package seleniumDemo;

import java.util.Scanner;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class SeleniumDemo {
	
	public void findElements() {
		
		Scanner scanner = new Scanner(System.in);
		
		WebDriverManager.chromedriver().setup();
		
		WebDriver webDriver = new ChromeDriver();
		
		System.out.println("Enter the web link to launch : ");
		
		webDriver.get(scanner.next());  //("https://demoqa.com/automation-practice-form");
		
		
		System.out.println(webDriver.getTitle());
		
		WebElement firstName = webDriver.findElement(By.id("firstName"));
		System.out.println("Enter the First Name : ");
		firstName.sendKeys(scanner.next()); //("krishna");
		
		WebElement lastName = webDriver.findElement(By.id("lastName"));
		System.out.println("Enter the Last Name : ");
		lastName.sendKeys(scanner.next());   //("samy");
		
		WebElement email = webDriver.findElement(By.id("userEmail"));
		System.out.println("Enter the Email Id : ");
		email.sendKeys(scanner.next());    //("test@gmail.com");
		
		WebElement mobile = webDriver.findElement(By.id("userNumber"));
		System.out.println("Enter the Mobile number : ");
		mobile.sendKeys(scanner.next());   //("9361273739");
		
		WebElement currentAddress = webDriver.findElement(By.id("currentAddress"));
		System.out.println("Enter the Address : ");
		currentAddress.sendKeys(scanner.next());    //("Chennai");

		
//		WebElement subjects = webDriver.findElement(By.xpath("//*[@id=\'subjectsContainer\']/div/div[1]"));
//		subjects.sendKeys("Register");
		//webTest.close();
	}

}
