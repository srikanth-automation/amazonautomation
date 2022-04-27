package hrmtest;

import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
//import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Amazonweb {

	WebDriver driver;

	@Test

	public void setup() {

		WebDriverManager.chromedriver().setup();
		System.setProperty("webdriver.chrome.driver", "D:\\Chrome Driver/chromedriver.exe");
		driver = new ChromeDriver();
		String url = "https://amazon.in";
		// driver.get(url);
		driver.manage().window().maximize();
		driver.get(url);
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS); // used implicit wait
	}

	@Test
	public void validateTitle() {
		String Expectedtitle = "Online Shopping site in India: Shop Online for Mobiles, Books, Watches, Shoes and More - Amazon.in";
		String aTitle = "";
		aTitle = driver.getTitle();
		System.out.println(aTitle);
		AssertJUnit.assertEquals(aTitle, Expectedtitle); // valdated title using assert
	}

	@Test
	public void validateandhandletooltip() throws InterruptedException {
		//driver.findElement(By.xpath("//div[@class='nav-flyout-buffer-top']")).click();
		//driver.findElement(By.xpath("//div[@class=nav-flyout-buffer-left']//parent::div//following-child::div[@class='nav-flyout-buffer-right']//siblling::div[@class='nav-flyout-buffer-top']")).click();
		//System.out.println("clicked on tooltip succesfully");
		Actions actions = new Actions(driver);
		WebElement etooltip=driver.findElement(By.xpath("//div[@id='nav-signin-tooltip']"));
		Thread.sleep(2000);
		actions.moveToElement(etooltip).perform();
		WebElement tooltip =driver.findElement(By.xpath("//span[@class='nav-action-inner']"));
		String actp=tooltip.getText();
		System.out.println(actp);
		String exetp="Sign in";
		AssertJUnit.assertEquals(actp, exetp);
		System.out.println(etooltip);
		

	}
}
