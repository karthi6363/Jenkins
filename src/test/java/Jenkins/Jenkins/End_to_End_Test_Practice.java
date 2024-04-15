package Jenkins.Jenkins;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;

public class End_to_End_Test_Practice {

	@Test
	public static void test1() throws InterruptedException {
		// TODO Auto-generated method stub

		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://rahulshettyacademy.com/dropdownsPractise/");
		Thread.sleep(2000);
		driver.findElement(By.xpath("//input[@id='autosuggest']")).sendKeys("Ind");
		Thread.sleep(2000);
		List<WebElement> options = driver.findElements(By.xpath("//li[@class='ui-menu-item']"));
		Thread.sleep(2000);

		for (WebElement option : options) {
			if (option.getText().equalsIgnoreCase("India")) {
				option.click();
				break;
			}
		}

		Thread.sleep(2000);
		driver.findElement(By.xpath("//input[@id='ctl00_mainContent_ddl_originStation1_CTXT']")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//div[@id='glsctl00_mainContent_ddl_originStation1_CTNR'] //a[@value='BLR']"))
				.click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//div[@id='glsctl00_mainContent_ddl_destinationStation1_CTNR'] //a[@value='GOI']"))
				.click();
		Thread.sleep(2000);
		driver.findElement(
				By.xpath("//div[@class='ui-datepicker-group ui-datepicker-group-first'] //a[contains(.,'17')]"))
				.click();
		Thread.sleep(2000);
		if (driver.findElement(By.xpath("//div[@id='Div1']")).getAttribute("style").contains("0.5")) {
			Assert.assertTrue(true);
			System.out.println("Return Date field is disabled");
		} else {
			Assert.assertTrue(false);
		}

		driver.findElement(By.xpath("//div[@id='divpaxinfo']")).click();
		Thread.sleep(2000);
		for (int i = 1; i < 5; i++) {
			driver.findElement(By.xpath("//span[@id='hrefIncAdt']")).click();
		}
		Thread.sleep(2000);
		driver.findElement(By.xpath("//input[@id='btnclosepaxoption']")).click();
		Thread.sleep(2000);
		System.out.println(driver.findElement(By.xpath("//div[@id='divpaxinfo']")).getText());
		Thread.sleep(2000);
		WebElement selectDropdown = driver
				.findElement(By.xpath("//select[@id='ctl00_mainContent_DropDownListCurrency']"));
		Select dropdown = new Select(selectDropdown);
		Thread.sleep(2000);
		dropdown.selectByValue("USD");
		Thread.sleep(2000);
		driver.findElement(By.xpath("//input[@value='Search']")).click();
		System.out.println("Train search has been successfully completed");
		Thread.sleep(2000);
		driver.quit();

	}

}
