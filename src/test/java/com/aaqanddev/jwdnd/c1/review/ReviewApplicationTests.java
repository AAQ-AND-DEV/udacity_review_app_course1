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
import org.springframework.security.test.context.support.WithMockUser;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class ReviewApplicationTests {

	//making port static doesn't work
	@LocalServerPort
	private int port;

	static ChatPage chatPage;
	static LoginPage loginPage;
	static SignupPage signupPage;
	static WebDriver driver;

	private static String first = "Abe";
	private static String last = "Bubba";
	private static String username = "Abbubba";
	private static String pw = "butters";

	//TODO could probably do login in beforeAll right?
	//but the username is required accessible in the chatPage test
	//also may be a problem if we haven't called driver.get, but maybe not
	//cant seem to access port from static beforeAll() method,
	// when made port static, didn't populate with a port
	@BeforeAll
	static void beforeAll(){
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
	}

	@BeforeEach
	public void beforeEach(){
		//(way to init all three by passing driver to another method)
		//not really necessary
		chatPage = new ChatPage(driver);
		System.out.println("port:" + this.port);
		driver.get("http://localhost:" + this.port + "/signup");
		signupPage = new SignupPage(driver);
		//wait for signup to load?
		WebDriverWait wait = new WebDriverWait(driver, 3);
		WebElement thing = wait.until(webDriver -> webDriver.findElement(By.id("inputFirstName")));
		//set fields of signup
		signupPage.setNames(first, last);
		signupPage.setUserAndPW(username, pw);
		//submit form
		signupPage.submitSignup();
		//click link to login page
		signupPage.navToLogin();
		//wait for login to load
		loginPage = new LoginPage(driver);
		WebDriverWait waitLogin = new WebDriverWait(driver, 3);
		WebElement thing2 = wait.until(webDriver -> webDriver.findElement(By.id("inputUsername")));
		//set username pw fields
		loginPage.setUsername(username);
		loginPage.setPw(pw);
		//submit login
		loginPage.submitLogin();
	}

	@AfterAll
	public static void afterAll(){
		driver.quit();
	}

//	@Test
//	void contextLoads() {
//	}

	@Test
	public void testInputReadOutput(){
		//GIVEN /login page opened, nav to signup
		//loginPage.navToSignup();
		driver.get("http://localhost:" + port + "/chat");
		// /Chat page generated after BeforeEach (i think)
		String test = "testing";
		//await chat page load
		// looks like the submitLogin function is not resulting in a load of defaultSuccessUrl
		WebDriverWait waitChat = new WebDriverWait(driver, 3);
		WebElement thing3 = waitChat.until(webDriver -> webDriver.findElement(By.id("messageText")));
		//WHEN populate messageText and submit form
		chatPage.setMessageText(test);
		chatPage.submitForm();

		//THEN: outputText contains string (formatted accding to toString of ChatMessage.java)
		assertEquals(username + ": " + test, chatPage.getOutput());

	}

	//@WithMockUser

}
