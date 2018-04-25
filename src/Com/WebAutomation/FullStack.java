package Com.WebAutomation;

import static org.testng.Assert.assertEquals;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Reporter;
import org.testng.annotations.Test;

import Generic.Baseclass;

public class FullStack extends Baseclass {
	@Test(priority =4)
	public  void TestCase() {
	
		 /*Click ON Sign In LInk*/ 
	driver.findElement(By.linkText("Sign in")).click();
	/*IN  page Create Account in Send Email Address */
	 driver.findElement(By.name("email_create")).sendKeys("capgemini.sogeti@gmail.com");
	 /*Click on Create an account */
	driver.findElement(By.name("SubmitCreate")).click();
	/* Fill YOUR  PERSONAL INFORMATION */
	driver.findElement(By.id("uniform-id_gender1")).click();
	driver.findElement(By.name("customer_firstname")).sendKeys("sumanth");
	driver.findElement(By.name("customer_lastname")).sendKeys("modadugu");
	driver.findElement(By.id("passwd")).sendKeys("password");
	//Select Date DropDown
 	WebElement Date =driver.findElement(By.name("days"));
				Select sel = new Select(Date);
				sel.selectByIndex(22);
 //Select Month DropDown
  WebElement Month =driver.findElement(By.name("months"));
				Select sel2 = new Select(Month);
				sel2.selectByIndex(11);
 //select YEAR DROPDOWN
   WebElement years =driver.findElement(By.name("years"));
				Select sel3 = new Select(years);
				sel3.selectByValue("1995");
	driver.findElement(By.name("newsletter")).click();
	driver.findElement(By.name("company")).sendKeys("capgemini");
	driver.findElement(By.id("address1")).sendKeys("airoli sez");
	driver.findElement(By.id("address2")).sendKeys("B1 Block 1st Floor ");
	driver.findElement(By.name("city")).sendKeys("Mumbai");
	WebElement State =driver.findElement(By.name("id_state"));
					Select sel4 = new Select(State);
					sel4.selectByVisibleText("New York");
	driver.findElement(By.id("postcode")).sendKeys("40078");	
	
	driver.findElement(By.id("other")).sendKeys("hello this IS High End Information ");
	driver.findElement(By.id("phone_mobile")).sendKeys("096543212");
	driver.findElement(By.name("alias")).sendKeys("yummyheloo   Area");
				
				
				
				
	}
	@Test(priority =3)
	public void BuyingProduct() throws InterruptedException {
	                  	/*Navigate to Women*/
		   WebElement women =driver.findElement(By.xpath("//a[@title='Women']")); 
		   Actions act =new Actions(driver);
		   act.moveToElement(women).perform();
		           /*Click on T-shirts*/
		   driver.findElement(By.linkText("T-shirts")).click();
		   Reporter.log("clicked on Women T-shirts");
		   /*Click on Faded Short Sleeve T-shirts Product*/
		   driver.findElement(By.linkText("Faded Short Sleeve T-shirts")).click();
		   /*Add PRoduct To Cart*/
		   driver.findElement(By.name("Submit")).click();
		   Reporter.log("Product added to cart sucessfulluy");
		   /*Click on Continue Shopping*/
		   while(true){
			  try{
		   driver.findElement(By.xpath("//span[@title='Continue shopping']")).click();
		   break;
		   }
		   catch(Throwable t){
		   }
		   }
		   /*Verify PRoduct in Cart  */
		  int product =Integer.parseInt(driver.findElement(By.xpath("//a[@title='View my shopping cart']/span")).getText());
		  int value =1;
		  assertEquals(product, value);
		   }
	
	
	@Test(priority =2)
	public void ProductResult(){
		
		/*Enter value in Search Box */
		driver.findElement(By.id("search_query_top")).sendKeys("printed summer Dress");
		driver.findElement(By.name("submit_search")).submit();
		Reporter.log("check for Result ");
		/*check for PRoducts Found */
		String ExpectedMsg = "3 results have been found.";        
	String actualMsg =	driver.findElement(By.xpath("//span[@class='heading-counter']")).getText();	
	assertEquals(actualMsg, ExpectedMsg);
		
}
	
	@Test(priority =1)
	public void VerifyLogo(){
		/*Check for Logo */
		Boolean imageLoaded = driver.findElement(By.id("header_logo")).isDisplayed();
		
		/*verify  Logo is displayed or Not*/
		
	if (imageLoaded) {
		Reporter.log("Logo displayed.");
		
		} 

		else {
		Reporter.log("Logo not displayed.");
		}
}
		
}









