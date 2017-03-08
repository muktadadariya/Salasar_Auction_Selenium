package salasartestngpackage;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class SalasarTestNGFile {
	public String baseURL = "http://salasarauction.com/";
	public WebDriver driver = new FirefoxDriver();
	final String username_xpath = "/html/body/div[1]/div[3]/div[1]/div/form/fieldset[1]/section[1]/div/div/label/input";
	final String password_xpath = "/html/body/div[1]/div[3]/div[1]/div/form/fieldset[1]/section[2]/div/div/label/input";
	final String login_xpath = "/html/body/div[1]/div[3]/div[1]/div/form/fieldset[1]/section[3]/div/div/input";
	final String home_xpath = "/html/body/section/section/section/aside/section/section/div/div[1]/nav/ul/li[1]/a/span";
	final String drop_xpath = "/html/body/section/header/ul[2]/li[2]/a";
	final String logout_xpath = "/html/body/section/header/ul[2]/li[2]/ul/li[6]/a";
	final String aboutus_xpath = "/html/body/div[1]/div[6]/div/div/div[3]/div[2]/ul/li[1]/a";
	final String verifyaboutus_xpath = "/html/body/div[1]/div[3]/ol/li[2]";
	final String contactus_xpath = "/html/body/div[1]/div[6]/div/div/div[3]/div[2]/ul/li[2]/a";
	final String verifycontactus_xpath = "/html/body/div[1]/div[3]/div/div[1]/form/h3";
	
	@BeforeTest
	public void launchBrowserone() {
		driver.get(baseURL);
	}
	
  @Test(priority = 0)
  public void verifyhomepagetitle() {
	  String expectedTitle = "Home -Salasar Auction: Buy,Sell,Bid Online, Bid Online";
	  String actualTitle = driver.getTitle();
	  Assert.assertEquals(actualTitle, expectedTitle);
  }
  
  @Test(priority = 1)
  public void clickbuyerlogin() {
	  driver.findElement(By.linkText("Buyer Login")).click();
  }
  
  @Test(priority = 2)
  public void buyerlogin() {
	WebElement usernameElement = driver.findElement(By.xpath(username_xpath));
	String username = "mukta";
	usernameElement.sendKeys(username);
	
	WebElement passwordElement = driver.findElement(By.xpath(password_xpath));
	String password = "mukta";
	passwordElement.sendKeys(password);
	
	WebElement loginElement = driver.findElement(By.xpath(login_xpath));
	loginElement.click();
  }
  
  @Test(priority = 3)
  public void waitforhomepage() { 
    driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
  }
  
  @Test(priority = 4)
  public void verifybuyerlogin() {
	  WebElement homeTab = driver.findElement(By.xpath(home_xpath));
	  Assert.assertEquals ("Home" , homeTab.getText()); 
  }
 
  @Test(priority = 5)
  public void logout() {
	  WebElement dropElement = driver.findElement(By.xpath(drop_xpath));
	  dropElement.click();
	 
	  WebElement logoutElement = driver.findElement(By.xpath(logout_xpath));
	  logoutElement.click();
  }
 
  @Test(priority = 6)
  public void waitforhomepageagain() { 
    driver.manage().timeouts().implicitlyWait(100, TimeUnit.SECONDS);
  }

  @Test(priority = 7)
  public void verifylogouttitle() {
	  String expectedTitle = "Home -Salasar Auction: Buy,Sell,Bid Online, Bid Online";
	  String actualTitle = driver.getTitle();
	  Assert.assertEquals(actualTitle, expectedTitle);
  }
  
  @Test(priority = 8)
  public void aboutus() {
	  WebElement aboutusElement = driver.findElement(By.xpath(aboutus_xpath));
	  aboutusElement.click();
  }

  @Test(priority = 9)
  public void waitforaboutus() { 
    driver.manage().timeouts().implicitlyWait(100, TimeUnit.SECONDS);
  }
  
  @Test(priority = 10)
  public void verifyaboutus() {
	  WebElement verifyaboutusTab = driver.findElement(By.xpath(verifyaboutus_xpath));
	  Assert.assertEquals ("About Us" ,verifyaboutusTab.getText());
  }
  
  @Test(priority = 11)
  public void launchBrowsertwo() {
		driver.get(baseURL);
	}
  
  @Test(priority = 12)
  public void contactus() {
	  WebElement contactusElement = driver.findElement(By.xpath(contactus_xpath));
	  contactusElement.click();
  }
  
  @Test(priority = 13)
  public void waitforcontactus() { 
    driver.manage().timeouts().implicitlyWait(100, TimeUnit.SECONDS);
  }
  
  @Test(priority = 14)
  public void verifycontactus() {
	  WebElement verifycontactusTab = driver.findElement(By.xpath(verifycontactus_xpath));
	  Assert.assertEquals ("Contact Us" ,verifycontactusTab.getText());
  }
  
  @AfterTest
  public void terminateBrowser() {
	  driver.quit();
  }
}
