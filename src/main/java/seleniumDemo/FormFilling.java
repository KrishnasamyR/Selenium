package seleniumDemo;

import java.util.Scanner;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class FormFilling {
	public static void main(String[] args) {
		
	
	//public void form() {
		
		Scanner scanner = new Scanner(System.in);
		
		System.out.println("Enter the url to launch");
		String url = scanner.next();
		
		WebDriverManager.chromedriver().setup();
		
		WebDriver driver = new ChromeDriver();
		driver.get(url);
		scanner.close();
		
//		WebElement subjectElement =driver.findElement(By.xpath("/html/body/div[2]/div/div/div[2]/div[2]/div[2]/form/div[6]/div[2]/div/div/div[1]"));
//		subjectElement.sendKeys("register");
		
//		WebElement gender = driver.findElement(By.className("custom-control-label"));
//		gender.click();
//		
//		WebElement dob = driver.findElement(By.id("dateOfBirthInput"));
//		dob.getAttribute("value");
//		
		WebElement hobbies = driver.findElement(By.xpath("//*[@id='hobbiesWrapper']/div[2]/div[1]/label"));
		hobbies.click();
		
	}

}
