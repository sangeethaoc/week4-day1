package week4.day1;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class NestedFrames {

	public static void main(String[] args) 
	{
		// Setup the web driver
		WebDriverManager.chromedriver().setup();

		// Launch the chrome browser
		ChromeDriver chromeDriver = new ChromeDriver();

		// Load the url
		chromeDriver.get(" https://chercher.tech/practice/frames-example-selenium-webdriver");

		// Maximize the browser window
		chromeDriver.manage().window().maximize();

		// Implicit Wait of 2 seconds
		chromeDriver.manage().timeouts().implicitlyWait(Duration.ofMillis(2000));
		
		// Switch to outer frame
		chromeDriver.switchTo().frame("frame1");
		
		// Switch to inner frame
		chromeDriver.switchTo().frame("frame3");
		
		// Select the checkbox
		WebElement checkBoxWE = chromeDriver.findElement(By.id("a"));
		if(checkBoxWE != null && !checkBoxWE.isSelected())
			checkBoxWE.click();
		
		// Switch to parent window from out of all the frames
		chromeDriver.switchTo().defaultContent();
		
		// Switch to third frame
		chromeDriver.switchTo().frame("frame2");
		
		// Find webelement to choose the Animals Drop down
		Select select = new Select(chromeDriver.findElement(By.id("animals")));
		
		// Select the last index
		select.selectByIndex(3);
		
		//Switch to parent window
		chromeDriver.switchTo().parentFrame();
				
	}

}
