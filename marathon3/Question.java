package marathon3;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Question extends LoginPage {
	
	@BeforeTest
	public void setUp() {
		fileName="CreateQuestion";
    }
	
	@Test(dataProvider = "fetchData")
	public void runQuestion(String question,String details) throws InterruptedException {
		
		driver.findElement(By.xpath("//div[contains(@class,'slds-icon-waffle')]")).click();
		driver.findElement(By.xpath("//button[text()='View All']")).click();
		driver.findElement(By.xpath("//input[@class='slds-input']")).sendKeys("content");
		driver.findElement(By.xpath("(//mark[text()='Content'])[1]")).click();
		//javascript to click
		WebElement chatter =driver.findElement(By.xpath("//span[text()='Chatter']"));
		driver.executeScript("arguments[0].click();", chatter);
		Thread.sleep(3000);
		String title = driver.getTitle();
		System.out.println(title);
		if(title.contains("Chatter Home | Salesforce")) {
			System.out.println("Title is Correct");
		}
		else {
			System.out.println("Incorrect Title");
		}
		driver.findElement(By.xpath("//span[text()='Question']")).click();
		driver.findElement(By.xpath("//textarea[contains(@class,'cuf-questionTitleField textarea')]")).sendKeys(question);
		driver.findElement(By.xpath("//div[contains(@class,'ql-editor ql-blank slds-rich-text-area__content slds-text-color_weak slds-grow')]")).sendKeys(details);
		driver.findElement(By.xpath("//button[contains(@title,'Click, or press Ctrl+Enter')]")).click();
		String text = driver.findElement(By.xpath("(//span[@class='uiOutputText'])[3]")).getText();
		if(text.contains(text)) {
			System.out.println("Question Appeared");
		}
		else {
			System.out.println("Not Appeared");
		}
		

	}

}
