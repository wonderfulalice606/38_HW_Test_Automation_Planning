package core;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import java.util.logging.*;


public class Chrome {
	
	static WebDriver driver;
	
	public static void main(String[] args) throws InterruptedException {
		
		// cleaning up the logs of the output of the console
		Logger logger = Logger.getLogger("");
		logger.setLevel(Level.OFF);
		
		//Set path for driver exe
		String driverPath = "./src/main/resources/webdrivers/mac/chromedriver";
		System.setProperty("webdriver.chrome.driver", driverPath);
		// cleaning up the logs of the output of the console
		System.setProperty("webdriver.chrome.silentOutput", "true");
		
		//Create a instance of ChromeOptions class
		ChromeOptions options = new ChromeOptions();
		//Add chrome switch to disable notification - "--disable-notifications"
		options.addArguments("--disable-notifications");
		//Pass ChromeOptions instance to ChromeDriver Constructor
		driver = new ChromeDriver(options);
		driver.manage().window().maximize();
		
		System.out.println("Browser is: Chrome");
		driver.get("http://facebook.com/");
		//Pause in milliseconds (1000 - 1 sec)
		Thread.sleep(1000); //Pause in milliseconds (1000 - 1 sec)
		
		System.out.println("Title: " + driver.getTitle());
		String copyright = driver.findElement
				(By.xpath("//span[contains(text(),'Facebook © 2018')]")).getText();
		System.out.println("Copyright: " + copyright);
		driver.findElement(By.id("email")).sendKeys("email");
		driver.findElement(By.id("pass")).sendKeys("password");
		//driver.findElement(By.id("u_0_2")).click();
		driver.findElement(By.xpath("//input[@value='Log In']")).click();
		
		driver.findElement(By.xpath("//*[@id=\"u_0_a\"]/div[1]/div[1]/div/a/span/span")).click();//span[@class='_1vp5 f_click']
		
		Thread.sleep(2000); //Pause in milliseconds (1000 - 1 sec)
		String friends = 
				driver.findElement(By.xpath("//span[text()='207']")).getText();
		System.out.println("You have " + friends + " friends");
		
		driver.findElement(By.id("userNavigationLabel")).click();
		
		Thread.sleep(2000); //Pause in milliseconds (1000 - 1 sec)
		driver.findElement(By.xpath(
				"//span[text()='Log Out']")).click();
		driver.quit();
	}
}
