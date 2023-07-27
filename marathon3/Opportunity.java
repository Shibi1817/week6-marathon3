package marathon3;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Opportunity extends LoginPage {
	
	@BeforeTest
	public void setUp() {
		fileName="CreateOpportunity";
    }
	
	@Test(dataProvider = "fetchData")
	public void runOpportunity(String name,String amount) throws InterruptedException {
		
		driver.findElement(By.xpath("//div[contains(@class,'slds-icon-waffle')]")).click();
		driver.findElement(By.xpath("//button[text()='View All']")).click();
		driver.findElement(By.xpath("//p[text()='Sales']")).click();
		
		WebElement view = driver.findElement(By.xpath("//span[text()='View All Key Deals']"));
		Actions act=new Actions(driver);
		act.scrollToElement(view).perform();
		
		driver.executeScript("arguments[0].click();", view);
		
	
		driver.findElement(By.xpath("//div[text()='New']")).click();
		driver.findElement(By.xpath("//input[@name='Name']")).sendKeys(name);
		driver.findElement(By.xpath("(//div[contains(@class,'slds-combobox__form-element slds-input-has-icon slds-input-has-icon_right')])[3]")).click();
		Thread.sleep(5000);
		driver.findElement(By.xpath("//span[text()='New Customer']")).click();
		Thread.sleep(3000);
		WebElement leadSource = driver.findElement(By.xpath("(//div[contains(@class,'slds-combobox__form-element slds-input-has-icon slds-input-has-icon_right')])[4]"));
		driver.executeScript("arguments[0].click();", leadSource);
		Thread.sleep(5000);
		driver.findElement(By.xpath("//span[text()='Partner Referral']")).click();
		driver.findElement(By.xpath("//input[@name='Amount']")).sendKeys(amount);
		driver.findElement(By.xpath("//input[@name='CloseDate']")).click();
		driver.findElement(By.xpath("//table[contains(@class,'slds-datepicker__month')]//tr[5]/td[5]")).click();
		driver.findElement(By.xpath("(//div[contains(@class,'slds-combobox__form-element slds-input-has-icon slds-input-has-icon_right')])[2]")).click();
		Thread.sleep(5000);
		WebElement needsAnalysis = driver.findElement(By.xpath("//span[@title='Needs Analysis']"));
		driver.executeScript("arguments[0].click();", needsAnalysis);
		driver.findElement(By.xpath("//button[text()='Save']")).click();
		String toastMsg = driver.findElement(By.xpath("//span[contains(@class,'toastMessage slds-text-heading--small forceActionsText')]")).getText();
		System.out.println(toastMsg);
		if(toastMsg.contains(toastMsg)) {
			System.out.println("Opportunity is Created");
		}
		else {
			System.out.println("Not Created");
		}
		
	}

}
