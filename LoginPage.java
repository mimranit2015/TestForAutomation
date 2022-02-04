package mypackage;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import com.google.common.base.Verify;

import net.jodah.failsafe.internal.util.Assert;

public class LoginPage {

	
public WebElement SignInButton;
public WebElement StaySignedInCheckbox;
public WebElement RegisterButton;
public WebElement AccountRegisterButton;
public WebElement ActualEmailRequiredMessage;
public WebElement FirstNameRequiredMessage;
public WebElement PasswordRequiredMessage;
public WebElement Gmailoption;
public WebElement Email;
public WebElement Nextbutton;
public WebElement Password;
public WebElement UserSignIn;
public WebElement UserEmail;
public WebElement UserPassword;
public WebElement WelcomeMessage;
public WebElement SearchBox;
public WebElement SearchIcon;
public WebElement SearchResult;
public WebElement AddToBasket;
public WebElement BasketIcon;
public WebElement ItemPresentActual;
public WebElement ProductImage;
public WebElement ShopItembutton;

public String ExpectedEmailRequiredMessage = "Email can't be blank.11";
public String ItemPresentTextExpected = "1 item in your basket";
  
  public LoginPage(WebDriver driver) {
	// TODO Auto-generated constructor stub
	  
	  SignInButton = driver.findElement(By.cssSelector("#gnav-header-inner > div.wt-flex-shrink-xs-0 > nav > ul > li:nth-child(1) > button"));
	  
}


public void ClickSignInButton()
  {
	SignInButton.click();
  }

public void UnCheckStaySignedIn(WebDriver driver)
{

	  StaySignedInCheckbox = driver.findElement(By.xpath("//input[@name='persistent']"));
	
	
	  if(StaySignedInCheckbox.isSelected())
	  {	  
	  StaySignedInCheckbox.click();
	  }	
	
}	  
	  public void ClickRegisterButton(WebDriver driver)
	  {

		  RegisterButton = driver.findElement(By.cssSelector("#join-neu-form > div.wt-grid.wt-grid--block > div > div:nth-child(1) > div > button"));
	  	
		  RegisterButton.click();
	  
	  }

	  public void ClickAccountRegisterButton(WebDriver driver)
	  {

		AccountRegisterButton = driver.findElement(By.xpath("//*[@id='join-neu-form']/div[1]/div/div[7]/div/button"));
		  
		AccountRegisterButton.click();
		
		ActualEmailRequiredMessage = driver.findElement(By.cssSelector("div#aria-join_neu_email_field-error"));
		
		
	  }
	  
	 public void accountcreationgmail(WebDriver driver)
	 {
		 Gmailoption = driver.findElement(By.cssSelector("#join-neu-form > div.wt-display-flex-xs.wt-flex-direction-column-xs > div.wt-mb-xs-2 > div > button"));

		 Gmailoption.click();

	 
		 Email = driver.findElement(By.xpath("//input[type='email']"));
		 
		 Email.sendKeys("imran@gmail.com");
		 
		 Nextbutton = driver.findElement(By.cssSelector("#identifierNext > div > button > span"));
			
		 Nextbutton.click();

		 Password = driver.findElement(By.xpath("//input[type='password']"));
			
		 Nextbutton.click();
		 
		 
	 }
	  
	 
	 public void setUserEmail(WebDriver driver,String value)
	 {
		 
		 //UserEmail = driver.findElement(By.xpath("//button[@name='email']"));
		 
		 UserEmail = driver.findElement(By.cssSelector("#join_neu_email_field"));
		 UserEmail.sendKeys(value);
		
	 }
	 
	 public void setUserPassword(WebDriver driver,String value)
	 {
		 
		 //Password = driver.findElement(By.xpath("//button[@name='password']"));	
		 
		 Password = driver.findElement(By.cssSelector("#join_neu_password_field"));
		 Password.sendKeys(value);
	 }	 
	 

	 
	 public void ClickUserSignIn(WebDriver driver)
	 {

		 UserSignIn = driver.findElement(By.xpath("//button[@name='submit_attempt']"));
 		 
		 
		 UserSignIn.submit();
		 
		 
	 }
	 
	 public boolean isWelcomeMessageDisplayed(WebDriver driver)
	 {
		 WelcomeMessage = driver.findElement(By.cssSelector("h1.welcome-message-text"));
		 return WelcomeMessage.isDisplayed();
		 
	 }
	 
	 public void SearchProduct(WebDriver driver)
	 {
		 SearchBox = driver.findElement(By.xpath("//input[@id='global-enhancements-search-query']"));
		 
		 SearchBox.click();
		 
		 /*
		 ProductImage = driver.findElement(By.xpath("\r\n"
		 		+ "//*[@id=\"content\"]/div/div[2]/div/ul/li[1]/a/div[1]/div/img"));
		 
		 //ProductImage.click();
		 
		 //ShopItembutton.click();
		 */ 
		 
		 SearchBox.sendKeys("mask");
		 
		 SearchIcon = driver.findElement((By.cssSelector("\r\n"
		 		+ "#gnav-search > div > div.wt-input-btn-group.global-enhancements-search-input-btn-group.wt-menu__trigger.emphasized_search_bar.emphasized_search_bar_grey_bg > button > span")));
	 
	 SearchIcon.click();
	 
	 SearchResult = driver.findElement(By.cssSelector("#content > div > div.wt-bg-white.wt-grid__item-md-12.wt-pl-xs-1.wt-pr-xs-0.wt-pr-md-1.wt-pl-lg-0.wt-pr-lg-0.wt-bb-xs-1 > div > div.wt-mt-xs-3.wt-text-black > div.wt-grid.wt-pl-xs-0.wt-pr-xs-1.search-listings-group > div:nth-child(3) > div.wt-bg-white.wt-display-block.wt-pb-xs-2.wt-mt-xs-0 > div > div > div:nth-child(3) > ul > li:nth-child(1) > div > a > div.v2-listing-card__img.wt-position-relative > div > div > div > div > div > img"));
	 
	 SearchResult.click();
	 
	 AddToBasket = driver.findElement(By.xpath("//button[@class='wt-btn wt-btn--filled wt-width-full']"));
	 
	 AddToBasket.click();
	 
	 BasketIcon = driver.findElement(By.xpath("//*[@id='gnav-header-inner']/div[4]/nav/ul/li[4]/span/a/span[3]"));
	 
	 BasketIcon.click();
	 
	 ItemPresentActual = driver.findElement(By.cssSelector("#checkout > div.wt-pb-xs-4 > div > div > div:nth-child(1) > h1"));
	 
	 
	 
	 }
	 
}


