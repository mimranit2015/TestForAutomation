package mypackage;

import java.util.concurrent.TimeUnit;
import lib.ExcelDataConf;

import org.apache.poi.ss.usermodel.Workbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

//import net.jodah.failsafe.internal.util.Assert;

public class MainTest {
    //public String baseUrl = "http://demo.guru99.com/test/newtours/";
	public String baseUrl = "https://www.etsy.com/";
    String driverPath = "C:\\Tools\\geckodriver.exe";
	//String driverPath = "C:\\Tools\\chromedriver.exe";
	
	public WebDriver driver ; 
     
 
  public void verifyHomepageTitle() {
       
      System.out.println("launching firefox browser"); 
      System.setProperty("webdriver.gecko.driver", driverPath);
      driver = new FirefoxDriver();
      driver.get(baseUrl);
      String expectedTitle = "Welcome: Mercury Tours";
      String actualTitle = driver.getTitle();
      //Assert.assertEquals(actualTitle, expectedTitle);
      driver.close();
  }
  
  
 @Test 
  public void ClickSignInVerifyRequiredFields()
  {
	 
	  try {
		  
	      System.setProperty("webdriver.gecko.driver", driverPath);
	      driver = new FirefoxDriver();
		  
		  //System.setProperty("webdriver.chrome.driver",driverPath);
		  
		  //driver = new ChromeDriver();
		  
	 
		  
	          
	      driver.manage().window().maximize();
	      driver.manage().deleteAllCookies();
	      driver.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS); // pageload timeout
	      driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
	
	      
	      driver.get(baseUrl);	  
	      
		  LoginPage loginpage = new LoginPage(driver);
		  
		  loginpage.ClickSignInButton();
		  loginpage.UnCheckStaySignedIn(driver);
		  Thread.sleep(500);
		  loginpage.ClickRegisterButton(driver);
		  Thread.sleep(500);
	      loginpage.ClickAccountRegisterButton(driver);
	      
	      
	      Assert.assertEquals(loginpage.ExpectedEmailRequiredMessage,loginpage.ActualEmailRequiredMessage.getText());
		  
		Thread.sleep(200);
	} catch (InterruptedException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
  }
  
  
  
 @Test
  public void CreateAccount()
  {
	 
	  try {
		  
	      System.setProperty("webdriver.gecko.driver", driverPath);
	      driver = new FirefoxDriver();
		  
		 // System.setProperty("webdriver.chrome.driver",driverPath);
		  
		 // driver = new ChromeDriver();
		  
	 
		  
	          
	      driver.manage().window().maximize();
	      driver.manage().deleteAllCookies();
	      driver.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS); // pageload timeout
	      driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
	
	      
	      driver.get(baseUrl);	  
	      
		  LoginPage loginpage = new LoginPage(driver);
		  
		  loginpage.ClickSignInButton();
		  loginpage.UnCheckStaySignedIn(driver);
		  Thread.sleep(500);
		  loginpage.ClickRegisterButton(driver);
		  Thread.sleep(500);
	      
		  loginpage.accountcreationgmail(driver);
		  
		Thread.sleep(200);
	} catch (InterruptedException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	  
	 
	  
	  
	  
  }
  
  @Test
  public void AccountLogin() throws Exception
  {
	  ExcelDataConf excel=new ExcelDataConf("C:\\WS\\MyAutomationTest\\src\\TestData.xlsx");
	  
	 // System.out.println(excel.getData(0, 0, 0));
	  
//	  System.setProperty("webdriver.chrome.driver",driverPath);
	  
//	  driver = new ChromeDriver();
	  
      System.setProperty("webdriver.gecko.driver", driverPath);
      driver = new FirefoxDriver();

	  
          
      driver.manage().window().maximize();
      driver.manage().deleteAllCookies();
      driver.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS); // pageload timeout
      driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);

      
      driver.get(baseUrl);	  
    	
	  LoginPage loginpage = new LoginPage(driver);
	  
	  loginpage.ClickSignInButton();
 
	  loginpage.UnCheckStaySignedIn(driver);
	  Thread.sleep(500); 
	  
	 // loginpage.ClickUserSignIn(driver);
	  
	  Thread.sleep(500);
	  
	  String username;
	  String password;

	  
	  for(int row=1; row<5; row++)
	  {
		  
		  System.out.println("Usermame is "+excel.getData(0, row, 0));
		  System.out.println("Password is "+excel.getData(0, row, 1));
		  
		  loginpage.setUserEmail(driver,excel.getData(0, row, 0) );
		  loginpage.setUserPassword(driver,excel.getData(0, row, 1) );
		  
		  loginpage.ClickUserSignIn(driver);
		  
		  Thread.sleep(200);
		  
		  Assert.assertEquals(loginpage.isWelcomeMessageDisplayed(driver), true, "User is unable to login");
		  
	  }  
	  
	  

}
	  
  
@Test
  public void ProductManagement() throws Exception
  {
	  ExcelDataConf excel=new ExcelDataConf("C:\\WS\\MyAutomationTest\\src\\TestData.xlsx");
	  
	 // System.out.println(excel.getData(0, 0, 0));
	  
      System.setProperty("webdriver.gecko.driver", driverPath);
      driver = new FirefoxDriver();
	  
      /*
	  System.setProperty("webdriver.chrome.driver",driverPath);
	  
	  driver = new ChromeDriver();
	  */
 
	  
          
      driver.manage().window().maximize();
      driver.manage().deleteAllCookies();
      driver.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS); // pageload timeout
      driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);

      
      driver.get(baseUrl);	  
    	
	  LoginPage loginpage = new LoginPage(driver);
	  
	  loginpage.ClickSignInButton();
 
	  loginpage.UnCheckStaySignedIn(driver);
	  Thread.sleep(500); 
	  
	 // loginpage.ClickUserSignIn(driver);
	  
	  Thread.sleep(500); 

	  Thread.sleep(500);
	  
	  String username;
	  String password;

	  
	  
		  
		  loginpage.setUserEmail(driver,excel.getData(0, 1, 0) );
		  loginpage.setUserPassword(driver,excel.getData(0, 1, 1) );
		  
		  loginpage.ClickUserSignIn(driver);
		  
		  
  
	  loginpage.SearchProduct(driver);
  
	  Assert.assertEquals(loginpage.ItemPresentActual.getText().toString(), loginpage.ExpectedEmailRequiredMessage,"Item not found in the basked");
  }	  
}