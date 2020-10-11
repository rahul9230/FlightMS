package stepDefinition;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class LoginVerify {

	
	WebDriver driver;
	@Given("^Admin is on login page$")
	public void admin_is_on_login_page() throws Throwable {
		System.setProperty("webdriver.chrome.driver", "K:\\SeleniumCucumberSoftware\\chromedriver_win32\\chromedriver.exe");
		driver=new ChromeDriver();
		driver.get("http://demowebshop.tricentis.com/Register");
		driver.manage().window().maximize();
	}

	@When("^Admin enters valid username and password$")
	public void admin_enters_valid_username_and_password() throws Throwable {
	    
	}

	@When("^Admin clicks on Login button$")
	public void admin_clicks_on_Login_button() throws Throwable {
	   
	}

	@Then("^Admin should be able to see Scheduling Page\\.$")
	public void admin_should_be_able_to_see_Scheduling_Page() throws Throwable {
	    
	}

}




//
//@When("^User enters valid personal details$")
//public void user_enters_valid_personal_details() throws Throwable {
//	driver.findElement(By.xpath("//input[@name='Gender' and @value='M']")).click();
//	driver.findElement(By.id("FirstName")).sendKeys("Rahul");
//	driver.findElement(By.id("LastName")).sendKeys("Kasturi");
//	driver.findElement(By.id("Email")).sendKeys("rahulkasturi92300@gmail.com");
//}
//
//@When("^User enters password$")
//public void user_enters_password() throws Throwable {
//	driver.findElement(By.name("Password")).sendKeys("Rahul9");
//	
//}
//
//@When("^user enters Confirm password$")
//public void user_enters_Confirm_password() throws Throwable {
//	driver.findElement(By.name("ConfirmPassword")).sendKeys("Rahul9");
//}
//
//@Then("^User should be able to see Registration Successful\\.$")
//public void user_should_be_able_to_see_Registration_Successful() throws Throwable {
//	driver.findElement(By.xpath("//input[@id='register-button']")).click();
//}
