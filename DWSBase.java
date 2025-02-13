package com.crmBaseClass;

import java.io.IOException;
import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;

import com.crmFileUtility.ReadFromProperties;

public class DwsPageBase{
	public static WebDriver driver=null;
			
	@BeforeClass
	public void preCondition() throws IOException 
	{
		String browser=ReadFromProperties.getData("browser");
		
		String url=ReadFromProperties.getData("url");
		
		if(browser.equalsIgnoreCase("chrome"))
		{
			
			driver=new ChromeDriver();
		}
		else if(browser.equalsIgnoreCase("edge")) 
		{
			driver=new EdgeDriver();
		}
		else if(browser.equalsIgnoreCase("firefox"))
		{
			driver=new FirefoxDriver();
		}
		
		driver.manage().window().maximize();
		//waiting condition
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
		//enter URL
		driver.get("https://demowebshop.tricentis.com/");
	}
	
		@BeforeMethod
		public void login() throws IOException{
			
			String username=ReadFromProperties.getData("username");
			String password=ReadFromProperties.getData("password");
			
			driver.findElement(By.className("ico-login")).click();
			   driver.findElement(By.id("Email")).sendKeys(username);
			   driver.findElement(By.id("Password")).sendKeys(password);
			   driver.findElement(By.id("RememberMe")).click();
			   driver.findElement(By.xpath("/html/body/div[4]/div[1]/div[4]/div[2]/div/div[2]/div[1]/div[2]/div[2]/form/div[5]/input")).click();
			   
		}
		
		@AfterMethod
		public void logout(){
			driver.findElement(By.className("ico-logout")).click();
			System.out.println("Logout Successfully Done!!");
		   }
		
		@AfterClass
		public void close() {
			driver.close();
		}
		}
	
	

