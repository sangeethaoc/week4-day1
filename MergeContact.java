package week4.day1;

import java.time.Duration;
import java.util.ArrayList;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class MergeContact {

	public static void main(String[] args) 
	{
		
		// Setup the web driver
				WebDriverManager.chromedriver().setup();

				// Launch the chrome browser
				ChromeDriver chromeDriver = new ChromeDriver();

				// Load the url
				chromeDriver.get("http://leaftaps.com/opentaps/control/login");

				// Maximize the browser window
				chromeDriver.manage().window().maximize();

				// Implicit Wait of 2 seconds
				chromeDriver.manage().timeouts().implicitlyWait(Duration.ofMillis(2000));

				// Enter the Username
				WebElement userName = chromeDriver.findElement(By.id("username"));

				userName.sendKeys("DemoSalesManager");

				// Enter the password"
				chromeDriver.findElement(By.id("password")).sendKeys("crmsfa");

				// Click Submit button
				chromeDriver.findElement(By.className("decorativeSubmit")).click();

				// Click CRM/SFA
				chromeDriver.findElement(By.linkText("CRM/SFA")).click();
				
				// Click Contacts tab
				chromeDriver.findElement(By.linkText("Contacts")).click();
				
				// Click Merge Contacts
				chromeDriver.findElement(By.xpath("//a[text()='Merge Contacts']")).click();
				
				// Click From Contact Widget
				chromeDriver.findElement(By.xpath("//input[@id='partyIdFrom']/following-sibling::a")).click();
				
				ArrayList<String> arrayList = new ArrayList<String>(chromeDriver.getWindowHandles());
				
				// Switch to Find Contact Window
				chromeDriver.switchTo().window(arrayList.get(1));
				
				// Click on First Resulting Contact
				chromeDriver.findElement(By.xpath("(//div[@class='x-grid3-cell-inner x-grid3-col-partyId'])[1]/a")).click();
				
				// Switch to Merge Contact Window again
				chromeDriver.switchTo().window(arrayList.get(0));
				
				// Click To Contact Widget
				chromeDriver.findElement(By.xpath("//input[@id='partyIdTo']/following-sibling::a")).click();
				
				arrayList = new ArrayList<String>(chromeDriver.getWindowHandles());
				
				// Switch to Find Contact Window
				chromeDriver.switchTo().window(arrayList.get(1));
				
				// Click on Second Resulting Contact
				chromeDriver.findElement(By.xpath("(//div[@class='x-grid3-cell-inner x-grid3-col-partyId'])[2]/a")).click();
				
				// Switch to Merge Contact Window again
				chromeDriver.switchTo().window(arrayList.get(0));
				
				// Click on Merge button using Xpath Locator
				chromeDriver.findElement(By.xpath("//a[text()='Merge']")).click();
				
				// Accept the Alert
				chromeDriver.switchTo().alert().accept();
				
				String title = chromeDriver.getTitle();
				
				System.out.println("Page Title : "+title);
				
				if(title != null && title.contains("View Contact | opentaps CRM"))
				{
					System.out.println("The page title is verified and is as expected");
				}
				else
				{
					System.out.println("The displayed page is not as expected");
				}
	}

}
