package Maven.Sun_Advisor;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

public class POS {
	public static WebDriver driver;
	@Test
	public static void quota() throws InterruptedException {
		 System.setProperty("webdriver.chrome.driver", "C:\\Users\\ut1\\Downloads\\chromedriver-win64\\chromedriver.exe");
		  
		    WebDriver driver=new ChromeDriver();
		    
		    driver.get("https://www.pos.com.my/send/ratecalculator");
		    
		    driver.manage().timeouts().implicitlyWait(40,TimeUnit.SECONDS);
		    
		    driver.manage().window().maximize();
            
            JavascriptExecutor js = (JavascriptExecutor) driver;
            
            WebDriverWait wait = new WebDriverWait(driver,30);
            
            js.executeScript("window.scrollBy(30000,0)");
		    
            wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//div[text()='From']/following-sibling::div[2]/div/input[@placeholder='Postcode']")))).sendKeys("35600");
            
		    wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.xpath("//div[text()='To']/following-sibling::div/mat-select-country/mat-form-field/div/div/div[2]/input")))).clear();
		    
		    wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//div[text()='To']/following-sibling::div/mat-select-country/mat-form-field/div/div/div[2]/input")))).sendKeys("India");
            
		    wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.xpath("//div[@role='listbox']/mat-option/span/div/small[text()='India - IN']")))).click();
		    
		    wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.xpath("//div[text()='Weight (kg)']/following-sibling::div/div/input")))).click();
            
		    wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//div[text()='Weight (kg)']/following-sibling::div/div/input")))).sendKeys("1");
		    
		    wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.xpath("//a[text()=' Calculate ']")))).click();
		    
            Boolean e=driver.findElement(By.xpath("//h1[text()=' Your Quote ']/parent::div/following-sibling::div/dl/div/div/dt[text()='Service Type']")).isDisplayed();
		    if(!e) {System.out.println("shipment options not displayed");}
		   
		    
            driver.close();
		   
		    
	}
	
}
