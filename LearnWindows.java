package week4.day1;

import java.time.Duration;
import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class LearnWindows {

	public static void main(String[] args) throws InterruptedException {
		// Setup the web driver
				WebDriverManager.chromedriver().setup();

				// Launch the chrome browser
				ChromeDriver chromeDriver = new ChromeDriver();

				// Load the url
				chromeDriver.get("http://www.leafground.com/pages/Window.html");

				// Maximize the browser window
				chromeDriver.manage().window().maximize();

				// Implicit Wait of 2 seconds
				chromeDriver.manage().timeouts().implicitlyWait(Duration.ofMillis(2000));
				
				//Click on 'Open Home Page'
				chromeDriver.findElement(By.id("home")).click();
				
				//Prints the first window title
				String pageTitle = chromeDriver.getTitle();
				System.out.println("Page Title : "+pageTitle);
				
				//Get all window handles
				Set<String> windowHandles = chromeDriver.getWindowHandles();
				
				//Convert the set to List for retrieving the particular window based on the index
				List<String> windowHandlesList = new ArrayList<String>(windowHandles);
				
				//Switch the driver control to second window
				chromeDriver.switchTo().window(windowHandlesList.get(1));
				
				chromeDriver.manage().window().maximize();
				chromeDriver.manage().timeouts().implicitlyWait(Duration.ofMillis(3000));
				
				Thread.sleep(5000);
				
				//Closes only second window
				chromeDriver.close();
				
				//Switch control to parent window else you will get NoSuchWindowException
				chromeDriver.switchTo().window(windowHandlesList.get(0));
				
				//Click on 'Open Multiple Windows'
				chromeDriver.findElement(By.xpath("//button[text()='Open Multiple Windows']")).click();
				
				windowHandlesList = new ArrayList<String>(chromeDriver.getWindowHandles());
				
				System.out.println("Multiple Window Handles Size: "+windowHandlesList.size());
				
				//Switch the driver control to second window
				chromeDriver.switchTo().window(windowHandlesList.get(1));
				
				chromeDriver.manage().window().maximize();
				chromeDriver.manage().timeouts().implicitlyWait(Duration.ofMillis(3000));
				
				Thread.sleep(5000);
				
				//Closes only second window
				chromeDriver.close();
				
				//Switch the driver control to third window
				chromeDriver.switchTo().window(windowHandlesList.get(2));
				
				chromeDriver.manage().window().maximize();
				chromeDriver.manage().timeouts().implicitlyWait(Duration.ofMillis(3000));
				
				Thread.sleep(5000);
				
				//Closes only third window
				chromeDriver.close();
				
				//Switch the driver control to parent window
				chromeDriver.switchTo().window(windowHandlesList.get(0));
				
				//close all the opened windows
				//chromeDriver.quit();
	}

}
