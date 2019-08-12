package testcases;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.Select;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.remote.MobileCapabilityType;

public class TestDropDowns {

public static AppiumDriver driver;
	
	public static void main(String[] args) throws MalformedURLException {
		
		DesiredCapabilities capabilities = new DesiredCapabilities();
		
		capabilities.setCapability(MobileCapabilityType.DEVICE_NAME, "iPhone 7 Plus");
		capabilities.setCapability(MobileCapabilityType.PLATFORM_NAME, "iOS");
		capabilities.setCapability(MobileCapabilityType.PLATFORM_VERSION, "12.1");
		capabilities.setCapability(MobileCapabilityType.BROWSER_NAME, "safari");

		
		driver = new AppiumDriver(new URL("http://127.0.0.1:4723/wd/hub"),capabilities);
		
		driver.manage().timeouts().implicitlyWait(15L, TimeUnit.SECONDS);
		
		driver.get("http://www.wikipedia.org");
		
		new Select(driver.findElement(By.id("searchLanguage"))).selectByValue("es");
		

		List<WebElement> values = driver.findElements(By.tagName("option"));
		
		
		System.out.println("Total values in dropdown are : "+values.size());
		
		for(WebElement element:values){
			
			System.out.println(element.getText());
			
		}
		
		System.out.println("------Printing total link from the page----------");
		
		WebElement block = driver.findElement(By.xpath("//*[@id=\"www-wikipedia-org\"]/div[6]/div[3]"));
		
		List<WebElement> links = block.findElements(By.tagName("a"));
		
		
		System.out.println("Total links are : "+links.size());
		
		for(WebElement element: links) {
			
			System.out.println(element.getText());
			
		}
		
	}

}
