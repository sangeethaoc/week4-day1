package week4.day1;

import java.time.Duration;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class LearnAlerts {

	public static void main(String[] args) throws InterruptedException {
		// Setup the web driver
		WebDriverManager.chromedriver().setup();

		// Launch the chrome browser
		ChromeDriver chromeDriver = new ChromeDriver();

		// Load the url
		chromeDriver.get("http://www.leafground.com/pages/Alert.html");

		// Maximize the browser window
		chromeDriver.manage().window().maximize();

		// Implicit Wait of 2 seconds
		chromeDriver.manage().timeouts().implicitlyWait(Duration.ofMillis(2000));

		// Wait for alert box to load
		Thread.sleep(5000);

		// Click on Alert Box
		chromeDriver.findElement(By.xpath("//button[text()='Alert Box']")).click();

		// Switch to alert box
		Alert simpleAlert = chromeDriver.switchTo().alert();

		// Get the alert text
		System.out.println("Simple Alert Box - Displayed Text : " + simpleAlert.getText());

		Thread.sleep(3000);

		// Click on OK button
		simpleAlert.accept();

		// Click on Confirm Box
		chromeDriver.findElement(By.xpath("//button[text()='Confirm Box']")).click();

		// Switch to alert box
		Alert confirmAlert = chromeDriver.switchTo().alert();

		// Get the alert text
		System.out.println("Confirm Alert Box - Displayed Text : " + confirmAlert.getText());

		Thread.sleep(3000);

		// Click on OK button
		confirmAlert.accept();

		// Click on Prompt Box
		chromeDriver.findElement(By.xpath("//button[text()='Prompt Box']")).click();

		// Switch to alert box
		Alert promptAlert = chromeDriver.switchTo().alert();

		// Send text to the input test field in prompt box
		promptAlert.sendKeys("CSE");

		Thread.sleep(3000);

		// Click on OK button
		promptAlert.accept();

		if (chromeDriver.findElement(By.id("result1")).getText().contains("CSE")) {
			System.out.println("The text displayed here has the text entered in the prompt alert input field");
		}

		// Non - Modal Dialog Box

		// Click on Sweet Alert Box
		chromeDriver.findElement(By.xpath("//button[text()='Sweet Alert']")).click();
		
		Thread.sleep(8000);

		// Click on OK button
		chromeDriver.findElement(By.xpath("//button[text()='OK']")).click();

		// Get the alert text
		WebElement nonModalDialogWE = chromeDriver.findElement(By.className("swal-text"));
		System.out.println("Sweet Alert Text : " + nonModalDialogWE.getText());

	}

}
