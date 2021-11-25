package com.vtiger.stepdefinitions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;

import com.vtiger.pages.HomePage;
import com.vtiger.pages.LoginPage;

import io.github.bonigarcia.wdm.WebDriverManager;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
//import io.github.bonigarcia.wdm.WebDriverManager;

public class Loginstepdefinitions extends BaseTest {
	public LoginPage lp;
	public HomePage hp;
	
	
	@Given("^user navigate to url \"([^\"]*)\" on chrome$")
	public void user_navigate_to_url_on_chrome(String url) throws Throwable {
		launchApp();
		logger=extent.createTest("Login Feature");
		lp=new LoginPage(driver,logger);
		hp=new HomePage(driver,logger);
	}

	@Then("^Login page should be appear$")
	public void login_page_should_be_appear() throws Throwable {
		lp.verifyloginpage();
	}

	@When("^user enters valid username and password$")
	public void user_enters_valid_username_and_password() throws Throwable {
		lp.login("admin", "admin");
	}
	@When("^user enters invalid username and password$")
	public void user_enters_invalid_username_and_password() throws Throwable {
		lp.verifyInValidlogin("admin1", "admin1");
	}   
    
	@When("user enters invalid userid as {string} and password as {string}")
	public void user_enters_invalid_userid_as_and_password_as(String string, String string2) {
	    lp.login(string, string2);   
	}

	
	@When("^click on the login button$")
	public void click_on_the_login_button() throws Throwable {
		lp.clickLogin();
	}

	@Then("^user should be landed on homepage$")
	public void user_should_be_landed_on_homepage() throws Throwable {
		hp.verifyHomeTab();
	}

	@Then("^Logout link should be appear$")
	public void logout_link_should_be_appear() throws Throwable {
		hp.clickLogout();
	}
    
	@Then("^error msg should be appear$")
	public void error_msg_should_be_appear() throws Throwable {
		lp.verifyerrorMsg();
	}
	@Then("^close the browser$")
	public void close_browser() throws Throwable {
		extent.flush();
		driver.quit();
		
	}


}
