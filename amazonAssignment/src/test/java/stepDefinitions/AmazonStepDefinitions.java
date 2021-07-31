package stepDefinitions;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
//import junit.framework.Assert;
import junit.framework.Assert;

public class AmazonStepDefinitions {

	public static WebDriver driver;
	public static String addedItem;
	//Background 
	
	@Given("user launch the browser")
	public void user_launch_the_browser() {
		
		System.setProperty("webdriver.chrome.driver", "D:/chromedriver.exe");
		driver = new ChromeDriver();
		
		
	}
	@Then("user enters  the amazon site")
	public void user_enters_the_amazon_site() {
		driver.manage().deleteAllCookies();
		driver.get("https://www.amazon.in/");
		driver.manage().window().maximize();
	}
	
	
	
	@Given("user clicks on todays deals")
	public void user_clicks_on_todays_deals() {
		
		driver.findElement(By.xpath("//a[normalize-space()='See all deals']")).click();
		System.out.println("Clicked Todays Deals");
		
	}
	@When("user clicks on third deal")
	public void user_clicks_on_third_deal() {
		
		driver.findElement(By.xpath("//div[@data-testid='shoveler-widget']/div/div/div/div[3]")).click();
		System.out.println("Clicked 3rd deal");
	}
	@Then("user select the deal")
	public void user_select_the_deal() {
		
		driver.findElement(By.xpath("//*[@id='octopus-dlp-asin-stream']/ul/li[1]")).click();
		System.out.println("Selected a deal");
		
	}
	
	public String getElement(String path) {
		return driver.findElement(By.xpath(path)).getText();
	}
	@Then("adds item to the cart")
	public void adds_item_to_the_cart() {
		
		
		addedItem=getElement("//*[@id='productTitle']");
		System.out.println("Item selected: "+addedItem);
		driver.findElement(By.xpath("//*[@id=\"add-to-cart-button\"]")).click();
		System.out.println("Added to the cart");
		

	}
	@Then("Item should be added to the cart")
	public void item_should_be_added_to_the_cart() {
		driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.findElement(By.xpath("//*[@id=\"attach-view-cart-button-form\"]")).click();
		System.out.println("Entered Cart");
		
		driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
		driver.navigate().refresh();
		
		
		WebDriverWait wait = new WebDriverWait(driver, 2000);
        WebElement CartItem = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//span[@class='a-truncate-cut']")));
        System.out.println("Cart Item: "+CartItem.getText());
       // WebElement CartItem = driver.findElement(By.xpath("//span[@class='a-truncate-cut']"));
		 Assert.assertEquals(addedItem, CartItem.getText());
	     
		
	}
	@Then("close the browser")
	public void close_the_browser() {
	   driver.quit();
	}
	
	@Given("user types Mobiles in search bar")
	public void user_types_mobiles_in_search_bar() {
	    
		driver.findElement(By.xpath("//*[@id=\"twotabsearchtextbox\"]")).sendKeys("Mobiles");
	}

	@When("user clicks to search")
	public void user_clicks_to_search() {
	    
		driver.findElement(By.xpath("//*[@id=\"nav-search-submit-button\"]")).click();
		
	}

	@Then("user selects the last displayed item")
	public void user_selects_the_last_displayed_item() {
//		
//		addedItem=driver.findElement(By.xpath("//*[@id=\"search\"]/div[1]/div/div[1]/div/span[3]/div[2]/div[21]/div/span/div/div/div[2]/div[1]/div/div/span/a/div/img"));
//		System.out.println(addedItem.getAttribute("alt"));
//		addedItem.click();
		
	}

	@Then("the last displayed item deatils should be displyed")
	public void the_last_displayed_item_deatils_should_be_displyed() {
		//WebElement item=driver.findElement(By.xpath("//*[@id=\"landingImage\"]"));
		//Assert.assertEquals(addedItem.getAttribute("alt"),item.getAttribute("alt"));
	}


}
