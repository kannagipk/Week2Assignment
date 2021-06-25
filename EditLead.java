package week2.day1;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class EditLead {

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
		driver.findElementByXPath("(//*[@name='firstName'])[3]").sendKeys("Srividhya");
		Thread.sleep(2000);
		//Click Find leads button
		driver.findElementByXPath("//button[text()='Find Leads']").click();
		Thread.sleep(2000);
		driver.findElementByXPath("//table[@class='x-grid3-row-table']//td[1]/div/a").click();
		//verify title page
		
		String title = driver.getTitle();
		if(title.contains("View Lead | opentaps CRM")) {
			System.out.println("Welcome! You are in View Lead | opentaps CRM Page!");
		}
		//click edit
		driver.findElementByXPath("//a[@class='subMenuButton'][3]").click();
		Thread.sleep(2000);
		//Change the company name
		driver.findElementById("updateLeadForm_companyName").clear();
		driver.findElementById("updateLeadForm_companyName").sendKeys("HLT Updated");
		String company = driver.findElementById("updateLeadForm_companyName").getAttribute("value");
		driver.findElementByXPath("//input[@name='submitButton']").click();
		Thread.sleep(2000);
		//Confirm the changed name appears
		if(company.contains("HLT Updated")) {
			System.out.println("Company updated successfully!");
		}
		
		driver.close();
		
		
	}

}
