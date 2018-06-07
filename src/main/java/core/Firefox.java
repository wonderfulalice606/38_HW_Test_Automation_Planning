package core;

import org.openqa.selenium.*;
import org.openqa.selenium.firefox.*;
import org.openqa.selenium.remote.DesiredCapabilities;
import java.util.logging.*;

public class Firefox {
	
	static WebDriver driver;
	
	public static void main(String[] args) throws InterruptedException {
		
		// cleaning up the logs of the output of the console
		Logger logger = Logger.getLogger("");
		logger.setLevel(Level.OFF);
		
		String driverPath = "./src/main/resources/webdrivers/mac/geckodriver";
		System.setProperty("webdriver.gecko.driver", driverPath);
		
		// cleaning up the logs of the output of the console
		String driverLogger = "./src/main/resources/webdrivers/mac/geckodriver.sh";
		System.setProperty("webdriver.gecko.driver", driverLogger);
		
		FirefoxProfile testprofile = new FirefoxProfile();
		testprofile.setPreference("dom.webnotifications.enabled", false);
		DesiredCapabilities dc = DesiredCapabilities.firefox();
		dc.setCapability(FirefoxDriver.PROFILE, testprofile);
		FirefoxOptions opt = new FirefoxOptions();
		opt.merge(dc);
		
		
		WebDriver driver =  new FirefoxDriver(opt);
		driver.manage().window().maximize();
		
		System.out.println("Browser is: Firefox");
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
		
		driver.findElement(By.xpath("//*[@id=\"u_0_a\"]/div[1]/div[1]/div/a/span/span")).click();
		//span[@class='_1vp5 f_click']
		
		Thread.sleep(2000); //Pause in milliseconds (1000 - 1 sec)
		String friends = 
				driver.findElement(By.xpath("//*[@data-tab-key=\"friends\"]/span[1]")).getText();
		System.out.println("You have " + friends + " friends");
		
		driver.findElement(By.id("userNavigationLabel")).click();
		
		Thread.sleep(2000); //Pause in milliseconds (1000 - 1 sec)
		driver.findElement(By.xpath(
				"//span[text()='Log Out']")).click();
		driver.quit();
	}
}

