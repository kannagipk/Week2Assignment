package week2.day1;

import java.net.HttpURLConnection;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.Keys;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class LocatorsandInteractions {

	private static String text;

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		driver.get("http://leafground.com/pages/Edit.html");
		driver.manage().window().maximize();
		//Text Fields
		driver.findElement(By.xpath("//div[@class='wrapper-outer']/div[3]//input")).sendKeys("kannagipk@gmail.com");
		 
		driver.findElement(By.xpath("//label[contains(text(),'press keyboard tab')]/following::input")).sendKeys("Completed");
		 
		WebElement text = driver.findElement(By.xpath("//label[contains(text(),'Get default text entered')]/following::input"));
		String append = text.getAttribute("value"); 
		System.out.println("default text entered" + " "+append );
		
		driver.findElement(By.xpath("//div[@id='contentblock']//div[4]//input")).clear();
		
		WebElement isdisable = driver.findElement(By.xpath("//div[@id='contentblock']//div[5]//input"));
		boolean enabled = isdisable.isEnabled();
		if(enabled  == false) {
			System.out.println("Correct! Textbox is disabled!");
		}
		//Button
		driver.navigate().to("http://leafground.com/");
		driver.findElement(By.xpath("//div[@class='wp-landing-categories']//following::li[2]")).click();
		driver.findElement(By.xpath("//div[@id='contentblock']//following::div[2]/button")).click();
		driver.findElement(By.xpath("//div[@class='wp-landing-categories']//following::li[2]")).click();
		Point location = driver.findElement(By.xpath("//div[@id='contentblock']//div[1]/following::button")).getLocation();
		System.out.println(location);
		System.out.println("color of the button is" + " " +driver.findElement(By.xpath("//div[@id='contentblock']//div[2]/following::button")).getCssValue("background-color"));
		Dimension size = driver.findElement(By.xpath("//button[text()='What is my size?']")).getSize();
		System.out.println(size);
		//Hyperlink
		driver.navigate().back();
		driver.findElement(By.xpath("//h5[text()='HyperLink']/following::img")).click();
		driver.findElement(By.xpath("//div[@id='contentblock']//div/a")).click();
		driver.findElement(By.xpath("//h5[text()='HyperLink']/following::img")).click();
		WebElement wheretogo = driver.findElement(By.xpath("//div[@id='contentblock']//div/following::a"));
		String href = wheretogo.getAttribute("href");
		System.out.println("This link should redirect to the following "+ " "+href);
		
		String url = driver.findElement(By.xpath("//div[@id='contentblock']//div[2]/following::a")).getAttribute("href");
		try {
		URL link = new URL(url);
		// Create a connection using URL object (i.e., link)
		HttpURLConnection httpConn =(HttpURLConnection)link.openConnection();
		//Set the timeout for 2 seconds
		httpConn.setConnectTimeout(2000);
		//connect using connect method
		httpConn.connect();
		//use getResponseCode() to get the response code. 
			if(httpConn.getResponseCode()== 404) {	
				System.out.println("Following url is Broken"+url+" - "+httpConn.getResponseMessage());
			}
			
		}catch (Exception e) {
			//e.printStackTrace();
		}
		
		driver.findElement(By.xpath("//div[@id='contentblock']//following-sibling::div[4]//a")).click();
		driver.navigate().back();
		
		WebElement findhref = driver.findElement(By.xpath("//div[@id='contentblock']//following-sibling::div[5]//a"));
		String ref = findhref.getAttribute(href);
		if (ref == null)
		{
			System.out.println("Link dont have url" + " " + "value is" + " "+ ref);
		}else
		{
			System.out.println("Link has content"+" "+ ref);
		}
		
		driver.navigate().back();
		
		//image
		driver.findElement(By.xpath("//div[@id='content']//following::div[4]//li[4]")).click();
		driver.findElement(By.xpath("//div[@id='contentblock']//following-sibling::div//img")).click();
		driver.navigate().back();
		
		driver.findElement(By.xpath("//*[@id=\"contentblock\"]/section/div[3]/div/div/img")).click();
		
		driver.navigate().to("http://leafground.com/home.html");
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS) ;
 		//dropdown
		
		driver.findElement(By.xpath("//*[@id=\"post-153\"]/div[2]/div/ul/li[5]/a/img")).click();
		
		WebElement drpdwn1 = driver.findElement(By.xpath("//div[@id='contentblock']//div/select"));
		Select drp1 = new Select(drpdwn1);
		drp1.selectByIndex(1);
		
		WebElement drpdwn2 = driver.findElement(By.xpath("//div[@id='contentblock']//div[2]/select"));
		Select drp2 = new Select(drpdwn2);
		drp2.selectByVisibleText("UFT/QTP");
		
		WebElement drpdwn3 = driver.findElement(By.xpath("//div[@id='contentblock']//div[3]/select"));
		Select drp3 = new Select(drpdwn3);
		drp3.selectByValue("3");
		
		driver.findElement(By.xpath("//div[@id='contentblock']//div[5]/select")).sendKeys("Appium");
		
		WebElement drpdwn4 = driver.findElement(By.xpath("//div[@id='contentblock']//div[6]/select"));
		Select drp4 = new Select(drpdwn4);
		drp4.selectByValue("1");
		
		driver.navigate().back();
		
		//Radio Button
		
		driver.findElement(By.xpath("//div[@id='wrapper']//div[2]//following::div/div[2]/div/ul/li[6]")).click();
		driver.findElement(By.xpath("//div[@id='first']//input")).click();
		
		WebElement radio1 = driver.findElement(By.xpath("//div[@id='contentblock']//div[2]/div/div/label[2]/input"));
		WebElement radio2 = driver.findElement(By.xpath("//div[@id='contentblock']//div[2]/div/div/label[3]/input"));
		boolean selected1 = radio1.isSelected();
		boolean selected2 = radio2.isSelected();
		if(selected1 == true) {
			System.out.println("Radio button is selected"+ " "+ radio1.getAttribute("value"));
		}else if(selected2 == true){
			System.out.println("Radio button is selected"+ " "+ radio2.getAttribute("value"));
		}else {
			System.out.println("None of the Radio selected!");
		}
		
		WebElement r1 = driver.findElement(By.xpath("//div[@id='contentblock']//following-sibling::div[3]//input"));
		WebElement r2 = driver.findElement(By.xpath("//div[@id='contentblock']//following-sibling::div[3]//input[2]"));
		WebElement r3 = driver.findElement(By.xpath("//div[@id='contentblock']//following-sibling::div[3]//input[3]"));
		
		
		boolean age1 = r1.isSelected();
		
		
		if(age1 = true ) {
			System.out.println("This is  my age");
			
		}else {
			r1.click();
		}
		
		//Checkbox
		driver.navigate().back();
		driver.findElement(By.xpath("//h5[text()='Checkbox']/following::img")).click();
		driver.findElement(By.xpath(("//input[@type='checkbox']/following::input[2]"))).click();
		
		WebElement sel = driver.findElement(By.xpath("//div[@class='example']/following::div//input"));
		
		boolean selected = sel.isSelected();
		
		if(selected == true) {
			System.out.println("Yes check box selected");
		}else {
			System.out.println("Not selected! Checkbox");
		}
		
		WebElement deselect = driver.findElement(By.xpath("//div[@class='example']/following::div[5]//input"));
		boolean verify = deselect.isSelected();
		
		if(verify == true) {
			deselect.click();
			System.out.println("unselected the checkboc!");
		}
		
		WebElement multiselect = driver.findElement(By.xpath("//div[@class='example'][4]//input[1]"));
		
		String chk = multiselect.getAttribute("type");
		
		if(chk == "checkbox") {
			multiselect.click();
		}
	}

}
