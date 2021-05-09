package com.aaqanddev.jwdnd.c1.review.seleniumpage;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ChatPage {

    @FindBy(id="messageText")
    private WebElement textInput;

    @FindBy(id="messageType")
    private WebElement typeSelect;

    //will only work because only one form on page
    @FindBy(tagName="form")
    private WebElement form;

    @FindBy(id="outputText")
    private WebElement output;

    public ChatPage(WebDriver driver){
        PageFactory.initElements(driver, this);
    }

    public void setMessageText(String text){
        textInput.sendKeys(text);
    }

    public void setMessageType(String type){
        typeSelect.sendKeys(type);
    }

    public void submitForm(){
        form.submit();
    }

    public String getOutput(){
        return output.getText();
    }
}
