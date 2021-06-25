package week2.day1;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class RedBus {

	public static void main(String[] args) throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		driver.get("https://www.redbus.in/");
		driver.manage().window().maximize();
		Thread.sleep(2000);
		//Type Chennai in From textBox and ENTER
		driver.findElementByXPath("//input[@id='src']").sendKeys("Chennai");
		Thread.sleep(2000);
		driver.findElementByXPath("//li[@select-id='results[0]']/i").click();
		
		driver.findElementByXPath("//input[@id='dest']").sendKeys("Bangalore");
		Thread.sleep(2000);
		driver.findElementByXPath("//li[@select-id='results[0]']/i").click();
		

		driver.findElementById("onward_cal").click();
		Thread.sleep(2000);

		driver.findElementByXPath("//*[@id='rb-calendar_onward_cal']/table/tbody/tr[7]/td[1]").click();
		Thread.sleep(2000);

		driver.findElementByXPath("//*[@id='search_btn']").click();
		Thread.sleep(4000);
		
		WebElement bustotal = driver.findElementByXPath("//div[@class='search']/div[2]/div[2]/div//div//span/span");
		String count = bustotal.getText();
		System.out.println("Total Bus Count is"+" " + count);
		//closing banners
		driver.findElementByXPath("//div[@class='close']/i").click();
		Thread.sleep(2000);
		//Acbuses
		driver.findElementByXPath("(//label[@class='custom-checkbox'])[6]").click();
		Thread.sleep(2000);
		WebElement acbustotal = driver.findElementByXPath("//div[@class='search']/div[2]/div[2]/div//div//span/span");
		String account = acbustotal.getText();
		System.out.println("Total Ac Bus Count is"+" " + account);
		//Before 6am bus count
		driver.findElementByXPath("(//label[@class='custom-checkbox'])[1]").click();
		Thread.sleep(2000);
		WebElement mornbustotal = driver.findElementByXPath("//div[@class='search']/div[2]/div[2]/div//div//span/span");
		String morncount = mornbustotal.getText();
		System.out.println("Total Ac Bus Count is"+" " + morncount);
		
		driver.close();
		

	}

}