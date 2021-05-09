package com.aaqanddev.jwdnd.c1.review;

import com.aaqanddev.jwdnd.c1.review.seleniumpage.ChatPage;
import com.aaqanddev.jwdnd.c1.review.seleniumpage.LoginPage;
import com.aaqanddev.jwdnd.c1.review.seleniumpage.SignupPage;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.web.server.LocalServerPort;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class ReviewApplicationTests {

	@LocalServerPort
	private int port;

	ChatPage chatPage;
	LoginPage loginPage;
	SignupPage signupPage;
	static WebDriver driver;

	//TODO could probably do login in beforeAll right?
	//but the username is required accessible in the chatPage test
	//also may be a problem if we haven't called driver.get, but maybe not
	@BeforeAll
	public static void beforeAll(){
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
	}

	@BeforeEach
	public void beforeEach(){
		driver.get("http://localhost:" + this.port + "/chat");
		//(way to init all three by passing driver to another method)
		//not really necessary
		chatPage = new ChatPage(driver);
		loginPage = new LoginPage(driver);
		signupPage = new SignupPage(driver);
	}

	@AfterAll
	public static void afterAll(){ driver.quit();}

	@Test
	void contextLoads() {
	}

	@Test
	public void testInputReadOutput(){
		//GIVEN /login page opened, nav to signup
		loginPage.navToSignup();
		String first = "Abe";
		String last = "Bubba";
		String username = "Abbubba";
		String pw = "butters";

		//wait for signup to load?
		WebDriverWait wait = new WebDriverWait(driver, 3);
		WebElement thing = wait.until(webDriver -> webDriver.findElement(By.id("firstName")));
		//set fields of signup
		signupPage.setNames(first, last);
		signupPage.setUserAndPW(username, pw);
		//submit form
		signupPage.submitSignup();
		//click link to login page
		signupPage.navToLogin();
		//wait for login to load
		WebDriverWait waitLogin = new WebDriverWait(driver, 3);
		WebElement thing2 = wait.until(webDriver -> webDriver.findElement(By.id("username")));
		//set username pw fields
		loginPage.setUsername(username);
		loginPage.setPw(pw);
		//submit login
		loginPage.submitLogin();
		// /Chat page generated
		String test = "testing";
		//WHEN populate messageText and submit form
		chatPage.setMessageText(test);
		chatPage.submitForm();

		//THEN: outputText contains string (formatted accding to toString of ChatMessage.java)
		assertEquals(username + ": " + test, chatPage.getOutput());

	}

}
