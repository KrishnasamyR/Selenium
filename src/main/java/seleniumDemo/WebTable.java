package seleniumDemo;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class WebTable {

	WebDriver driver;

	@Test(priority = 1)
	public void getWebsite() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get("https://www.techlistic.com/p/demo-selenium-practice.html");
	}

	@Test(priority = 2)
	public void scrollWebsite() {
		driver.findElement(By.xpath("//*[@id=\"ez-video-ez-stuck-close\"]"));
		JavascriptExecutor executor = (JavascriptExecutor) driver;
		executor.executeScript("window.scrollBy(0,1000)", "");
	}

	@Test(priority = 3)
	public void tableHeaders() {
		WebElement table = driver.findElement(By.xpath("//table[@class=\"tsc_table_s13\"]"));
		List<WebElement> headers = table.findElements(By.xpath("//th[@scope=\"col\"]"));
		System.out.println("Demo table two headers are : ");

		for (WebElement header : headers) {
			String headertext = header.getText();
			System.out.println(headertext);
		}
	}

	@Test(priority = 4)
	public void listElementsInList() {
		List<WebElement> allrows = driver.findElements(By.xpath("//th[@scope=\"row\"]"));
		allrows.remove(0);
		int size = allrows.size();
		System.out.println("Size is : " + size);

		if (size == 4) {
			System.out.println("Size of structre is 4 ");
			System.out.println();
		} else {
			System.out.println("Wrong Size of structure");
		}
		System.out.println();
		System.out.println("Top Building name : ");

		for (WebElement row : allrows) {
			String rowtext = row.getText();
			System.out.println(rowtext);
		}
	}

	@Test(priority = 5)
	public void burjKalifaDetails() {

		WebElement table = driver.findElement(By.xpath("//table[@class=\"tsc_table_s13\"]"));

		List<WebElement> burjKalifa = table.findElements(By.xpath("(//tbody/tr)[8]"));

		for (WebElement webElement : burjKalifa) {
			String burjData = webElement.getText();
			System.out.println();
			System.out.println(burjData);
		}
	}

	@Test(priority = 6)
	public void clockTowerHotelDetails() {
		WebElement table = driver.findElement(By.xpath("//table[@class=\"tsc_table_s13\"]"));

		List<WebElement> clockToweHotel = table.findElements(By.xpath("(//tbody/tr)[9]"));

		for (WebElement webElement : clockToweHotel) {
			String clockData = webElement.getText();
			System.out.println();
			System.out.println(clockData);
		}
	}

	@Test(priority = 7)
	public void taipei101Dteails() {
		WebElement table = driver.findElement(By.xpath("//table[@class=\"tsc_table_s13\"]"));

		List<WebElement> taipei101 = table.findElements(By.xpath("(//tbody/tr)[10]"));

		for (WebElement webElement : taipei101) {

			String taipeiData = webElement.getText();
			System.out.println();
			System.out.println(taipeiData);
		}
	}

	@Test(priority = 8)
	public void financialCenterDetails() {
		WebElement table = driver.findElement(By.xpath("//table[@class=\"tsc_table_s13\"]"));

		List<WebElement> financialCenter = table.findElements(By.xpath("(//tbody/tr)[11]"));

		for (WebElement webElement : financialCenter) {

			String financialCenterAttributes = webElement.getText();
			System.out.println();
			System.out.println(financialCenterAttributes);
		}

	}

	@Test(priority = 9)
	public void height() {

		int row = driver.findElements(By.xpath(" //table[@class='tsc_table_s13']/tbody/tr")).size();

		for (int rowburj = 1; rowburj <= row; rowburj++) {
			String structure = driver
					.findElement(By.xpath("//table[@class='tsc_table_s13']/tbody/tr[" + rowburj + "]/th")).getText();
			if (structure.equals("Burj Khalifa")) {
				String height = driver
						.findElement(By.xpath("//table[@class='tsc_table_s13']/tbody/tr[" + rowburj + "]/td[3]"))
						.getText();
				System.out.println("Height of Burj Khalifa : ");
				System.out.println("Tallest Building : " + structure + " " + height);

			}
		}
	}

	@Test(priority = 10)
	public void VerifyColumnValue() {
		WebElement table = driver.findElement(By.xpath("//table[@class=\"tsc_table_s13\"]"));
		int count = 0;
		WebElement lastColumn = table
				.findElement(By.xpath("//*[@id=\"post-body-5867683659713562481\"]/div[1]/div[4]/table/tfoot/tr"));
		String oneString = lastColumn.getText();

		
		//String headerString = "//*[@id='post-body-5867683659713562481']/div[1]/div[4]/table/tfoot/tr";
		String valueStringOne = "//*[@id='post-body-5867683659713562481']/div[1]/div[4]/table/tfoot/tr/th";
		String valStringTwo = "//*[@id='post-body-5867683659713562481']/div[1]/div[4]/table/tfoot/tr/td";

		WebElement columnOneElements = table.findElement(By.xpath(valueStringOne));
		String twoString = columnOneElements.getText();

		WebElement columnTwoElements = table.findElement(By.xpath(valStringTwo));
		String threeString = columnTwoElements.getText();
		if (oneString.contains(twoString)) {
			count++;

			if (oneString.contains(threeString)) {

				count++;
			}
		}
		System.out.println("Number of cloumn in last row: " + count);
	}
}
