package week4.day1;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ServiceNow {

	public static void main(String[] args) throws InterruptedException 
	{
				// Setup the web driver
				WebDriverManager.chromedriver().setup();
				
				//Add preference in BROWSER LEVEL
				ChromeOptions chromeOptions = new ChromeOptions();
				chromeOptions.addArguments("--disable-notifications");

				// Launch the chrome browser
				ChromeDriver chromeDriver = new ChromeDriver(chromeOptions);

				// Load the url
				chromeDriver.get("https://dev77053.service-now.com/");

				// Maximize the browser window
				chromeDriver.manage().window().maximize();

				// Implicit Wait of 2 seconds
				chromeDriver.manage().timeouts().implicitlyWait(Duration.ofMillis(2000));
				
				// Switch to login frame
				chromeDriver.switchTo().frame(chromeDriver.findElement(By.id("gsft_main")));
				
				// Enter User Name
				chromeDriver.findElement(By.id("user_name")).sendKeys("admin");
				
				// Enter Password
				chromeDriver.findElement(By.id("user_password")).sendKeys("ServiceNow@123");
				
				// Click Login button
				chromeDriver.findElement(By.id("sysverb_login")).click();
				
				Thread.sleep(3000);
				
				// Find Search box and give 'incident'
				chromeDriver.findElement(By.id("filter")).sendKeys("incident", Keys.ENTER);
				
				Thread.sleep(5000);

				// Click All
				chromeDriver.findElement(By.xpath("((//div[text()='All'])[2])/ancestor::a")).click();
				
				// Switch to new frame
				chromeDriver.switchTo().frame("gsft_main");
				
				//Click New
				chromeDriver.findElement(By.id("sysverb_new")).click();
				
				Thread.sleep(3000);
				
				// Click Caller Search icon
				chromeDriver.findElement(By.id("lookup.incident.caller_id")).click();
				
				//Get all window handles
				Set<String> windowHandles = chromeDriver.getWindowHandles();
				
				//Covert the set to List for retrieving the particular window based on the index
				List<String> windowHandlesList = new ArrayList<String>(windowHandles);
				
				//Switch the driver control to second window
				chromeDriver.switchTo().window(windowHandlesList.get(1));
				
				// Choose First Caller
				chromeDriver.findElement(By.xpath("(//a[@class='glide_ref_item_link'])[1]")).click();
				
				// Give control to the parent window again
				chromeDriver.switchTo().window(windowHandlesList.get(0));
				
				// Give control to the parent frame again
				chromeDriver.switchTo().frame("gsft_main");
				
				// Enter short description text field
				chromeDriver.findElement(By.id("incident.short_description")).sendKeys("Have choosen first caller from caller search window");
				
				// Read, store and print the incident number generated
				String incidentNumber = chromeDriver.findElement(By.id("incident.number")).getAttribute("value");
				System.out.println("Incident Number : "+incidentNumber);
				
				// Click Submit button
				chromeDriver.findElement(By.id("sysverb_insert_bottom")).click();
				
				// Search the newly created Incident Number
				chromeDriver.findElement(By.xpath("//input[@class='form-control']")).sendKeys(incidentNumber,Keys.ENTER);
				
				//Get the incident number from the search result
				String searchOutputIncidentNumber = chromeDriver.findElement(By.xpath("//a[@class='linked formlink']")).getText();
				
				if(searchOutputIncidentNumber != null && searchOutputIncidentNumber.contains(incidentNumber))
					System.out.println("The newly created incident is found in the search result");
				else
					System.out.println("The newly created incident is NOT found in the search result");
	}
		

}

