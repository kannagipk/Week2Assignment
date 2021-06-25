package week2.day1;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class CreateLead {

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		driver.get("http://leaftaps.com/opentaps/control/main");
		driver.manage().window().maximize();
		driver.findElement(By.id("username")).sendKeys("demosalesmanager");
		driver.findElement(By.id("password")).sendKeys("crmsfa");
		driver.findElementByClassName("decorativeSubmit").click();
		driver.findElement(By.linkText("CRM/SFA")).click();
		driver.findElementByLinkText("Leads").click();
		driver.findElementByLinkText("Create Lead").click();
		driver.findElement(By.id("createLeadForm_companyName")).sendKeys("ABc Group");
		driver.findElement(By.id("createLeadForm_firstName")).sendKeys("Kannagi");
		driver.findElement(By.id("createLeadForm_lastName")).sendKeys("PK");
		driver.findElementByClassName("smallSubmit").click();
		String title = driver.getTitle();
		System.out.println(title);
		driver.close();
	}

}
