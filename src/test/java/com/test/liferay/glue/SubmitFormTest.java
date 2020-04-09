package com.test.liferay.glue;

import static org.junit.Assert.assertThat;

import java.util.concurrent.TimeUnit;


import org.hamcrest.CoreMatchers;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


import cucumber.api.java.After;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class SubmitFormTest {

	public static WebDriver driver;
	
	@Given("^user is on page$")
	public void user_is_on_page() throws Throwable {
		System.setProperty("webdrive.gecko.drive", "/usr/local/bin");
		driver = new FirefoxDriver();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("https://forms.liferay.com/web/forms/shared/-/form/122548");
	}
	
	@Given("^party rock text is visible$")
	public void party_rock_text_is_visible() throws Throwable {
		WebElement partyRock = driver.findElement(By.cssSelector(".lfr-ddm-form-page-description"));
		assertThat(partyRock.getText(), CoreMatchers.containsString("party rock"));
	}
	
	@When("^name field filled in by the user with only letters$")
	public void name_field_filled_in_by_the_user_with_only_letters() throws Throwable {
		WebElement name = driver.findElement(By.cssSelector("input.ddm-field-text"));
		if(name.isDisplayed()) {
			name.clear();
			name.sendKeys("test");
			name.click();
			name.click();
		}
	}
	
	@When("^name field filled in by the user with only numbers$")
	public void name_field_filled_in_by_the_user_with_only_numbers() throws Throwable {
		WebElement name = driver.findElement(By.cssSelector("input.ddm-field-text"));
		if(name.isDisplayed()) {
			name.clear();
			name.sendKeys("12345");
			name.click();
			name.click();
		}
	}
	
	@When("^name field filled in by the user with only special characters$")
	public void name_field_filled_in_by_the_user_with_only_special_characters() throws Throwable {
		WebElement name = driver.findElement(By.cssSelector("input.ddm-field-text"));
		if(name.isDisplayed()) {
			name.clear();
			name.sendKeys("*%#@?");
			name.click();
			name.click();
		}
	}

	@When("^why test field filled in by the user with only letters$")
	public void why_field_filled_in_by_the_user_with_only_letters() throws Throwable {
		WebElement whyTest = driver.findElement(By.cssSelector("textarea.ddm-field-text"));
		if(whyTest.isDisplayed()) {
			whyTest.click();
			whyTest.clear();
			whyTest.sendKeys("test");
			whyTest.click();
			whyTest.click();
		}
	}
	
	@When("^why field filled in by the user with only numbers$")
	public void why_field_filled_in_by_the_user_with_only_numbers() throws Throwable {
		WebElement whyTest = driver.findElement(By.cssSelector("textarea.ddm-field-text"));
		if(whyTest.isDisplayed()) {
			whyTest.click();
			whyTest.clear();
			whyTest.sendKeys("12345");
			whyTest.click();
			whyTest.click();
		}
	}
	
	@When("^why field filled in by the user with only special characters$")
	public void why_field_filled_in_by_the_user_with_only_special_characters() throws Throwable {
		WebElement whyTest = driver.findElement(By.cssSelector("textarea.ddm-field-text"));
		if(whyTest.isDisplayed()) {
			whyTest.click();
			whyTest.clear();
			whyTest.sendKeys("*%#@?");
			whyTest.click();
			whyTest.click();
		}
	}

	@When("^birthday field filled in by the user with valid date$")
	public void birthday_field_filled_in_by_the_user_with_valid_date() throws Throwable {
		WebElement birthday = driver.findElement(By.cssSelector(".input-group-inset"));
		if(birthday.isDisplayed()) {
			birthday.click();
			birthday.clear();
			birthday.sendKeys("09051992");
			birthday.click();
			birthday.click();
		}
	}
	
	@When("^birthday field filled in by the user with future date$")
	public void birthday_field_filled_in_by_the_user_with_future_date() throws Throwable {
		WebElement birthday = driver.findElement(By.cssSelector(".input-group-inset"));
		if(birthday.isDisplayed()) {
			birthday.click();
			birthday.clear();
			birthday.sendKeys("09052020");
			birthday.click();
			birthday.click();
		}
	}
	
	@When("^birthday field filled in by the user with nineteenth century date$")
	public void birthday_field_filled_in_by_the_user_with_nineteenth_century_date() throws Throwable {
		WebElement birthday = driver.findElement(By.cssSelector(".input-group-inset"));
		if(birthday.isDisplayed()) {
			birthday.click();
			birthday.clear();
			birthday.sendKeys("09051800");
			birthday.click();
			birthday.click();
		}
	}
	

	@When("^press submit button$")
	public void press_submit_button() throws Throwable {
	    WebElement submitButton = driver.findElement(By.cssSelector(".btn-primary"));
	    submitButton.click();
	    if(submitButton.isDisplayed()) {
	    	submitButton.click();
	    }
	    
	}
	
	@Then("^success message is displayed$")
	public void sucess_message_is_displayed() throws Throwable {
		WebDriverWait wait = new WebDriverWait(driver, 5);
		wait.until(ExpectedConditions.presenceOfElementLocated
				(By.xpath("/html/body/div[1]/div[1]/div/div/div/div/div/div/div/h1")));
		String expMessage = "Information sent successfully!";
		WebElement message = driver.findElement(By.cssSelector(".ddm-form-description"));
		String actual = message.getText();
        Assert.assertEquals(expMessage, actual);
        
	}
	
	@Then("^Required field message is displayed to why field$")
	public void required_field_message_is_displayed_to_why_field() throws Throwable {
		String requiredLocation = "/html/body/div[1]/div/div/div/div/div/div/form"
				+ "/div[3]/div/div/div/div[1]/div/div/div[2]/div/div/div/div"; 
		WebDriverWait wait = new WebDriverWait(driver, 2);
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(requiredLocation)));
		
		WebElement message = driver.findElement(By.xpath(requiredLocation));
		String expMessage = "This field is required.";
		Assert.assertEquals(expMessage, message.getText());
		
	}
	
	@Then("^Required field message is displayed to birthday field$")
	public void required_field_message_is_displayed_to_birthday_field() throws Throwable {
		String requiredLocation = ".col-md-5 > div:nth-child(1) > div:nth-child(3) > div:nth-child(1)";
		WebDriverWait wait = new WebDriverWait(driver, 2);
		wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector(requiredLocation)));
		WebElement message = driver.findElement(
				By.cssSelector(requiredLocation));
		String expMessage = "This field is required.";
		Assert.assertEquals(expMessage, message.getText());
		
	}
	
	@Then("^Required field message is displayed to name field$")
	public void required_field_message_is_displayed_to_name_field() throws Throwable {
		String requiredLocation = "/html/body/div[1]/div/div/div/div/div/div/"
				+ "form/div[3]/div/div/div/div[1]/div/div/div[1]/div[1]/div/div/div"; 
		WebDriverWait wait = new WebDriverWait(driver, 2);
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(requiredLocation)));
		
		WebElement message = driver.findElement(By.xpath(requiredLocation));
		String expMessage = "This field is required.";
		Assert.assertEquals(expMessage, message.getText());
		
	}
	@After
	public void exitTest() {
		driver.quit();
	}
}
