package seleniumDemo;

import java.util.List;

import javax.swing.text.Element;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class FramesExample {

	public static void main(String[] args) {
		
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();  //Instantiating the Chrome driver
		driver.get("http://www.leafground.com/pages/frame.html");
		
		driver.switchTo().frame(0);
		WebElement clickMeOne = driver.findElement(By.id("click"));
		clickMeOne.click();
		
		String text = driver.findElement(By.id("Click")).getText();
		System.out.println(text);
		
		driver.switchTo().defaultContent();
		
		driver.switchTo().frame(1);
		driver.switchTo().frame("frame2");
		WebElement clickMeTwo = driver.findElement(By.id("Click1"));
		clickMeTwo.click();
		
		driver.switchTo().defaultContent();
		
		List<WebElement> totalFrames = driver.findElements(By.tagName("iframe")); //return List<webElent>,we storing it.
		int size = totalFrames.size();
		System.out.println("Total Frames : "+size);
		
	}

}
