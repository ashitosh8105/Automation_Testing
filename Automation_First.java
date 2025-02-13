package com.Basic;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
public class StartupProgram 
{
	public static void main(String[] args) throws InterruptedException {
		//open the chrome
		ChromeDriver driver=new ChromeDriver();
		//maximize the browser
		driver.manage().window().maximize();

		//enter the url
		driver.get("https://demowebshop.tricentis.com/");
		
		
	     //find the element using tag name
		
	
		Thread.sleep(2000);
		//close the browser
		driver.close();
	}

}
