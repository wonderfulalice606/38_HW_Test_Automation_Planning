package core;

import org.openqa.selenium.*;
import org.openqa.selenium.safari.SafariDriver;
import org.openqa.selenium.WebDriver;
import java.util.logging.*;

public class Safari {
	public static void main(String[] args) throws InterruptedException {
		WebDriver driver = new SafariDriver();
		
		// cleaning up the logs of the output of the console
		Logger logger = Logger.getLogger("");
		logger.setLevel(Level.OFF);
		
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();	
		
		System.out.println("Browser is: Safari");
		driver.get("http://facebook.com/");
		//Pause in milliseconds (1000 - 1 sec)
		Thread.sleep(1000); //Pause in milliseconds (1000 - 1 sec)
		
		System.out.println("Title: " + driver.getTitle());
		String copyright = driver.findElement
				(By.xpath("//span[contains(text(),'Facebook © 2018')]")).getText();
		System.out.println("Copyright: " + copyright);
		driver.findElement(By.id("email")).clear();
		driver.findElement(By.id("email")).sendKeys("email");
		driver.findElement(By.id("pass")).clear();
		driver.findElement(By.id("pass")).sendKeys("password");
		//driver.findElement(By.id("u_0_2")).click();
		driver.findElement(By.xpath("//input[@value='Log In']")).click();
		
		Thread.sleep(4000); //Pause in milliseconds (1000 - 1 sec)
		driver.findElement(By.xpath("//*[@id=\"u_0_a\"]/div[1]/div[1]/div/a/span/span")).click();//span[@class='_1vp5 f_click']
		
		Thread.sleep(4000); //Pause in milliseconds (1000 - 1 sec)
		String friends = 
				driver.findElement(By.xpath("//span[text()='207']")).getText();
		System.out.println("You have " + friends + " friends");
		
		Thread.sleep(2000); //Pause in milliseconds (1000 - 1 sec)
		driver.findElement(By.xpath("//a[@aria-labelledby='userNavigationLabel']")).click();//By.id("userNavigationLabel")//div[text()='Account Settings
		Thread.sleep(2000); //Pause in milliseconds (1000 - 1 sec)
		driver.findElement(By.xpath(
				"//a[contains(@data-gt,'menu_logout')]")).click();
		Thread.sleep(2000);
		driver.quit();
	}
}
