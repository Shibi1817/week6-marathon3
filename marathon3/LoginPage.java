package marathon3;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;

import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterMethod;

public class LoginPage {
	
	public String fileName;
	public RemoteWebDriver driver;
	@Parameters({"browser","url","username","password"})
  
  @BeforeMethod
  public void beforeMethod(String browser,String url, String uname ,String pwd) {
		
		 ChromeOptions ch=new ChromeOptions();
	     ch.addArguments("--disable-notifications");
	     EdgeOptions ed=new EdgeOptions();
	     ed.addArguments("--disable-notifications");
		switch(browser) {
        case "chrome":
        {
            driver = new ChromeDriver(ch);
            break;
        }
        case "edge":
        {
            driver=new EdgeDriver(ed);
            break;
        }
        }	 
     
      driver.get(url);
      driver.manage().window().maximize();
      driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
      driver.findElement(By.id("username")).sendKeys(uname);
      driver.findElement(By.id("password")).sendKeys(pwd);
      driver.findElement(By.id("Login")).click();
     
	  
  }

  @AfterMethod
  public void afterMethod() {
	  driver.close();
  }

  @DataProvider(name="fetchData")
  public String[][] getData() throws IOException {
       String[][] readData = ReadExcel.readData(fileName);//ctrl+2+l    
      return readData;
}

 
}
