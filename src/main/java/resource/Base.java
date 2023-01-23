package resource;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.io.FileHandler;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Base {
	
	public WebDriver driver;
	public static Properties prop;
	
	public WebDriver initializeDriver() throws IOException
	{
		String browserName = getBrowserData("Browser");
		
		
		if(browserName.equalsIgnoreCase("chrome"))
	    {
		    WebDriverManager.chromedriver().setup();
		    driver = new ChromeDriver();
	    }
		
		else if(browserName.equalsIgnoreCase("firefox"))
		{
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
		}
		
		else if(browserName.equalsIgnoreCase("IE"))
		{
			WebDriverManager.iedriver().setup();
			driver = new InternetExplorerDriver();		
		}
		
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		return driver;
	}
	
	public static String getBrowserData(String value) throws IOException
	{
        prop = new Properties();
		
		String propPath = System.getProperty("user.dir")+"\\src\\main\\java\\resource\\browser.properties";
	
		FileInputStream file = new FileInputStream(propPath);
		
		prop.load(file);
		
		String data1 = prop.getProperty(value);
		
		return data1;
		
		
	}
	
	public String takeScreenShot(String testName, WebDriver driver) throws IOException
	{
		File source = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		String dest = System.getProperty("user.dir")+"\\screenshots\\"+testName+".png";
		FileUtils.copyFile(source, new File(dest));	
		return dest;
	}

}
