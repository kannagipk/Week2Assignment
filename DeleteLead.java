package week2.day1;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DeleteLead {

	public static void main(String[] args) throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		driver.get("http://leaftaps.com/opentaps/control/main");
		driver.manage().window().maximize();
		//Login
		driver.findElement(By.xpath("//input[@id='username']")).sendKeys("demosalesmanager");
		driver.findElement(By.xpath("//input[@id='password']")).sendKeys("crmsfa");
		driver.findElement(By.xpath("//input[@class='decorativeSubmit']")).click();
		driver.findElement(By.xpath("//a[contains(text(),'CRM/SFA')]")).click();
		
		// click Leads menu
		driver.findElement(By.xpath("//a[contains(text(),'Leads')]")).click();
		//Click Find leads
		driver.findElement(By.xpath("//a[contains(text(),'Find Leads')]")).click();
		
		//Click on Phone
		driver.findElementByXPath("(//em[@class='x-tab-left'])[2]").click();
		driver.findElementByXPath("//input[@name='phoneNumber']").sendKeys("99");
		driver.findElementByXPath("//button[text()='Find Leads']").click();
		Thread.sleep(2000);
		
		//Capture lead ID of First Resulting lead
		WebElement leadId = driver.findElementByXPath("//div[@class='x-grid3-cell-inner x-grid3-col-partyId']/a");
		String args1 = leadId.getText();
		driver.findElementByXPath("//div[@class='x-grid3-cell-inner x-grid3-col-partyId']/a").click();
		//Delete Lead
		driver.findElementByXPath("//a[@class='subMenuButtonDangerous']").click();
		//Click Find leads
		driver.findElement(By.xpath("//a[contains(text(),'Find Leads')]")).click();
		driver.findElementByXPath("//input[@name='id']").sendKeys(args1);
		driver.findElementByXPath("//button[text()='Find Leads']").click();
		Thread.sleep(2000);
		WebElement nodata = driver.findElementByXPath("//div[@class='x-paging-info']");
		String data = nodata.getText();
		if(data.contains("No records to display")) {
			System.out.println("Lead not found!");
			
		}
		driver.close();
	}

}
