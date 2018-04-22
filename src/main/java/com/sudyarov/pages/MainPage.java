package com.sudyarov.pages;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;
import ru.yandex.qatools.allure.annotations.Step;

public class MainPage {

    @FindBy(xpath = "//*[@id='root']/div[1]/div[3]/div[1]/div[1]/div/div/div/div/div[1]/button[1]") private SelenideElement loginFrame;
    @FindBy(xpath = "//input[@name = 'email']") private SelenideElement email;
    @FindBy(xpath = "//input[@name = 'password']") private SelenideElement password;
    @FindBy(xpath = "//button[@type = 'submit']") private SelenideElement loginButton;
    @FindBy(className = "SidebarProfile__UserEmail") private SelenideElement userEmail;
    @FindBy(className = "SidebarLogin__error") private SelenideElement failAuthorizationAlert;

    @Step("Set user email")
    public MainPage setEmail(String email) {
        loginFrame.click();
        this.email.setValue(email);
        return this;
    }

    @Step("Set password")
    public MainPage setPassword(String pass) {
        password.setValue(pass);
        return this;
    }

    @Step("Click login button")
    public MainPage clickLoginButton() {
        loginButton.click();
        return this;
    }

    @Step("Check success authorization")
    public MainPage checkSuccessAuthorization() {
        Assert.assertEquals(userEmail.getText(), "sudalium@gmail.com");
        return this;
    }

    @Step("Check failed authorization")
    public MainPage checkFailedAuthorization() {
        Assert.assertEquals(failAuthorizationAlert.getText(),
                "Invalid login or password");
        return this;
    }
}