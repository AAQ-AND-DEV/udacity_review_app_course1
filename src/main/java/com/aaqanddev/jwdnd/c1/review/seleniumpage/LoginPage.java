package com.aaqanddev.jwdnd.c1.review.seleniumpage;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {

    @FindBy(id="error-msg")
    private WebElement errorText;

    @FindBy(id="logout-msg")
    private WebElement loggedOutText;

    @FindBy(name="username")
    private WebElement usernameInput;

    @FindBy(name="password")
    private WebElement pwInput;

    @FindBy(id="submit-button")
    private WebElement submit;

    @FindBy(id="signup-link")
    private WebElement signupLink;

    public LoginPage(WebDriver driver){
        PageFactory.initElements(driver, this);
    }

    public void setUsername(String username){
        usernameInput.sendKeys(username);
    }

    public void setPw(String password){
        pwInput.sendKeys(password);
    }

    public void submitLogin(){
        submit.click();
    }

    public String getErrorText(){
        return errorText.getText();
    }

    public String getLogoutMsg(){
        return loggedOutText.getText();
    }

    public void navToSignup(){
        signupLink.click();
    }
}
