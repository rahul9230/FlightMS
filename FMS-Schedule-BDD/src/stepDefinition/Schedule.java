package stepDefinition;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class Schedule {

	WebDriver driver;
	
	@Given("^Admin is on login page$")
	public void admin_is_on_login_page() throws Throwable {
		System.setProperty("webdriver.chrome.driver","K:\\SeleniumCucumbersoftware\\chromedriver_win32\\chromedriver.exe" );
	    driver=new ChromeDriver();
	    driver.get("http://localhost:4200/login");
	    driver.manage().window().maximize();
	}

	@When("^Admin enters valid username and password$")
	public void admin_enters_valid_username_and_password() throws Throwable {
		driver.findElement(By.xpath("//input[@id='userPassword']")).sendKeys("Rahul1998");
		  driver.findElement(By.xpath("//input[@id='password']")).sendKeys("R@@@hul9");
	}

	@When("^Admin clicks on Login button$")
	public void admin_clicks_on_Login_button() throws Throwable {
		driver.findElement(By.xpath("//button[contains(text(),'Login')]")).click();	
		Thread.sleep(3000); 
		  driver.findElement(By.xpath("//button[contains(text(),'Login')]")).click();
	}

	@When("^Admin clicks Schedule a Flight$")
	public void admin_clicks_Schedule_a_Flight() throws Throwable {
		Thread.sleep(3000);
		driver.findElement(By.xpath("//button[contains(text(),'Schedule A Flight')]")).click();	
		Thread.sleep(3000);
		 
	}

	@When("^Admin fills all the details of Flight and Schedule$")
	public void admin_fills_all_the_details_of_Flight_and_Schedule() throws Throwable {
	   
	 driver.findElement(By.xpath("//body/app-root[1]/div[1]/div[1]/div[2]/app-add[1]/div[1]/form[1]/div[1]/input[1]")).sendKeys("101");
	  driver.findElement(By.xpath("//body/app-root[1]/div[1]/div[1]/div[2]/app-add[1]/div[1]/form[1]/div[2]/input[1]")).sendKeys("150");
	  driver.findElement(By.xpath(" //body/app-root[1]/div[1]/div[1]/div[2]/app-add[1]/div[1]/form[1]/div[3]/input[1]")).sendKeys("101");
	  driver.findElement(By.xpath(" //body/app-root[1]/div[1]/div[1]/div[2]/app-add[1]/div[1]/form[1]/div[4]/input[1]")).sendKeys("101");
	  driver.findElement(By.xpath(" //body/app-root[1]/div[1]/div[1]/div[2]/app-add[1]/div[1]/form[1]/div[5]/input[1]")).sendKeys("HYDE");
	  driver.findElement(By.xpath(" //body/app-root[1]/div[1]/div[1]/div[2]/app-add[1]/div[1]/form[1]/div[6]/input[1]")).sendKeys("MUMBAI");
	  driver.findElement(By.xpath(" //body/app-root[1]/div[1]/div[1]/div[2]/app-add[1]/div[1]/form[1]/div[7]/input[1]")).sendKeys("2020-12-11-10-30-20");
	  driver.findElement(By.xpath(" //body/app-root[1]/div[1]/div[1]/div[2]/app-add[1]/div[1]/form[1]/div[8]/input[1]")).sendKeys("2020-12-14-11-30-20");
	}

	@When("^Admin click on Add Schedule$")
	public void admin_click_on_Add_Schedule() throws Throwable {
		driver.findElement(By.xpath("//button[contains(text(),'Add')]")).click();
		Thread.sleep(1000);
		driver.switchTo().alert().accept();

	}

	@Then("^Admin is logged out\\.$")
	public void admin_is_logged_out() throws Throwable {
		driver.navigate().back();
		Thread.sleep(1000);
		driver.findElement(By.xpath("//button[@id='logout']")).click();
		Thread.sleep(1000);
		driver.switchTo().alert().accept(); 
		
		driver.close();
	}
	}



