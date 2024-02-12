package com.practise;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.*;
import io.github.bonigarcia.wdm.WebDriverManager;

public class ComparisonPgm {

	@Test
	public void browser() {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.amazon.in/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.findElement(By.xpath("//div[@id='nav-xshop']/a[text()='Mobiles']")).click();
		ArrayList<String> actual = new ArrayList<String>();
		actual.add("Electronics");
		actual.add("Mobiles & Accessories");
		actual.add("Mobile Accessories");
		actual.add("Mobile Broadband Devices");
		actual.add("SIM Cards");
		actual.add("Smartphones & Basic Mobiles");
		actual.add("Smartwatches");

		ArrayList<String> expected = new ArrayList<String>();

		List<WebElement> listelements = driver.findElements(By.xpath("//span[text()='Electronics']/ancestor::ul/li"));

		for (WebElement we : listelements) {
			expected.add(we.getText());

		}

		try {
			// Comparing actual and expected menu lists
			Assert.assertEquals(actual, expected);
			System.out.println("The side menu options are validated successfully..");
		} catch (AssertionError e) {

			System.out.println("The side menu options validation failed..");
			e.printStackTrace();
		}

		driver.close();

	}

}
