package week4.day1;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class LearnFrames {

	public static void main(String[] args) throws InterruptedException, IOException 
	{
				// Setup the web driver
				WebDriverManager.chromedriver().setup();

				// Launch the chrome browser
				ChromeDriver chromeDriver = new ChromeDriver();

				// Load the url
				chromeDriver.get("http://www.leafground.com/pages/frame.html");

				// Maximize the browser window
				chromeDriver.manage().window().maximize();

				// Implicit Wait of 2 seconds
				chromeDriver.manage().timeouts().implicitlyWait(Duration.ofMillis(2000));
				
				// Switch to Frame 1
				chromeDriver.switchTo().frame(0);
				
				Thread.sleep(3000);
				
				// Take Screenshot as file
				File source = chromeDriver.findElement(By.id("Click")).getScreenshotAs(OutputType.FILE);
				
				// Copy to a folder
				File destination = new File("./images/ClickMe.png");
				
				FileUtils.copyFile(source, destination);
				
				// Click on Click Me button in Frame
				chromeDriver.findElement(By.id("Click")).click();
				
				//Switch to parent frame
				chromeDriver.switchTo().parentFrame();
				
				// Switch to Second Frame
				chromeDriver.switchTo().frame(1);
				
				// Switch to Nested Frame
				chromeDriver.switchTo().frame(chromeDriver.findElement(By.id("frame2")));
				
				// Click on Click Me button in Frame
				chromeDriver.findElement(By.id("Click1")).click();
				
				//Switch to parent window from out of all the frames
				chromeDriver.switchTo().defaultContent();
				
				// Get the list of frames using tag name
				List<WebElement> findElements = chromeDriver.findElements(By.tagName("iframe"));
				
				System.out.println("Total Number of Frames :"+findElements.size());
	}

}
