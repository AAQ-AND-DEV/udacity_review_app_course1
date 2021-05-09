package com.aaqanddev.jwdnd.c1.review.seleniumpage;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SignupPage {
    @FindBy(name="firstName")
    private WebElement firstName;

    @FindBy(name="lastName")
    private WebElement lastName;

    @FindBy(name="username")
    private WebElement username;

    @FindBy(name="pw")
    private WebElement pw;

    @FindBy(id="submit-button")
    private WebElement submit;

    @FindBy(id="login-link")
    private WebElement loginLink;

    public SignupPage(WebDriver driver){
        PageFactory.initElements(driver, this);
    }

    public void setNames(String first, String last){
        firstName.sendKeys(first);
        lastName.sendKeys(last);
    }

    public void setUserAndPW(String user, String pw){
        username.sendKeys(user);
        this.pw.sendKeys(pw);
    }

    public void submitSignup(){
        submit.submit();
    }

    public void navToLogin(){
        loginLink.click();
    }
}
